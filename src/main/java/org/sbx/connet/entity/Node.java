package org.sbx.connet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "nodes")
@NamedQueries({
        @NamedQuery(name = "Node.getAllNodes", query = "SELECT n FROM Node n")
})
public class Node implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private long nodeId;

    @Column(name = "node_name")
    private String nodeName;

    private String region;
    private String street;
    private String building;

    @OneToMany(mappedBy = "node", fetch = FetchType.LAZY)
    private List<ConnectionUnit> connectors;

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCapacity() {
        int capacity = 0;
        for (ConnectionUnit cu: connectors) {
            capacity += cu.getCapacity();
        }
        return capacity;
    }

    public int getFreePool() {

        int freePool = getCapacity();
        for (ConnectionUnit cu: connectors) {
            for (Point p: cu.getPoints()) {
                if (p.getLinkedPoint() != null) {
                    freePool--;
                }
            }
        }

        return freePool;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return nodeId == node.nodeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId);
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + nodeId +
                ", nodeName='" + nodeName + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
