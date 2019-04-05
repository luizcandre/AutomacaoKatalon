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


class DescontoComercialCAPComissao {

	@When('clico no combo box do campo "CAP"')
	def clicaNoComboCAP(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.clicaNoComboCAP()
	}

	@Then('é exibido o valor do campo "CAP"')
	def validaValorDoCampoCAP(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.validaValorDoCampoCAP()
	}

	@Then('as opções "CAP" são exibidas conforme esperado')
	def exibirOpcoesCAP(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.exibirOpcoesCAP()
	}

	@When ('edito o campo Comissão')
	def editarComissao(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.editarComissao()
	}

	@Then('o valor é permitido')
	def verificaValorPermitidoParaComissao(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.verificaValorPermitidoParaComissao()
	}

	@When('verifico se o campo está preenchido com o valor')
	def verificaCampoPreenchido(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.verificaCampoComissaoPreenchido()
	}

	@When('verifico se o campo está preenchido com qualquer valor')
	def verificaCampoPreenchidoComQualquerValor(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.verificaCampoCAPPreenchidoComQualquerValor()
	}

	@When('verifico se o campo CAP está preenchido com qualquer valor da nova janela')
	def verificaCampoCAPPreenchidoComQualquerValorNova(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.verificaCampoCAPPreenchidoComQualquerValorNovaJanela()
	}

	@When('verifico se o campo Comissão está preenchido com qualquer valor da nova janela')
	def verificaCampoComissaoPreenchidoComQualquerValorNova(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.verificaCampoComissaoPreenchidoComQualquerValorNovaJanela()
	}

	@And('que estou na tela "2. Preço" clico sessão "Edição de Cálculo" da nova janela')
	def clicarSessãoEdicaoDeCalculoDaNovaJanela(){
		funcionalidadesAuto.DescontoComercialCAPComissaoFuncionalidades.clicarSessãoEdicaoDeCalculoDaNovaJanela()
	}
}