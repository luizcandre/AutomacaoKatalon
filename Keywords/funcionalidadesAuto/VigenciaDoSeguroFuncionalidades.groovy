package funcionalidadesAuto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.List

import org.openqa.selenium.WebElement

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

public class VigenciaDoSeguroFuncionalidades extends AutoComandos{

	private static contem
	private static String vigencia


	/**
	 * @author T_DCDias
	 * @return
	 * Faz leitura do arquivo pdf e verifica a caracteristica do condutor
	 */
	public static verificaVigenciaProdutoPDF(){
		try{
			WebUI.delay(10)
			capturaVigenciaDaApolice()
			String sdata1=hasdates.get(0).toString().trim();
			String sdata2=hasdates.get(1).toString().trim();
			vigencia = "VIGÊNCIA: das 24H de "+sdata1+" às 24H de "+sdata2

			contem = pdfReader(pathFileValue).contains(vigencia.toString())
		} catch (Exception e){
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static realizaCalculoVigenciaPDF(){
		if(contem){
			calculoVigenciaPDF()
		} else {
			salvarEvidenciaPDF(issue_info.get(0).get("CT"),vigencia+" não existe no layout do arquivo PDF ","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 */
	public static preencherAgrupamentoDeRamos(){
		try{
			WebUI.delay(30)
			clicarEmElementoDaTelaFrame("//button[@data-id='agrupaRamos']", 10)
			clicarEmElementoDaTela(tipoAgrupamentoDeRamos(issue_info.get(0).get("AgrupamentoDeRamos")), 2)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível preencher o campo Agrupamento de Ramos", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencherVencimento(){
		try{
			clicarEmElementoDaTela("//button[@data-id='vencimiento']", 5)
			clicarEmElementoDaTela(tipoVencimento(issue_info.get(0).get("Vencimento")), 2)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível preencher o campo Vencimento", "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarBotaoTelaRenovacao(){
		String botao = issue_info.get(0).get("botao")
		try{
			clicarEmElementoDaTela("//button[contains(text(),'"+botao+"')]", 10)
			WebUI.delay(2)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar no botao "+botao, "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementRelacaoDeApolices(){
		highlightElement("//tr[@id='row_3_idPoliza']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementRelacaoDeApolices(){
		unHighlightElement("//tr[@id='row_3_idPoliza']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Metodo clina na primeira lupa disponível
	 */
	public static clicarNaLupa(){
		try{
			HashMap<Integer, WebElement> mapWebElement= new HashMap<Integer,WebElement>()
			posicaoDaTela("//h4[text()='Relação apólices']")
			WebUI.delay(4)
			String xpath = "//table[@id='idPoliza']"
			String tag = 'input'
			selecionaListaDeElementos(xpath,tag)
			int lupa = 1
			for(int i = 0; i < listOfElements.size(); i++){
				if(!listOfElements[i].getLocation().toString().equals("(0, 0)")){
					mapWebElement.put(lupa,listOfElements[i])
					lupa++
				}
			}
			mapWebElement.get(Integer.valueOf(issue_info.get(0).get("lupa"))).click()
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Falha ao clicar na lupa", "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarRenovarComAlteração(){
		String botao = issue_info.get(1).get("botao")
		try{
			WebUI.delay(4)
			posicaoDaTela("//h4[text()='Apólice Digital']")
			WebUI.delay(4)
			clicarEmElementoDaTela("//button[contains(text(),'"+botao+"')]", 15)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível clicar no botao "+botao, "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static botaoAvancarNovaJanela(){
		switchToNewWindow()
		windowMaximize()
		clicarEmElementoDaTela("//button[text()='Avançar ']", 10)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static salvarArquyivoPDFNovaJanela(){
		try{
			switchToNewWindow()
			WebUI.delay(2)
			pathFileValue = issue_info.get(0).get("downloadPath")+issue_info.get(0).get("arquivo")
			System.err.println("pathValue ["+pathFileValue+"]")
			boolean result = validaExistenciaDeArquivo(pathFileValue)
			WebUI.delay(5)
			if( result == false){
				deleteFileDiretory(pathFileValue)
			}
			WebUI.delay(5)
			clicarEmElementoDaTelaDeNovaJanela("//button[@id='b_generatePDF']", 1)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao salvar Arquyivo PDF", "FAIL" )
			finalizar()
		}
	}
}
