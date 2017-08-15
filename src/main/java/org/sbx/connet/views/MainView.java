package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "mainView")
@SessionScoped
public class MainView implements Serializable {

    @EJB
    private ConnetBean connetBean;

    private List<Node> nodes;

    @PostConstruct
    private void init() {
        nodes = connetBean.getAllNodes();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
