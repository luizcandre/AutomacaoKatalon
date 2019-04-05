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
import commands.AutoComandos
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class DiaDePagamentoFuncionalidades extends AutoComandos {


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionaFormaDepagamento(){
		clicarEmElementoDaTela("//button[@data-id='comboPaymentOption_1']", 1)
		clicarEmElementoDaTela("//ul[@class='dropdown-menu inner']//span[text()='"+issue_info.get(0).get("Pagamento")+" S/ JUROS']", 5)
		WebUI.delay(6)
		highlightElement("//div[@class='cobertura-description head-container']")
		adicionaImagem(issue_info.get(0).get("CT"), " Pagamento parcelado selecionado ", "PASSED", 1)
		unHighlightElement("//div[@class='cobertura-description head-container']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaComboDiaDoVencimento(){
		WebUI.delay(10)
		posicaoDaTela("//h4[text()='Informações da conta']")
		clicarEmElementoDaTela("//button[@data-id='diaDeVenc']", 1)
		WebUI.delay(3)
		posicaoDaTela("//h4[text()='Dados do segurado']")
		String xpath ="//div[@class='btn-group bootstrap-select block dropup open']//div[@class='dropdown-menu open']"
		String tag = "span"
		selecionaListaDeElementos(xpath, tag)
	}
}
