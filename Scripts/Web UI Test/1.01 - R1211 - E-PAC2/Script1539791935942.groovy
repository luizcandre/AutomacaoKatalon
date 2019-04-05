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
import org.openqa.selenium.Keys as Keys
import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


'Logar'
WebUI.openBrowser('')
def driver = DriverFactory.getWebDriver()
String baseUrl = sURLEpacAceitacao
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open(sURLEpacAceitacao)
WebUI.setText(findTestObject('Page_Inicio/input_Usurio__58_login'), sUser)
WebUI.setEncryptedText(findTestObject('Page_Inicio/input_Senha__58_password'), sPasswd)
WebUI.click(findTestObject('Page_Inicio/button_Aceitar'))
WebUI.waitForPageLoad(30)


'Nova Cotação'
WebUI.click(findTestObject('Page_Home/button_Nova Cotao'))
WebUI.delay(3)
WebUI.click(findTestObject('Page_Home/div_Automvel'))
WebUI.waitForPageLoad(30)
WebUI.maximizeWindow()
WebUI.switchToFrame(findTestObject('Object Repository/Page_app/iframe_Incio_appArea'), 30)
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'),30)
'Segurado'
WebUI.setText(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), "62543091149 ")
WebUI.sendKeys(findTestObject('Object Repository/Page_app/input_CPF ou CNPJ do segurado'), Keys.chord(Keys.TAB))

def sCep = WebUI.getAttribute(findTestObject('Object Repository/Page_app/CEP'), 'text')

if (sCep.toString() == "null") {
    sCep = "05570120"
	WebUI.setText(findTestObject('Object Repository/Page_app/CEP'),sCep) 
	WebUI.sendKeys(findTestObject('Object Repository/Page_app/CEP'), Keys.chord(Keys.TAB))
	WebUI.delay(2)
}

'Combo Estado Civil'

WebUI.delay(5)
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Estado civil do condutor:'])[1]/following::span[1]")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='[SELECIONE...]'])[6]/following::span[2]")
selenium.select("id=comboCivilEstado", "label=Casado[a] ou convive em união estável")
'Placa do Veiculo'
WebUI.setText(findTestObject('Page_app/input_Placa do veculo_placa'), "EMV9613")
WebUI.sendKeys(findTestObject('Object Repository/Page_app/CEP'), Keys.chord(Keys.TAB))
WebUI.delay(2)
WebUI.click(findTestObject('Page_app/div_1.0 8v(G2)(SilverFox)(Tota'))
WebUI.delay(2)
'Tipo Residência'
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='[SELECIONE...]'])[13]/following::span[2]")
selenium.click("link=Casa")
selenium.select("id=valorResideEm", "label=Casa")

WebUI.click(findTestObject('Page_app/button_Avanar'))
WebUI.delay(3)

'Validar e Redigitar CEP - Artificio' 
WebUI.focus(findTestObject('Object Repository/Page_app/CEP'))
WebUI.setText(findTestObject('Object Repository/Page_app/CEP'),sCep)
WebUI.sendKeys(findTestObject('Object Repository/Page_app/CEP'), Keys.chord(Keys.TAB))
WebUI.delay(2)
WebUI.click(findTestObject('Page_app/button_Avanar'))
WebUI.waitForPageLoad(30)


WebUI.click(findTestObject('Page_app/div_AlertaVistoria Prvia Prese'))

WebUI.doubleClick(findTestObject('Page_app/label_Vigncia da aplice 021020'))


