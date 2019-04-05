#Author: Denilson Costa Dias 


@CPF_ou_CNPJ_do_segurado
Feature: CPF  ou  CNPJ do segurado
 R1211 - ePac - CPF  ou  CNPJ do segurado - Validar CPF do segurado com Restrição Técnica

@4.01_R1211_ePac @Executar  
 Scenario: CPF  ou  CNPJ do segurado - Validar CPF do segurado com Restrição Técnica para  Segurado para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem                         |topico           |Cenário                                                                      |
  | CTCPF401R1211EPAC |Restrição técnica para o segurado|CPFCNPJdoSegurado|Validar CPF do segurado com Restrição Técnica para  Segurado para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Restrição Técnica para o Segurado"
  And finalizo a aplicação 

@4.02_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CPF do segurado com Restrição Técnica para  Segurado para Renovação Externa sem Sinistro
  Given que eu estou na Home do sistema Auto
  | CT                |seguro   |tipo                                      |mensagem                         |topico           |Cenário                                                                                         |
  | CTCPF402R1211EPAC |Renovação|Renovação de outra seguradora sem sinistro|Restrição técnica para o segurado|CPFCNPJdoSegurado|Validar CPF do segurado com Restrição Técnica para  Segurado para Renovação Externa sem Sinistro|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Restrição Técnica para o Segurado"
  And finalizo a aplicação   
 
@4.04_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CNPJ do segurado com Restrição Técnica para  Segurado para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |tipo                                      |mensagem                         |sexo     |topico           |Cenário                                                                       |
  | CTCPF404R1211EPAC |Renovação de outra seguradora sem sinistro|Restrição técnica para o segurado|Masculino|CPFCNPJdoSegurado|Validar CNPJ do segurado com Restrição Técnica para  Segurado para Seguro Novo|
  |                   |                                          |Preencha o sexo do condutor.     |         |                 |                                                                              |
  |                   |                                          |Preencha o nome do segurado.     |         |                 |                                                                              |
  |                   |                                          |Data de nascimento.              |         |                 |                                                                              |
  |                   |                                          |Preencha o sexo do segurado.     |         |                 |                                                                              |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Restrição Técnica para o Segurado"
  And finalizo a aplicação  
  
@4.05_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CNPJ do segurado com Restrição Técnica para  Segurado para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |seguro   |tipo                          |mensagem                         |sexo     |topico           |Cenário                                                                       |
  | CTCPF405R1211EPAC |Renovação|Renovação Allianz com sinistro|Restrição técnica para o segurado|Masculino|CPFCNPJdoSegurado|Validar CNPJ do segurado com Restrição Técnica para  Segurado para Seguro Novo|
  |                   |         |                              |Preencha o sexo do condutor.     |         |                 |                                                                              |
  |                   |         |                              |Preencha o nome do segurado.     |         |                 |                                                                              |
  |                   |         |                              |Data de nascimento.              |         |                 |                                                                              |
  |                   |         |                              |Preencha o sexo do segurado.     |         |                 |                                                                              |

  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção "Renovação Allianz com sinistro" no combo "O seguro que você está cotando é" na tela "1. Cotação Auto"
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And informo um "número de CI"
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Restrição Técnica para o Segurado"
  And finalizo a aplicação 
    
@4.07_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CPF do segurado inválido para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem    |topico           |Cenário                                          |
  | CTCPF407R1211EPAC |CPF Inválido|CPFCNPJdoSegurado|Validar CPF do segurado inválido para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  Then exibe a mensagem "CPF inválido" em vermelho
  And finalizo a aplicação     
  
@4.09_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CPF do segurado válido e que já exista na base para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                | Tela    |topico           |Cenário                                                                |
  | CTCPF409R1211EPAC | 2. Preço|CPFCNPJdoSegurado|Validar CPF do segurado válido e que já exista na base para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar 
  Then é exibida a tela '2. Preço'
  And finalizo a aplicação  
  
@4.15_R1211_ePac @Executar
 Scenario: CPF  ou  CNPJ do segurado - Validar CNPJ do segurado válido e que não exista na base para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem                     |sexo     | Tela    |topico           |Cenário                                                                  |
  | CTCPF415R1211EPAC |                             |Masculino| 2. Preço|CPFCNPJdoSegurado|Validar CNPJ do segurado válido e que não exista na base para Seguro Novo|
  |                   |Preencha o sexo do condutor. |         |         |                 |                                                                         |
  |                   |Preencha o nome do segurado. |         |         |                 |                                                                         |
  |                   |Data de nascimento.          |         |         |                 |                                                                         |
  |                   |Preencha o sexo do segurado. |         |         |                 |                                                                         |
  
   
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço'
  And finalizo a aplicação
  
    
  
  
  