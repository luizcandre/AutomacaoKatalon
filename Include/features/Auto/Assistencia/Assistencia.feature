#Author: Denilson Costa Dias 

@Assistência
Feature: Assistência 

@13.1_R1211_ePac   @Executar @testemassa
 Scenario: Assistência - Verificar se para a assistência 24h Completa está apresentando a assistência de Cláusula 1020
  Given que eu estou na Home do sistema Auto
  | CT                 |massa                |Clausulas                                                            |topico       |Cenário                                                                                      |
  | CTAS131R1211EPAC   |MassaAutoAllianz.xlsx|1020   -   Assistência Completo 24 HS - 500km - 20 Dias Carro Reserva|Assistência  |Verificar se para a assistência 24h Completa está apresentando a assistência de Cláusula 1020|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão "Comprar Compacto"
  And clico no botao Avançar
  When verifico a sessão Cláusulas da tela "Confirmação de Pagamento" 
  Then é exibida a Cláusula 
  And finalizo a aplicação
  
@13.2_R1211_ePac  @Executar 
 Scenario:  Assistência - Verificar se para a assistência 24h Completa está apresentando a assistência de 20 dias de carro reserva
  Given que eu estou na Home do sistema Auto
  | CT                 |DiasCarroReserva|topico     |Cenário                                                                                                 |
  | CTAS132R1211EPAC   |20              |Assistência|Verificar se para a assistência 24h Completa está apresentando a assistência de 20 dias de carro reserva|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão "Comprar Compacto"
  And clico no botao Avançar
  When verifico os pacotes com  "Assistências 24h - Completa" 
  Then é exibido os dias para a opção de Carro Reserva 
  And finalizo a aplicação  
  
@13.3_R1211_ePac  @Executar 
 Scenario:  Assistência - Verificar se para a assistência 24h Completa está apresentando a assistência de Guincho 500km
  Given que eu estou na Home do sistema Auto
  | CT                 |kmGuincho|topico     |Cenário                                                                                                    |
  | CTAS133R1211EPAC   |500Km    |Assistência|Assistência - Verificar se para a assistência 24h Completa está apresentando a assistência de Guincho 500km|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão "Comprar Compacto"
  And clico no botao Avançar
  When verifico os pacotes para a opção de Guincho com  "Assistências 24h - Completa" para a opção de Guincho 
  Then é exibido km para a opção de Guincho
  And finalizo a aplicação 

@13.4_R1211_ePac  @Executar 
 Scenario: Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de Cláusula 1030
  Given que eu estou na Home do sistema Auto
  | CT                 |Clausulas                                                          |topico       |Cenário                                                                                               |
  | CTAS134R1211EPAC   |1030   -   Assistência VIP 24 HS - km livre - 30 Dias Carro Reserva|Assistência  |Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de Cláusula 1030|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And clico no botao Avançar
  When verifico a sessão Cláusulas da tela "Confirmação de Pagamento" 
  Then é exibida a Cláusula 
  And finalizo a aplicação  
  
@13.5_R1211_ePac  @Executar 
 Scenario:  Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de 30 dias de carro reserva
  Given que eu estou na Home do sistema Auto
  | CT                 |DiasCarroReserva|topico     |Cenário                                                                                                          |
  | CTAS135R1211EPAC   |30              |Assistência|Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de 30 dias de carro reserva|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And clico no botao Avançar
  When verifico os pacotes com  "Assistências 24h - VIP" 
  Then é exibido os dias para a opção de Carro Reserva 
  And finalizo a aplicação   
  
@13.6_R1211_ePac @Executar  
 Scenario:  13.6 - R1211 - E-PAC - Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de Guincho km ilimitado
  Given que eu estou na Home do sistema Auto
  | CT                 |kmGuincho|topico     |Cenário                                                                                                      |
  | CTAS136R1211EPAC   |KM Livre |Assistência|Assistência - Verificar se para a assistência 24h VIP está apresentando a assistência de Guincho km ilimitado|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And clico no botao Avançar
  When verifico os pacotes para a opção de Guincho com  "Assistências 24h - VIP" para a opção de Guincho 
  Then é exibido km para a opção de Guincho
  And finalizo a aplicação   
  
  
  