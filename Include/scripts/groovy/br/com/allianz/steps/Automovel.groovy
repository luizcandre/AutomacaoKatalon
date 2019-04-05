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


class Automovel {

	@Given("")

	@Then("as opções 'Estado civil do condutor:' são exibidas conforme esperado")
	def exibirOpcoesEstadoCivilCondutor(){
		funcionalidadesAuto.AutomovelFuncionalidades.exibirOpcoesEstadoCivilCondutor()
	}

	@Then("as opções 'O principal condutor reside em:' são exibidas conforme esperado")
	def exibirOpcoesPrincipalCondutorResideEm(){
		funcionalidadesAuto.AutomovelFuncionalidades.exibirOpcoesPrincipalCondutorResideEm()
	}

	@And("não há duplicidade de informação")
	def verificaDuplicidadeAuto(){
		funcionalidadesAuto.AutomovelFuncionalidades.verificaDuplicidadeAuto()
	}

	@When("clico na opção 'Sim' do campo 'Utiliza o veiculo comercialmente'")
	def clicarBotaoSimAutoUtilizaVeiculoComercialmente(){
		funcionalidadesAuto.AutomovelFuncionalidades.clicarBotaoAutoUtilizaVeiculoComercialmente()
	}

	@Then("é exibido a mensagem: 'Sem cobertura para veículos utilizados como taxi ou transporte de passageiros'")
	def validaMensagemAuto(){
		funcionalidadesAuto.AutomovelFuncionalidades.validaMensagemAuto()
	}

	@When("clico na opção 'Não' do campo 'Utiliza o veiculo comercialmente'")
	def clicarBotaoNaoAutoUtilizaVeiculoComercialmente(){
		funcionalidadesAuto.AutomovelFuncionalidades.clicarBotaoAutoUtilizaVeiculoComercialmente()
	}

	@Then("NÃO é exibido nenhuma mensagem")
	def validaMensagemAutoVazia(){
		funcionalidadesAuto.AutomovelFuncionalidades.validaMensagemAutoVazia()
	}

	@When("clico na opção 'Não' do campo 'O condutor reside com pessoas de 17 a 25 anos'")
	def clicarBotaoNaoAutoCondutorResideComPessoas(){
		funcionalidadesAuto.AutomovelFuncionalidades.clicarBotaoNaoAutoCondutorResideComPessoas()
	}

	@When("clico no  botão 'Sim' do campo 'O condutor reside com pessoas de 17 a 25 anos' são exibidas as opções")
	def clicarBotaoSimAutoCondutorResideComPessoas(){
		funcionalidadesAuto.AutomovelFuncionalidades.clicarBotaoSimAutoCondutorResideComPessoas()
	}

	@Then("as opções 'O condutor reside com pessoas de 17 a 25 anos' são exibidas conforme esperado")
	def exibirOpcoesCondutorResideComPessoas(){
		funcionalidadesAuto.AutomovelFuncionalidades.exibirOpcoesCondutorResideComPessoas()
	}

	@Given("preencho todos os demais campos obrigatórios com dados válidos")
	def preencherCotacaoAuto(){
		funcionalidadesAuto.AutomovelFuncionalidades.preencheCamposObrigatoriosCotacaoAutoUm()
	}

	@When("que estou na tela '2. Preço' clico no ícone 'Salvar Cotação'")
	def clicarSalvarCotação(){
		funcionalidadesAuto.AutomovelFuncionalidades.clicarSalvarCotação()
	}

	@And("clico no botão 'Baixar PDF' no modal 'Cotação'")
	def gerartePDF(){
		funcionalidadesAuto.AutomovelFuncionalidades.salvarArquyivoPDF()
	}

	@And("verifico a seção 'Características do Condutor' no PDF")
	def verificaCaracterísticasDoCondutor(){
		funcionalidadesAuto.AutomovelFuncionalidades.verificaDadosDoProduto()
	}

	@Then("é exibido a informação 'Separado a' ou 'Divorciado a' para o campo 'Estado civil do condutor'")
	def identificaInformacaoDoEstadoCivilDoCondutor(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}

	@And("eu clico na opção 'Sim' do campo 'Utiliza o veiculo comercialmente'")
	def utilizaVeiculoComercialmenteOpcaoSim(){
		funcionalidadesAuto.AutomovelFuncionalidades.utilizaVeiculoComercialmente()
	}

	@And("verifico a seção 'Dados do Produto' no PDF")
	def verificaDadosDoProduto(){
		funcionalidadesAuto.AutomovelFuncionalidades.verificaDadosDoProduto()
	}

	@Then("é exibido a informação 'Automóvel - Comercial' para o campo 'Categoria de Risco'")
	def identificaDadosDoProdutoAutomóvelComercial(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}

	@And("eu clico na opção 'Não' do campo 'Utiliza o veiculo comercialmente'")
	def utilizaVeiculoComercialmenteOpcaoNao(){
		funcionalidadesAuto.AutomovelFuncionalidades.utilizaVeiculoComercialmente()
	}

	@Then("é exibido 'Automóvel - Particular' em 'Utiliza o veiculo comercialmente'")
	def identificaDadosDoProdutoAutomóvelParticular(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}

	@And("eu clico na opção 'Não' do campo 'O condutor reside com pessoas de 17 a 25 anos'")
	def naoResideComPessoasDestaFaixaEtaria(){
		funcionalidadesAuto.AutomovelFuncionalidades.resideComPessoasDestaFaixaEtaria()
	}

	@Then("é exibido a mensagem: 'Não reside com pessoas desta faixa etária' para o campo  'O condutor reside com pessoas de 17 a 25 anos'")
	def identificaResideComPessoasDestaFaixaEtariaNao(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}

	@And("eu clico na opção 'Sim' do campo 'O condutor reside com pessoas de 17 a 25 anos'")
	def simResideComPessoasDestaFaixaEtaria(){
		funcionalidadesAuto.AutomovelFuncionalidades.resideComPessoasDestaFaixaEtaria()
	}

	@Then("é exibido a informação 'Sim' para a opção 'O condutor reside com pessoas de 17 a 25 anos'")
	def identificaResideComPessoasDestaFaixaEtariaSim(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}

	@And("seleciono uma opção do campo 'O condutor reside com pessoas de 17 a 25 anos'")
	def selecionarOpcaoCondutorResideComPessoas(){
		funcionalidadesAuto.AutomovelFuncionalidades.selecionarOpcaoCondutorResideComPessoas()
	}

	@Then("é exibido a informação 'Casa em Condomínio Fechado' para o campo 'O principal condutor reside em'")
	def resideCasaEmCondomínioFechado(){
		funcionalidadesAuto.AutomovelFuncionalidades.identificaDadosDoProduto()
	}
}