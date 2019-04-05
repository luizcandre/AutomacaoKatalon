#Author: Denilson Dias 


@Reabertura_de_cotacao 
Feature: Reabertura de cotacao
           Validar CEP que o CPF/CNPJ estiver cadastrado na base

@20.1.1_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com mais de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão    |Menu   |topico           |Cenário                                                                                                            |
  |CTRC2011R1211EPAC |Alterar  |Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com mais de 7 dias|
  |                  |Tarificar|       |                 |                                                                                                                   |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then é exibido o botão "Alterar" na tela "Cotação"
  And finalizo a aplicação
  
@20.1.2_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com menos de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão    |Menu   |topico           |Cenário                                                                                                             |
  |CTRC2012R1211EPAC |Alterar  |Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com menos de 7 dias|
  |                  |Tarificar|       |                 |                                                                                                                    |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then é exibido o botão "Alterar" na tela "Cotação"
  And finalizo a aplicação  

@20.1.3_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com menos de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão    |Menu   |topico           |Cenário                                                                                                             |
  |CTRC2013R1211EPAC |Alterar  |Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Alterar" na reabertura de cotação com menos de 7 dias|
  |                  |Tarificar|       |                 |                                                                                                                    |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  And clico no botão 'Alterar'
  
  
  And finalizo a aplicação 









@20.2.1_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Emitir" na reabertura de cotação com mais de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão    |Menu   |topico           |Cenário                                                                                                           |
  |CTRC2021R1211EPAC |Emitir   |Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Emitir" na reabertura de cotação com mais de 7 dias|
  |                  |Emitir   |       |                 |                                                                                                                  |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then não é exibido o botão "Emitir" na tela "Cotação"
  And finalizo a aplicação   
  
@20.2.2_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Emitir" na reabertura de cotação com menos de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão    |Menu   |topico           |Cenário                                                                                                            |
  |CTRC2022R1211EPAC |Emitir   |Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Emitir" na reabertura de cotação com menos de 7 dias|
  |                  |Emitir   |       |                 |                                                                                                                   |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then é exibido o botão "Emitir" na tela "Cotação"
  And finalizo a aplicação  
   
   
   
 
 @20.3.1_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Visualizar" na reabertura de cotação com mais de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão     |Menu   |topico           |Cenário                                                                                                               |
  |CTRC2031R1211EPAC |Visualizar|Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Visualizar" na reabertura de cotação com mais de 7 dias|
  |                  |Visualizar|       |                 |                                                                                                                      |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then não é exibido o botão "Visualizar" na tela "Cotação"
  And finalizo a aplicação
   
 @20.3.2_R1211_ePac  @Executar  @ExecutarReaberturaCotacao
 Scenario: Reabertura pelo botão Alterar - Verificar existência do botão "Visalizar" na reabertura de cotação com menos de 7 dias
  Given que eu estou na Home do sistema Auto
  |CT                |Botão     |Menu   |topico           |Cenário                                                                                                               |
  |CTRC2032R1211EPAC |Visualizar|Cotação|ReaberturaCotacao|Reabertura pelo botão Alterar - Verificar existência do botão "Visalizar" na reabertura de cotação com menos de 7 dias|
  |                  |Visualizar|       |                 |                                                                                                                      |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  Then é exibido o botão "Visualizar" na tela "Cotação"
  And finalizo a aplicação   
   
   
  
  
  