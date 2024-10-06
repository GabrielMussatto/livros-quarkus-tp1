package br.unitins.topicos1.resource.pessoa;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.service.ClienteService;
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
@Path("/clientes")
public class ClienteResource {

    @Inject
    public ClienteService clienteService;

    private static final Logger LOG = Logger.getLogger(ClienteResource.class);

    @GET
    //@RolesAllowed({"Funcionario"})
    public Response findAll() {
        LOG.info("Buscando todos os clientes");
        LOG.debug("ERRO DE DEBUG.");
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    @Path("/search/estado/{estado}")
    public Response findByEstado(@PathParam("estado") String estado) {
        LOG.info("Buscando clientes por estados");
        return Response.ok(clienteService.findByEstado(estado)).build();
    }

    @GET
    //@RolesAllowed({"Funcionario"})
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        LOG.info("Buscando cpf do cliente");
        return Response.ok(clienteService.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({"Funcionario"})
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o método findById. Id: %s", id.toString());
        return Response.ok(clienteService.findById(id)).build();
    }

    @POST
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
    //@RolesAllowed({"Cliente"})
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
}
