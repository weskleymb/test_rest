package service;

import dao.ContatoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Contato;

@Path("/contato")
public class ContatoService {

    private final ContatoDAO dao = new ContatoDAO();
    
    @POST
    @Path("/cadastrar")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response cadastrar(Contato contato) {
        try {
            dao.create(contato);
            return Response.status(200).entity("Contato Cadastrado").build();
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha no Cadastro").build();
    }
    
    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Contato> buscarTodos() {
        return dao.findAll();
    }
    
    @GET
    @Path("/buscar/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Contato buscarId(@PathParam("id") int id) {
        return dao.findByPrimaryKey(id);
    }
    
    @PUT
    @Path("/alterar")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response alterar(Contato contato) {
        try {
            dao.update(contato);
            return Response.status(200).entity("Contato Alterado").build();
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na Alteração").build();
    }
    
    @DELETE
    @Path("/excluir/{id}")
    public Response excluir(@PathParam("id") int id) {
        try {
            dao.delete(dao.findByPrimaryKey(id));
            return Response.status(200).entity("Contato Excluído").build();
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("Falha na Exclusão").build();
    }
    
}
