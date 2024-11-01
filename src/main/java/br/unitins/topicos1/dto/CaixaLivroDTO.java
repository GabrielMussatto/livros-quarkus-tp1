package br.unitins.topicos1.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CaixaLivroDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O nome deve possuir no min 2 e no max 60 caracteres")
    String nome,
    
    @NotBlank(message = "A descrição não pode ser nula ou vazia")
    @Size(min = 2, max = 20000, message = "A descrição deve possuir no min 2 e no max 20000 caracteres")
    String descricao,

    @NotNull(message = "O fornecedor não pode ser nulo ou vazio")
    Long fornecedor,

    @NotNull(message = "A editora não pode ser nula ou vazia")
    Long editora,

    @NotNull(message = "Os generos não podem ser nulos ou vazios")
    List<Long> generos,

    @NotNull(message = "Os autores não podem ser nulos ou vazios")
    List<Long> autores,

    @NotNull(message = "O preço não pode ser nulo ou vazio")
    Double preco,

    @NotNull(message = "A quantidade em estoque não pode ser nula ou vazia")
    Integer quantidadeEstoque,
    
    @NotNull(message = "A classificação não pode ser nula ou vazia")
    Integer classificacao
) { }
