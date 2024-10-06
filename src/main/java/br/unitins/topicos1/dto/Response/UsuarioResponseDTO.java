package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;

import br.unitins.topicos1.model.Enum.Sexo;
import br.unitins.topicos1.model.Pessoa.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String username,
    LocalDate dataNascimento,
    String email,
    TelefoneResponseDTO telefone,
    Sexo sexo,
    String cpf
 
) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(), 
            usuario.getUsername(),
            usuario.getDataNascimento(),
            usuario.getEmail(),
            TelefoneResponseDTO.valueOf(usuario.getTelefone()), 
            usuario.getSexo(),
            usuario.getCpf()
        );
    }
}
