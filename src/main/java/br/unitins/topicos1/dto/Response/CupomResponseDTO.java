package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.cupom.Cupom;

public record CupomResponseDTO (
    Long id,
    String nomeCupom,
    Double desconto
    
) {

    public static CupomResponseDTO valueOf(Cupom cupom){
        return new CupomResponseDTO(
            cupom.getId(), 
            cupom.getNomeCupom(), 
            cupom.getDesconto());
    } 
}
