package br.unitins.topicos1.dto.Response;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.Cliente;

public record ClienteResponseDTO(
    Long id,
    String cep,
    String endereco,
    String estado,
    String sigla,
    String cidade,
    UsuarioResponseDTO usuario,
    List<ItemFavoritoResponseDTO> listaFavorito

) {
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getCep(),
            cliente.getEndereco(),
            cliente.getEstado(),
            cliente.getSigla(),
            cliente.getCidade(),
            UsuarioResponseDTO.valueOf(cliente.getUsuario()),
            cliente.getListaFavorito().stream().map(ItemFavoritoResponseDTO::valueOf).toList());
    }
}
