package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.autor.Autor;

public record AutorResponseDTO(Long id, String nome, String biografia, String nomeImagem) {

    public static AutorResponseDTO valueOf(Autor autor){
        return new AutorResponseDTO(
            autor.getId(),
            autor.getNome(),
            autor.getBiografia(),
            autor.getNomeImagem());
    }
    
}
