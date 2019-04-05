package funcionalidadesAuto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.io.File
import java.util.List
import java.util.Map
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.DesiredCapabilities
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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.*
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.testobject.ConditionType

import org.openqa.selenium.remote.CapabilityType;

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.PdfReader;

public class AutomovelFuncionalidades extends AutoComandos{



	private static contem

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static lerInformacoesDaDataTable(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		leituraMassa(issue_info.get(0).get("CT"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirOpcoesEstadoCivilCondutor(){
		try{
			preencheCpfCnpj()
			'Combo Estado Civil'
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Page_app/clicComboEstadoCivil'))
			WebUI.delay(5)
			String xpath =  "//div[@aria-invalid='true']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']"
			String tag = "span"
			selecionaListaDeElementos(xpath, tag)
		} catch ( Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao exibir Opcoes 'Estado civil do condutor:' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirOpcoesPrincipalCondutorResideEm(){
		try{
			preencheCpfCnpj()
			'Tipo Residência'
			posicaoDaTela("//input[@id='dataInicioVigenciaSeguro']")
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Page_app/clicarComboResidenciaCondutor'))
			WebUI.delay(5)
			String xpath =  "//div[@aria-invalid='true']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']"
			String tag = "span"
			selecionaListaDeElementos(xpath, tag)
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
		} catch ( Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao exibir Opcoes 'O principal condutor reside em:' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaDuplicidadeAuto(){
		if(verificaDuplicidadesCombo()==0 ) {
			highlightEstadoCivilCondutor()
			salvarEvidencia(issue_info.get(0).get("CT")," Não existe duplicidade no combo '"+issue_info.get(0).get("combo")+"' ","PASSED")
			unHighlightEstadoCivilCondutor()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Existe duplicidade no combo '"+issue_info.get(0).get("combo")+"' ","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightEstadoCivilCondutor(){
		highlightElement("//div[@aria-invalid='true']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']")
		highlightElement("//div[@class='btn-group bootstrap-select block open']//ul[@class='dropdown-menu inner']")
		highlightElement("//div[@class='btn-group bootstrap-select block dropup open']//div[@class='dropdown-menu open']")
	}

	/**
	 * @author T_DCDias	
	 * @return
	 */
	public static unHighlightEstadoCivilCondutor(){
		unHighlightElement("//div[@aria-invalid='true']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']")
		unHighlightElement("//div[@class='btn-group bootstrap-select block open']//ul[@class='dropdown-menu inner']")
		unHighlightElement("//div[@class='btn-group bootstrap-select block dropup open']//div[@class='dropdown-menu open']")
	}



	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoAutoUtilizaVeiculoComercialmente(){
		String botao = issue_info.get(0).get("botão")
		try{
			preencheCpfCnpj()
			posicaoDaTela("//input[@id='dataInicioVigenciaSeguro']")
			WebUI.delay(4)
			clicarEmElementoDaTela(botoesUtilizaVeiculoComercialmente(botao), 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar na opção '"+botao+"' do campo 'Utiliza o veiculo comercialmente' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Valida mensagem 
	 */
	public static validaMensagemAuto(){
		WebUI.delay(5)
		boolean msg = false
		def xpath = "//div[contains(@id,'content_null')]"
		selecionaListaDeElementos(xpath, "span")
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if(issue_info.get(0).get("Mensagem").equals(listOfElements[i].getText())) {
					msg = true
				}
			}
		}
		if(msg){
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			highlightUtilizaVeiculoComercialmente()
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem exibida corretamente ","PASSED")
			unHighlightUtilizaVeiculoComercialmente()
		}
		else   {
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem não foi exibida corretamente ","FAIL")
		}
	}


	public static highlightUtilizaVeiculoComercialmente(){
		highlightElement("//div[@class='genericCol errorClass col-md-12 col-sm-12 col-xs-12 ws-invalid']")
	}


	public static unHighlightUtilizaVeiculoComercialmente(){
		unHighlightElement("//div[@class='genericCol errorClass col-md-12 col-sm-12 col-xs-12 ws-invalid']")
	}



	/**
	 * @author T_DCDias
	 * @return
	 * Valida mensagem
	 */
	public static validaMensagemAutoVazia(){
		WebUI.delay(5)
		boolean msg = validaElemento("//span[@style='color:#008AE6 !important;']")
		System.err.println("validaElemento ["+msg +"]" )
		def xpath = "//div[contains(@id,'content_null')]"
		if(msg){
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem exibida ","FAIL")
		}
		else   {
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			WebUI.delay(1)

			salvarEvidencia(issue_info.get(0).get("CT")," Menhuma mensagem exibida ","PASSED")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoSimAutoCondutorResideComPessoas(){
		String botao = issue_info.get(0).get("botão")
		try{
			preencheCpfCnpj()
			posicaoDaTela("//input[@id='dataInicioVigenciaSeguro']")
			WebUI.delay(4)
			clicarEmElementoDaTela(botoesCondutorResideComPessoas(botao), 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar na opção '"+botao+"' do campo 'O condutor reside com pessoas de 17 a 25 anos' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoNaoAutoCondutorResideComPessoas(){
		String botao = issue_info.get(0).get("botão")
		try{
			preencheCpfCnpj()
			posicaoDaTela("//input[@id='dataInicioVigenciaSeguro']")
			WebUI.delay(4)
			clicarEmElementoDaTela(botoesCondutorResideComPessoas(botao), 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar na opção '"+botao+"' do campo 'O condutor reside com pessoas de 17 a 25 anos' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirOpcoesCondutorResideComPessoas(){
		try{
			String xpathToClick = "//button[@data-id='valor17a25']"
			clicarEmElementoDaTela(xpathToClick, 8)
			String xpath =  "//div[@aria-invalid='true']//div[@class='dropdown-menu open']//ul[@class='dropdown-menu inner']"
			String tag = "span"
			selecionaListaDeElementos(xpath, tag)
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
		} catch ( Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao exibir Opcoes ''O condutor reside com pessoas de 17 a 25 anos'' ","FAIL")
			finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCamposObrigatoriosCotacaoAutoUm(){
		preencheCamposObrigatoriosCotacaoAutoUmIFrame()
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarSalvarCotação(){
		clicarEmElementoDaTela("//img[@id='saveStudyIcon']", 1)
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static salvarArquyivoPDF(){
		try{
			WebUI.delay(2)
			pathFileValue = issue_info.get(0).get("downloadPath")+issue_info.get(0).get("arquivo")
			//System.err.println("pathValue ["+pathFileValue+"]")
			boolean result = validaExistenciaDeArquivo(pathFileValue)
			WebUI.delay(5)
			if( result == false){
				deleteFileDiretory(pathFileValue)
			}
			WebUI.delay(5)
			clicarEmElementoDaTela("//button[@id='b_generatePDF']", 1)
			WebUI.delay(5)
			clicarEmElementoDaTela("//div[@id='lightboxSalvaCotacao_dialog']//button[@aria-label='Close']", 1)
			posicaoDaTela("//div[@id='idPackagePrice_0']")
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao salvar Arquyivo PDF", "FAIL" )
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Faz leitura do arquivo pdf e verifica a caracteristica do condutor
	 */
	public static verificaDadosDoProduto(){
		WebUI.delay(10)
		contem = pdfReader(pathFileValue).contains(issue_info.get(0).get("campo"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static identificaDadosDoProduto(){
		if(contem){
			salvarEvidenciaPDF(issue_info.get(0).get("CT")," Texto ["+issue_info.get(0).get("campo")+"] existe no layout do arquivo PDF ","PASSED")
		} else {
			salvarEvidenciaPDF(issue_info.get(0).get("CT")," Texto ["+issue_info.get(0).get("campo")+"] não existe no layout do arquivo PDF ","FAIL")
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static utilizaVeiculoComercialmente(){
		String botao = issue_info.get(0).get("botão")
		try{
			WebUI.delay(4)
			clicarEmElementoDaTela(botoesUtilizaVeiculoComercialmente(botao), 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar na opção '"+botao+"' do campo 'Utiliza o veiculo comercialmente' ","FAIL")
			finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static resideComPessoasDestaFaixaEtaria(){
		String botao = issue_info.get(0).get("botão")
		try{
			WebUI.delay(4)
			clicarEmElementoDaTela(botoesCondutorResideComPessoas(botao), 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar na opção '"+botao+"' do campo 'O condutor reside com pessoas de 17 a 25 anos' ","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionarOpcaoCondutorResideComPessoas(){
		try{
			String xpathToClick = "//button[@data-id='valor17a25']"
			clicarEmElementoDaTela(xpathToClick, 2)
			flexibleTestObject = new TestObject()
			WebUI.click(flexibleTestObject.addProperty("xpath", ConditionType.EQUALS, tipoCondutorResideComPessoas(issue_info.get(0).get("reside"))))
		} catch ( Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao exibir Opcoes ''O condutor reside com pessoas de 17 a 25 anos'' ","FAIL")
			finalizar()
		}
	}


}
