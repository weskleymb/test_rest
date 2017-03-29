package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class HelloWorldService {

    @GET
    @Path("/hello")
    @Produces({MediaType.APPLICATION_JSON})
    public String hello() {
        return "Bem vindo!";
    }
	
}
