package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.sbx.connet.entity.ConnectionUnit;
import org.sbx.connet.entity.Node;
import org.sbx.connet.entity.Point;

@Named(value = "addCuBean")
@Dependent
@Stateless
public class AddCuBean implements Serializable {

    @EJB
    private ConnetBean connetBean;

    private Node selectedNode;
    private String newCuName;
    private String newCapacity;
    
    public void clearForm() {
        selectedNode = null;
        newCuName = null;
        newCapacity = null;
    }
    
    public void onDialogOpen() {
        clearForm();
    }
    
    public void createCu() {
        ConnectionUnit cu = new ConnectionUnit();
        
        for (int i = 0; i < Integer.parseInt(newCapacity); i++) {
            Point point = new Point();
            point.setPointNumber(i);
            point.setCu(cu);
            cu.getPoints().add(point);
        }
        
        cu.setCuName(newCuName);
        cu.setCapacity(Integer.parseInt(newCapacity));
        cu.setNode(selectedNode);
        
        selectedNode.getConnectors().add(cu);
        
        connetBean.createConnectionUnit(cu);
        
        clearForm();
    }

    public Node getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(Node selectedNode) {
        this.selectedNode = selectedNode;
    }

    public String getNewCuName() {
        return newCuName;
    }

    public void setNewCuName(String newCuName) {
        this.newCuName = newCuName;
    }

    public String getNewCapacity() {
        return newCapacity;
    }

    public void setNewCapacity(String newCapacity) {
        this.newCapacity = newCapacity;
    }
}
