#Author: Denilson Costa Dias



@Caminão
Feature: Testar preenchimento de campos 
  
  
@1.01_R1211_ePac @ExecCaminaoTeste   
 Scenario: Moto - Testar preenchimento de campos 
  Given que eu estou na Home do sistema Caminhão
  | CT                  |Motorista Indeterminado|MotoristaPrinicipal|PossuiSegurodaCarga |RegiãoDeCirculaçãoMaisFrequente|CargaTransportada|topico           |Cenário                                   |
  | CTRLCM101R1211EPAC  |Não                    |index1             |index1              |index1                         |Água             |RadarLiveCaminhao|Caminhão - Testar preenchimento de campos |
  
  And clico no botão Nova Cotação na Home
  And seleciono a opção Caminhão na Modal Nova Cotação
  And preencho todos os demais campos obrigatórios com dados válidos para caminhão
  And clico no botao Avançar 
  And tela "2 preço" cotação Caminhão é exeibida corretamente
  And finalizo a aplicação  