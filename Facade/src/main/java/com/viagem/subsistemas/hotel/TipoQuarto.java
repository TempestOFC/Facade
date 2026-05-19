package com.viagem.subsistemas.hotel;

public enum TipoQuarto {
    SIMPLES(200.0),
    EXECUTIVO(200.0 * 2.5),          // +150% = 500
    SUITE_PRESIDENCIAL(500.0 * 4.0); // +300% = 2000

    private final double precoPorPessoaDiaria;
    TipoQuarto(double preco) { this.precoPorPessoaDiaria = preco; }
    public double getPrecoPorPessoaDiaria() { return precoPorPessoaDiaria; }

    @Override
    public String toString() {
        return switch (this) {
            case SIMPLES -> "Quarto Simples";
            case EXECUTIVO -> "Quarto Executivo";
            case SUITE_PRESIDENCIAL -> "Suíte Presidencial";
        };
    }
}