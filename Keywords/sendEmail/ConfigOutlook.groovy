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
import java.security.Security;

public class ConfigOutlook {

	public static Properties configureOutLook(){

		Properties propers = new Properties()
//		propers.setProperty("proxySet","true");
//		propers.setProperty("http.proxyHost","prxazb.allianz.com.br");
//		propers.setProperty("http.proxyPort","8080");
		
		propers.put("mail.smtp.EnableSSL.enable", "true");
		propers.put("mail.smtp.auth", "true")
		propers.put("mail.smtp.starttls.enable", "true")
		//propers.put("mail.smtp.host", "smtpe.intrallianz.es")
		propers.put("mail.smtp.host", "outlook.office365.com")
		propers.put("mail.smtp.port", "587")

		return propers
	}
	
	
	public static Properties configureGMail(){
//	   Properties propers = new Properties()
//	   propers.put("mail.smtp.host", "smtp.gmail.com")
//	   propers.put("mail.smtp.socketFactory.port", "465")
//	   propers.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
//	   propers.put("mail.smtp.auth", "true")
//	   propers.put("mail.smtp.port", "465")
//	   propers.put("mail.smtp.starttls.enable", "true");
//
//	   propers.setProperty("proxySet","true");
//	   propers.setProperty("http.proxyHost","prxazb.allianz.com.br");
//	   propers.setProperty("http.proxyPort","8080");
		
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		 props.setProperty("proxySet","true");
		 props.setProperty("socksProxyHost","prxazb.allianz.com.br");
		 props.setProperty("socksProxyPort","8080");
		 props.setProperty("mail.smtp.host", "smtp.gmail.com");
		 props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		 props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 props.setProperty("mail.smtp.port", "465");
		 props.setProperty("mail.smtp.socketFactory.port", "465");
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.debug", "true");
		 props.put("mail.store.protocol", "pop3");
		 props.put("mail.transport.protocol", "smtp");
	   
	   return props
	}
}
