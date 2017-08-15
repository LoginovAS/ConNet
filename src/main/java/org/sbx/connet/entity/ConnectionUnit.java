package org.sbx.connet.entity;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "connection_units")
public class ConnectionUnit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cu_id")
    private long cuId;

    @Column(name = "cu_name")
    private String cuName;

    @JoinTable(name = "node_cu", joinColumns = { @JoinColumn(name = "cu_id", referencedColumnName = "cu_id") },
                                 inverseJoinColumns = { @JoinColumn(name = "node_id", referencedColumnName = "node_id") }
    )
    @ManyToOne
    private Node node;

    @OneToMany(mappedBy = "cu", fetch = FetchType.LAZY)
    private List<Point> points;

    transient private int capacity;

    public long getCuId() {
        return cuId;
    }

    public void setCuId(long cuId) {
        this.cuId = cuId;
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName;
    }

    public int getCapacity() {
        return points.size();
    }

    @PostConstruct
    private void init() {
        if (points != null && !points.isEmpty()) {
            capacity = points.size();
        } else {
            capacity = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConnectionUnit)) return false;
        ConnectionUnit that = (ConnectionUnit) o;
        return cuId == that.cuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuId);
    }

    @Override
    public String toString() {
        return "ConnectionUnit{" +
                "cuId=" + cuId +
                ", cuName='" + cuName + '\'' +
                '}';
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
