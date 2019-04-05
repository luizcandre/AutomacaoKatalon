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


class ValidaLayout {


	@Given("Dado que eu estou na 'Sessão iniciar' do sistema corretor ePac")
	def sessaoIniciarSistemaCorretorEpac(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.acessaSessaoIniciar(data)
	}

	@When("eu informo usuário e senha válidos")
	def informoUsuarioSenha() {
		funcionalidadesAuto.ValidaLayoutFuncionalidades.efetuarLogin()
	}

	@And("clico no botão 'Aceitar' na 'Sessão iniciar'")
	def botãoAceitar(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.acessarHome()
	}

	@Then("é exibida a tela 'Home'")
	def telaHome(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutTelaInicial()
	}

	@Then("é exibido a mensagem 'Acesso negado'")
	def mensagemAcessoNegado(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaMensagemAcessoNegado()
	}

	@Then("é exibido o nomde do corretor correto")
	def validaNomdeDoCorretor(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaNomdeDoCorretor()
	}

	@Then("é exibida a tela '1. Cotação Auto'")
	def validaTelaCotaçãoAuto(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaTelaCotaçãoAuto()
	}

	@Given("que eu estou na  tela '1. Cotação Auto' verifico o layout dos campos na seguinte ordem")
	def verificarLayoutCotaCAoAuto(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificarLayoutCotacaoAuto(data)
	}

	@Then("é exibido o layout '1. Cotação Auto' corretamente")
	def exibirLayout(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutCotacaoAuto()
	}

	@Given("que eu estou na tela '1. Cotação Auto' NÃO preencho nenhum dos campos obrigatórios e aciono o botão 'Avançar'")
	def acionarbotaoAvançarSemPreencherCamposObrigatorios(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.botaoAvançar()
	}

	@Then("é exibida a mensagem: 'Obrigatório' para os campos")
	def validaMensagensDeCamposObrigatorios(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaMensagensDeCamposObrigatorios(data)
	}

	@Given("que eu estou na tela '1. Cotação Auto' verifico os campos default, são exibidos os campos na seguinte ordem:")
	def verificaCamposDefaultCotacaoAuto(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaCamposDefaultCotacaoAuto(data)
	}

	@Then("são exibidos os campos default corretamente")
	def validaCamposDefault(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaCamposDefault()
	}

	@Given("que estou na tela '1. Cotação Auto' informo todos os campos obrigatórios")
	def preencherCotacaoAuto(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.preencheCamposObrigatoriosCotacaoAutoUm(data)
	}

	@Then("é exibida a tela '2. Preço'")
	def validaTelaPreco(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaTelaPreco()
	}

	@Given("que leio a planilha de massa")
	def readFile(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.leituraMassa()
	}

	@Given("que eu estou na  tela '2. Preço' verifico o layout dos campos na seguinte ordem")
	def verificarLayoutPreco(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificarLayoutPreco(data)
	}

	@Then("é exibido o layout '2. Preço' corretamente")
	def exibirLayoutPreco(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutPreco()
	}

	@Given("que eu estou na  tela '2. Preço' verifico o campo default, é exibido o campo:")
	def validaCampoDefautComboFormaDePagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaCampoDefautComboFormaDePagamento(data)
	}

	@Then("é exibido o campo default corretamente em Forma de Pagamento.")
	def exibirCampoDefautComboFormaDePagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.campoDefautComboFormaDePagamento()
	}

	@Given("que eu estou na tela '2. Preço' clico na sessão 'Resumo dos dados'")
	def clicarNaSessãoResumoDosDados(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarNaSessãoResumoDosDados()
	}

	@Then("verifico o layout da sessão 'Resumo dos dados' são exibidos os campos na seguinte ordem:")
	def validaLayoutDaSessãoResumoDosDados(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutDaSessãoResumoDosDados(data)
	}

	@Then("é exibido o layout da sessão 'Resumo dos dados' corretamente")
	def exibirLayoutDaSessãoResumoDosDadosCorretamente(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutDaSessãoResumoDosDadosCorretamente()
	}

	@Given("que eu estou na tela '2. Preço' clico na sessão 'Edição de Cálculo'")
	def clicarNaSessãoEdiCAoDeCalculo(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarNaSessãoEdiCAoDeCalculo()
	}

	@When("verifico o layout da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:")
	def verificarLayoutSessãoEdicaoDeCalculo(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificarLayoutSessãoEdicaoDeCalculo(data)
	}

	@Then("é exibido o layout da sessão 'Edição de Cálculo' corretamente")
	def validarLayoutDaSessaoEdicaoDeCAlculo(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validarLayoutDaSessaoEdicaoDeCAlculo()
	}

	@Given("eu estou na tela '2. Preço' verifico os campos default da sessão 'Edição de Cálculo' são exibidos os campos na seguinte ordem:")
	def verificaCamposDefaultDaSessaoEdicaoDeCAlculo(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaCamposDefaultDaSessaoEdicaoDeCAlculo(data)
	}

	@Then("são exibidos os campos default da sessão 'Edição de Cálculo' corretamente")
	def validarCamposDefaultDaSessaoEdicaoDeCAlculo(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validarCamposDefaultDaSessaoEdicaoDeCAlculo()
	}

	@Given("que eu estou na tela '2. Preço' clico no ícone 'Salvar Cotação'")
	def clicarSalvarCotação(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarSalvarCotação(data)
	}

	@Then("é exibida a tela 'Salvar Cotação'")
	def validaTelaSalvarCotação(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaTelaSalvarCotação()
	}

	@Given("que eu estou na tela 'Salvar Cotação'  verifico o layout da tela 'Salvar Cotação' são exibidos os campos na seguinte ordem:")
	def verificaLayoutDaTelaSalvarCotação(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaLayoutDaTelaSalvarCotação(data)
	}

	@Then("é exibido o layout da tela 'Salvar Cotação' corretamente.")
	def validaLayoutDaTelaSalvarCotação(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutDaTelaSalvarCotação()
	}

	@Given("que eu estou na tela 'Salvar Cotação' verifico todos os 'Pacotes' disponíveis; Selecionados")
	def verificaPacotesdisponíveisSelecionados(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaPacotesdisponíveisSelecionados(data)
	}

	@Then("são exibidos os campos default da tela 'Salvar Cotação' corretamente.")
	def validaPacotesdisponíveisSelecionados(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaPacotesdisponíveisSelecionados()
	}

	@Given("que eu estou na tela '2. Preço' clico no botão 'Comprar' de um dos pacotes disponíveis:")
	def clicarNoBotãoComprar(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarNoBotãoComprar(data)
	}

	@Then("é exibida a tela '3.Pagamento'")
	def validaTelaPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.TelaPagamento()
	}

	@Given("que eu estou na tela '3. Pagamento' verifico o layout da tela 'Pagamento' com forma de pagamento 'Débito em conta bancária' são exibidos os campos na seguinte ordem:")
	def verificaLayoutTelaPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaLayoutTelaPagamento(data)
	}

	@Then("é exibido o layout da tela 'Pagamento Débito em conta bancária' corretamente.")
	def validaLayoutDaTelaPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutDaTelaPagamentoDebito()
	}

	@Given("que eu estou na tela '2. Preço' e altero a forma de pagamento")
	def alteraFormaDePagamentoDaTelaPreço(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.alteraFormaDePagamentoDaTelaPreço(data)
	}

	@And("clico no botão 'Comprar'")
	def clicaNoBotaoComprar(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicaNoBotaoComprar()
	}

	@Given("que eu estou na tela '3. Pagamento' verifico o layout da tela 'Pagamento' com forma de pagamento 'boleto bancário' são exibidos os campos na seguinte ordem:")
	def verificaLayoutTelaPagamentoBoleto(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaLayoutTelaPagamentoBoleto(data)
	}

	@Then("é exibido o layout da tela 'Pagamento com Boleto' corretamente.")
	def validaLayoutDaTelaPagamentoBoleto(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutDaTelaPagamentoBoleto()
	}

	@When("Quando clico no combo 'Renda mensal ', na tela '3. Pagamento' são exibidos as opções")
	def clicaNoComboRendaMensal(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicaNoComboRendaMensal()
	}

	@Given("que eu estou na tela '3. Pagamento'")
	def telaPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.telaPagamento(data)
	}

	@Given("que eu estou na tela '3. Pagamento' verifico as mensagens 'Obrigatório' para os campos")
	def telaPagamentoVerificaMensagemObrigatoria(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.telaPagamentoVerificaMensagemObrigatoria(data)
	}

	@Then("é exibida a mensagem 'Obrigatório' para os campos")
	def exibirMensagemObrigatório(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirMensagemObrigatório()
	}

	@And("os campos são destacados na tela '3. Pagamento'.")
	def camposSaoDestacadosNaTelaPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.camposSaoDestacadosNaTelaPagamento()
	}

	@Then("as informações são exibidas conforme esperado do combo 'Renda mensal'")
	def exibirInformacoesDoComboRendaMensal(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirInformacoesDoComboRendaMensal()
	}

	@And("não há duplicidade de informação no combo 'Renda mensal'")
	def verificaDuplicidade(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaDuplicidade()
	}

	@Given("que eu estou na tela '3. Pagamento' verifico os campos default exibidos os campos na seguinte ordem")
	def verificaCamposDefaultTelaPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaCamposDefaultTelaPagamento(data)
	}

	@Then("são exibidos os campos default da tela '3.Pagamento' corretamente")
	def exibirCamposDefault(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirCamposDefault()
	}

	@Given("que eu estou na tela '3. Pagamento' clico na sessão 'Resumo dos dados'")
	def clicarNaSessãoResumoDosDadosPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.clicarNaSessãoResumoDosDados()
	}

	@Then("verifico o layout da sessão 'Resumo dos dados' na tela '3. Pagamento' são exibidos os campos na seguinte ordem:")
	def validaLayoutDaSessãoResumoDosDadosPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validaLayoutDaSessãoResumoDosDados(data)
	}

	@Then("são exibidos os campos default 'Resumo dos dados' da tela '3.Pagamento' corretamente")
	def exibirLayoutDaSessãoResumoDosDadosCorretamentePagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutDaSessãoResumoDosDadosCorretamente()
	}

	@Given("que eu estou na tela '3. Pagamento' informo todos os campos obrigatórios")
	def informarTodosOsCamposObrigatóriosPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.informarTodosOsCamposObrigatóriosPagamento(data)
	}

	@When("aciono o botão 'Avançar'")
	def botãoAvançarPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.botãoAvançarPagamento()
	}

	@Then("é exibida a tela 'Confirmação de Pagamento'")
	def telaConfirmaçãoDePagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.telaConfirmaçãoDePagamento()
	}

	@Given("que eu estou na tela 'Confirmação de Pagamento'verifico se o layout da tela são exibidos os campos na seguinte ordem")
	def estouNaTelaConfirmaçãoDePagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.estouNaTelaConfirmaçãoDePagamento(data)
	}

	@Then ("é exibido o layout da tela 'Confirmação de Pagamento' corretamente")
	def exibirLayoutTelaConfirmaçãoPagamentoCorretamente(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutTelaConfirmaçãoPagamentoCorretamente()
	}

	@Given("que eu estou na tela 'Confirmação de Pagamento' verifico o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' são exibidos os campos na seguinte ordem")
	def verificaLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento(data)
	}

	@Then ("é exibido o layout das características do 'veículo' e 'condutor' da tela 'Confirmação de Pagamento' corretamente")
	def exibirLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutCaracterísticasDoVeiculoECondutorTelaConfirmaçãoPagamento()
	}

	@Given("que eu estou na tela 'Confirmação de Pagamento' verifico o layout das características do 'seguro' da tela 'Confirmação de Pagamento' são exibidos os campos na seguinte ordem")
	def verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.verificaLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(data)
	}

	@Then ("é exibido o layout das características do 'seguro' da tela 'Confirmação de Pagamento' corretamente")
	def exibirLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.exibirLayoutCaracteristicaDoSeguroTelaConfirmaçãoPagamento()
	}

	@Given("que estou na tela 'Confirmação de Pagamento'")
	def validatelaTelaConfirmaçãoDePagamento(DataTable data){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.validatelaTelaConfirmaçãoDePagamento(data)
	}
	
	@And('encerro a sessão')
	def encerrarSessao(){
		funcionalidadesAuto.ValidaLayoutFuncionalidades.encerraSessao()
	}
}