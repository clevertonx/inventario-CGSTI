package com.cgsti.cgsti.exceptions;

public class EquipamentoNaoEncontradoException extends Exception{

    public EquipamentoNaoEncontradoException(String s) {
        super("Já existe um equipamento com esse id");
    }
}
