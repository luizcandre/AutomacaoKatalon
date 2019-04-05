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

public class DecodificadorFuncionalidades extends AutoComandos{

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaDadosDoAutomovel(){
		String modelo = issue_info.get(0).get("Modelo")
		if( retornaValorDaTela("//font[text()='"+modelo+"']", 2, 2, 2)!=null ){
			highlightElementDadosDoAutomovel()
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem do automóvel exibida corretamente", "PASSED")
			unHighlightElementDadosDoAutomovel()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem do automóvel não foi exibida corretamente ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementDadosDoAutomovel(){
		highlightElement("//label[@id='placaInfo']")
		highlightElement("//input[@id='chassis']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementDadosDoAutomovel(){
		unHighlightElement("//label[@id='placaInfo']")
		unHighlightElement("//input[@id='chassis']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaMensagemDeErro(){
		try{
			WebUI.delay(3)
			String mensagem = issue_info.get(0).get("Mensagem")
			if(retornaValorDaTela("//div[text()='"+mensagem+"']", 2, 2, 2)!=null ){
				highlightElement("//div[@id='errMsg']")
				salvarEvidencia(issue_info.get(0).get("CT")," Mensagem de erro exibida corretamente", "PASSED")
				unHighlightElement("//div[@id='errMsg']")
			} else {
				salvarEvidencia(issue_info.get(0).get("CT")," Mensagem de erro não foi exibida corretamente ", "FAIL")
			}
		} catch (Exception e){}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaBotaoSimNaoVeiculoZero(){
		if( retornaValorDaTela("//button[@id='BKM0Sim']", 2, 2, 2)!=null && retornaValorDaTela("//button[@id='BKM0Nao']", 2, 2, 2)!=null ){
			highlightElement("//div[@id='sectionZeroKM']")
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem de erro exibida corretamente", "PASSED")
			unHighlightElement("//div[@id='sectionZeroKM']")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem de erro não foi exibida corretamente ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 */
	public static preencherChassi(){
		preencherNumeroDoChassi()
	}

	/**
	 * @author T_DCDias        
	 * @return
	 */
	public static validarModalDeSelecaoDeVeiculo(){
		WebUI.delay(1)
		if( retornaValorDaTela("//h4[text()='Selecione o veículo' ]", 2, 2, 2)!=null){
			highlightElement("//div[@id='FipeListLightbox_dialog']")
			salvarEvidencia(issue_info.get(0).get("CT")," Modal para a seleção do veículo exibida corretamente", "PASSED")
			unHighlightElement("//div[@id='FipeListLightbox_dialog']")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Modal para a seleção do veículo não foi exibida corretamente ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaCampoPLaca(){
		String placa = issue_info.get(0).get("Placa")
		String xpath ="//input[@id='placa' and  @value='"+placa+"']"
		String placaDaTela = retornaValorDaTela(xpath, 2, 2, 2)
		if(placaDaTela==null){
			highlightElement("//input[@id='placa']")
			salvarEvidencia(issue_info.get(0).get("CT")," Campo placa não preenchida ", "PASSED")
			unHighlightElement("//input[@id='placa']")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaCampoPLacaEmBranco(){
		posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
		String placa = issue_info.get(0).get("Placa")
		String xpath ="//input[@id='placa' and  @value='"+placa+"']"
		String placaDaTela = retornaValorDaTela(xpath, 2, 2, 2)
		if(placaDaTela==null){
			highlightElement("//input[@id='placa']")
			adicionaImagem(issue_info.get(0).get("CT"), " Campo placa não preenchida ", "FAIL", 1)
			unHighlightElement("//input[@id='placa']")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCampoPlaca(String placa){
		escreverCamposInput("//input[@id='placa']", placa)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCampoPlaca(){
		String placa = issue_info.get(1).get("Placa")
		preencheCampoPlaca(placa)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaCampoPlacaPreenchido(){
		clicarEmElementoDaTela("//a[text()='1. Cotação Auto']", 5)
		posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
		String placa = issue_info.get(1).get("Placa")
		String xpath ="//input[@id='placa' and  @value='"+placa+"']"
		String placaDaTela = retornaValorDaTela(xpath, 2, 2, 2)
		if(placaDaTela!=null){
			highlightElement("//input[@id='placa']")
			salvarEvidencia(issue_info.get(0).get("CT")," Campo placa não preenchida ", "PASSED")
			unHighlightElement("//input[@id='placa']")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionaOpcaoSimParaCarroZero(){
		String valor = issue_info.get(0).get("botao")
		clicarEmElementoDaTela("//button[@id='BKM0"+valor+"']", 2)
		WebUI.delay(3)
		clicarEmElementoDaTela("//div[@id='FipeListLightbox_dialog']//..//button[@data-dismiss='modal']", 1)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencherPlacaInvalida(){
		preencheCpfCnpj()
		String placa = casodeteste.getPlaca()
		preencheCampoPlaca(placa)
		commandTAB("//input[@id='placa']")
	}
}
