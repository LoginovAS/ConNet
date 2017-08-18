package org.sbx.connet.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.sbx.connet.beans.ConnetBean;
import org.sbx.connet.entity.Node;
import org.sbx.connet.entity.Point;
import org.sbx.connet.views.MenuBean;

@FacesConverter(value = "pointConverter")
public class PointConverter implements Converter{
    
    @Inject
    private ConnetBean connetBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                for (Point point: connetBean.getAllPoints() ) {
                    if (point.getPointId() == Long.parseLong(value)) {
                        return point;
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
            return String.valueOf(((Point) value).getPointId());
        }
        else {
            return null;
        }
    }
    
}
