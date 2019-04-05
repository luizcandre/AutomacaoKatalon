package funcionalidadesAuto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import commands.AutoComandos
import internal.GlobalVariable
import io.cucumber.datatable.DataTable

public class AssistenciaFuncionalidades extends AutoComandos {

	private static boolean assistencia = false
	private static boolean carroReserva = false
	private static boolean opcaoDeGuincho = false

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicaNobotaoComprarCompacto(){
		clicarEmElementoDaTela("//button[@id='button_1']", 10)
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(){
		String xpath = "//div[contains(@id,'content_null')]"
		selecionaListaDeElementos(xpath, "span")
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")) {
				if(listOfElements[j].getText().equals(issue_info.get(0).get("Clausulas"))) {
					assistencia = true
				}
			}
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaClausula(){
		if(assistencia == true){
			posicaoDaTela("//h2[text()='Confirmação de Pagamento']")
			WebUI.delay(1)
			highlightElementClausula()
			salvarEvidencia(issue_info.get(0).get("CT")," É exibida Cláusula corretamente","PASSED")
			unHighlightElementClausula()
		}else{
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi exibida Cláusula corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementClausula(){
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[3]")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementClausula(){
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[3]")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaPacotes(){
		String xpath = "//div[contains(@id,'content_null')]"
		selecionaListaDeElementos(xpath, "span")
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")) {
				if(listOfElements[j].getText().contains(issue_info.get(0).get("DiasCarroReserva"))) {
					carroReserva = true
				}
			}
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validarDiasDeCarroReserva(){
		String dias = issue_info.get(0).get("DiasCarroReserva")
		if(carroReserva == true){
			posicaoDaTela("//h2[text()='Confirmação de Pagamento']")
			WebUI.delay(1)
			highlightElementCarroReserva(dias)
			salvarEvidencia(issue_info.get(0).get("CT")," "+dias+" Dias para a opção de Carro Reserva è exibida corretamente","PASSED")
			unHighlightElementCarroReserva(dias)
		}else{
			salvarEvidencia(issue_info.get(0).get("CT")," "+dias+" Dias para a opção de Carro Reserva não è exibida corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCarroReserva(String dias){
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='"+dias+" Dias                                 ']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCarroReserva(String dias){
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='"+dias+" Dias                                 ']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaPacotesOpcaoDeGuincho(){
		String xpath = "//div[contains(@id,'content_null')]"
		selecionaListaDeElementos(xpath, "span")
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")) {
				if(listOfElements[j].getText().contains(issue_info.get(0).get("kmGuincho"))) {
					opcaoDeGuincho = true
				}
			}
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validarOpcaoDeGuincho(){
		String km = issue_info.get(0).get("kmGuincho")
		if(opcaoDeGuincho == true){
			posicaoDaTela("//h2[text()='Confirmação de Pagamento']")
			WebUI.delay(1)
			highlightElementKilometragem()
			salvarEvidencia(issue_info.get(0).get("CT")," Opção "+km+" de Guincho exibida corretamente","PASSED")
			unHighlightElementKilometragem()
		}else{
			salvarEvidencia(issue_info.get(0).get("CT")," Opção "+km+" de Guincho exibida não foi exibida corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementKilometragem(){
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='KM Livre                                ']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='500Km                                   '] 	")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementKilometragem(){
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='KM Livre                                ']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='500Km                                   '] 	")
	}
}
