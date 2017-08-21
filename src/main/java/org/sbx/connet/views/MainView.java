package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.sbx.connet.entity.Point;

@Named(value = "mainView")
@ViewScoped
public class MainView implements Serializable {

    @Inject
    private ConnetBean connetBean;

    @Inject
    private ShowLinksBean showLinksBean;

    private List<Node> nodes;
    
    private Node selectedNode;
    
    public void onShowLinksDialog() {
        showLinksBean.clear();
        showLinksBean.loadValues(selectedNode);
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

    public Node getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(Node selectedNode) {
        this.selectedNode = selectedNode;
    }

    public ShowLinksBean getShowLinksBean() {
        return showLinksBean;
    }

    public void setShowLinksBean(ShowLinksBean showLinksBean) {
        this.showLinksBean = showLinksBean;
    }

}
