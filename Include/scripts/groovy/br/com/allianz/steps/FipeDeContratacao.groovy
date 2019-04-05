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


class FipeDeContratacao {

	@And("seleciono a opção 'Sim' no botão 'O veículo é 0 km'")
	def botaoVeiculoZerokmSim(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.selecionarVeiculoZerokm()
	}

	@And("que estou na tela '2. Preço' clico sessão 'Edição de Cálculo'")
	def clicarNaSessãoEdiCAoDeCalculo(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarNaSessãoEdiCAoDeCalculo()
	}

	@And("clico no combo da opção 'Tabela FIPE'")
	def clicarTabelaFIPE(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.clicarTabelaFIPE()
	}

	@Then("as opções 'Tabela FIPE' são exibidas conforme esperado")
	def pegarOpcoesTabelaFIPE(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.pegarOpcoesTabelaFIPE()
	}

	@When("verifico na sessão 'Edicação de Cálculo' o valor FIPE de '90%'")
	def verificarSessaoEdicaçãoDeCalculo(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.verificarSessaoEdicaçãoDeCalculo()
	}

	@Then("é exibida a mensagem 'Aceitação Condicionada a Inspeção Veicular e contratação de 90% FIPE'")
	def validaExibicaoDeMensagem(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.validaExibicaoDeMensagem()
	}

	@And("seleciono a opção 'Não' no botão 'O veículo é 0 km'")
	def botaoVeiculoZerokmNao(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.selecionarVeiculoZerokm()
	}

	@And("seleciono opção da tabela FIPE")
	def selecionaValorNaTabelaFIPE(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.selecionaValorNaTabelaFIPE()
	}

	@And('recalculo o valor da tabela FIPE')
	def recalcularValorDaTabelaFIPE(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.recalcularValorDaTabelaFIPE()
	}

	@Then("é exibida a mensagem 'Percentual FIPE não permitido para esta cotação'")
	def validaPercentualFIPENaoPermitido(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.validaPercentualFIPENaoPermitido()
	}

	@Then('nenhuma critíca é exibida')
	def validaInesistenciaDeMensagemCritíca(){
		funcionalidadesAuto.FipeDeContratacaoFuncionalidades.validaInesistenciaDeMensagemCritíca()
	}
}