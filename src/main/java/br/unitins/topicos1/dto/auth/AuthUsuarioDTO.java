package br.unitins.topicos1.dto.auth;

public record AuthUsuarioDTO(
    String username,
    String senha,
    int perfil
) {
    
}
