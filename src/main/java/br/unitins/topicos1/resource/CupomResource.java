package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.CupomDTO;
import br.unitins.topicos1.service.CupomService;
import jakarta.annotation.security.RolesAllowed;
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
@Path("/cupons")
public class CupomResource {
    
    @Inject
    public CupomService cupomService;

    private static final Logger LOG = Logger.getLogger(CupomResource.class);

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        LOG.info("Executando o findById - Executando CupomResource_FindById");
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(cupomService.findById(id)).build();
    }

    @GET
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todos os cupoms - Executando CupomResource_FindAll");
        return Response.ok(cupomService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nomeCupom/{nomeCupom}")
    public Response findByNomeCupom(
        @PathParam("nomeCupom") String nomeCupom,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando os cupoms pelo nomeCupomCupom - Executando CupomResource_FindByNomeCupom");
        return Response.ok(cupomService.findByNomeCupom(page, pageSize, nomeCupom)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(cupomService.count()).build();
    }

    @GET
    @Path("/count/search/{nomeCupom}")
    public Response countByNomeCupom(@PathParam("nomeCupom") String nomeCupom) {
        return Response.ok(cupomService.countByNomeCupom(nomeCupom)).build();
    }

    @POST
    @RolesAllowed({"Funcionario"})
    public Response create (CupomDTO dto){
        // try {
        //     LOG.info("Criando um novo cupom - Executando CupomResource_create");
            return Response.status(Status.CREATED).entity(cupomService.create(dto)).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao criar um novo cupom - Executando CupomResource_create", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao criar um novo cupom - Executando CupomResource_create").build();
        // }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, CupomDTO dto){
        // try {
        //     LOG.info("Atualizando um cupom - Executando CupomResource_update");
            cupomService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao atualizar um cupom - Executando CupomResource_update", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar um cupom - Executando CupomResource_update").build();
        // }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Deletando um cupom - Executando CupomResource_delete");
            cupomService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar um cupom - Executando CupomResource_deleta", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar um cupom - Executando CupomResource_deleta").build();
        }
    }    

}
