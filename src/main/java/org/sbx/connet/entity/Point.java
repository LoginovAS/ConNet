package org.sbx.connet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private long pointId;

    @Column(name = "cu_id")
    private long cuId;

    @Column(name = "point_number")
    private int pointNumber;

    @JoinTable(name = "cu_point", joinColumns = { @JoinColumn(name = "point_id", referencedColumnName = "point_id") },
                                  inverseJoinColumns = { @JoinColumn(name = "cu_id", referencedColumnName = "cu_id") })
    @ManyToOne
    private ConnectionUnit cu;

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public long getCuId() {
        return cuId;
    }

    public void setCuId(long cuId) {
        this.cuId = cuId;
    }

    public int getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(int pointNumber) {
        this.pointNumber = pointNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return pointId == point.pointId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointId);
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointId=" + pointId +
                ", cuId=" + cuId +
                ", pointNumber=" + pointNumber +
                '}';
    }
}
