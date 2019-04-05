package funcionalidadesMoto

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.List

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

import bean.CasoDeTeste
import com.kms.katalon.core.testobject.ConditionType


public class MotoFuncionalidades extends AutoComandos{




	/**
	 * @author T_DCDias
	 * @param ct
	 * @return
	 */
	public static leituraMassaMoto(String ct){
		try{
			System.err.println("path "+path)
			casodeteste = auxiliares.WriteExcelFactory.readingSheet(path,ct)
		} catch (Exception e) {
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi possível iniciar o teste", e)
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static acessaHomePageMoto(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		def ct = issue_info.get(0).get("CT")
		leituraMassaMoto(ct)
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		addTitlePageMoto()
		try{
			commands.Login.homePage(url)
			commands.Login.efetuarLogin(casodeteste.getUsuario(), casodeteste.getSenha())
			commands.Login.acessarHome()
			commands.Login.pegaUltimoAcesso()
		} catch (Exception e) {
			salvarEvidencia(ct," Falha ao executar o teste", "FAIL" )
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionarOpcaoMoto(){
		WebUI.click(findTestObject('Object Repository/Page_Home/div_Moto'))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCamposObrigatoriosMoto(){

		WebUI.delay(15)

		'Navegar'
		WebUI.switchToFrame(findTestObject('Object Repository/Page_app/iframe_Incio_appArea'), 20)
		'Navegar'
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'),20)
		WebUI.delay(10)

		escreverCamposInput("//input[@id='cpfCnpjSegurado']", casodeteste.getCpfcnpj())
		WebUI.delay(2)
		commandTAB("//input[@id='cpfCnpjSegurado']")
		if( casodeteste.getCpfcnpj().toString().length()>11){
			WebUI.delay(2)
			escreverCamposInput("//input[@id='cpfCnpjCondutor']", casodeteste.getNumCpfCondutor())
		}

		escreverCamposInput("//input[@id = 'CEP']", casodeteste.getCep())
		commandTAB("//input[@id = 'CEP']")
		WebUI.delay(2)

		'Combo Estado Civil'
		commandCLICK("//button[contains(@data-id,'comboCivilEstado' )]")
		commandCLICK(comboEstadoCivil(casodeteste.getEstadoCivil()))
		WebUI.delay(2)

		'Placa do Veiculo ou Chassis'
		if( casodeteste.getPlaca().length() > 1){
			escreverCamposInput("//input[@id='placa']", casodeteste.getPlaca() )
			commandTAB("//input[@id='placa']")
			WebUI.delay(5)
			if( validaElemento("//div[contains(@id,'FipeListLightbox_row_' ) ]")){
				commandCLICK("//div[contains(@id,'FipeListLightbox_row_' ) ]")
			}
		} else if(casodeteste.getPlaca().length() == 1 || casodeteste.getPlaca().length() == 0) {
			escreverCamposInput("//input[@id='chassis']", casodeteste.getChassis() )
			commandTAB("//input[@id='chassis']")
			WebUI.delay(5)
			if( validaElemento("//div[contains(@id,'FipeListLightbox_row_' ) ]")){
				commandCLICK("//div[contains(@id,'FipeListLightbox_row_' ) ]")
			}
		}

		'Tipo Residência'
		WebUI.delay(2)
		commandCLICK(".//*[contains(@data-id,'valorResideEm') and not(contains(@data-id,'qcab_valorResid'))]")
		commandCLICK(comboResidenciaCondutor(casodeteste.getResidenciaCondutor()))
	}




	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibeTelaPrecoMoto(){
		WebUI.delay(15)
		if(validaElemento("//*[@id='stepByStepMenuTestListDTOtoJSONString-desktop']/li[2]/span/a")){
			salvarEvidencia(issue_info.get(0).get("CT"), " Tela '2 preço' cotação moto é exeibida corretamente ", "PASSED")
		} else{
			salvarEvidencia(issue_info.get(0).get("CT"), " Tela '2 preço' cotação moto não foi exeibida corretamente ", "PASSED")
		}
	}





	/**
	 * @author T_DCDias
	 * @param i
	 * @return
	 */
	public static preencheCamposObrigatoriosMotoListFrame(int i){

		clicarEmElementoDaTelaList("//button[@id='newUser']", 3)
		clicarEmElementoDaTelaList("//div[@class='alz-iconBtn-centertxt']//span[contains(text(),'Moto')]", 20)

		'Navegar'
		WebUI.switchToFrame(findTestObject('Object Repository/Page_app/iframe_Incio_appArea'), 20)

		escreverCamposInputList("//input[@id='cpfCnpjSegurado']", ListCasoDeTeste.get(i).getCpfcnpj())
		WebUI.delay(2)
		commandTABList("//input[@id='cpfCnpjSegurado']")
		if( ListCasoDeTeste.get(i).getCpfcnpj().toString().length()>11){
			WebUI.delay(2)
			escreverCamposInputList("//input[@id='cpfCnpjCondutor']", ListCasoDeTeste.get(i).getNumCpfCondutor())
		}

		escreverCamposInputList("//input[@id = 'CEP']", ListCasoDeTeste.get(i).getCep())
		WebUI.delay(2)
		commandTABList("//input[@id = 'CEP']")
		WebUI.delay(2)

		if(issue_info.get(0).get("Renovação").equals("Sim")){
			clicarTipoDeSeguroEmCotacaoFormularioPreenchido()
			selecionaCcomboTipoDeSeguro(issue_info.get(0).get("tipo"))
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Page_app/listClasseDeBonus'))
			flexibleTestObject = new TestObject()
			WebUI.click(flexibleTestObject.addProperty("xpath", ConditionType.EQUALS, commands.AutoComandos.comboClasseDeBonus( ListCasoDeTeste.get(i).getClasseDeBonus())))
		}

		'Combo Estado Civil'
		commandCLICKList("//button[contains(@data-id,'comboCivilEstado' )]")
		commandCLICKList(comboEstadoCivil(ListCasoDeTeste.get(i).getEstadoCivil()))
		WebUI.delay(2)

		'Placa do Veiculo ou Chassis'
		if( ListCasoDeTeste.get(i).getPlaca().length() > 1){
			escreverCamposInputList("//input[@id='placa']", ListCasoDeTeste.get(i).getPlaca() )
			commandTABList("//input[@id='placa']")
			WebUI.delay(5)
			if( validaElemento("//div[contains(@id,'FipeListLightbox_row_' ) ]")){
				commandCLICKList("//div[contains(@id,'FipeListLightbox_row_' ) ]")
			}
		} else if(ListCasoDeTeste.get(i).getPlaca().length() == 1 || ListCasoDeTeste.get(i).getPlaca().length() == 0) {
			escreverCamposInputList("//input[@id='chassis']", ListCasoDeTeste.get(i).getChassis() )
			commandTABList("//input[@id='chassis']")
			WebUI.delay(5)
			if( validaElemento("//div[contains(@id,'FipeListLightbox_row_' ) ]")){
				commandCLICKList("//div[contains(@id,'FipeListLightbox_row_' ) ]")
			}
		}

		'Tipo Residência'
		WebUI.delay(2)
		commandCLICKList(".//*[contains(@data-id,'valorResideEm') and not(contains(@data-id,'qcab_valorResid'))]")
		commandCLICKList(comboResidenciaCondutor(ListCasoDeTeste.get(i).getResidenciaCondutor()))
	}


	/**
	 * @author T_DCDias
	 * @return
	 * Retorna lista com todos os item da planilha de massa
	 */
	public static List<CasoDeTeste> retornaListaDeCasosDeTesteRadarLiveMoto(){
		return auxiliares.WriteExcelFactory.readExcelFileToArray(pathRadarLiveMoto)
	}
}
