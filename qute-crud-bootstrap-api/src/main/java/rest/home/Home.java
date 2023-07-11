package rest.home;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author milenko
 */
@Path("/")
public interface Home {
    
    @GET
    Response getHome();
}
