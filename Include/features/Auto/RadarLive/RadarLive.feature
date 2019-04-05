  #Author: your.email@your.domain.com

@RadarLive
Feature: Validar motor de cálculo de pacotes de premios do sistema Auto
  
 @RL_1.01_R1211_ePac   @Executar   
 Scenario: Radar Live - Validar motor de cálculo de pacotes de premios do sistema Auto Seguro Novo  
  Given que acesso tela Home do sistema Auto, preencho campos obrigatórios da tela "1. Cotação Auto"
  | CT                 |Renovação|topico    |Cenário                                                |
  | CTRL101R1211EPAC   |Não      |RadarLive |Validar  pacotes de premios do sistema Auto Seguro Novo|
  
  Then verifico se não existem diferenças no cálculo dos pacotes da tela "2. Preço" 
  
  
 @RL_1.02_R1211_ePac   @Executar 
 Scenario: Radar Live - Validar motor de cálculo de pacotes de premios do sistema Auto para Renovação externa sem sinistro  
  Given que acesso tela Home do sistema Auto, preencho campos obrigatórios da tela "1. Cotação Auto"
  | CT               |Renovação|tipo                                      |topico    |Cenário                                                                   |
  | CTRL102R1211EPAC |Sim      |Renovação de outra seguradora sem sinistro|RadarLive |Validar pacotes de premios do sistema Auto Renovação externa sem sinistro |
  
  Then verifico se não existem diferenças no cálculo dos pacotes da tela "2. Preço"   
   