package org.sbx.connet.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private long linkId;

    @Column(name = "cu_id1")
    private long cuId1;

    @Column(name = "cu_id2")
    private long cuId2;

    @Column(name = "point_number_1")
    private int pointNumber1;

    @Column(name = "point_number_2")
    private int pointNumber2;

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public long getCuId1() {
        return cuId1;
    }

    public void setCuId1(long cuId1) {
        this.cuId1 = cuId1;
    }

    public long getCuId2() {
        return cuId2;
    }

    public void setCuId2(long cuId2) {
        this.cuId2 = cuId2;
    }

    public int getPointNumber1() {
        return pointNumber1;
    }

    public void setPointNumber1(int pointNumber1) {
        this.pointNumber1 = pointNumber1;
    }

    public int getPointNumber2() {
        return pointNumber2;
    }

    public void setPointNumber2(int pointNumber2) {
        this.pointNumber2 = pointNumber2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return linkId == link.linkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId);
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", cuId1=" + cuId1 +
                ", cuId2=" + cuId2 +
                ", pointNumber1=" + pointNumber1 +
                ", pointNumber2=" + pointNumber2 +
                '}';
    }
}
