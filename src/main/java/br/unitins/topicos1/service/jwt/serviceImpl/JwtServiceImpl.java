package br.unitins.topicos1.service.jwt.serviceImpl;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.dto.auth.AuthUsuarioDTO;
import br.unitins.topicos1.service.jwt.JwtService;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofDays(365);

    @Override
    public String generateJwt(AuthUsuarioDTO authDTO, UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        Set<String> roles = new HashSet<String>();
    
        if(authDTO.perfil() == 1){
            roles.add("Funcionario");
        }else if (authDTO.perfil() == 2){
            roles.add("Cliente");
        }
      
        return Jwt.issuer("unitins-jwt")
            .claim("id", dto.id())
            .subject(dto.username())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }
    
}
