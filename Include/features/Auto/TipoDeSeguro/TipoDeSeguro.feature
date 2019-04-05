#Author: Denilson Costa Dias

@mensal_auto
Feature: Validar Tipo de Seguro

@2.01-R1211-E-PAC  @Executar   
 Scenario: Tipo de Seguro - Validar as opções para o combo "O seguro que você está cotando é"  
  Given que eu estou na Home do sistema Auto
  | CT                 | seguro       | Valores                                    | topico       |Cenário                                                                           |
  | CTTS201R1211EPAC   | Nova Cotação | Seguro Novo                                | TipodeSeguro |Tipo de Seguro - Validar as opções para o combo O seguro que você está cotando é  |
  |                    |              | Renovação Allianz sem sinistro             |              |                                                                                  |
  |                    |              | Renovação Allianz com sinistro             |              |                                                                                  |
  |                    |              | Renovação de outra seguradora sem sinistro |              |                                                                                  |
  |                    |              | Renovação de outra seguradora com sinistro |              |                                                                                  |
   
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação 
  When clico no combo 'O seguro que você está cotando é', na tela '1. Cotação Auto' são exibidos as opções
  Then as informações são exibidas conforme esperado
  And não há duplicidade de informações no combo tipo de seguro
  And finalizo a aplicação   
   
@2.02-R1211-E-PAC  @Executar
 Scenario: Tipo de Seguro - Validar quando selecionada a opção Renovação Interna
  Given que eu estou na Home do sistema Auto 
  | CT                 | seguro       | tipo                           | campos                      |topico       | Cenário                                                             |
  | CTTS202R1211EPAC   | Nova Cotação | Renovação Allianz sem sinistro | Qual a sua classe de bônus? |TipodeSeguro |Tipo de Seguro - Validar quando selecionada a opção Renovação Interna|
  |                    |              |                                | Número da CI                |             |                                                                     |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  Then são exibidos os campos 'Qual a sua classe de bônus'
  And  o campo 'Número da CI'. 
  And finalizo a aplicação
  
@2.03-R1211-E-PAC  @Executar
 Scenario: Tipo de Seguro - Validar quando selecionada a opção Renovação Interna
  Given que eu estou na Home do sistema Auto 
  | CT                 | seguro       | tipo                                       | campos                      |topico       | Cenário                                                             |
  | CTTS203R1211EPAC   | Nova Cotação | Renovação de outra seguradora com sinistro | Qual a sua classe de bônus? |TipodeSeguro |Tipo de Seguro - Validar quando selecionada a opção Renovação Interna|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When seleciono a opção 'Renovação de outra seguradora com sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  Then são exibidos os campos 'Qual a sua classe de bônus'
  And finalizo a aplicação
    
@2.04-R1211-E-PAC  @Executar
 Scenario: Tipo de Seguro - Validar a Recuperação de Cotação quando selecionado a opção Emitir 
  Given que eu estou na Home do sistema Auto 
  | CT                 |seguro   | tipo                                       |  Menu     | Botão  | topico       | Cenário                                                                           |
  | CTTS204R1211EPAC   |Renovação| Renovação de outra seguradora com sinistro |  Cotação  | Emitir | TipodeSeguro |Tipo de Seguro - Validar a Recuperação de Cotação quando selecionado a opção Emitir|
  
  And clico no botão Nova Cotação na Home  
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And seleciono a opção 'Renovação de outra seguradora com sinistro' está selecionada no campo 'O seguro que você está cotando é' na tela '1. Cotação Auto'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar 
  And clico no botão de gerar cotação 'Imagem de um Disquete'
  And capturo o número informado na seção 'Número da cotação' 
  And clico no 'x' para fechar o modal
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação' 
  And clico no botão 'Emitir'
  When eu verifico a informação do combo  'O seguro que você está cotando é' na tela 1.Cotação Auto
  Then é exibido o texto 'Renovação de outra seguradora com sinistro' bloqueado para edição.
  And finalizo a aplicação
  
@2.05-R1211-E-PAC  @Executar
 Scenario: Tipo de Seguro - Validar a Recuperação de Cotação quando selecionado a opção Alterar 
  Given que eu estou na Home do sistema Auto 
  | CT                 | seguro   | tipo                                       |  Menu     | Botão   | topico       | Cenário                                                                            |
  | CTTS205R1211EPAC   | Renovação| Renovação de outra seguradora sem sinistro |  Cotação  | Alterar | TipodeSeguro |Tipo de Seguro - Validar a Recuperação de Cotação quando selecionado a opção Alterar|
   
  And clico no botão Nova Cotação na Home  
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar 
  And clico no botão de gerar cotação 'Imagem de um Disquete'
  And capturo o número informado na seção 'Número da cotação' 
  And clico no 'x' para fechar o modal
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação' 
  And clico no botão 'Alterar'
  When eu verifico a informação do combo  'O seguro que você está cotando é' na tela 1.Cotação Auto
  Then é exibido o texto 'Renovação de outra seguradora sem sinistro' livre para edição.
  And finalizo a aplicação
  
@2.06-R1211-E-PAC  @Executar  
 Scenario: Vigência do Seguro - Validar opões do combo "O seguro que você está cotando é" no endosso.  
  Given que eu estou na Home do sistema Auto 
  | CT                 | seguro       | Valores                                    |botao     | Menu     | Opção    | SubOpção |topico       | Cenário                                                                                 |
  | CTTS206R1211EPAC   | Endosso      | Seguro Novo                                |Selecionar| Vendas   | Endossos | Endosso  |TipodeSeguro | Vigência do Seguro - Validar opões do combo O seguro que você está cotando é no endosso.|
  |                    |              | Renovação Allianz sem sinistro             |Aceitar   |          |          |          |             |                                                                                         |
  |                    |              | Renovação Allianz com sinistro             |          |          |          |          |             |                                                                                         |
  |                    |              | Renovação de outra seguradora sem sinistro |          |          |          |          |             |                                                                                         |
  |                    |              | Renovação de outra seguradora com sinistro |          |          |          |          |             |                                                                                         |
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice'
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  When clico no combo 'O seguro que você está cotando é', na tela '1. Cotação Auto' são exibidos as opções
  Then as informações são exibidas conforme esperado
  And não há duplicidade de informações no combo tipo de seguro
  And finalizo a aplicação
  
