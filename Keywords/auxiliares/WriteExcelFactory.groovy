package auxiliares

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import bean.CasoDeTeste
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
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.stringtemplate.v4.compiler.STParser.ifstat_return
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


public class WriteExcelFactory extends FileInput{


	private static List<String> resultWriteExcel


	/**
	 * @author Denilson Costa Dias 
	 * Retorna valores da linha selecionada
	 */
	public static List<String> WriteExcel(String path, Integer line){
		List<String> Excelvalues = new ArrayList<String>();
		File xlsx = new File(path);
		FileInputStream file = new FileInputStream (xlsx)
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Integer LeftCol = sheet.getLeftCol()
		XSSFRow rw = sheet.getRow(line)
		for (int i = 0; i <= LeftCol; i++ ){
			if(rw.getCell(i)!=null) {
				Excelvalues.add(rw.getCell(i));
			}
		}
		file.close();
		return Excelvalues;
	}

	/**
	 * @author T_DCDias
	 * Imprime o resultado da leitura
	 * @return
	 */
	public static resultadoExel(){
		resultWriteExcel = WriteExcel("C://Users//Public//QA_ALLIANZ//MassaAuto//MassaAutoAllianz.xlsx", 1)
		System.err.println("WriteExcel Result :"+resultWriteExcel.size())
		for(int i = 0; i < resultWriteExcel.size(); i++){
			System.err.println("WriteExcel :"+ resultWriteExcel[i].toString())
		}
	}




	/**
	 * @author T_DCDias
	 * @param caminho_arquivo_xlsx
	 * @param ct
	 * @return
	 * @throws IOException
	 */
	public static CasoDeTeste readingSheet(String caminho_arquivo_xlsx, String ct) throws IOException {

		Iterator<?> rowItr = null;
		CellValidation cellValidation = null;
		XSSFSGetrow xssfsgetrow = null;
		CasoDeTeste casodeteste = null
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput(caminho_arquivo_xlsx));
			XSSFSheet sheet = workbook.getSheetAt(0);
			rowItr = sheet.rowIterator();
			xssfsgetrow = new XSSFSGetrow();
			XSSFRow rw = sheet.getRow(xssfsgetrow.getrow(rowItr,ct));
			casodeteste = new CasoDeTeste();
			cellValidation = new CellValidation();

			if( rw.getCell(0) != null || rw.getCell(0) == null ){
				casodeteste.setCt(cellValidation.cellValidation(rw.getCell(0)));
			}
			if( rw.getCell(1) != null || rw.getCell(1) == null ){
				casodeteste.setUsuario(cellValidation.cellValidation(rw.getCell(1)));
			}
			if( rw.getCell(2) != null || rw.getCell(2) == null ){
				casodeteste.setSenha(cellValidation.cellValidation(rw.getCell(2)));
			}
			if( rw.getCell(3) != null || rw.getCell(3) == null ){
				casodeteste.setUsuario2(cellValidation.cellValidation(rw.getCell(3)));
			}
			if( rw.getCell(4) != null || rw.getCell(4) == null ){
				casodeteste.setSenha2(cellValidation.cellValidation(rw.getCell(4)));
			}
			if( rw.getCell(5) != null || rw.getCell(5) == null ){
				casodeteste.setClasseDeBonus(cellValidation.cellValidation(rw.getCell(5)));
			}
			if( rw.getCell(6) != null || rw.getCell(6) == null ){
				casodeteste.setNumeroci(cellValidation.cellValidation(rw.getCell(6)));
			}
			if( rw.getCell(7) != null || rw.getCell(7) == null ){
				casodeteste.setCpfcnpj(cellValidation.cellValidation(rw.getCell(7)));
			}
			if( rw.getCell(8) != null || rw.getCell(8) == null ){
				casodeteste.setCep(cellValidation.cellValidation(rw.getCell(8)));
			}
			if( rw.getCell(9) != null || rw.getCell(9) == null ){
				casodeteste.setCotacao(cellValidation.cellValidation(rw.getCell(9)));
			}
			if( rw.getCell(10) != null || rw.getCell(10) == null ){
				casodeteste.setNumCpfCondutor(cellValidation.cellValidation(rw.getCell(10)));
			}
			if( rw.getCell(11) != null || rw.getCell(11) == null ){
				casodeteste.setEstadoCivil(cellValidation.cellValidation(rw.getCell(11)));
			}
			if( rw.getCell(12) != null || rw.getCell(12) == null ){
				casodeteste.setPlaca(cellValidation.cellValidation(rw.getCell(12)));
			}
			if( rw.getCell(13) != null || rw.getCell(13) == null ){
				casodeteste.setChassis(cellValidation.cellValidation(rw.getCell(13)));
			}


			if( rw.getCell(15) != null || rw.getCell(15) == null ){
				casodeteste.setBlindagem(cellValidation.cellValidation(rw.getCell(15)));
			}
			if( rw.getCell(16) != null || rw.getCell(16) == null ){
				casodeteste.setResidenciaCondutor(cellValidation.cellValidation(rw.getCell(16)));
			}
			if( rw.getCell(17) != null || rw.getCell(17) == null ){
				casodeteste.setNomeCpfCondutor(cellValidation.cellValidation(rw.getCell(17)));
			}




			if( rw.getCell(34) != null || rw.getCell(34) == null ){
				casodeteste.setApolice(cellValidation.cellValidation(rw.getCell(34)));
			}



			if( rw.getCell(42) != null || rw.getCell(42) == null ){
				casodeteste.setExecutar(cellValidation.cellValidation(rw.getCell(42)));
			}


			closeFileInputStream();
			workbook.finalize()
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return casodeteste;
	}


	/**
	 * @author T_DCDias
	 * @param caminho_arquivo_xlsx
	 * @param ct
	 * @throws IOException
	 * Salvar evidência no arquivo xlsx
	 */
	public static void updateSheet(String caminho_arquivo_xlsx, String ct, String msg, int numCell) throws IOException{
		println("\nUpdate Cell ["+numCell+"] ["+ct+"] ["+msg+"]")
		Iterator<?> rowItr = null;
		Iterator<?> rowItr2 = null;
		CellValidation cellValidation = null;
		XSSFSGetrow xssfsgetrow = null;
		XSSFSGetrow xssfsgetrow2 = null;
		XSSFSGetrow xssfsgetrowmessage = null;
		Cell cell= null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput(caminho_arquivo_xlsx));
			XSSFSheet sheet = workbook.getSheetAt(0);
			rowItr = sheet.rowIterator()
			xssfsgetrow = new XSSFSGetrow()
			xssfsgetrow.setrow(rowItr,ct,msg,numCell)
			FileOutputStream outFile = new FileOutputStream(new File(caminho_arquivo_xlsx));
			workbook.write(outFile)
			workbook.finalize()
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			commands.AutoComandos.finalizar()
		}
	}


	/**
	 * @author T_DCDias
	 * @param caminho_arquivo_xlsx
	 * @param ct
	 * @throws IOException
	 * Salvar evidência no arquivo xlsx
	 */
	public static void updateSheetLine(int rowNum, String caminho_arquivo_xlsx, String msg, int numCell) throws IOException{
		println("\nUpdate Cell ["+numCell+"] ["+msg+"]")
		Iterator<?> rowItr = null;
		Iterator<?> rowItr2 = null;
		CellValidation cellValidation = null;
		XSSFSGetrow xssfsgetrow = null;
		XSSFSGetrow xssfsgetrow2 = null;
		XSSFSGetrow xssfsgetrowmessage = null;
		Cell cell= null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput(caminho_arquivo_xlsx));
			XSSFSheet sheet = workbook.getSheetAt(0);
			rowItr = sheet.rowIterator()
			xssfsgetrow = new XSSFSGetrow()
			xssfsgetrow.setrowLine(rowItr,msg,numCell,rowNum)
			FileOutputStream outFile = new FileOutputStream(new File(caminho_arquivo_xlsx));
			workbook.write(outFile)
			workbook.finalize()
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			commands.AutoComandos.finalizar()
		}
	}


	public static List<CasoDeTeste> readExcelFileToArray(String caminho_arquivo_xlsx){

		List<CasoDeTeste> listCasoDeTeste = new ArrayList<CasoDeTeste>()
		XSSFWorkbook workbook = null;
		Iterator<?> rowIterator = null;
		try {
			workbook = new XSSFWorkbook(fileInput(caminho_arquivo_xlsx));
			XSSFSheet sheet = workbook.getSheetAt(0);
			rowIterator = sheet.rowIterator();
			while ( rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				if (row.getRowNum() == 0) {
					continue;
				}
				Iterator<?> cellIterator = row.cellIterator();
				CasoDeTeste casodeteste = new CasoDeTeste();
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					switch (cell.getColumnIndex()) {
						case 0:
							casodeteste.setCt(cell.getStringCellValue());
							break;
						case 1:
							casodeteste.setUsuario(cell.getStringCellValue());
							break;
						case 2:
							casodeteste.setSenha(cell.getStringCellValue());
							break;
						case 3:
							casodeteste.setUsuario2(cell.getStringCellValue());
							break;
						case 4:
							casodeteste.setSenha2(cell.getStringCellValue());
							break;
						case 5:
							casodeteste.setClasseDeBonus(cell.getStringCellValue());
							break;
						case 6:
							casodeteste.setNumeroci(cell.getStringCellValue());
							break;
						case 7:
							casodeteste.setCpfcnpj(cell.getStringCellValue());
							break;
						case 8:
							casodeteste.setCep(cell.getStringCellValue());
							break;
						case 9:
							casodeteste.setCotacao(cell.getStringCellValue());
							break;
						case 10:
							casodeteste.setNumCpfCondutor(cell.getStringCellValue());
							break;
						case 11:
							casodeteste.setEstadoCivil(cell.getStringCellValue());
							break;
						case 12:
							casodeteste.setPlaca(cell.getStringCellValue());
							break;
						case 13:
							casodeteste.setChassis(cell.getStringCellValue());
							break;

						case 15:
							casodeteste.setBlindagem(cell.getStringCellValue());
							break;
						case 16:
							casodeteste.setResidenciaCondutor(cell.getStringCellValue());
							break;
						case 17:
							casodeteste.setNomeCpfCondutor(cell.getStringCellValue());
							break;

						case 34:
							casodeteste.setApolice(cell.getStringCellValue());
							break;

						case 42:
							casodeteste.setExecutar(cell.getStringCellValue());
							break;
					}
				}
				listCasoDeTeste.add(casodeteste);
			}
			closeFileInputStream();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listCasoDeTeste
	}



	public static List<CasoDeTeste> readExcelFileToObjectCasoDeTeste(String caminho_arquivo_xlsx){

		List<CasoDeTeste> listCasoDeTeste = new ArrayList<CasoDeTeste>();
		String filePath = caminho_arquivo_xlsx;
		try{
			// Abrindo o arquivo e recuperando a planilha
			FileInputStream file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<?> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				// Descantando a primeira linha com o header
				if (row.getRowNum() == 0) {
					continue;
				}
				Iterator<?> cellIterator = row.cellIterator();
				CasoDeTeste casoDeTeste = new CasoDeTeste();

				while (cellIterator.hasNext()) {

					Cell cell = (Cell) cellIterator.next();
					cell.setCellType(cell.CELL_TYPE_STRING);

					switch (cell.getColumnIndex()) {
						case 0:
							casoDeTeste.setUsuario(cell.getStringCellValue());
							break;
						case 1:
							casoDeTeste.setParceiro(cell.getStringCellValue());
							break;
						case 2:
							casoDeTeste.setMediador(cell.getStringCellValue());
							break;
						case 3:
							casoDeTeste.setIsentoIOF(cell.getStringCellValue());
							break;
						case 4:
							casoDeTeste.setDataInicio(cell.getStringCellValue());
							break;
						case 5:
							casoDeTeste.setPercentualComissao(cell.getStringCellValue());
							break;
						case 6:
							casoDeTeste.setPercentualDesconto(cell.getStringCellValue());
							break;
						case 7:
							casoDeTeste.setNomeTomador(cell.getStringCellValue());
							break;
						case 8:
							casoDeTeste.setDocumentoTomador(cell.getStringCellValue());
							break;
						case 9:
							casoDeTeste.setNomeCondutor(cell.getStringCellValue());
							break;
						case 10:
							casoDeTeste.setDocumentoCondutor(cell.getStringCellValue());
							break;
						case 11:
							casoDeTeste.setDataNascimento(cell.getStringCellValue());
							break;
						case 12:
							casoDeTeste.setChassi(cell.getStringCellValue());
							break;
						case 13:
							casoDeTeste.setAnoModelo(cell.getStringCellValue());
							break;
						case 14:
							casoDeTeste.setIsVeiculoUsado(cell.getStringCellValue());
							break;
						case 15:
							casoDeTeste.setPlaca(cell.getStringCellValue());
							break;

						case 16:
							casoDeTeste.setCodigoMarcaModelo(cell.getStringCellValue());
							break;
						case 17:
							casoDeTeste.setCodigoFipe(cell.getStringCellValue());
							break;
						case 18:
							casoDeTeste.setPercentualFipe(cell.getStringCellValue());
							break;
						case 19:
							casoDeTeste.setCepPernoite(cell.getStringCellValue());
							break;
						case 20:
							casoDeTeste.setTipoFranquia(cell.getStringCellValue());
							break;
						case 21:
							casoDeTeste.setDispositivoAtual(cell.getStringCellValue());
							break;
						case 22:
							casoDeTeste.setVeiculoBlindado(cell.getStringCellValue());
							break;
						case 23:
							casoDeTeste.setDespesasExtraordinarias(cell.getStringCellValue());
							break;
						case 24:
							casoDeTeste.setCategoriaRisco(cell.getStringCellValue());
							break;
						case 25:
							casoDeTeste.setSexo(cell.getStringCellValue());
							break;
						case 26:
							casoDeTeste.setEstadoCivil(cell.getStringCellValue());
							break;
						case 27:
							casoDeTeste.setTempoHabilitacao(cell.getStringCellValue());
							break;
						case 28:
							casoDeTeste.setExisteMenor25anos(cell.getStringCellValue());
							break;
						case 29:
							casoDeTeste.setGaragemFaculdade(cell.getStringCellValue());
							break;
						case 30:
							casoDeTeste.setGaragemResidencia(cell.getStringCellValue());
							break;
						case 31:
							casoDeTeste.setGaragemTrabalho(cell.getStringCellValue());
							break;
						case 32:
							casoDeTeste.setCondutorPrincipalResideEm(cell.getStringCellValue());
							break;
					}


				}
				listCasoDeTeste.add(casoDeTeste);
			}


			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//listCasoDeTeste.remove(0);
		return listCasoDeTeste;
	}




	public static List<CasoDeTeste> readExcelFileToObjectCasoDeTesteRenovaSeguro(String caminho_arquivo_xlsx){

		List<CasoDeTeste> listCasoDeTeste = new ArrayList<CasoDeTeste>();
		String filePath = caminho_arquivo_xlsx;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dataAtual = format.format(new Date());

		try{
			// Abrindo o arquivo e recuperando a planilha
			FileInputStream file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("1211 - SN - Usado");
			Iterator<?> rowIterator = sheet.rowIterator();
			while (rowIterator.hasNext()) {
				Row row = (Row) rowIterator.next();
				// Descantando a primeira linha com o header
				if (row.getRowNum() == 0) {
					continue;
				}
				// Descantando a primeira linha com o header
				if (row.getCell(1).getStringCellValue().contentEquals("Impedido")) {
					continue;
				}
				Iterator<?> cellIterator = row.cellIterator();
				CasoDeTeste casoDeTeste = new CasoDeTeste();

				// Valores Fixos
				casoDeTeste.setUsuario("BA262880");
				casoDeTeste.setParceiro("BP002617");
				casoDeTeste.setMediador("0617120");
				//casoDeTeste.setIsentoIOF("false");
				casoDeTeste.setDataInicio(dataAtual);
				casoDeTeste.setNomeTomador("ROBO TOMADOR");
				casoDeTeste.setNomeCondutor("ROBO CONDUTOR");
				casoDeTeste.setDataNascimento("1974-06-18");
				casoDeTeste.setTipoFranquia("REDUZIDA");
				casoDeTeste.setDispositivoAtual("200");
				casoDeTeste.setDespesasExtraordinarias("false");
				casoDeTeste.setTempoHabilitacao("941");
				casoDeTeste.setGaragemFaculdade("250");
				casoDeTeste.setGaragemResidencia("232");
				casoDeTeste.setGaragemTrabalho("240");

				while (cellIterator.hasNext()) {

					Cell cell = (Cell) cellIterator.next();
					cell.setCellType(cell.CELL_TYPE_STRING);

					switch (cell.getColumnIndex()) {
						case 0:
							casoDeTeste.setCt(cell.getStringCellValue());
							break;
						case 2:
							casoDeTeste.setDescricaoCasoDeTeste(cell.getStringCellValue());
							break;
						case 5:
							casoDeTeste.setDocumentoTomador(cell.getStringCellValue());
							break;
						case 6:
							casoDeTeste.setSexo(cell.getStringCellValue());
							break;
						case 7:
							casoDeTeste.setCepPernoite(cell.getStringCellValue());
							break;
						case 8:
							if(cell.getStringCellValue().trim().equals("SIM")) {
								casoDeTeste.setDocumentoCondutor(casoDeTeste.getDocumentoTomador());
							}else {
								casoDeTeste.setDocumentoCondutor(cell.getStringCellValue());
							}
							break;
						case 9:
							casoDeTeste.setEstadoCivil(cell.getStringCellValue());
							break;
						case 10:
							casoDeTeste.setChassi(cell.getStringCellValue());
							break;
						case 11:
							casoDeTeste.setPlaca(cell.getStringCellValue());
							break;
						case 12:
							casoDeTeste.setAnoModelo(cell.getStringCellValue());
							break;
						case 13:
							casoDeTeste.setCodigoMarcaModelo(cell.getStringCellValue());
							break;
						case 14:
							casoDeTeste.setCodigoFipe(cell.getStringCellValue());
							break;
						case 15:
							casoDeTeste.setCategoriaRisco(cell.getStringCellValue());
							break;
						case 16:
							casoDeTeste.setIsVeiculoUsado(String.valueOf(cell.getStringCellValue().contentEquals("NÃO")));
							break;
						case 17:
							casoDeTeste.setVeiculoBlindado(String.valueOf(cell.getStringCellValue().contentEquals("SIM")));
							break;
						case 18:
							casoDeTeste.setExisteMenor25anos(cell.getStringCellValue());
							break;
						case 19:
							casoDeTeste.setCondutorPrincipalResideEm(cell.getStringCellValue());
							break;
						case 22:
							casoDeTeste.setPercentualDesconto(cell.getStringCellValue());
							break;
						case 23:
							casoDeTeste.setPercentualAgravo(cell.getStringCellValue());
							break;
						case 24:
							casoDeTeste.setPercentualComissao(cell.getStringCellValue());
							break;
						case 25:
							casoDeTeste.setPercentualFipe(cell.getStringCellValue());
							break;
						case 27:
							casoDeTeste.setFormaDePagamento(cell.getStringCellValue().trim());
							break;
						case 28:
							casoDeTeste.setParcela(cell.getStringCellValue().trim());
							break;
						case 29:
							casoDeTeste.setIsentoIOF(cell.getStringCellValue().trim());
							break;
					}



				}
				listCasoDeTeste.add(casoDeTeste);
			}


			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//listCasoDeTeste.remove(0);
		return listCasoDeTeste;
	}



	public static testaMetodo(){
		updateSheetLine(116, "C://Users//Public//QA_ALLIANZ//MassaAuto//MassaAutoAllianz.xlsx", "TEST CELL VALUE", 40)
	}
}




