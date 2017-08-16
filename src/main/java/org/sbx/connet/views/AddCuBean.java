package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "addCuBean")
@Dependent
@Stateless
public class AddCuBean implements Serializable {

    @EJB
    private ConnetBean connetBean;

    private String selectedNode = "";
    private String newCuName = "";
    private String newCapacity = "";

    public String getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(String selectedNode) {
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
