package br.unitins.topicos1.dto.Response;

import java.util.List;

import br.unitins.topicos1.model.Enum.Classificacao;
import br.unitins.topicos1.model.caixa.CaixaLivro;

public record CaixaLivroResponseDTO(
        Long id,
        String nome,
        String descricao,
        FornecedorResponseDTO fornecedor,
        EditoraResponseDTO editora,
        List<AutorResponseDTO> autores,
        List<GeneroResponseDTO> generos,
        Double preco,
        Integer quantidadeEstoque,
        Classificacao classificacao,
        String nomeImagem) {
    public static CaixaLivroResponseDTO valueOf(CaixaLivro caixaLivro) {
        // Transformar listas de autores e gêneros em suas respectivas DTOs
        List<AutorResponseDTO> listaAutor = caixaLivro.getListaAutores()
                .stream()
                .map(AutorResponseDTO::valueOf)
                .toList();

        List<GeneroResponseDTO> listaGenero = caixaLivro.getListaGeneros()
                .stream()
                .map(GeneroResponseDTO::valueOf)
                .toList();

        // Avaliar o status do estoque
        // String statusEstoque = caixaLivro.getQuantidadeEstoque() > 0 ? "Disponível" :
        // "Estoque esgotado";

        // Construir o DTO
        return new CaixaLivroResponseDTO(
                caixaLivro.getId(),
                caixaLivro.getNome(),
                caixaLivro.getDescricao(),
                FornecedorResponseDTO.valueOf(caixaLivro.getFornecedor()),
                EditoraResponseDTO.valueOf(caixaLivro.getEditora()),
                listaAutor,
                listaGenero,
                caixaLivro.getPreco(),
                caixaLivro.getQuantidadeEstoque(),
                // statusEstoque,
                caixaLivro.getClassificacao(),
                caixaLivro.getNomeImagem());
    }
}