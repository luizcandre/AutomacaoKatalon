package sendEmail

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CreateEmail {

	//private static String sender = 'denilson.dias@inmetric.com.br'
	//private static String sender = 'renovacaosantander@allianz.com.br'
	//private static String sender = 'dj.denilson@gmail.com'
	private static String sender = 'denilson.inmetricsext@allpronet.com.br'


	private static String pwdsender = 'be54955'

	//private static String emaildestination = 'denilson.inmetricsext@allpronet.com.br'
	private static String emaildestination = 'denilson.inmetricsext@allpronet.com.br'
	//private static String emaildestination = 'andre.antunes@allianz.com.br'






	private static String subject ='TESTE QA'
	private static String messagebody = 'Teste de envio de mensagem peo robo QA'


	public static createEmail(){
		try{
			ConfigOutlook configOutlook = new ConfigOutlook()
			MessageFactory messageFactory = new MessageFactory(sender,pwdsender,emaildestination,subject,messagebody)
			messageFactory.createMessage(configOutlook.configureOutLook() )
			//messageFactory.createMessage(configOutlook.configureGMail() )
		} catch(Exception e){
			System.err.println("\n"+e)
		}
	}
}
