#Author: Denilson Costa Dias

@Regras_de_Negocios_QA_Layout
Feature: Regras de Negocios QA Layout 

@8.1.1_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar as opções exibidas para o campo 'Estado civil do condutor:'.
  Given que eu estou na Home do sistema Auto 
  | CT               | Valores                                | combo                    |topico          |Cenário                                                                             |
  | CTAU811R1211EPAC | Casado (a) ou convive em união estável | Estado civil do condutor |PerfilAutomovel |Automóvel  -  Verificar as opções exibidas para o campo 'Estado civil do condutor:'.|
  |                  | Solteiro (a)                           |                          |                |                                                                                    |
  |                  | Separado (a) / Divorciado (a)          |                          |                |                                                                                    |
  |                  | Viúvo (a)                              |                          |                |                                                                                    |
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  Then as opções 'Estado civil do condutor:' são exibidas conforme esperado
  And  não há duplicidade de informação
  And finalizo a aplicação

@8.1.2_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar no PDF o layout na seção "Características do Condutor" a opção 'Separado a  Divorciado a' do campo "Estado civil do condutor".
  Given que eu estou na Home do sistema Auto
  | CT                |campo                      |topico          |downloadPath       |arquivo        |Cenário                                                                                                             |
  | CTAU812R1211EPAC  |Separado[a] / Divorciado[a]|PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF 'Características do Condutor' campo 'Estado civil' opção 'Separado[a] / Divorciado[a]'.|
  |                   |                           |                |                   |               |                                                                                                                    |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Características do Condutor' no PDF
  Then é exibido a informação 'Separado a' ou 'Divorciado a' para o campo 'Estado civil do condutor'
  And finalizo a aplicação 

@8.1.3_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar o campo 'Utiliza o veiculo comercialmente?' quando selecionado a opção 'Sim'.
 Given que eu estou na Home do sistema Auto
 | CT                | botão |Mensagem                                                                      |topico          |Cenário                                                                                              |
 | CTAU813R1211EPAC  | Sim   |Sem cobertura para veículos utilizados como taxi ou transporte de passageiros |PerfilAutomovel |Automóvel  -  Verificar o campo 'Utiliza o veiculo comercialmente?' quando selecionado a opção 'Sim'.|

 And clico no botão Nova Cotação na Home
 And seleciono a opção Automovel na Modal Nova Cotação
 When clico na opção 'Sim' do campo 'Utiliza o veiculo comercialmente'
 Then é exibido a mensagem: 'Sem cobertura para veículos utilizados como taxi ou transporte de passageiros'
 And finalizo a aplicação
 
@8.1.4_R1211_ePac  @Executar @Automóvel
 Scenario: Automóvel  -  Verificar no PDF o layout na seção 'Características do Condutor', quando selecionado a opção 'Sim' no campo 'Utiliza o veículo comercialmente?'.
  Given que eu estou na Home do sistema Auto
  | CT              |campo                                    |botão|topico          |downloadPath       |arquivo        |Cenário                                                                                                                    |
  | CTAU814R1211EPAC|CATEGORIA DE RISCO: Automóvel - Comercial|Sim  |PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF 'Características do Condutor' campo 'Automóvel - Comercial' para o campo 'Categoria de Risco'.|
  |                 |                                         |     |                |                   |               |                                                                                                                           |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And eu clico na opção 'Sim' do campo 'Utiliza o veiculo comercialmente'
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Dados do Produto' no PDF
  Then é exibido a informação 'Automóvel - Comercial' para o campo 'Categoria de Risco'
  And finalizo a aplicação 
  
@8.1.5_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar o campo "Utiliza o veiculo comercialmente?" quando selecionado a opção "Não".
  Given que eu estou na Home do sistema Auto
  | CT                | botão |Mensagem                                                                      |topico          |Cenário                                                                                                                            |
  | CTAU815R1211EPAC  | Não   |Sem cobertura para veículos utilizados como taxi ou transporte de passageiros |PerfilAutomovel |Automóvel  -  Verificar o campo "Utiliza o veiculo comercialmente?" quando selecionado a opção "Não".NÃO é exibido nenhuma mensagem|

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When clico na opção 'Não' do campo 'Utiliza o veiculo comercialmente'
  Then NÃO é exibido nenhuma mensagem
  And finalizo a aplicação
 
@8.1.6_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar no PDF o layout na seção 'Características do Condutor', quando selecionado a opção 'Não' no campo 'Utiliza o veículo comercialmente?'.
  Given que eu estou na Home do sistema Auto
  | CT              |campo                                     |botão|topico          |downloadPath       |arquivo        |Cenário                                                                                                                     |
  | CTAU816R1211EPAC|CATEGORIA DE RISCO: Automóvel - Particular|Não  |PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF 'Características do Condutor' campo 'Automóvel - Particular' para o campo 'Categoria de Risco'.|
  |                 |                                          |     |                |                   |               |                                                                                                                            |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And eu clico na opção 'Não' do campo 'Utiliza o veiculo comercialmente'
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Dados do Produto' no PDF
  Then é exibido 'Automóvel - Particular' em 'Utiliza o veiculo comercialmente'
  And finalizo a aplicação 
 
@8.1.7_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar o campo "O condutor reside com pessoas de 17 a 25 anos?" quando selecionado a opção "Não".
  Given que eu estou na Home do sistema Auto
  | CT                | botão |topico          |Cenário                                                                                                                                         |
  | CTAU817R1211EPAC  | Não   |PerfilAutomovel |Automóvel  -  Verificar o campo "O condutor reside com pessoas de 17 a 25 anos?" quando selecionado a opção "Não".NÃO é exibido nenhuma mensagem|

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When clico na opção 'Não' do campo 'O condutor reside com pessoas de 17 a 25 anos'
  Then NÃO é exibido nenhuma mensagem
  And finalizo a aplicação
 
@8.1.8_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar no PDF o layout na seção 'Características do Condutor', quando selecionado a opção 'Não' no campo 'O condutor reside com pessoas de 17 a 25 anos?'.
  Given que eu estou na Home do sistema Auto
  | CT              |campo                                     |botão|topico          |downloadPath       |arquivo        |Cenário                                                                                                      |
  | CTAU818R1211EPAC|Não reside com pessoas desta faixa etária.|Não  |PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF 'Características do Condutor' campo 'Não reside com pessoas desta faixa etária.'|
  |                 |                                          |     |                |                   |               |                                                                                                             |
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And eu clico na opção 'Não' do campo 'O condutor reside com pessoas de 17 a 25 anos'
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Dados do Produto' no PDF
  Then é exibido a mensagem: 'Não reside com pessoas desta faixa etária' para o campo  'O condutor reside com pessoas de 17 a 25 anos'
  And finalizo a aplicação
  
@8.1.9_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar se não há duplicidade de informações no campo "O condutor reside com pessoas de 17 a 25 anos?" quando selecionado a opção "Sim".
  Given que eu estou na Home do sistema Auto
  | CT                | botão |topico          |Cenário                                                                                                                                                 |
  | CTAU819R1211EPAC  | Sim   |PerfilAutomovel |Automóvel  -  Verificar se não há duplicidade de informações no campo "O condutor reside com pessoas de 17 a 25 anos?" quando selecionado a opção "Sim".|

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When clico no  botão 'Sim' do campo 'O condutor reside com pessoas de 17 a 25 anos' são exibidas as opções
  Then as opções 'O condutor reside com pessoas de 17 a 25 anos' são exibidas conforme esperado
  And  não há duplicidade de informação
  And finalizo a aplicação
  
@8.1.10_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar no PDF o layout na seção "Características do Condutor", quando selecionado a opção "Sim" no campo "O condutor reside com pessoas de 17 a 25 anos?".
  Given que eu estou na Home do sistema Auto
  | CT               |campo                                                         |reside   |botão|topico          |downloadPath       |arquivo        |Cenário                                                                                                                         |
  | CTAU8110R1211EPAC|Reside com pessoas que pode[m] vir a usar o veículo segurado. |index3   |Sim  |PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF 'Características do Condutor' campo 'Reside com pessoas que pode[m] vir a usar o veículo segurado.'|
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And eu clico na opção 'Sim' do campo 'O condutor reside com pessoas de 17 a 25 anos'
  And seleciono uma opção do campo 'O condutor reside com pessoas de 17 a 25 anos'
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Dados do Produto' no PDF
  Then é exibido a informação 'Sim' para a opção 'O condutor reside com pessoas de 17 a 25 anos'
  And finalizo a aplicação  
  
@8.1.11_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar as opções exibidas para o campo 'O principal condutor reside em:'.
 Given que eu estou na Home do sistema Auto
 | CT                | Valores                    | combo                          |topico          |Cenário                                                                                                                        |
 | CTAU8111R1211EPAC | Casa                       | O principal condutor reside em |PerfilAutomovel |Automóvel  -  Verificar se não há duplicidade de informações na opções exibidas para o campo 'O principal condutor reside em:'.|
 |                   | Casa em Condomínio Fechado |                                |                |                                                                                                                               |
 |                   | Apartamento                |                                |                |                                                                                                                               |
 
 And clico no botão Nova Cotação na Home
 And seleciono a opção Automovel na Modal Nova Cotação
 Then as opções 'O principal condutor reside em:' são exibidas conforme esperado
 And  não há duplicidade de informação
 And finalizo a aplicação
  
@8.1.12_R1211_ePac  @Executar
 Scenario: Automóvel  -  Verificar no PDF o layout na seção "Características do Condutor" a opção do campo "O principal condutor reside em:".
  Given que eu estou na Home do sistema Auto
  | CT               |campo                      |reside   |botão|topico          |downloadPath       |arquivo        |Cenário                                                                                                     |
  | CTAU8120R1211EPAC|Casa em condomínio fechado |index3   |Sim  |PerfilAutomovel |C://Users//Public//|retrievedoc.pdf|Automóvel - Verificar no PDF a opção 'Casa em Condomínio Fechado' do campo 'O principal condutor reside em:'|
 
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a seção 'Dados do Produto' no PDF
  Then é exibido a informação 'Casa em Condomínio Fechado' para o campo 'O principal condutor reside em'
  And finalizo a aplicação  
  
