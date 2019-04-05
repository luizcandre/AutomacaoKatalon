package funcionalidadesAuto

import java.text.SimpleDateFormat

import javax.xml.soap.SOAPMessage
import javax.xml.transform.OutputKeys
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMResult
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import bean.Cobertura
import bean.Pacote
import bean.Proposta
import commands.AutoComandos
import io.cucumber.datatable.DataTable
import webservice.AutomacaoException
import webservice.CotacaoWebService
import webservice.MessagesFactory
import webservice.RequestSoap
import webservice.WebServiceError



public class RadarLiveWebServiceFuncionalidades extends AutoComandos{

	private static boolean resultadoDoTeste = false;
	private static boolean execucao = false;
	private static List<Pacote> listPacoteAntigo = new ArrayList<Pacote>();
	private static List<Pacote> listPacoteNovo = new ArrayList<Pacote>();
	private static WebServiceError mensagem = new WebServiceError();


	private static WebServiceError tratamentoErro = new WebServiceError()
	private static String responseSoap;
	private static String pathXML = 'C:\\Users\\Public\\QA_ALLIANZ\\xml\\'
	private static String pathXMLResponse = 'C:\\Users\\Public\\QA_ALLIANZ\\xml\\response\\'
	private static List<Pacote> listPacotesCoberturas = new ArrayList<Pacote>();
	private static Pacote MotorCalcNovoCompacto1

	private static List<Pacote> listMotorCalcAntigo;
	private static List<Pacote> listMotorCalcNovo;

	/**
	 * @author T_DCDias
	 * @param data
	 * @return
	 */
	public static lerDataTable(DataTable data){
		issue_info =  data.asMaps(String.class, String.class);

		tablePacotes()
		def ct = issue_info.get(0).get("CT")
		createDiretory(createDiretorypath+issue_info.get(0).get("topico") )
		createDocument(ct, pathEvidences+issue_info.get(0).get("topico"))
		createTitlePage()
	}

	/**
	 * Luiz
	 * Realiza o request SOAP no motor de calculo Antigo
	 * Obs. verifica se existe mensagem de erro no response, caso exista é lançado uma exception.
	 */
	public static solicitaRequestMotorCalcAntigo(){
		responseSoap(pathXML+issue_info.get(0).get("Diretório"), issue_info.get(0).get("URL"))
		salvarXmlResponse(issue_info.get(0).get("CT"),pathEvidences)
	}

	/**
	 * Luiz
	 * Realiza o request SOAP no motor de calculo novo
	 * Obs. verifica se existe mensagem de erro no response, caso exista é lançado uma exception.
	 */
	public static solicitaRequestMotorCalcNovo(){
		responseSoap(pathXML+issue_info.get(1).get("Diretório"), issue_info.get(1).get("URL"))
		salvarXmlResponse(issue_info.get(0).get("CT"),pathEvidences)
	}

	/**
	 * @author T_DCDias
	 * @param diretorio
	 * @param url
	 * @return
	 * Realisa o 'response' no 'Soap'
	 */
	public static responseSoap(String diretorio, String url){
		responseSoap = realizaRequestSoap(diretorio,url)
		tratamentoErro()
	}

	/**
	 * 
	 * @return
	 * Efetua o tratamento caso o 'response' retorne uma mensagem de erro 
	 */
	public static tratamentoErro(){
		if(tratamentoErro.hasErrorResponse(CotacaoWebService.pegarMensagens(retornaXmlToSOAPMessage()).get(0).getTipoMensagem())){
			CotacaoWebService.carregaMensagens(retornaXmlToSOAPMessage())
			salvarXmlResponse(issue_info.get(0).get("CT"),pathEvidences)
			throw new AutomacaoException("Erro gerado no retorno do request Motor Calculo")
		}
	}

	/**
	 * 
	 * @param diretorio
	 * @param url
	 * @return
	 */
	public static realizaRequestSoap(String diretorio, String url){
		try{
			responseSoap = RequestSoap.request(diretorio, url)
		} catch (Exception e){
			//Falha ao chamar 'responseSoap'
		}
	}

	/**
	 * 
	 * @return
	 */
	public static SOAPMessage retornaXmlToSOAPMessage(){
		return MessagesFactory.messageFactoryRequestString(responseSoap)
	}



	public static selecionarPacotePorParcelaMotorCalcNovo(){
		listMotorCalcNovo =	obterPacoteCoberturaList(issue_info.get(0).get("Pagamento"),issue_info.get(0).get("Parcela"))
		mostraPacoteCoberturas(listMotorCalcNovo)
	}


	public static selecionarPacotePorParcelaMotorCalcAntigo(){

		listMotorCalcAntigo = obterPacoteCoberturaList(issue_info.get(0).get("Pagamento"),issue_info.get(0).get("Parcela"))
		mostraPacoteCoberturas(listMotorCalcAntigo)
	}

	public static tablePacotes(){
		//issue_info.get(0).get("topico"


		for(int i=0; i< issue_info.size(); i++){
			
			Map<String, String> mapa = issue_info.get(i)
			for (String key : mapa.keySet()) {
				//Capturamos o valor a partir da chave
				String value = mapa.get(key);
				
				System.out.println(key + " = " + value);
			}
		}

	}


	/**
	 * @author t_lcsandre
	 * @param ct
	 * @param path
	 * @param flag
	 * @return
	 */
	public static salvarXmlResponse(String ct, String path){
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("ddMMyyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HHmmss").format(dataHoraAtual);

		String xmlStr = responseSoap;
		Source xmlInput = new StreamSource(new StringReader(xmlStr));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.transform(xmlInput,
				new StreamResult(new FileOutputStream(path+ "//"+"RadarLive"+"//"+ct+"_"+data+"_"+hora+".xml")));
	}



	/**
	 * @author t_lcsandre
	 * @param pagamento
	 * @param parcela
	 * @return
	 */
	public static List<Pacote> obterPacoteCoberturaList(String pagamento, String parcela){
		List<Pacote> listPacote = new ArrayList<Pacote>();
		Pacote pacote = new Pacote();

		try {
			Source src = retornaXmlToSOAPMessage().getSOAPPart().getContent();
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMResult result = new DOMResult();
			transformer.transform(src, result)
			Document document = result.getNode();


			document.getDocumentElement().normalize();

			System.out.println("Root element name :- " + document.getDocumentElement().getNodeName());


			NodeList nodeListPacote = document.getElementsByTagName("pacote");

			for (int i = 0; i < nodeListPacote.getLength(); i++) {

				pacote = new Pacote();


				NodeList nodeListOperacao = document.getElementsByTagName("ns2:cotacaoResponse");
				for(int k = 0; k< nodeListOperacao.getLength();k++) {
					Node nodeOperacao = nodeListOperacao.item(k);
					if (nodeOperacao.getNodeType() == Node.ELEMENT_NODE) {

						Element element = (Element) nodeOperacao;

						pacote.setNumeroOperacao(element.getElementsByTagName("ns1:operacao").item(0).getTextContent())
						pacote.setNumeroCotacao(element.getElementsByTagName("numeroCotacao").item(0).getTextContent());
					}
				}



				Node nodePacote = nodeListPacote.item(i);
				if (nodePacote.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) nodePacote;

					pacote.setCodigoPacote(element.getElementsByTagName("codigoPacote").item(0).getTextContent());
					pacote.setDescricaoPacote(element.getElementsByTagName("descricaoPacote").item(0).getTextContent());
					pacote.setFormaPagamento(element.getElementsByTagName("formaPagamento").item(0).getTextContent());
					pacote.setQuantidadeParcelas(
							element.getElementsByTagName("quantidadeParcelas").item(0).getTextContent());
					pacote.setValorPrimeiraParcela(
							element.getElementsByTagName("valorPrimeiraParcela").item(0).getTextContent());
					pacote.setValorTotalParcelado(
							element.getElementsByTagName("valorTotalParcelado").item(0).getTextContent());
					pacote.setValorTotalParcelaUnica(
							element.getElementsByTagName("valorTotalParcelaUnica").item(0).getTextContent());
					pacote.setValorIof(element.getElementsByTagName("valorIof").item(0).getTextContent());
					pacote.setValorAdicionalFracionamento(
							element.getElementsByTagName("valorAdicionalFracionamento").item(0).getTextContent());

					NodeList nodeList = element.getElementsByTagName("cobertura");
					List<Cobertura> lista = new ArrayList<Cobertura>();
					for (int j = 0; j < nodeList.getLength(); j++) {

						Cobertura cobertura = new Cobertura();

						Node node = nodeList.item(j);



						if (node.getNodeType() == Node.ELEMENT_NODE) {

							Element elementCobertura = (Element) node;

							cobertura.setCodigoCobertura(
									elementCobertura.getElementsByTagName("codigoCobertura").item(0).getTextContent());
							cobertura.setDescricaoCobertura(elementCobertura.getElementsByTagName("descricaoCobertura")
									.item(0).getTextContent());
							cobertura.setValorPremio(
									elementCobertura.getElementsByTagName("valorPremio").item(0).getTextContent());
							cobertura.setValorFranquia(
									elementCobertura.getElementsByTagName("valorFranquia").item(0).getTextContent());
							cobertura.setValorLMI(
									elementCobertura.getElementsByTagName("valorLMI").item(0).getTextContent());

							lista.add(cobertura);
							pacote.setListaCobertura(lista);
						}
					}
				}

				if(pacote.getFormaPagamento().equals(pagamento) && pacote.getQuantidadeParcelas().equals(parcela)) {
					listPacote.add(pacote);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPacote;
	}



	/**
	 * @author t_lcsandre
	 * @return
	 * Chama o metodo de validação do pacotes e coberturas
	 */
	public static boolean validar(){

		validarPacotesCoberturasWebServiceRadarLive(listMotorCalcAntigo, listMotorCalcNovo)


		adicionaTexto(statusValidacao(), "Radar Live - Validar requisições no serviço de gerar cotações, no motor de cálculo de prêmios.")

		adicionaLinhaTextoNegrito("Validação do request motor de cálculo antigo.")
		addEmptyLineExterno(1)
		adicionaLinhaTextoNegrito("Nº Operação : "+listMotorCalcAntigo.get(0).getNumeroOperacao()+ "     Nº Cotação: "+listMotorCalcAntigo.get(0).getNumeroCotacao())
		adicionaLinhaTexto("Web Service URL: " + issue_info.get(0).get("URL"))
		addEmptyLineExterno(1)
		evidenciaPacotesCoberturas(listMotorCalcAntigo)
		addEmptyLineExterno(1)

		adicionaLinhaTextoNegrito("Validação do request motor de cálculo novo.")
		addEmptyLineExterno(1)
		adicionaLinhaTextoNegrito("Nº Operação : "+listMotorCalcNovo.get(0).getNumeroOperacao()+ "     Nº Cotação: "+ listMotorCalcNovo.get(0).getNumeroCotacao())
		adicionaLinhaTexto("Web Service URL: " + issue_info.get(1).get("URL"))
		addEmptyLineExterno(1)
		evidenciaPacotesCoberturas(listMotorCalcNovo)
		adicionaMessagem(mensagem.statusPacote, mensagem.mensagemPacote)
		adicionaMessagem(mensagem.statusCobertura, mensagem.mensagemCobertura)

		return execucao;
	}

	public static void validarPacotesCoberturasWebServiceRadarLive(List<Pacote> motorAntigo, List<Pacote> motorNovo){

		//Inicializa a variavel resultado como false
		resultadoDoTeste = false;

		for(int i = 0; i< motorAntigo.size(); i++){

			//Validação de Pacotes
			isError(motorAntigo.get(i).getDescricaoPacote().equals(motorNovo.get(i).getDescricaoPacote()))
			isError(motorAntigo.get(i).getFormaPagamento().equals(motorNovo.get(i).getFormaPagamento()))
			isError(motorAntigo.get(i).getQuantidadeParcelas().equals(motorNovo.get(i).getQuantidadeParcelas()))
			isError(motorAntigo.get(i).getValorPrimeiraParcela().equals(motorNovo.get(i).getValorPrimeiraParcela()))
			isError(motorAntigo.get(i).getValorTotalParcelado().equals(motorNovo.get(i).getValorTotalParcelado()))
			isError(motorAntigo.get(i).getValorTotalParcelaUnica().equals(motorNovo.get(i).getValorTotalParcelaUnica()))
			isError(motorAntigo.get(i).getValorIof().equals(motorNovo.get(i).getValorIof()))
			isError(motorAntigo.get(i).getValorAdicionalFracionamento().equals(motorNovo.get(i).getValorAdicionalFracionamento()))

			if(resultadoDoTeste.equals(true)){
				execucao = resultadoDoTeste
				mensagem.setMensagemPacote("Ocorreu um erro ou divergência nos dados do pacote.")
				mensagem.setStatusPacote("FAIL")
				//			throw new AutomacaoException(e)
			}else{
				mensagem.setMensagemPacote("Realizado a validação dos pacotes com sucesso")
				mensagem.setStatusPacote("PASSED")
			}
			//assert resultadoDoTeste.equals(true)

			resultadoDoTeste = false

			for(int a = 0; a < motorAntigo.get(i).getListaCobertura().size(); a++){

				isError(motorAntigo.get(i).getListaCobertura().get(a).getCodigoCobertura().equals(motorNovo.get(i).getListaCobertura().get(a).getCodigoCobertura()))
				isError(motorAntigo.get(i).getListaCobertura().get(a).getDescricaoCobertura().equals(motorNovo.get(i).getListaCobertura().get(a).getDescricaoCobertura()))
				isError(motorAntigo.get(i).getListaCobertura().get(a).getValorPremio().equals(motorNovo.get(i).getListaCobertura().get(a).getValorPremio()))
				isError(motorAntigo.get(i).getListaCobertura().get(a).getValorFranquia().equals(motorNovo.get(i).getListaCobertura().get(a).getValorFranquia()))
				isError(motorAntigo.get(i).getListaCobertura().get(a).getValorLMI().equals(motorNovo.get(i).getListaCobertura().get(a).getValorLMI()))


				if(resultadoDoTeste.equals(true)){
					execucao = resultadoDoTeste
					mensagem.setStatusCobertura("FAIL")
					mensagem.setMensagemCobertura("Ocorreu um erro ou divergência nos dados do Cobertura.")
					//			throw new AutomacaoException(e)
				}else{
					mensagem.setStatusCobertura("PASSED")
					mensagem.setMensagemCobertura("Realizado a validação das coberturas com sucesso.")
				}

			}
		}


	}




	/**
	 * @author T_DCDias
	 * @return
	 */
	public static String confereExecucao(){
		if(resultadoDoTeste ==false){
			execucao = resultadoDoTeste
			return "FAIL"
		}
		return "PASSED"
	}

	/**
	 * @author t_lcsandre
	 * @return
	 * Verificar se ocorreu erro e retorna o status da execução para evidência
	 */
	public static String statusValidacao(){
		if(execucao.equals(true)){
			return "FAIL"
		}
		return "PASSED"
	}


	public static void isError(boolean error){

		if(error == false){
			resultadoDoTeste = true
		}
	}

	/**
	 * @author T_DCDias
	 * @param corretor
	 * @return
	 */
	public static registroDeFalhaDeValidacaoDoCorretor(String corretor, int i, int teste){
		System.err.println(i+"Falha no corretor "+corretor)
		porcentagemDeTela(60)
		adicionaCenario("FAIL", issue_info.get(0).get("Cenário")+" - Execução "+teste)
		adicionarEvidencia(takeScreen())
		porcentagemDeTela(100)
		salvarEvidenciaRadarLive(i, "Falha ao validar pacotes do corretor "+corretor+" Execução "+teste, "FAIL", "S")
		finalizar()
	}

	//	/**
	//	 * @author T_DCDias
	//	 * @param corretor
	//	 * @return
	//	 */
	//	public static registroDeExecucaoSemMassa(){
	//		adicionaCenario("FAIL", "Não existe dados para validar")
	//	}


	public static finalizarDocumento(){
		closeDocument()
	}


	/**
	 * @author T_DCDias
	 * @param pc
	 */
	public static void mostraPacoteCoberturas(List<Pacote> listPacote){
		for (int a = 0; a < listPacote.size(); a++) {

			System.out.println("### PACOTE ### ");
			System.out.println("Código Pacote: " + listPacote.get(a).getCodigoPacote());
			System.out.println("Descrição Pacote: " + listPacote.get(a).getDescricaoPacote());
			System.out.println("valorPremio" + listPacote.get(a).getValorTotalParcelaUnica());

			for (int i = 0; i < listPacote.get(a).getListaCobertura().size(); i++) {

				System.out.println("Código Cobertura:"
						+ listPacote.get(a).getListaCobertura().get(i).getCodigoCobertura()+ " " + "Descrição Cobertura: "
						+ listPacote.get(a).getListaCobertura().get(i).getDescricaoCobertura()+ " " + "valorPremio: "
						+ listPacote.get(a).getListaCobertura().get(i).getValorPremio()+ " " + "valorFranquia: "
						+ listPacote.get(a).getListaCobertura().get(i).getValorFranquia()+ " " + "valorLMI: "
						+ listPacote.get(a).getListaCobertura().get(i).getValorLMI());

			}
			System.out.println("-------------------------------------");
		}

	}







}
