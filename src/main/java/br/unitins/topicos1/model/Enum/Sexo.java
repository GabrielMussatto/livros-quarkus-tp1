package br.unitins.topicos1.model.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT) // Quarkus vai entender Enum como objeto na hora de retornar
public enum Sexo {
    MASCULINO (1, "Masculino"),
    FEMININO (2, "Feminino");

    private int id;
    private String nome;

    Sexo(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public static Sexo valueOf(Integer id) throws IllegalArgumentException{
        for (Sexo sexo : Sexo.values()){
            if (sexo.id == id)
                return sexo;
        }
        throw new IllegalArgumentException("Id Sexo Inválido!");
    }
}
