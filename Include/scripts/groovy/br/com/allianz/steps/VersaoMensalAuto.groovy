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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import io.cucumber.datatable.DataTable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.apache.http.util.Asserts
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

import org.openqa.selenium.Keys as Keys

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*

import java.text.NumberFormat
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import commands.AutoComandos

class VersaoMensalAuto {

	@And("clico no botao Avançar")
	def botaoAvançar(){
		commands.AutoComandos.botaoAvançar()
	}

	@And("clico no botao Comprar")
	def botaoComprar(){
		commands.AutoComandos.botaoComprar()
	}

	@And("seleciono a opção Renovação de outra seguradora com sinistro está selecionada no campo O seguro que você está cotando é")
	def tipoDeSeguroEmCotacao(){
		commands.AutoComandos.selecionaTipoDeSeguroEmCotacao()
	}

	@And("seleciono a opção 0 no campo Qual a sua classe de bônus")
	def classeDeBonusZero(){
		commands.AutoComandos.selecionaClasseDeBonus()
	}

	@And("preencho todos os campos obrigatorios com dados validos na tela 3.Pagamento")
	def preencherPagamento(){
		commands.AutoComandos.preencheCamposObrigatorioPagamento()
	}

	@And("informo o número da cotação no campo 'Pesquisar'na Home")
	def informarCotacao(){
		commands.AutoComandos.informaCotacao()
	}

	@And("seleciono a opção 'Cotação' na Barra de Pesquisa")
	def cotacaoPesquisa(){
		commands.AutoComandos.pesquisarCotacao()
	}

	@And("clico no botão Emitir na tela Cotação")
	def emitir(){
		commands.AutoComandos.emitirCotacao()
	}

	@And("finalizo a aplicação")
	def finalizarAplicação(){
		WebUI.delay(2)
		commands.AutoComandos.finalizar()
	}

	@And("clico no botão 'Alterar'")
	def clicarNoBotaoAlterarDoFrame(){
		commands.AutoComandos.clicarNoBotaoAlterarDoFrame()
	}
}