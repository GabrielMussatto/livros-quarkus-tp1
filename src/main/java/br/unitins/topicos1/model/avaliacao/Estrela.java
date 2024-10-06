package br.unitins.topicos1.model.avaliacao;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Estrela {

    ESTRELA1(1, "⭐"),
    ESTRELA2(2, "⭐⭐"),
    ESTRELA3(3, "⭐⭐⭐"),
    ESTRELA4(4, "⭐⭐⭐⭐"),
    ESTRELA5(5, "⭐⭐⭐⭐⭐");

    private int id;
    private String label;

    Estrela(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Estrela valueOf(Integer id) throws IllegalArgumentException {
        if (id == null) {
            return null;
        }

        for (Estrela estrela : Estrela.values()) {
            if (id.equals(estrela.getId())) {
                return estrela;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
  
}
