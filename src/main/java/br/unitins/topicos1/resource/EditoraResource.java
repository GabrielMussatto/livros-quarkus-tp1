package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.service.EditoraService;
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
@Path("/editoras")
public class EditoraResource {

    @Inject
    public EditoraService editoraService;

    private static final Logger LOG = Logger.getLogger(EditoraResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Buscando editora por id: - Executando EditoraResource_FindById" + id);
        return Response.ok(editoraService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todas as editoras - Executando EditoraResource_Findall");
        return Response.ok(editoraService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({"Funcionario"})
    public Response findByNome(
        @PathParam("nome") String nome,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando editora por nome: - Executando EditoraResource_FindByNome" + nome);
        return Response.ok(editoraService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/search/estado/{estado}")
    //@RolesAllowed({"Funcionario"})
    public Response findByEstado(
        @PathParam("estado") String estado,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todas as editora por estado: - Executando EditoraResource_FindByEstado" + estado);
        return Response.ok(editoraService.findByEstado(page, pageSize, estado)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(editoraService.count()).build();
    }

    @POST
    //@RolesAllowed({"Funcionario"})
    public Response create (EditoraDTO dto){
        try {
            LOG.info("Editora criado com sucesso - Executando EditoraResource_create");
            return Response.status(Status.CREATED).entity(editoraService.create(dto)).build();
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar editora - Executando EditoraResource_create", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao cadastrar editora - Executando EditoraResource_create").build();
        }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, EditoraDTO dto){
        try {
            LOG.info("Editora atualizado com sucesso - Executando EditoraResource_update");
            editoraService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao atualizar editora - Executando EditoraResource_update", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar editora - Executando EditoraResource_update").build();
        }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Editora deletado com sucesso - Executando EditoraResource_delete");
            editoraService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar editora - Executando EditoraResource_delete", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar editora - Executando EditoraResource_delete").build();
        }
    }    
}
