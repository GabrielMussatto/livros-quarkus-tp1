package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;

import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Cliente;

public record CadastroBasicoResponseDTO(
        Long id,
        String username,
        String nome,
        String email,
        String cpf,
        Sexo sexo,
        LocalDate dataNascimento,
        TelefoneResponseDTO telefone,
        String estado,
        String sigla,
        String cidade,
        String cep,
        String endereco
) {

    public static CadastroBasicoResponseDTO valueOf(Cliente cliente) {
        return new CadastroBasicoResponseDTO(
            cliente.getId(), 
            cliente.getUsuario().getUsername(),
            cliente.getUsuario().getNome(),
            cliente.getUsuario().getEmail(),
            cliente.getUsuario().getCpf(),
            cliente.getUsuario().getSexo(),
            cliente.getUsuario().getDataNascimento(),
            TelefoneResponseDTO.valueOf(cliente.getUsuario().getTelefone()),
            cliente.getEstado(),
            cliente.getSigla(),
            cliente.getCidade(),
            cliente.getCep(),
            cliente.getEndereco()
        );
    }
}
