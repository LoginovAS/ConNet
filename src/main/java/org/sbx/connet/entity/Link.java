package org.sbx.connet.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "links")
public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private long linkId;

    @ManyToOne
    @JoinColumn(name = "point_id_1", referencedColumnName = "point_id")
    private Point point1;

    @ManyToOne
    @JoinColumn(name = "point_id_2", referencedColumnName = "point_id")
    private Point point2;

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}
