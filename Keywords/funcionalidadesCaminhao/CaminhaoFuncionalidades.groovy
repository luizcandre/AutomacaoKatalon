package funcionalidadesCaminhao

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
import io.cucumber.datatable.DataTable

public class CaminhaoFuncionalidades extends AutoComandos{


	/**
	 * @author T_DCDias
	 * @param ct
	 * @return
	 */
	public static leituraMassaCaminhao(String ct){
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
	public static acessaHomePageCaminhao(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		def ct = issue_info.get(0).get("CT")
		leituraMassaCaminhao(ct)
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		addTitlePageCaminhao()
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
	public static selecionarOpcaoCaminhao(){
		WebUI.click(findTestObject('Object Repository/Page_Home/div_Caminhao'))
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencheCamposObrigatoriosCaminhao(){

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

		'Motorista prinicipal'
		commandCLICK("//button[@data-id='valorMotoristaPrinicipal']")
		WebUI.delay(2)
		commandCLICK(comboMotoristaPrinicipal(issue_info.get(0).get("MotoristaPrinicipal")))

		'Combo Possui Seguro da Carga'
		commandCLICK("//*[@id='QuestionarioRamoSeguroCarga']/div/div/div[1]/div/button")
		WebUI.delay(2)
		commandCLICK(comboSeguroGargaTransportada(issue_info.get(0).get("PossuiSegurodaCarga")))

		'Combo Região de circulação mais frequente'
		commandCLICK("//button[@data-id='valorRegiaoCirculacao']")
		WebUI.delay(2)
		commandCLICK(comboRegiaoDeCirculacaoMaisFrequente(issue_info.get(0).get("RegiãoDeCirculaçãoMaisFrequente")))

		'Carga transportada mais frequente'
		selectOptionWithAutoCompleteInPutText("//input[@id='cargaTransportada_1']", issue_info.get(0).get("CargaTransportada"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibeTelaPrecoCaminhao(){
		WebUI.delay(15)
		if(validaElemento("//*[@id='stepByStepMenuTestListDTOtoJSONString-desktop']/li[2]/span/a")){
			salvarEvidencia(issue_info.get(0).get("CT"), " Tela '2 preço' cotação moto é exeibida corretamente ", "PASSED")
		} else{
			salvarEvidencia(issue_info.get(0).get("CT"), " Tela '2 preço' cotação moto não foi exeibida corretamente ", "PASSED")
		}
	}

	/**
	 * @author T_DCDias	
	 * @param index
	 * @return
	 */
	public static String comboSeguroGargaTransportada(String index){
		Map<String, String> xpaths = new HashMap<String, String>()
		xpaths.put("index1", "//li[@data-original-index='1']//span[contains(text(),'Sempre possui seguro')]")
		xpaths.put("index2", "//li[@data-original-index='2']//span[contains(text(),'Possui seguro eventualmente')]")
		xpaths.put("index3", "//li[@data-original-index='3']//span[contains(text(),'Nunca possui seguro')]")
		return xpaths.get(index.toLowerCase()).toString();
	}

	/**
	 * @author T_DCDias
	 * @param index
	 * @return
	 */
	public static String comboRegiaoDeCirculacaoMaisFrequente(String index){
		Map<String, String> xpaths = new HashMap<String, String>()
		xpaths.put("index1", "//li[@data-original-index='1']//span[contains(text(),'Municípios e arredores até 100 km da cidade sede')]")
		xpaths.put("index2", "//li[@data-original-index='2']//span[contains(text(),'Região Centro-Oeste')]")
		xpaths.put("index3", "//li[@data-original-index='3']//span[contains(text(),'Região Sul')]")
		xpaths.put("index4", "//li[@data-original-index='4']//span[contains(text(),'Região Norte')]")
		xpaths.put("index5", "//li[@data-original-index='5']//span[contains(text(),'Região Sudeste, exceto Estado de São Paulo')]")
		xpaths.put("index6", "//li[@data-original-index='6']//span[contains(text(),'Região Nordeste')]")
		xpaths.put("index7", "//li[@data-original-index='7']//span[contains(text(),'Região Sudeste - Estado de São Paulo')]")
		xpaths.put("index8", "//li[@data-original-index='8']//span[contains(text(),'Região Mercosul - Necessária extensão de Perímetro')]")
		xpaths.put("index9", "//li[@data-original-index='9']//span[contains(text(),'Região América do Sul, exceto países do Mercosul-Necessária ext. perímetro')]")
		xpaths.put("index10", "//li[@data-original-index='10']//span[contains(text(),'Possui mais de uma região de circulação')]")
		return xpaths.get(index.toLowerCase()).toString();
	}

	/**
	 * @author T_DCDias
	 * @param index
	 * @return
	 */
	public static String comboMotoristaPrinicipal(String index){
		Map<String, String> xpaths = new HashMap<String, String>()
		xpaths.put("index1", "//li[@data-original-index='1']//span[contains(text(),'Quem dirige o veículo segurado por mais de 85% do tempo semanal')]")
		xpaths.put("index2", "//li[@data-original-index='2']//span[contains(text(),'Utilizado o mais jovem, pois não há quem dirija por mais de 85% do tempo semanal')]")
		return xpaths.get(index.toLowerCase()).toString();
	}
}
