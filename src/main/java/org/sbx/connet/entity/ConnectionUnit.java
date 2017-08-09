package org.sbx.connet.entity;

import javax.persistence.*;
import java.io.Serializable;
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

    @JoinColumn(name = "node_id", referencedColumnName = "node_id")
    @ManyToOne
    private Node node;

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
}
