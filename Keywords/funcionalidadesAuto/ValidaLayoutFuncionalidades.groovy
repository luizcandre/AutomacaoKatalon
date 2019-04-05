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
import org.junit.After
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




public class ValidaLayoutFuncionalidades extends AutoComandos{

	private static int camposDefaultTelaPagamento
	private static int layoutCamposTelaPagamento
	private static int qtdMapSpanSessãoVeículo


	/**
	 * @author T_DCDias
	 * @param ct
	 * @return
	 */
	public static criaDocumentoPDF(String ct){
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		createTitlePage()
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static acessaSessaoIniciar(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		def ct = issue_info.get(0).get("CT")
		leituraMassa(ct)
		criaDocumentoPDF(ct)
		//		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		//		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		//		createTitlePage()
		try{
			commands.Login.homePage(url)
		} catch (Exception e ){
			salvarEvidencia(ct," Falha ao executar o teste", "FAIL" )
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static efetuarLogin(){
		commands.Login.efetuarLogin(casodeteste.getUsuario(), casodeteste.getSenha())
	}

	/**
	 * @author T_DCDias
	 * Valida se a tela de Home foi acessada com sucesso verificando a existência do botão 'Nova Cotação'
	 * @return
	 */
	public static validaLayoutTelaInicial(){
		try{
			boolean telaInicial = false
			WebUI.delay(10)
			if( pegaValorDaTela("//button[@id='newUser']").equals("Nova Cotação")){
				telaInicial = true
			}
			if(telaInicial){
				salvarEvidencia(issue_info.get(0).get("CT")," Tela 'Home' é exibida ", "PASSED")
			}
			else {
				salvarEvidencia(issue_info.get(0).get("CT")," Tela 'Home' não exibida ", "FAIL")
			}
		}  catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi possível validar a tela 'Home' ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaMensagemAcessoNegado(){
		if( pegaValorDaTela("//div//b[contains(text(),'Acesso negado')]").toString().contains(issue_info.get(0).get("mensagem"))){
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem 'Acesso negado' é exibida ", "PASSED")
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Mensagem 'Acesso negado' não exibida ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * Valida nome correto do corretor no hidden e no combo
	 * @return
	 */
	public static validaNomdeDoCorretor(){

		HashMap<Integer, String> mapCorretor= new HashMap<Integer,String>()
		mapCorretor.put(0,issue_info.get(0).get("corretor"))
		mapCorretor.put(1,issue_info.get(0).get("corretor"))

		//pega valor do hidden
		String corretor = issue_info.get(0).get("corretor")
		def xpathDivSpan = "//div[contains(@class,'container-fluid prehead hidden-xs hidden-sm')]"
		def tag1 = "span"
		boolean hidden = false
		selecionaListaDeElementos(xpathDivSpan,tag1)
		for(int i = 0; i < listOfElements.size(); i++){
			if(listOfElements[i].getText().equals(mapCorretor.get(i).toString())){
				hidden = true
			}
		}

		//pega valores do combo
		def xpathA = "//div[contains(@class,'container-fluid prehead hidden-xs hidden-sm')]//a[contains(@tabindex,'-1')]"
		clicarEmElementoDaTela(xpathA, 1)
		def xpathDivLi = "//div[contains(@class,'mCSB_container')]"
		def tag2 = "li"
		boolean combo = false
		selecionaListaDeElementos(xpathDivLi,tag2)
		for(int i = 0; i < listOfElements.size(); i++){
			if(listOfElements[i].getText().equals(mapCorretor.get(1).toString())){
				combo = true
			}
		}

		if(combo == true && hidden == true){
			salvarEvidencia(issue_info.get(0).get("CT")," Corretor "+corretor+" é exibido da forma correta ","PASSED")
		}
		else {
			salvarEvidencia(issue_info.get(0).get("CT")," Corretor "+corretor+" não foi exibido da forma correta ", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * Retorna lista de elementos dentro de um IFrame tela Cotação Auto
	 * @return
	 */
	public static validaTelaCotaçãoAuto(){
		try{
			WebUI.delay(20)
			esperarElementoCarregarNaTela("//button[@id='NextButton']")
			def xpathDivSpan = "//div[contains(@id,'content_null')]"
			def tag1 = "a"
			boolean tl = false
			selecionaListaDeElementosIFrame(xpathDivSpan,tag1)
			for(int i = 0; i < listOfElements.size(); i++){
				if(listOfElements[i].getText().equals(issue_info.get(0).get("Tela"))){
					tl = true
				}
			}
			if(tl == true){
				highlightElement("//a[text()='1. Cotação Auto']")
				salvarEvidencia(issue_info.get(0).get("CT"), " Exibida a tela '1. Cotação Auto", "PASSED")
				unHighlightElement("//a[text()='1. Cotação Auto']")
			}
			else {
				salvarEvidencia(issue_info.get(0).get("CT")," Não exibida a tela '1. Cotação Auto ", "FAIL")
				finalizar()
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Não exibida a tela '1. Cotação Auto ", "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirLayoutCotacaoAuto(){
		if(totalvalidationslabels == totalDeLabels){
			highlightElementLayOutPreco()
			salvarEvidencia(issue_info.get(0).get("CT"), " Layout '1. Cotação Auto' exibido corretamente", "PASSED")
			unHighlightElementLayOutPreco()
		}
		else {
			salvarEvidencia(issue_info.get(0).get("CT")," Layout '1. Cotação Auto' não exibido corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementLayOutPreco(){
		highlightElement("//h2[text()='Preencha os dados do Segurado e Condutor']")
		highlightElement("//label[@id='sectionHeader1']")
		highlightElement("//label[text()='O seguro que você está cotando é:']")
		highlightElement("//label[text()='CPF ou CNPJ do segurado *']")
		highlightElement("//label[text()='CEP de pernoite do veículo *']")
		highlightElement("//label[text()='O CPF mencionado é o mesmo do Condutor?']")
		highlightElement("//label[text()='Estado civil do condutor:']")
		highlightElement("//label[text()='Placa do veículo']")
		highlightElement("//label[text()='Chassis do veículo']")
		highlightElement("//label[text()='Utiliza o veículo comercialmente?']")
		highlightElement("//div[@id='QuestionarioRamoBlindagem']//label[text()='Veículo possui blindagem?']")
		highlightElement("//label[text()='O condutor reside com pessoas de 17 a 25 anos?']")
		highlightElement("//div[@id='QuestionarioRamoResideEm']//label[text()='O principal condutor reside em:']")
		highlightElement("//label[text()='Data de início da vigência do seguro']")
		highlightElement("//label[@id='sectionHeader4']")
		highlightElement("//p[text()='VOCÊ E SEU VEÍCULO PROTEGIDOS COM OS PRINCIPAIS SERVIÇOS:']")
		highlightElement("//p[text()='Assistência 24hs com possibilidade de reboque ilimitado']")
		highlightElement("//p[text()='Carro Reserva de 20 dias ou 30 dias']")
		highlightElement("//p[text()='Utilização de 2º guincho na mesma pane']")
		highlightElement("//p[text()='Assistência Vidros VIP']")
		highlightElement("//p[text()='Assistência Reparos Residenciais']")
		highlightElement("//p[text()='E muito mais!']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayOutPreco(){
		unHighlightElement("//h2[text()='Preencha os dados do Segurado e Condutor']")
		unHighlightElement("//label[@id='sectionHeader1']")
		unHighlightElement("//label[text()='O seguro que você está cotando é:']")
		unHighlightElement("//label[text()='CPF ou CNPJ do segurado *']")
		unHighlightElement("//label[text()='CEP de pernoite do veículo *']")
		unHighlightElement("//label[text()='O CPF mencionado é o mesmo do Condutor?']")
		unHighlightElement("//label[text()='Estado civil do condutor:']")
		unHighlightElement("//label[text()='Placa do veículo']")
		unHighlightElement("//label[text()='Chassis do veículo']")
		unHighlightElement("//label[text()='Utiliza o veículo comercialmente?']")
		unHighlightElement("//div[@id='QuestionarioRamoBlindagem']//label[text()='Veículo possui blindagem?']")
		unHighlightElement("//label[text()='O condutor reside com pessoas de 17 a 25 anos?']")
		unHighlightElement("//div[@id='QuestionarioRamoResideEm']//label[text()='O principal condutor reside em:']")
		unHighlightElement("//label[text()='Data de início da vigência do seguro']")
		unHighlightElement("//label[@id='sectionHeader4']")
		unHighlightElement("//p[text()='VOCÊ E SEU VEÍCULO PROTEGIDOS COM OS PRINCIPAIS SERVIÇOS:']")
		unHighlightElement("//p[text()='Assistência 24hs com possibilidade de reboque ilimitado']")
		unHighlightElement("//p[text()='Carro Reserva de 20 dias ou 30 dias']")
		unHighlightElement("//p[text()='Utilização de 2º guincho na mesma pane']")
		unHighlightElement("//p[text()='Assistência Vidros VIP']")
		unHighlightElement("//p[text()='Assistência Reparos Residenciais']")
		unHighlightElement("//p[text()='E muito mais!']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static botaoAvançar(){
		def botao = "//button[@id='NextButton']"
		try{
			clicarEmElementoDaTela(botao, 5)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao executar o teste, botão 'Avançar' não encontrado", "FAIL" )
			finalizar()
		}

		'Valida mensagem de erro na tela'
		validarMensagemDeErro()  // verificar outra forma de validar a msg de erro com menos de 30 segundos
	}

	/**
	 * @author T_DCDias
	 * Valida mensagens de campos obrigatórios
	 * CPF ou CNPJ do segurado; - CEP de pernoite do veículo;- Estado civil do condutor;- Chassis do veículo;- O principal condutor reside em:
	 * @return
	 */
	public static validaMensagensDeCamposObrigatorios(DataTable data){
		WebUI.delay(2)

		posicaoDaTela("//a[text()='1. Cotação Auto']")
		issue_info =  data.asMaps(String.class, String.class);
		def xpath = "//div[contains(@id,'content_null')]"
		def tag="p"
		def totalMsgs = 5
		selecionaListaDeElementos(xpath,tag)
		List<String> validations = new ArrayList<String>();
		HashMap<Integer, String> msgcampobrig= new HashMap<Integer,String>()
		msgcampobrig.put(0,issue_info.get(0).get("Mensagem"))
		msgcampobrig.put(2,issue_info.get(1).get("Mensagem"))
		msgcampobrig.put(4,issue_info.get(2).get("Mensagem"))
		msgcampobrig.put(5,issue_info.get(3).get("Mensagem"))
		msgcampobrig.put(7,issue_info.get(4).get("Mensagem"))

		for(int i = 0; i < listOfElements.size(); i++){ print("*")
			if( !listOfElements[i].getText().equals("")){
				if( msgcampobrig.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+msgcampobrig.get(i).toString()+"]")
				}
			}
		}

		if(validations.size() == totalMsgs){
			highlightElementMensagemObrigatorio()
			salvarEvidencia(issue_info.get(0).get("CT")," Campos destacados na tela exibidos corretamente","PASSED")
			unHighlightElementMensagemObrigatorio()
		}
		else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campos destacados na tela não foram exibidos corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementMensagemObrigatorio(){
		highlightElement("//div[@id='errorbox-1']")
		highlightElement("//div[@id='errorbox-2']")
		highlightElement("//div[@id='errorbox-3']")
		highlightElement("//div[@id='errorbox-4']")
		highlightElement("//div[@id='errorbox-5']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementMensagemObrigatorio(){
		unHighlightElement("//div[@id='errorbox-1']")
		unHighlightElement("//div[@id='errorbox-2']")
		unHighlightElement("//div[@id='errorbox-3']")
		unHighlightElement("//div[@id='errorbox-4']")
		unHighlightElement("//div[@id='errorbox-5']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaCamposDefaultCotacaoAuto(DataTable data){
		posicaoDaTela("//a[text()='1. Cotação Auto']")
		issue_info =  data.asMaps(String.class, String.class);
		totalCamposDefaultCotacaoAuto = 8
		List<String> validations = new ArrayList<String>();

		//combo O seguro que você está cotando é: Seguro Novo;
		def xpathTipoSeguro = "//button[contains(@data-id,'comboSeguro')]"
		def tag = "span"
		selecionaListaDeElementos(xpathTipoSeguro,tag)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( listOfElements[i].getText().equals(issue_info.get(0).get("defaut")) )
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS [Seguro Novo]")
				}
			}
		}

		//O CPF mencionado é o mesmo do Condutor?  Sim;
		def xpathCPFCondutorSim = "//div[contains(@id,'BCPFSim') and contains(@class,'alz-wm-bs-btn-desktop-container alz-wm-bs-btn-group active')]"
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(xpathCPFCondutorSim));
		boolean selected = element.isEnabled()
		validations.add("O CPF mencionado é o mesmo do Condutor? sim ["+selected+"]")


		// Combo Estado civil do condutor:
		def xpathEstadoCivil = "//button[contains(@data-id,'comboCivilEstado')]"
		def tagec = "span"
		selecionaListaDeElementos(xpathEstadoCivil,tagec)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( listOfElements[i].getText().equals(issue_info.get(2).get("defaut")) )
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS [SELECIONE...]")
				}
			}
		}

		//Utiliza o veículo comercialmente?  Não;
		def xpathUtilizaVeiculoNao= "//div[contains(@id,'BComercialNao')]"
		WebDriver driverUtilizaVeiculoNao = DriverFactory.getWebDriver()
		WebElement elementUtilizaVeiculoNao = driverUtilizaVeiculoNao.findElement(By.xpath( xpathUtilizaVeiculoNao));
		boolean selectedUtilizaVeiculoNao = elementUtilizaVeiculoNao.isEnabled()
		validations.add("Utiliza o veículo comercialmente?  Não ["+selectedUtilizaVeiculoNao+"]")

		//Veículo possui blindagem?  Não;
		def xpatblindagem = "//div[contains(@class,'alz-wm-bs-btn-desktop-container alz-wm-bs-btn-group active')]//button[contains(@id,'BBlindagemNao') and contains(@class,'btn alz-wm-btn alz-wm-btn-grey active alz-wm-button-pull')]"
		WebDriver driverblindagemNao = DriverFactory.getWebDriver()
		WebElement elementblindagemNao = driverblindagemNao.findElement(By.xpath( xpatblindagem));
		boolean selectedblindagemNao = elementblindagemNao.isEnabled()
		validations.add("Veículo possui blindagem?  Não ["+selectedblindagemNao+"]")

		//O condutor reside com pessoas de 17 a 25 anos?  Não;
		def xpathCondutor = "//div[contains(@class,'alz-wm-bs-btn-desktop-container alz-wm-bs-btn-group active')]//button[contains(@id,'B17a25Nao') and contains(@class,'btn alz-wm-btn alz-wm-btn-grey active alz-wm-button-pull')]"
		WebDriver driverCondutorNao = DriverFactory.getWebDriver()
		WebElement elementCondutorNao = driverCondutorNao.findElement(By.xpath( xpathCondutor));
		boolean selectedCondutor = elementCondutorNao.isEnabled()
		validations.add("Veículo possui blindagem?  Não ["+selectedCondutor+"]")

		//O principal condutor reside em: Selecione;
		def xpathPrincipalCondutor = "//button[contains(@data-id,'comboCivilEstado')]"
		def tagvr = "span"
		selecionaListaDeElementos(xpathPrincipalCondutor,tagvr)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( listOfElements[i].getText().equals(issue_info.get(6).get("defaut")) )
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS [SELECIONE...]")
				}
			}
		}

		//Data de início da vigência do seguro: Data do dia;
		Calendar calendar = new GregorianCalendar()
		int dia = calendar.get(calendar.DAY_OF_MONTH)

		String sDate = Integer.toString(dia)
		WebDriver driverbt = DriverFactory.getWebDriver()
		WebElement elementbt = driverbt.findElement(By.xpath("//div[contains(@id,'dataInicioVigenciaSeguro_div')]//span[contains(@class,'input-group-addon')]//i[contains(@class,'allianz-icon allianz-icon-calendar')]"));
		elementbt.click()
		WebUI.delay(2)
		WebDriver driverdt = DriverFactory.getWebDriver()
		def dtvalue = Integer.parseInt( driverdt.findElement(By.xpath("//tbody//tr//td[contains(@class,'today active')]")).getText());
		WebElement elementdt = driverdt.findElement(By.xpath("//tbody//tr//td[contains(@class,'today active')]"));
		elementdt.click()
		if(dia == dtvalue ){
			validations.add("[ Data de início da vigência do seguro "+dtvalue+"]")
		}
		totalvalidationsdefault = validations.size()
		posicaoDaTela("//a[text()='1. Cotação Auto']")
	}

	/**
	 * @author T_DCDias
	 */
	public static validaCamposDefault(){
		if( totalCamposDefaultCotacaoAuto == totalvalidationsdefault){
			highlightElementCamposDefault()
			salvarEvidencia(issue_info.get(0).get("CT"), " Campos default exibidos corretamente", "PASSED")
			unHighlightElementCamposDefault()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campos default não exibidos corretamente","FAIL")
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCamposDefault(){
		highlightElement("//button[@data-id='comboSeguro']//span[text()='Seguro Novo']")
		highlightElement("//div[@id='BCPFSim_container']")
		highlightElement("//button[@data-id='comboCivilEstado']//span[text()='[SELECIONE...]']")
		highlightElement("//button[@data-id='valorResideEm']//span[text()='[SELECIONE...]']")
		highlightElement("//div[@id='BComercialNao_container']")
		highlightElement("//div[@id='buttonBlindagem']//div[@id='BBlindagemNao_container']")
		highlightElement("//div[@id='button17a25']//div[@id='B17a25Nao_container']")
		highlightElement("//input[@id='dataInicioVigenciaSeguro']")
	}

	/**
	 * @author T_DCDias
	 */
	public static unHighlightElementCamposDefault(){
		unHighlightElement("//button[@data-id='comboSeguro']//span[text()='Seguro Novo']")
		unHighlightElement("//div[@id='BCPFSim_container']")
		unHighlightElement("//button[@data-id='comboCivilEstado']//span[text()='[SELECIONE...]']")
		unHighlightElement("//button[@data-id='valorResideEm']//span[text()='[SELECIONE...]']")
		unHighlightElement("//div[@id='BComercialNao_container']")
		unHighlightElement("//div[@id='buttonBlindagem']//div[@id='BBlindagemNao_container']")
		unHighlightElement("//div[@id='button17a25']//div[@id='B17a25Nao_container']")
		unHighlightElement("//input[@id='dataInicioVigenciaSeguro']")
	}


	/**
	 * @author T_DCDias
	 */
	public static preencheCamposObrigatoriosCotacaoAutoUm(DataTable data){

		issue_info =  data.asMaps(String.class, String.class);
		leituraMassa(issue_info.get(0).get("CT"))
		try{
			preencheCamposObrigatorios()

			//  		Campos desabilitados para testes com o nmetodo 'preencheCamposObrigatorios()'
			//			'Navegar'
			//			'Navegar'
			//			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'),20)
			//			WebUI.delay(10)
			//			WebUI.setText(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), casodeteste.getCpfcnpj())
			//			WebUI.delay(5)
			//			WebUI.sendKeys(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), Keys.chord(Keys.TAB))
			//
			//			WebUI.delay(2)
			//
			//			WebUI.setText(findTestObject('Object Repository/Page_app/CEP'),casodeteste.getCep())
			//			WebUI.sendKeys(findTestObject('Object Repository/Page_app/CEP'), Keys.chord(Keys.TAB))
			//			WebUI.delay(2)
			//
			//			'Combo Estado Civil'
			//			WebUI.click(findTestObject('Object Repository/Page_app/clicComboEstadoCivil'))
			//			flexibleTestObject = new TestObject()
			//			WebUI.click(flexibleTestObject.addProperty("xpath", ConditionType.EQUALS, commands.AutoComandos.comboEstadoCivil(casodeteste.getEstadoCivil())))
			//			WebUI.delay(2)
			//
			//			'Placa do Veiculo ou Chassis'
			//			if(casodeteste.getPlaca().length() > 1){
			//				WebUI.setText(findTestObject('Object Repository/Page_app/input_Placa do veculo_placa'), casodeteste.getPlaca() )
			//				WebUI.click(findTestObject('Object Repository/Page_app/clic_chassis'))
			//				WebUI.delay(5)
			//				WebUI.click(findTestObject('Object Repository/Page_app/selecionaPrimeiroVeiculo'))
			//			} else if(casodeteste.getPlaca().length() == 1) {
			//				WebUI.setText(findTestObject('Object Repository/Page_app/input_Chassis do veculo'), casodeteste.getchassis())
			//				WebUI.sendKeys(findTestObject('Object Repository/Page_app/input_Chassis do veculo'), Keys.chord(Keys.TAB))
			//				WebUI.delay(5)
			//				WebUI.click(findTestObject('Object Repository/Page_app/selecionaPrimeiroVeiculo'))
			//			}
			//
			//			'Tipo Residência'
			//			WebUI.delay(2)
			//			WebUI.click(findTestObject('Object Repository/Page_app/clicarComboResidenciaCondutor'))
			//			flexibleTestObject = new TestObject()
			//			WebUI.click(flexibleTestObject.addProperty("xpath", ConditionType.EQUALS, commands.AutoComandos.comboResidenciaCondutor(casodeteste.getResidenciaCondutor())))

		}  catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Falha ao preencher campos obrigatorios", "FAIL" )
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * Retorna lista de elementos dentro de um IFrame tela Preço
	 * @return
	 */
	public static validaTelaPreco(DataTable data){
		try{
			posicaoDaTela("//a[text()='Início']")
			//			def xpathDivSpan = "//div[contains(@id,'content_null')]"
			//			def tag1 = "a"
			boolean tl = false
			//			selecionaListaDeElementos(xpathDivSpan,tag1)
			//			for(int i = 0; i < listOfElements.size(); i++){
			//				if(listOfElements[i].getText().equals(issue_info.get(0).get("Tela"))){
			//					tl = true
			//				}
			//			}

			WebUI.delay(10)

			tl = validaElemento("//li[@class='active']//a[text()='2. Preço']")

			if(tl == true){
				highlightElement("//a[text()='2. Preço']")
				salvarEvidencia(issue_info.get(0).get("CT")," Tela '2. Preço' exibida corretamente","PASSED" )
				unHighlightElement("//a[text()='2. Preço']")
			}
			else {
				salvarEvidencia(issue_info.get(0).get("CT")," Tela '2. Preço' não foi exibida corretamente", "FAIL")
				WebUI.delay(2)
				finalizar()
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Tela '2. Preço' não foi encontrada", "FAIL")
			WebUI.delay(2)
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * '2. Preço' verifica o layout dos campos na ordem
	 * @param data
	 * @return
	 */
	public static verificarLayoutPreco(DataTable data){
		posicaoDaTela("//a[text()='2. Preço']")

		issue_info =  data.asMaps(String.class, String.class);
		def xpath = "//div[contains(@id,'content_null')]"
		def a="a", h2="h2"  , div="div", button="button",  h4="h4", label="label"
		totalDeLabels = 14

		List<String> validations = new ArrayList<String>();

		HashMap<Integer, String> maph2= new HashMap<Integer,String>()
		maph2.put(0,issue_info.get(0).get("Label"))

		HashMap<Integer, String> maph4= new HashMap<Integer,String>()
		maph4.put(2,issue_info.get(5).get("Label"))

		HashMap<Integer, String> mapVigenciaApolice= new HashMap<Integer,String>()
		mapVigenciaApolice.put(9,issue_info.get(3).get("Label"))

		HashMap<Integer, String> mapdivNumeroDaOperação= new HashMap<Integer,String>()
		mapdivNumeroDaOperação.put(125,issue_info.get(4).get("Label"))

		HashMap<Integer, String> mapdivResumoDosDados= new HashMap<Integer,String>()
		mapdivResumoDosDados.put(110,issue_info.get(2).get("Label"))

		HashMap<Integer, String> mapdivNossaRecomendação= new HashMap<Integer,String>()
		mapdivNossaRecomendação.put(309,issue_info.get(11).get("Label"))

		HashMap<Integer, String> mapButtons= new HashMap<Integer,String>()
		mapButtons.put(19,issue_info.get(0).get("botao"))
		mapButtons.put(20,issue_info.get(1).get("botao"))
		mapButtons.put(22,issue_info.get(2).get("botao"))
		mapButtons.put(23,issue_info.get(2).get("botao"))
		mapButtons.put(24,issue_info.get(2).get("botao"))
		mapButtons.put(25,issue_info.get(2).get("botao"))
		mapButtons.put(26,issue_info.get(2).get("botao"))
		mapButtons.put(27,issue_info.get(2).get("botao"))
		mapButtons.put(28,issue_info.get(2).get("botao"))
		mapButtons.put(29,issue_info.get(2).get("botao"))
		mapButtons.put(30,issue_info.get(2).get("botao"))
		mapButtons.put(31,issue_info.get(2).get("botao"))
		mapButtons.put(32,issue_info.get(2).get("botao"))
		mapButtons.put(33,issue_info.get(2).get("botao"))
		mapButtons.put(35,issue_info.get(3).get("botao"))
		mapButtons.put(36,issue_info.get(4).get("botao"))

		HashMap<Integer, String> mapVerComparacao= new HashMap<Integer,String>()
		mapVerComparacao.put(25,issue_info.get(15).get("Label"))
		mapVerComparacao.put(26,issue_info.get(15).get("Label"))
		mapVerComparacao.put(27,issue_info.get(15).get("Label"))
		mapVerComparacao.put(28,issue_info.get(15).get("Label"))
		mapVerComparacao.put(29,issue_info.get(15).get("Label"))
		mapVerComparacao.put(30,issue_info.get(15).get("Label"))
		mapVerComparacao.put(31,issue_info.get(15).get("Label"))
		mapVerComparacao.put(32,issue_info.get(15).get("Label"))
		mapVerComparacao.put(33,issue_info.get(15).get("Label"))
		mapVerComparacao.put(34,issue_info.get(15).get("Label"))
		mapVerComparacao.put(35,issue_info.get(15).get("Label"))
		mapVerComparacao.put(36,issue_info.get(15).get("Label"))

		HashMap<Integer, String> mapFormasDePagamento = new HashMap<Integer,String>()
		mapFormasDePagamento.put(0,issue_info.get(7).get("Lista"))
		mapFormasDePagamento.put(1,issue_info.get(8).get("Lista"))

		HashMap<Integer, String> mapDiqueteSalvar= new HashMap<Integer,String>()
		mapDiqueteSalvar.put(0,"img")

		HashMap<Integer, String> mapPacotes= new HashMap<Integer,String>()
		mapPacotes.put(271,issue_info.get(10).get("Pacotes"))
		mapPacotes.put(346,issue_info.get(11).get("Pacotes"))
		mapPacotes.put(389,issue_info.get(12).get("Pacotes"))
		mapPacotes.put(432,issue_info.get(13).get("Pacotes"))
		mapPacotes.put(443,issue_info.get(14).get("Pacotes"))
		mapPacotes.put(486,issue_info.get(15).get("Pacotes"))

		HashMap<Integer, String> mapCoberturas= new HashMap<Integer,String>()
		mapCoberturas.put(253,issue_info.get(9).get("Coberturas"))
		mapCoberturas.put(254,issue_info.get(10).get("Coberturas"))
		mapCoberturas.put(255,issue_info.get(11).get("Coberturas"))
		mapCoberturas.put(256,issue_info.get(12).get("Coberturas"))
		mapCoberturas.put(257,issue_info.get(13).get("Coberturas"))
		mapCoberturas.put(258,issue_info.get(14).get("Coberturas"))
		mapCoberturas.put(259,issue_info.get(15).get("Coberturas"))
		mapCoberturas.put(260,issue_info.get(16).get("Coberturas"))
		mapCoberturas.put(261,issue_info.get(17).get("Coberturas"))
		mapCoberturas.put(262,issue_info.get(18).get("Coberturas"))
		mapCoberturas.put(263,issue_info.get(19).get("Coberturas"))

		WebUI.delay(10)

		println("    [validation [ O texto: A Allianz tem o pacote certo para você;   ]")
		selecionaListaDeElementos(xpath, h2)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{  //System.err.println("h2 ["+i+"] : ["+listOfElements[i].getText()+"]")
				if( maph2.get(i).toString().equals(listOfElements[i].getText())) //A Allianz tem o pacote certo para você;
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maph2.get(i).toString()+"]")
				}
			}
		}

		println("    [validation [ Sessão Edição de Cálculo;   ]")
		selecionaListaDeElementos(xpath, h4)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{ //System.err.println("h4 ["+i+"] : ["+listOfElements[i].getText()+"]")
				if( maph4.get(i).toString().equals(listOfElements[i].getText())) //Sessão Edição de Cálculo;
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maph4.get(i).toString()+"]")
				}
			}
		}

		println("    [validation [ Vigência da Apólice;   ]")
		println("    [validation [ Opção de seleção 'Ver Comparação' em todos os pacotes disponíveis;   ]")

		selecionaListaDeElementos(xpath, label)
		int qtdmapVerComparacao = 0  // 12
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{  //System.err.println("label ["+i+"] : ["+listOfElements[i].getText()+"]")
				if( listOfElements[i].getText().contains(mapVigenciaApolice.get(i).toString()) ) //Vigência da Apólice
				{
					validations.add("["+listOfElements[i].getText()+"] CONTAINS ["+mapVigenciaApolice.get(i).toString()+"]")
				}

				if( listOfElements[i].getText().equals(mapVerComparacao.get(i).toString())) //Opção de seleção ""Ver Comparação"" em todos os pacotes disponíveis;
				{
					qtdmapVerComparacao++
				}
			}
		}


		if(qtdmapVerComparacao == 12)
		{
			validations.add("Opção de seleção 'Ver Comparação' em todos os pacotes disponíveis exibidos corretamente ["+qtdmapVerComparacao+"]")
		}

		println("    [validation [ Número da Operação;   ]")
		println("    [validation [ Sessão Resumo dos Dados;   ]")
		println("    [validation [ Pacote nossa recomendação;   ]")
		println("    [validation [ Pacotes de acordo com o perfil do risco;   ]")
		println("    [validation [ Coberturas de acordo com o perfil do risco;   ]")
		selecionaListaDeElementos(xpath, div)
		int qtdmapPacotes = 0
		int qtdCoberturas = 0
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{
				//System.err.println("div ["+i+"] : ["+listOfElements[i].getText()+"]")
				if( listOfElements[i].getText().contains(mapdivNumeroDaOperação.get(i).toString())) //Número da Operação;
				{
					validations.add("["+listOfElements[i].getText()+"] CONTAINS ["+mapdivNumeroDaOperação.get(i).toString()+"]")
				}

				if( listOfElements[i].getText().contains(mapdivResumoDosDados.get(i).toString())) //Sessão Resumo dos Dados;
				{
					validations.add("["+listOfElements[i].getText()+"] CONTAINS ["+mapdivResumoDosDados.get(i).toString()+"]")
				}

				if( listOfElements[i].getText().contains(mapdivNossaRecomendação.get(i).toString())) //Pacote nossa recomendação;
				{
					validations.add("["+listOfElements[i].getText()+"] CONTAINS ["+mapdivNossaRecomendação.get(i).toString()+"]")
				}

				if( listOfElements[i].getText().contains(mapPacotes.get(i).toString())) //Pacotes de acordo com o perfil do risco;
				{
					qtdmapPacotes++
				}

				if( listOfElements[i].getText().contains(mapCoberturas.get(i).toString())) //Coberturas de acordo com o perfil do risco;
				{
					qtdCoberturas++
				}
				//highlightElement("//div[@id='packets']")
				print("*")
				//unHighlightElement("//div[@id='packets']")
			}
		}



		if(qtdmapPacotes == 6)
		{
			validations.add("Pacotes exibidos corretamente ["+validations+"]")
		}



		if(qtdCoberturas == 11)
		{
			validations.add("Coberturas exibidas corretamente ["+qtdCoberturas+"]")
		}

		println("\n    [validation [ Botão 'Comprar' em todos os pacotes disponíveis;   ]")
		println("    [validation [ Botão 'Voltar';   ]")
		println("    [validation [ Botão 'Comparar itens selecionados';   ]")
		selecionaListaDeElementos(xpath, button)
		int qtdmapButtons = 0
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{  //System.err.println("buttons ["+i+"] : ["+listOfElements[i].getText()+"]")
				if( listOfElements[i].getText().contains(mapButtons.get(i).toString()))
				{
					qtdmapButtons++
				}
			}
		}


		if(qtdmapButtons == 16)
		{
			validations.add("Botão 'Comprar','Comparar itens selecionados','Voltar','Débito em conta bancária' exibidos corretamente ["+qtdmapButtons+"]")
		}


		println("    [validation [ Forma de Pagamento; (Opção Débito em Conta Bancária ou Boleto Bancário).   ]")
		clicarEmElementoDaTela("//div[contains(@class,'combo-div')]//button[contains(@data-id,'comboPaymentMode')]", 1)
		int qtdFormaDePagamento = 0
		selecionaListaDeElementos("//div[contains(@class,'btn-group bootstrap-select block open')]//div[contains(@class,'dropdown-menu open')]", a)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals(""))
			{
				if( listOfElements[i].getText().equals(mapFormasDePagamento.get(i).toString()))
				{
					qtdFormaDePagamento++
				}
			}
		}

		if(qtdFormaDePagamento == 2)
		{
			validations.add("Forma de Pagamento 'Débito em conta bancária' e 'Boleto Bancário' exibidos corretamente")
		}


		println("    [validation [ Valida Ícone diquete para salvar cotações   ]")
		selecionaListaDeElementos(xpath, "img")
		for(int i = 0; i < listOfElements.size(); i++){
			if( listOfElements[i].getTagName().toString().equals(mapDiqueteSalvar.get(i).toString()))
			{
				validations.add("Ícone diquete para salvar cotações exibido corretamente")
			}
		}

		println("    [validation [ Valores das coberturas de cada pacote;  ]")
		int qtdValidacoes = 0
		for(int i = 0; i< qtdmapPacotes; i++ ){
			selecionaListaDeElementos("//div[contains(@id,'package_"+i+"')]//div[contains(@class,'packages-container')]", "div")
			for(int j = 0; j < listOfElements.size(); j++){
				if( !listOfElements[j].getText().equals(""))
				{
					if(12<j){
						if(listOfElements[j].getText().length() > 0){
							qtdValidacoes++
						}
					}
				}
			}
		}

		def total = qtdmapPacotes*qtdCoberturas
		if(total == qtdValidacoes)
		{
			validations.add(total+" Validaçõeses para valores das coberturas de cada pacote")
		}

		println("    [validation [ Valor do prêmio para todos  os pacotes disponíveis;  ]")
		int qtdValorDoPremio = 0
		for(int i = 0; i< qtdmapPacotes; i++ ){
			selecionaListaDeElementos("//div[contains(@id,'package_"+i+"')]", "div")
			for(int j = 0; j < listOfElements.size(); j++){
				if( !listOfElements[j].getText().equals(""))
				{
					if(3==j)
					{
						if(listOfElements[j].getText().length() > 0){
							qtdValorDoPremio++
						}
					}
					if(35==j)
					{
						if(listOfElements[j].getText().length() > 0){
							qtdValorDoPremio++
						}
					}
				}
			}
		}

		System.err.println("Validar Layout Preco: qtdmapPacotes ["+qtdmapPacotes+"] qtdCoberturas ["+qtdCoberturas+"]")
		if(qtdValorDoPremio == qtdmapPacotes*2)
		{
			validations.add("Valor do prêmio para todos os pacotes disponíveis")
		}
		totalvalidationslabels = validations.size()
	}

	/**
	 * @author T_DCDias
	 * '2. Preço' Confirma o layout dos campos na ordem
	 * @return
	 */
	public static exibirLayoutPreco(){
		System.err.println("Validar Layout Preco: Itens validados ["+totalvalidationslabels +"] Total para validar ["+ totalDeLabels+"]" )
		if(totalvalidationslabels == totalDeLabels){
			highlightElementLayoutPreco()
			salvarEvidencia(issue_info.get(0).get("CT")," Layout '2. Preço' exibido corretamente","PASSED")
			unHighlightElementLayoutPreco()
		}
		else {
			adicionaImagem(issue_info.get(0).get("CT")," Layout '2. Preço' não exibido corretamente", "FAIL", 1)
		}
	}

	/**
	 * @author T_DCDias 
	 * @return
	 */
	public static highlightElementLayoutPreco(){
		highlightElement("//h2[text()='A Allianz tem o pacote certo para você.']")
		highlightElement("//img[@id='saveStudyIcon']")
		highlightElement("//div[text()='Resumo dos dados']")
		highlightElement("//label[@id='validity']")
		highlightElement("//div[text()='Número da operação']")
		highlightElement("//h4[text()='Edição de Cálculo']")
		highlightElement("//div[@class='cobertura-title']")
		highlightElement("//div[@class='hide-on-mobile-package']")
		highlightElement("//div[@id='divGeneral_0']//div[@class='mobile-package-value']")
		highlightElement("//div[@id='divGeneral_1']//div[@class='mobile-package-value']")
		highlightElement("//div[@id='divGeneral_2']//div[@class='mobile-package-value']")
		highlightElement("//div[@id='divGeneral_3']//div[@class='mobile-package-value']")
		highlightElement("//div[@id='divGeneral_4']//div[@class='mobile-package-value']")
		highlightElement("//div[@id='divGeneral_5']//div[@class='mobile-package-value']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayoutPreco(){
		unHighlightElement("//h2[text()='A Allianz tem o pacote certo para você.']")
		unHighlightElement("//img[@id='saveStudyIcon']")
		unHighlightElement("//div[text()='Resumo dos dados']")
		unHighlightElement("//label[@id='validity']")
		unHighlightElement("//div[text()='Número da operação']")
		unHighlightElement("//h4[text()='Edição de Cálculo']")
		unHighlightElement("//div[@class='cobertura-title']")
		unHighlightElement("//div[@class='hide-on-mobile-package']")
		unHighlightElement("//div[@id='divGeneral_0']//div[@class='mobile-package-value']")
		unHighlightElement("//div[@id='divGeneral_1']//div[@class='mobile-package-value']")
		unHighlightElement("//div[@id='divGeneral_2']//div[@class='mobile-package-value']")
		unHighlightElement("//div[@id='divGeneral_3']//div[@class='mobile-package-value']")
		unHighlightElement("//div[@id='divGeneral_4']//div[@class='mobile-package-value']")
		unHighlightElement("//div[@id='divGeneral_5']//div[@class='mobile-package-value']")
	}

	/**
	 * @author T_DCDias
	 * Verifica o campo default na tela '2. Preço'
	 * @param data
	 * @return
	 */
	public static validaCampoDefautComboFormaDePagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * Confirma que, o campo default na tela '2. Preço' está correto
	 * @param result
	 * @return
	 */
	public static campoDefautComboFormaDePagamento(String result){
		println("    [validation [ Valida campo default na tela '2 Preço' Forma de Pagamento  Débito em conta bancária;  ]")
		def xpath ="//div[contains(@class,'combo-div')]//button[contains(@data-id,'comboPaymentMode')]//span[contains(text(),'Débito em conta bancária')]"
		if(issue_info.get(0).get("Forma de Pagamento").equals(pegaValorDaTela(xpath)) == true){
			highlightElementComboFormaDePagamento()
			salvarEvidencia(issue_info.get(0).get("CT")," Campo default 'Forma de Pagamento : Débito em conta bancária' na  tela '2. Preço' exibido corretamente","PASSED")
			unHighlightElementComboFormaDePagamento()
		}
		else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campo default na  tela '2. Preço' não exibido corretamente", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementComboFormaDePagamento(){
		highlightElement("//div[contains(@class,'btn-group bootstrap-select block open')]//div[contains(@class,'dropdown-menu open')]//span[text()='Débito em conta bancária']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementComboFormaDePagamento(){
		unHighlightElement("//div[contains(@class,'btn-group bootstrap-select block open')]//div[contains(@class,'dropdown-menu open')]//span[text()='Débito em conta bancária']")
	}


	/**
	 * @author T_DCDias
	 * Mapa do layout da pagina 1.Cotação Auto, método valida ordem dos labels
	 * @return
	 */
	public static verificarLayoutCotacaoAuto(DataTable data){
		posicaoDaTela("//a[text()='1. Cotação Auto']")
		WebUI.delay(10)

		issue_info =  data.asMaps(String.class, String.class);
		def xpathIFrame = "//div[contains(@id,'content_null')]"
		def taglabel = "label" ,  tagp = "p"  , tagbutton = "button", tagh2 = "h2"    , tagb = "b"
		totalDeLabels = 25
		List<String> validations = new ArrayList<String>();

		HashMap<Integer, String> maptagb= new HashMap<Integer,String>()
		maptagb.put(0,issue_info.get(0).get("Label"))
		maptagb.put(1,issue_info.get(1).get("Label"))

		HashMap<Integer, String> maptagh2= new HashMap<Integer,String>()
		maptagh2.put(0,issue_info.get(2).get("Label"))

		HashMap<Integer, String> maptagp= new HashMap<Integer,String>()
		maptagp.put(3,issue_info.get(3).get("Label"))
		maptagp.put(5, issue_info.get(4).get("Lista"))
		maptagp.put(7, issue_info.get(5).get("Lista"))
		maptagp.put(9, issue_info.get(6).get("Lista"))
		maptagp.put(11,issue_info.get(7).get("Lista"))
		maptagp.put(13, issue_info.get(8).get("Lista"))
		maptagp.put(15, issue_info.get(9).get("Lista"))

		HashMap<Integer, String> maptagbutton= new HashMap<Integer,String>()
		maptagbutton.put(88, issue_info.get(24).get("Label"))

		HashMap<Integer, String> maptlabel= new HashMap<Integer,String>()
		maptlabel.put(4, issue_info.get(10).get("Label"))
		maptlabel.put(7, issue_info.get(11).get("Label"))
		maptlabel.put(9, issue_info.get(12).get("Label"))
		maptlabel.put(10,issue_info.get(13).get("Label"))
		maptlabel.put(16,issue_info.get(14).get("Label"))
		maptlabel.put(19,issue_info.get(15).get("Label"))
		maptlabel.put(21,issue_info.get(16).get("Label"))
		maptlabel.put(23,issue_info.get(17).get("Label"))
		maptlabel.put(24,issue_info.get(18).get("Label"))
		maptlabel.put(32,issue_info.get(19).get("Label"))
		maptlabel.put(34,issue_info.get(20).get("Label"))
		maptlabel.put(37,issue_info.get(21).get("Label"))
		maptlabel.put(39, issue_info.get(22).get("Label"))
		maptlabel.put(55,issue_info.get(23).get("Label"))

		selecionaListaDeElementos(xpathIFrame,tagb)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( maptagb.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maptagb.get(i).toString()+"]")
				}
			}
		}

		selecionaListaDeElementos(xpathIFrame,tagh2)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( maptagh2.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maptagh2.get(i).toString()+"]")
				}
			}

		}

		selecionaListaDeElementos(xpathIFrame,taglabel)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( maptlabel.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maptlabel.get(i).toString()+"]")
				}
			}
		}

		selecionaListaDeElementos(xpathIFrame,tagp)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( maptagp.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maptagp.get(i).toString()+"]")
				}
			}
		}

		selecionaListaDeElementos(xpathIFrame,tagbutton)
		for(int i = 0; i < listOfElements.size(); i++){
			if( !listOfElements[i].getText().equals("")){
				if( maptagbutton.get(i).toString().equals(listOfElements[i].getText()))
				{
					validations.add("["+listOfElements[i].getText()+"] EQUALS ["+maptagbutton.get(i).toString()+"]")
				}
			}
		}
		totalvalidationslabels = validations.size()
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static telaPagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		leituraMassa(issue_info.get(0).get("CT"))
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static telaPagamentoVerificaMensagemObrigatoria(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		WebUI.delay(2)
		posicaoDaTela("//h4[text()='Dados do segurado']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirMensagemObrigatório(){
		try{
			// WebUI.delay(2)
			// posicaoDaTela("//h4[text()='Dados do segurado']")
			//email
			limparCamposInput("//input[@id='txtMaskEmail']")

			//celular
			limparCamposInput("//input[@id='phoneTypeBR']")

			//prof
			//limparCamposInput("//input[@id='comboProfAuto']")

			// posicaoDaTela("//h4[text()='Forma de pagamento']")
			WebUI.delay(2)
			//renda mensal click abrir combo
			clicarEmElementoDaTela("//button[@data-id='comboRenda']", 2)

			//WebUI.delay(2)
			//selecionar item 0 do combo
			clicarEmElementoDaTela("//button[@data-id='comboRenda']//..//span[text()='--']", 2)

			//WebUI.delay(2)
			//clicar na data venc
			clicarEmElementoDaTela("//button[@data-id='diaDeVencBol']", 2)

			//seleciona opção 1
			clicarEmElementoDaTela("//button[@data-id='diaDeVencBol']//span[text()='1']", 2)

			//cep
			limparCamposInput("//input[@id='CEP']")

			//num
			limparCamposInput("//input[@id='f_numero']")

			//complemento clicar para aparecer a msg de num
			clicarEmElementoDaTela("//input[@id='f_complemento']", 5)

			posicaoDaTela("//h4[text()='Dados do segurado']")

		} catch (Exception e) {}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static camposSaoDestacadosNaTelaPagamento(){
		try{
			List<String> validations = new ArrayList<String>();
			HashMap<Integer, String> msgcampobrig= new HashMap<Integer,String>()
			msgcampobrig.put(0,issue_info.get(0).get("Mensagem"))
			msgcampobrig.put(1,issue_info.get(1).get("Mensagem"))
			msgcampobrig.put(2,issue_info.get(2).get("Mensagem"))
			msgcampobrig.put(3,issue_info.get(3).get("Mensagem"))
			msgcampobrig.put(4,issue_info.get(4).get("Mensagem"))
			msgcampobrig.put(5,issue_info.get(5).get("Mensagem"))
			selecionaListaDeElementos("//div[contains(@id,'content_null')]","p")
			for(int i = 0; i < listOfElements.size(); i++){
				print("*")
				if( !listOfElements[i].getText().equals("")){
					if( msgcampobrig.get(i).toString().equals(listOfElements[i].getText())) {
						validations.add("["+listOfElements[i].getText()+"] EQUALS ["+msgcampobrig.get(i).toString()+"]")
					}
				}
			}
			if(validations.size()==5){ // total 6 - campo profissão não validado
				highlightElementMensagemObrigatorioTelaPagamento()
				salvarEvidencia(issue_info.get(0).get("CT")," Campos destacados na tela '3. Pagamento' exibidos corretamente.","PASSED")
				unHighlightElementMensagemObrigatorioTelaPagamento()
			} else {
				salvarEvidencia(issue_info.get(0).get("CT")," Campos destacados na tela '3. Pagamento' não exibidos corretamente.","FAIL")
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Campos destacados na tela '3. Pagamento' não exibidos corretamente.","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementMensagemObrigatorioTelaPagamento(){
		highlightElement("//div[@id='errorbox-1']")
		highlightElement("//div[@id='errorbox-2']")
		//	highlightElement("//div[@id='errorbox-3']")
		highlightElement("//div[@id='errorbox-4']")
		highlightElement("//div[@id='errorbox-5']")
		highlightElement("//div[@id='errorbox-6']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementMensagemObrigatorioTelaPagamento(){
		unHighlightElement("//div[@id='errorbox-1']")
		unHighlightElement("//div[@id='errorbox-2']")
		//	unHighlightElement("//div[@id='errorbox-3']")
		unHighlightElement("//div[@id='errorbox-4']")
		unHighlightElement("//div[@id='errorbox-5']")
		unHighlightElement("//div[@id='errorbox-6']")
	}



	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicaNoComboRendaMensal(){
		posicaoDaTela("//label[text()='Renda mensal *']")
		clicarEmElementoDaTela("//button[@data-id='comboRenda']", 5)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirInformacoesDoComboRendaMensal(){
		try{
			WebUI.delay(10)
			posicaoDaTela("//a[text()='3. Pagamento']")
			selecionaListaDeElementos("//button[@data-id='comboRenda']//..//ul[@class='dropdown-menu inner']", "span")
		} catch (Exception e){
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaDuplicidade(){
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
	 * @param data
	 * @return
	 */
	public static verificaCamposDefaultTelaPagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		HashMap<Integer, String> mapLabel= new HashMap<Integer,String>()
		List<String> validations = new ArrayList<String>();
		try{
			mapLabel.put(11,issue_info.get(0).get("Campos"))
			mapLabel.put(13,issue_info.get(1).get("Campos"))
			selecionaListaDeElementos("//div[contains(@id,'content_null')]","label")
			for(int i = 0; i < listOfElements.size(); i++){
				print("*")
				if( !listOfElements[i].getText().equals("")){
					if( mapLabel.get(i).toString().equals(listOfElements[i].getText())) {
						validations.add("["+listOfElements[i].getText()+"] EQUALS ["+mapLabel.get(i).toString()+"]")
					}
				}
			}

			if(validaElemento("//div[@class='alz-wm-checkbox-button disabled alz-wm-form-control-inline-cbrb']//label[text()='Receber documentos relacionados à apólice apenas por email?']")){
				validations.add("true")
			}

			if(validaElemento("//div[@id='BTBenefCredNao_container']//button//input[@data-btn-inside-radio='enabled']")){
				validations.add("true")
			}
			camposDefaultTelaPagamento = validations.size()
		}  catch (Exception e) {
			camposDefaultTelaPagamento = validations.size()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirCamposDefault(){
		if(camposDefaultTelaPagamento==4){
			highlightElementCamposDefaultTelaPagamento()
			salvarEvidencia(issue_info.get(0).get("CT")," Campos default da tela '3.Pagamento' exibidos corretamente ["+camposDefaultTelaPagamento+"]", "PASSED")
			unHighlightElementCamposDefaultTelaPagamento()
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," Campos default da tela '3.Pagamento' não exibidos corretamente ["+camposDefaultTelaPagamento+"]", "FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCamposDefaultTelaPagamento(){
		highlightElement("//div[@id='BTBenefCredNao_container']")
		highlightElement("//label[@id='justEmail_label']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCamposDefaultTelaPagamento(){
		unHighlightElement("//div[@id='BTBenefCredNao_container']")
		unHighlightElement("//label[@id='justEmail_label']")
	}


	/**
	 * @author T_DCDias
	 * Clica na sessão 'Resumo dos dados'
	 * @return
	 */
	public static clicarNaSessãoResumoDosDados(){
		posicaoDaTela("//a[text()='2. Preço']")
		clicarEmElementoDaTela("//div[contains(@id,'datablockicon')]", 5)
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Verificar o layout da sessão 'Resumo dos dados' dos seguintes campos
	 */
	public static validaLayoutDaSessãoResumoDosDados(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * Exibir o layout da sessão 'Resumo dos dados' corretamente
	 * @return
	 */
	public static exibirLayoutDaSessãoResumoDosDadosCorretamente(){

		HashMap<Integer, String> mapTitulosResumo= new HashMap<Integer,String>()
		mapTitulosResumo.put(0,issue_info.get(0).get("Veículo"))
		mapTitulosResumo.put(2,issue_info.get(0).get("Dados do condutor"))
		mapTitulosResumo.put(4,issue_info.get(0).get("Dados do segurado"))
		mapTitulosResumo.put(6,issue_info.get(0).get("Perfil do condutor"))

		HashMap<Integer, String> mapResumoDosDados= new HashMap<Integer,String>()
		mapResumoDosDados.put(0,issue_info.get(1).get("Veículo"))
		mapResumoDosDados.put(1,issue_info.get(2).get("Veículo"))
		mapResumoDosDados.put(2,issue_info.get(3).get("Veículo"))
		mapResumoDosDados.put(3,issue_info.get(4).get("Veículo"))
		mapResumoDosDados.put(4,issue_info.get(5).get("Veículo"))
		mapResumoDosDados.put(5,issue_info.get(6).get("Veículo"))
		mapResumoDosDados.put(6,issue_info.get(7).get("Veículo"))
		mapResumoDosDados.put(7,issue_info.get(8).get("Veículo"))
		mapResumoDosDados.put(8,issue_info.get(9).get("Veículo"))
		mapResumoDosDados.put(9,issue_info.get(10).get("Veículo"))
		mapResumoDosDados.put(10,issue_info.get(11).get("Veículo"))
		mapResumoDosDados.put(11,issue_info.get(12).get("Veículo"))
		mapResumoDosDados.put(12,issue_info.get(13).get("Veículo"))
		mapResumoDosDados.put(13,issue_info.get(1).get("Dados do condutor"))
		mapResumoDosDados.put(14,issue_info.get(2).get("Dados do condutor"))
		mapResumoDosDados.put(15,issue_info.get(3).get("Dados do condutor"))
		mapResumoDosDados.put(16,issue_info.get(1).get("Dados do segurado"))
		mapResumoDosDados.put(17,issue_info.get(2).get("Dados do segurado"))
		mapResumoDosDados.put(18,issue_info.get(1).get("Perfil do condutor"))
		mapResumoDosDados.put(19,issue_info.get(2).get("Perfil do condutor"))

		println("    [validation [ verifico o layout da sessão 'Resumo dos dados' na tela '3. Pagamento' são exibidos os campos na seguinte ordem   ]")
		selecionaListaDeElementos("//div[contains(@id,'resumo-dados-global-container')]", "span")// mapTitulosResumo
		int qtdTitulosResumo = 0
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{  	//System.err.println("span [ "+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().equals(mapTitulosResumo.get(j).toString())){ qtdTitulosResumo++ }}
		}

		selecionaListaDeElementos("//div[contains(@id,'resumo-dados-global-container')]", "b")// mapResumoDosDados
		int qtdResumoDosDados = 0
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{	//System.err.println("b [ "+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().equals(mapResumoDosDados.get(j).toString())){ qtdResumoDosDados++ }}
		}

		if(qtdTitulosResumo+qtdResumoDosDados == 24){
			highlightElementlayoutResumoDosDados()
			salvarEvidencia(issue_info.get(0).get("CT")," layout da sessão 'Resumo dos dados' são exibidos corretamente","PASSED")
			unHighlightElementlayoutResumoDosDados()
		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT")," layout da sessão 'Resumo dos dados' não são exibidos corretamente","FAIL")
		}
		clicarEmElementoDaTela("//div[contains(@id,'datablockicon')]", 1)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementlayoutResumoDosDados(){
		highlightElement("//span[text()='Veículo']")
		highlightElement("//span[text()='Dados do condutor']")
		highlightElement("//span[text()='Dados do segurado']")
		highlightElement("//span[text()='Perfil do condutor']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Placa: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Chassis: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Marca: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Modelo: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Versão: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Ano Modelo: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Código Fipe: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Valor Fipe: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Zero KM: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Cep pernoite: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Endereço pernoite: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Veículo blindado: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Uso Comercial: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Nome Segurado: ']")
		highlightElement("//span[text()='Dados do segurado']//..//b[1]")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Nome do Condutor: ']")
		highlightElement("//span[text()='Dados do condutor']//..//b[1]")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Estado Civil: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Reside com pessoas de 17 e 25 anos?: ']")
		highlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='O principal condutor reside em: ']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementlayoutResumoDosDados(){
		unHighlightElement("//span[text()='Veículo']")
		unHighlightElement("//span[text()='Dados do condutor']")
		unHighlightElement("//span[text()='Dados do segurado']")
		unHighlightElement("//span[text()='Perfil do condutor']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Placa: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Chassis: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Marca: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Modelo: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Versão: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Ano Modelo: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Código Fipe: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Valor Fipe: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Zero KM: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Cep pernoite: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Endereço pernoite: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Veículo blindado: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Uso Comercial: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Nome Segurado: ']")
		unHighlightElement("//span[text()='Dados do segurado']//..//b[1]")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Nome do Condutor: ']")
		unHighlightElement("//span[text()='Dados do condutor']//..//b[1]")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Estado Civil: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='Reside com pessoas de 17 e 25 anos?: ']")
		unHighlightElement("//span[@class='resumo-dados-title-descripcion']//b[text()='O principal condutor reside em: ']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicarNaSessãoEdiCAoDeCalculo(){
		clicarEmElementoDaTela("//span[contains(@class,'allianz-icon allianz-icon-chevron-down pull-right alz-wm-accordion-section-icon-color')]", 2)
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static verificarLayoutSessãoEdicaoDeCalculo(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * Verifica o layout da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:
	 * @return
	 */
	public static validarLayoutDaSessaoEdicaoDeCAlculo(){

		HashMap<Integer, String> mapEdicaoDeCalculo= new HashMap<Integer,String>()
		mapEdicaoDeCalculo.put(0,issue_info.get(0).get("Valores"))
		mapEdicaoDeCalculo.put(1,issue_info.get(1).get("Valores"))
		mapEdicaoDeCalculo.put(2,issue_info.get(2).get("Valores"))
		mapEdicaoDeCalculo.put(3,issue_info.get(3).get("Valores"))
		mapEdicaoDeCalculo.put(4,issue_info.get(4).get("Valores"))
		mapEdicaoDeCalculo.put(5,issue_info.get(5).get("Valores"))
		mapEdicaoDeCalculo.put(7,issue_info.get(7).get("Valores"))

		HashMap<Integer, String> mapButtons= new HashMap<Integer,String>()
		mapButtons.put(6,issue_info.get(6).get("Valores"))


		println("    [validation [ "+issue_info.get(0).get("CT")+" - verificar layout da sessão 'Resumo dos dados' são exibidos os campos na seguinte ordem:   ]")
		selecionaListaDeElementos("//div[contains(@class,'alz-wm-bs-panel-body')]", "label")// mapEdicaoDeCalculo
		int qtdmapEdicaoDeCalculo = 0
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{  	if(listOfElements[j].getText().equals(mapEdicaoDeCalculo.get(j).toString())){ qtdmapEdicaoDeCalculo++ }}
		}

		selecionaListaDeElementos("//div[contains(@class,'alz-wm-bs-panel-body')]", "button")// mapButtons
		int qtdmapButtons = 0
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{	if(listOfElements[j].getText().equals(mapButtons.get(j).toString())) {
					qtdmapButtons++ } }
		}

		if(qtdmapEdicaoDeCalculo+qtdmapButtons == 7){
			highlightElementlayoutEdicaoDeCalculo()
			salvarEvidencia(issue_info.get(0).get("CT")," Layout da sessão 'Resumo dos dados' são exibidos corretamente","PASSED")
			unHighlightElementlayoutEdicaoDeCalculo()
		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT")," Layout da sessão 'Resumo dos dados' não são exibidos corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementlayoutEdicaoDeCalculo(){
		highlightElement("//label[text()='Antecipação da comissão?']")
		highlightElement("//label[text()='Desconto venda cruzada (%)']")
		highlightElement("//label[text()='CAP (%)']")
		highlightElement("//label[text()='% de Agravo']")
		highlightElement("//label[text()='Comissão (%)']")
		highlightElement("//label[text()='Tabela FIPE (%)']")
		highlightElement("//label[text()='Possui co-corretagem?']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementlayoutEdicaoDeCalculo(){
		unHighlightElement("//label[text()='Antecipação da comissão?']")
		unHighlightElement("//label[text()='Desconto venda cruzada (%)']")
		unHighlightElement("//label[text()='CAP (%)']")
		unHighlightElement("//label[text()='% de Agravo']")
		unHighlightElement("//label[text()='Comissão (%)']")
		unHighlightElement("//label[text()='Tabela FIPE (%)']")
		unHighlightElement("//label[text()='Possui co-corretagem?']")
	}


	/**
	 * @author T_DCDias
	 * Verifico os campos default da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:
	 * @param data
	 */
	public static void verificaCamposDefaultDaSessaoEdicaoDeCAlculo(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 *@author T_DCDias
	 * Exibidos os campos default da sessão 'Edição de Cálculo' corretamente
	 */
	public static void validarCamposDefaultDaSessaoEdicaoDeCAlculo(){
		println("    [validation [ "+issue_info.get(0).get("CT")+" - verifico os campos default da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:   ]")

		List<String> validations = new ArrayList<String>();

		WebDriver driverDescontoVendaCruzada = DriverFactory.getWebDriver()
		def descontoVendaCruzada = driverDescontoVendaCruzada.findElement(By.xpath("//div[@class='btn-group bootstrap-select disabled block']//span[@class='filter-option pull-left']")).getText();
		if(descontoVendaCruzada.equals(issue_info.get(1).get("Valores"))){
			validations.add("Antecipação da comissão")
		}

		WebDriver driverCap = DriverFactory.getWebDriver()
		def cap = driverCap.findElement(By.xpath("//div[@class='btn-group bootstrap-select block']//button[@data-id='comboCap']//span[@class='filter-option pull-left']")).getText();
		if(cap.equals(issue_info.get(2).get("Valores"))){
			validations.add("Desconto venda cruzada?")
		}

		WebDriver driverTabelaFIPE = DriverFactory.getWebDriver()
		def tabelaFIPE = driverTabelaFIPE.findElement(By.xpath("//label[@id='percFipe']")).getText();
		if(tabelaFIPE.equals(issue_info.get(5).get("Valores"))){
			validations.add("CAP")
		}

		WebDriver driverAgravo = DriverFactory.getWebDriver()
		if(driverAgravo.findElement(By.xpath("//input[@name='appealPercentage' and @value='"+issue_info.get(3).get("Valores")+"']")).isEnabled().toString().equals("false")){
			validations.add("% de Agravo")
		}

		WebDriver driverComissao = DriverFactory.getWebDriver()
		if( driverComissao.findElement(By.xpath("//input[@name='comboComissao' and @value='"+issue_info.get(4).get("Valores")+"']")).isEnabled().toString()){
			validations.add("Comissão (%)")
		}

		WebDriver driverAntecipaçãoDaComissão = DriverFactory.getWebDriver()
		if(driverAntecipaçãoDaComissão.findElement(By.xpath("//button[@id='BtnAntComissaoSim']//input[contains(@name,'radiobtnAntComissao') and contains(@checked,'checked' ) and contains(@id,'BtnAntComissaoSim')]")).isEnabled().toString()){
			validations.add("Tabela FIPE (%)")
		}

		WebDriver driverPossuiCoCorretagem = DriverFactory.getWebDriver()
		if (driverPossuiCoCorretagem.findElement(By.xpath("//button[@id='BtnCoCorretagemNao']//input[contains(@name,'radiobtnCoCorretagem') and contains(@checked,'checked' ) and contains(@id,'BtnCoCorretagemNao')]")).isEnabled().toString()){
			validations.add("Possui co-corretagem?")
		}

		if(validations.size() == 7){
			highlightElementCamposDefaultEdicaoDeCalculo()
			salvarEvidencia(issue_info.get(0).get("CT")," Campos default da sessão 'Edição de Cálculo' são exibidos corretamente","PASSED")
			unHighlightElementCamposDefaultEdicaoDeCalculo()
		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT")," Campos default da sessão 'Edição de Cálculo' não são exibidos corretamente","FAIL")
		}
		fecharSessãoEdiCAoDeCalculo()
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCamposDefaultEdicaoDeCalculo(){
		highlightElement("//div[@id='BtnAntComissaoSim_container']")
		highlightElement("//div[@id='BtnCoCorretagemNao_container']")
		highlightElement("//div[@class='btn-group bootstrap-select disabled block']")
		highlightElement("//div[@class='btn-group bootstrap-select block']//button[@data-id='comboCap']")
		highlightElement("//input[@id='appealPercentage']")
		highlightElement("//input[@id='comboComissao']")
		highlightElement("//label[@id='percFipe']")
		highlightElement("//div[@id='divRecalc']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCamposDefaultEdicaoDeCalculo(){
		unHighlightElement("//div[@id='BtnAntComissaoSim_container']")
		unHighlightElement("//div[@id='BtnCoCorretagemNao_container']")
		unHighlightElement("//div[@class='btn-group bootstrap-select disabled block']")
		unHighlightElement("//div[@class='btn-group bootstrap-select block']//button[@data-id='comboCap']")
		unHighlightElement("//input[@id='appealPercentage']")
		unHighlightElement("//input[@id='comboComissao']")
		unHighlightElement("//label[@id='percFipe']")
		unHighlightElement("//div[@id='divRecalc']")
	}

	/**
	 * @author T_DCDias
	 * Clicar no ícone 'Salvar Cotação'
	 * @return
	 */
	public static clicarSalvarCotação(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		clicarEmElementoDaTela("//img[@id='saveStudyIcon']", 1)
	}

	/**
	 * @author T_DCDias
	 * Exibida a tela 'Salvar Cotação'
	 * @return
	 */
	public static validaTelaSalvarCotação(){
		WebDriver driverTelaSalvaCotacao = DriverFactory.getWebDriver()
		if( driverTelaSalvaCotacao.findElement(By.xpath("//span[text()='A Allianz tem o pacote certo para você.']")).isEnabled().toString() ){
			salvarEvidencia(issue_info.get(0).get("CT")," Tela 'Salvar Cotação' exibida ","PASSED")
		}else {
			salvarEvidencia(issue_info.get(0).get("CT")," ela 'Salvar Cotação' não exibidae","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Verifica o layout da tela 'Salvar Cotação', verifica se os campos são exibidosna seguinte ordem
	 */
	public static verificaLayoutDaTelaSalvarCotação(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * @return
	 *  Validar exibição do layout da tela 'Salvar Cotação' corretamente
	 */
	public static validaLayoutDaTelaSalvarCotação(){
		println("    [validation [ "+issue_info.get(0).get("CT")+" - Validar exibição do layout da tela 'Salvar Cotação' corretamente   ]")

		List<String> validations = new ArrayList<String>();

		HashMap<Integer, String> mapSpan= new HashMap<Integer,String>()
		mapSpan.put(0,issue_info.get(0).get("Valores"))
		mapSpan.put(1,issue_info.get(1).get("Valores"))
		mapSpan.put(2,issue_info.get(2).get("Valores"))
		mapSpan.put(4,issue_info.get(3).get("Valores"))
		mapSpan.put(9,issue_info.get(6).get("Valores"))

		HashMap<Integer, String> mapLabel= new HashMap<Integer,String>()
		mapLabel.put(0,issue_info.get(4).get("Valores"))
		mapLabel.put(1,issue_info.get(5).get("Valores"))

		HashMap<Integer, String> mapButton= new HashMap<Integer,String>()
		mapButton.put(0,issue_info.get(8).get("Valores"))
		mapButton.put(1,issue_info.get(9).get("Valores"))

		WebUI.delay(5)
		selecionaListaDeElementos("//div[@id='lightboxSalvaCotacao_content']//div[@id='lightboxSalvaCotacao_body']", "span")
		int qtdmapSpan
		for(int j = 0; j < listOfElements.size(); j++){
			if(listOfElements[j].getText().contains(mapSpan.get(j).toString())) {
				qtdmapSpan++ }
		}

		selecionaListaDeElementos("//div[@id='lightboxSalvaCotacao_content']//div[@id='lightboxSalvaCotacao_body']", "label")
		int qtdmapLabel
		for(int j = 0; j < listOfElements.size(); j++){
			if(listOfElements[j].getText().equals(mapLabel.get(j).toString())) {
				qtdmapLabel++ }
		}

		selecionaListaDeElementos("//div[@id='lightboxSalvaCotacao_content']//div[@id='lightboxSalvaCotacao_body']", "button")
		int qtdmapButton
		for(int j = 0; j < listOfElements.size(); j++){  //System.err.println(j+" ["+listOfElements[j].getText()+"]")
			if(listOfElements[j].getText().equals(mapButton.get(j).toString())) {
				qtdmapButton++ }
		}

		//pacotes
		HashMap<Integer, String> mapPacotes= new HashMap<Integer,String>()
		mapPacotes.put( 3,"Ampliado 2")
		mapPacotes.put(11,"Compacto 1")
		mapPacotes.put(19,"Compacto 2")
		mapPacotes.put(27,"Ampliado 1")
		mapPacotes.put(35,"Especial")
		mapPacotes.put(43,"Exclusivo")
		int qtdmapPacotes
		selecionaListaDeElementos("//div[@id='savePackageContainer']", "div")
		for(int j = 0; j < listOfElements.size(); j++){
			if( listOfElements[j].getText().equals(mapPacotes.get(j).toString())){ qtdmapPacotes++ }
		}

		int totalValidations = qtdmapSpan+qtdmapLabel+qtdmapButton+qtdmapPacotes

		if(totalValidations == 15){

			salvarEvidencia(issue_info.get(0).get("CT")," Layout da tela 'Salvar Cotação' exibidos corretamente","PASSED")

		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT"),"  Layout da tela 'Salvar Cotação' não exibidos corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementLayoutSalvarCotacao(){
		highlightElement("//span[text()='A Allianz tem o pacote certo para você.']")
		highlightElement("//span[@id='validaDataPopUp']")
		highlightElement("//span[text()='Número da cotação']")
		highlightElement("//span[text()='Dados do cliente']")
		highlightElement("//label[text()='Insira o endereço de e-mail do cliente']")
		highlightElement("//label[@id='mailToAgent_label']")
		highlightElement("//span[text()='Pacotes:']")
		highlightElement("//div[@id='package_save_0']")
		highlightElement("//div[@id='package_save_1']")
		highlightElement("//div[@id='package_save_2']")
		highlightElement("//div[@id='package_save_3']")
		highlightElement("//div[@id='package_save_4']")
		highlightElement("//div[@id='package_save_5']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayoutSalvarCotacao(){
		unHighlightElement("//span[text()='A Allianz tem o pacote certo para você.']")
		unHighlightElement("//span[@id='validaDataPopUp']")
		unHighlightElement("//span[text()='Número da cotação']")
		unHighlightElement("//span[text()='Dados do cliente']")
		unHighlightElement("//label[text()='Insira o endereço de e-mail do cliente']")
		unHighlightElement("//label[@id='mailToAgent_label']")
		unHighlightElement("//span[text()='Pacotes:']")
		unHighlightElement("//div[@id='package_save_0']")
		unHighlightElement("//div[@id='package_save_1']")
		unHighlightElement("//div[@id='package_save_2']")
		unHighlightElement("//div[@id='package_save_3']")
		unHighlightElement("//div[@id='package_save_4']")
		unHighlightElement("//div[@id='package_save_5']")
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * verifico todos os 'Pacotes' disponíveis
	 */
	public static verificaPacotesdisponíveisSelecionados(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}


	/**
	 * @author T_DCDias
	 * campos default 'Pacotes' disponíveis da tela 'Salvar Cotação' corretamente
	 */
	public static validaPacotesdisponíveisSelecionados(){
		println("    [validation [ "+issue_info.get(0).get("CT")+" - Verifico todos os 'Pacotes' disponíveis; Selecionados   ]")

		HashMap<Integer, String> mapPacotesSel= new HashMap<Integer,String>()
		mapPacotesSel.put( 6,issue_info.get(0).get("Valor"))
		mapPacotesSel.put(14,issue_info.get(0).get("Valor"))
		mapPacotesSel.put(22,issue_info.get(0).get("Valor"))
		mapPacotesSel.put(30,issue_info.get(0).get("Valor"))
		mapPacotesSel.put(38,issue_info.get(0).get("Valor"))
		mapPacotesSel.put(46,issue_info.get(0).get("Valor"))

		int qtdmapPacotesSel
		for(int j = 0; j < listOfElements.size(); j++){
			if(listOfElements[j].getText().equals(mapPacotesSel.get(j).toString())) { qtdmapPacotesSel++ }
		}

		if(qtdmapPacotesSel == 6){
			salvarEvidencia(issue_info.get(0).get("CT")," Na tela 'Salvar Cotação' todos os 'Pacotes' disponíveis 'Selecionados' exibidos corretamente","PASSED")
		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT"),"  Na tela 'Salvar Cotação' todos os 'Pacotes' disponíveis 'Selecionados' não exibidos corretamente","FAIL")
		}

		clicarEmElementoDaTela("//div[@id='lightboxSalvaCotacao_header']//button[@aria-label='Close']", 1)
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Clico no botão 'Comprar' de um dos pacotes disponíveis
	 */
	public static clicarNoBotãoComprar(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		casodeteste.setFormaDePagamento(retornaValorDaTela("//button[@data-id='comboPaymentMode']", 1, 1, 1))
		selecionaListaDeElementos("//div[@id='package_0']", "div")
		String val
		for(int j = 0; j < listOfElements.size(); j++){
			if(j==2){ casodeteste.setPacote(listOfElements[j].getText())}
			if(j==3){
				String[] valor = auxiliares.CurrencyMonetary.removeEspacos(listOfElements[j].getText()).split("")
				val = auxiliares.CurrencyMonetary.removeValorMonetario(valor)
			}
		}
		casodeteste.setValorSeguro(val)
		clicarEmElementoDaTela("//button[@id='button_0']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static TelaPagamento(){
		WebUI.delay(15)
		try{
			def xpathDivSpan = "//div[contains(@id,'content_null')]"
			def tag1 = "a"
			boolean tl = false
			selecionaListaDeElementos(xpathDivSpan,tag1)
			for(int i = 0; i < listOfElements.size(); i++){
				if(listOfElements[i].getText().equals("3. Pagamento")){
					tl = true
				}
			}
			if(tl == true){
				highlightElementTelaPagamento()
				salvarEvidencia(issue_info.get(0).get("CT")," Tela '3.Pagamento' exibida corretamente","PASSED")
				unHighlightElementTelaPagamento()
			}
			else {
				salvarEvidencia(issue_info.get(0).get("CT")," Tela '3.Pagamento' não exibida corretamente","FAIL")
				WebUI.delay(2)
				finalizar()
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Exception - Não exibida a tela '3.Pagamento'", "FAIL")
			WebUI.delay(2)
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementTelaPagamento(){
		highlightElement("//a[text()='3. Pagamento']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementTelaPagamento(){
		unHighlightElement("//a[text()='3. Pagamento']")
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Verifico o layout da tela 'Pagamento'
	 */
	public static verificaLayoutTelaPagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Valida layout da tela 'Pagamento'
	 */
	public static validaLayoutDaTelaPagamentoDebito(){

		posicaoDaTela("//a[text()='3. Pagamento']")

		HashMap<Integer, String> mapCampLabel= new HashMap<Integer,String>()
		mapCampLabel.put( 0,issue_info.get(3).get("Campos"))
		mapCampLabel.put( 6,issue_info.get(5).get("Campos"))
		mapCampLabel.put( 7,issue_info.get(6).get("Campos"))
		mapCampLabel.put( 8,issue_info.get(7).get("Campos"))
		mapCampLabel.put( 9,issue_info.get(8).get("Campos"))
		mapCampLabel.put( 10,issue_info.get(9).get("Campos"))
		mapCampLabel.put( 11,issue_info.get(10).get("Campos"))
		mapCampLabel.put( 16,issue_info.get(12).get("Campos"))
		mapCampLabel.put( 17,issue_info.get(13).get("Campos"))
		mapCampLabel.put( 18,issue_info.get(14).get("Campos"))
		mapCampLabel.put( 19,issue_info.get(15).get("Campos"))
		mapCampLabel.put( 20,issue_info.get(16).get("Campos"))
		mapCampLabel.put( 21,issue_info.get(17).get("Campos"))
		mapCampLabel.put( 24,issue_info.get(18).get("Campos"))
		mapCampLabel.put( 27,issue_info.get(20).get("Campos"))
		mapCampLabel.put( 28,issue_info.get(21).get("Campos"))
		mapCampLabel.put( 32,issue_info.get(24).get("Campos"))
		mapCampLabel.put( 33,issue_info.get(25).get("Campos"))
		mapCampLabel.put( 35,issue_info.get(26).get("Campos"))
		mapCampLabel.put( 36,issue_info.get(27).get("Campos"))
		mapCampLabel.put( 37,issue_info.get(28).get("Campos"))
		mapCampLabel.put( 38,issue_info.get(29).get("Campos"))
		mapCampLabel.put( 39,issue_info.get(30).get("Campos"))
		mapCampLabel.put( 40,issue_info.get(31).get("Campos"))
		mapCampLabel.put( 41,issue_info.get(32).get("Campos"))

		HashMap<Integer, String> mapCampH4= new HashMap<Integer,String>()
		mapCampH4.put( 0,issue_info.get(4).get("Campos"))
		mapCampH4.put( 1,issue_info.get(11).get("Campos"))
		mapCampH4.put( 2,issue_info.get(23).get("Campos"))

		HashMap<Integer, String> mapButton= new HashMap<Integer,String>()
		mapButton.put(  7,issue_info.get(18).get("Botão"))
		mapButton.put(  8,issue_info.get(19).get("Botão"))
		mapButton.put( 13,issue_info.get(21).get("Botão"))
		mapButton.put( 14,issue_info.get(22).get("Botão"))
		mapButton.put( 25,issue_info.get(31).get("Botão"))
		mapButton.put( 26,issue_info.get(32).get("Botão"))

		HashMap<Integer, String> mapCampDiv= new HashMap<Integer,String>()
		mapCampDiv.put( 22,issue_info.get(0).get("Campos"))
		mapCampDiv.put( 37,issue_info.get(2).get("Campos"))

		WebUI.delay(8)
		selecionaListaDeElementos("//div[@class='container-lateral-panel lateral-panel-align-center']", "div")
		int qtdResumo
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{
				print("*")
				String[] valor = listOfElements[j].getText().trim().split("")
				String resumo = auxiliares.CurrencyMonetary.removeValorMonetario(valor)
				if(resumo.contains(casodeteste.getFormaDePagamento().trim())){qtdResumo++}
				if(resumo.contains(casodeteste.getPacote())){qtdResumo++}
				if(resumo.contains(casodeteste.getValorSeguro())){qtdResumo++}

			}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "label")
		int qtdmapCampLabel  // 25
		for(int j = 0; j < listOfElements.size(); j++){ //System.err.println("LABEL ["+j+"] ["+listOfElements[j].getText()+" ]")
			if( !listOfElements[j].getText().equals("")){
				print("*")
				if( listOfElements[j].getText().contains(mapCampLabel.get(j).toString())) { qtdmapCampLabel++ }}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "h4")
		int qtdmapCampH4 // 3
		for(int j = 0; j < listOfElements.size(); j++){ //System.err.println("H4 ["+j+"] ["+listOfElements[j].getText()+" ]")
			if( !listOfElements[j].getText().equals("")){
				print("*")
				if( listOfElements[j].getText().contains(mapCampH4.get(j).toString())){ qtdmapCampH4++}}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "button")
		int qtdmapButton // 6
		for(int j = 0; j < listOfElements.size(); j++){ //System.err.println("BUTTON ["+j+"] ["+listOfElements[j].getText()+" ]")
			if( listOfElements[j].getText().contains(mapButton.get(j).toString()))
			{
				print("*")
				qtdmapButton++}

		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "div")
		int qtdmapCampDiv // 2
		for(int j = 0; j < listOfElements.size(); j++){ //System.err.println("div ["+j+"] ["+listOfElements[j].getText()+" ]")
			if( !listOfElements[j].getText().equals("")){
				print("*")
				if( listOfElements[j].getText().contains(mapCampDiv.get(j).toString())){ qtdmapCampDiv++}}
		}

		int totalValidation = qtdmapCampLabel + qtdmapCampH4 + qtdmapButton + qtdmapCampDiv+qtdResumo


		System.out.println("Pagamento em Débito ["+totalValidation+"] ["+qtdmapCampLabel+"] ["+qtdmapCampH4+"] ["+qtdmapButton+"] ["+qtdmapCampDiv+"] ["+qtdResumo+"]")

		if(totalValidation == 39){
			highlightElementLayoutPagamentoDebitoContaBancaria()
			salvarEvidencia(issue_info.get(0).get("CT")+"_A"," Exibido o layout da tela 'Pagamento em Débito' exibidos corretamente.","PASSED")
			posicaoDaTela("//label[@id='justEmail_label']")
			salvarEvidencia(issue_info.get(0).get("CT")+"_B"," Exibido o layout da tela 'Pagamento em Débito' exibidos corretamente.","PASSED")
			unHighlightElementLayoutPagamentoDebitoContaBancaria()
		}
		else{
			adicionaImagem(issue_info.get(0).get("CT")," Exibido o layout da tela 'Pagamento' não exibidos corretamente","FAIL", 1)
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementLayoutPagamentoDebitoContaBancaria(){
		highlightElement("//div[text()='Resumo dos dados']")
		highlightElement("//div[text()='Número da operação']")
		highlightElement("//label[@id='validity']")
		highlightElement("//h4[text()='Dados do segurado']")
		highlightElement("//label[text()='E-mail do segurado *']")
		highlightElement("//label[text()='Telefone *']")
		highlightElement("//label[text()='Profissão *']")
		highlightElement("//label[text()='Renda mensal *']")
		highlightElement("//label[text()='Receber documentos relacionados à apólice apenas por email?']")
		highlightElement("//h4[text()='Informações da conta']")
		highlightElement("//label[text()='Tipo de Conta']")
		highlightElement("//label[text()='Banco']")
		highlightElement("//label[text()='Agência']")
		highlightElement("//label[text()='DCO']")
		highlightElement("//label[text()='N.de Conta']")
		highlightElement("//label[text()='DCC']")
		highlightElement("//label[text()='Beneficiário credor é outro?']")
		highlightElement("//label[text()='Data Vencimento da Parcela:']")
		highlightElement("//label[text()='Você é o titular da conta?']")
		highlightElement("//label[text()='CEP de correspondência *']")
		highlightElement("//label[text()='Endereço *']")
		highlightElement("//label[text()='Número *']")
		highlightElement("//label[text()='Complemento']")
		highlightElement("//label[text()='Bairro *']")
		highlightElement("//label[text()='Cidade']")
		highlightElement("//label[text()='Estado']")
		highlightElement("//h4[text()='Endereço do segurado']")
		highlightElement("//div[@id='BTBenefCredNao_container']")
		highlightElement("//div[@id='BTTitContSim_container']")
		highlightElement("//div[@id='divContentFooterButtonBar']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayoutPagamentoDebitoContaBancaria(){
		unHighlightElement("//div[text()='Resumo dos dados']")
		unHighlightElement("//div[text()='Número da operação']")
		unHighlightElement("//label[@id='validity']")
		unHighlightElement("//h4[text()='Dados do segurado']")
		unHighlightElement("//label[text()='E-mail do segurado *']")
		unHighlightElement("//label[text()='Telefone *']")
		unHighlightElement("//label[text()='Profissão *']")
		unHighlightElement("//label[text()='Renda mensal *']")
		unHighlightElement("//label[text()='Receber documentos relacionados à apólice apenas por email?']")
		unHighlightElement("//h4[text()='Informações da conta']")
		unHighlightElement("//label[text()='Tipo de Conta']")
		unHighlightElement("//label[text()='Banco']")
		unHighlightElement("//label[text()='Agência']")
		unHighlightElement("//label[text()='DCO']")
		unHighlightElement("//label[text()='N.de Conta']")
		unHighlightElement("//label[text()='DCC']")
		unHighlightElement("//label[text()='Beneficiário credor é outro?']")
		unHighlightElement("//label[text()='Data Vencimento da Parcela:']")
		unHighlightElement("//label[text()='Você é o titular da conta?']")
		unHighlightElement("//label[text()='CEP de correspondência *']")
		unHighlightElement("//label[text()='Endereço *']")
		unHighlightElement("//label[text()='Número *']")
		unHighlightElement("//label[text()='Complemento']")
		unHighlightElement("//label[text()='Bairro *']")
		unHighlightElement("//label[text()='Cidade']")
		unHighlightElement("//label[text()='Estado']")
		unHighlightElement("//h4[text()='Endereço do segurado']")
		unHighlightElement("//div[@id='BTBenefCredNao_container']")
		unHighlightElement("//div[@id='BTTitContSim_container']")
		unHighlightElement("//div[@id='divContentFooterButtonBar']")
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Na tela '2. Preço' e alterar a forma de pagamento para Boleto Bancário
	 */
	public static alteraFormaDePagamentoDaTelaPreço(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		clicarEmElementoDaTela("//a[text()='"+issue_info.get(0).get("Tela")+"']", 5)
		clicarEmElementoDaTela("//div[contains(@class,'combo-div')]//button[contains(@data-id,'comboPaymentMode')]", 1)
		clicarEmElementoDaTela("//span[contains(text(),'"+issue_info.get(0).get("Pagamento")+"')]", 5)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static clicaNoBotaoComprar(){
		try{
			casodeteste.setFormaDePagamento(retornaValorDaTela("//button[@data-id='comboPaymentMode']", 1, 1, 1))
			selecionaListaDeElementos("//div[@id='package_0']", "div")
			String val
			for(int j = 0; j < listOfElements.size(); j++){
				if(j==2){ casodeteste.setPacote(listOfElements[j].getText())}
				if(j==3){
					String[] valor = auxiliares.CurrencyMonetary.removeEspacos(listOfElements[j].getText()).split("")
					val = auxiliares.CurrencyMonetary.removeValorMonetario(valor)
				}
			}
			casodeteste.setValorSeguro(val)
			clicarEmElementoDaTela("//button[@id='button_0']", 1)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Exception - Falha ao clicar no botão comprar ", "FAIL")
			WebUI.delay(2)
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 * Verifico o layout da tela 'Pagamento'
	 */
	public static verificaLayoutTelaPagamentoBoleto(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Valido layout da tela 'Pagamento'
	 */
	public static validaLayoutDaTelaPagamentoBoleto(){
		posicaoDaTela("//a[text()='3. Pagamento']")
		HashMap<Integer, String> mapCampLabel= new HashMap<Integer,String>()
		mapCampLabel.put( 0,issue_info.get(3).get("Campos"))
		mapCampLabel.put( 6,issue_info.get(8).get("Campos"))
		mapCampLabel.put( 7,issue_info.get(9).get("Campos"))
		mapCampLabel.put( 8,issue_info.get(10).get("Campos"))
		mapCampLabel.put( 9,issue_info.get(11).get("Campos"))
		mapCampLabel.put( 10,issue_info.get(12).get("Campos"))
		mapCampLabel.put( 11,issue_info.get(13).get("Campos"))
		mapCampLabel.put( 12,issue_info.get(14).get("Campos"))
		mapCampLabel.put( 13,issue_info.get(16).get("Campos"))
		mapCampLabel.put( 16,issue_info.get(18).get("Campos"))
		mapCampLabel.put( 17,issue_info.get(21).get("Campos"))
		mapCampLabel.put( 18,issue_info.get(22).get("Campos"))
		mapCampLabel.put( 20,issue_info.get(23).get("Campos"))
		mapCampLabel.put( 21,issue_info.get(24).get("Campos"))
		mapCampLabel.put( 22,issue_info.get(25).get("Campos"))
		mapCampLabel.put( 23,issue_info.get(26).get("Campos"))
		mapCampLabel.put( 24,issue_info.get(27).get("Campos"))
		mapCampLabel.put( 25,issue_info.get(28).get("Campos"))
		mapCampLabel.put( 26,issue_info.get(29).get("Campos"))


		HashMap<Integer, String> mapCampH4= new HashMap<Integer,String>()
		mapCampH4.put( 1,issue_info.get(4).get("Campos"))
		mapCampH4.put( 0,issue_info.get(7).get("Campos"))
		mapCampH4.put( 1,issue_info.get(15).get("Campos"))
		mapCampH4.put( 2,issue_info.get(20).get("Campos"))

		HashMap<Integer, String> mapButton= new HashMap<Integer,String>()
		mapButton.put(2,issue_info.get(16).get("Botão"))
		mapButton.put(3,issue_info.get(17).get("Botão"))
		mapButton.put(15,issue_info.get(30).get("Botão"))
		mapButton.put(16,issue_info.get(31).get("Botão"))


		HashMap<Integer, String> mapCampDiv= new HashMap<Integer,String>()
		mapCampDiv.put( 22,issue_info.get(0).get("Campos"))
		mapCampDiv.put( 37,issue_info.get(3).get("Campos"))


		WebUI.delay(8)
		selecionaListaDeElementos("//div[@class='container-lateral-panel lateral-panel-align-center']", "div")
		int qtdResumo // 3
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{
				String[] valor = listOfElements[j].getText().trim().split("")
				String resumo = auxiliares.CurrencyMonetary.removeValorMonetario(valor)
				if(resumo.contains(casodeteste.getFormaDePagamento().trim())){qtdResumo++}
				if(resumo.contains(casodeteste.getPacote())){qtdResumo++}
				if(resumo.contains(casodeteste.getValorSeguro())){qtdResumo++}
				print("*")
			}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "label")
		int qtdmapCampLabel  // 18
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")){
				print("*")
				if( listOfElements[j].getText().contains(mapCampLabel.get(j).toString())) {
					qtdmapCampLabel++ }
			}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "h4")
		int qtdmapCampH4 // 3
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")){
				print("*")
				if( listOfElements[j].getText().contains(mapCampH4.get(j).toString())){ qtdmapCampH4++}
			}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "button")
		int qtdmapButton // 4
		for(int j = 0; j < listOfElements.size(); j++){
			if( listOfElements[j].getText().contains(mapButton.get(j).toString()))	{ qtdmapButton++}
		}

		selecionaListaDeElementos("//div[@class='col-xs-12 col-sm-12 col-md-12 alz-wm-fasttrack-content']", "div")
		int qtdmapCampDiv // 3
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals("")){
				//print("*")
				if( listOfElements[j].getText().contains(mapCampDiv.get(j).toString())){qtdmapCampDiv++}}
		}

		int totalValidation = qtdmapCampLabel + qtdmapCampH4 + qtdmapButton + qtdmapCampDiv + qtdResumo

		System.err.println("totalValidation Tela Pagamento Boleto ["+totalValidation +" ]  [ "+ qtdmapCampLabel +" "+ qtdmapCampH4 +" "+ qtdmapButton +" "+ qtdmapCampDiv +" "+ qtdResumo+" ]")

		if(totalValidation == 30){
			highlightElementLayoutPagamentoBoleto()
			salvarEvidencia(issue_info.get(0).get("CT")+"_A"," Exibido o layout da tela 'Pagamento com Boleto' exibidos corretamente.","PASSED")
			posicaoDaTela("//label[@id='justEmail_label']")
			salvarEvidencia(issue_info.get(0).get("CT")+"_B"," Exibido o layout da tela 'Pagamento com Boleto' exibidos corretamente.","PASSED")
			unHighlightElementLayoutPagamentoBoleto()
		}
		else{
			salvarEvidencia(issue_info.get(0).get("CT")," Exibido o layout da tela 'Pagamento com Boleto' não exibidos corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementLayoutPagamentoBoleto(){
		highlightElement("//div[text()='Resumo dos dados']")
		highlightElement("//div[text()='Número da operação']")
		highlightElement("//label[@id='validity']")
		highlightElement("//h4[text()='Dados do segurado']")
		highlightElement("//label[text()='E-mail do segurado *']")
		highlightElement("//label[text()='Telefone *']")
		highlightElement("//label[text()='Profissão *']")
		highlightElement("//label[text()='Renda mensal *']")
		highlightElement("//label[text()='Receber documentos relacionados à apólice apenas por email?']")
		highlightElement("//h4[text()='Forma de pagamento']")
		highlightElement("//label[text()='Adicionar cláusula beneficiaria?']")
		highlightElement("//div[@id='BTBenefCredNao_container']")
		highlightElement("//label[text()='Dia de vencimento']")
		highlightElement("//button[@id='BTBenefCredNao']")
		highlightElement("//h4[text()='Endereço do segurado']")
		highlightElement("//label[text()='CEP de correspondência *']")
		highlightElement("//label[text()='Endereço *']")
		highlightElement("//label[text()='Número *']")
		highlightElement("//label[text()='Complemento']")
		highlightElement("//label[text()='Bairro *']")
		highlightElement("//label[text()='Cidade']")
		highlightElement("//label[text()='Estado']")
		highlightElement("//h4[text()='Endereço do segurado']")
		highlightElement("//div[@id='BTBenefCredNao_container']")
		highlightElement("//div[@id='BTTitContSim_container']")
		highlightElement("//div[@id='divContentFooterButtonBar']")
		highlightElement("//h4[text()='Forma de pagamento']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayoutPagamentoBoleto(){
		unHighlightElement("//div[text()='Resumo dos dados']")
		unHighlightElement("//div[text()='Número da operação']")
		unHighlightElement("//label[@id='validity']")
		unHighlightElement("//h4[text()='Dados do segurado']")
		unHighlightElement("//label[text()='E-mail do segurado *']")
		unHighlightElement("//label[text()='Telefone *']")
		unHighlightElement("//label[text()='Profissão *']")
		unHighlightElement("//label[text()='Renda mensal *']")
		unHighlightElement("//label[text()='Receber documentos relacionados à apólice apenas por email?']")
		unHighlightElement("//h4[text()='Forma de pagamento']")
		unHighlightElement("//label[text()='Adicionar cláusula beneficiaria?']")
		unHighlightElement("//div[@id='BTBenefCredNao_container']")
		unHighlightElement("//label[text()='Dia de vencimento']")
		unHighlightElement("//button[@id='BTBenefCredNao']")
		unHighlightElement("//h4[text()='Endereço do segurado']")
		unHighlightElement("//label[text()='CEP de correspondência *']")
		unHighlightElement("//label[text()='Endereço *']")
		unHighlightElement("//label[text()='Número *']")
		unHighlightElement("//label[text()='Complemento']")
		unHighlightElement("//label[text()='Bairro *']")
		unHighlightElement("//label[text()='Cidade']")
		unHighlightElement("//label[text()='Estado']")
		unHighlightElement("//h4[text()='Endereço do segurado']")
		unHighlightElement("//div[@id='BTBenefCredNao_container']")
		unHighlightElement("//div[@id='BTTitContSim_container']")
		unHighlightElement("//div[@id='divContentFooterButtonBar']")
		unHighlightElement("//h4[text()='Forma de pagamento']")
	}



	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static informarTodosOsCamposObrigatóriosPagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		leituraMassa(issue_info.get(0).get("CT"))

		try{
			// WebUI.delay(2)
			// posicaoDaTela("//h4[text()='Dados do segurado']")
			//email
			escreverCamposInput("//input[@id='txtMaskEmail']", "samuel@email.com.br")

			//celular
			escreverCamposInput("//input[@id='phoneTypeBR']", "1131716000")

			//prof
			//			escreverCamposInput("//input[@id='comboProfAuto']", "Analista")
			//			WebUI.delay(10)
			//			clicarEmElementoDaTela("//div[@class='genericCol errorClass col-md-6 col-sm-6 col-xs-12 ws-success']//span[@class='ui-helper-hidden-accessible']", 1)

			// posicaoDaTela("//h4[text()='Forma de pagamento']")
			WebUI.delay(2)
			//renda mensal click abrir combo
			clicarEmElementoDaTela("//button[@data-id='comboRenda']", 2)

			//WebUI.delay(2)
			//selecionar item 0 do combo
			clicarEmElementoDaTela("//button[@data-id='comboRenda']//..//li[@data-original-index='3']", 2) // De R$ 3.301,00 Até R$5.000,00

			//WebUI.delay(2)
			//clicar na data venc
			clicarEmElementoDaTela("//button[@data-id='diaDeVencBol']", 2)

			//seleciona opção 1
			clicarEmElementoDaTela("//button[@data-id='diaDeVencBol']//span[text()='1']", 2)

			//cep
			escreverCamposInput("//input[@id='CEP']", "05425000")

			//num
			escreverCamposInput("//input[@id='f_numero']", "303")

			//complemento clicar para aparecer a msg de num
			clicarEmElementoDaTela("//input[@id='f_complemento']", 2)

			posicaoDaTela("//h4[text()='Dados do segurado']")

		} catch (Exception e) {}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static botãoAvançarPagamento(){
		clicarEmElementoDaTela("//button[@id='NextButton']", 20)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static telaConfirmaçãoDePagamento(){ // EFETUAR DOIS PRINTS DA TELA DE EVIDENCIA
		try{
			if(validaElemento("//h2[text()='Confirmação de Pagamento']").booleanValue()){
				highlightElement("//h2[text()='Confirmação de Pagamento']")
				salvarEvidencia(issue_info.get(0).get("CT")," É exibida a tela 'Confirmação de Pagamento'","PASSED")
				unHighlightElement("//h2[text()='Confirmação de Pagamento']")
			} else {
				salvarEvidencia(issue_info.get(0).get("CT")," Não é exibida a tela 'Confirmação de Pagamento'","FAIL")
				finalizar()
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Não é exibida a tela 'Confirmação de Pagamento'","FAIL")
			finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static estouNaTelaConfirmaçãoDePagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		posicaoDaTela("//h2[text()='Confirmação de Pagamento']")
		HashMap<Integer, String> mapCampH2= new HashMap<Integer,String>()
		mapCampH2.put( 0,issue_info.get(10).get("Campos"))

		HashMap<Integer, String> mapCampB= new HashMap<Integer,String>()
		mapCampB.put( 0,issue_info.get(11).get("Campos"))
		mapCampB.put( 1,issue_info.get(12).get("Campos"))
		mapCampB.put( 2,issue_info.get(13).get("Campos"))

		HashMap<Integer, String> mapCampSpan= new HashMap<Integer,String>()
		mapCampSpan.put( 9,issue_info.get(0).get("Campos"))
		mapCampSpan.put( 21,issue_info.get(1).get("Campos"))
		mapCampSpan.put( 26,issue_info.get(2).get("Campos"))
		mapCampSpan.put( 32,issue_info.get(3).get("Campos"))
		mapCampSpan.put( 43,issue_info.get(4).get("Campos"))
		mapCampSpan.put( 47,issue_info.get(5).get("Campos"))
		mapCampSpan.put( 72,issue_info.get(6).get("Campos"))
		mapCampSpan.put( 75,issue_info.get(7).get("Campos"))
		mapCampSpan.put( 78,issue_info.get(8).get("Campos"))
		mapCampSpan.put( 84,issue_info.get(9).get("Campos"))

		String xpath = "//div[contains(@id,'content_null')]"
		int qtdValidacoes

		selecionaListaDeElementos(xpath, "span") // 10
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{  System.err.println("span ["+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().equals(mapCampSpan.get(j).toString()))
				{
					qtdValidacoes++
				}

			}
		}

		selecionaListaDeElementos(xpath, "h2") // 1
		for(int j = 0; j < listOfElements.size(); j++){ //System.err.println("h2 ["+j+"] : ["+listOfElements[j].getText()+"]")
			if( !listOfElements[j].getText().equals(""))
			{
				if(listOfElements[j].getText().equals(mapCampH2.get(j).toString()))
				{
					qtdValidacoes++
				}

			}
		}

		selecionaListaDeElementos(xpath, "b") // 3
		for(int j = 0; j < listOfElements.size(); j++){ // System.err.println("b ["+j+"] : ["+listOfElements[j].getText()+"]")
			if( !listOfElements[j].getText().equals(""))
			{
				if(listOfElements[j].getText().equals(mapCampB.get(j).toString()))
				{
					qtdValidacoes++
				}
			}
		}

		def ButtonBar = pegaValorDaTela("//div[@id='divContentFooterButtonBar']") // 2
		if(  issue_info.get(1).get("botao")+issue_info.get(0).get("botao").contains(ButtonBar.trim())){ qtdValidacoes = qtdValidacoes+2 }
		layoutCamposTelaPagamento = qtdValidacoes
		System.err.println("layoutCamposTelaPagamento ["+layoutCamposTelaPagamento+"] - [16]")
	}




	public static exibirLayoutTelaConfirmaçãoPagamentoCorretamente(){
		try{
			if( layoutCamposTelaPagamento == 16 ){
				highlightElementLayoutTelaConfirmaçãoPagamento()
				salvarEvidencia(issue_info.get(0).get("CT")," É exibido o layout da tela 'Confirmação de Pagamento' corretamente","PASSED")
				unHighlightElementLayoutTelaConfirmaçãoPagamento()
			} else {
				salvarEvidencia(issue_info.get(0).get("CT")," Não é exibido o layout da tela 'Confirmação de Pagamento' corretamente","FAIL")
				finalizar()
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT")," Não é exibido o layout da tela 'Confirmação de Pagamento' corretamente","FAIL")
			finalizar()
		}
	}



	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementLayoutTelaConfirmaçãoPagamento(){
		highlightElement("//h2[text()='Confirmação de Pagamento']'")
		highlightElement("//b[text()='Data de início do Seguro: ']")
		highlightElement("//b[text()='Número da operação: ']")
		highlightElement("//span[text()='Veículo']")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Uso veículo')]")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Perfil do condutor')]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Forma de pagamento')]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Valor do Seguro')]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]")
		highlightElement("//span[text()='Cláusulas']")
		highlightElement("//span[text()='Para o Corretor']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementLayoutTelaConfirmaçãoPagamento(){
		unHighlightElement("//h2[text()='Confirmação de Pagamento']'")
		unHighlightElement("//b[text()='Data de início do Seguro: ']")
		unHighlightElement("//b[text()='Número da operação: ']")
		unHighlightElement("//span[text()='Veículo']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Uso veículo')]")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Perfil do condutor')]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Forma de pagamento')]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Valor do Seguro')]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]")
		unHighlightElement("//span[text()='Cláusulas']")
		unHighlightElement("//span[text()='Para o Corretor']")
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static verificaLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento(DataTable data){

		issue_info =  data.asMaps(String.class, String.class);

		HashMap<Integer, String> mapSpanCaracterísticasVeículoCondutor= new HashMap<Integer,String>()
		mapSpanCaracterísticasVeículoCondutor.put( 11,issue_info.get(0).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 12,issue_info.get(1).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 13,issue_info.get(2).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 14,issue_info.get(3).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 15,issue_info.get(4).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 16,issue_info.get(5).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 17,issue_info.get(6).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 18,issue_info.get(7).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 19,issue_info.get(8).get("Veiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 20,issue_info.get(9).get("Veiculo"))

		mapSpanCaracterísticasVeículoCondutor.put( 23,issue_info.get(0).get("UsoVeiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 24,issue_info.get(1).get("UsoVeiculo"))
		mapSpanCaracterísticasVeículoCondutor.put( 25,issue_info.get(2).get("UsoVeiculo"))

		mapSpanCaracterísticasVeículoCondutor.put( 28,issue_info.get(0).get("DadosDoCondutor"))
		mapSpanCaracterísticasVeículoCondutor.put( 29,issue_info.get(1).get("DadosDoCondutor"))
		mapSpanCaracterísticasVeículoCondutor.put( 30,issue_info.get(2).get("DadosDoCondutor"))
		mapSpanCaracterísticasVeículoCondutor.put( 31,issue_info.get(3).get("DadosDoCondutor"))

		mapSpanCaracterísticasVeículoCondutor.put( 34,issue_info.get(0).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 35,issue_info.get(1).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 36,issue_info.get(2).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 37,issue_info.get(3).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 38,issue_info.get(4).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 39,issue_info.get(5).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 40,issue_info.get(6).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 41,issue_info.get(7).get("DadosDoSegurado"))
		mapSpanCaracterísticasVeículoCondutor.put( 42,issue_info.get(8).get("DadosDoSegurado"))

		mapSpanCaracterísticasVeículoCondutor.put( 45,issue_info.get(0).get("PerfilDoCondutor"))
		mapSpanCaracterísticasVeículoCondutor.put( 46,issue_info.get(1).get("PerfilDoCondutor"))

		int qtdValidacoes
		String xpath = "//div[contains(@id,'content_null')]"
		selecionaListaDeElementos(xpath, "span") // 10
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{   print"*"
				//System.err.println("span ["+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().equals(mapSpanCaracterísticasVeículoCondutor.get(j).toString()))
				{
					qtdValidacoes++
				}

			}
		}

		qtdMapSpanSessãoVeículo = qtdValidacoes
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento(){ System.err.println("qtdMapSpanSessãoVeículo ["+qtdMapSpanSessãoVeículo+"]")
		if(qtdMapSpanSessãoVeículo==28){
			highlightElementCaracterísticasVeiculoCondutor()
			salvarEvidencia(issue_info.get(0).get("CT")," É exibido o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' corretamente","PASSED")
			unHighlightElementCaracterísticasVeiculoCondutor()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi exibido o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' corretamente","FAIL")
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCaracterísticasVeiculoCondutor(){
		//Veiculo
		highlightElement("//span[text()='Placa: ']")
		highlightElement("//span[text()='Chassis: ']")
		highlightElement("//span[text()='Ano: ']")
		highlightElement("//span[text()='Marca: ']")
		highlightElement("//span[text()='Modelo: ']")
		highlightElement("//span[text()='Versão: ']")
		highlightElement("//span[text()='Código Fipe: ']")
		highlightElement("//span[text()='Valor Fipe: ']")
		highlightElement("//span[text()='Blindagem: ']")
		highlightElement("//span[text()='Zero Km: ']")

		//USO DO VEICULO
		highlightElement("//span[text()='Endereço de Pernoite: ']")
		highlightElement("//span[text()='Utilização Comercial: ']")
		highlightElement("//span[text()='Cep Pernoite: ']")

		//Perfil do condutor
		highlightElement("//span[text()='Reside com pessoas de 17 e 25 anos?: ']")
		highlightElement("//span[text()='O principal condutor reside em: ']")

		//Dados do segurado
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='CPF: ']")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='Nome: ']")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='Email: ']")
		highlightElement("//span[text()='Profissão: ']")
		highlightElement("//span[text()='Renda Mensal: ']")
		highlightElement("//span[text()='Estado Civil: ']")
		highlightElement("//span[text()='Telefone: ']")
		highlightElement("//span[text()='CEP: ']")
		highlightElement("//span[text()='Endereço de residência: ']")

		//Dados do condutor
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='CPF: ']")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='Nome: ']")
		highlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='Email: ']")
		highlightElement("//span[text()='Estado Civil: ']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCaracterísticasVeiculoCondutor(){
		//Veiculo
		unHighlightElement("//span[text()='Placa: ']")
		unHighlightElement("//span[text()='Chassis: ']")
		unHighlightElement("//span[text()='Ano: ']")
		unHighlightElement("//span[text()='Marca: ']")
		unHighlightElement("//span[text()='Modelo: ']")
		unHighlightElement("//span[text()='Versão: ']")
		unHighlightElement("//span[text()='Código Fipe: ']")
		unHighlightElement("//span[text()='Valor Fipe: ']")
		unHighlightElement("//span[text()='Blindagem: ']")
		unHighlightElement("//span[text()='Zero Km: ']")

		//USO DO VEICULO
		unHighlightElement("//span[text()='Endereço de Pernoite: ']")
		unHighlightElement("//span[text()='Utilização Comercial: ']")
		unHighlightElement("//span[text()='Cep Pernoite: ']")

		//Perfil do condutor
		unHighlightElement("//span[text()='Reside com pessoas de 17 e 25 anos?: ']")
		unHighlightElement("//span[text()='O principal condutor reside em: ']")

		//Dados do segurado
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='CPF: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='Nome: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='Email: ']")
		unHighlightElement("//span[text()='Profissão: ']")
		unHighlightElement("//span[text()='Renda Mensal: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do segurado')]//.. //span[text()='Estado Civil: ']")
		unHighlightElement("//span[text()='Telefone: ']")
		unHighlightElement("//span[text()='CEP: ']")
		unHighlightElement("//span[text()='Endereço de residência: ']")

		//Dados do condutor
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='CPF: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='Nome: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='Email: ']")
		unHighlightElement("//div[@class='confirm-payment-particular-container confirm-payment-width-package']//span[@class='confirm-payment-title-particular-container' and contains(text(),'Dados do condutor')]//.. //span[text()='Estado Civil: ']")

	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		String xpath = "//div[contains(@id,'content_null')]"
		int qtdValidacoes

		HashMap<Integer, String> mapSpanCaracterísticasDoSeguro= new HashMap<Integer,String>()
		mapSpanCaracterísticasDoSeguro.put( 49,issue_info.get(0).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 50,issue_info.get(1).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 52,issue_info.get(2).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 54,issue_info.get(3).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 56,issue_info.get(4).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 58,issue_info.get(5).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 60,issue_info.get(6).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 62,issue_info.get(7).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 64,issue_info.get(8).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 66,issue_info.get(9).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 68,issue_info.get(10).get("CaracterísticasDoSeguroEscolhido"))
		mapSpanCaracterísticasDoSeguro.put( 70,issue_info.get(11).get("CaracterísticasDoSeguroEscolhido"))
		//	span [49] : [Pacote:]
		//	span [50] : [Casco]
		//	span [52] : [RCF Danos Materiais]
		//	span [54] : [RCF Danos Corporais]
		//	span [56] : [RCF Danos Morais]
		//	span [58] : [APP Morte]
		//	span [60] : [APP Invalidez]
		//	span [62] : [Franquia]
		//	span [64] : [Assistência 24h]
		//	span [66] : [Guincho]
		//	span [68] : [Carro Reserva]
		//	span [70] : [Vidros]

		mapSpanCaracterísticasDoSeguro.put( 77,issue_info.get(0).get("ValorDoSeguro"))
		//span [77] : [Total:]

		mapSpanCaracterísticasDoSeguro.put( 80,issue_info.get(0).get("Clausulas"))
		mapSpanCaracterísticasDoSeguro.put( 81,issue_info.get(1).get("Clausulas"))
		mapSpanCaracterísticasDoSeguro.put( 82,issue_info.get(2).get("Clausulas"))
		mapSpanCaracterísticasDoSeguro.put( 83,issue_info.get(3).get("Clausulas"))
		//clausulas
		//	span [80] : [252   -   Valor de Mercado Referenciado - Valor Econômico]
		//	span [81] : [253   -   Molicar - 2a. tabela de Referência - Revista Carro]
		//	span [82] : [1030   -   Assistência VIP 24 HS - km livre - 30 Dias Carro Reserva]
		//	span [83] : [2105   -   Vidro VIP - passeio nacional]

		mapSpanCaracterísticasDoSeguro.put( 74,issue_info.get(0).get("FormaDePagamento"))
		mapSpanCaracterísticasDoSeguro.put( 74,issue_info.get(1).get("FormaDePagamento"))
		//span [74] : [Boleto Dia de vencimento:]


		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{   //System.err.println("span ["+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().contains(mapSpanCaracterísticasDoSeguro.get(j).toString()))
				{
					qtdValidacoes++
				}

			}
		}

		mapSpanCaracterísticasDoSeguro.put( 49,issue_info.get(0).get("ParaCorretor"))
		mapSpanCaracterísticasDoSeguro.put( 52,issue_info.get(1).get("ParaCorretor"))
		mapSpanCaracterísticasDoSeguro.put( 55,issue_info.get(2).get("ParaCorretor"))
		mapSpanCaracterísticasDoSeguro.put( 58,issue_info.get(3).get("ParaCorretor"))
		mapSpanCaracterísticasDoSeguro.put( 61,issue_info.get(4).get("ParaCorretor"))
		//div [49] : [Antecipação da comissão:]
		//div [52] : [Desconto venda cruzada:]
		//div [55] : [Fipe:]
		//div [58] : [Cap:]
		//div [61] : [Comissão:]

		selecionaListaDeElementos(xpath, "div")
		for(int j = 0; j < listOfElements.size(); j++){
			if( !listOfElements[j].getText().equals(""))
			{   //System.err.println("div ["+j+"] : ["+listOfElements[j].getText()+"]")
				if(listOfElements[j].getText().equals(mapSpanCaracterísticasDoSeguro.get(j).toString()))
				{
					qtdValidacoes++
				}
			}
		}
		qtdMapSpanSessãoVeículo = qtdValidacoes // 23
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static exibirLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(){
		if(qtdMapSpanSessãoVeículo==23){
			highlightElementCaracteristicaDoSeguro()
			salvarEvidencia(issue_info.get(0).get("CT")," É exibido o layout das características do 'seguro' da tela 'Confirmação de Pagamento' corretamente","PASSED")
			unHighlightElementCaracteristicaDoSeguro()
		} else {
			salvarEvidencia(issue_info.get(0).get("CT")," Não foi exibido o layout das características do 'seguro' da tela 'Confirmação de Pagamento' corretamente","FAIL")
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementCaracteristicaDoSeguro(){
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Pacote:']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Casco']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Materiais']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Corporais']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Morais']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='APP Morte']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='APP Invalidez']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Franquia']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Assistência 24h']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Guincho']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Carro Reserva']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Vidros']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Forma de pagamento')]//.. //span[text()='Boleto']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Valor do Seguro')]//..//span[text()='Total: ']")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[1]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[2]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[3]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[4]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[1]//div[1]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[2]//div[1]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[3]//div[1]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[4]//div[1]")
		highlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[5]//div[1]")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementCaracteristicaDoSeguro(){
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Pacote:']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Casco']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Materiais']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Corporais']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='RCF Danos Morais']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='APP Morte']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='APP Invalidez']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Franquia']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Assistência 24h']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Guincho']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Carro Reserva']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Características do seguro escolhido')]//.. //span[text()='Vidros']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Forma de pagamento')]//.. //span[text()='Boleto']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Valor do Seguro')]//..//span[text()='Total: ']")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[1]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[2]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[3]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Cláusulas')]//..//p[4]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[1]//div[1]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[2]//div[1]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[3]//div[1]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[4]//div[1]")
		unHighlightElement("//div[@class='confirm-payment-package-inner-container']//span[@class='confirm-payment-title-package-container' and contains(text(),'Para o Corretor')]//..//div[5]//div[1]")
	}


	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static validatelaTelaConfirmaçãoDePagamento(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		posicaoDaTela("//a[text()='3. Pagamento']")
		try{
			if(validaElemento("//h2[text()='"+issue_info.get(0).get("tela")+"']")){
				highlightElementConfirmaçãoDePagamento()
				adicionaImagem(issue_info.get(0).get("CT"),"É exibido tela 'Confirmação de Pagamento'","PASSED", 1)
				unHighlightElementConfirmaçãoDePagamento()
			} else {

			}
		} catch (Exception e){finalizar()}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementConfirmaçãoDePagamento(){
		highlightElement("//div[@class='title-border-bottom col-md-12 col-sm-12 col-xs-12']")
	}

	/**
	 * @author T_DCDias	
	 * @return
	 */
	public static unHighlightElementConfirmaçãoDePagamento(){
		unHighlightElement("//div[@class='title-border-bottom col-md-12 col-sm-12 col-xs-12']")
	}









}
