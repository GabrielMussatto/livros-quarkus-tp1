package br.unitins.topicos1.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LivroDTO(
        @NotBlank(message = "O titulo não pode ser nulo ou vazio")
        @Size(min = 2, max = 60, message = "O titulo deve possuir no min 2 e no max 60 caracteres") 
        String titulo,
        @NotBlank(message = "A descrição não pode ser nula ou vazia") 
        @Size(min = 2, max = 999999, message = "A descrição deve possuir no min 2 e no max 999999 caracteres") 
        String descricao,
        @NotNull(message = "A quantidade em estoque não pode ser nula ou vazia")
        Integer quantidadeEstoque,
        @NotBlank(message = "O isbn não pode ser nulo ou vazio")
        @Size(min = 13, max = 13, message = "O isbn deve possuir no min 13 e no max 13 caracteres")
        String isbn,
        @NotNull(message = "O preço não pode ser nulo ou vazio")
        Double preco,
        @NotNull(message = "A classificação não pode ser nula ou vazia")
        Integer classificacao,
        @NotNull(message = "A data de lançamento não pode ser nula ou vazia")
        LocalDate datalancamento,
        @NotNull(message = "O fornecedor não pode ser nulo ou vazio")
        Long fornecedor,
        @NotNull(message = "A editora não pode ser nulo ou vazio")
        Long editora,
        @NotNull(message = "Os autores não podem ser nulos ou vazios")
        List<Long> autores,
        @NotNull(message = "Os generos não podem ser nulos ou vazios")
        List<Long> generos) {
}
