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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import internal.GlobalVariable

public class CreateXMLRadarLive {

	public static createXmlRadarLiveRequest(CasoDeTeste casoDeTeste){

		//CasoDeTeste casoDeTeste = casoDeTeste;
		Document doc = new Document();
		//Namespace ns1 = Namespace.getNamespace("urn:iso:std:iso:20022:tech:xsd:pain.001.001.03");
		Namespace ns1 = Namespace.getNamespace("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
		Namespace ws = Namespace.getNamespace("ws", "http://drswbo05.allianz.com.br/V1_00_00/ws");
		Namespace sch = Namespace.getNamespace("sch", "http://drswbo05.allianz.com.br/V1_00_00/schemas");
		Element root = new Element("Envelope", ns1);
		root.addNamespaceDeclaration(ws);
		root.addNamespaceDeclaration(sch);


		Element body = new Element("Body", ns1);

		// CotacaoRequest
		Element cotacaoRequest = new Element("cotacaoRequest",ws);
		body.addContent(cotacaoRequest);

		// Autenticacao
		Element autenticacao = new Element("autenticacao", sch);
		Element usuario = new Element("usuario", sch);
		Element parceiro = new Element("parceiro", sch);
		Element mediador = new Element("mediador", sch);

		usuario.setText(casoDeTeste.getUsuario());
		parceiro.setText(casoDeTeste.getParceiro());
		mediador.setText(casoDeTeste.getMediador());

		autenticacao.addContent(usuario);
		autenticacao.addContent(parceiro);
		autenticacao.addContent(mediador);

		cotacaoRequest.addContent(autenticacao);



		//Dados Fiscais
		Element dadosFiscais = new Element("dadosFiscais", sch);
		cotacaoRequest.addContent(dadosFiscais);

		Element isentoIOF = new Element("isentoIOF");
		isentoIOF.setText(casoDeTeste.getIsentoIOF());
		dadosFiscais.addContent(isentoIOF);


		//Dados Gerais
		Element dadosGerais = new Element("dadosGerais", sch);
		Element dataInicio = new Element("dataInicio", sch);
		Element percentualComissao = new Element("percentualComissao", sch);
		Element agravoDesconto = new Element("agravoDesconto", sch);
		Element percentualDesconto = new Element("percentualDesconto", sch);

		dataInicio.setText(casoDeTeste.getDataInicio());
		percentualComissao.setText(casoDeTeste.getPercentualComissao());
		percentualDesconto.setText(casoDeTeste.getPercentualDesconto());
		agravoDesconto.addContent(percentualDesconto);

		dadosGerais.addContent(dataInicio);
		dadosGerais.addContent(percentualComissao);
		dadosGerais.addContent(agravoDesconto);

		cotacaoRequest.addContent(dadosGerais);


		//Nó DADOS DE RISCO
		Element dadosRisco = new Element("dadosRisco", sch);
		Element nomeTomador = new Element("nomeTomador", sch);
		Element documentoTomador = new Element("documentoTomador", sch);
		Element nomeCondutor = new Element("nomeCondutor", sch);
		Element documentoCondutor = new Element("documentoCondutor", sch);
		Element dataNascimento = new Element("dataNascimento", sch);

		nomeTomador.setText(casoDeTeste.getNomeTomador());
		documentoTomador.setText(casoDeTeste.getDocumentoTomador());
		nomeCondutor.setText(casoDeTeste.getNomeCondutor());
		documentoCondutor.setText(casoDeTeste.getDocumentoCondutor());
		dataNascimento.setText(casoDeTeste.getDataNascimento());

		dadosRisco.addContent(nomeTomador);
		dadosRisco.addContent(documentoTomador);
		dadosRisco.addContent(nomeCondutor);
		dadosRisco.addContent(documentoCondutor);
		dadosRisco.addContent(dataNascimento);

		cotacaoRequest.addContent(dadosRisco);


		//Nó DADOS DO VEÍCULO

		Element veiculo = new Element("veiculo", sch);
		Element chassi = new Element("chassi", sch);
		Element anoModelo = new Element("anoModelo", sch);
		Element situacaoVeiculo = new Element("situacaoVeiculo", sch);
		Element usado = new Element("usado", sch);
		Element isVeiculoUsado = new Element("isVeiculoUsado", sch);
		Element placa = new Element("placa", sch);
		Element codigoMarcaModelo = new Element("codigoMarcaModelo", sch);
		Element codigoFipe = new Element("codigoFipe", sch);
		Element percentualFipe = new Element("percentualFipe", sch);
		Element cepPernoite = new Element("cepPernoite", sch);
		Element tipoFranquia = new Element("tipoFranquia", sch);
		Element dispositivoAtual = new Element("dispositivoAtual", sch);
		Element veiculoBlindado = new Element("veiculoBlindado", sch);
		Element despesasExtraordinarias = new Element("despesasExtraordinarias", sch);

		chassi.setText(casoDeTeste.getChassi());
		anoModelo.setText(casoDeTeste.getAnoModelo());
		isVeiculoUsado.setText(casoDeTeste.getIsVeiculoUsado());
		placa.setText(casoDeTeste.getPlaca());
		codigoMarcaModelo.setText(casoDeTeste.getCodigoMarcaModelo());
		codigoFipe.setText(casoDeTeste.getCodigoFipe());
		percentualFipe.setText(casoDeTeste.getPercentualFipe());
		cepPernoite.setText(casoDeTeste.getCepPernoite());
		tipoFranquia.setText(casoDeTeste.getTipoFranquia());
		dispositivoAtual.setText(casoDeTeste.getDispositivoAtual());
		veiculoBlindado.setText(casoDeTeste.getVeiculoBlindado());
		despesasExtraordinarias.setText(casoDeTeste.getDespesasExtraordinarias());

		situacaoVeiculo.addContent(usado);
		usado.addContent(isVeiculoUsado);
		usado.addContent(placa);

		veiculo.addContent(chassi);
		veiculo.addContent(anoModelo);
		veiculo.addContent(situacaoVeiculo);
		veiculo.addContent(codigoMarcaModelo);
		veiculo.addContent(codigoFipe);
		veiculo.addContent(percentualFipe);
		veiculo.addContent(cepPernoite);
		veiculo.addContent(tipoFranquia);
		veiculo.addContent(dispositivoAtual);
		veiculo.addContent(veiculoBlindado);
		veiculo.addContent(despesasExtraordinarias);

		cotacaoRequest.addContent(veiculo);



		//Nó DADOS DO RAMO

		Element ramo = new Element("ramo", sch);
		Element auto = new Element("auto", sch);
		Element categoriaRisco = new Element("categoriaRisco", sch);
		Element questionario = new Element("questionario", sch);
		Element sexo = new Element("sexo", sch);
		Element estadoCivil = new Element("sexo", sch);
		Element tempoHabilitacao = new Element("tempoHabilitacao", sch);
		Element existeMenor25anos = new Element("existeMenor25anos", sch);
		Element garagemFaculdade = new Element("garagemFaculdade", sch);
		Element garagemResidencia = new Element("garagemResidencia", sch);
		Element garagemTrabalho = new Element("garagemTrabalho", sch);
		Element condutorPrincipalResideEm = new Element("condutorPrincipalResideEm", sch);

		categoriaRisco.setText(casoDeTeste.getCategoriaRisco());
		sexo.setText(casoDeTeste.getSexo());
		estadoCivil.setText(casoDeTeste.getEstadoCivil());
		tempoHabilitacao.setText(casoDeTeste.getTempoHabilitacao());
		existeMenor25anos.setText(casoDeTeste.getExisteMenor25anos());
		garagemFaculdade.setText(casoDeTeste.getGaragemFaculdade());
		garagemResidencia.setText(casoDeTeste.getGaragemResidencia());
		garagemTrabalho.setText(casoDeTeste.getGaragemTrabalho());
		condutorPrincipalResideEm.setText(casoDeTeste.getCondutorPrincipalResideEm());


		ramo.addContent(auto);
		auto.addContent(categoriaRisco);
		auto.addContent(questionario);

		questionario.addContent(sexo);
		questionario.addContent(estadoCivil);
		questionario.addContent(tempoHabilitacao);
		questionario.addContent(existeMenor25anos);
		questionario.addContent(garagemFaculdade);
		questionario.addContent(garagemResidencia);
		questionario.addContent(garagemTrabalho);
		questionario.addContent(condutorPrincipalResideEm);


		cotacaoRequest.addContent(ramo);


		root.addContent(body);
		doc.setRootElement(root);

		XMLOutputter xout = new XMLOutputter();
		try {
			Format f = Format.getPrettyFormat();
			f.setEncoding("UTF-8");
			xout.setFormat(f);

			OutputStream out = new FileOutputStream(new File("exemplo.xml"));
			xout.output(doc, out);
			xout.output(doc, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

