package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.CaixaLivroDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.CaixaLivroService;
import br.unitins.topicos1.service.file.CaixaLivroFileServiceImpl;
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
@Path("/caixaLivros")
public class CaixaLivroResource {
    @Inject
    public CaixaLivroService caixaLivroService;

    @Inject
    public CaixaLivroFileServiceImpl fileService;

    private static final Logger LOG = Logger.getLogger(CaixaLivroResource.class);

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Executando o findById - CaixaLivroResource");
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(caixaLivroService.findById(id)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando todos as caixas de livros - Executando CaixaLivroResource_FindAll");
        return Response.ok(caixaLivroService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(
        @PathParam("nome") String nome,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando caixas de livros por nonme - Executando CaixaLivroResource_findByNome");
        return Response.ok(caixaLivroService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByDescricao(
        @PathParam("descricao") String descricao,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando caixas de livros por descrição - Executando CaixaLivroResource_findByDescricao");
        return Response.ok(caixaLivroService.findByDescricao(page, pageSize, descricao)).build();
    }

    @GET
    @Path("/search/autor/{autor}")
    //@RolesAllowed({"Funcionario", "Cliente"})
    public Response findByAutor(
        @PathParam("autor") String autor,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize){
        LOG.info("Buscando caixas de livros por autor - Executando CaixaLivroResource_findByAutor");
        return Response.ok(caixaLivroService.findByAutor(page, pageSize, autor)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(caixaLivroService.count()).build();
    }

    @GET
    @Path("/count/search/{nome}")
    public Response countByNome(@PathParam("nome") String nome) {
        return Response.ok(caixaLivroService.countByNome(nome)).build();
    }

    @POST
    //@RolesAllowed({"Funcionario"})
    public Response create (CaixaLivroDTO dto){
        // try {
        //     LOG.info("Criando uma nova caixa livro - Executando CaixaLivroResource_create");
            return Response.status(Status.CREATED).entity(caixaLivroService.create(dto)).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao criar uma nova caixa livro - Executando CaixaLivroResource_create", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao criar uma nova caixa livro - Executando CaixaLivroResource_create").build();
        // }
    }

    @PUT
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response update(@PathParam("id") Long id, CaixaLivroDTO dto){
        // try {
        //     LOG.info("Atualizando uma caixa livro- Executando CaixaLivroResource_update");
            caixaLivroService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        // } catch (Exception e) {
        //     LOG.error("Erro ao atualizar uma caixa livro - Executando CaixaLivroResource_update", e);
        //     return Response.status(Status.NOT_FOUND).entity("Erro ao atualizar uma caixa livro - Executando CaixaLivroResource_update").build();
        // }
    }

    @DELETE
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response delete(@PathParam("id") Long id){
        try {
            LOG.info("Deletando uma caixa livro - Executando CaixaLivroResource_delete");
            caixaLivroService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar uma caixa livro - Executando CaixaLivroResource_delete", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao deletar uma caixa livro - Executando CaixaLivroResource_delete").build();
        }
    }  
    
    @PATCH
    @Path("/{id}/image/upload")
    //@RolesAllowed({"Funcionario"})
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        try {
            fileService.salvar(id, form.getNomeImagem(), form.getImagem());
            LOG.infof("Imagem salva com sucesso - Executando CaixaLivroResource_upload");
            return Response.noContent().build();
        } catch (Exception e) {
            LOG.error("Erro ao salvar imagem da caixa livro - Executando CaixaLivroResource_upload", e);
            return Response.status(Status.CONFLICT).entity("Erro ao salvar imagem da caixa livro - Executando CaixaLivroResource_upload").build();
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
            LOG.infof("Download do arquivo %s concluído com sucesso. - Executando CaixaLivroResource_download", nomeImagem);
            return response.build();
        } catch (Exception e) {
            LOG.errorf("Erro ao realizar o download do arquivo:- Executando CaixaLivroResource_download %s", nomeImagem, e);

            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
