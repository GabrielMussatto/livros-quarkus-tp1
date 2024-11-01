package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FornecedorDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O nome deve possuir no min 2 e no max 60 caracteres")
    String nome, 
    @NotBlank(message = "O cnpj não pode ser nulo ou vazio")
    @Size(min = 18, max = 18, message = "O cnpj deve possuir no min 18 e no max 18 caracteres")
    String cnpj, 
    @NotBlank(message = "A Inscrição Estadual não pode ser nula ou vazia")
    @Size(min = 12, max = 12, message = "O nome deve possuir no min 12 e no max 12 caracteres")
    String inscricaoEstadual, 
    @Email(message= "E-mail inválido.")
	@NotEmpty(message = "O E-mail deve ser informado.")
    String email, 
    @NotBlank(message = "O endereço não pode ser nulo ou vazio")
    @Size(min = 2, max = 60, message = "O endereço deve possuir no min 2 e no max 60 caracteres")
    String endereco, 
    @NotBlank(message = "O cep não pode ser nulo ou vazio")
    @Size(min = 8, max = 8, message = "O cep deve possuir no min 8 e no max 8 caracteres")
    String cep, 
    String estado, 
    String cidade, 
    TelefoneDTO telefone, 
    @NotNull(message = "A quantidade de livros fornecidos não pode ser nulo ou vazio")
    Integer quantLivrosFornecido
) {}
