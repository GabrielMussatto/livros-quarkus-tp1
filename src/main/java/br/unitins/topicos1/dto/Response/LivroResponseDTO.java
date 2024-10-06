package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.livro.Livro;

public record LivroResponseDTO(
        Long id,
        String titulo,
        List<AutorResponseDTO> autores,
        EditoraResponseDTO editora,
        List<GeneroResponseDTO> generos,
        String preco,
        String quantidadeEstoque,
        String isbn,
        LocalDate datalancamento,
        Classificacao id_classificacao,
        String descricao,
        FornecedorResponseDTO fornecedor, 
        String nomeImagem
) {
    public static LivroResponseDTO valueOf(Livro livro) {
                                                List<AutorResponseDTO> listaAutor = livro.getListaAutor()
                                                                        .stream()
                                                                        .map(AutorResponseDTO::valueOf)
                                                                        .toList();
                                                List<GeneroResponseDTO> listaGenero = livro.getListaGenero()
                                                                        .stream()
                                                                        .map(GeneroResponseDTO::valueOf)
                                                                        .toList();
        return new LivroResponseDTO(
                livro.getId(),
                livro.getTitulo(),
                listaAutor,
                EditoraResponseDTO.valueOf(livro.getEditora()),
                listaGenero,
                "R$" + String.format("%.2f",livro.getPreco()),
                livro.getQuantidadeEstoque() > 0 ? "Disponível" : "Estoque esgotado",
                livro.getIsbn(),
                livro.getDatalancamento(),
                livro.getClassificacao(),
                livro.getDescricao(),
                FornecedorResponseDTO.valueOf(livro.getFornecedor()),
                livro.getNomeImagem());
    }
}
