package br.unitins.topicos1.dto.Response;

import java.util.List;

import br.unitins.topicos1.model.favorito.Favorito;

public record FavoritoResponseDTO(
    Long id,
    ClienteResponseDTO cliente,
    List<LivroResponseDTO> livro,
    List<CaixaLivroResponseDTO> caixaLivro
) {
    public static FavoritoResponseDTO valueOf(Favorito favoritos) {
        // Mapear as listas de livros e caixas de livros para suas respectivas DTOs, permitindo null ou listas vazias
        List<LivroResponseDTO> listaLivros = (favoritos.getListaLivrosFavoritos() != null)
                ? favoritos.getListaLivrosFavoritos()
                        .stream()
                        .map(LivroResponseDTO::valueOf)
                        .toList()
                : List.of();

        List<CaixaLivroResponseDTO> listaCaixasLivros = (favoritos.getListaCaixasLivrosFavoritos() != null)
                ? favoritos.getListaCaixasLivrosFavoritos()
                        .stream()
                        .map(CaixaLivroResponseDTO::valueOf)
                        .toList()
                : List.of();

        return new FavoritoResponseDTO(
                favoritos.getId(),
                ClienteResponseDTO.valueOf(favoritos.getCliente()),
                listaLivros,
                listaCaixasLivros
        );
    }
}
