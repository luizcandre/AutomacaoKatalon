package funcionalidadesAuto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.*
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Wait
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys
import org.apache.http.util.Asserts
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import java.text.NumberFormat
import commands.AutoComandos
import internal.GlobalVariable
import io.cucumber.datatable.DataTable

import java.util.concurrent.TimeUnit;


public class TipoDeSeguroFuncionalidades extends AutoComandos{


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaDuplicidadeRendaMensal(){
		if(verificaDuplicidadesCombo()==0 ) {
			highlightElementComboRendaMensal()
			salvarEvidencia(issue_info.get(0).get("CT")," Não existem valores duplicados para o combo 'Renda mensal' ", "PASSED")
			unHighlightElementComboRendaMensal()
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Existem valores duplicados para o combo 'Renda mensal' ", "FAIL")
		}
		clicarEmElementoDaTela("//button[@data-id='comboRenda']", 3)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementComboRendaMensal(){
		highlightElement("//button[@data-id='comboRenda']//..//ul[@class='dropdown-menu inner']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementComboRendaMensal(){
		unHighlightElement("//button[@data-id='comboRenda']//..//ul[@class='dropdown-menu inner']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaDuplicidadeTipoDeSeguro(){
		try{
			if(verificaDuplicidadesCombo()==0 ) {
				highlightElementTipoDeSeguro()
				salvarEvidencia(issue_info.get(0).get("CT")," Não existem valores duplicados para o combo 'Tipo de Seguro' ", "PASSED")
				unHighlightElementTipoDeSeguro()
			}else {
				salvarEvidencia(issue_info.get(0).get("CT")," Existem valores duplicados para o combo 'Tipo de Seguro' ", "FAIL")
			}
		} catch (Exception e){
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementTipoDeSeguro(){
		highlightElement("//div[contains(@class,'btn-group bootstrap-select block open')]//div[contains(@class,'dropdown-menu open')]//ul[contains(@class,'dropdown-menu inner') and contains(@role,'menu')]")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementTipoDeSeguro(){
		unHighlightElement("//div[contains(@class,'btn-group bootstrap-select block open')]//div[contains(@class,'dropdown-menu open')]//ul[contains(@class,'dropdown-menu inner') and contains(@role,'menu')]")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoFrameSelecionar(){
		clicarBotaoFrame(issue_info.get(0).get("botao"))
		adicionaImagem(issue_info.get(0).get("CT")," Endosso", "PASSED", 5)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoFrameAceitar(){
		clicarBotaoFrame(issue_info.get(1).get("botao"))
	}
}
