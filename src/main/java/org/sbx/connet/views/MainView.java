package org.sbx.connet.views;

import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "mainView")
@ViewScoped
public class MainView implements Serializable {

    @EJB
    private ConnetBean connetBean;

    @ManagedProperty(value = "#{nodes}")
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
