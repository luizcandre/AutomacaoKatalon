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


class cpf {

	@Then('é exibida a mensagem: "Restrição Técnica para o Segurado"')
	def validaMensagemDeAlerta(){
		funcionalidadesAuto.CPFFuncionalidades.validaMensagemDeAlerta()
	}

	@And('clico no botao Avançar sem parar por mensagem')
	clicarEmAvancar(){
		funcionalidadesAuto.CPFFuncionalidades.clicarEmAvancar()
	}

	@And('seleciono a opção "Renovação Allianz com sinistro" no combo "O seguro que você está cotando é" na tela "1. Cotação Auto"')
	def selecionaTipoDeSeguroEmCotacao(){
		funcionalidadesAuto.CPFFuncionalidades.selecionaTipoDeSeguroEmCotacao()
	}

	@Then('exibe a mensagem "CPF inválido" em vermelho')
	def validaCPFInvalido(){
		funcionalidadesAuto.CPFFuncionalidades.validaCPFInvalido()
	}


	@When('preencho com o CPF do condutor diferente do segurado')
	def cpfDoCondutor(){
		funcionalidadesAuto.CPFFuncionalidades.cpfDoCondutor()
	}

	@Then('é exibida  a mensagem  "CNPJ inválido" em vermelho')
	def cnpjInvalido(){
		funcionalidadesAuto.CPFFuncionalidades.cnpjInvalido()
	}

	@When('preencho com o CNPJ do condutor inválido')
	def preencheCnpj(){
		funcionalidadesAuto.CPFFuncionalidades.preencheCnpj()
	}

	@Then('é exibida a mensagem: "Condutor não pode ter mais de 100 anos"')
	def validaMensagem(){
		funcionalidadesAuto.CPFFuncionalidades.validaMensagemDeAlerta()
	}
}