package org.sbx.connet.beans;

import org.sbx.connet.entity.Node;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class ConnetBean implements Serializable {

    @PersistenceContext(unitName = "connetPU")
    private EntityManager em;

    public List<Node> getAllNodes() {
        return em.createNamedQuery("Node.getAllNodes", Node.class).getResultList();
    }
    
}
