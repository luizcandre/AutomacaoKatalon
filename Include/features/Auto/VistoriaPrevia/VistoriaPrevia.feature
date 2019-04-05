#Author: Denilson Costa Dias  

#7.6.16 R1211 ePac placa do veículo não seja 0KM tenha saido há menos de 3 dias da concessionária trocar a cada execução
#7.6.17 Concluir vistoriaPrevia() 
#7.6.18 informar chassi de veículos com até 14 anos a cada execução
#7.6.19 R1211 ePac placa do veículo sendo 0km dentro do prazo de 180 dias da data de saída da concessionária trocar a cada execução
#7.6.20 R1211 ePac placa e Número da CI VÁLIDO do mesmo veículo 0Km da apólice anterior do veículo sendo 0km dentro do prazo de 180 dias da data de saída da concessionária trocar a cada execução
#7.6.21_R1211_ePac trocar placa para "O veículo é 0 km" a cada execução 
#7.6.21_R1211_ePac trocar placa para "O veículo é 0 km" e número de CI de veículo 0Km da apólice anterior cada execução 

@VistoriaPrevia
Feature: VistoriaPrevia
  R1211 - ePac - Vistoria prévia - Validar VP obrigatória para seguro e renovação
  

@7.6.5_R1211_ePac @Executar @chassis_de_veículo_usado  
 Scenario: Vistoria prévia - Validar VP obrigatória para seguro novo de veículos usados
  Given que eu estou na Home do sistema Auto
  | CT              |mensagem                              |topico        |Cenário                                                                     |
  | CTVP765R1211EPAC|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para seguro novo de veículos usados|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação
  
@7.6.6_R1211_ePac  @Executar  @chassis_de_veículo_0KM
 Scenario: Vistoria prévia - Validar VP obrigatória para seguro novo de veículo zero km que tenha saído da concessionária há mais de 3 dias
  Given que eu estou na Home do sistema Auto
  | CT              |mensagem                              |topico        |Cenário                                                                                                                         |
  | CTVP766R1211EPAC|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para seguro novo de veículo zero km que tenha saído da concessionária há mais de 3 dias|
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação  
  
@7.6.7_R1211_ePac   @Executar @chassis_de_veículo_0KM
 Scenario: Vistoria prévia - Validar VP obrigatória para seguro novo e renovação externa com contratação de blindagem e acessórios
  Given que eu estou na Home do sistema Auto
  | CT              |mensagem                                           |topico        |Cenário                                                                                                                |
  | CTVP767R1211EPAC|Vistoria Prévia Presencial Obrigatória             |VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para seguro novo e renovação externa com contratação de blindagem e acessórios|
  |                 |Cobertura não permitida para Acessório - Blindagem.|              |                                                                                                                       |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botão "Sim" para a pergunta "Veículo possui blindagem"
  And é exibida a mensagem "Cobertura não permitida para Acessório - Blindagem"
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação 
 
@7.6.8_R1211_ePac @Executar @chassis_de_veículo_de_15_anos_ou_mais  
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação externa de veículo com 15 anos de uso ou mais
  Given que eu estou na Home do sistema Auto
  | CT              |mensagem                              |topico        |Cenário                                                                                              |
  | CTVP768R1211EPAC|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação externa de veículo com 15 anos de uso ou mais|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação  
  
@7.6.9_R1211_ePac @Executar @placa_do_veículo_não_seja_0KM_tenha_saido_há_menos_de_3_dias_da_concessionária 
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência (exceto veículo 0 km que tenha saído da concessionária há menos de 3 dias)
  Given que eu estou na Home do sistema Auto
  | CT              |mensagem                              |topico        |Cenário                                                                                                           |
  | CTVP769R1211EPAC|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação     
  
@7.6.11_R1211_ePac @Executar @placa_do_veículo_não_seja_0KM_tenha_saido_há_menos_de_3_dias_da_concessionária 
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação externa com sinistro (exceto veículo  0km que tenha saído da concessionária há menos de 3 dias)
  Given que eu estou na Home do sistema Auto
  | CT               |seguro   | tipo                                      |mensagem                              |topico        |Cenário                                                                                                                                                |
  | CTVP7611R1211EPAC|Renovação| Renovação de outra seguradora com sinistro|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação externa com sinistro (exceto veículo  0km que tenha saído da concessionária há menos de 3 dias)|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora com sinistro' está selecionada no campo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação   

@7.6.12_R1211_ePac @Executar @placa_do_veículo_não_seja_0KM_tenha_saido_há_menos_de_3_dias_da_concessionária 
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação interna fora do prazo (quebra de vigência acima de 7 dias)
  Given que eu estou na Home do sistema Auto
  | CT               |seguro   | tipo                                     |mensagem                              |topico        |Cenário                                                                                                           |
  | CTVP7612R1211EPAC|Renovação|Renovação de outra seguradora sem sinistro|Vistoria Prévia Presencial Obrigatória|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação interna fora do prazo (quebra de vigência acima de 7 dias)|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação
  
@7.6.13_R1211_ePac @Executar @placa_do_veículo_não_seja_0KM_tenha_saido_há_menos_de_3_dias_da_concessionária 
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência (exceto veículo 0 km que tenha saído da concessionária há menos de 3 dias)
  Given que eu estou na Home do sistema Auto
  | CT               |mensagem                              |Placa  |topico        |Cenário                                                                                                           |
  | CTVP7613R1211EPAC|Vistoria Prévia Presencial Obrigatória|QJL5785|VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When substituo a placa do veículo que não seja 0KM e tenha saído há menos de 3 dias
  And clico no botao Avançar
  And clico no botão 'Comprar'
  Then é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"
  And finalizo a aplicação    

@7.6.16_R1211_ePac @Executar 
 Scenario: Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência (exceto veículo 0 km que tenha saído da concessionária há menos de 7 dias)
  Given que eu estou na Home do sistema Auto
  | CT               |botao| Pagamento       | Tela     |Dias|downloads       |topico        |Cenário                                                                                                           |
  | CTVP7616R1211EPAC|Sim  | Boleto Bancário | 2. Preço |7   |Carteirinha     |VistoriaPrevia|Vistoria prévia - Validar VP obrigatória para renovação externa com troca de veículo, mesmo sem quebra de vigência|
  |                  |     |                 |          |    |Apólice         |              |                                                                                                                  |
  |                  |     |                 |          |    |Apólice Resumida|              |                                                                                                                  |
  |                  |     |                 |          |    |Proposta        |              |                                                                                                                  |
  |                  |     |                 |          |    |Boleto          |              |                                                                                                                  |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono para "O veículo é 0 km" a opção "Sim"
  And clico no botao Avançar
  And clico em uma opção para a pergunta "Forma de Pagamento"
  And clico no botão 'Comprar'
  And clico no botao Avançar
  And seleciono uma data com menos de 3 dias para a pergunta "Data de saída da nota fiscal do seu carro 0km" na tela "3.Preço"
  And clico no botao Avançar
  And clico no botão "Emitir"
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação  
  
@7.6.17_R1211_ePac @Executar
 Scenario: Vistoria prévia - Vistoria prévia - Validar VP não obrigatória para renovação  Allianz sem quebra de vigência e sem substituição de veículo
  Given que eu estou na Home do sistema Auto
  | CT                 |segur   o| tipo                           | campos                      |downloads       |topico        | Cenário                                                                                                                 |
  | CTVP7617R1211EPAC  |Renovação| Renovação Allianz sem sinistro | Qual a sua classe de bônus? |Carteirinha     |VistoriaPrevia|Vistoria prévia - Validar VP não obrigatória para renovação  Allianz sem quebra de vigência e sem substituição de veículo|
  |                    |         |                                | Número da CI                |Apólice         |              |                                                                                                                         |
  |                    |         |                                |                             |Apólice Resumida|              |                                                                                                                         |
  |                    |         |                                |                             |Proposta        |              |                                                                                                                         |
  |                    |         |                                |                             |Boleto          |              |                                                                                                                         |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And  informo um "número de CI" 
  And clico no botao Avançar
  And clico em uma opção para a pergunta "Forma de Pagamento"
  And clico no botão 'Comprar'
  And clico no botao Avançar
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação    
  
@7.6.18_R1211_ePac @Executar
 Scenario: Vistoria prévia - Vistoria prévia - Validar VP não obrigatória para renovação externa de veículos com até 14 anos
  Given que eu estou na Home do sistema Auto
  | CT                 |seguro   | tipo                                       | campos                      |downloads       |topico        | Cenário                                                                                       |
  | CTVP7618R1211EPAC  |Renovação| Renovação de outra seguradora com sinistro | Qual a sua classe de bônus? |Carteirinha     |VistoriaPrevia|Vistoria prévia - Validar VP não obrigatória para renovação externa de veículos com até 14 anos|
  |                    |         |                                            |                             |Apólice         |              |                                                                                               |
  |                    |         |                                            |                             |Apólice Resumida|              |                                                                                               |
  |                    |         |                                            |                             |Proposta        |              |                                                                                               |
  |                    |         |                                            |                             |Boleto          |              |                                                                                               |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When seleciono a opção 'Renovação de outra seguradora com sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And informo os dados para a pergunta "Número da apólice anterior"
  And informo os dados para a pergunta "Número da CI"
  And informo uma data para a pergunta "Fim da vigência anterior"
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação     
   
@7.6.19_R1211_ePac @Executar
 Scenario: Vistoria prévia - Vistoria prévia - Validar VP não obrigatória para renovação externa com o mesmo veículo da apólice anterior, sendo 0km dentro do prazo de 180 dias da data de saída da concessionária e sem quebra de vigência
  Given que eu estou na Home do sistema Auto
  | CT                 |seguro   | tipo                                       | campos                      |botao|Dias|downloads       |topico        | Cenário                                                                                                                |
  | CTVP7619R1211EPAC  |Renovação| Renovação de outra seguradora sem sinistro | Qual a sua classe de bônus? |Sim  |3   |Carteirinha     |VistoriaPrevia|Vistoria prévia - Validar VP 0km dentro do prazo de 180 dias da data de saída da concessionária e sem quebra de vigência|
  |                    |         |                                            |                             |     |    |Apólice         |              |                                                                                                                        |
  |                    |         |                                            |                             |     |    |Apólice Resumida|              |                                                                                                                        |
  |                    |         |                                            |                             |     |    |Proposta        |              |                                                                                                                        |
  |                    |         |                                            |                             |     |    |Boleto          |              |                                                                                                                        |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And seleciono para "O veículo é 0 km" a opção "Sim"
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And informo os dados para a pergunta "Número da apólice anterior"
  And informo os dados para a pergunta "Número da CI"
  And informo uma data para a pergunta "Fim da vigência anterior"
  And seleciono uma data com menos de 3 dias para a pergunta "Data de saída da nota fiscal do seu carro 0km" na tela "3.Preço"
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação    
  
@7.6.20_R1211_ePac @Executar
 Scenario: Vistoria prévia - Validar VP não obrigatória para renovação Allianz com o mesmo veículo da apólice anterior, sendo 0km dentro do prazo de 180 dias da data de saída da concessionária e sem quebra de vigência
  Given que eu estou na Home do sistema Auto
  | CT                 |seguro   | tipo                           | campos                                               |downloads       |topico        | Cenário                                                                                                                |
  | CTVP7620R1211EPAC  |Renovação| Renovação Allianz sem sinistro | Qual a sua classe de bônus?                          |Carteirinha     |VistoriaPrevia|Vistoria prévia - Validar VP 0km dentro do prazo de 180 dias da data de saída da concessionária e sem quebra de vigência|
  |                    |         |                                | Número da CI do mesmo veículo 0Km da apólice anterior|Apólice         |              |                                                                                                                        |
  |                    |         |                                |                                                      |Apólice Resumida|              |                                                                                                                        |
  |                    |         |                                |                                                      |Proposta        |              |                                                                                                                        |
  |                    |         |                                |                                                      |Boleto          |              |                                                                                                                        |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And  informo um "número de CI" 
  And clico no botao Avançar
  And clico em uma opção para a pergunta "Forma de Pagamento"
  And clico no botão 'Comprar'
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação    
    
@7.6.21_R1211_ePac @Executar
 Scenario: 7.6.21 - R1211 - ePac - Vistoria prévia - Validar VP não obrigatória para renovação externa com troca de veículo para 0km que tenha saído da concessionária há menos de 3
  Given que eu estou na Home do sistema Auto
  | CT                 |seguro   | tipo                                       |botao|Dias| downloads      |topico        | Cenário                                                                                                                                          |
  | CTVP7621R1211EPAC  |Renovação| Renovação de outra seguradora sem sinistro |Sim  |3   |Carteirinha     |VistoriaPrevia| Vistoria prévia - Validar VP não obrigatória para renovação externa com troca de veículo para 0km que tenha saído da concessionária há menos de 3|
  |                    |         |                                            |     |    |Apólice         |              |                                                                                                                                                  |
  |                    |         |                                            |     |    |Apólice Resumida|              |                                                                                                                                                  |
  |                    |         |                                            |     |    |Proposta        |              |                                                                                                                                                  |
  |                    |         |                                            |     |    |Boleto          |              |                                                                                                                                                  |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And seleciono para "O veículo é 0 km" a opção "Sim" 
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And informo os dados para a pergunta "Número da apólice anterior"
  And informo os dados para a pergunta "Número da CI"
  And informo uma data para a pergunta "Fim da vigência anterior"
  And seleciono uma data com menos de 3 dias para a pergunta "Data de saída da nota fiscal do seu carro 0km" na tela "3.Preço"
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação    
  
@7.6.22_R1211_ePac @Executar
 Scenario: 7.6.21 - R1211 - ePac - Vistoria prévia - Validar VP não obrigatória para renovação externa com troca de veículo para 0km que tenha saído da concessionária há menos de 3
  Given que eu estou na Home do sistema Auto
  | CT                 |seguro   | tipo                                       |downloads       |topico        | Cenário                                                                                                                                          |
  | CTVP7622R1211EPAC  |Renovação| Renovação Allianz sem sinistro             |Carteirinha     |VistoriaPrevia| Vistoria prévia - Validar VP não obrigatória para renovação externa com troca de veículo para 0km que tenha saído da concessionária há menos de 3|
  |                    |         |                                            |Apólice         |              |                                                                                                                                                  |
  |                    |         |                                            |Apólice Resumida|              |                                                                                                                                                  |
  |                    |         |                                            |Proposta        |              |                                                                                                                                                  |
  |                    |         |                                            |Boleto          |              |                                                                                                                                                  |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And  informo um "número de CI" 
  And clico no botao Avançar
  And clico no botão 'Comprar'
  And clico no botao Avançar
  And clico no botão "Emitir"
  And NÃO há necessidade de Vistoria Prévia
  Then é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads 
  And finalizo a aplicação   
  
  
  
  