package com.cgsti.cgsti.exceptions;

public class EquipamentoJaExisteException extends Exception{

    public EquipamentoJaExisteException(String s) {
        super("Já existe um equipamento com esse id");
    }
}
