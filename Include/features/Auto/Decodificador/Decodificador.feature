#Author: Denilson Costa Dias  

@Decodificador
Feature: Decodificador
  Decodificador de placa e chassi

@7.1.1_R1211_ePac @Executar   
 Scenario: Decodificador de placa e chassi - Validar a troca de campo após preenchimento de placa válida
  Given que eu estou na Home do sistema Auto
  | CT                 |Modelo                                                        |topico       |Cenário                                                                                      |
  | CTDC711R1211EPAC   |VOLKSWAGEN / FOX / 1.0 8v(G2)(SilverFox)(TotalFlex)  4p / 2010|Decodificador|Decodificador de placa e chassi - Validar a troca de campo após preenchimento de placa válida|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  Then é exibido a marca, modelo, versão, ano e chassi
  And finalizo a aplicação
  
@7.1.2_R1211_ePac  @Executar 
 Scenario: Decodificador de placa e chassi - Validar a tentativa de preenchimento com placa inexistente
  Given que eu estou na Home do sistema Auto
  | CT                 |Mensagem                                                                          |topico       |Cenário                                                                                     |
  | CTDC712R1211EPAC   |Não foi identificado o chassi correspondente a essa placa. Favor informar o chassi|Decodificador|Decodificador de placa e chassi - Validar a tentativa de preenchimento com placa inexistente|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho com uma placa inválida
  Then é exibido a mensagem de erro
  And finalizo a aplicação  
  
@7.1.3_R1211_ePac  @Executar 
 Scenario: Decodificador de placa e chassi - Validar se é exibido o campo habilitado para veículo 0 KM
  Given que eu estou na Home do sistema Auto
  | CT                 |botão|topico       |Cenário                                                                                    |
  | CTDC713R1211EPAC   |Sim  |Decodificador|Decodificador de placa e chassi - Validar se é exibido o campo habilitado para veículo 0 KM|
  |                    |Nao  |             |                                                                                           |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  Then é exibido os botões habilitados de "Sim" e "Não" para o campo "O veículo é 0Km"
  And finalizo a aplicação    
 
@7.1.4_R1211_ePac @Executar @Ajustar_posicao_do_modal  
 Scenario: Decodificador de placa e chassi - Validar a troca de campo após preenchimento de chassi válido
  Given que eu estou na Home do sistema Auto
  | CT              |topico       |Cenário                                                                                       |
  | CTDC714R1211EPAC|Decodificador|Decodificador de placa e chassi - Validar a troca de campo após preenchimento de chassi válido|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho com um chassis válido
  Then é exibido um modal para a seleção do veículo
  And finalizo a aplicação  
  
@7.1.5_R1211_ePac @Executar  
 Scenario: Decodificador de placa e chassi - Validar a tentativa de preenchimento com chassi irregular
  Given que eu estou na Home do sistema Auto
  | CT              |Mensagem                        |topico       |Cenário                                                                                    |
  | CTDC715R1211EPAC|Chassi irregular, favor corrigir|Decodificador|Decodificador de placa e chassi - Validar a tentativa de preenchimento com chassi irregular|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho com um chassis inexistente
  Then é exibido a mensagem de erro
  And finalizo a aplicação    

@7.1.6_R1211_ePac  @Executar 
 Scenario: Decodificador de placa e chassi - Validar se o campo placa fica em branco no caso do veículo ser 0KM e não ter sido emplacado
  Given que eu estou na Home do sistema Auto
  | CT              |Placa  |topico       |Cenário                                                                                                                      |
  | CTDC716R1211EPAC|vazia  |Decodificador|Decodificador de placa e chassi - Validar se o campo placa fica em branco no caso do veículo ser 0KM e não ter sido emplacado|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  Then o campo "Placa do veículo" é exibido em branco.
  And finalizo a aplicação  
  
@7.1.7_R1211_ePac  @Executar 
 Scenario: Decodificador de placa e chassi - Validar o preenchimento do campo placa quando o veículo é 0 Km e foi emplacado recentemente
  Given que eu estou na Home do sistema Auto
  | CT              |Placa  |botao|topico       |Cenário                                                                                                      |
  | CTDC717R1211EPAC|vazia  |Sim  |Decodificador|Decodificador de placa e chassi - Validar o preenchimento da placa para veículo é 0 Km emplacado recentemente|
  |                 |QJL5785|     |             |                                                                                                             |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And o campo "Placa do veículo" é exibido em branco
  And preencho manualmente o campo "Placa do veículo" com uma pláca válida
  And seleciono a opção "Sim" para "O veículo é 0 km"
  And clico no botao Avançar
  Then o campo "Placa do veículo" é exibido preenchido
  And finalizo a aplicação    
  
  
  
  