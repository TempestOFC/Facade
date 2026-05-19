package com.viagem.subsistemas.aereo;

public class Assento {
    private int fileira;
    private char letra;
    private ClasseVoo classe;
    private String localizacao;

    public Assento(int fileira, char letra) {
        this.fileira = fileira;
        this.letra = Character.toUpperCase(letra);
        this.classe = ClasseVoo.fromFileira(fileira);
        if (letra == 'A' || letra == 'F') localizacao = "Janela";
        else if (letra == 'B' || letra == 'E') localizacao = "Meio";
        else localizacao = "Corredor";
    }

    public int getFileira() { return fileira; }
    public char getLetra() { return letra; }
    public ClasseVoo getClasse() { return classe; }
    public String getLocalizacao() { return localizacao; }
    public double getPreco() { return classe.getPrecoBase(); }

    @Override
    public String toString() {
        return String.format("%d%c (%s - %s)", fileira, letra, classe, localizacao);
    }
}