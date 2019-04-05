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

public class CepPernoiteFuncionalidades extends AutoComandos{

	
	
	private static String contemCartaVerdeDanosMateriais
	private static String contemCartaVerdeDanosCorporais 
	
	/**
	 * @author T_DCDias
	 */
	public static void verificoCampoCEP(){
		WebUI.delay(10)

		//		if(pegaValorDaTela("//input[@id='CEP']").length() >0){
		highlightElement("//input[@id = 'CEP']")
		adicionaImagem(issue_info.get(0).get("CT"), "campo 'CEP' é exibido preenchido", "PASSED", 1)
		unHighlightElement("//input[@id = 'CEP']")
		//		} else {
		//		  highlightElement("//input[@id = 'CEP']")
		//		  adicionaImagem(issue_info.get(0).get("CT"), "campo 'CEP' é exibido fazio", "FAIL", 1)
		//		  unHighlightElement("//input[@id = 'CEP']")
		//		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCPFeTrocaDeCEP(){
		preencheCpfCnpj()
		WebUI.delay(2)
		highlightElement("//input[@id = 'CEP']")
		adicionaImagem(issue_info.get(0).get("CT"), "campo 'CEP' é exibido preenchido", "PASSED", 1)
		unHighlightElement("//input[@id = 'CEP']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaMensagemDeAlerta(){
		WebUI.delay(5)
		if( validaElemento("//div[@id='popUpEndereco_dialog']//h4[text()='Informações Endereço']")){
			highlightElement("//div[@id='popUpEndereco_body']")
			salvarEvidencia(issue_info.get(0).get("CT"), "Mensagem de 'CEP' invélido é exibida corretamente", "PASSED")
			unHighlightElement("//div[@id='popUpEndereco_body']")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT"), "Mensagem de 'CEP' inválido não é exibida", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static escreveCEP(String cep){
		WebUI.delay(2)
		clicarEmElementoDaTela("//input[@id = 'CEP']", 1)
		limparCamposInput("//input[@id = 'CEP']")
		WebUI.delay(2)
		escreverCamposInput("//input[@id = 'CEP']", cep)
		commandTAB("//input[@id = 'CEP']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static escreveCEPInvalido(){
		WebUI.delay(15)
		escreveCEP(issue_info.get(0).get("CEPInválido"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static escreveCEPValido(){
		WebUI.delay(15)
		escreveCEP(issue_info.get(0).get("CEPVálido"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificoInformacoesParaSeguroNovo(){
		if( pegaValorDaTela("//label[@id='cepInfo']").equals(issue_info.get(0).get("Endereço").toString())){
			highlightElement("//label[@id='cepInfo']")
			salvarEvidencia(issue_info.get(0).get("CT"), "Informações para 'Seguro Novo' apresentada corretamente", "PASSED")
			unHighlightElement("//label[@id='cepInfo']")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT"), "Informações para 'Seguro Novo' não foram apresentada corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarEmNaoSeiCep(){
		WebUI.delay(20)
		clicarEmElementoDaTelaFrame("//label[@id='ajudaCEP']", 5)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheLogradouroCidadeEstado(){
		clicarEmElementoDaTela("//button[@data-id='EnderecoEstadoPopUp']", 5)
		clicarEmElementoDaTela("//div[@id='popUpEndereco_body']//div[@class='dropdown-menu open']//span[text()='"+issue_info.get(0).get("Estado")+"']", 5)
		selectOptionWithAutoCompleteInPutText("//input[@id='EnderecoCidadePopUp']", issue_info.get(0).get("Cidade"))
		WebUI.delay(2)
		selectOptionWithAutoCompleteInPutText("//input[@id='EnderecoLogradouroPopUp']", issue_info.get(1).get("Endereço"))
		WebUI.delay(2)
		highlightElement("//div[@id='popUpEndereco_body']")
		adicionaImagem(issue_info.get(0).get("CT"), "Informações Endereço", "PASSED", 1)
		unHighlightElement("//div[@id='popUpEndereco_body']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicaNoBotaoOK(){
		WebUI.delay(2)
		clicarEmElementoDaTela("//button[@id='close4_2']", 10)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaInformacoesDoComboSelecioneEstado(){
		clicarEmElementoDaTela("//button[@data-id='EnderecoEstadoPopUp']", 5)
		String xpath = "//div[@id='popUpEndereco_body']//ul[@class='dropdown-menu inner']"
		String tag = "span"
		selecionaListaDeElementos(xpath, tag)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaDuplicidadeComboSelecioneEstado(){
		try{
			if( verificaDuplicidadesCombo()==0 ) {
				highlightElement("//div[@id='popUpEndereco_body']//ul[@class='dropdown-menu inner']")
				salvarEvidencia(issue_info.get(0).get("CT")," Não existem valores duplicados para o combo 'Selecione o Estado' ", "PASSED")
				unHighlightElement("//div[@id='popUpEndereco_body']//ul[@class='dropdown-menu inner']")
			}else {
				salvarEvidencia(issue_info.get(0).get("CT")," Existem valores duplicados para o combo 'Selecione o Estado' ", "FAIL")
			}
		} catch (Exception e){
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCidade(){
		try{
		     selectOptionWithAutoCompleteInPutText("//input[@id='EnderecoCidadePopUp']", issue_info.get(0).get("Cidade"))
		     WebUI.delay(2)
		   } catch (Exception e){
		     highlightElement("//div[@id='popUpEndereco_body']")
		     salvarEvidencia(issue_info.get(0).get("CT"), "Falha ao preencher a cidade", "FAIL")
			 unHighlightElement("//div[@id='popUpEndereco_body']")
			 finalizar()
	       }
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheLogradouro(){
		try{
		     selectOptionWithAutoCompleteInPutText("//input[@id='EnderecoLogradouroPopUp']", issue_info.get(0).get("Endereço"))
		     WebUI.delay(2)
		   } catch (Exception e){
		     highlightElement("//div[@id='popUpEndereco_body']")
			 salvarEvidencia(issue_info.get(0).get("CT"), "Falha ao preencher logradouro", "FAIL")
			 unHighlightElement("//div[@id='popUpEndereco_body']")
			 finalizar()
		   }
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarNoBotooBuscar(){
		WebUI.delay(2)
		clicarEmElementoDaTela("//button[@id='searchBtn']", 10)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaInformacaoNaTelaInformacoesDoEndereço(){
		if( validaElemento("//p[text()='"+issue_info.get(0).get("MensagemErro")+"']")){
			highlightElement("//div[@id='popUpEndereco_body']")
			salvarEvidencia(issue_info.get(0).get("CT"), "Nenhuma informação foi exibida na tela", "PASSED")
			unHighlightElement("//div[@id='popUpEndereco_body']")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT"), "Informação de pesquisa exibidas na tela", "FAIL")
		}
	}
	
	
	public static valdidaCartaVerde(){
		
		WebUI.delay(5)
		boolean CVDM = false
		boolean CVDC = false
		String xpath = "//div[@class='cobertura-column']"
		String tag = 'p'
		selecionaListaDeElementos(xpath, tag)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){  
				if(issue_info.get(0).get("CartaVerde").equals(listOfElements[i].getText())) {
					CVDM = true
				}
				if(issue_info.get(1).get("CartaVerde").equals(listOfElements[i].getText())) {
					CVDC = true
				}
			}
		}
		
		if(CVDM==true && CVDC==true){
			highlightElementCartaVerde()
			salvarEvidencia(issue_info.get(0).get("CT"), "Listagem de Coberturas opções de Carta Verde são exibidas corretamente", "PASSED")
			unHighlightElementCartaVerde()
		} else {
		    salvarEvidencia(issue_info.get(0).get("CT"), "Listagem de Coberturas opções de Carta Verde não são exibidas corretamente", "FAIL")
		}
			
	}
	
	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCartaVerde(){
	    highlightElement("//*[@id='packets']/div/div/div[1]/div[1]/div[3]/div[5]/p")
	    highlightElement("//*[@id='packets']/div/div/div[1]/div[1]/div[3]/div[6]/p")
	}
	
	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCartaVerde(){
	   unHighlightElement("//*[@id='packets']/div/div/div[1]/div[1]/div[3]/div[5]/p")
	   unHighlightElement("//*[@id='packets']/div/div/div[1]/div[1]/div[3]/div[6]/p")
	}
	
	
	
	public static  valdidaCartaVerdePDF(){
		WebUI.delay(10)
		contemCartaVerdeDanosMateriais = pdfReader(pathFileValue).contains(issue_info.get(0).get("CartaVerde"))
		contemCartaVerdeDanosCorporais = pdfReader(pathFileValue).contains(issue_info.get(1).get("CartaVerde"))
	}
	
	
	public static verificarInformacaoCartaVerdePDF(){
		if(contemCartaVerdeDanosMateriais && contemCartaVerdeDanosCorporais){
			salvarEvidenciaPDF(issue_info.get(0).get("CT")," Textos ["+issue_info.get(0).get("CartaVerde")+' - '+issue_info.get(1).get("CartaVerde")+"] existem no layout do arquivo PDF ","PASSED")
		} else {
			salvarEvidenciaPDF(issue_info.get(0).get("CT")," Textos ["+issue_info.get(0).get("CartaVerde")+' - '+issue_info.get(1).get("CartaVerde")+"] não existem no layout do arquivo PDF ","FAIL")
		}
	}
	
}
