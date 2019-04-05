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


class VigenciaDoSeguro {

	@Given("Auto")
	def homePage(DataTable data){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.acessaHomePage(data)
	}

	@And("seleciono uma data dentro do periodo de 30 dias futuros no campo Data de inicio de vigência do seguro")
	def dataDeVigencia(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.dataDeVigencia()
	}

	@When("verifico a informação de vigência da apólice na seção Resumo dos Dados na tela Preço")
	def capturaVigenciaDaApolice(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.capturaVigenciaDaApolice()
	}

	@Then("é exibido um período igual a 365 dias")
	def calculoVigencia(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.calculoVigencia()
	}

	@Then("seleciono uma data inferior á data atual")
	def navegacaoDatasIneriores(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.navegacaoDatasIneriores()
	}

	@Then("o campo do dia é exibido desabilitado para seleção")
	def identificaCampoDesabilitado(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.identificaCampoDesabilitado()
	}

	@Then("a data de fim de vigência é exibida sem alteração")
	def validaDataFimDeVigencia(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.validaDataFinalDaVigencia()
	}

	@And("verifico a informação do campo 'Vigência' na seção 'Dados Gerais' no PDF")
	def verificaVigenciaProduto(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.verificaVigenciaProdutoPDF()
	}

	@Then("é exibido um período igual a 365 dias no PDF")
	def realizaCalculoVigenciaPDF(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.realizaCalculoVigenciaPDF()
	}

	@And("informo o 'Número da CI'")
	def preencherNumeroCI(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.preencherNumeroCI()
	}

	@And("clico na oção 'Gestão de Renovações'")
	def subMenus(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.subMenus()
	}

	@And("informo a opção 'Automóvel' no combo 'Agrupamento de Ramos'")
	def agrupamentoDeRamos(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.preencherAgrupamentoDeRamos()
	}

	@And("seleciono a primeira opção  no combo 'Vencimento'")
	def vencimento(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.preencherVencimento()
	}

	@And("clico no botão 'Filtrar'")
	def clicarBotaoTelaRenovacao(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.clicarBotaoTelaRenovacao()
	}

	@And("clico na primeira opção que tenha disponível o botão de pesquisa 'Lupa'")
	def clicarNaLupa(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.clicarNaLupa()
	}

	@And("clico no botão 'Renovar com alteração' na seção 'Detalhe da Pesquisa'")
	def clicarRenovarComAlteração(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.clicarRenovarComAlteração()
	}

	@And("clico no botao Avançar da nova janela")
	def clicarBotaoAvancar(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.botaoAvancarNovaJanela()
	}

	@And("clico no botão 'Baixar PDF' no modal 'Cotação' da nova janela")
	def gerartePDFNovaJanela(){
		funcionalidadesAuto.VigenciaDoSeguroFuncionalidades.salvarArquyivoPDFNovaJanela()
	}
}