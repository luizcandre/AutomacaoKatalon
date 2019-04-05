#Author: Denilson Costa Dias 

@mensal_auto
Feature: Validar vigências

    
@1.01-R1211-E-PAC  @Executar  
 Scenario: Vigência do Seguro - Validar Vigência futura com até 30 dias 
  Given que eu estou na Home do sistema Auto 
  | CT                 | vigencia | chave |topico           | Cenário                                                                           |
  | CTVG101R1211EPAC   | 365      | 21    |VigenciaDoSeguro | Vigência do Seguro - Validar Vigência futura com até 30 dias. Período de vigência de 365 dias|

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And seleciono uma data dentro do periodo de 30 dias futuros no campo Data de inicio de vigência do seguro
  And clico no botao Avançar 
  When verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço 
  Then é exibido um período igual a 365 dias  
  And finalizo a aplicação
    
@1.02-R1211-E-PAC  @Executar   
 Scenario: Vigência do Seguro - Validar tentativa de seleção de vigência fora do perìodo de 30 dias, inferior. 
  Given que eu estou na Home do sistema Auto 
  | CT                 | topico           | Cenário                                                                                                                           |
  | CTVG102R1211EPAC   | VigenciaDoSeguro |Vigência do Seguro - Validar tentativa de seleção de vigência fora do perìodo de 30 dias, inferior. Campo desabilitado para seleção|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  When seleciono uma data inferior á data atual 
  Then o campo do dia é exibido desabilitado para seleção
  And finalizo a aplicação
  
@1.03-R1211-E-PAC  @Executar 
 Scenario: Vigência do Seguro - Validar tentativa de seleção de alteração da data de fim de vigência da apólice por endosso.  
  Given que eu estou na Home do sistema Auto 
  | CT                 | botao     | Menu     | Opção    | SubOpção     | topico           |dtFinalVigencia| Cenário                                                                                                         |
  | CTVG103R1211EPAC   | Selecionar| Vendas   | Endossos | Endosso      | VigenciaDoSeguro |04/10/2019     |Vigência do Seguro - Validar tentativa de seleção de alteração da data de fim de vigência da apólice por endosso.|
  |                    | Aceitar   |          |          |              |                  |               |                                                                                                                 |                   
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  And clico no botao Avançar 
  When verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço 
  Then a data de fim de vigência é exibida sem alteração  
  And finalizo a aplicação
   
@1.04-R1211-E-PAC  @Executar   
 Scenario: Vigência do Seguro - Validar Vigência igual a 365 dias Seguro Novo 
  Given que eu estou na Home do sistema Auto 
  | CT                 | vigencia| topico           |downloadPath       |arquivo        |Cenário                                                            |
  | CTVG104R1211EPAC   | 365     | VigenciaDoSeguro |C://Users//Public//|retrievedoc.pdf|Vigência do Seguro - Validar Vigência igual a 365 dias Seguro Novo |
   
  And clico no botão Nova Cotação na Home 
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a informação do campo 'Vigência' na seção 'Dados Gerais' no PDF
  Then é exibido um período igual a 365 dias no PDF
  And finalizo a aplicação 
   
@1.05-R1211-E-PAC @Executar  
 Scenario: Vigência do Seguro - Validar Vigência igual a 365 dias Renovação Interna digitada 
  Given que eu estou na Home do sistema Auto 
  | CT                 |seguro   | tipo                          | vigencia| topico           |downloadPath       |arquivo        |Cenário                                                            |
  | CTVG105R1211EPAC   |Renovação| Renovação Allianz sem sinistro| 365     | VigenciaDoSeguro |C://Users//Public//|retrievedoc.pdf|Vigência do Seguro - Validar Vigência igual a 365 dias Seguro Novo |
   
  And clico no botão Nova Cotação na Home 
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto' 
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And informo o 'Número da CI'
  And clico no botao Avançar 
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação'
  And verifico a informação do campo 'Vigência' na seção 'Dados Gerais' no PDF
  Then é exibido um período igual a 365 dias no PDF
  And finalizo a aplicação

@1.06-R1211-E-PAC  @Executar  
 Scenario: Vigência do Seguro - Validar Vigência igual a 365 dias Renovação Interna pelo Gestão de Renovações 
  Given que eu estou na Home do sistema Auto 
  | CT                 | vigencia|downloadPath       |arquivo        | botao                | Menu     | Opção            | AgrupamentoDeRamos |Ramo          |Vencimento|lupa|topico           |Cenário                                                                                           |
  | CTVG106R1211EPAC   | 365     |C://Users//Public//|retrievedoc.pdf| Filtrar              | Vendas   | gestaorenovacoes | Automóvel          |1211-Automóvel|index2    |1   |VigenciaDoSeguro |Vigência do Seguro - Validar Vigência igual a 365 dias Renovação Interna pelo Gestão de Renovações|
  |                    |         |                   |               | Renovar com alteração|          |                  |                    |              |          |    |                 |                                                                                                  |                                                                                                                                    
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Gestão de Renovações'
  And informo a opção 'Automóvel' no combo 'Agrupamento de Ramos'
  And seleciono a primeira opção  no combo 'Vencimento'
  And clico no botão 'Filtrar'
  And clico na primeira opção que tenha disponível o botão de pesquisa 'Lupa'
  And clico no botão 'Renovar com alteração' na seção 'Detalhe da Pesquisa'
  And clico no botao Avançar da nova janela
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação' da nova janela
  And verifico a informação do campo 'Vigência' na seção 'Dados Gerais' no PDF
  Then é exibido um período igual a 365 dias no PDF
  And finalizo a aplicação
  
@1.07-R1211-E-PAC  @Executar     
 Scenario: Vigência do Seguro - Validar Vigência igual a 365 dias Renovação Externa 
  Given que eu estou na Home do sistema Auto 
  | CT                 |seguro   | tipo                                      | vigencia| topico           |downloadPath       |arquivo        |Cenário                                                                  |
  | CTVG107R1211EPAC   |Renovação| Renovação de outra seguradora com sinistro| 365     | VigenciaDoSeguro |C://Users//Public//|retrievedoc.pdf|Vigência do Seguro - Validar Vigência igual a 365 dias Renovação Externa |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto
  And seleciono a opção Renovação de outra seguradora com sinistro está selecionada no campo O seguro que você está cotando é
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar
  When que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  And clico no botão 'Baixar PDF' no modal 'Cotação' da nova janela
  When verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço
  And verifico a informação do campo 'Vigência' na seção 'Dados Gerais' no PDF
  Then é exibido um período igual a 365 dias no PDF
  And finalizo a aplicação
 
@1.08-R1211-E-PAC  @Executar  
 Scenario: Vigência do Seguro - Validar Vigência na Recuperação de Cotação pelo botão Emitir  
  Given que eu estou na Home do sistema Auto
  | CT                 | vigencia| Menu     | Botão  | topico           | Cenário                                                                          |
  | CTVG108R1211EPAC   | 365     | Cotação  | Emitir | VigenciaDoSeguro | Vigência do Seguro - Validar Vigência na Recuperação de Cotação pelo botão Emitir|
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  And clico no botão 'Emitir'
  And clico no botao Avançar 
  When verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço 
  Then é exibido um período igual a 365 dias
  And finalizo a aplicação
   
@1.09-R1211-E-PAC  @Executar   
 Scenario: Vigência do Seguro - Validar Vigência na Recuperação de Cotação pelo botão Alterar
  Given que eu estou na Home do sistema Auto
  | CT                 | vigencia| Menu     | Botão    | topico           | Cenário                                                                          |
  | CTVG109R1211EPAC   | 365     | Cotação  | Alterar  | VigenciaDoSeguro |Vigência do Seguro - Validar Vigência na Recuperação de Cotação pelo botão Alterar|
  |                    |         |          | Tarificar|                  |                                                                                  |
  
  And informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'
  And clico na opção 'Cotação' e acesso a tela 'Cotação'
  And clico no botão 'Alterar'
  And clico no botao Avançar 
  When verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço 
  Then é exibido um período igual a 365 dias
  And finalizo a aplicação






