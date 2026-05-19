package com.viagem.facade;

import com.viagem.model.*;
import com.viagem.subsistemas.aereo.*;
import com.viagem.subsistemas.carro.*;
import com.viagem.subsistemas.hotel.*;
import com.viagem.subsistemas.pagamento.*;
import java.util.List;

public class PacoteViagemFacade {

    public PacoteViagem comprarPacote(
            List<Cliente> clientes,
            int fileira, char letra,
            TipoQuarto tipoQuarto, int diariasHotel, int pessoasHotel,
            TipoCarro tipoCarro, int diasCarro,
            String formaPagamento, int parcelas) throws Exception {

        PacoteViagem pacote = new PacoteViagem();
        pacote.setClientes(clientes);

        Assento assento = ReservaPassagem.reservarAssento(fileira, letra);
        pacote.setAssento(assento);
        double valorPassagem = ReservaPassagem.calcularPrecoPassagem(assento);

        double totalHotel = ReservaHotel.calcularTotalHotel(tipoQuarto, diariasHotel, pessoasHotel);
        pacote.setTipoQuarto(tipoQuarto);
        pacote.setNumeroDiariasHotel(diariasHotel);
        pacote.setQuantidadePessoasHotel(pessoasHotel);

        double totalCarro = AluguelCarro.calcularTotalCarro(tipoCarro, diasCarro);
        pacote.setTipoCarro(tipoCarro);
        pacote.setDiasAluguelCarro(diasCarro);

        double valorBase = valorPassagem + totalHotel + totalCarro;
        pacote.setValorBase(valorBase);

        var resultado = ProcessadorPagamento.processar(valorBase, formaPagamento, parcelas);
        pacote.setValorFinal(resultado.valorFinal);
        pacote.setDescontoOuAcrescimo(resultado.diferenca);
        pacote.setFormaPagamento(resultado.forma);
        pacote.setParcelas(resultado.parcelas);

        return pacote;
    }
}