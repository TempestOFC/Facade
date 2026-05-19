package com.viagem.subsistemas.pagamento;

public class ProcessadorPagamento {
    public static class Resultado {
        public double valorFinal;
        public double diferenca;
        public String forma;
        public int parcelas;
    }

    public static Resultado processar(double valorBase, String forma, int parcelas) throws Exception {
        Resultado res = new Resultado();
        res.forma = forma;
        res.parcelas = parcelas;
        double finalVal = valorBase;

        switch (forma.toUpperCase()) {
            case "PIX": finalVal = valorBase * 0.9; res.diferenca = -valorBase * 0.1; break;
            case "BOLETO": finalVal = valorBase * 0.95; res.diferenca = -valorBase * 0.05; break;
            case "DEBITO": res.diferenca = 0; break;
            case "CREDITO":
                if (parcelas < 1 || parcelas > 6) throw new Exception("Parcelas 1-6");
                if (parcelas > 1) {
                    double acrescimo = valorBase * (parcelas - 1) * 0.0399;
                    finalVal = valorBase + acrescimo;
                    res.diferenca = acrescimo;
                } else res.diferenca = 0;
                break;
            default: throw new Exception("Forma inválida");
        }
        res.valorFinal = finalVal;
        return res;
    }
}