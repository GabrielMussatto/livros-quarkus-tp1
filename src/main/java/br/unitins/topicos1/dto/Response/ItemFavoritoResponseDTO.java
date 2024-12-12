package br.unitins.topicos1.dto.Response;

import java.util.List;

import br.unitins.topicos1.model.Pessoa.ItemFavorito;

public record ItemFavoritoResponseDTO(
    Long id,
    String tipo,
    String nome,
    String descricao,
    Double preco,
    List<AutorResponseDTO> autores,
    String imagemUrl
) {
    public static ItemFavoritoResponseDTO valueOf(ItemFavorito item){
        if (item.getLivro() != null) {
            return new ItemFavoritoResponseDTO(
                item.getId(),
                "Livro",
                item.getLivro().getTitulo(),
                item.getLivro().getDescricao(),
                item.getLivro().getPreco(),
                item.getLivro().getListaAutor() != null
                    ? item.getLivro().getListaAutor().stream()
                        .map(AutorResponseDTO::valueOf)
                        .toList()
                    : List.of(), // Verifica se a lista de autores é nula
                item.getLivro().getNomeImagem() // Retorna o nome da imagem do livro
            );
        }
        if (item.getCaixaLivro() != null) {
            return new ItemFavoritoResponseDTO(
                item.getId(),
                "CaixaLivro",
                item.getCaixaLivro().getNome(),
                item.getCaixaLivro().getDescricao(),
                item.getCaixaLivro().getPreco(),
                item.getCaixaLivro().getListaAutores() != null
                    ? item.getCaixaLivro().getListaAutores().stream()
                        .map(AutorResponseDTO::valueOf)
                        .toList()
                    : List.of(), // Verifica se a lista de autores é nula
                item.getCaixaLivro().getNomeImagem() // Retorna o nome da imagem da caixa de livro
            );
        }
        throw new IllegalArgumentException("Item inválido, não possui Caixa de Livro ou Livro relacionado.");
    }
}
