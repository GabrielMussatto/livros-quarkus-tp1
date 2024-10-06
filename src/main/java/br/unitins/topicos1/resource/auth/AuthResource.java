package br.unitins.topicos1.resource.auth;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.dto.auth.AuthUsuarioDTO;
import br.unitins.topicos1.service.hash.HashService;
import br.unitins.topicos1.service.jwt.JwtService;
import br.unitins.topicos1.validation.ValidationException;
import br.unitins.topicos1.service.ClienteService;
import br.unitins.topicos1.service.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthResource {

    @Inject
    public FuncionarioService funcionarioService;

    @Inject
    public ClienteService clienteService;

    @Inject
    public HashService hashService;

    @Inject
    public JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

    @POST
    public Response login(AuthUsuarioDTO dto) {
        try {
            String hashSenha = hashService.getHashSenha(dto.senha());

            UsuarioResponseDTO usuario = null;
    
            if(dto.perfil() == 1){
                usuario = funcionarioService.login(dto.username(), hashSenha);
            } else if (dto.perfil() == 2){
                usuario = clienteService.login(dto.username(), hashSenha);
            } else {
                return Response.status(Status.NOT_FOUND).header("Perfil", "perfis: 1-funcionario ou 2-cliente").build();
            }
    
            if(usuario != null){
                return Response.ok(usuario).header("Authorization", jwtService.generateJwt(dto, usuario))
                                .status(Status.CREATED)
                                .build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            LOG.error("Erro durante o login. Verifique seu username ou senha!");
            throw new ValidationException("Verificando", "Erro durante o login. Verifique seu username ou senha! - Executando AuthResource_Login");
        }
        
    }
}


