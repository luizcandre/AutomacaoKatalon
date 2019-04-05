﻿package auxiliares

import java.text.SimpleDateFormat

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import bean.CasoDeTeste
import bean.Pacote



public class GeneratorPDF {

	private static Font blackFont = new Font(Font.FontFamily.HELVETICA, 8,Font.BOLD, BaseColor.BLACK);
	private static Font smallList = new Font(Font.FontFamily.HELVETICA, 7);
	private static Font smallListBlack = new Font(Font.FontFamily.HELVETICA, 6);
	private static Font smallBoldBlack = new Font(Font.FontFamily.HELVETICA, 6,Font.BOLD);
	private static Font blueFont = new Font(Font.FontFamily.HELVETICA, 8,Font.BOLD, BaseColor.BLUE);
	private static Font blueFontSmall = new Font(Font.FontFamily.HELVETICA, 6,Font.BOLD, BaseColor.BLUE);
	private static Font whiteFontSmall = new Font(Font.FontFamily.HELVETICA, 6,Font.BOLD, BaseColor.WHITE);
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL, BaseColor.RED);
	private static Font greenFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.NORMAL, BaseColor.GREEN);
	private static Font smmallRedFont = new Font(Font.FontFamily.HELVETICA, 6,Font.NORMAL, BaseColor.RED);
	private static Font smmallGreenFont = new Font(Font.FontFamily.HELVETICA, 6,Font.NORMAL, BaseColor.GREEN);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
	private static Font small = new Font(Font.FontFamily.TIMES_ROMAN, 10);
	private static Font smallEvidence = new Font(Font.FontFamily.TIMES_ROMAN, 9);
	private static StringBuffer strbffr
	private static Document document
	protected static nomePDF
	private static int noPages = 2
	protected static fabrica = 'Inmetrics'
	protected static testador = 'Automação'
	protected static projeto = "Quality Assurance"
	protected static codigoProjeto = "BDM-1169"
	def x = 'anish\044'


	/**
	 * @author Luiz André
	 * @param pacote1
	 * @param pacote2
	 * @return
	 *
	 * Cria a evidencia em PDF para o projeto RadarLive com formatação de fonte e cores
	 */

	public static evidenciaRadarLive(Object pacote1, Object pacote2, int teste, String cenario){

		try{
			CasoDeTeste validacao1 = pacote1;
			CasoDeTeste validacao2 = pacote2;

			adicionaCenario(validacao2.getStatus(), cenario+" - Execução "+teste )

			PdfPTable table = new PdfPTable(7);
			table.setHeaderRows(1);
			table.getDefaultCell().setBorder(1)

			table.setHorizontalAlignment(Element.ALIGN_CENTER)
			table.addCell(new Paragraph("Corretor", blueFont))
			table.addCell(new Paragraph("Ampliado 2", blueFont))
			table.addCell(new Paragraph("Compacto 1", blueFont))
			table.addCell(new Paragraph("Compacto 2", blueFont))
			table.addCell(new Paragraph("Ampliado 1", blueFont))
			table.addCell(new Paragraph("Especial ", blueFont))
			table.addCell(new Paragraph("Exclusivo ", blueFont))

			table.addCell(new Paragraph(validacao1.getUsuario(), blackFont))
			table.addCell(new Paragraph(validacao1.getPacoteAmpliado2(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteCompacto1(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteCompacto2(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteAmpliado1(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteEspecial(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteExclusivo(),smallList))

			table.addCell(new Paragraph(validacao2.getUsuario2(), blackFont))
			table.addCell(new Paragraph(validacao2.getPacoteAmpliado2(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteCompacto1(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteCompacto2(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteAmpliado1(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteEspecial(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteExclusivo(),smallList))


			document.add(table);
		} catch (Exception e) {
			System.err.println("evidenciaRadarLive - Falha na geração de evidência ["+e+"]")
			commands.AutoComandos.finalizar()
		}
	}


	public static evidenciaRadarLiveMoto(Object pacote1, Object pacote2, int teste, String cenario){

		try{
			CasoDeTeste validacao1 = pacote1;
			CasoDeTeste validacao2 = pacote2;

			adicionaCenario(validacao2.getStatus(), cenario+" - Execução "+teste )

			PdfPTable table = new PdfPTable(6);
			table.setHeaderRows(1);
			table.getDefaultCell().setBorder(1)

			table.setHorizontalAlignment(Element.ALIGN_CENTER)
			table.addCell(new Paragraph("Corretor", blueFont))
			table.addCell(new Paragraph("Ampliado 2", blueFont))
			table.addCell(new Paragraph("Compacto 1", blueFont))
			table.addCell(new Paragraph("Compacto 2", blueFont))
			table.addCell(new Paragraph("Ampliado 1", blueFont))
			//table.addCell(new Paragraph("Especial ", blueFont))
			table.addCell(new Paragraph("Exclusivo ", blueFont))

			table.addCell(new Paragraph(validacao1.getUsuario(), blackFont))
			table.addCell(new Paragraph(validacao1.getPacoteAmpliado2(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteCompacto1(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteCompacto2(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteAmpliado1(),smallList))
			table.addCell(new Paragraph(validacao1.getPacoteExclusivo(),smallList))

			table.addCell(new Paragraph(validacao2.getUsuario2(), blackFont))
			table.addCell(new Paragraph(validacao2.getPacoteAmpliado2(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteCompacto1(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteCompacto2(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteAmpliado1(),smallList))
			table.addCell(new Paragraph(validacao2.getPacoteExclusivo(),smallList))


			document.add(table);
		} catch (Exception e) {
			System.err.println("evidenciaRadarLive - Falha na geração de evidência ["+e+"]")
			commands.AutoComandos.finalizar()
		}
	}



	public static void evidenciaRadarLiveWebService(List<Pacote> listaPacote){





		PdfPTable table = new PdfPTable(9);
		table.setHeaderRows(1);
		table.setWidthPercentage(100.0)
		table.getDefaultCell().setBorder(1)

		table.setHorizontalAlignment(Element.ALIGN_CENTER)
		table.addCell(new Paragraph("Cod", blueFontSmall))
		table.addCell(new Paragraph("Descrição", blueFontSmall))
		table.addCell(new Paragraph("Form. Pagmto.", blueFontSmall))
		table.addCell(new Paragraph("Qtd. Parc.", blueFontSmall))
		table.addCell(new Paragraph("Vlr. 1 Parc.", blueFontSmall))
		table.addCell(new Paragraph("Total Parc.", blueFontSmall))
		table.addCell(new Paragraph("Total Parc. Unic.", blueFontSmall))
		table.addCell(new Paragraph("Vlr. IOF. ", blueFontSmall))
		table.addCell(new Paragraph("Vlr. Ad. Frac. ", blueFontSmall))

		for(int i=0; i < listaPacote.size(); i++){

			if(listaPacote[i].getFormaPagamento().toString() == "1" && listaPacote[i].getQuantidadeParcelas().toString() == "1"){

				table.addCell(new Paragraph(listaPacote[i].getCodigoPacote(), smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getDescricaoPacote(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getFormaPagamento(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getQuantidadeParcelas(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getValorPrimeiraParcela(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getValorTotalParcelado(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getValorTotalParcelaUnica(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getValorIof(),smallListBlack))
				table.addCell(new Paragraph(listaPacote[i].getValorAdicionalFracionamento(),smallListBlack))
			}
		}
		document.add(table);
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static createTitlePage(){
		addTitlePage()
	}

	/**
	 * @author T_DCDias
	 * @param document
	 * @param img
	 * @return
	 */
	public static Document addTitlePage(){
		Image img = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//seguro-auto-allianz-2.jpg");
		img.scaleAbsolute(180f, 55f);

		document.add(img);
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 4);
		preface = new Paragraph("Evidência de Teste", catFont);
		preface.setAlignment(Element.ALIGN_CENTER);
		addEmptyLine(preface, 1);

		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		PdfPTable table = new PdfPTable(4);
		table.setHeaderRows(1);
		table.getDefaultCell().setBorder(0)
		table.setHorizontalAlignment(Element.ALIGN_LEFT)
		table.addCell(new Paragraph("Cód. Projeto: ", smallBold))
		table.addCell(new Paragraph(codigoProjeto, small))
		table.addCell(new Paragraph("Projeto: ",smallBold))
		table.addCell(new Paragraph(projeto,small))
		table.addCell(new Paragraph("Fábrica: ", smallBold))
		table.addCell(new Paragraph(fabrica, small))
		table.addCell(new Paragraph("Data: ",smallBold))
		table.addCell(new Paragraph(data,small))
		table.addCell(new Paragraph("Testador: ",smallBold))
		table.addCell(new Paragraph(testador,small))
		table.addCell(new Paragraph("Execução: ",smallBold))
		table.addCell(new Paragraph(hora,small))

		document.add(preface);
		document.add(table);

		Image imgBarr = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//barr.jpg")
		imgBarr.scaleToFit(500, 500)
		document.add(imgBarr);

		Image imgFooterw = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footerw.jpg")
		imgFooterw.scaleToFit(500, 500)
		document.add(imgFooterw);

		Image imgFooter = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footer.jpg")
		imgFooter.scaleToFit(500, 500)
		document.add(imgFooter);
		return document
	}


	/**
	 * @author T_DCDias
	 * @param document
	 * @param img
	 * @return
	 */
	public static Document addTitlePageMoto(){
		Image img = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//seguro-auto-allianz-2.jpg");
		img.scaleAbsolute(180f, 55f);

		document.add(img);
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 4);
		preface = new Paragraph("Evidência de Teste", catFont);
		preface.setAlignment(Element.ALIGN_CENTER);
		addEmptyLine(preface, 1);

		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		PdfPTable table = new PdfPTable(4);
		table.setHeaderRows(1);
		table.getDefaultCell().setBorder(0)
		table.setHorizontalAlignment(Element.ALIGN_LEFT)
		table.addCell(new Paragraph("Cód. Projeto: ", smallBold))
		table.addCell(new Paragraph(codigoProjeto, small))
		table.addCell(new Paragraph("Projeto: ",smallBold))
		table.addCell(new Paragraph(projeto,small))
		table.addCell(new Paragraph("Fábrica: ", smallBold))
		table.addCell(new Paragraph(fabrica, small))
		table.addCell(new Paragraph("Data: ",smallBold))
		table.addCell(new Paragraph(data,small))
		table.addCell(new Paragraph("Testador: ",smallBold))
		table.addCell(new Paragraph(testador,small))
		table.addCell(new Paragraph("Execução: ",smallBold))
		table.addCell(new Paragraph(hora,small))

		document.add(preface);
		document.add(table);

		Image imgBarr = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//barr.jpg")
		imgBarr.scaleToFit(500, 500)
		document.add(imgBarr);

		Image imgFooterw = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footerwmoto.jpg")
		imgFooterw.scaleToFit(500, 500)
		document.add(imgFooterw);

		Image imgFooter = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footer.jpg")
		imgFooter.scaleToFit(500, 500)
		document.add(imgFooter);
		return document
	}

	/**
	 * @author T_DCDias
	 * @param document
	 * @param img
	 * @return
	 */
	public static Document addTitlePageCaminhao(){
		Image img = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//seguro-auto-allianz-2.jpg");
		img.scaleAbsolute(180f, 55f);

		document.add(img);
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 4);
		preface = new Paragraph("Evidência de Teste", catFont);
		preface.setAlignment(Element.ALIGN_CENTER);
		addEmptyLine(preface, 1);

		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		PdfPTable table = new PdfPTable(4);
		table.setHeaderRows(1);
		table.getDefaultCell().setBorder(0)
		table.setHorizontalAlignment(Element.ALIGN_LEFT)
		table.addCell(new Paragraph("Cód. Projeto: ", smallBold))
		table.addCell(new Paragraph(codigoProjeto, small))
		table.addCell(new Paragraph("Projeto: ",smallBold))
		table.addCell(new Paragraph(projeto,small))
		table.addCell(new Paragraph("Fábrica: ", smallBold))
		table.addCell(new Paragraph(fabrica, small))
		table.addCell(new Paragraph("Data: ",smallBold))
		table.addCell(new Paragraph(data,small))
		table.addCell(new Paragraph("Testador: ",smallBold))
		table.addCell(new Paragraph(testador,small))
		table.addCell(new Paragraph("Execução: ",smallBold))
		table.addCell(new Paragraph(hora,small))

		document.add(preface);
		document.add(table);

		Image imgBarr = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//barr.jpg")
		imgBarr.scaleToFit(500, 500)
		document.add(imgBarr);

		Image imgFooterw = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footerwcaminhao.jpg")
		imgFooterw.scaleToFit(500, 500)
		document.add(imgFooterw);

		Image imgFooter = Image.getInstance("C://Users//Public//QA_ALLIANZ//Images//footer.jpg")
		imgFooter.scaleToFit(500, 500)
		document.add(imgFooter);
		return document
	}

	/**
	 * @author T_DCDias
	 * @param paragraph
	 * @param number
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static void addEmptyLineExterno(int number) {
		Paragraph paragraph = new Paragraph();
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
			document.add(paragraph);
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static createDocument(String ct, String path){
		document = new Document();
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("ddMMyyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HHmmss").format(dataHoraAtual);
			nomePDF = ct+"_"+data+"_"+hora+".pdf"
			PdfWriter.getInstance(document, new FileOutputStream(path+"//"+ct+"_"+data+"_"+hora+".pdf"));
			document.open(); System.err.println("-[document Opened]-")
		} catch(DocumentException de) {
			closeDocument()
			System.err.println(de.getMessage());
		} catch(IOException ioe) {
			closeDocument()
			System.err.println(ioe.getMessage());
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static closeDocument(){
		System.err.println("-[document closed]-")
		document.close();
		document.finalize()
	}

	/**
	 * @author T_DCDias
	 * @param im
	 * @return
	 */
	public static adicionarEvidencia(Image im){
		document.add(im);
	}

	/**
	 * @author T_DCDias
	 * @param im
	 * @return
	 * Pega valores do arquivo pdf de cotação e adiciona como log na evidência 
	 */
	public static adicionarEvidenciaContentPDF(String im){
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface = new Paragraph(im, smallEvidence);
		preface.setAlignment(Element.ALIGN_LEFT);
		document.add(preface);
	}

	/**
	 * @author T_DCDias
	 * @return
	 */
	public static adicionaCenario(String status, String cenario){
		Paragraph prefaceCenario = new Paragraph();
		addEmptyLine(prefaceCenario, 1);
		prefaceCenario.add(new Paragraph("Cenário: ", smallBold));
		prefaceCenario.add(new Paragraph(cenario, small));
		prefaceCenario.add(new Paragraph(status, corDaFonte(status)));
		document.add(prefaceCenario);
	}


	public static adicionaTexto(String status, String cenario){
		Paragraph prefaceCenario = new Paragraph();
		addEmptyLine(prefaceCenario, 1);
		prefaceCenario.add(new Paragraph(status, corDaFonte(status)));
		prefaceCenario.add(new Paragraph(cenario, blackFont));
		addEmptyLine(prefaceCenario, 1);



		document.add(prefaceCenario);
	}

	/**
	 * @author T_DCDias
	 * @param str
	 * @return
	 */
	public static Font corDaFonte(String str){
		Font font;
		if(str.equals("PASSED")){
			font= greenFont
		}else if (str.equals("FAIL")) {
			font= redFont
		}
		return font
	}

	public static Font corDaFonteSmall(String str){
		Font font;
		if(str.equals("PASSED")){
			font= smmallGreenFont
		}else if (str.equals("FAIL")) {
			font= smmallRedFont
		}
		return font
	}

	/**
	 * @author T_DCDias
	 * @param pathFileValue
	 * @return
	 */
	public static String pdfReader(String pathFileValue){
		strbffr = new StringBuffer()
		String text
		try{
			for(int i=0; i<noPages; i++){
				PdfReader pdfReaderFiles= new PdfReader(pathFileValue);
				int j = i+1
				text = PdfTextExtractor.getTextFromPage(pdfReaderFiles, j)
				strbffr.append(text).toString()
				pdfReaderFiles.close()
				pdfReaderFiles.finalize()
			}
			return strbffr
		} catch (Exception e){
			System.err.println("pdfReader - Falha ao ler arquivo ["+e+"]")
			commands.AutoComandos.finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @return
	 * Extrai os valores do arquivo pdf 
	 */
	public static String takePDFContent(String pathFileValue ){
		strbffr = new StringBuffer()
		String text
		try{
			for(int i=0; i<noPages; i++){
				PdfReader pdfReaderFiles = new PdfReader(pathFileValue);
				int j = i+1
				text = PdfTextExtractor.getTextFromPage(pdfReaderFiles, j)
				strbffr.append("\n"+text+"\n\n").toString()
				pdfReaderFiles.finalize()
				pdfReaderFiles.close()
			}
			return strbffr
		} catch (Exception e){
			System.err.println("takePDFContent - Falha ao ler arquivo ["+e+"]")
			commands.AutoComandos.finalizar()
		}
	}

	/**
	 * @author T_DCDias
	 * @throws IOException
	 * Altera nome do arquivo
	 */
	public static void renamingFiles() throws IOException {
		FileUtils.moveFile(
				FileUtils.getFile("C://Users//Public//retrievedoc.pdf"),
				FileUtils.getFile("C://Users//Public//retrievedoc_old.pdf"));
	}


	public static evidenciaPacotesCoberturas(List<Pacote> listCotacao){

		double somaPacoteCompacto1 = 0.0;
		double somaPacoteCompacto2 = 0.0;
		double somaPacoteAmpliado1 = 0.0;
		double somaPacoteAmpliado2 = 0.0;
		double somaPacoteEspecial = 0.0;
		double somaPacoteExclusivo= 0.0;

		//DecimalFormat formato = new DecimalFormat("#.##");

		PdfPTable table = new PdfPTable(listCotacao.size()+1);
		table.setHeaderRows(1);
		table.setWidthPercentage(100.0)
		table.getDefaultCell().setBorder(1)
		table.getDefaultCell().setBorderWidthLeft(1)
		table.getDefaultCell().setBorderWidthRight(1)
		table.getDefaultCell().setBorderWidthTop(1)
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE)
		table.getDefaultCell().setBorderColor(BaseColor.WHITE)

		PdfPCell cell;

		table.setHorizontalAlignment(Element.ALIGN_CENTER)

		cell = new PdfPCell(new Paragraph("Forma de Pagamento\nÀ vista", whiteFontSmall), )
		cell.setBackgroundColor(BaseColor.BLUE)
		cell.setBorderColor(BaseColor.WHITE)
		table.addCell(cell)

		for(int i = 0; i<listCotacao.size();i++){

			cell = new PdfPCell(new Paragraph(listCotacao.get(i).getDescricaoPacote()+"\n R\044 "+ listCotacao.get(i).getValorTotalParcelaUnica(), whiteFontSmall), )
			cell.setBackgroundColor(BaseColor.BLUE)
			cell.setBorderColor(BaseColor.WHITE)
			table.addCell(cell)
		}


		for(int a = 0; a < listCotacao.get(0).getListaCobertura().size(); a++){

			table.addCell(new Paragraph(listCotacao.get(0).getListaCobertura().get(a).getDescricaoCobertura(),smallListBlack))

			for(int i = 0; i<listCotacao.size();i++){

				table.addCell(new Paragraph("R\044 " + listCotacao.get(i).getListaCobertura().get(a).getValorPremio(),smallListBlack))

			}
		}


		table.addCell(new Paragraph("Prêmio Líquido", smallBoldBlack))

			for(int i = 0; i<listCotacao.size();i++){
	
					table.addCell(new Paragraph("R\044 " + String.format("%.2f", listCotacao.get(i).getTotalPremioCobertura()),smallListBlack))
			}
		

		document.add(table);
	}


	public static adicionaMessagem(String status, String cenario){
		Paragraph prefaceCenario = new Paragraph();
		prefaceCenario.add(new Paragraph(status, corDaFonteSmall(status)));
		prefaceCenario.add(new Paragraph(cenario, smallListBlack));
		document.add(prefaceCenario);
	}

	public static adicionaLinhaTexto(String cenario){
		Paragraph prefaceCenario = new Paragraph();
		addEmptyLine(prefaceCenario, 0);
		prefaceCenario.add(new Paragraph(cenario, smallListBlack));
		addEmptyLine(prefaceCenario, 0);
		document.add(prefaceCenario);
	}

	public static adicionaLinhaTextoNegrito(String cenario){
		Paragraph prefaceCenario = new Paragraph();

		prefaceCenario.add(new Paragraph(cenario, smallBoldBlack));

		document.add(prefaceCenario);
	}
}