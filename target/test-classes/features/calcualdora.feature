# language: pt;


Feature: Soma da Calculadora com dados CSV

  Scenario: Executar testes de soma utilizando dados CSV
    Dado que a calculadora esta aberta
    Quando eu executo os testes de soma a partir do CSV "csv/soma.csv"
    Entao os testes de soma devem ser executados com sucesso

