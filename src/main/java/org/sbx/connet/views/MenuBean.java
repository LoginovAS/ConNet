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
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

@Named(value = "menuBean")
@Dependent
public class MenuBean implements Serializable{
    
    @Inject
    private ConnetBean connetBean;
    
    private List<Node> nodeMenuItems;
    
    @PostConstruct
    private void init() {
        
        nodeMenuItems = new ArrayList<>();
        
        nodeMenuItems = connetBean.getAllNodes();
        
    }

    public List<Node> getNodeMenuItems() {
        return nodeMenuItems;
    }

    public void setNodeMenuItems(List<Node> nodeMenuItems) {
        this.nodeMenuItems = nodeMenuItems;
    }
    
}
