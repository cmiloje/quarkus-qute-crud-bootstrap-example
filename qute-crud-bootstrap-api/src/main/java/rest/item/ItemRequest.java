package rest.item;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 *
 * @author milenko
 */
public class ItemRequest {
    
    @FormParam("name") 
    @PartType(MediaType.TEXT_PLAIN) 
    public String itemName;
    
    @FormParam("description") 
    @PartType(MediaType.TEXT_PLAIN) 
    public String itemDescription;
    
    @FormParam("count") 
    @PartType(MediaType.TEXT_PLAIN) 
    public Integer itemCount;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
    
}
