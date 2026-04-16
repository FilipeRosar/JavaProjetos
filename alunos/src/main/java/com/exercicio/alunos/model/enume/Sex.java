package com.exercicio.alunos.model.enume;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sex {
    FEMININO("Feminino"),
    MASCULINO("Masculino"),
    OUTRO("Outro");

    private final String descricao;


    Sex(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Sex fromValue(String value){
        for (Sex sex : Sex.values()) {
            if (sex.descricao.equalsIgnoreCase(value)){
                return sex;
            }
        }
        throw new IllegalArgumentException("Sexo invalido" + value);
    }
}

