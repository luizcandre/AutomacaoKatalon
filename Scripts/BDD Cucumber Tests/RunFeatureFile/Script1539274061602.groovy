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

@RunWith(Cucumber.class)
@CucumberOptions(
	              features = { 
					           'Include/features/Auto/TipoDeSeguro/TipoDeSeguro.feature'
					           'Include/features/Auto/VigenciaDoSeguro/VigenciaDoSeguro.feature' 
							   'Include/features/Auto/Automovel/Automovel.feature'
							   'Include/features/Auto/FipeDeContratacao/FipeDeContratacao.feature'
							   'Include/features/Auto/DescontoComercialCAPComissao/DescontoComercialCAPComissao.feature'
							   'Include/features/Auto/Assistencia/Assistencia.feature'
							   'Include/features/Auto/Decodificador/Decodificador.feature'
							   'Include/features/Auto/DiaDePagamento/DiaDePagamento.feature'
							   'Include/features/Auto/VistoriaPrevia/VistoriaPrevia.feature'
							   'Include/features/Auto/ValidaLayout/ValidaLayout.feature'
							   'Include/features/Auto/CPF/CPFCNPJSegurado.feature'
							   'Include/features/Auto/CPF/CPFDoCondutor.feature'
							  },
				      glue = {''},
					  tags = {"@two"}
				)

     public class MyCucumberRunner {
}