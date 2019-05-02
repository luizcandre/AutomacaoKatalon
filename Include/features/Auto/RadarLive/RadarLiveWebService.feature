#Author: your.email@your.domain.com

@RadarLiveWebService
 Feature: que realizo os requests no web service SOAP "gerarCotacao", com corretores atrelados ao motor de calculo antigo e motor de calculo novo.

 @1.01_R1211_ePac   @Executar   
 Scenario: Radar Live - Validar requsições no serviço de gerar cotações no motor de cálculo de prêmios.
  Given que carrego os dados obrigatórios "Body" da requisição SOAP.
  |CT                |Pacote    |Pagamento|Parcela|Diretório  	 																	      |topico    |Cenário                                                   |URL                                                           |
  |CTRL101R1211EPAC  |Compacto 1|1        |1      |RadarLive - PlanoDeTeste_Robo de Cálculo_1211_C.xlsx|RadarLive |Validar pacotes de premios do Auto Seguro Novo Web Service|https://wspre.allianzseguros.com/drswbo05/services/AutoWSOld?wsdl|
  |                  |Compacto 2|1        |1      |              																	     |          |                                                          |https://wspre.allianzseguros.com/drswbo05/services/AutoWS?wsdl|
  |                  |Ampliado 1|1        |1      |              																	     |          |                                                          |                                                              |
  |                  |Ampliado 2|1        |1      |              																	     |          |                                                          |                                                              |
  |                  |Especial  |1        |1      |              																	     |          |                                                          |                                                              |
  |                  |Exclusivo |1        |1      |              																	     |          |                                                          |                                                              |
  
  And realizo a leitura dos dados da planilha
  Then Realiza o Request no Motor de Calculo Antigo e Novo e faz a validação