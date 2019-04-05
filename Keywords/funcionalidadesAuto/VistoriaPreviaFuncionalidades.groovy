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

public class VistoriaPreviaFuncionalidades extends AutoComandos{



	/**
	 * @author T_DCDias
	 * @return
	 */
	public static preencherCamposObrigatorios(){
		preencheCamposObrigatoriosFrame()
	}

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
	public static validaMensagemDeCoberturaDeBlindagem(){
		String xpath = "//div[@id='infoMsg']"
		WebUI.delay(2)
		String mensagem = issue_info.get(1).get("mensagem")
		if(pegaValorDaTela("//div[@id='infoMsg']").equals(mensagem)){
			posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
			WebUI.delay(2)
			highlightElement(xpath)
			adicionaImagem(issue_info.get(0).get("CT"),"Blindagem", "PASSED", 1)
			unHighlightElement(xpath)
		} else {
			adicionaImagem(issue_info.get(0).get("CT"),"Blindagem", "FAIL", 1)
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionarOpcaoDeBlindagemSim(){
		String botao = casodeteste.getBlindagem();
		clicarEmElementoDaTela("//div[@id='buttonBlindagem']//button[@id='BBlindagem"+botao+"']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static substituiCampoPlaca(){
		String placa = issue_info.get(0).get("Placa")
		String xpath = "//input[@id='placa']"
		substituiCampoPlaca(placa)
		posicaoDaTela("//h2[text()='Preencha os dados do Segurado e Condutor']")
		WebUI.delay(2)
		highlightElement(xpath)
		adicionaImagem(issue_info.get(0).get("CT"),"Campo Placa", "PASSED", 1)
		unHighlightElement(xpath)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionaFormaDePagamento(){
		String placa = issue_info.get(0).get("Placa")
		String xpath ="//button[@data-id='comboPaymentMode']"
		alteraFormaDePagamento()
		WebUI.delay(5)
		highlightElement(xpath)
		adicionaImagem(issue_info.get(0).get("CT"),"Forma de pagamento", "PASSED", 1)
		unHighlightElement(xpath)
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionarDataNFInferiorDiaAtual(){
		try{
			List<Integer> diasList = new ArrayList<Integer>();
			Set<Integer> dias = new HashSet<Integer>();

			int menorDia=0;
			int maiorDia=0;
			int aux=0;
			clicarEmElementoDaTela("//div[@id='nfSaida_div']//i[@class='allianz-icon allianz-icon-calendar']", 2)
			WebUI.delay(2)

			int dataAtual = Integer.parseInt(pegaValorDaTela("//div[@class='datepicker-days']//td[@class='today day']"));
			String Sdiferenca = issue_info.get(0).get("Dias")
			int diferenca = Integer.parseInt(Sdiferenca)
			int diaSeleconado = dataAtual - diferenca;

			String xpath = "//div[@class='datepicker-days']"
			String tag ="td"
			selecionaListaDeElementos(xpath,tag)
			for(int i = 0; i < listOfElements.size(); i++){
				String dia = listOfElements[i].getText()
				dias.add(Integer.parseInt(dia));
			}

			diasList.addAll(dias);

			for (int i = 0; i < diasList.size(); i++){
				if(i==0) {
					aux = diasList.get(i)
					menorDia = aux
				}
				else if(diasList.get(i) < aux) {
					menorDia = diasList.get(i)
				}
				else if(diasList.get(i) > aux) {
					maiorDia = diasList.get(i)
				}
			}

			System.err.println("Menor dia ["+menorDia+"] Maior dia ["+maiorDia+"]")

			clicarEmElementoDaTela("//div[@class='datepicker-days']//td[text()='"+Integer.toString(diaSeleconado)+"']", 2)
			String xpathInput = "//input[@id='nfSaida']"
			posicaoDaTela("//h4[text()='Dados do segurado']")
			WebUI.delay(2)
			highlightElement(xpathInput)
			adicionaImagem(issue_info.get(0).get("CT"),"Data selecionada", "PASSED", 1)
			unHighlightElement(xpathInput)
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível informar a data da NF", "FAIL")
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static selecionaCarroZeroOpcaoSim(){
		WebUI.delay(3)
		String valor = issue_info.get(0).get("botao")
		clicarEmElementoDaTela("//button[@id='BKM0"+valor+"']", 2)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static emitirApolice(){
		clicarEmElementoDaTela("//button[text()='Emitir ']", 1)
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static validaInformacoesTelaPagamento(){
		try{
			WebUI.delay(30)
			HashMap<Integer, String> mapDownloads= new HashMap<Integer,String>()
			mapDownloads.put(0,issue_info.get(0).get("downloads"))
			mapDownloads.put(1,issue_info.get(1).get("downloads"))
			mapDownloads.put(2,issue_info.get(2).get("downloads"))
			mapDownloads.put(3,issue_info.get(3).get("downloads"))
			mapDownloads.put(4,issue_info.get(4).get("downloads"))

			int validacoes
			String xpath = "//ul[@class='list-inline center-block text-center']"
			String tag = "h3"
			selecionaListaDeElementos(xpath,tag)
			for(int i = 0; i < listOfElements.size(); i++){
				if( !listOfElements[i].getText().equals("")) {
					// System.err.println("h3 ["+i+"] : ["+listOfElements[i].getText()+"]")
					if( mapDownloads.get(i).toString().equals(listOfElements[i].getText()))
					{  System.err.println("h3 ["+i+"] : ["+listOfElements[i].getText()+"]")
						validacoes++
					}
				}
			}

			if(validaElemento("//div[@class='col-xs-6 col-sm-3 col-md-3']")){
				validacoes++
			}

			if(validaElemento("//div[@class='col-xs-6 col-sm-3 col-sm-offset-6 col-md-3 col-md-offset-6']")){
				validacoes++
			}

			System.err.println("validacoes ["+validacoes+"]")

			if(validacoes==7){
				highlightElementTelaPagamento()
				salvarEvidencia(issue_info.get(0).get("CT"),"Número da apólice, Número da operação e todos os arquivos para downloads exibidos corretamente", "PASSED")
				unHighlightElementTelaPagamento()
			} else {
				salvarEvidencia(issue_info.get(0).get("CT"),"Número da apólice, Número da operação e todos os arquivos para downloads não foram exibidos corretamente", "FAIL")
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),"Não foi possível validar o Número da operação e todos os arquivos para downloads não foram exibidos corretamente", "FAIL")
			finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static highlightElementTelaPagamento(){
		highlightElement("//div[@class='col-xs-6 col-sm-3 col-md-3']")
		highlightElement("//div[@class='col-xs-6 col-sm-3 col-sm-offset-6 col-md-3 col-md-offset-6']")
		highlightElement("//ul[@class='list-inline center-block text-center']")
		highlightElement("//p[text()='Faça o downloads dos arquivos:']")
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static unHighlightElementTelaPagamento(){
		unHighlightElement("//div[@class='col-xs-6 col-sm-3 col-md-3']")
		unHighlightElement("//div[@class='col-xs-6 col-sm-3 col-sm-offset-6 col-md-3 col-md-offset-6']")
		unHighlightElement("//ul[@class='list-inline center-block text-center']")
		unHighlightElement("//p[text()='Faça o downloads dos arquivos:']")
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static informarNumeroCI(){
		preencherNumeroCI()
		if(validaElemento("//p[text()='CI inválida']")){
			salvarEvidencia(issue_info.get(0).get("CT")," Número CI inválido ", "FAIL" )
			finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static informaNumeroApolice(){
		WebUI.delay(15)
		escreverCamposInput("//input[@id='apoliceAnterior']", casodeteste.getApolice())
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static informarNumeroCIAnterior(){
		escreverCamposInput("//input[@id='ci']", casodeteste.getNumeroci())
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static informarVigênciaAnterior(){
		clicarEmElementoDaTela("//div[@id='fimVigencia_div']//i[@class='allianz-icon allianz-icon-calendar']", 2)
		clicarEmElementoDaTela("//div[@class='datepicker-days']//td[@class='today day']", 2)
	}


	/**
	 * @author T_DCDias
	 * @return
	 * Precisa de CI para conclusão da contrução do método 
	 */
	public static vistoriaPrevia(){

	}


}
