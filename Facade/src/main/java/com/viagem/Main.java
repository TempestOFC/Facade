package com.viagem;

import com.viagem.facade.PacoteViagemFacade;
import com.viagem.model.Cliente;
import com.viagem.model.PacoteViagem;
import com.viagem.subsistemas.carro.TipoCarro;
import com.viagem.subsistemas.hotel.TipoQuarto;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PacoteViagemFacade facade = new PacoteViagemFacade();

        try {
            System.out.print("Quantas pessoas? ");
            int num = Integer.parseInt(sc.nextLine());
            List<Cliente> clientes = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                System.out.println("Cliente " + i);
                System.out.print("  Nome: ");
                String nome = sc.nextLine();
                System.out.print("  CPF: ");
                String cpf = sc.nextLine();
                clientes.add(new Cliente(nome, cpf));
            }

            System.out.println("\n--- ASSENTO ---");
            System.out.print("Fileira (1-32): ");
            int fileira = Integer.parseInt(sc.nextLine());
            System.out.print("Letra (A-F): ");
            char letra = sc.nextLine().charAt(0);

            System.out.println("\n--- HOTEL ---");
            System.out.println("1-Simples 2-Executivo 3-Suíte");
            int opHotel = Integer.parseInt(sc.nextLine());
            TipoQuarto quarto = switch (opHotel) {
                case 1 -> TipoQuarto.SIMPLES;
                case 2 -> TipoQuarto.EXECUTIVO;
                default -> TipoQuarto.SUITE_PRESIDENCIAL;
            };
            System.out.print("Diárias: ");
            int diarias = Integer.parseInt(sc.nextLine());
            System.out.print("Pessoas no quarto: ");
            int pessHotel = Integer.parseInt(sc.nextLine());

            System.out.println("\n--- CARRO ---");
            System.out.println("1-Econômico 2-Executivo 3-Luxo");
            int opCarro = Integer.parseInt(sc.nextLine());
            TipoCarro carro = switch (opCarro) {
                case 1 -> TipoCarro.ECONOMICO;
                case 2 -> TipoCarro.EXECUTIVO;
                default -> TipoCarro.LUXO;
            };
            System.out.print("Dias: ");
            int diasCarro = Integer.parseInt(sc.nextLine());

            System.out.println("\n--- PAGAMENTO ---");
            System.out.print("Forma (PIX/BOLETO/DEBITO/CREDITO): ");
            String forma = sc.nextLine().toUpperCase();
            int parcelas = 0;
            if (forma.equals("CREDITO")) {
                System.out.print("Parcelas (1-6): ");
                parcelas = Integer.parseInt(sc.nextLine());
            }

            PacoteViagem pacote = facade.comprarPacote(clientes, fileira, letra,
                    quarto, diarias, pessHotel, carro, diasCarro, forma, parcelas);
            pacote.imprimirComprovante();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}