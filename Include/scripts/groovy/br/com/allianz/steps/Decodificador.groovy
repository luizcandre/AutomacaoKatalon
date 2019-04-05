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


class Decodificador {

	@Then('é exibido a marca, modelo, versão, ano e chassi')
	def validaDadosDoAutomovel() {
		funcionalidadesAuto.DecodificadorFuncionalidades.validaDadosDoAutomovel()
	}

	@Then('é exibido a mensagem de erro')
	def validaMensagemDeErro(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validaMensagemDeErro()
	}

	@Then('é exibido os botões habilitados de "Sim" e "Não" para o campo "O veículo é 0Km"')
	def validaBotaoSimNaoVeiculoZero(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validaBotaoSimNaoVeiculoZero()
	}

	@Then('é exibido um modal para a seleção do veículo')
	def validarModalDeSelecaoDeVeiculo(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validarModalDeSelecaoDeVeiculo()
	}

	@And('preencho com um chassis válido')
	def preencherChassiValido(){
		funcionalidadesAuto.DecodificadorFuncionalidades.preencherChassi()
	}

	@And('preencho com um chassis inexistente')
	def preencherChassiInexistente(){
		funcionalidadesAuto.DecodificadorFuncionalidades.preencherChassi()
	}

	@And('o campo "Placa do veículo" é exibido em branco')
	def validaCampoPLaca(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validaCampoPLacaEmBranco()
	}

	@And('preencho manualmente o campo "Placa do veículo" com uma pláca válida')
	def preencheCampoPlaca(){
		funcionalidadesAuto.DecodificadorFuncionalidades.preencheCampoPlaca()
	}

	@Then('o campo "Placa do veículo" é exibido preenchido')
	def validaCampoPlaca(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validaCampoPlacaPreenchido()
	}

	@Then('o campo "Placa do veículo" é exibido em branco.')
	def validaCampoPlacaEmBranco(){
		funcionalidadesAuto.DecodificadorFuncionalidades.validaCampoPLaca()
	}

	@And('seleciono a opção "Sim" para "O veículo é 0 km"')
	def selecionaOpcaoSimParaCarroZero(){
		funcionalidadesAuto.DecodificadorFuncionalidades.selecionaOpcaoSimParaCarroZero()
	}

	@And('preencho com uma placa inválida')
	def preencherPlacaInvalida(){
		funcionalidadesAuto.DecodificadorFuncionalidades.preencherPlacaInvalida()
	}
}