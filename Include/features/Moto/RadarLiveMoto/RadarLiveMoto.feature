#Author: Denilson Costa Dias



@RadarLive
Feature: Validar motor de cálculo de pacotes de premios do sistema Moto
  
 @1.01_R1211_ePac  @ExecMotoTeste     
 Scenario: Radar Live - Validar motor de cálculo de pacotes de premios do sistema Moto seguro novo  
  Given que acesso tela Home do sistema Moto, preencho campos obrigatórios da tela "1. Cotação Moto"
  | CT                 |Renovação|topico        |Cenário                                                |
  | CTRLM101R1211EPAC  |Não      |RadarLiveMoto |Validar  pacotes de premios do sistema Moto Seguro Novo|
  
  Then verifico se não existem diferenças no cálculo dos pacotes da tela "2. Preço" Moto
  
  
 @1.02_R1211_ePac   
 Scenario: Radar Live - Validar motor de cálculo de pacotes de premios do sistema Moto para Renovação externa sem sinistro  
  Given que acesso tela Home do sistema Moto, preencho campos obrigatórios da tela "1. Cotação Moto"
  | CT                |Renovação|tipo                                       |topico        |Cenário                                                                   |
  | CTRLM102R1211EPAC |Sim      |Renovação de outra seguradora sem sinistro|RadarLiveMoto |Validar pacotes de premios do sistema Moto Renovação externa sem sinistro |
  
  Then verifico se não existem diferenças no cálculo dos pacotes da tela "2. Preço" Moto  
  
  
@1.03_R1211_ePac   
 Scenario: Radar Live - preencher campos obrigatórios 
  Given que eu estou na Home do sistema Moto
  | CT                 |topico       |Cenário                                   |
  | CTRLM102R1211EPAC  |RadarLiveMoto|Radar Live - preencher campos obrigatórios|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Moto na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos para moto
  And clico no botao Avançar 
  And tela "2 preço" cotação moto é exeibida corretamente
  And finalizo a aplicação  