package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.GeneroDTO;
import br.unitins.topicos1.service.GeneroService;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/generos")
public class GeneroResource {

    @Inject
    public GeneroService generoService;

    private static final Logger LOG = Logger.getLogger(GeneroResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Executando o findById - Executando GeneroResource_FindById");
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(generoService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todos os generos - Executando GeneroResource_FindAll");
        return Response.ok(generoService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({"Funcionario"})
    public Response findByNome(
        @PathParam("nome") String nome,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando os generos pelo nome - Executando GeneroResource_FindByNome");
        return Response.ok(generoService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    //@RolesAllowed({"Funcionario"})
    public Response findByDescricao(
        @PathParam("descricao") String descricao,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando os generos pela descricao - Executando GeneroResource_FindByDescricao");
        return Response.ok(generoService.findByDescricao(page, pageSize, descricao)).build();
    }
    
    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(generoService.count()).build();
    }

    @GET
    @Path("/count/search/{nome}")
    public Response countByNome(@PathParam("nome") String nome) {
        return Response.ok(generoService.countByNome(nome)).build();
    }

    @POST
    //@RolesAllowed({"Funcionario"})
    public Response create (GeneroDTO dto){
        // try {
        //     LOG.info("Criando um novo genero - Executando GeneroResource_create");
            return Response.status(Status.CREATED).entity(generoService.create(dto)).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao criar um novo genero - Executando GeneroResource_create", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao criar um novo genero - Executando GeneroResource_create").build();
        // }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, GeneroDTO dto){
        // try {
        //     LOG.info("Atualizando um genero - Executando GeneroResource_update");
            generoService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao atualizar um genero - Executando GeneroResource_update", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar um genero - Executando GeneroResource_update").build();
        // }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Deletando um genero - Executando GeneroResource_delete");
            generoService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar um genero - Executando GeneroResource_deleta", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar um genero - Executando GeneroResource_deleta").build();
        }
    }    
}
