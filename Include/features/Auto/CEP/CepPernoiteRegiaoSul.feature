#Author: Denilson Dias 


@CEP_de_Pernoite_Região_Sul_Mato_Grosso  
Feature: CEP de Pernoite Região Sul + Mato Grosso 
           Validar CEP que o CPF/CNPJ estiver cadastrado na base

 
@5.1.1_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |CartaVerde                    |topico              |Cenário                                                                                                                                    |
  | CTCEP511R1211EPAC |Carta Verde - Danos Materiais |CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Seguro Novo|
  |                   |Carta Verde - Danos Corporais |                    |                                                                                                                                           |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar 
  Then na tela "2 Preço" na listagem de Coberturas são exibidas a opções de Carta Verde
  And finalizo a aplicação
  
@5.1.2_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Renovação Interna com Sinistro
 Given que eu estou na Home do sistema Auto 
  |CT               |seguro   |tipo                           |campos                      |CartaVerde                   |topico              | Cenário                                                                                                                                                      |
  |CTCEP512R1211EPAC|Renovação|Renovação Allianz sem sinistro |Qual a sua classe de bônus? |Carta Verde - Danos Materiais|CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Renovação Interna com Sinistro|
  |                 |         |                               |Número da CI                |                             |                    |                                                                                                                                                              |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação 
  And preencho todos os demais campos obrigatórios com dados válidos 
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And  informo um "número de CI"
  And clico no botao Avançar 
  Then na tela "2 Preço" na listagem de Coberturas são exibidas a opções de Carta Verde
  And finalizo a aplicação
  
@5.1.3_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Renovação Externa sem Sinistro
  Given que eu estou na Home do sistema Auto
  | CT                |seguro   |tipo                                      |CartaVerde                    |topico              |Cenário                                                                                                            |
  | CTCEP513R1211EPAC |Renovação|Renovação de outra seguradora sem sinistro|Carta Verde - Danos Materiais |CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde para Renovação Externa sem Sinistro|
  |                   |         |                                          |Carta Verde - Danos Corporais |                    |                                                                                                                   |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar 
  Then na tela "2 Preço" na listagem de Coberturas são exibidas a opções de Carta Verde
  And finalizo a aplicação   
  
@5.1.4_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Endosso
  Given que eu estou na Home do sistema Auto
  |CT                |CEPVálido|botao     |Menu  |Opção    |SubOpção|CartaVerde                   |topico              |Cenário                                                                                                      |
  |CTCEP514R1211EPAC |79262970 |Selecionar|Vendas|Endossos |Endosso |Carta Verde - Danos Materiais|CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde na tela de Preço para Endosso|
  |                  |         |Aceitar   |      |         |        |Carta Verde - Danos Corporais|                    |                                                                                                             |
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  When informo "CEP" válido
  And clico no botao Avançar 
  Then na tela "2 Preço" na listagem de Coberturas são exibidas a opções de Carta Verde
  And finalizo a aplicação     
  
@5.1.5_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |botão|downloadPath       |arquivo        |CartaVerde                    |topico              |Cenário                                                                                                                                    |
  | CTCEP515R1211EPAC |Sim  |C://Users//Public//|retrievedoc.pdf|Carta Verde - Danos Materiais |CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Seguro Novo|
  |                   |     |                   |               |Carta Verde - Danos Corporais |                    |                                                                                                                                           |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção "Coberturas Carta Verde" no PDF
  Then é exibido a informação "Carta Verde" para o campo "Coberturas"
  And finalizo a aplicação  
  
@5.1.6_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro no PDF de Preço para Renovação Externa com Sinistro
  Given que eu estou na Home do sistema Auto
  | CT                |seguro   |tipo                                      |botão|downloadPath       |arquivo        |CartaVerde                    |topico              |Cenário                                                                                                                                                      |
  | CTCEP516R1211EPAC |Renovação|Renovação de outra seguradora sem sinistro|Sim  |C://Users//Public//|retrievedoc.pdf|Carta Verde - Danos Materiais |CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro no PDF de Preço para Renovação Externa com Sinistro|
  |                   |         |                                          |     |                   |               |Carta Verde - Danos Corporais |                    |                                                                                                                                                             |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção "Coberturas Carta Verde" no PDF
  Then é exibido a informação "Carta Verde" para o campo "Coberturas"
  And finalizo a aplicação   
  
@5.1.7_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro no PDF de Preço para Renovação Interna sem Sinistro
 Given que eu estou na Home do sistema Auto 
  |CT               |seguro   |tipo                           |campos                      |botão|downloadPath       |arquivo        |CartaVerde                   |topico              |Cenário                                                                                                                                                      |
  |CTCEP517R1211EPAC|Renovação|Renovação Allianz sem sinistro |Qual a sua classe de bônus? |Sim  |C://Users//Public//|retrievedoc.pdf|Carta Verde - Danos Materiais|CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro no PDF de Preço para Renovação Interna sem Sinistro|
  |                 |         |                               |Número da CI                |     |                   |               |                             |                    |                                                                                                                                                             |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação 
  And preencho todos os demais campos obrigatórios com dados válidos 
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And  informo um "número de CI"
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção "Coberturas Carta Verde" no PDF
  Then é exibido a informação "Carta Verde" para o campo "Coberturas"
  And finalizo a aplicação
  
@5.1.8_R1211_ePac  @Executar @ExecutarCEPdePernoiteCartaVerde
 Scenario: CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Endosso
  Given que eu estou na Home do sistema Auto
  |CT                |CEPVálido|botão|downloadPath       |arquivo        |botao     |Menu  |Opção    |SubOpção|CartaVerde                   |topico              |Cenário                                                                                                                                |
  |CTCEP518R1211EPAC |79262970 |Sim  |C://Users//Public//|retrievedoc.pdf|Selecionar|Vendas|Endossos |Endosso |Carta Verde - Danos Materiais|CepPernoiteRegiaoSul|CEP de Pernoite Região Sul + Mato Grosso  - Validar  a concessão de carta verde e a Extensão de Perímetro na tela de Preço para Endosso|
  |                  |         |     |                   |               |Aceitar   |      |         |        |Carta Verde - Danos Corporais|                    |                                                                                                                                       |
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  When informo "CEP" válido
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção "Coberturas Carta Verde" no PDF
  Then é exibido a informação "Carta Verde" para o campo "Coberturas"
  And finalizo a aplicação     
    
  
  
  
  