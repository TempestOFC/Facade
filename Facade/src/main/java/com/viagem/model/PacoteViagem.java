package com.viagem.model;

import com.viagem.subsistemas.aereo.Assento;
import com.viagem.subsistemas.hotel.TipoQuarto;
import com.viagem.subsistemas.carro.TipoCarro;
import java.util.List;

public class PacoteViagem {
    private List<Cliente> clientes;
    private Assento assento;
    private TipoQuarto tipoQuarto;
    private int numeroDiariasHotel;
    private int quantidadePessoasHotel;
    private TipoCarro tipoCarro;
    private int diasAluguelCarro;
    private double valorBase;
    private double valorFinal;
    private String formaPagamento;
    private int parcelas;
    private double descontoOuAcrescimo;

    // Getters e Setters
    public List<Cliente> getClientes() { return clientes; }
    public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }
    public Assento getAssento() { return assento; }
    public void setAssento(Assento assento) { this.assento = assento; }
    public TipoQuarto getTipoQuarto() { return tipoQuarto; }
    public void setTipoQuarto(TipoQuarto tipoQuarto) { this.tipoQuarto = tipoQuarto; }
    public int getNumeroDiariasHotel() { return numeroDiariasHotel; }
    public void setNumeroDiariasHotel(int numeroDiariasHotel) { this.numeroDiariasHotel = numeroDiariasHotel; }
    public int getQuantidadePessoasHotel() { return quantidadePessoasHotel; }
    public void setQuantidadePessoasHotel(int quantidadePessoasHotel) { this.quantidadePessoasHotel = quantidadePessoasHotel; }
    public TipoCarro getTipoCarro() { return tipoCarro; }
    public void setTipoCarro(TipoCarro tipoCarro) { this.tipoCarro = tipoCarro; }
    public int getDiasAluguelCarro() { return diasAluguelCarro; }
    public void setDiasAluguelCarro(int diasAluguelCarro) { this.diasAluguelCarro = diasAluguelCarro; }
    public double getValorBase() { return valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }
    public double getValorFinal() { return valorFinal; }
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public int getParcelas() { return parcelas; }
    public void setParcelas(int parcelas) { this.parcelas = parcelas; }
    public double getDescontoOuAcrescimo() { return descontoOuAcrescimo; }
    public void setDescontoOuAcrescimo(double descontoOuAcrescimo) { this.descontoOuAcrescimo = descontoOuAcrescimo; }

    public void imprimirComprovante() {
        System.out.println("\n=== COMPROVANTE DE PACOTE DE VIAGEM ===");
        System.out.println("CLIENTES:");
        for (Cliente c : clientes) System.out.println("  " + c);
        System.out.println("\nDETALHES DA COMPRA:");
        System.out.println("  Poltrona: " + assento);
        System.out.println("  Hotel: " + tipoQuarto + " - " + numeroDiariasHotel + " diárias para " + quantidadePessoasHotel + " pessoa(s)");
        System.out.println("  Carro: " + tipoCarro + " - " + diasAluguelCarro + " dia(s)");
        System.out.println("\nValor base do pacote: R$ " + String.format("%.2f", valorBase));
        System.out.println("Forma de pagamento: " + formaPagamento + (parcelas>0 ? " em " + parcelas + "x" : ""));
        System.out.println("Desconto/ Acréscimo: R$ " + String.format("%.2f", descontoOuAcrescimo));
        System.out.println("Valor final: R$ " + String.format("%.2f", valorFinal));
        System.out.println("=======================================");
    }
}