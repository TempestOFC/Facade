package com.viagem.subsistemas.carro;

public enum TipoCarro {
    ECONOMICO(150.0),
    EXECUTIVO(150.0 * 2.0),   // +100% = 300
    LUXO(300.0 * 2.0);        // +100% = 600

    private final double precoDiaria;
    TipoCarro(double preco) { this.precoDiaria = preco; }
    public double getPrecoDiaria() { return precoDiaria; }

    @Override
    public String toString() {
        return switch (this) {
            case ECONOMICO -> "Econômico";
            case EXECUTIVO -> "Executivo";
            case LUXO -> "Luxo";
        };
    }
}