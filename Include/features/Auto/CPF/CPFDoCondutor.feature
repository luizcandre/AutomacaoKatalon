#Author: Denilson Costa Dias 


@CPF_ou_CNPJ_do_segurado
Feature: CPF  ou  CNPJ do segurado
 R1211 - ePac - CPF  ou  CNPJ do segurado - Validar CPF do segurado com Restrição Técnica

@6.01_R1211_ePac @Executar
 Scenario: CPF do Condutor   - Validar CPF do condutor quando diferente do CPF do segurado para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                 |topico     |Cenário                                                                     |
  | CTCPFC601R1211EPAC |CPFCondutor|Validar CPF do condutor quando diferente do CPF do segurado para Seguro Novo|
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  When preencho com o CPF do condutor diferente do segurado
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço'
  And finalizo a aplicação 
  
@6.05_R1211_ePac @Executar
 Scenario: CPF do Condutor   - Validar CNPJ do segurado válido e que não exista na base para Seguro Novo
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem                     |sexo     | Tela    |topico     |Cenário                                                                  |
  | CTCPFC605R1211EPAC|CNPJ Inválido                |Masculino| 2. Preço|CPFCondutor|Validar CNPJ do segurado válido e que não exista na base para Seguro Novo|
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  When preencho com o CNPJ do condutor inválido
  Then é exibida  a mensagem  "CNPJ inválido" em vermelho 
  And finalizo a aplicação
  
@6.06_R1211_ePac @Executar
 Scenario: CPF do Condutor   - Validar quando o condutor possui 100 anos de idade para Seguro Novo quando preencho o campo CPF ou CNPJ do segurado com CNPJ 
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem                              |sexo                        |topico     |Cenário                                                                                                                      |
  | CTCPFC606R1211EPAC|Condutor não pode ter mais de 100 anos|Masculino                   |CPFCondutor|Validar quando o condutor possui 100 anos de idade para Seguro Novo quando prrencho o campo CPF ou CNPJ do segurado com CNPJ |
  |                   |                                      |Preencha o sexo do condutor.|           |                                                                                                                             |
  |                   |                                      |Preencha o nome do segurado.|           |                                                                                                                             |
  |                   |                                      |Data de nascimento.         |           |                                                                                                                             |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Condutor não pode ter mais de 100 anos" 
  And finalizo a aplicação  
  
@6.10_R1211_ePac @Executar @SOLICITAR_MASSA_PARA_CPF_COM_IDADE_99
 Scenario: CPF do Condutor   - Validar quando o condutor possui 99 anos de idade para Seguro Novo quando preencho o campo CPF ou CNPJ do segurado com CPF 
  Given que eu estou na Home do sistema Auto
  | CT                | Tela    |topico     |Cenário                                                                                                                    |
  | CTCPFC610R1211EPAC| 2. Preço|CPFCondutor|Validar quando o condutor possui 99 anos de idade para Seguro Novo quando prrencho o campo CPF ou CNPJ do segurado com CPF |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço' 
  And finalizo a aplicação   
  
@6.11_R1211_ePac @Executar @SOLICITAR_MASSA_PARA_CPF_COM_IDADE_99
 Scenario: CPF do Condutor   - Validar quando o condutor possui 99 anos de idade para Renovação Externa sem sinistro quando preencho o campo CPF ou CNPJ do segurado com CPF 
  Given que eu estou na Home do sistema Auto
  | CT                |tipo                                      | Tela    |topico     |Cenário                                                                                                                                       |
  | CTCPFC611R1211EPAC|Renovação de outra seguradora sem sinistro| 2. Preço|CPFCondutor|Validar quando o condutor possui 99 anos de idade para Renovação Externa sem sinistro quando prrencho o campo CPF ou CNPJ do segurado com CPF |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço' 
  And finalizo a aplicação   
  
@6.13_R1211_ePac @Executar @SOLICITAR_MASSA_PARA_CPF_COM_IDADE_17
 Scenario: CPF do Condutor   - Validar quando o condutor possui 17 anos de idade para Seguro Novo quando preencho o campo CPF ou CNPJ do segurado com CPF 
  Given que eu estou na Home do sistema Auto
  | CT                | Tela    |topico     |Cenário                                                                                                                    |
  | CTCPFC613R1211EPAC| 2. Preço|CPFCondutor|Validar quando o condutor possui 17 anos de idade para Seguro Novo quando prrencho o campo CPF ou CNPJ do segurado com CPF |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço' 
  And finalizo a aplicação   
  
@6.15_R1211_ePac @Executar @SOLICITAR_MASSA_PARA_CPF_COM_IDADE_17
 Scenario: CPF do Condutor   - Validar quando o condutor possui 17 anos de idade para Renovação Externa sem sinistro quando preencho o campo CPF ou CNPJ do segurado com CPF 
  Given que eu estou na Home do sistema Auto
  | CT                |tipo                                      | Tela    |topico     |Cenário                                                                                                                                       |
  | CTCPFC615R1211EPAC|Renovação de outra seguradora sem sinistro| 2. Preço|CPFCondutor|Validar quando o condutor possui 17 anos de idade para Renovação Externa sem sinistro quando prrencho o campo CPF ou CNPJ do segurado com CPF |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'
  And seleciono a opção 1 no campo Qual a sua classe de bônus
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a tela '2. Preço' 
  And finalizo a aplicação     
  
  
@6.16_R1211_ePac @Executar
 Scenario: CPF do Condutor   - Validar quando o condutor possui 100 anos de idade para Seguro Novo quando preencho o campo CPF ou CNPJ do segurado com CPF 
  Given que eu estou na Home do sistema Auto
  | CT                |mensagem                              |topico     |Cenário                                                                                                                     |
  | CTCPFC616R1211EPAC|Condutor não pode ter mais de 100 anos|CPFCondutor|Validar quando o condutor possui 100 anos de idade para Seguro Novo quando prrencho o campo CPF ou CNPJ do segurado com CPF |
  |                   |                                      |           |                                                                                                                            |
  |                   |                                      |           |                                                                                                                            |
  |                   |                                      |           |                                                                                                                            |
    
  And clico no botão Nova Cotação na Home
  And seleciono a opção Automovel na Modal Nova Cotação
  And preencho todos os campos obrigatórios com dados válidos
  And clico no botao Avançar sem parar por mensagem
  Then é exibida a mensagem: "Condutor não pode ter mais de 100 anos" 
  And finalizo a aplicação   
  
  