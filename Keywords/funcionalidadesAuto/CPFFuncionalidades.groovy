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

public class CPFFuncionalidades extends AutoComandos{

	/**
	 * @author T_DCDias
	 *
	 */
	public static validaMensagemDeAlerta(){
		validarMensagemDeAlerta()
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarEmAvancar(){
		clicarEmElementoDaTela("//button[@id='NextButton']", 2)
		validarMensagemDeAlertaDePreenchimentoDeCamposCNPJ()
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaCPFInvalido(){
		try{
			String xpath = "//p[text()='"+issue_info.get(0).get("mensagem")+"']"
			if(validaElemento(xpath)){
				posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
				highlightElement( xpath)
				salvarEvidencia(issue_info.get(0).get("CT")," Mensagem: 'CPF inválido' exibida corretamente ", "PASSED" )
				unHighlightElement( xpath)
			}else {
				salvarEvidencia(issue_info.get(0).get("CT")," Mensagem: 'CPF inválido' não foi exibida ", "FAIL" )
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi possível valdar a mensagem na tela ", "FAIL" )
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static cpfDoCondutor(){
		clicarEmElementoDaTela("//button[@id='BCPFNao']", 3)
		String xpath = "//input[@id='cpfCnpjCondutor']"
		if(validaElemento(xpath)){
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			escreverCamposInput( xpath, casodeteste.getNumCpfCondutor())
			highlightElement( xpath)
			adicionaImagem(issue_info.get(0).get("CT"), "CPF do Condutor", "PASSED", 1)
			unHighlightElement( xpath)
		}else {
			adicionaImagem(issue_info.get(0).get("CT"), "CPF do Condutor", "FAIL", 1)
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static cnpjInvalido(){
		String msg = issue_info.get(0).get("mensagem")
		String xpath = "//p[text()='"+msg+"']"
		if(validaElemento(xpath)){
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			highlightElement( xpath)
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem "+msg+" exibida corretamente", "PASSED")
			unHighlightElement( xpath)
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem "+msg+" não foi exibida corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCnpj(){
		preencheCpfCnpj()
	}
}
