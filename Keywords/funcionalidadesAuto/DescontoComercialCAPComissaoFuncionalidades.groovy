package funcionalidadesAuto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver
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
import com.kms.katalon.core.webui.driver.DriverFactory
import commands.AutoComandos
import internal.GlobalVariable
import org.openqa.selenium.By

public class DescontoComercialCAPComissaoFuncionalidades extends AutoComandos{

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicaNoComboCAP(){
		clicarEmElementoDaTela("//button[@data-id='comboCap']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaValorDoCampoCAP(){
		String valor = issue_info.get(0).get("CAP")
		String xpath = "//div[@class='btn-group bootstrap-select block open']//a//span[@class='text' and text()='"+valor+"']"
		clicarEmElementoDaTela(xpath, 2)
		if(pegaValorDaTela("//button[@data-id='comboCap']").trim().equals(valor)){
			highlightElementCAP()
			salvarEvidencia(issue_info.get(0).get("CT")," É exibido o valor do campo CAP "+valor+"% corretamente", "PASSED")
			unHighlightElementCAP()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Não é exibido o valor do campo CAP "+valor+"% corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCAP(){
		highlightElement("//button[@data-id='comboCap']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCAP(){
		unHighlightElement("//button[@data-id='comboCap']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirOpcoesCAP(){
		String xpath="//div[@class='btn-group bootstrap-select block open']//ul[@class='dropdown-menu inner']"
		String tag="span"
		selecionaListaDeElementos(xpath, tag)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static editarComissao(){
		String xpath = "//input[@id='comboComissao']"
		limparCamposInput(xpath)
		escreverCamposInput(xpath, issue_info.get(0).get("Comissao"))
		commandTAB(xpath)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaValorPermitidoParaComissao(){
		WebUI.delay(5)
		String comis = issue_info.get(0).get("Comissao")
		if(pegaValorDaTela("//div[@class='genericCol errorClass col-md-12 col-sm-12 col-xs-12 ws-invalid']").equals(null)){
			highlightElementComissao()
			salvarEvidencia(issue_info.get(0).get("CT")," É aceito o valor para Comissão "+comis+"% corretamente", "PASSED")
			unHighlightElementComissao()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Não é aceito o valor para Comissão "+comis+"% corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementComissao(){
		highlightElement("//input[@id='comboComissao']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementComissao(){
		unHighlightElement("//input[@id='comboComissao']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaCampoComissaoPreenchido(){
		String valor = issue_info.get(0).get("Comissao")
		String xpath = "//div[@class='alz-form-group form-group']//input[@value='"+valor+"']"
		if(validaElemento(xpath)){
			highlightElementCampoPreenchido(xpath)
			salvarEvidencia(issue_info.get(0).get("CT")," Campo está preenchido com o valor "+valor+"%", "PASSED")
			unHighlightElementCampoPreenchido(xpath)
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campo não está preenchido com o valor "+valor+"%", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaCampoCAPPreenchidoComQualquerValor(){
		String cap = pegaValorDaTela("//button[@data-id='comboCap']")
		String xpath = "//button[@data-id='comboCap']//span[text()='"+cap.trim()+"']"
		int intCap = Integer.valueOf(cap.trim())
		int minCap = Integer.valueOf(issue_info.get(0).get("CAP"))
		int maxCap = Integer.valueOf(issue_info.get(1).get("CAP"))
		System.err.println("CAP ["+intCap+"]  minCap ["+minCap+"] maxCap ["+maxCap+"]" )
		if( intCap > minCap &&  intCap <= maxCap){
			highlightElementCampoPreenchido(xpath)
			salvarEvidencia(issue_info.get(0).get("CT")," Campo está preenchido com o valor "+cap.trim()+"%", "PASSED")
			unHighlightElementCampoPreenchido(xpath)
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campo não está preenchido com o valor "+cap.trim()+"%", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaCampoCAPPreenchidoComQualquerValorNovaJanela(){
		switchToNewWindow()
		String cap =	retornaValorDeElementoDaTelaDeNovaJanela("//button[@data-id='comboCap']", 1)
		int minCap = Integer.valueOf(issue_info.get(0).get("CAP"))
		int maxCap = Integer.valueOf(issue_info.get(1).get("CAP"))
		int intCap = Integer.valueOf(cap.trim())
		String xpath = "//button[@data-id='comboCap']//span[text()='"+cap.trim()+"']"
		System.err.println("CAP ["+intCap+"]  minCap ["+minCap+"] maxCap ["+maxCap+"]" )
		if( intCap > minCap &&  intCap <= maxCap){
			highlightElementCampoPreenchido(xpath)
			salvarEvidencia(issue_info.get(0).get("CT")," Campo está preenchido com o valor "+cap.trim()+"%", "PASSED")
			unHighlightElementCampoPreenchido(xpath)
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campo não está preenchido com o valor "+cap.trim()+"%", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCampoPreenchido(String xpath){
		highlightElement(xpath)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCampoPreenchido(String xpath){
		unHighlightElement(xpath)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaCampoComissaoPreenchidoComQualquerValorNovaJanela(){
		switchToNewWindow()
		String valor = issue_info.get(0).get("Comissao")
		String xpath = "//div[@class='alz-form-group form-group']//input[@value='']"
		if( validaElementoNovaJanela(xpath, 1)== false){
			highlightElementCampoPreenchido("//input[@id='comboComissao']")
			salvarEvidencia(issue_info.get(0).get("CT")," Campo está preenchido ", "PASSED")
			unHighlightElementCampoPreenchido("//input[@id='comboComissao']")
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campo não está preenchido "+valor+"%", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarSessãoEdicaoDeCalculoDaNovaJanela(){
		WebUI.delay(5)
		switchToNewWindow()
		clicarEmElementoDaTelaDeNovaJanela("//span[contains(@class,'allianz-icon allianz-icon-chevron-down pull-right alz-wm-accordion-section-icon-color')]", 1)
	}
}
