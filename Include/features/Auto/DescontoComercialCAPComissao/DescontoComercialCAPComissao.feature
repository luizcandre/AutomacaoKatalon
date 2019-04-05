#Author: Denilson Dias 


@Fipe_de_Contratação
Feature: Fipe de Contratação
  
@16.1_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar o acesso a a sessão "Edição de Cálculo"
  Given que eu estou na Home do sistema Auto
  |CT               | Valores                       |topico                    |Cenário                                                                                |
  |CTCAP161R1211EPAC| Antecipação da comissão?      |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar o acesso a a sessão 'Edição de Cálculo'|
  |                 | Desconto venda cruzada (%)    |                          |                                                                                       |
  |                 | CAP (%)                       |                          |                                                                                       |
  |                 | % de Agravo                   |                          |                                                                                       |
  |                 | Comissão (%)                  |                          |                                                                                       |
  |                 | Tabela FIPE (%)               |                          |                                                                                       |
  |                 | Recalcular                    |                          |                                                                                       |
  |                 | Possui co-corretagem?         |                          |                                                                                       |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  Then é exibido o layout da sessão 'Edição de Cálculo' corretamente
  And finalizo a aplicação
  
@16.2_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar o valor mínimo do CAP de 0%
  Given que eu estou na Home do sistema Auto
  |CT               | CAP |topico                    |Cenário                                                                    |
  |CTCAP162R1211EPAC| 0   |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar o valor mínimo do CAP de 0%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When clico no combo box do campo "CAP"
  Then é exibido o valor do campo "CAP"
  And finalizo a aplicação
  
@16.3_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar o valor máximo do CAP de 25%
  Given que eu estou na Home do sistema Auto
  |CT               | CAP |topico                    |Cenário                                                                     |
  |CTCAP163R1211EPAC| 25  |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar o valor máximo do CAP de 25%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When clico no combo box do campo "CAP"
  Then é exibido o valor do campo "CAP"
  And finalizo a aplicação  
  
@16.4_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se são exibidos os valores de 0 à 25
  Given que eu estou na Home do sistema Auto
  |CT               |topico                    |combo|Cenário                                                                             |
  |CTCAP164R1211EPAC|DescontoComercialeComissao| CAP |Desconto Comercial (CAP) e Comissão - Verificar se são exibidos os valores de 0 à 25|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When clico no combo box do campo "CAP"
  Then as opções "CAP" são exibidas conforme esperado
  And  não há duplicidade de informação 
  And finalizo a aplicação  
 
@16.5_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar o valor mínimo da comissão de 0,01%
  Given que eu estou na Home do sistema Auto
  |CT               |Comissao|topico                    |Cenário                                                                            |
  |CTCAP165R1211EPAC|0,01    |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar o valor mínimo da comissão de 0,01%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When edito o campo Comissão
  Then o valor é permitido
  And finalizo a aplicação  
  
@16.6_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar o valor máximo da comissão de 30%
  Given que eu estou na Home do sistema Auto
  |CT               |Comissao|topico                    |Cenário                                                                          |
  |CTCAP166R1211EPAC|30      |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar o valor máximo da comissão de 30%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When edito o campo Comissão
  Then o valor é permitido
  And finalizo a aplicação   
  
@16.7_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Interna o sistema carrega automaticamente na cotação a comissão da apólice anterior.
  Given que eu estou na Home do sistema Auto
  |CT               | botao                  | Menu     | Opção            | AgrupamentoDeRamos|Ramo          |Vencimento|lupa|topico                    |Cenário                                                                                                                                             |
  |CTCAP167R1211EPAC| Filtrar                | Vendas   | gestaorenovacoes | Automóvel         |1211-Automóvel|index2    |1   |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Interna o sistema carrega automaticamente na cotação a comissão da apólice anterior.|
  |                 | Renovar com alteração  |          |                  |                   |              |          |    |                          |                                                                                                                                                    |
    
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Gestão de Renovações'
  And informo a opção 'Automóvel' no combo 'Agrupamento de Ramos'
  And seleciono a primeira opção  no combo 'Vencimento'
  And clico no botão 'Filtrar'
  And clico na primeira opção que tenha disponível o botão de pesquisa 'Lupa'
  And clico no botão 'Renovar com alteração' na seção 'Detalhe da Pesquisa'
  And clico no botao Avançar da nova janela
  And que estou na tela "2. Preço" clico sessão "Edição de Cálculo" da nova janela
  When verifico se o campo Comissão está preenchido com qualquer valor da nova janela
  And finalizo a aplicação   
  
@16.8_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Interna o sistema carrega automaticamente o CAP que o corretor tem cadastrado atualmente
  Given que eu estou na Home do sistema Auto
  |CT               | CAP| botao                  | Menu     | Opção            | AgrupamentoDeRamos|Ramo          |Vencimento|lupa|topico                    |Cenário                                                                                                                                                  |
  |CTCAP168R1211EPAC| 0  | Filtrar                | Vendas   | gestaorenovacoes | Automóvel         |1211-Automóvel|index2    |2   |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Interna o sistema carrega automaticamente o CAP que o corretor tem cadastrado atualmente.|
  |                 | 25 | Renovar com alteração  |          |                  |                   |              |          |    |                          |                                                                                                                                                         |
    
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Gestão de Renovações'
  And informo a opção 'Automóvel' no combo 'Agrupamento de Ramos'
  And seleciono a primeira opção  no combo 'Vencimento'
  And clico no botão 'Filtrar'
  And clico na primeira opção que tenha disponível o botão de pesquisa 'Lupa'
  And clico no botão 'Renovar com alteração' na seção 'Detalhe da Pesquisa'
  And clico no botao Avançar da nova janela
  And que estou na tela "2. Preço" clico sessão "Edição de Cálculo" da nova janela
  When verifico se o campo CAP está preenchido com qualquer valor da nova janela
  And finalizo a aplicação 
    
@16.9_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Externa é carregado a comissão padrão de 25%
  Given que eu estou na Home do sistema Auto
  |CT               | tipo                                       |Comissao|topico                    |Cenário                                                                                                     |
  |CTCAP169R1211EPAC| Renovação de outra seguradora sem sinistro |25,0    |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Externa é carregado a comissão padrão de 25%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When verifico se o campo está preenchido com o valor
  And finalizo a aplicação   

@16.10_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se na Renovação Externa é carregado o CAP atual do corretor
  Given que eu estou na Home do sistema Auto
  |CT                | tipo                                       |CAP|topico                    |Cenário                                                                                               |
  |CTCAP1610R1211EPAC| Renovação de outra seguradora sem sinistro |0  |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se no Seguro Novo é carregado a comissão padrão de 25%|
  |                  |                                            |25 |                          |                                                                                                      |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When verifico se o campo está preenchido com qualquer valor
  And finalizo a aplicação 
    
@16.11_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se no Seguro Novo é carregado a comissão padrão de 25%
  Given que eu estou na Home do sistema Auto
  |CT                | Comissao|topico                    |Cenário                                                                                               |
  |CTCAP1611R1211EPAC| 25,0    |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se no Seguro Novo é carregado a comissão padrão de 25%|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When verifico se o campo está preenchido com o valor
  And finalizo a aplicação    
  
@16.12_R1211_ePac @Executar
 Scenario: Desconto Comercial (CAP) e Comissão - Verificar se no Seguro Novo é carregado o CAP atual do corretor
  Given que eu estou na Home do sistema Auto
  |CT                | CAP|topico                    |Cenário                                                                                              |
  |CTCAP1612R1211EPAC| 0  |DescontoComercialeComissao|Desconto Comercial (CAP) e Comissão - Verificar se no Seguro Novo é carregado o CAP atual do corretor|
  |                  | 25 |                          |                                                                                                     |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And clico no botao Avançar
  And que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'
  When verifico se o campo está preenchido com qualquer valor
  And finalizo a aplicação   
  
   
  
  
  
  