package br.unitins.topicos1.dto;

import java.time.LocalDate;

public record CartaoCreditoDTO(
    String numeroCartao,
    String nomeImpressaoTitular,
    Integer cvc,
    LocalDate validade,
    String cpfTitular,
    Integer bandeiraCartao
) {}
