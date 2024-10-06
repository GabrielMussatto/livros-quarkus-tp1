package br.unitins.topicos1.model.formaPagamento;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat( shape = JsonFormat.Shape.OBJECT)
public enum BandeiraCartao {

    VISA(1, "Visa"),
    MASTERCARD(2, "Mastercard"),
    ELO(3, "Elo");

    private int id;
    private String label;

    BandeiraCartao(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static BandeiraCartao valueOf(Integer id) throws IllegalArgumentException {
        if (id == null) {
            return null;
        }
        for (BandeiraCartao bandeiraCartao : BandeiraCartao.values()) {
            if (id.equals(bandeiraCartao.getId())) {
                return bandeiraCartao;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}
