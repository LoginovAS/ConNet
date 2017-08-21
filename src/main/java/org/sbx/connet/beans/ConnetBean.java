package org.sbx.connet.beans;

import org.sbx.connet.entity.Node;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.sbx.connet.entity.ConnectionUnit;
import org.sbx.connet.entity.Point;

@Resource
@Stateless
public class ConnetBean implements Serializable {

    @PersistenceContext(unitName = "connetPU")
    private EntityManager em;

    public List<Node> getAllNodes() {
        return em.createNamedQuery("Node.getAllNodes", Node.class).getResultList();
    }
    
    public List<Point> getAllPoints() {
        return em.createNamedQuery("Point.getAllPoints").getResultList();
    }
    
    public Point getPointByLink(int id) {
        return (Point) em.createNamedQuery("Point.getPointByLink").setParameter("id", id).getSingleResult();
    }
    
    public void createConnectionUnit(ConnectionUnit cu) {
        em.persist(cu);
    }
    
    public ConnectionUnit getCuById(long id) {
        return em.find(ConnectionUnit.class, id);
    }
    
}
