package com.viagem.subsistemas.carro;

public class AluguelCarro {
    public static double calcularTotalCarro(TipoCarro tipo, int dias) {
        return tipo.getPrecoDiaria() * dias;
    }
}