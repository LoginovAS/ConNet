package org.sbx.connet.entity;

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

    private int capacity;

    @JoinTable(name = "node_cu", joinColumns = { @JoinColumn(name = "node_id", referencedColumnName = "node_id") },
                                 inverseJoinColumns = { @JoinColumn(name = "cu_id", referencedColumnName = "cu_id") }
    )
    @ManyToOne
    private Node node;

    @OneToMany(mappedBy = "cu", fetch = FetchType.LAZY)
    private List<Point> points;

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
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
                ", capacity=" + capacity +
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
}