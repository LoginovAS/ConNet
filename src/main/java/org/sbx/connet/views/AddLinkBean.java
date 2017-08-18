package org.sbx.connet.views;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;
import org.sbx.connet.entity.Point;

@Named(value = "addLinkBean")
@Dependent
@Stateless
public class AddLinkBean implements Serializable {
    
    @EJB
    private ConnetBean connetBean;
    
    private Point fromPoint;
    private Node remoteNode;
    private Point toPoint;

    public void clearForm() {
        fromPoint = null;
        remoteNode = null;
        toPoint = null;
    }
    
    public Point getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(Point fromPoint) {
        this.fromPoint = fromPoint;
    }

    public Point getToPoint() {
        return toPoint;
    }

    public void setToPoint(Point toPoint) {
        this.toPoint = toPoint;
    }

    /**
     * @return the remoteNode
     */
    public Node getRemoteNode() {
        return remoteNode;
    }

    /**
     * @param remoteNode the remoteNode to set
     */
    public void setRemoteNode(Node remoteNode) {
        this.remoteNode = remoteNode;
    }
    
}
