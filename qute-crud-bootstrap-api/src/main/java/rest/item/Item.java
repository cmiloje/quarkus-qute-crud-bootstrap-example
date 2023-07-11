package rest.item;

import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

/**
 *
 * @author milenko
 */
@Path("item")
public interface Item {

    @POST
    Response postHome();

    @GET
    TemplateInstance getHome();

    @GET
    @Path("/{itemId}")
    TemplateInstance getItemForEdit(@PathParam("itemId") Long itemId);

    @POST
    @Path("/{itemId}/update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Response updateItem(@PathParam("itemId") Long itemId, @MultipartForm ItemRequest itemRequstForm);

    @POST
    @Path("/{itemId}")
    Response deleteItem(@PathParam("itemId") Long itemId);

    @POST
    @Path("/add")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    Response addItem(@MultipartForm ItemRequest itemRequstForm);

}
