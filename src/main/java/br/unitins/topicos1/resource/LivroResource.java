package br.unitins.topicos1.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.LivroDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.LivroService;
import br.unitins.topicos1.service.file.LivroFileServiceImpl;
//import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
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
@Path("/livros")
public class LivroResource {

    @Inject
    public LivroService livroService;

    @Inject
    public LivroFileServiceImpl fileService;

    private static final Logger LOG = Logger.getLogger(LivroResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id){
        LOG.info("Executando o findById");
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(livroService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todos os livros - Executando LivroResource_FindAll");
        return Response.ok(livroService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/titulo/{titulo}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByTitulo(
        @PathParam("titulo") String titulo,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando livros por título - Executando LivroResource_FindByTitulo");
        return Response.ok(livroService.findByTitulo(page, pageSize, titulo)).build();
    }

    @GET
    @Path("/search/isbn/{isbn}")
    //@RolesAllowed({"Funcionario","Cliente"})
    public Response findByIsbn(
        @PathParam("isbn") String isbn,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando livros por ISBN - Executando LivroResource_findByIsbn");
        return Response.ok(livroService.findByIsbn(page, pageSize, isbn)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByDescricao(
        @PathParam("descricao") String descricao,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando livros por descrição - Executando LivroResource_findByDescricao");
        return Response.ok(livroService.findByDescricao(page, pageSize, descricao)).build();
    }
    
    @GET
    @Path("/search/autor/{autor}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByAutor(
        @PathParam("autor") String autor,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando livros por autor - Executando LivroResource_findByAutor");
        return Response.ok(livroService.findByAutor(page, pageSize, autor)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(livroService.count()).build();
    }

    @GET
    @Path("/count/search/{titulo}")
    public Response countByTitulo(@PathParam("titulo") String titulo) {
        return Response.ok(livroService.countByTitulo(titulo)).build();
    }

    @GET
    @Path("/count/search/{autor}")
    public Response countByAutor(@PathParam("autor") String autor) {
        return Response.ok(livroService.countByAutor(autor)).build();
    }

    @POST
    //@RolesAllowed({"Funcionario"})
    public Response create (LivroDTO dto){
        // try {
        //     LOG.info("Criando um novo livro - Executando LivroResource_create");
            return Response.status(Status.CREATED).entity(livroService.create(dto)).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao criar um novo livro - Executando LivroResource_create", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao criar um novo livro - Executando LivroResource_create").build();
        // }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, LivroDTO dto){
        // try {
        //     LOG.info("Atualizando um livro- Executando LivroResource_update");
            livroService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao atualizar um livro - Executando LivroResource_update", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar um livro - Executando LivroResource_update").build();
        // }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Deletando um livro - Executando LivroResource_delete");
            livroService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar um livro - Executando LivroResource_delete", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar um livro - Executando LivroResource_delete").build();
        }
    }  
    
    @PATCH
    @Path("/{id}/image/upload")
    //@RolesAllowed({"Funcionario"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            LOG.infof("Imagem salva com sucesso - Executando LivroResource_upload");
            return Response.noContent().build();
        } catch (Exception e) {
            LOG.error("Erro ao salvar imagem do livro - Executando LivroResource_upload", e);
            return Response.status(Status.CONFLICT).entity("Erro ao salvar imagem do livro - Executando LivroResource_upload").build();
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
            LOG.infof("Download do arquivo %s concluído com sucesso. - Executando LivroResource_download", nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar o download do arquivo:- Executando LivroResource_download %s", nomeImagem, e);

            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }   

}
