package br.unitins.topicos1.resource.pessoa;

import java.util.List;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.Response.SugestaoResponseDTO;
import br.unitins.topicos1.service.FuncionarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public FuncionarioService funcionarioService;

    private static final Logger LOG = Logger.getLogger(FuncionarioResource.class);

    @GET
    @RolesAllowed({ "Funcionario" })
    public Response findAll() {
        LOG.info("Buscando todos os Funcionarios");
        LOG.debug("ERRO DE DEBUG.");
        return Response.ok(funcionarioService.findAll()).build();
    }

    @GET
    @RolesAllowed({ "Funcionario" })
    @Path("/search/cargo/{cargo}")
    public Response findByCargo(@PathParam("cargo") String cargo) {
        LOG.info("Buscando Funcionarios pelo cargo: " + cargo);
        return Response.ok(funcionarioService.findByCargo(cargo)).build();
    }

    @GET
    @RolesAllowed({ "Funcionario" })
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.info("Buscando Funcionario pelo cpf: " + cpf);
        return Response.ok(funcionarioService.findByCpf(cpf)).build();
    }

    @GET
    @RolesAllowed({ "Funcionario" })
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(funcionarioService.findById(id)).build();
    }

    @POST
    @RolesAllowed({ "Funcionario" })
    public Response create(@Valid FuncionarioDTO dto) {

        try {
            LOG.info("Funcionario criado com sucesso");
            return Response.status(Status.CREATED).entity(funcionarioService.create(dto)).build();
        } catch (Exception e) {
            LOG.error("Erro ao criar funcionairo", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao criar funcionario.").build();
        }
    }

    @PUT
    @RolesAllowed({ "Funcionario" })
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FuncionarioDTO dto) {
        try {
            LOG.info("Funcionario atualizado com sucesso");

            funcionarioService.update(id, dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao fazer update de funcionario.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao fazer update de funcionario.").build();
        }
    }

    @DELETE
    @RolesAllowed({ "Funcionario" })
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            LOG.infof("Cliente excluido com sucesso", id);
            funcionarioService.delete(id);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao deletar um funcionario", e);
            throw e;
        }
    }

    @PATCH
    @Path("/search/alterar-senha")
    @RolesAllowed({ "Funcionario" })
    public Response alterarSenha(AlterarSenhaDTO dto) {
        try {
            LOG.info("Senha alterada com sucesso");
            funcionarioService.alterarSenha(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar senha");
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar senha").build();
        }
    }

    @PATCH
    @Path("/search/alterar-email")
    @RolesAllowed({ "Funcionario" })
    public Response alterarEmail(AlterarEmailDTO dto) {
        try {
            LOG.info("Email alterado com sucesso.");
            funcionarioService.alterarEmail(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao alterar email, cliente.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Email").build();
        }
    }

    @PATCH
    @Path("/search/alterar-username")
    @RolesAllowed({ "Funcionario" })
    public Response alterarUsername(AlterarUsernameDTO dto) {
        try {
            LOG.info("Username alterado com sucesso.");
            funcionarioService.alterarUsername(dto);
            return Response.status(Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOG.error("Erro ao tentar alterar Username.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao tentar alterar Username").build();
        }
    }

    @GET
    @Path("/search/meu-perfil")
    @RolesAllowed({ "Funcionario" })
    public Response meuPerfil() {
        try {
            LOG.info("Buscando perfil do funcionario logado");
            return Response.ok(funcionarioService.findMeuPerfil()).build();
        } catch (Exception e) {
            LOG.error("Erro ao buscar perfil do funcionario.", e);
            return Response.status(Status.NOT_FOUND).entity("Erro ao buscar perfil do funcionario.").build();
        }
    }

    @GET
    @Path("/sugestoes/listarSugestoes")
    @RolesAllowed({"Funcionario"})
    public Response listarSugestoes() {
        try { 
            LOG.info("Listando todas as sugestões dos clientes"); 
            List<SugestaoResponseDTO> sugestoes = funcionarioService.findSugestoes(); 
            return Response.ok(sugestoes).build(); 
        } catch (Exception e) { 
            LOG.error("Erro ao listar todas as sugestões.", e); 
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao listar todas as sugestões.").build();
        }
    }

}
