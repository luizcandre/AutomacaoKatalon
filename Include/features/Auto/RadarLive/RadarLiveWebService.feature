#Author: your.email@your.domain.com

@RadarLiveWebService
 Feature: que realizo os requests no web service SOAP "gerarCotacao", com corretores atrelados ao motor de calculo antigo e motor de calculo novo.

 @1.01_R1211_ePac   @Executar   
 Scenario: Radar Live - Validar requsições no serviço de gerar cotações no motor de cálculo de prêmios.
  Given que carrego os dados obrigatórios "Body" da requisição SOAP.
  |CT                |Pacote    |Pagamento|Parcela|Diretório  |topico    |Cenário                                                   |URL                                                           		|
  |CTRL101R1211EPAC  |Compacto 1|1        |1      |request.xml|RadarLive |Validar pacotes de premios do Auto Seguro Novo Web Service|https://wspre.allianzseguros.com/drswbo05/services/AutoWSOld?wsdl|
  |                  |Compacto 2|1        |1      |request.xml|          |                                                          |https://wspre.allianzseguros.com/drswbo05/services/AutoWSOld?wsdl|
  |                  |Ampliado 1|1        |1      |           |          |                                                          |                                                              		|
  |                  |Ampliado 2|1        |1      |           |          |                                                          |                                                              		|
  |                  |Especial  |1        |1      |           |          |                                                          |                                                              		|
  |                  |Exclusivo |1        |1      |           |          |                                                          |                                                              		|
  
  And realizo requests no WebService no motor de Calculo Antigo
  And obtenho os dados do WebService antigo
  And realizo requests no WebService no motor de Calculo Novo
  And obtenho os dados do WebService Novo
  Then verifico se não existem diferenças no cálculo dos pacotes no documento xml respota do web service.
  And finaliza a automação
  