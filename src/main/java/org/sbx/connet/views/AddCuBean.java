package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import org.sbx.connet.entity.Node;

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
    
    public void action() {
        Node n = selectedNode;
        String s1 = newCuName;
        String s2 = newCapacity;
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
