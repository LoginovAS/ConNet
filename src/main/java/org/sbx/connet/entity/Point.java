package org.sbx.connet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "points")
@NamedQueries({
    @NamedQuery(name = "Point.getPointsByCu",
                query = "SELECT p FROM Point p WHERE p.cu = :cu"),
    @NamedQuery(name = "Point.getAllPoints",
                query = "SELECT p FROM Point p")
})
public class Point implements Serializable {

    @Override
    public String toString() {
        return cu.getCuName() +
                "_" + pointNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private long pointId;

    @Column(name = "point_number")
    private int pointNumber;

    @JoinTable(name = "cu_point", joinColumns = { @JoinColumn(name = "point_id", referencedColumnName = "point_id") },
                                  inverseJoinColumns = { @JoinColumn(name = "cu_id", referencedColumnName = "cu_id") })
    @ManyToOne
    private ConnectionUnit cu;

    @OneToOne
    @JoinTable(name = "links", joinColumns = { @JoinColumn(name = "point_id_1", referencedColumnName = "point_id") },
                                inverseJoinColumns = { @JoinColumn(name = "point_id_2", referencedColumnName = "point_id") })
    private Point linkedPoint;

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
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

    public Point getLinkedPoint() {
        return linkedPoint;
    }

    public void setLinkedPoint(Point linkedPoint) {
        this.linkedPoint = linkedPoint;
    }

    /**
     * @return the cu
     */
    public ConnectionUnit getCu() {
        return cu;
    }

    /**
     * @param cu the cu to set
     */
    public void setCu(ConnectionUnit cu) {
        this.cu = cu;
    }
}
