package rest.impl.Item;

import controllers.ItemController;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import rest.item.Item;
import rest.item.ItemRequest;

/**
 *
 * @author milenko
 */
public class ItemImpl implements Item {
    
    @Inject
    ItemController itemController;
    
    @Override
    public TemplateInstance getHome() {
        return itemController.getHome();
    }

    @Override
    public Response postHome() {
        return redirectToHome();
    }

    @Override
    public Response updateItem(Long itemId, ItemRequest itemRequstForm) {
        itemController.updateItem(itemId, itemRequstForm);
        return redirectToHome();
    }
    
    @Override
    public Response deleteItem(Long itemId) {
        itemController.deleteItem(itemId);
        return redirectToHome();
    }
    
    @Override
    public TemplateInstance getItemForEdit(Long itemId) {
        return itemController.getItemForEdit(itemId);
    }
    
    @Override
    public Response addItem(ItemRequest itemRequstForm) {
        itemController.addItem(itemRequstForm);
        return redirectToHome();
    }
    
    
    private Response redirectToHome() {
        return Response
                .status(Response.Status.MOVED_PERMANENTLY)
                .location(URI.create("/item"))
                .build();
    }
}
