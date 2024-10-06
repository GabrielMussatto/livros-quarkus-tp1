package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record FornecedorDTO(
    String nome, 
    String cnpj, 
    String inscricaoEstadual, 
    @Email(message= "E-mail inválido.")
	@NotEmpty(message = "O E-mail deve ser informado.")
    String email, 
    String endereco, 
    String cep, 
    String estado, 
    String cidade, 
    TelefoneDTO telefone, 
    Integer quantLivrosFornecido
) {}
