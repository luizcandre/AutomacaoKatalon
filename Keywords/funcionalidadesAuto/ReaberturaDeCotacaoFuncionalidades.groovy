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

public class ReaberturaDeCotacaoFuncionalidades extends AutoComandos {



	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificaBotao(){
		try{
			if( verificaBotaoNoFrame(issue_info.get(0).get("Botão"), issue_info.get(1).get("Botão"))){
				highlightElement('//*[@id="detalleSectionBar"]/table/tbody/tr/td')
				salvarEvidencia(issue_info.get(0).get("CT"),' É exibido o botão "Alterar" na tela "Cotação" ', "PASSED" )
				unHighlightElement('//*[@id="detalleSectionBar"]/table/tbody/tr/td')
			} else {
				salvarEvidencia(issue_info.get(0).get("CT"),' Não foi exibido o botão '+issue_info.get(0).get("Botão")+' na tela "Cotação" ', "FAIL" )
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),' Falha ao validar botao '+issue_info.get(0).get("Botão")+' na tela "Cotação"', "FAIL" )
		}
	}


	/**
	 * @author T_DCDias
	 * @return
	 */
	public static verificarInesistenciaDoBotao(){
		try{
			if( verificaBotaoNoFrame(issue_info.get(0).get("Botão"), issue_info.get(1).get("Botão"))){
				salvarEvidencia(issue_info.get(0).get("CT"),' É exibido o botão '+issue_info.get(0).get("Botão")+' na tela "Cotação" ', "FAIL" )
			} else {
				highlightElement('//*[@id="detalleSectionBar"]/table/tbody/tr/td')
				salvarEvidencia(issue_info.get(0).get("CT"),' Não é exibido o botão '+issue_info.get(0).get("Botão")+' na tela "Cotação"', "PASSED" )
				unHighlightElement('//*[@id="detalleSectionBar"]/table/tbody/tr/td')
			}
		} catch (Exception e){
			salvarEvidencia(issue_info.get(0).get("CT"),' Falha ao validar botao '+issue_info.get(0).get("Botão")+' na tela "Cotação"', "FAIL" )
		}
	}
}
