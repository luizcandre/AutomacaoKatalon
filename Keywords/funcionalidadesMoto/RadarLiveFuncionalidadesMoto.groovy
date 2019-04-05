package funcionalidadesMoto

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
import com.kms.katalon.core.testobject.ConditionType
import commands.AutoComandos
import internal.GlobalVariable

import bean.CasoDeTeste
import io.cucumber.datatable.DataTable

public class RadarLiveFuncionalidadesMoto extends AutoComandos{


	private static boolean resultadoDoTeste;
	private static boolean execucao = true

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static boolean confereExecucao(){
		if(resultadoDoTeste==false){
			execucao = resultadoDoTeste
		}
		return execucao
	}

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static lerDataTableMoto(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		def ct = issue_info.get(0).get("CT")
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		addTitlePageMoto()
	}




	/**
	 * @author Luiz Andre
	 * @return
	 */
	public static preencherCamposObrigatoriosDaTelaPrecoMoto(){
		int teste = 1
		boolean existeDados = false
		ListCasoDeTeste.addAll(retornaListaDeCasosDeTesteRadarLive())
		for(int i=0;i<ListCasoDeTeste.size();i++){
			if(ListCasoDeTeste.get(i).getCt().equals(issue_info.get(0).get("CT"))) {
				if(ListCasoDeTeste.get(i).getExecutar().equals("S")){
					existeDados = true
					System.err.println(i+" CT ["+ListCasoDeTeste.get(i).getCt()+" Usuario 1 "+ListCasoDeTeste.get(i).getUsuario()+" Senha 1 "+ListCasoDeTeste.get(i).getSenha()+" Usuario 2 "+ListCasoDeTeste.get(i).getUsuario2()+" Senha 2 "+ListCasoDeTeste.get(i).getSenha2()+" CPF/CNPJ "+ListCasoDeTeste.get(i).getCpfcnpj()+" CEP "+ListCasoDeTeste.get(i).getCep()+"]")
					CasoDeTeste pacote1 = new CasoDeTeste();
					CasoDeTeste pacote2 = new CasoDeTeste();
					try{
						//USUARIO 1
						System.err.println("[ CORRETOR 1 ]")
						commands.Login.homePage(url)
						commands.Login.efetuarLogin(ListCasoDeTeste.get(i).getUsuario(), ListCasoDeTeste.get(i).getSenha())
						commands.Login.acessarHome()
						WebUI.delay(6)
						MotoFuncionalidades.preencheCamposObrigatoriosMotoListFrame(i)
						WebUI.delay(3)
						botaoAvançar()
						pacote1 = obterPacotes()
						WebUI.switchToDefaultContent()
						WebUI.delay(3)
						WebUI.closeBrowser()
					}  catch (Exception e){
						registroDeFalhaDeValidacaoDoCorretor(ListCasoDeTeste.get(i).getUsuario(),i, teste)
						break
					}

					try{
						//USUARIO 2
						System.err.println("[ CORRETOR 2 ]")
						commands.Login.homePage(url)
						WebUI.delay(10)
						commands.Login.efetuarLogin(ListCasoDeTeste.get(i).getUsuario2(), ListCasoDeTeste.get(i).getSenha2())
						commands.Login.acessarHome()
						WebUI.delay(10)
						MotoFuncionalidades.preencheCamposObrigatoriosMotoListFrame(i)
						WebUI.delay(3)
						botaoAvançar()
						pacote2 = obterPacotes()
					}  catch (Exception e){
						registroDeFalhaDeValidacaoDoCorretor(ListCasoDeTeste.get(i).getUsuario2(),i, teste)
						break
					}

					validarPacotes(pacote1, pacote2,i, teste)
					pacote1.setUsuario(ListCasoDeTeste.get(i).getUsuario())
					pacote2.setUsuario2(ListCasoDeTeste.get(i).getUsuario2())
					evidenciaRadarLiveMoto(pacote1, pacote2, teste, issue_info.get(0).get("Cenário"))
					WebUI.delay(3)
					WebUI.closeBrowser()
					teste++
					validaResultadoDaComparacaoDePacotes(i)
				}
			}
		}
		//System.err.println("existeDados ["+existeDados+"]")
		if(existeDados==false){ System.err.println("existeDados ["+existeDados+"]")
			registroDeExecucaoSemMassa()
		}
		finalizar()
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Atualiza planilha de massa
	 */
	public static validaResultadoDaComparacaoDePacotes(int i){
		System.err.println("resultadoDoTeste "+ resultadoDoTeste)
		if(resultadoDoTeste == false){
			salvarEvidenciaRadarLive(i, "Motor de cálculo de pacotes de premios não validado", "FAIL","S")
		}else{
			salvarEvidenciaRadarLive(i, "Motor de cálculo de pacotes de premios validado", "PASSED","N")
		}
	}


	/**
	 *
	 */
	public static highlightPacote(){
		for(int i=0; i<=6; i++){
			highlightElement("//*[@id='package_"+i+"']/div[2]")
		}
	}

	/**
	 *
	 * @return
	 */
	public static unHighlightPacote(){
		for(int i=0; i<=6; i++){
			unHighlightElement("//*[@id='package_"+i+"']/div[2]")
		}
	}

	/**
	 *
	 */
	public static CasoDeTeste obterPacotes(){
		CasoDeTeste pacotes = new CasoDeTeste();
		highlightPacote()
		pacotes.setPacoteAmpliado2(pegaValorDaTela("//*[@id='package_0']/div[2]/div[2]"))
		pacotes.setPacoteCompacto1(pegaValorDaTela("//*[@id='package_1']/div[2]/div[2]"))
		pacotes.setPacoteCompacto2(pegaValorDaTela("//*[@id='package_2']/div[2]/div[2]"))
		pacotes.setPacoteAmpliado1(pegaValorDaTela("//*[@id='package_3']/div[2]/div[2]"))
		pacotes.setPacoteExclusivo(pegaValorDaTela("//*[@id='package_4']/div[2]/div[2]"))
		WebUI.delay(5)
		unHighlightPacote()
		return pacotes;
	}

	/**
	 *
	 * @param pacote1
	 * @param pacote2
	 * @return
	 */
	public static validarPacotes(Object pacote1, Object pacote2, int i, int teste){
		try{
			CasoDeTeste validacao1 = pacote1;
			CasoDeTeste validacao2 = pacote2;
			resultadoDoTeste = validacao1.getPacoteAmpliado2().contentEquals(validacao2.getPacoteAmpliado2());
			System.err.println("validarPacotes ["+resultadoDoTeste+"]")
			def status
			if(resultadoDoTeste == false){
				status="FAIL"
				validacao1.setStatus(status)
				validacao2.setStatus(status)
			}else{
				status="PASSED"
				validacao1.setStatus(status)
				validacao2.setStatus(status)
			}
		} catch (Exception e){
			salvarEvidenciaRadarLive(i, "Não foi possivel validar os pacotes - Execução "+teste, "FAIL", "S")
		}
	}


	/**
	 * @author T_DCDias
	 * @param corretor
	 * @return
	 */
	public static registroDeFalhaDeValidacaoDoCorretor(String corretor, int i, int teste){
		System.err.println(i+"Falha no corretor "+corretor)
		porcentagemDeTela(60)
		adicionaCenario("FAIL", issue_info.get(0).get("Cenário")+" - Execução "+teste)
		adicionarEvidencia(takeScreen())
		porcentagemDeTela(100)
		salvarEvidenciaRadarLive(i, "Falha ao validar pacotes do corretor "+corretor+" Execução "+teste, "FAIL", "S")
		finalizar()
	}

	/**
	 * @author T_DCDias
	 * @param corretor
	 * @return
	 */
	public static registroDeExecucaoSemMassa(){
		adicionaCenario("FAIL", "Não existe dados para validar")
	}







}
