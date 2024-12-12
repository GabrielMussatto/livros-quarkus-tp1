package br.unitins.topicos1.dto.Response;

import java.time.LocalDate;

import br.unitins.topicos1.model.sugestao.Sugestao;

public record SugestaoResponseDTO(
    Long idSugestao,
    Long idCliente,
    String nomeCliente,
    String usernameCliente,
    String sugestao,
    LocalDate dataSugestao
) {
    public static SugestaoResponseDTO valueOf(Sugestao sugestao){
        return new SugestaoResponseDTO(
            sugestao.getId(), 
            sugestao.getCliente().getId(), 
            sugestao.getCliente().getUsuario().getNome(),
            sugestao.getCliente().getUsuario().getUsername(),
            sugestao.getSugestao(), 
            sugestao.getDataSugestao()
        );
    }
}
