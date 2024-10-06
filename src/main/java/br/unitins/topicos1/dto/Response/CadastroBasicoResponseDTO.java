package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Cliente;

public record CadastroBasicoResponseDTO(
        Long id,
        String nome,
        String email,
        String username,
        Sexo sexo
) {

    public static CadastroBasicoResponseDTO valueOf(Cliente cliente) {
        return new CadastroBasicoResponseDTO(
            cliente.getId(), 
            cliente.getUsuario().getNome(),
            cliente.getUsuario().getEmail(),
            cliente.getUsuario().getUsername(),
            cliente.getUsuario().getSexo()
        );
    }
}
