package com.viagem.subsistemas.aereo;

import java.util.HashSet;
import java.util.Set;

public class ReservaPassagem {
    private static final Set<String> assentosOcupados = new HashSet<>();

    public static Assento reservarAssento(int fileira, char letra) throws Exception {
        if (fileira < 1 || fileira > 32)
            throw new Exception("Fileira inválida! Use 1-32.");
        letra = Character.toUpperCase(letra);
        if (!(letra >= 'A' && letra <= 'F'))
            throw new Exception("Letra inválida! Use A-F.");
        String codigo = fileira + "" + letra;
        if (assentosOcupados.contains(codigo))
            throw new Exception("Assento já ocupado.");
        assentosOcupados.add(codigo);
        return new Assento(fileira, letra);
    }

    public static double calcularPrecoPassagem(Assento assento) {
        return assento.getPreco();
    }
}