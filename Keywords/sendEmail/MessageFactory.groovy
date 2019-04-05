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
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException

import internal.GlobalVariable
import javax.mail.Address
import javax.mail.Message
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


public class MessageFactory extends ConfigParameters{

	public MessageFactory(String sender, String pwrsender, String emaildestination, String subject, String messagebory){
		this.sender = sender;
		this.pwrsender = pwrsender;
		this.emaildestination = emaildestination;
		this.subject = subject;
		this.messagebory = messagebory;
	}


	public void createMessage(Properties config){

		try{

			ConfigOutlook configOutlook = new ConfigOutlook()
			Sessions sessions = new Sessions()
			Message message = new MimeMessage(sessions.create(sender, pwrsender, config))
			message.setFrom(new InternetAddress(sender))

			Address[] toUser = InternetAddress.parse(emaildestination)

			message.setRecipients(Message.RecipientType.TO, toUser)
			message.setSubject(subject)
			message.setText(messagebory)

			Transport.send(message)
			System.err.println("Feito !")
		} catch (MessagingException e){
			throw new RuntimeException()
		}
	}
}
