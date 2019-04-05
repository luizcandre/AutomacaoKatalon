#Author: Denilson Costa Dias 

@DiaDePagamento
Feature: Dia de pagamento
  Verificar as opções de seleção

@1.8.1_R1211_ePac  @Executar 
 Scenario: Dia de pagamento - Verificar as opções de seleção do "Dia de pagamento"
  Given que eu estou na Home do sistema Auto
  | CT                 |Dia de vencimento|Pagamento|combo            |topico        |Cenário                                                                |
  | CTPG181R1211EPAC   |de 1 a 31        |4x       |Dia de vencimento|DiaDePagamento|Dia de pagamento - Verificar as opções de seleção do "Dia de pagamento"|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar 
  And seleciono uma forma de pagamento parcelado
  And clico no botão 'Comprar'
  When clico no combo "Dia de vencimento" na tela "3. Pagamento" são exibidas as opções de 1 a 31
  And  não há duplicidade de informação
  And finalizo a aplicação 