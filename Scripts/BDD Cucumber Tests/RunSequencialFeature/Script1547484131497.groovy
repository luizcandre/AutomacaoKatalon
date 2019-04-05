import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import groovy.lang.Closure


CucumberKW.runFeatureFolder('Include/features/Auto/CPF/CPFCNPJSegurado.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/CPF/CPFDoCondutor.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/DiaDePagamento/DiaDePagamento.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/Decodificador/Decodificador.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/Assistencia/Assistencia.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/TipoDeSeguro/TipoDeSeguro.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/Automovel/Automovel.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/FipeDeContratacao/FipeDeContratacao.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/VigenciaDoSeguro/VigenciaDoSeguro.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/DescontoComercialCAPComissao/DescontoComercialCAPComissao.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/VistoriaPrevia/VistoriaPrevia.feature')
CucumberKW.runFeatureFolder('Include/features/Auto/ValidaLayout/ValidaLayout.feature')