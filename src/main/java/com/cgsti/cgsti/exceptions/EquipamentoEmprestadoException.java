package com.cgsti.cgsti.exceptions;


public class EquipamentoEmprestadoException extends RuntimeException {
    public EquipamentoEmprestadoException() {
        super("Finalize a reserva que está vinculado ao equipamento antes de excluí-lo.");
    }
}