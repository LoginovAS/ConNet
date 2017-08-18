/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbx.connet.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.ConnectionUnit;
import org.sbx.connet.entity.Node;
import org.sbx.connet.entity.Point;

@Named(value = "menuBean")
@Dependent
public class MenuBean implements Serializable{
    
    @Inject
    private ConnetBean connetBean;
    
    private List<Node> nodeMenuItems;
    
    private List<Point> nodePointsMenuItems;
    
    private List<Point> remotePointsMenuItems;
    
    @PostConstruct
    private void init() {
        
        nodeMenuItems = new ArrayList<>();
        
        nodePointsMenuItems = new ArrayList<>();
        
    }
    
    public void loadNodeMenu() {
        nodeMenuItems = connetBean.getAllNodes();
    }
    
    public void  loadPointsMenu(Node node) {
        for (ConnectionUnit cu: node.getConnectors()) {
            for (Point p: cu.getPoints()) {
                if (p.getLinkedPoint() == null) {
                    nodePointsMenuItems.add(p);
                }
            }
        }
    }

    public List<Node> getNodeMenuItems() {
        return nodeMenuItems;
    }

    public void setNodeMenuItems(List<Node> nodeMenuItems) {
        this.nodeMenuItems = nodeMenuItems;
    }

    /**
     * @return the nodePointsMenuItems
     */
    public List<Point> getNodePointsMenuItems() {
        return nodePointsMenuItems;
    }

    /**
     * @param nodePointsMenuItems the nodePointsMenuItems to set
     */
    public void setNodePointsMenuItems(List<Point> nodePointsMenuItems) {
        this.nodePointsMenuItems = nodePointsMenuItems;
    }

    /**
     * @return the remotePointsMenuItems
     */
    public List<Point> getRemotePointsMenuItems() {
        return remotePointsMenuItems;
    }

    /**
     * @param remotePointsMenuItems the remotePointsMenuItems to set
     */
    public void setRemotePointsMenuItems(List<Point> remotePointsMenuItems) {
        this.remotePointsMenuItems = remotePointsMenuItems;
    }
    
}
