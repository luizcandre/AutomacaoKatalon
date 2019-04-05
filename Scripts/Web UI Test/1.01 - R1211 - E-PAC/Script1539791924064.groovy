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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.openqa.selenium.Keys as Keys

'Iniciar Navegador'
WebUI.openBrowser('')

'Instanciar Selenium'
def driver = DriverFactory.getWebDriver()
String baseUrl = sURL
seleni um = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(baseUrl)
WebUI.maximizeWindow()
CustomKeywords.'br.com.intrallianz.common.LogarIntranet'(sUser, sPasswd)

'Logar'
WebUI.setText(findTestObject('Object Repository/Page_Inicio/input_Usurio__58_login'), sUsuario)
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Inicio/input_Senha__58_password'), sSenha)
WebUI.click(findTestObject('Object Repository/Page_Inicio/button_Aceitar'))
WebUI.waitForPageLoad(30)


'Selecionar Automovel'
WebUI.click(findTestObject('Object Repository/Page_Home/button_Nova Cotao'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Page_Home/div_Automvel'))
WebUI.delay(2)

'Carregar Iframe'
selenium.selectFrame('index=2')
WebUI.waitForPageLoad(30)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'),30)

'Navegar'
WebUI.setText(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), '62543091149 ')
WebUI.sendKeys(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), Keys.chord(Keys.TAB))
WebUI.click(findTestObject('Object Repository/Page_app/span_SELECIONE..._caret'))
WebUI.click(findTestObject('null'))
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_app/select_SELECIONE...Casadoa ou'), '210', true)
WebUI.setText(findTestObject('Object Repository/Page_app/input_Placa do veculo_placa'), 'EMV9613' )
WebUI.click(findTestObject('Object Repository/Page_app/div_1.0 8v(G2)(SilverFox)(Tota'))
WebUI.click(findTestObject('Object Repository/Page_app/button_SELECIONE...'))
WebUI.click(findTestObject('Object Repository/Page_app/a_Casa'))
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_app/select_SELECIONE...CasaCasa em'), '270', true)
WebUI.click(findTestObject('Object Repository/Page_app/i_Data de incio da vigncia do'))
WebUI.click(findTestObject('Object Repository/Page_app/th_'))
WebUI.click(findTestObject('Object Repository/Page_app/td_28'))
WebUI.click(findTestObject('Object Repository/Page_app/button_Avanar'))
WebUI.click(findTestObject('Object Repository/Page_app/label_Vigncia da aplice 281020'))



WebUI.closeBrowser()

