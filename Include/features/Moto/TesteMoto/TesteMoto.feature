#Author: Denilson Costa Dias



@Moto
Feature: Testar preenchimento de campos 
  
  
@1.03_R1211_ePac   
 Scenario: Moto - Testar preenchimento de campos 
  Given que eu estou na Home do sistema Moto
  | CT                 |topico       |Cenário                               |
  | CTRLM102R1211EPAC  |RadarLiveMoto|Moto - Testar preenchimento de campos |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Moto na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos para moto
  And clico no botao Avançar 
  And tela "2 preço" cotação moto é exeibida corretamente
  And finalizo a aplicação  