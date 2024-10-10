package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.service.FornecedorService;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/fornecedores")
public class FornecedorResource {
    
    @Inject
    public FornecedorService fornecedorService;

    private static final Logger LOG = Logger.getLogger(FornecedorResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Executando o findById - Executando FornecedorResource_FindById");
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(fornecedorService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    public Response findAll(){
        LOG.info("Buscando todos os fornecedores - Executando FornecedorResource_FindAll");
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({"Funcionario"})
    public Response findByNome(@PathParam("nome") String nome){
        LOG.info("Buscando fornecedor por nome: - Executando FornecedorResource_FindByNome " + nome);
        return Response.ok(fornecedorService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/estado/{estado}")
    //@RolesAllowed({"Funcionario"})
    public Response findByEstado(@PathParam("estado") String estado){
        LOG.info("Buscando todos os fornecedores por estado: - Executando FornecedorResource_FindByEstado" + estado);
        return Response.ok(fornecedorService.findByEstado(estado)).build();
    }

    @GET
    @Path("/search/cidade/{cidade}")
    //@RolesAllowed({"Funcionario"})
    public Response findByCidade(@PathParam("cidade") String cidade){
        LOG.info("Buscando todos os fornecedores por cidade: - Executando FornecedorResource_FindByCidade" + cidade);
        return Response.ok(fornecedorService.findByCidade(cidade)).build();
    }

    @GET
    @Path("/search/cnpj/{cnpj}")
    //@RolesAllowed({"Funcionario"})
    public Response findByCnpj(@PathParam("cnpj") String cnpj){
        LOG.info("Buscando fornecedor por cnpj: - Executando FornecedorResource_FindByCnpj" + cnpj);
        return Response.ok(fornecedorService.findByCnpj(cnpj)).build();
    }

    @POST
    //@RolesAllowed({"Funcionario"})
    public Response create(@Valid FornecedorDTO dto){
        try {
            LOG.info("Criando novo fornecedor: - Executando FornecedorResource_create");
            return Response.status(Status.CREATED).entity(fornecedorService.create(dto)).build();
        } catch (Exception e) {
            LOG.error("Erro ao criar fornecedor: " + e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao criar fornecedor - Executando FornecedorResource_create").build();
        }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, FornecedorDTO dto){
        try {
            LOG.info("Fornecedor atualizado com sucesso - Executando FornecedorResource_update");
            fornecedorService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao atualizar fornecedor: - Executando FornecedorResource_update" + e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar fornecedor - Executando FornecedorResource_update").build();
        }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Fornecedor deletado com sucesso - Executando FornecedorResource_delete");
            fornecedorService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar fornecedor: - Executando FornecedorResource_delete" + e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar fornecedor - Executando FornecedorResource_delete").build();
        }
    }
}
