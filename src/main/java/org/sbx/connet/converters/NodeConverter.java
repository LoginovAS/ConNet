package org.sbx.connet.converters;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;

@FacesConverter(value = "nodeConverter")
public class NodeConverter implements Converter, Serializable{
    
    @EJB
    private ConnetBean connetBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                for (Node node: connetBean.getAllNodes()) {
                    if (node.getNodeId() == Long.parseLong(value)) {
                        return node;
                    }
                }
                
                return null;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid node."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Node) value).getNodeId());
        }
        else {
            return null;
        }
    }
    
}
