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
import io.cucumber.datatable.DataTable
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


class Assistencia {

	@When('verifico a sessão Cláusulas da tela "Confirmação de Pagamento"')
	def verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento()
	}

	@Then('é exibida a Cláusula')
	def verificaClausula(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaClausula()
	}

	@And ('clico no botão "Comprar Compacto"')
	def clicaNobotaoComprarCompacto(){
		funcionalidadesAuto.AssistenciaFuncionalidades.clicaNobotaoComprarCompacto()
	}

	@When ('verifico os pacotes com  "Assistências 24h - Completa"')
	def verificaPacotesCompleta(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaPacotes()
	}

	@Then('é exibido os dias para a opção de Carro Reserva')
	def validarDiasDeCarroReserva(){
		funcionalidadesAuto.AssistenciaFuncionalidades.validarDiasDeCarroReserva()
	}

	@When('verifico os pacotes com  "Assistências 24h - VIP"')
	def verificaPacotesVIP(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaPacotes()
	}

	@When('verifico os pacotes para a opção de Guincho com  "Assistências 24h - Completa" para a opção de Guincho')
	def validarOpcaoDeGunchoCompleta(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaPacotesOpcaoDeGuincho()
	}

	@When('verifico os pacotes para a opção de Guincho com  "Assistências 24h - VIP" para a opção de Guincho')
	def validarOpcaoDeGunchoVIP(){
		funcionalidadesAuto.AssistenciaFuncionalidades.verificaPacotesOpcaoDeGuincho()
	}

	@Then('é exibido km para a opção de Guincho')
	def validarOpcaoDeGuincho(){
		funcionalidadesAuto.AssistenciaFuncionalidades.validarOpcaoDeGuincho()
	}
}