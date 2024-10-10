package br.unitins.topicos1.dto.Response;

import java.util.List;
import java.time.format.DateTimeFormatter;

import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.livro.Livro;

public record LivroResponseDTO(
        Long id,
        String titulo,
        String descricao,
        Integer quantidadeEstoque,
        String isbn,
        Double preco,
        Classificacao classificacao,
        String datalancamento,
        FornecedorResponseDTO fornecedor, 
        EditoraResponseDTO editora,
        List<AutorResponseDTO> autores,
        List<GeneroResponseDTO> generos,
        String nomeImagem
) {
        private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
                livro.getDescricao(),
                livro.getQuantidadeEstoque(), // > 0 ? "Disponível" : "Estoque esgotado",
                livro.getIsbn(),
                livro.getPreco(),
                livro.getClassificacao(),
                livro.getDatalancamento().format(formatter),
                FornecedorResponseDTO.valueOf(livro.getFornecedor()),
                EditoraResponseDTO.valueOf(livro.getEditora()),
                listaAutor,
                listaGenero,
                livro.getNomeImagem());
    }
}
