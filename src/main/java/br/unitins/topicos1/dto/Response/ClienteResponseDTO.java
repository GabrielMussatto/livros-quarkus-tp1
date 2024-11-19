package br.unitins.topicos1.dto.Response;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Cliente;
import br.unitins.topicos1.model.livro.Livro;

public record ClienteResponseDTO(
    Long id,
    String cep,
    String endereco,
    String estado,
    String cidade,
    UsuarioResponseDTO usuario,
    List<LivroResponseDTO> listaFavorito

) {
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getCep(),
            cliente.getEndereco(),
            cliente.getEstado(),
            cliente.getCidade(),
            UsuarioResponseDTO.valueOf(cliente.getUsuario()),
            cliente.getListaFavorito().stream().map(LivroResponseDTO::valueOf).toList());
    }
}
