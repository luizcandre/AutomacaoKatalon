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

public class FipeDeContratacaoFuncionalidades extends AutoComandos{


	private static boolean fipe
	private static boolean msg

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionarVeiculoZerokm(){
		String valor = issue_info.get(0).get("botao")
		clicarEmElementoDaTela("//button[@id='BKM0"+valor+"']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarTabelaFIPE(){
		clicarEmElementoDaTela("//button[@data-id='comboFipe']", 2)
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static pegarOpcoesTabelaFIPE(){
		try{
			String xpath =  "//div[@class='btn-group bootstrap-select block open']//ul[@class='dropdown-menu inner']"
			String tag = "span"
			selecionaListaDeElementos(xpath, tag)
		} catch ( Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao exibir opções da Tabela FIPE ","FAIL")
			finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificarSessaoEdicaçãoDeCalculo(){
		try{
			//label [19] : [90]
			WebUI.delay(10)
			HashMap<Integer, String> mapTabelaFIPE= new HashMap<Integer,String>()
			mapTabelaFIPE.put(19,issue_info.get(0).get("TabelaFIPE"))
			selecionaListaDeElementos("//div[@id='content_null']", "label")
			for(int i = 0; i < listOfElements.size(); i++){
				if( !listOfElements[i].getText().equals(""))
				{  //System.err.println("label ["+i+"] : ["+listOfElements[i].getText()+"]")
					if( mapTabelaFIPE.get(i).toString().equals(listOfElements[i].getText()))
					{
						fipe = true
					}
				}
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao ler mensagens da Tabela FIPE","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaExibicaoDeMensagem(){
		try{
			String xpath = "//div[@id='divContentErrorSection']"
			String tag ="div"
			String mensagem = issue_info.get(0).get("mensagem")
			WebUI.delay(10)
			selecionaListaDeElementos(xpath,tag)
			for(int i = 0; i < listOfElements.size(); i++){
				System.err.println("["+i+"] div ["+listOfElements[i].getText()+"]")
				if(listOfElements[i].getText().equals(mensagem)){
					msg = true
				}
			}

			if( msg.equals(true) && fipe.equals(true))
			{
				highlightElementAceitaçãoCondicionada()
				salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE' exibida corretamente","PASSED")
				unHighlightElementAceitaçãoCondicionada()
			}
			else if (msg.equals(false) && fipe.equals(true))
			{
				salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE' não exibida corretamente","FAIL")
			}
			else if (msg.equals(true) && fipe.equals(false))
			{
				salvarEvidencia(issue_info.get(0).get("CT")," Valor de 90% da Tabela FIPE' não exibida corretamente","FAIL")
			}
		} catch ( Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao validar mensagens da Tabela FIPE","FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementAceitaçãoCondicionada(){
		highlightElement("//div[text()='Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE']")
		highlightElement("//label[@id='percFipe']")
		highlightElement("//p[@class='ws-errormessage']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementAceitaçãoCondicionada(){
		unHighlightElement("//div[text()='Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE']")
		unHighlightElement("//label[@id='percFipe']")
		unHighlightElement("//p[@class='ws-errormessage']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionaValorNaTabelaFIPE(){
		String valor = issue_info.get(0).get("FIPE")
		clicarEmElementoDaTela("//a//span[text()='"+valor+"'] ", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static recalcularValorDaTabelaFIPE(){
		WebUI.delay(3)
		clicarEmElementoDaTela("//button[@id='btnRecalcular2']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaPercentualFIPENaoPermitido(){
		if( issue_info.get(0).get("mensagem").equals(pegaValorDaTela("//p[@class='ws-errormessage']")) ){
			highlightElementAceitaçãoCondicionada()
			salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'Percentual FIPE não permitido para esta cotação' exibida corretamente","PASSED")
			unHighlightElementAceitaçãoCondicionada()
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'Percentual FIPE não permitido para esta cotação' exibida corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaInesistenciaDeMensagemCritíca(){
		String valor = issue_info.get(0).get("FIPE")
		if( retornaValorDaTela("//p[@class='ws-errormessage']", 2, 2, 2)==null){
			highlightElementComboFipe()
			salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'nenhuma critíca é exibida' exibida corretamente para FIPE "+valor,"PASSED")
			unHighlightElementComboFipe()
		}else {
			highlightElementAceitaçãoCondicionada()
			salvarEvidencia(issue_info.get(0).get("CT")," mensagem 'nenhuma critíca é exibida' exibida corretamente para FIPE "+valor,"FAIL")
			unHighlightElementAceitaçãoCondicionada()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementComboFipe(){
		highlightElement("//button[@data-id='comboFipe']")

	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementComboFipe(){
		unHighlightElement("//button[@data-id='comboFipe']")
	}


}
