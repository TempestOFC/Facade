package com.viagem.subsistemas.aereo;

public enum ClasseVoo {
    ECONOMICA(500.0),
    EXECUTIVA(500.0 * 3.5),      // 250% a mais = 1750
    PRIMEIRA_CLASSE(1750.0 * 2.5); // 150% a mais = 4375

    private final double precoBase;

    ClasseVoo(double precoBase) { this.precoBase = precoBase; }
    public double getPrecoBase() { return precoBase; }

    public static ClasseVoo fromFileira(int fileira) {
        if (fileira >= 1 && fileira <= 3) return PRIMEIRA_CLASSE;
        if (fileira >= 4 && fileira <= 8) return EXECUTIVA;
        return ECONOMICA;
    }
}