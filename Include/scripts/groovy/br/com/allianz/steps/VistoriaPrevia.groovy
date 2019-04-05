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


class VistoriaPrevia {

	@And('preencho todos os campos obrigatórios com dados válidos')
	def preencheCamposObrigatorios(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.preencherCamposObrigatorios()
	}

	@Then('é exibida a mensagem: "Vistoria Prévia Presencial Obrigatória"')
	def validaMensagemDeAlerta(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.validaMensagemDeAlerta()
	}

	@And('é exibida a mensagem "Cobertura não permitida para Acessório - Blindagem"')
	def validaMensagemDeCoberturaDeBlindagem(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.validaMensagemDeCoberturaDeBlindagem()
	}

	@And('clico no botão "Sim" para a pergunta "Veículo possui blindagem"')
	def selecionarOpcaoDeBlindagemSim(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.selecionarOpcaoDeBlindagemSim()
	}

	@When('substituo a placa do veículo que não seja 0KM e tenha saído há menos de 3 dias')
	def substituirPlaca(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.substituiCampoPlaca()
	}

	@And('clico em uma opção para a pergunta "Forma de Pagamento"')
	def selecionaFormaDePagamento(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.selecionaFormaDePagamento()
	}

	@And('seleciono uma data com menos de 3 dias para a pergunta "Data de saída da nota fiscal do seu carro 0km" na tela "3.Preço"')
	def selecionarDataNF(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.selecionarDataNFInferiorDiaAtual()
	}

	@And('seleciono para "O veículo é 0 km" a opção "Sim"')
	def selecionaOpcaoSimCarroZero(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.selecionaCarroZeroOpcaoSim()
	}

	@And('clico no botão "Emitir"')
	def emitirApolice(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.emitirApolice()
	}

	@Then('é exibida a tela "3.Pagamento" com as informações de "Número da apólice" "Número da operação" com todos os arquivos para downloads')
	def validaInformacoesTelaPagamento(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.validaInformacoesTelaPagamento()
	}

	@And('informo um "número de CI"')
	def informarNumeroCI(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.informarNumeroCI()
	}

	@And('NÃO há necessidade de Vistoria Prévia')
	def vistoriaPrevia(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.vistoriaPrevia()
	}

	@And('informo os dados para a pergunta "Número da apólice anterior"')
	def informaNumeroApolice(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.informaNumeroApolice()
	}

	@And('informo os dados para a pergunta "Número da CI"')
	def informarNumeroCIAnterior(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.informarNumeroCIAnterior()
	}

	@And('informo uma data para a pergunta "Fim da vigência anterior"')
	def informarVigênciaAnterior(){
		funcionalidadesAuto.VistoriaPreviaFuncionalidades.informarVigênciaAnterior()
	}
}