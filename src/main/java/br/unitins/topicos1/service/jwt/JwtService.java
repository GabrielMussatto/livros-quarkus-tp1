package br.unitins.topicos1.service.jwt;

import br.unitins.topicos1.dto.Response.UsuarioResponseDTO;
import br.unitins.topicos1.dto.auth.AuthUsuarioDTO;

public interface JwtService {
    String generateJwt(AuthUsuarioDTO authDTO, UsuarioResponseDTO dto);
}
