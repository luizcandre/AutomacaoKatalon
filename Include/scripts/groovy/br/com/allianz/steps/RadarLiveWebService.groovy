package br.com.allianz.steps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import funcionalidadesAuto.RadarLiveFuncionalidades
import io.cucumber.datatable.DataTable

import static org.junit.Assert.*

class RadarLiveWebService {



	@Given('que carrego os dados obrigatórios "Body" da requisição SOAP.')
	def realizarRequestWebServiceSoap(DataTable data){
		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.lerDataTable(data)
	}

	@And('realizo requests no WebService no motor de Calculo Antigo')
	def realizoRequestTestAntigo(){
		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.realizaLeituraPlanilha()
		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.finalizarDocumento()
		//funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.solicitaRequestMotorCalcAntigo()
	}

	//	@And('obtenho os dados do WebService antigo')
	//	def obterDadosAntigo(){
	//		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.selecionarPacotePorParcelaMotorCalcAntigo()
	//		//	funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.pegarPacoteCoberturaList()
	//	}
	//
	//	@And('realizo requests no WebService no motor de Calculo Novo')
	//	def realizoRequestTestNovo(){
	//		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.solicitaRequestMotorCalcNovo()
	//	}
	//
	//	@And('obtenho os dados do WebService Novo')
	//	def obterDadosNovo(){
	//		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.selecionarPacotePorParcelaMotorCalcNovo()
	//	}
	//
	//	@Then('verifico se não existem diferenças no cálculo dos pacotes no documento xml respota do web service.')
	//	def validaPacotesMotorAntigoENovo(){
	//		if(funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.validar()){
	//			KeywordUtil.markFailed("Ocorreu um erro na validação dos dados")
	//		}
	//	}
	//
	//	@And('finaliza a automação')
	//	def finalizaAutomacao(){
	//		funcionalidadesAuto.RadarLiveWebServiceFuncionalidades.finalizar()
	//	}
}