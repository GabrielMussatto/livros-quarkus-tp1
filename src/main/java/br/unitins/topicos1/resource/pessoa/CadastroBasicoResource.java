package br.unitins.topicos1.resource.pessoa;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.CadastroBasicoDTO;
import br.unitins.topicos1.service.CadastroBasicoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cadastroBasicoCliente")
public class CadastroBasicoResource {

    @Inject
    CadastroBasicoService cadastroBasicoService;

    private static final Logger LOG = Logger.getLogger(CadastroBasicoResource.class);
    
    @POST
    public Response create(@Valid CadastroBasicoDTO dto){

        LOG.info("Executando um cadastro basico de cliente. ");
        return Response.status(Response.Status.CREATED).entity(cadastroBasicoService.create(dto)).build();
    }

}
