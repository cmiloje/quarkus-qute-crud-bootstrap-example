package rest.impl.home;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import rest.home.Home;

/**
 *
 * @author milenko
 */

@Path("/")
public class HomeImpl implements Home {
    
    @Override
    public Response getHome() {
        return Response.status(Response.Status.MOVED_PERMANENTLY)
                .location(URI.create("/item"))
                .build();
    }
    
}
