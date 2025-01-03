package br.unitins.topicos1.resource.pessoa;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.SugestaoDTO;
import br.unitins.topicos1.dto.Response.ItemFavoritoResponseDTO;
import br.unitins.topicos1.dto.Response.SugestaoResponseDTO;
import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.annotation.security.RolesAllowed;
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
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/clientes")
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    @RolesAllowed({"Funcionario"})
    public Response findAll(
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando todos os clientes");
        LOG.debug("ERRO DE DEBUG.");
        return Response.ok(clienteService.findAll(page, pageSize)).build();
    }

    @GET
    @RolesAllowed({"Funcionario"})
    @Path("/search/estado/{estado}")
    public Response findByEstado(
        @PathParam("estado") String estado,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando clientes por estados");
        return Response.ok(clienteService.findByEstado(page, pageSize, estado)).build();
    }

    @GET
    @RolesAllowed({"Funcionario"})
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(
        @PathParam("cpf") String cpf,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando cpf do cliente");
        return Response.ok(clienteService.findByCpf(page, pageSize, cpf)).build();
    }

    @GET
    @RolesAllowed({"Funcionario"})
    @Path("/search/nome/{nome}")
    public Response findByNome(
        @PathParam("nome") String nome,
        @DefaultValue("0") @QueryParam("page") int page,
        @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        LOG.info("Buscando nome do cliente");
        return Response.ok(clienteService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(clienteService.count()).build();
    }

    @GET
    @Path("/count/search/estado/{estado}")
    public Response countByEstado(@PathParam("estado") String estado) {
        return Response.ok(clienteService.countByEstado(estado)).build();
    }

    @GET
    @Path("/count/search/nome/{nome}")
    public Response countByNome(@PathParam("nome") String nome) {
        return Response.ok(clienteService.countByNome(nome)).build();
    }

    @GET
    @Path("/count/search/cpf/{cpf}")
    public Response countByCpf(@PathParam("cpf") String cpf) {
        return Response.ok(clienteService.countByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(clienteService.findById(id)).build();
    }

    @POST
    @RolesAllowed({"Cliente"})
    public Response create(@Valid ClienteDTO dto) {
        try {
            LOG.info("Cliente criado com suceso");
            return Response.status(Status.CREATED).entity(clienteService.create(dto)).build(); // 201
        } catch (Exception e) {
            LOG.error("Erro ao criar cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao criar cliente.").build();
        }
    }

    @PUT
    @RolesAllowed({"Cliente"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        try {
            LOG.info("Cliente atualizado com sucesso");
            clienteService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build(); // 204
        } catch (Exception e) {
            LOG.error("Erro ao fazer update de cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao fazer update cliente.").build();
        }
    }

    @DELETE
    @RolesAllowed({"Cliente"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.infof("Cliente excluido com sucesso", id);
            clienteService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar um cliente", e);
            throw e;
        }
    }

    @PATCH
    @Path("/search/alterar-senha")
    @RolesAllowed({"Cliente"})
    public Response alterarSenha(AlterarSenhaDTO dto) {
        try {
            LOG.info("Senha alterada com sucesso");
            clienteService.alterarSenha(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar senha");
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar senha").build();
        }
    }

    @PATCH
    @Path("/search/alterar-email")
    @RolesAllowed({"Cliente"})
    public Response alterarEmail(AlterarEmailDTO dto) {
        try {
            LOG.info("Email alterado com sucesso.");            
            clienteService.alterarEmail(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao alterar email, cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Email").build();
        }
    }

    @PATCH
    @RolesAllowed({"Cliente"})
    @Path("/search/alterar-username")
    public Response alterarUsername(AlterarUsernameDTO dto) {
        try {
            LOG.info("Username alterado com sucesso.");
            clienteService.alterarUsername(dto);
            return Response.status(Status.NO_CONTENT).build();   
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar Username.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Username").build();
        }
    }

    @GET
    @RolesAllowed({"Cliente"})
    @Path("/search/meu-perfil")
    public Response meuPerfil() {
        try {
            LOG.info("Buscando perfil do cliente logado");
            return Response.ok(clienteService.findMeuPerfil()).build();
        } catch (Exception e) {
            LOG.error("Erro ao buscar perfil do cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao buscar perfil do cliente.").build();
        }
    }

    @PATCH
    @RolesAllowed({"Cliente"})
    @Path("/favoritos/adicionar")
    public Response adicionarItemFavorito(
        @QueryParam("idLivro") Long idLivro,
        @QueryParam("idCaixaLivro") Long idCaixaLivro){
        try {
            LOG.infof("Inserindo item na lista de favoritos");
            clienteService.adicionarItemFavorito(idLivro, idCaixaLivro);
            return Response.status(Status.NO_CONTENT).build();
        }catch (Exception e) {
            LOG.error("Erro ao adicionar item na lista de favoritos.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao adicionar item na lista de favoritos.").build();
        }
    }

    @PATCH
    @RolesAllowed({"Cliente"})
    @Path("/favoritos/remover/{id}")
    public Response removerItemFavorito(@PathParam("id") Long idItem){
        try {
            LOG.infof("Removendo item da lista de favoritos");
            clienteService.removerItemFavorito(idItem);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao remover item da lista de favoritos.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao remover item da lista de favoritos.").build();
        }
    }

    @GET
    @RolesAllowed({"Cliente"})
    @Path("/favoritos")
    public Response listarMeusFavoritos(){
        try {
            LOG.info("Listando itens favoritos do cliente");
            List<ItemFavoritoResponseDTO> lista = clienteService.findMeusFavoritos();
            return Response.ok(lista).build();
        } catch (Exception e) {
            LOG.error("Erro ao listar os itens favoritos", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao listar os itens favoritos.").build();
        }
    }

    @POST 
    @RolesAllowed({"Cliente"}) 
    @Path("/sugestoes/adicionarSugestao") 
    public Response adicionarSugestao(@Valid SugestaoDTO sugestaoDTO) { 
        try { 
            LOG.info("Adicionando nova sugestão"); 
            SugestaoResponseDTO resposta = clienteService.adicionarSugestao(sugestaoDTO); 
            return Response.status(Status.CREATED).entity(resposta).build(); 
        } catch (Exception e) { 
            LOG.error("Erro ao adicionar sugestão.", e); 
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao adicionar sugestão.").build(); 
        } 
    } 
    
    @GET 
    @RolesAllowed({"Cliente"}) 
    @Path("/sugestoes/minhasSugestoes") 
    public Response findMinhasSugestoes() { 
        try { 
            LOG.info("Buscando sugestões do cliente logado"); 
            List<SugestaoResponseDTO> sugestoes = clienteService.findMinhasSugestoes(); 
            return Response.ok(sugestoes).build(); 
        } catch (Exception e) { 
            LOG.error("Erro ao buscar sugestões do cliente.", e); 
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar sugestões do cliente.").build(); 
        }
    }

    @GET
    @Path("/sexos")
    public Response getSexos(){
        return Response.ok(Sexo.values()).build();
    }
}
