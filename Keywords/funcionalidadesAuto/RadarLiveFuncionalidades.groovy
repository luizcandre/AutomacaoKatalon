package funcionalidadesAuto

import java.util.List

import javax.swing.ToolTipManager.insideTimerAction
import javax.xml.soap.SOAPMessage

import org.junit.After

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import bean.CasoDeTeste
import bean.Pacote
import bsh.commands.dir
import commands.AutoComandos
import io.cucumber.datatable.DataTable
import webservice.AutomacaoException
import webservice.CotacaoWebService
import webservice.MessagesFactory
import webservice.RequestSoap
import webservice.WebServiceError


public class RadarLiveFuncionalidades extends AutoComandos{

	private static boolean resultadoDoTeste = false;

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static lerDataTable(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);
		def ct = issue_info.get(0).get("CT")
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		createTitlePage()
	}

	/**
	 * @author Luiz Andre
	 * @return
	 */
	public static preencherCamposObrigatoriosDaTelaPreco(){
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
						WebUI.delay(20)
						preencheCamposObrigatoriosListFrame(i)
						WebUI.delay(3)
						botaoAvançar()
						pacote1 = obterPacotes()
						WebUI.switchToDefaultContent()
						WebUI.delay(3)
						WebUI.closeBrowser()
					}   catch (Exception e){
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
						WebUI.delay(20)
						preencheCamposObrigatoriosListFrame(i)
						WebUI.delay(3)
						botaoAvançar()
						pacote2 = obterPacotes()
					}   catch (Exception e){
						registroDeFalhaDeValidacaoDoCorretor(ListCasoDeTeste.get(i).getUsuario2(),i, teste)
						break
					}

					validarPacotes(pacote1, pacote2,i, teste)
					pacote1.setUsuario(ListCasoDeTeste.get(i).getUsuario())
					pacote2.setUsuario2(ListCasoDeTeste.get(i).getUsuario2())
					evidenciaRadarLive(pacote1, pacote2, teste, issue_info.get(0).get("Cenário"))
					WebUI.delay(3)
					WebUI.closeBrowser()
					teste++
					validaResultadoDaComparacaoDePacotes(i)
				}
			}
		}

		if(existeDados==false){
			System.err.println("existeDados ["+existeDados+"]")
			registroDeExecucaoSemMassa()
		}
		finalizar()
	}

	/**
	 * Obtem valores dos pacotes a atribui ao objeto pacote 
	 */
	public static CasoDeTeste obterPacotes(){
		CasoDeTeste pacotes = new CasoDeTeste();
		highlightPacote()
		pacotes.setPacoteAmpliado2(pegaValorDaTela("//*[@id='package_0']/div[2]/div[2]"))
		pacotes.setPacoteCompacto1(pegaValorDaTela("//*[@id='package_1']/div[2]/div[2]"))
		pacotes.setPacoteCompacto2(pegaValorDaTela("//*[@id='package_2']/div[2]/div[2]"))
		pacotes.setPacoteAmpliado1(pegaValorDaTela("//*[@id='package_3']/div[2]/div[2]"))
		pacotes.setPacoteEspecial(pegaValorDaTela("//*[@id='package_4']/div[2]/div[2]"))
		pacotes.setPacoteExclusivo(pegaValorDaTela("//*[@id='package_5']/div[2]/div[2]"))
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
			//resultadoDoTeste = validacao1.equals(validacao2);

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
	 * @author T_DCDias
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
	 *@author T_DCDias
	 */
	public static highlightPacote(){
		for(int i=0; i<=6; i++){
			highlightElement("//*[@id='package_"+i+"']/div[2]")
		}
	}

	/**
	 *@author T_DCDias
	 */
	public static unHighlightPacote(){
		for(int i=0; i<=6; i++){
			unHighlightElement("//*[@id='package_"+i+"']/div[2]")
		}
	}

	/**
	 * @author T_DCDias
	 */
	public static registroDeExecucaoSemMassa(){
		adicionaCenario("FAIL", "Não existe dados para validar")
	}


}
