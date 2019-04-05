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

String url = 'https://wwwi.br.intrallianz.com/drlf01/web/allianznet'

String sUsuario = 'ba919190'

String sSenha = 'Dxr1QqVWYO4f1hXm6pp8bQ=='

String cpfcnpj = '62543091149 '

String cep = '05570120'

String placa = 'EMV9613'

WebUI.openBrowser('');

WebUI.maximizeWindow();

WebUI.navigateToUrl('https://wwwi.br.intrallianz.com/drlf01/web/allianznet')

WebUI.setText(findTestObject('Page_Inicio/input_Usurio__58_login'), 'ba919190')

WebUI.setEncryptedText(findTestObject('Page_Inicio/input_Senha__58_password'), 'Dxr1QqVWYO4f1hXm6pp8bQ==')

 WebUI.click(findTestObject('Page_Inicio/button_Aceitar'))
 
 WebUI.click(findTestObject('null'))
 
 WebUI.click(findTestObject('Object Repository/Page_Home/span_Automvel'))
 
 WebUI.setText(findTestObject('Page_app/input_CPF ou CNPJ do segurado '), '625.430.911-49')

WebUI.click(findTestObject('Page_app/button_SELECIONE...'))
 
  WebUI.click(findTestObject('Page_app/span_Casadoa ou convive em uni'))
 
WebUI.selectOptionByValue(findTestObject('Page_app/select_SELECIONE...Casadoa ou '), '210', true)
 
WebUI.setText(findTestObject('Page_app/input_Placa do veculo_placa'), 'EMV9613')
 
WebUI.click(findTestObject('Page_app/div_1.0 8v(G2)(SilverFox)(Tota'))
 
//WebUI.click(findTestObject('Page_app/button_SELECIONE...'))
// 
//WebUI.click(findTestObject('Page_app/a_Casa'))
// 
//WebUI.selectOptionByValue(findTestObject('Page_app/select_SELECIONE...CasaCasa em'), '270', true)
 
WebUI.click(findTestObject('Page_app/span_Data de incio da vigncia '))
 
WebUI.click(findTestObject('Page_app/td_22'))
 
WebUI.click(findTestObject('Page_app/button_Avanar'))
 
WebUI.click(findTestObject('Page_app/span_'))
 
 
WebUI.closeBrowser()

