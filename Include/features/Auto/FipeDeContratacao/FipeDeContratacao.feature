#Author: Denilson Dias 


@Fipe_de_Contratação
Feature: Fipe de Contratação
  
@15.1_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar os percentuais FIPEs permitidos para contratação são: 90%, 100%, 105% e 110%.
  Given que eu estou na Home do sistema Auto
  | CT                |botao|topico            |combo      |Cenário                                                                                                      |
  | CTFP151R1211EPAC  |Sim  |FipeDeContrataCao |Tabela FIPE|Fipe de Contratação - Verificar os percentuais FIPEs permitidos para contratação são: 90%, 100%, 105% e 110%.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Sim' no botão 'O veículo é 0 km'
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  And clico no combo da opção 'Tabela FIPE'
  Then as opções 'Tabela FIPE' são exibidas conforme esperado
  And  não há duplicidade de informação
  And finalizo a aplicação
       
@15.2_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar se veículo proveniente de aceitação condicionada, o sistema só aceita o valor FIPE de  90%.
  Given que eu estou na Home do sistema Auto
  | CT                |topico            |TabelaFIPE|mensagem                                                            |Cenário                                                                                                                    |
  | CTFP152R1211EPAC  |FipeDeContrataCao |   90     |Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE|Fipe de Contratação - Verificar se veículo proveniente de aceitação condicionada, o sistema só aceita o valor FIPE de  90%.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar             
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When verifico na sessão 'Edicação de Cálculo' o valor FIPE de '90%'
  Then é exibida a mensagem 'Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE'
  And finalizo a aplicação
  
@15.3_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, quando informado valor 110% FIPE a critíca "Percentual FIPE não permitido para esta cotação" é exibida
  Given que eu estou na Home do sistema Auto
  | CT                |botao|FIPE|mensagem                                       |topico            |combo      |Cenário                                                                                                                                                                               |
  | CTFP153R1211EPAC  |Nao  |110 |Percentual FIPE não permitido para esta cotação|FipeDeContrataCao |Tabela FIPE|Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, quando informado valor 110% FIPE a critíca "Percentual FIPE não permitido para esta cotação" é exibida.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Não' no botão 'O veículo é 0 km'
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  And clico no combo da opção 'Tabela FIPE'
  And seleciono opção da tabela FIPE
  Then é exibida a mensagem 'Percentual FIPE não permitido para esta cotação'
  And finalizo a aplicação  
  
@15.4_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 105% FIPE
  Given que eu estou na Home do sistema Auto
  | CT                |botao|FIPE|mensagem                                       |topico            |combo      |Cenário                                                                                                                |
  | CTFP154R1211EPAC  |Nao  |105 |Percentual FIPE não permitido para esta cotação|FipeDeContrataCao |Tabela FIPE|Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 105% FIPE.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Não' no botão 'O veículo é 0 km'
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  And clico no combo da opção 'Tabela FIPE'
  And seleciono opção da tabela FIPE
  Then nenhuma critíca é exibida
  And finalizo a aplicação   
  
@15.5_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 100% FIPE
  Given que eu estou na Home do sistema Auto
  | CT                |botao|FIPE|mensagem                                       |topico            |combo      |Cenário                                                                                                                |
  | CTFP155R1211EPAC  |Nao  |100 |Percentual FIPE não permitido para esta cotação|FipeDeContrataCao |Tabela FIPE|Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 100% FIPE.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Não' no botão 'O veículo é 0 km'
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  And clico no combo da opção 'Tabela FIPE'
  And seleciono opção da tabela FIPE
  Then nenhuma critíca é exibida
  And finalizo a aplicação   
 
@15.6_R1211_ePac @Executar
 Scenario: Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 90% FIPE
  Given que eu estou na Home do sistema Auto
  | CT                |botao|FIPE|mensagem                                       |topico            |combo      |Cenário                                                                                                               |
  | CTFP156R1211EPAC  |Nao  |90  |Percentual FIPE não permitido para esta cotação|FipeDeContrataCao |Tabela FIPE|Fipe de Contratação - Verificar se nos casos de Seguro Novo com veículo usado, o sistema aceita o percentual 90% FIPE.|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Não' no botão 'O veículo é 0 km'
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  And clico no combo da opção 'Tabela FIPE'
  And seleciono opção da tabela FIPE
  Then nenhuma critíca é exibida
  And finalizo a aplicação   
  
         