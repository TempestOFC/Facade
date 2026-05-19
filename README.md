# ✈️ Sistema de Pacote de Viagens – Padrão Facade

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Pattern](https://img.shields.io/badge/Pattern-Facade-orange.svg)](https://refactoring.guru/design-patterns/facade)

Solução console em **Java puro** que simula a venda de pacotes de viagens completos (passagem aérea, hotel, aluguel de carro e pagamento) utilizando o **Padrão de Projeto Facade** para simplificar a interação com subsistemas complexos.

## 🧠 Visão Geral

O sistema integra quatro subsistemas independentes:

- **Aéreo** – reserva de assento com definição automática de classe (Econômica, Executiva, Primeira Classe) com base na fileira escolhida.
- **Hotel** – escolha de tipo de quarto (Simples, Executivo, Suíte Presidencial) com cálculo de diária por pessoa.
- **Carro** – aluguel de veículos nas categorias Econômico, Executivo e Luxo.
- **Pagamento** – suporte a PIX, Boleto, Débito e Crédito (1 a 6 parcelas) com regras de desconto e acréscimo.

O **Facade** (`PacoteViagemFacade`) expõe um único método que orquestra todas as operações, escondendo a complexidade do cliente.

## 📦 Funcionalidades

- ✅ Cadastro de múltiplos clientes (nome e CPF).
- ✅ Escolha de assento (fileira 1–32, letra A–F).
- ✅ Cálculo automático da classe do voo e preço.
- ✅ Seleção de quarto de hotel com número de diárias e hóspedes.
- ✅ Escolha de categoria de carro com número de dias.
- ✅ Métodos de pagamento com cálculos:
  - PIX → 10% desconto
  - Boleto → 5% desconto
  - Débito → sem acréscimo
  - Crédito → até 6x, acréscimo de 3,99% por parcela a partir da 2ª.
- ✅ Exibição de comprovante detalhado contendo:
  - Dados de todos os clientes
  - Poltrona escolhida
  - Detalhes do hotel e carro
  - Valor base, forma de pagamento, desconto/acréscimo e valor final

## 🗂️ Estrutura do Projeto



Facade/
└── src/main/java/com/viagem/
├── model/
│ ├── Cliente.java
│ └── PacoteViagem.java
├── subsistemas/
│ ├── aereo/
│ │ ├── ClasseVoo.java
│ │ ├── Assento.java
│ │ └── ReservaPassagem.java
│ ├── hotel/
│ │ ├── TipoQuarto.java
│ │ └── ReservaHotel.java
│ ├── carro/
│ │ ├── TipoCarro.java
│ │ └── AluguelCarro.java
│ └── pagamento/
│ └── ProcessadorPagamento.java
├── facade/
│ └── PacoteViagemFacade.java
└── Main.java




## 📊 Diagrama UML (Mermaid)

classDiagram
    class Cliente {
        - String nome
        - String cpf
        + getNome()
        + getCpf()
    }
    class PacoteViagem {
        - List~Cliente~ clientes
        - Assento assento
        - TipoQuarto tipoQuarto
        - int numeroDiariasHotel
        - int quantidadePessoasHotel
        - TipoCarro tipoCarro
        - int diasAluguelCarro
        - double valorBase
        - double valorFinal
        - String formaPagamento
        - int parcelas
        - double descontoOuAcrescimo
        + imprimirComprovante()
    }
    class Assento {
        - int fileira
        - char letra
        - ClasseVoo classe
        - String localizacao
        + getPreco()
    }
    class ClasseVoo {
        <<enum>>
        ECONOMICA
        EXECUTIVA
        PRIMEIRA_CLASSE
        + getPrecoBase()
        + fromFileira()
    }
    class ReservaPassagem {
        + reservarAssento()
        + calcularPrecoPassagem()
    }
    class TipoQuarto {
        <<enum>>
        SIMPLES
        EXECUTIVO
        SUITE_PRESIDENCIAL
        + getPrecoPorPessoaDiaria()
    }
    class ReservaHotel {
        + calcularTotalHotel()
    }
    class TipoCarro {
        <<enum>>
        ECONOMICO
        EXECUTIVO
        LUXO
        + getPrecoDiaria()
    }
    class AluguelCarro {
        + calcularTotalCarro()
    }
    class ProcessadorPagamento {
        + processar()
    }
    class PacoteViagemFacade {
        + comprarPacote()
    }
    class Main {
        + main()
    }
    PacoteViagem *-- Cliente
    PacoteViagem *-- Assento
    ReservaPassagem ..> Assento
    PacoteViagemFacade ..> ReservaPassagem
    PacoteViagemFacade ..> ReservaHotel
    PacoteViagemFacade ..> AluguelCarro
    PacoteViagemFacade ..> ProcessadorPagamento
    Main ..> PacoteViagemFacade




🚀 Como Executar
Pré‑requisitos
JDK 17 ou superior instalado (Download)

Git (opcional, para clonar)


PASSOS

1. Clone o Repositório

git clone https://github.com/seu-usuario/Facade.git
cd Facade



2. Compile o Código

javac -d out src/main/java/com/viagem/**/*.java src/main/java/com/viagem/Main.java



3. Execute

java -cp out com.viagem.Main



🎮 Exemplo de Interação


Quantas pessoas? 2

Cliente 1
  Nome: Ana Oliveira
  CPF: 111.222.333-44
Cliente 2
  Nome: Carlos Lima
  CPF: 555.666.777-88

--- ASSENTO ---
Fileira (1-32): 5
Letra (A-F): A

--- HOTEL ---
1-Simples 2-Executivo 3-Suíte
Opção: 2
Diárias: 3
Pessoas no quarto: 2

--- CARRO ---
1-Econômico 2-Executivo 3-Luxo
Opção: 3
Dias: 4

--- PAGAMENTO ---
Forma (PIX/BOLETO/DEBITO/CREDITO): CREDITO
Parcelas (1-6): 3

=== COMPROVANTE DE PACOTE DE VIAGEM ===
CLIENTES:
  Ana Oliveira (CPF: 111.222.333-44)
  Carlos Lima (CPF: 555.666.777-88)

DETALHES DA COMPRA:
  Poltrona: 5A (EXECUTIVA - Janela)
  Hotel: Quarto Executivo - 3 diárias para 2 pessoa(s)
  Carro: Luxo - 4 dia(s)

Valor base do pacote: R$ 9775,00
Forma de pagamento: CREDITO em 3x
Desconto/ Acréscimo: R$ 780,07
Valor final: R$ 10555,07
=======================================




🧪 Validação dos Preços
Aéreo
Econômica (fileiras 9–32): R$ 500

Executiva (fileiras 4–8): R
500
+
250
500+250 1.750

Primeira Classe (fileiras 1–3): R
1.750
+
150
1.750+150 4.375

Hotel (diária por pessoa)
Simples: R$ 200

Executivo: R
200
+
150
200+150 500

Suíte Presidencial: R
500
+
300
500+300 2.000

Carro (diária)
Econômico: R$ 150

Executivo: R
150
+
100
150+100 300

Luxo: R
300
+
100
300+100 600

Pagamento
PIX: 10% desconto

Boleto: 5% desconto

Débito: sem acréscimo

Crédito: até 6x. A partir da 2ª parcela, acréscimo de 3,99% sobre o valor base por parcela extra.

Exemplo: Crédito em 3x → acréscimo de (3-1) × 3,99% = 7,98% sobre o valor base.




📄 Licença
Este projeto está licenciado sob a licença MIT – veja o arquivo LICENSE para detalhes.

👤 Autor
Desenvolvido como exemplo prático do padrão Facade para a disciplina de Programação Orientada a Objetos.



