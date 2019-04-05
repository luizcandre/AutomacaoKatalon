package motosteps
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


class RadarLiveMoto {

	@Given('que acesso tela Home do sistema Moto, preencho campos obrigatórios da tela "1. Cotação Moto"')
	def abrirURL(DataTable data) {
		funcionalidadesMoto.RadarLiveFuncionalidadesMoto.lerDataTableMoto(data)
	}

	@Then('verifico se não existem diferenças no cálculo dos pacotes da tela "2. Preço" Moto')
	def preencherCamposObrigatoriosDaTelaPrecoMoto() {
		funcionalidadesMoto.RadarLiveFuncionalidadesMoto.preencherCamposObrigatoriosDaTelaPrecoMoto()
	}





	@Given('que eu estou na Home do sistema Moto')
	def acessaHomePage(DataTable data){
		funcionalidadesMoto.MotoFuncionalidades.acessaHomePageMoto(data)
	}

	@And('seleciono a opção Moto na Modal Nova Cotação')
	def selecionaOpcaoMoto(){
		funcionalidadesMoto.MotoFuncionalidades.selecionarOpcaoMoto()
	}

	@And('preencho todos os demais campos obrigatórios com dados válidos para moto')
	def preencheCamposObrigatorios(){
		funcionalidadesMoto.MotoFuncionalidades.preencheCamposObrigatoriosMoto()
	}

	@And('tela "2 preço" cotação moto é exeibida corretamente')
	def exibeTelaPrecoMoto(){
		funcionalidadesMoto.MotoFuncionalidades.exibeTelaPrecoMoto()
	}
}