package auxiliares

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
import java.text.SimpleDateFormat

/**
 * @author T_DCDias
 * Classe responsável or receber um texto e extrair datas existentes. Exemplo : 'Vigência da apólice: 19/10/2018 à 19/10/2019'
 */

public class ExtractDates {

	/**
	 * @author T_DCDias
	 * @param text
	 * Método separa apenas nomeros e transforma em datas   
	 * @return
	 */
	public static Map getSubDates(String text){

		Map<Integer,String> hasdates = new HashMap<Integer, String>();
		StringBuffer sbf = new StringBuffer();

		String[] vars = text.split("")
		int positions = 0;

		for(int i = 0; i< vars.length;i++){
			if(vars[i].equals("0") || vars[i].equals("1") ||
			vars[i].equals("2")|| vars[i].equals("3")  ||
			vars[i].equals("4")|| vars[i].equals("5")  ||
			vars[i].equals("6")|| vars[i].equals("7")  ||
			vars[i].equals("8")|| vars[i].equals("9")) {
				sbf.append(vars[i].toString());
				positions++;
			}
		}

		int joker = positions/8;
		int split =positions/joker;

		System.err.println("\n--[ Data values [ "+sbf.toString()+" ] "
				+"Positions [ "+positions+" ] "
				+"Total of Dates [ "+joker+" ] "
				+"Length of Dates [ "+split+" ] ] --\n");

		String srtval = sbf.toString();
		int start=0;
		int end=8;
		for(int i = 0; i < joker; i++){
			hasdates.put(i, formatDate(srtval.toString().substring(start, end)));
			start = start+8;
			end = end+8;
		}
		return hasdates;
	}

	/**
	 * @author T_DCDias
	 * @param strdate
	 * Formata para o padrão data 'dd/MM/yyyy'
	 * @return
	 */
	public static String formatDate(String strdate) {
		String dateFormated;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Date data = sdf.parse(strdate);
		sdf.applyPattern("dd/MM/yyyy");
		String dataFormatada = sdf.format(data);
		return dataFormatada;
	}


	/**
	 * @author T_DCDias
	 * @param hours
	 * Extrai a hora de um texto
	 * @return
	 */
	public static int extractHours(String hours){
		int iHours
		StringBuffer sbf = new StringBuffer();
		String[] vars = hours.split("")
		for(int i = 0; i< vars.length ; i++){
			if(i ==26 || i == 27  ){
				sbf.append(vars[i].toString());
			}
		}
		iHours = Integer.parseInt(sbf.toString());
		return iHours
	}
}
