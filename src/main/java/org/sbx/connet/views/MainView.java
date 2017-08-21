package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.sbx.connet.entity.Point;

@Named(value = "mainView")
@ViewScoped
public class MainView implements Serializable {

    @EJB
    private ConnetBean connetBean;

    @EJB
    private AddCuBean addCuBean;
    
    @EJB
    private AddLinkBean addLinkBean;
    
    @Inject
    private MenuBean menuBean;
    
    @Inject
    private ShowLinksBean showLinksBean;

    private List<Node> nodes;
    
    private Node selectedNode;
    
    public void onShowLinksDialog() {
        showLinksBean.clear();
        showLinksBean.loadValues(selectedNode);
    }
    
    public void onAddLinkDialogOpen() {
        addLinkBean.clearForm();
        menuBean.loadPointsMenu(selectedNode);
        menuBean.loadNodeMenu();
        menuBean.getNodeMenuItems().remove(selectedNode);
        menuBean.setRemotePointsMenuItems(new ArrayList<Point>());
    }
    
    public void onRemoteNodeSelect(ValueChangeEvent event) {
        Node node = (Node) event.getNewValue();
        menuBean.loadRemotePointsMenu(addLinkBean.getRemoteNode());
    }
    
    public void onAddLinkDialogClose() {
        addLinkBean.clearForm();
    }
    
    public void onAddCuDialogOpen() {
        addCuBean.clearForm();
        menuBean.loadNodeMenu();
    }

    @PostConstruct
    private void init() {
        nodes = connetBean.getAllNodes();
    }

    public void action() {
        return;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public AddCuBean getAddCuBean() {
        return addCuBean;
    }

    public void setAddCuBean(AddCuBean addCuBean) {
        this.addCuBean = addCuBean;
    }

    /**
     * @return the addLinkBean
     */
    public AddLinkBean getAddLinkBean() {
        return addLinkBean;
    }

    /**
     * @param addLinkBean the addLinkBean to set
     */
    public void setAddLinkBean(AddLinkBean addLinkBean) {
        this.addLinkBean = addLinkBean;
    }

    /**
     * @return the menuBean
     */
    public MenuBean getMenuBean() {
        return menuBean;
    }

    /**
     * @param menuBean the menuBean to set
     */
    public void setMenuBean(MenuBean menuBean) {
        this.menuBean = menuBean;
    }

    /**
     * @return the selectedNode
     */
    public Node getSelectedNode() {
        return selectedNode;
    }

    /**
     * @param selectedNode the selectedNode to set
     */
    public void setSelectedNode(Node selectedNode) {
        this.selectedNode = selectedNode;
    }

    /**
     * @return the showLinksBean
     */
    public ShowLinksBean getShowLinksBean() {
        return showLinksBean;
    }

    /**
     * @param showLinksBean the showLinksBean to set
     */
    public void setShowLinksBean(ShowLinksBean showLinksBean) {
        this.showLinksBean = showLinksBean;
    }

}
