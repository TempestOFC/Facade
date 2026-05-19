package com.viagem.subsistemas.hotel;

public class ReservaHotel {
    public static double calcularTotalHotel(TipoQuarto tipo, int diarias, int pessoas) {
        return tipo.getPrecoPorPessoaDiaria() * diarias * pessoas;
    }
}