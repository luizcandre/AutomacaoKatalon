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


class TipoDeSeguro {

	@Given("que eu estou na Home do sistema Auto")
	def homePage(DataTable data){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.acessaHomePage(data)
	}

	@And("clico no botão Nova Cotação na Home")
	def clicarBotao(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.clicaBotao()
	}

	@And("seleciono a opção Automovel na Modal Nova Cotação")
	def selecionaAutomovel(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaOpcaoAuto()
	}

	@When("clico no combo 'O seguro que você está cotando é', na tela '1. Cotação Auto' são exibidos as opções")
	def cotacaoSeguro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.apenasClicarTipoDeSeguroEmCotacao()
	}

	@Then("as informações são exibidas conforme esperado")
	def validaTipoDeSeguros(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.recuperarInformacoesComboCotacao()
	}

	@When("seleciono a opção 'Renovação Allianz sem sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'")
	def renovaçãoAllianzSemSinistro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaTipoDeSeguroEmCotacao()
	}

	@Then("são exibidos os campos 'Qual a sua classe de bônus'")
	def validaLabelClasseDeBonus(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.validarLabelClasseDeBonus()
	}

	@And("o campo 'Número da CI'.")
	def validaLabelNumeroDaCI(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.validarLabelNumeroDaCI()
	}

	@When("seleciono a opção 'Renovação de outra seguradora com sinistro' no combo 'O seguro que você está cotando é' na tela '1. Cotação Auto'")
	def renovaçãoOutraSeguradoraComSinistro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaTipoDeSeguroEmCotacao()
	}

	@And("clico no menu 'Vendas' na 'Home'")
	def MenuPrincipal(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.MenuPrincipal()
	}

	@And("clico na oção 'Endossos'")
	def subMenus(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.subMenus()
	}

	@And("clico na opção 'Endosso'")
	def subMenuEndossos(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.subMenuEndossos()
	}

	@And("informo o número da apólice no campo 'Apolice'")
	def informarApolice(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.informarApolice()
	}

	@And("clico no botão 'Selecionar'")
	def clicarBotaoFrameSelecionar(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.clicarBotaoFrameSelecionar()
	}

	@And("clico no botão 'Aceitar'")
	def clicarBotaoFrameAceitar(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.clicarBotaoFrameAceitar()
	}

	@And("preencho todos os campos obrigatorios com dados validos na tela 1.Cotacao Auto")
	def preencherCotacaoAuto(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.preencheCamposObrigatoriosCotacaoAutoUmIFrame()
	}

	@And("seleciono a opção 'Renovação de outra seguradora com sinistro' está selecionada no campo 'O seguro que você está cotando é' na tela '1. Cotação Auto'")
	def renovaçãoDeOutraSeguradoraComSinistro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaTipoDeSeguroEmCotacao()
	}

	@And("seleciono a opção 1 no campo Qual a sua classe de bônus")
	def classeDeBonusUm(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaClasseDeBonus()
	}

	@And("clico no botão de gerar cotação 'Imagem de um Disquete'")
	def clicarEmgerarCotação(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.clicarEmGerarCotacao()
	}

	@And("capturo o número informado na seção 'Número da cotação'")
	def capturoNumeroDaCotação(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.pegarNumeroDaCotacaoNoModal()
	}

	@And("clico no 'x' para fechar o modal")
	def fecharModalGerarCotacao(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.fecharModal()
	}

	@And("informo o número capturado na seção 'Número da cotação' no campo 'Pesquisar'")
	def informarNumeroCapturadoNoCampoPesquisar(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.preencherCampoPesquisar()
	}

	@And("clico na opção 'Cotação' e acesso a tela 'Cotação'")
	def clicarOpcaoCotacao(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionarCotacao()
	}

	@And("clico no botão 'Emitir'")
	def clicarNoBotaoEmitirDoFrame(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.clicarNoBotaoEmitirDoFrame()
	}

	@When("eu verifico a informação do combo  'O seguro que você está cotando é' na tela 1.Cotação Auto")
	def verificaInformacaoDoLabelDoCombo(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.verificaInformacaoDoLabelDoCombo()
	}

	@Then("é exibido o texto 'Renovação de outra seguradora com sinistro' bloqueado para edição.")
	def validaElementoRenovaçãoDeOutraSeguradoraComSinistroBloqueado(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.validaElementoRenovaçãoDeOutraSeguradoraComSinistroBloqueado()
	}

	@And("seleciono a opção 'Renovação de outra seguradora sem sinistro' está selecionada no campo 'O seguro que você está cotando é'")
	def renovaçãoDeOutraSeguradoraSemSinistro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.selecionaTipoDeSeguroEmCotacao()
	}

	@Then("é exibido o texto 'Renovação de outra seguradora sem sinistro' livre para edição.")
	def validaElementoRenovaçãoDeOutraSeguradoraSemSinistroDesbloqueado(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.validaElementoRenovaçãoDeOutraSeguradoraSemSinistroDesbloqueado()
	}

	@And("não há duplicidade de informações no combo tipo de seguro")
	def verificaDuplicidadeComboTipoDeSeguro(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.verificaDuplicidadeTipoDeSeguro()
	}
	
	
	
	
	
	
	@And("clico no menu 'Consultas' na 'Home'")
	def MenuPrincipalConsultas(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.MenuPrincipal()
	}
	
	@And("clico na opção 'Consultas'")
	def subMenuConsultas(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.subMenuCotacoesConsulta()
	}
	
	@And("clico na oção 'Cotações realizadas'")
	def subMenusCotacoesRealizadas(){
		funcionalidadesAuto.TipoDeSeguroFuncionalidades.subMenus()
	}
	
	
	
	
}