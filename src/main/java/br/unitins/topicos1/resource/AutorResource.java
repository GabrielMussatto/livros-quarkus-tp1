package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.AutorService;
import br.unitins.topicos1.service.file.AutorFileServiceImpl;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/autores")
public class AutorResource {

    @Inject
    public AutorService autorService;

    @Inject
    public AutorFileServiceImpl fileService;

    private static final Logger LOG = Logger.getLogger(AutorResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(autorService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando todos os autores - Executando AutorResource_FindAll");
        return Response.ok(autorService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(
        @PathParam("nome") String nome,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando autores por nome - Executando AutorResource_FindByNome");
        return Response.ok(autorService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/search/biografia/{biografia}")
    //@RolesAllowed({"Funcionario", "Cliente"}) 
    public Response findByBiografia(
        @PathParam("biografia") String biografia,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando autores por biografia - - Executando AutorResource_FindByBiografia");
        return Response.ok(autorService.findByBiografia(page, pageSize, biografia)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(autorService.count()).build();
    }

    @GET
    @Path("/count/search/{nome}")
    public long countByNome(@PathParam("nome") String nome) {
        return autorService.countByNome(nome);
    }

    @POST
    //@RolesAllowed({"Funcionario"}) 
    public Response create(@Valid AutorDTO dto) {
        // try {
        //     LOG.info("Criando novo autor: - Executando AutorResource_create");
            return Response.status(Status.CREATED).entity(autorService.create(dto)).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao criar autor - Executando AutorResource_create", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao criar autor. - - Executando AutorResource_Create").build();
        // }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"}) 
    public Response update(@PathParam("id") Long id, AutorDTO dto) {
        // try {
        //     LOG.info("Atualizando autor: - Executando AutorResource_update" + id);
            autorService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao atualizar autor - Executando AutorResource_update", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao fazer update autor. - Executando AutorResource_update").build();
        // }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"}) 
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.info("Removendo autor: - Executando AutorResource_delete" + id);
            autorService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao remover autor - Executando AutorResource_FindBydelete", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar autor - Executando AutorResource_delete").build();
        }
    }

    @PATCH
    @Path("/{id}/image/upload")
    //@RolesAllowed({"Funcionario"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            LOG.infof("Imagem salva com sucesso - Executando AutorResource_upload");
            return Response.noContent().build();
        } catch (Exception e) {
            LOG.error("Erro ao salvar imagem do livro - Executando AutorResource_upload", e);
            return Response.status(Status.CONFLICT).entity("Erro ao salvar imagem do livro - Executando AutorResource_upload").build();
        }
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    //@RolesAllowed({"Funcionario"})
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        try {
            
            ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
            response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
            LOG.infof("Download do arquivo %s concluído com sucesso. - Executando AutorResource_download", nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar o download do arquivo: %s", nomeImagem, e);

            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }  
}
