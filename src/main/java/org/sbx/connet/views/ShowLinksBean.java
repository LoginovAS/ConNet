/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbx.connet.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.sbx.connet.entity.ConnectionUnit;
import org.sbx.connet.entity.Node;
import org.sbx.connet.entity.Point;

@Named
@Dependent
public class ShowLinksBean implements Serializable{
    
    private List<Point> nodePoints;
    
    private List<Point> remotePoints;
    
    private List<Node> remoteNodes;
    
    
    
    @PostConstruct
    private void init() {
        nodePoints = new ArrayList<>();
        remoteNodes = new ArrayList<>();
        remotePoints = new ArrayList<>();
    }
    
    public void clear() {
        nodePoints.clear();
        remoteNodes.clear();
        remotePoints.clear();
    }
    
    public void loadValues(Node node) {
        for (ConnectionUnit cu: node.getConnectors()) {
            nodePoints.addAll(cu.getPoints());
        }
        
        for (Point point: nodePoints) {
            if (point.getLinkedPoint() != null) {
                remotePoints.add(point.getLinkedPoint());
                remoteNodes.add(point.getLinkedPoint().getCu().getNode());
            }
            if (point.getLinkOwner() != null) {
                remotePoints.add(point.getLinkOwner());
                remoteNodes.add(point.getLinkOwner().getCu().getNode());
            }
        }
    }
    
    public List<Point> getNodePoints() {
        return nodePoints;
    }

    public void setNodePoints(List<Point> nodePoints) {
        this.nodePoints = nodePoints;
    }

    public List<Point> getRemotePoints() {
        return remotePoints;
    }

    public List<Node> getRemoteNodes() {
        return remoteNodes;
    }
    
}
