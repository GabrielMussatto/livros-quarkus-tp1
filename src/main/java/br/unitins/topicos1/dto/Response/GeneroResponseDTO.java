package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.genero.Genero;

public record GeneroResponseDTO(
    Long id,  
    String nome, 
    String descricao
) {
    public static GeneroResponseDTO valueOf(Genero genero){
        return new GeneroResponseDTO(
            genero.getId(),
            genero.getNome(),
            genero.getDescricao()
        );
    }
}
