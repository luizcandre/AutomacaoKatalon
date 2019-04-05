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


class CepPernoite {


	@And('verifico o campo "CEP" que é exibido o campo preenchido')
	def verificoCampoCEP(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.verificoCampoCEP()
	}

	@Then('verifico se mensagem de "CEP" é exibida')
	def verificaMensagemDeAlerta(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.verificaMensagemDeAlerta()
	}

	@When('preencho com CPF válido e que tenha CEP cadastrado na base')
	def preencheCPF(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.preencheCPFeTrocaDeCEP()
	}

	@When('informo "CEP" inválido')
	def informarCepInvalido(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.escreveCEPInvalido()
	}

	@When('informo "CEP" válido')
	def informarCepValido(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.escreveCEPValido()
	}

	@Then('verifico as informações para "Seguro Novo"')
	def verificoInformacoesParaSeguroNovo(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.verificoInformacoesParaSeguroNovo()
	}

	@When('clique no campo "Não sei o CEP" para Seguro Novo')
	def clicarEmNaoSeiCep(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.clicarEmNaoSeiCep()
	}

	@And('preencho com logradouro, Cidade e Estado válido')
	def preencheLogradouroCidadeEstado(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.preencheLogradouroCidadeEstado()
	}
	@And('clico no botão "Buscar" e ao localizar o endereço clico no botão "OK"')
	def clicaNoBotãoBuscar(){
	}

	@And('clico no botão "OK"')
	def clicaNoBotaoOK(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.clicaNoBotaoOK()
	}

	@Then('valido as informações do combo "Selecione o Estado" da janela "Informações do Endereço"')
	def validaInformacoesDoComboSelecioneEstado(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.validaInformacoesDoComboSelecioneEstado()
	}

	@And("não há duplicidade de informações no combo 'Selecione o Estado'")
	def verificaDuplicidadeComboTipoDeSeguro(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.verificaDuplicidadeComboSelecioneEstado()
	}

	@And('preencho com a Cidade válida')
	def preencheCidade(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.preencheCidade()
	}

	@And('preencho com logradouro válido')
	def preencheLogradouro(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.preencheLogradouro()
	}

	@Then('não exibe nenhuma informação na tela')
	def validaInformacaoNaTelaInformacoesDoEndereço(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.validaInformacaoNaTelaInformacoesDoEndereço()
	}

	@And('clico no botão "Buscar"')
	def clicarNoBotooBuscar(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.clicarNoBotooBuscar()
	}
	
	@Then('na tela "2 Preço" na listagem de Coberturas são exibidas a opções de Carta Verde')
	def valdidaCartaVerde(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.valdidaCartaVerde()
	}
	
	@And('verifico a seção "Coberturas Carta Verde" no PDF')
	def valdidaCartaVerdePDF(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.valdidaCartaVerdePDF()
	}
	
	@Then('é exibido a informação "Carta Verde" para o campo "Coberturas"')
	def verificarInformacaoCartaVerdePDF(){
		funcionalidadesAuto.CepPernoiteFuncionalidades.verificarInformacaoCartaVerdePDF()
	}
	
	
}