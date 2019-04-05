#Author: Denilson Dias 


@CEP_de_Pernoite 
Feature: CEP de Pernoite
           Validar CEP que o CPF/CNPJ estiver cadastrado na base

 
@5.0.1_R1211_ePac  @Executar @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar CEP que o CPF/CNPJ estiver cadastrado na base de cliente sem alterar o CEP para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |topico     |Cenário                                                                                                               |
  | CTCEP501R1211EPAC |CepPernoite|CEP de Pernoite  - Validar CEP que o CPF/CNPJ estiver cadastrado na base de cliente sem alterar o CEP para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos
  And verifico o campo "CEP" que é exibido o campo preenchido
  And clico no botao Avançar 
  Then é exibida a tela '2. Preço'
  And finalizo a aplicação
  
@5.0.2_R1211_ePac  @Executar  @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar CEP que o CPF/CNPJ estiver cadastrado na base de cliente sem alterar o CEP para Endosso
  Given que eu estou na Home do sistema Auto
  | CT                | botao     | Menu     | Opção    | SubOpção     |topico     |Cenário                                                                                                           |
  | CTCEP502R1211EPAC | Selecionar| Vendas   | Endossos | Endosso      |CepPernoite|CEP de Pernoite  - Validar CEP que o CPF/CNPJ estiver cadastrado na base de cliente sem alterar o CEP para Endosso|
  |                   | Aceitar   |          |          |              |           |                                                                                                                  |
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  And verifico o campo "CEP" que é exibido o campo preenchido
  And clico no botao Avançar 
  Then é exibida a tela '2. Preço'
  And finalizo a aplicação
  
@5.0.3_R1211_ePac  @Executar @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar troca de CEP por número inválido para  Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |CEPInválido|topico     |Cenário                                                                      |
  | CTCEP503R1211EPAC |01999999   |CepPernoite|CEP de Pernoite  - Validar troca de CEP por número inválido para  Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When preencho com CPF válido e que tenha CEP cadastrado na base
  When informo "CEP" inválido 
  Then verifico se mensagem de "CEP" é exibida  
  And finalizo a aplicação
  
@5.0.4_R1211_ePac  @Executar @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar troca de CEP por número inválido para Endosso
  Given que eu estou na Home do sistema Auto
  | CT                |CEPInválido| botao     | Menu     | Opção    | SubOpção     |topico     |Cenário                                                                 |
  | CTCEP504R1211EPAC |01999999   | Selecionar| Vendas   | Endossos | Endosso      |CepPernoite|CEP de Pernoite  - Validar troca de CEP por número inválido para Endosso|
  |                   |           | Aceitar   |          |          |              |           |                                                                        |
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  And verifico o campo "CEP" que é exibido o campo preenchido
  When informo "CEP" inválido 
  Then verifico se mensagem de "CEP" é exibida
  And finalizo a aplicação  
  
@5.0.5_R1211_ePac  @Executar @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar troca de CEP por número válido que já busca as informações para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |CEPVálido|Endereço                                    |topico     |Cenário                                                                                                               |
  | CTCEP505R1211EPAC |01309900 |Ou Rua Luís Coelho 26, Consolação, São Paulo|CepPernoite|CEP de Pernoite  - Validar CEP que o CPF/CNPJ estiver cadastrado na base de cliente sem alterar o CEP para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When preencho com CPF válido e que tenha CEP cadastrado na base
  When informo "CEP" válido
  And verifico o campo "CEP" que é exibido o campo preenchido
  Then verifico as informações para "Seguro Novo"
  And finalizo a aplicação  
 
@5.0.6_R1211_ePac  @Executar  @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar troca de CEP por número inválido para Endosso
  Given que eu estou na Home do sistema Auto
  | CT                |CEPVálido|Endereço                                    | botao     | Menu   | Opção    | SubOpção|topico     |Cenário                                                                 |
  | CTCEP506R1211EPAC |01309900 |Ou Rua Luís Coelho 26, Consolação, São Paulo| Selecionar| Vendas | Endossos | Endosso |CepPernoite|CEP de Pernoite  - Validar troca de CEP por número inválido para Endosso|
  |                   |         |                                            | Aceitar   |        |          |         |           |                                                                        |
  
  And clico no menu 'Vendas' na 'Home'
  And clico na oção 'Endossos'
  And clico na opção 'Endosso'
  And informo o número da apólice no campo 'Apolice' 
  And clico no botão 'Selecionar'
  And clico no botão 'Aceitar'
  When informo "CEP" válido
  And verifico o campo "CEP" que é exibido o campo preenchido
  Then verifico as informações para "Seguro Novo"
  And finalizo a aplicação   
  
@5.0.7_R1211_ePac  @Executar  @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar clique no campo "Não sei o CEP" para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |Estado        |Cidade|Endereço                                             |topico     |Cenário                                                                    |
  | CTCEP507R1211EPAC |SAO PAULO (SP)|Osasco|Ou Avenida Antônio Carlos Costa 1, Bela Vista, Osasco|CepPernoite|CEP de Pernoite  - Validar clique no campo "Não sei o CEP" para Seguro Novo|
  |                   |              |      |Avenida                                              |           |                                                                           |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When clique no campo "Não sei o CEP" para Seguro Novo
  And preencho com logradouro, Cidade e Estado válido 
  And clico no botão "OK"
  Then verifico as informações para "Seguro Novo"
  And finalizo a aplicação 
  
@5.0.8_R1211_ePac  @Executar  @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar informações do combo "Selecione o Estado" da janela "Informações do Endereço" para Seguro Novo 
  Given que eu estou na Home do sistema Auto
  | CT                |Estado        |topico     |Cenário                                                                                                                   |
  | CTCEP508R1211EPAC |SAO PAULO (SP)|CepPernoite|CEP de Pernoite  - Validar informações do combo "Selecione o Estado" da janela "Informações do Endereço" para Seguro Novo |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When clique no campo "Não sei o CEP" para Seguro Novo 
  Then valido as informações do combo "Selecione o Estado" da janela "Informações do Endereço"
  And não há duplicidade de informações no combo 'Selecione o Estado'
  And finalizo a aplicação 
 
@5.0.9_R1211_ePac  @Executar  @ExecutarCEPdePernoite
 Scenario: CEP de Pernoite  - Validar preenchimento do campo "Insira o nome da Cidade" da janela "Informações do Endereço" para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |Cidade|MensagemErro        |topico     |Cenário                                                                                                                          |
  | CTCEP509R1211EPAC |Osasco|Informar logradouro!|CepPernoite|CEP de Pernoite  - Validar preenchimento do campo "Insira o nome da Cidade" da janela "Informações do Endereço" para Seguro Novo |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When clique no campo "Não sei o CEP" para Seguro Novo  
  And preencho com a Cidade válida  
  And clico no botão "Buscar"
  Then não exibe nenhuma informação na tela
  And finalizo a aplicação 

@5.0.10_R1211_ePac  @Executar @ExecutarCEPdePernoite 
 Scenario: CEP de Pernoite  - Validar preenchimento do campo "logradouro" da janela "Informações do Endereço" para Seguro Novo 
  Given que eu estou na Home do sistema Auto
  | CT                |Endereço|MensagemErro    |topico     |Cenário                                                                                                              |
  | CTCEP5010R1211EPAC|Avenida |Informar cidade!|CepPernoite|CEP de Pernoite  - Validar preenchimento do campo "logradouro" da janela "Informações do Endereço" para Seguro Novo  |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação  
  When clique no campo "Não sei o CEP" para Seguro Novo 
  And preencho com logradouro válido 
  And clico no botão "Buscar"
  Then não exibe nenhuma informação na tela 
  And finalizo a aplicação 
  
  