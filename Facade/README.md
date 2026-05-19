# 🧳 Sistema de Pacote de Viagens - Facade

Sistema console em Java usando padrão Facade para venda de pacotes de viagem (passagem + hotel + carro + pagamento).

## Como executar

1. Crie todas as pastas listadas acima e coloque cada arquivo no local indicado.
2. Abra o terminal na pasta `Facade`
3. Compile:
   ```bash
   javac -d out src/main/java/com/viagem/**/*.java src/main/java/com/viagem/Main.java

4. Execute

java -cp out com.viagem.Main


Funcionalidades
Reserva de assento (fileira 1-32, letra A-F) com classe automática e preço diferenciado.

Escolha de quarto de hotel (Simples, Executivo, Suíte) com preço por pessoa/diária.

Aluguel de carro (Econômico, Executivo, Luxo).

Pagamento: PIX (10% off), Boleto (5% off), Débito, Crédito (1-6x, acréscimo 3,99% a partir da 2ª parcela).

Exibe dados dos clientes, itens escolhidos, valor base, desconto/acréscimo e valor final.



Estrutura de pastas (resumo)

Facade/
└── src/main/java/com/viagem/
    ├── model/            (Cliente, PacoteViagem)
    ├── subsistemas/
    │   ├── aereo/        (ClasseVoo, Assento, ReservaPassagem)
    │   ├── hotel/        (TipoQuarto, ReservaHotel)
    │   ├── carro/        (TipoCarro, AluguelCarro)
    │   └── pagamento/    (ProcessadorPagamento)
    ├── facade/           (PacoteViagemFacade)
    └── Main.java


    
---

## ✅ Resumo final das pastas e arquivos (para você criar na mão)

| Pasta | Arquivo |
|-------|---------|
| `Facade/src/main/java/com/viagem/model/` | `Cliente.java`, `PacoteViagem.java` |
| `Facade/src/main/java/com/viagem/subsistemas/aereo/` | `ClasseVoo.java`, `Assento.java`, `ReservaPassagem.java` |
| `Facade/src/main/java/com/viagem/subsistemas/hotel/` | `TipoQuarto.java`, `ReservaHotel.java` |
| `Facade/src/main/java/com/viagem/subsistemas/carro/` | `TipoCarro.java`, `AluguelCarro.java` |
| `Facade/src/main/java/com/viagem/subsistemas/pagamento/` | `ProcessadorPagamento.java` |
| `Facade/src/main/java/com/viagem/facade/` | `PacoteViagemFacade.java` |
| `Facade/src/main/java/com/viagem/` | `Main.java` |
| `Facade/` | `README.md` |

Agora é só criar essas pastas e copiar cada código para o arquivo correspondente. O projeto está pronto para compilar e rodar.