#Author: Denilson Costa Dias

@Validações_QA_Layout
Feature: Validações QA Layout 


@1.01_R1211_ePac   @Executar 
 Scenario: Tela Login - Validar preenchimento do login com usuário e senha válidos
  Given Dado que eu estou na 'Sessão iniciar' do sistema corretor ePac
  | CT                 |topico       |Cenário                                                                |
  | CTVL101R1211EPAC   |ValidaLayout |Tela Login - Validar preenchimento do login com usuário e senha válidos|
  When eu informo usuário e senha válidos
  And clico no botão 'Aceitar' na 'Sessão iniciar'
  Then  é exibida a tela 'Home'
  And encerro a sessão
  And finalizo a aplicação
  
@1.02_R1211_ePac  @Executar @Teste
 Scenario: Tela Login - Validar preenchimento do login com usuário e senha inválidos
  Given Dado que eu estou na 'Sessão iniciar' do sistema corretor ePac
  | CT                 | mensagem       | topico       |Cenário                                                                  |
  | CTVL102R1211EPAC   | Acesso negado: | ValidaLayout |Tela Login - Validar preenchimento do login com usuário e senha inválidos|
  When eu informo usuário e senha válidos
  And clico no botão 'Aceitar' na 'Sessão iniciar'
  Then  é exibido a mensagem 'Acesso negado'
  And finalizo a aplicação

@1.03_R1211_ePac   @Executar
 Scenario: Tela Home - Verificar se o corretor certo é exibido
  Given que eu estou na Home do sistema Auto 
  | CT                 |corretor                                                    |topico       |Cenário                                            |
  | CTVL103R1211EPAC   |061-A/0617120/0000- M. S. SOLSSIA CORRETORA DE SEGUROS LTDA |ValidaLayout |Tela Home - Verificar se o corretor certo é exibido|
  
  Then é exibido o nomde do corretor correto
  And finalizo a aplicação

@3.01_R1211_ePac  @Executar
 Scenario: Tela Nova Cotação - Verificar o acesso a tela "Cotação Auto".
  Given que eu estou na Home do sistema Auto 
  | CT                 |Tela              |topico       | Cenário                                                   |
  | CTVL301R1211EPAC   |1. Cotação Auto   |ValidaLayout | Tela Nova Cotação - Verificar o acesso a tela Cotação Auto|

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  Then é exibida a tela '1. Cotação Auto'

@4.01_R1211_ePac   @Executar
 Scenario: Tela Cotação Auto - Verificar o layout da tela.
  Given que eu estou na  tela '1. Cotação Auto' verifico o layout dos campos na seguinte ordem
  |CT               | Label                                                    |Lista                                                    |topico       |Cenário                                       | 
  |CTVL401R1211EPAC | Data de início do Seguro:                                |                                                         |ValidaLayout |Tela Cotação Auto - Verificar o layout da tela|
  |                 | Número da operação:                                      |                                                         |             |                                              |
  |                 | Preencha os dados do Segurado e Condutor                 |                                                         |             |                                              |
  |                 | VOCÊ E SEU VEÍCULO PROTEGIDOS COM OS PRINCIPAIS SERVIÇOS:|                                                         |             |                                              |
  |                 |                                                          | Assistência 24hs com possibilidade de reboque ilimitado |             |                                              |
  |                 |                                                          | Carro Reserva de 20 dias ou 30 dias                     |             |                                              |
  |                 |                                                          | Utilização de 2º guincho na mesma pane                  |             |                                              |
  |                 |                                                          | Assistência Vidros VIP                                  |             |                                              |
  |                 |                                                          | Assistência Reparos Residenciais                        |             |                                              |
  |                 |                                                          | E muito mais!                                           |             |                                              |
  |                 | O seguro que você está cotando é:                        |                                                         |             |                                              |
  |                 | CPF ou CNPJ do segurado *                                |                                                         |             |                                              |
  |                 | CEP de pernoite do veículo *                             |                                                         |             |                                               |
  |                 | (Não sei o CEP)                                          |                                                         |             |                                              |
  |                 | O CPF mencionado é o mesmo do Condutor?                  |                                                         |             |                                              |
  |                 | Estado civil do condutor:                                |                                                         |             |                                              |
  |                 | Placa do veículo                                         |                                                         |             |                                              |
  |                 | Chassis do veículo                                       |                                                         |             |                                              |
  |                 | (Selecione o Veículo)                                    |                                                         |             |                                              |
  |                 | Utiliza o veículo comercialmente?                        |                                                         |             |                                              |
  |                 | Veículo possui blindagem?                                |                                                         |             |                                              |
  |                 | O condutor reside com pessoas de 17 a 25 anos?           |                                                         |             |                                              |
  |                 | O principal condutor reside em:                          |                                                         |             |                                              |
  |                 | Data de início da vigência do seguro                     |                                                         |             |                                              |
  |                 | Avançar                                                  |                                                         |             |                                              |
  
  Then é exibido o layout '1. Cotação Auto' corretamente

@4.02_R1211_ePac  @Executar
 Scenario: Tela Cotação Auto - Verificar os campos obrigatórios.
  Given que eu estou na tela '1. Cotação Auto' NÃO preencho nenhum dos campos obrigatórios e aciono o botão 'Avançar'
  Then é exibida a mensagem: 'Obrigatório' para os campos
  |CT               | Label                          | Mensagem     |topico       |Cenário                                              |
  |CTVL402R1211EPAC | CPF ou CNPJ do segurado;       | Obrigatório. |ValidaLayout |Tela Cotação Auto - Verificar os campos obrigatórios.|
  |                 | CEP de pernoite do veículo;    | Obrigatório. |             |                                                     |
  |                 | Estado civil do condutor;      | Obrigatório. |             |                                                     |
  |                 | Chassis do veículo;            | Obrigatório. |             |                                                     |
  |                 | O principal condutor reside em:| Obrigatório. |             |                                                     |

@4.03_R1211_ePac  @Executar
 Scenario: Tela Cotação Auto - Verificar os campos default.
  Given que eu estou na tela '1. Cotação Auto' verifico os campos default, são exibidos os campos na seguinte ordem:
  |CT               | Label	                                               | defaut         |topico       |Cenário                                         |
  |CTVL403R1211EPAC | O seguro que você está cotando é:                    | Seguro Novo    |ValidaLayout |Tela Cotação Auto - Verificar os campos default.|
  |                 | O CPF mencionado é o mesmo do Condutor?              | Sim            |             |                                                |
  |                 | Estado civil do condutor:                            | [SELECIONE...] |             |                                                |
  |                 | Utiliza o veículo comercialmente?                    | Não            |             |                                                |
  |                 | Veículo possui blindagem?                            | Não            |             |                                                |
  |                 | O condutor reside com pessoas de 17 a 25 anos?       | Não            |             |                                                |
  |                 | O principal condutor reside em:                      | [SELECIONE...] |             |                                                |
  |                 | Data de início da vigência do seguro:                | Data do dia    |             |                                                |
  
  Then são exibidos os campos default corretamente
 
@4.04_R1211_ePac  @Executar
 Scenario: Tela Cotação Auto - Verificar o acesso a tela 'Preço'.
 Given que estou na tela '1. Cotação Auto' informo todos os campos obrigatórios 
  | CT                 | Tela       | campos                          | topico       |Cenário                                             |
  | CTVL404R1211EPAC   | 2. Preço   | CPF ou CNPJ do segurado *       | ValidaLayout |Tela Cotação Auto - Verificar o acesso a tela Preço.|
  |                    |            | CEP de pernoite do veículo *    |              |                                                    |
  |                    |            | Estado civil do condutor:       |              |                                                    |
  |                    |            | Chassis do veículo              |              |                                                    |
  |                    |            | O principal condutor reside em: |              |                                                    |
 
 And clico no botao Avançar 
 Then é exibida a tela '2. Preço'
 
 
@5.01_R1211_ePac @Executar
 Scenario: - Tela Preço - Verificar o layout da tela.
  Given que eu estou na  tela '2. Preço' verifico o layout dos campos na seguinte ordem
  |CT               | Label                                               | Lista                    | Pacotes    | Coberturas                 | botao                      |topico       |Cenário                                 |
  |CTVL501R1211EPAC | A Allianz tem o pacote certo para você.             |                          |            |                            | Débito em conta bancária   |ValidaLayout |Tela Preço - Verificar o layout da tela.|
  |                 | Ícone diquete para salvar cotações                  |                          |            |                            | À VISTA                    |             |                                        |
  |                 | Resumo dos dados                                    |                          |            |                            | Comprar                    |             |                                        |
  |                 | Vigência da apólice:                                |                          |            |                            | Comparar itens selecionados|             |                                        |
  |                 | Número da operação                                  |                          |            |                            | Voltar                     |             |                                        |
  |                 | Edição de Cálculo                                   |                          |            |                            |                            |             |                                        |
  |                 | Forma de Pagamento                                  |                          |            |                            |                            |             |                                        |
  |                 | Opção Débito em Conta Bancária ou Boleto Bancário:  | Débito em conta bancária |            |                            |                            |             |                                        |
  |                 |                                                     | Boleto Bancário          |            |                            |                            |             |                                        |
  |                 | Coberturas de acordo com o perfil do risco          |                          |            | Casco                      |                            |             |                                        |
  |                 | Pacotes de acordo com o perfil do risco:            |                          | Ampliado 2 | RCF - Danos Materiais      |                            |             |                                        |
  |                 | Nossa recomendação                                  |                          | Compacto 1 | RCF - Danos Corporais      |                            |             |                                        |
  |                 |                                                     |                          | Compacto 2 | RCF - Danos Morais         |                            |             |                                        |
  |                 | Valor do prêmio para todos  os pacotes disponíveis  |                          | Ampliado 1 | APP - Morte                |                            |             |                                        |
  |                 | Valores das coberturas de cada pacote               |                          | Especial   | APP - Invalidez Permanente |                            |             |                                        |
  |                 | ver comparação                                      |                          | Exclusivo  | Franquia                   |                            |             |                                        |
  |                 |                                                     |                          |            | Assistência 24h            |                            |             |                                        |
  |                 |                                                     |                          |            | Guincho                    |                            |             |                                        |
  |                 |                                                     |                          |            | Carro Reserva              |                            |             |                                        |
  |                 |                                                     |                          |            | Vidros                     |                            |             |                                        |
 
  Then é exibido o layout '2. Preço' corretamente
 
@5.02_R1211_ePac  @Executar
 Scenario: - Tela Preço - Verificar os campos default.
  Given que eu estou na  tela '2. Preço' verifico o campo default, é exibido o campo:
  |CT               | Forma de Pagamento       | topico       |Cenário                                  |
  |CTVL502R1211EPAC | Débito em conta bancária | ValidaLayout |Tela Preço - Verificar os campos default.|
 
 Then é exibido o campo default corretamente em Forma de Pagamento.

@5.03_R1211_ePac  @Executar
 Scenario: - Tela Preço - Verificar o layout da sessão Resumo dos dados.
  Given que eu estou na tela '2. Preço' clico na sessão 'Resumo dos dados'
  Then verifico o layout da sessão 'Resumo dos dados' são exibidos os campos na seguinte ordem:
  |CT               | Veículo             | Dados do condutor | Dados do segurado    | Perfil do condutor                  |topico       |Cenário                                                    |
  |CTVL503R1211EPAC | Veículo             | Dados do condutor | Dados do segurado    | Perfil do condutor                  |ValidaLayout |Tela Preço - Verificar o layout da sessão Resumo dos dados.|
  |                 | Placa:              | CPF:              | CPF:                 | Reside com pessoas de 17 e 25 anos?:|             |                                                           |
  |                 | Chassis:            | Nome do Condutor: | Nome Segurado:       | O principal condutor reside em:     |             |                                                           |
  |                 | Marca:              | Estado Civil:     |                      |                                     |             |                                                           |
  |                 | Modelo:             |                   |                      |                                     |             |                                                           |
  |                 | Versão:             |                   |                      |                                     |             |                                                           |
  |                 | Ano Modelo:         |                   |                      |                                     |             |                                                           |
  |                 | Código Fipe:        |                   |                      |                                     |             |                                                           |
  |                 | Valor Fipe:         |                   |                      |                                     |             |                                                           |
  |                 | Zero KM:            |                   |                      |                                     |             |                                                           |
  |                 | Cep pernoite:       |                   |                      |                                     |             |                                                           |
  |                 | Endereço pernoite:  |                   |                      |                                     |             |                                                           |
  |                 | Veículo blindado:   |                   |                      |                                     |             |                                                           |
  |                 | Uso Comercial:      |                   |                      |                                     |             |                                                           |
 
  Then é exibido o layout da sessão 'Resumo dos dados' corretamente 

@5.04_R1211_ePac  @Executar 
 Scenario: - Tela Preço - Verificar o layout da sessão Edição de Cálculo.
  Given que eu estou na tela '2. Preço' clico na sessão 'Edição de Cálculo'
  When verifico o layout da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:
  |CT               | Valores                       |topico       |Cenário                                                     |
  |CTVL504R1211EPAC | Antecipação da comissão?      |ValidaLayout |Tela Preço - Verificar o layout da sessão Edição de Cálculo.|
  |                 | Desconto venda cruzada (%)    |             |                                                            |
  |                 | CAP (%)                       |             |                                                            |
  |                 | % de Agravo                   |             |                                                            |
  |                 | Comissão (%)                  |             |                                                            |
  |                 | Tabela FIPE (%)               |             |                                                            |
  |                 | Recalcular                    |             |                                                            |
  |                 | Possui co-corretagem?         |             |                                                            |

  Then é exibido o layout da sessão 'Edição de Cálculo' corretamente

@5.05_R1211_ePac @Executar @DEPENDE_DE_MASSA  
 Scenario: - Tela Preço - Verificar os campos default da sessão Edição de Cálculo.
  Given eu estou na tela '2. Preço' verifico os campos default da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:
  |CT               | Campos                        | Valores |topico       |Cenário                                                              |
  |CTVL505R1211EPAC | Antecipação da comissão?      | Sim     |ValidaLayout |Tela Preço - Verificar os campos default da sessão Edição de Cálculo.|
  |                 | Desconto venda cruzada (%)    | 0       |             |                                                                     |
  |                 | CAP (%)                       | 20      |             |                                                                     |
  |                 | % de Agravo                   | 0,0     |             |                                                                     |
  |                 | Comissão (%)                  | 18,0    |             |                                                                     |
  |                 | Tabela FIPE (%)               | 90      |             |                                                                     |
  |                 | Possui co-corretagem?         | Não     |             |                                                                     |

  Then são exibidos os campos default da sessão 'Edição de Cálculo' corretamente
 
############################################################################################################################ 
  
#@5.06_R1211_ePac  @NÃO_EXECUTAR
 #Scenario: - Tela Preço - Tela Preço - Verificar o acesso a tela "Salvar Cotação".
  #Given que eu estou na tela '2. Preço' clico no ícone 'Salvar Cotação'
  #| CT                 |topico       |
  #| CTVL506R1211EPAC   |ValidaLayout |
  #
  #Then é exibida a tela 'Salvar Cotação'
  #
#@5.07_R1211_ePac  @NÃO_EXECUTAR
 #Scenario: - Tela Preço - Tela Preço - Verificar o acesso a tela "Salvar Cotação".
  #Given que eu estou na tela 'Salvar Cotação'  verifico o layout da tela 'Salvar Cotação' são exibidos os campos na seguinte ordem:
  #| CT                 | Valores                                      |topico       |
  #| CTVL507R1211EPAC   | A Allianz tem o pacote certo para você.      |ValidaLayout |
  #|                    | Essa cotação é válida até o dia              |             |
  #|                    | Número da cotação                            |             |
  #|                    | Dados do cliente                             |             |
  #|                    | Insira o endereço de e-mail do cliente       |             |
  #|                    | Enviar uma cópia para o meu e-mail           |             |
  #|                    | Pacotes:                                     |             |
  #|                    | Relação de ""Pacotes"" disponíveis           |             |
  #|                    | Enviar e-mail                                |             |
  #|                    | Baixar PDF                                   |             |
         #
  #Then é exibido o layout da tela 'Salvar Cotação' corretamente.
#
#@5.08_R1211_ePac  @NÃO_EXECUTAR
 #Scenario: - Tela Preço - Verificar os campos default da tela "Salvar Cotação".
  #Given que eu estou na tela 'Salvar Cotação' verifico todos os 'Pacotes' disponíveis; Selecionados 
  #| CT                 | Valor       |topico       |
  #| CTVL508R1211EPAC   | Selecionado |ValidaLayout |
  #
  #Then são exibidos os campos default da tela 'Salvar Cotação' corretamente.
 
 ############################################################################################################################
 
@5.09_R1211_ePac  @Executar
 Scenario: - Tela Preço - Verificar o acesso a tela "3.Pagamento".
  Given que eu estou na tela '2. Preço' clico no botão 'Comprar' de um dos pacotes disponíveis: 
  | CT                 | Tela        |topico       |Cenário                                            | 
  | CTVL509R1211EPAC   | 3.Pagamento |ValidaLayout |Tela Preço - Verificar o acesso a tela 3.Pagamento.|
  
  Then é exibida a tela '3.Pagamento' 
 
@6.01_R1211_ePac  @Executar
 Scenario: - Tela Pagamento - Verificar o layout da tela.
  Given que eu estou na tela '3. Pagamento' verifico o layout da tela 'Pagamento' com forma de pagamento 'Débito em conta bancária' são exibidos os campos na seguinte ordem:
  | CT                 | Tela         | Campos                                                       | Botão   |topico       |Cenário                                     |
  | CTVL601R1211EPAC   | 3. Pagamento | Resumo dos dados                                             |         |ValidaLayout |Tela Pagamento - Verificar o layout da tela.|
  |                    |              | Número da cotação                                            |         |             |                                            |
  |                    |              | Número da operação                                           |         |             |                                            |
  |                    |              | Vigência da apólice:                                         |         |             |                                            |
  |                    |              | Dados do segurado                                            |         |             |                                            |
  |                    |              | E-mail do segurado *                                         |         |             |                                            |
  |                    |              | Estrangeiro                                                  |         |             |                                            |
  |                    |              | Celular *                                                    |         |             |                                            |
  |                    |              | Profissão *                                                  |         |             |                                            |
  |                    |              | Renda mensal *                                               |         |             |                                            |
  |                    |              | Receber documentos relacionados à apólice apenas por email?  |         |             |                                            |
  |                    |              | Informações da conta                                         |         |             |                                            |
  |                    |              | Tipo de Conta                                                |         |             |                                            |
  |                    |              | Banco                                                        |         |             |                                            |
  |                    |              | Agência                                                      |         |             |                                            |
  |                    |              | DCO                                                          |         |             |                                            |
  |                    |              | N.de Conta                                                   |         |             |                                            |
  |                    |              | DCC                                                          |         |             |                                            |
  |                    |              | Beneficiário credor é outro?                                 | Sim     |             |                                            |
  |                    |              |                                                              | Não     |             |                                            |
  |                    |              | Data Vencimento da Parcela:                                  |         |             |                                            |
  |                    |              | Você é o titular da conta?                                   | Sim     |             |                                            |
  |                    |              |                                                              | Não     |             |                                            |
  |                    |              | Endereço do segurado                                         |         |             |                                            |
  |                    |              | CEP de correspondência *                                     |         |             |                                            |
  |                    |              | (Não sei o CEP)                                              |         |             |                                            |
  |                    |              | Endereço *                                                   |         |             |                                            |
  |                    |              | Número *                                                     |         |             |                                            |
  |                    |              | S/N                                                          |         |             |                                            |
  |                    |              | Complemento                                                  |         |             |                                            |
  |                    |              | Bairro *                                                     |         |             |                                            |
  |                    |              | Cidade                                                       |         |             |                                            |
  |                    |              | Estado                                                       |         |             |                                            |
  |                    |              |                                                              | Avançar |             |                                            |
  |                    |              |                                                              | Voltar  |             |                                            |
   
  Then é exibido o layout da tela 'Pagamento Débito em conta bancária' corretamente.   
  
@6.02_R1211_ePac @Executar
 Scenario: - Tela Preço - Altera forma de pagamento da tela '2. Preço'.
  Given que eu estou na tela '2. Preço' e altero a forma de pagamento  
  | CT                 | Pagamento       | Tela     | Botão  |topico       |Cenário                                                 |
  | CTVL602R1211EPAC   | Boleto Bancário | 2. Preço | Comprar|ValidaLayout |Tela Preço - Altera forma de pagamento da tela 2. Preço.|
  
  And clico no botão 'Comprar'
  Then é exibida a tela '3.Pagamento'   

@6.03_R1211_ePac  @Executar
 Scenario: - Tela Pagamento - Verificar o layout da tela.
  Given que eu estou na tela '3. Pagamento' verifico o layout da tela 'Pagamento' com forma de pagamento 'boleto bancário' são exibidos os campos na seguinte ordem:
  | CT                 | Tela         | Campos                                                             | Botão   |topico       |Cenário                                     |
  | CTVL603R1211EPAC   |              | Resumo dos dados                                                   |         |ValidaLayout |Tela Pagamento - Verificar o layout da tela.|
  |                    |              | Vigência da apólice                                                |         |             |                                            |
  |                    |              | Número da cotação                                                  |         |             |                                            |
  |                    |              | Número da operação                                                 |         |             |                                            |
  |                    |              | Texto: Forma de pagamento; (Selecionada na tela anterior 2.Preço)  |         |             |                                            |
  |                    |              | Texto: Pacote selecionado; (Selecionado na tela anterior 2.Preço). |         |             |                                            |
  |                    |              | Valor do seguro                                                    |         |             |                                            |
  |                    |              | Dados do segurado                                                  |         |             |                                            |
  |                    |              | E-mail do segurado *                                               |         |             |                                            |
  |                    |              | Estrangeiro                                                        |         |             |                                            |
  |                    |              | Celular *                                                          |         |             |                                            |
  |                    |              | Profissão *                                                        |         |             |                                            |
  |                    |              | Renda mensal *                                                     |         |             |                                            |
  |                    |              | Receber documentos relacionados à apólice apenas por email?        |         |             |                                            |
  |                    |              | Boleto bancário                                                    |         |             |                                            |
  |                    |              | Forma de pagamento                                                 |         |             |                                            |
  |                    |              | Adicionar cláusula beneficiaria?                                   | Sim     |             |                                            |  
  |                    |              |                                                                    | Não     |             |                                            |                                                
  |                    |              | Dia de vencimento                                                  |         |             |                                            |
  |                    |              | Data de saída da nota fiscal do seu carro 0km                      |         |             |                                            |
  |                    |              | Endereço do segurado                                               |         |             |                                            |
  |                    |              | CEP de correspondência *                                           |         |             |                                            |
  |                    |              | (Não sei o CEP)                                                    |         |             |                                            |
  |                    |              | Endereço *                                                         |         |             |                                            |
  |                    |              | Número *                                                           |         |             |                                            |
  |                    |              | S/N                                                                |         |             |                                            |
  |                    |              | Complemento                                                        |         |             |                                            |
  |                    |              | Bairro *                                                           |         |             |                                            |
  |                    |              | Cidade                                                             |         |             |                                            |
  |                    |              | Estado                                                             |         |             |                                            |
  |                    |              |                                                                    | Avançar |             |                                            |
  |                    |              |                                                                    | Voltar  |             |                                            |
   
  Then é exibido o layout da tela 'Pagamento com Boleto' corretamente.    
  
@6.04-R1211-E-PAC  @Executar  
 Scenario: Tipo de Seguro - Validar as opções para o combo 'Renda mensal'  
  Given que eu estou na tela '3. Pagamento'
  | CT                 |  Valores                        | topico       |Cenário                                                     | 
  | CTVL604R1211EPAC   |  Até R$1.500,00                 | ValidaLayout |Tipo de Seguro - Validar as opções para o combo Renda mensal|
  |                    |  De R$ 1.501,00 Até R$3.000,00  |              |                                                            |
  |                    |  De R$ 3.301,00 Até R$5.000,00  |              |                                                            |
  |                    |  De R$ 5.001,00 Até R$10.000,00 |              |                                                            |
  |                    |  Acima de R$10.000,00           |              |                                                            |
   
  When Quando clico no combo 'Renda mensal ', na tela '3. Pagamento' são exibidos as opções
  Then as informações são exibidas conforme esperado do combo 'Renda mensal'
  And não há duplicidade de informação no combo 'Renda mensal'
 
@6.05_R1211_ePac  @Executar
 Scenario: - Tela Pagamento - Verificar os campos obrigatórios.
  Given que eu estou na tela '3. Pagamento' verifico as mensagens 'Obrigatório' para os campos 
  | CT                 | Campos                                        | Mensagem     | topico       |Cenário                                           |
  | CTVL605R1211EPAC   | E-mail do segurado                            | Obrigatório. | ValidaLayout |Tela Pagamento - Verificar os campos obrigatórios.|
  |                    | Telefone                                      | Obrigatório. |              |                                                  |
  |                    | Profissão                                     | Obrigatório. |              |                                                  |
  |                    | Renda mensal                                  | Obrigatório. |              |                                                  |
  |                    | CEP de correspondência                        | Obrigatório. |              |                                                  |
  |                    | Número                                        | Obrigatório. |              |                                                  |
  
  Then é exibida a mensagem 'Obrigatório' para os campos
  And os campos são destacados na tela '3. Pagamento'.
  
@6.06_R1211_ePac  @Executar
 Scenario: - Tela Pagamento - Verificar os campos default.
  Given que eu estou na tela '3. Pagamento' verifico os campos default exibidos os campos na seguinte ordem 
  | CT                 | Campos                                                       | Botão |topico       |Cenário                                      |
  | CTVL606R1211EPAC   | Receber documentos relacionados à apólice apenas por email?  |       |ValidaLayout |Tela Pagamento - Verificar os campos default.|
  |                    | Adicionar cláusula beneficiaria?                             | Não   |             |                                             |
  
  Then são exibidos os campos default da tela '3.Pagamento' corretamente
  
@6.07_R1211_ePac @Executar 
 Scenario: - Tela Pagamento - Verificar os campos default.
  Given que eu estou na tela '3. Pagamento' clico na sessão 'Resumo dos dados'
  Then verifico o layout da sessão 'Resumo dos dados' na tela '3. Pagamento' são exibidos os campos na seguinte ordem: 
  |CT               | Veículo             | Dados do condutor | Dados do segurado    | Perfil do condutor                  |topico       |Cenário                                      |
  |CTVL607R1211EPAC | Veículo             | Dados do condutor | Dados do segurado    | Perfil do condutor                  |ValidaLayout |Tela Pagamento - Verificar os campos default.|
  |                 | Placa:              | CPF:              | CPF:                 | Reside com pessoas de 17 e 25 anos?:|             |                                             |
  |                 | Chassis:            | Nome do Condutor: | Nome Segurado:       | O principal condutor reside em:     |             |                                             |
  |                 | Marca:              | Estado Civil:     |                      |                                     |             |                                             |
  |                 | Modelo:             |                   |                      |                                     |             |                                             |
  |                 | Versão:             |                   |                      |                                     |             |                                             |
  |                 | Ano Modelo:         |                   |                      |                                     |             |                                             |
  |                 | Código Fipe:        |                   |                      |                                     |             |                                             |
  |                 | Valor Fipe:         |                   |                      |                                     |             |                                             |
  |                 | Zero KM:            |                   |                      |                                     |             |                                             |
  |                 | Cep pernoite:       |                   |                      |                                     |             |                                             |
  |                 | Endereço pernoite:  |                   |                      |                                     |             |                                             |
  |                 | Veículo blindado:   |                   |                      |                                     |             |                                             |
  |                 | Uso Comercial:      |                   |                      |                                     |             |                                             |
  
  Then são exibidos os campos default 'Resumo dos dados' da tela '3.Pagamento' corretamente
  
@6.08_R1211_ePac  @Executar
 Scenario: - Tela Pagamento - Verificar os campos default.
  Given que eu estou na tela '3. Pagamento' informo todos os campos obrigatórios
  | CT                 | Campos                                        | topico       |Cenário                                      |
  | CTVL608R1211EPAC   | E-mail do segurado                            | ValidaLayout |Tela Pagamento - Verificar os campos default.|
  |                    | Telefone                                      |              |                                             |
  |                    | Profissão                                     |              |                                             |
  |                    | Renda mensal                                  |              |                                             |
  |                    | CEP de correspondência                        |              |                                             |
  |                    | Número                                        |              |                                             |
  
  When aciono o botão 'Avançar'
  Then é exibida a tela 'Confirmação de Pagamento' 
  
@7.01_R1211_ePac @Executar 
 Scenario: - Tela Confirmação de Pagamento - Verificar o layout da tela.
  Given que eu estou na tela 'Confirmação de Pagamento'verifico se o layout da tela são exibidos os campos na seguinte ordem
  | CT                 | Campos                                        | botao   | topico       |Cenário                                                                            |
  | CTVL701R1211EPAC   | Veículo                                       | Voltar  | ValidaLayout |Tela Confirmação de Pagamento - Verificar o layout da tela.Confirmação de Pagamento|
  |                    | Uso veículo                                   | Emitir  |              |                                                                                   |
  |                    | Dados do condutor                             |         |              |                                                                                   |
  |                    | Dados do segurado                             |         |              |                                                                                   |
  |                    | Perfil do condutor                            |         |              |                                                                                   |
  |                    | Características do seguro escolhido           |         |              |                                                                                   |
  |                    | Forma de pagamento                            |         |              |                                                                                   |
  |                    | Valor do Seguro                               |         |              |                                                                                   |
  |                    | Cláusulas                                     |         |              |                                                                                   |
  |                    | Para o Corretor                               |         |              |                                                                                   |
  |                    | Confirmação de Pagamento                      |         |              |                                                                                   |
  |                    | Data de início do Seguro:                     |         |              |                                                                                   |
  |                    | Número da operação:                           |         |              |                                                                                   |
  |                    | Resumo dos dados                              |         |              |                                                                                   |

  Then é exibido o layout da tela 'Confirmação de Pagamento' corretamente 
  
@7.02_R1211_ePac  @Executar
 Scenario: - Tela Confirmação de Pagamento - Verificar o layout da tela.
  Given que eu estou na tela 'Confirmação de Pagamento' verifico o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' são exibidos os campos na seguinte ordem
  | CT               | Veiculo     | UsoVeiculo           | DadosDoCondutor | DadosDoSegurado        | PerfilDoCondutor                    | topico       |Cenário                                                                     |
  | CTVL702R1211EPAC | Placa:      | Endereço de Pernoite:| CPF:            | CPF:                   | Reside com pessoas de 17 e 25 anos?:| ValidaLayout |Tela Confirmação de Pagamento - Verificar o layout da tela. Resumo dos dados|
  |                  | Chassis:    | Utilização Comercial:| Nome:           | Nome:                  | O principal condutor reside em:     |              |                                                                            |
  |                  | Ano:        | Cep Pernoite:        | Email:          | Email:                 |                                     |              |                                                                            |
  |                  | Marca:      |                      | Estado Civil:   | Profissão:             |                                     |              |                                                                            |
  |                  | Modelo:     |                      |                 | Renda Mensal:          |                                     |              |                                                                            |
  |                  | Versão:     |                      |                 | Estado Civil:          |                                     |              |                                                                            |
  |                  | Código Fipe:|                      |                 | Telefone:              |                                     |              |                                                                            |
  |                  | Valor Fipe: |                      |                 | CEP:                   |                                     |              |                                                                            |
  |                  | Blindagem:  |                      |                 | Endereço de residência:|                                     |              |                                                                            |
  |                  | Zero Km:    |                      |                 |                        |                                     |              |                                                                            |

  Then é exibido o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' corretamente 
  
@7.03_R1211_ePac  @Executar
 Scenario: - Tela Confirmação de Pagamento - Verificar o layout da tela.
  Given que eu estou na tela 'Confirmação de Pagamento' verifico o layout das características do 'seguro' da tela 'Confirmação de Pagamento' são exibidos os campos na seguinte ordem
  | CT               | CaracterísticasDoSeguroEscolhido| FormaDePagamento  | ValorDoSeguro| Clausulas                                                          | ParaCorretor            | topico      |Cenário                                                                              |
  | CTVL703R1211EPAC | Pacote:                         | Boleto            | Total:       | 252   -   Valor de Mercado Referenciado - Valor Econômico          | Antecipação da comissão:| ValidaLayout|Tela Confirmação de Pagamento - Verificar o layout da tela. Características do Seguro|
  |                  | Casco                           | Dia de vencimento:|              | 253   -   Molicar - 2a. tabela de Referência - Revista Carro       | Desconto venda cruzada: |             |                                                                                     |
  |                  | RCF Danos Materiais             |                   |              | 1030   -   Assistência VIP 24 HS - km livre - 30 Dias Carro Reserva| Fipe:                   |             |                                                                                     |
  |                  | RCF Danos Corporais             |                   |              | 2105   -   Vidros - Plano VIP                                      | Cap:                    |             |                                                                                     |
  |                  | RCF Danos Morais                |                   |              |                                                                    | Comissão:               |             |                                                                                     |
  |                  | APP Morte                       |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | APP Invalidez                   |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | Franquia                        |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | Assistência 24h                 |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | Guincho                         |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | Carro Reserva                   |                   |              |                                                                    |                         |             |                                                                                     |
  |                  | Vidros                          |                   |              |                                                                    |                         |             |                                                                                     |
  
  Then é exibido o layout das características do 'seguro' da tela 'Confirmação de Pagamento' corretamente 
  
#@7.04_R1211_ePac  @ExecutarValidaLayout
 #Scenario: -  Tela Confirmação de Pagamento - Verificar o acesso a tela "Emissão Finalizada".
  #Given que estou na tela 'Confirmação de Pagamento'
  #| CT               | tela                     | topico      |Cenário                                                                                                       |
  #| CTVL704R1211EPAC | Confirmação de Pagamento | ValidaLayout|Tela Confirmação de Pagamento - Verificar o acesso a tela 'Emissão Finalizada'.Tela 'Confirmação de Pagamento'|
 
 And finalizo a aplicação








  