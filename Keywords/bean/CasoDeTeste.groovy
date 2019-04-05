package bean

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

public class CasoDeTeste {

	private  String usuario
	private  String senha
	private  String usuario2
	private  String senha2
	private  String ct
	private  String cpfcnpj
	private  String cep
	private  String estadoCivil
	private  String placa
	private  String residenciaCondutor
	private  String chassis
	private  String formaDePagamento
	private  String valorPacote;
	private  String pacote;
	private  String valorSeguro;
	private  String apolice
	private  String cotacao
	private  String classeDeBonus
	private  String cenario
	private  String executar
	private  String numeroci
	private  String blindagem
	private  String numCpfCondutor
	private  String nomeCpfCondutor

	private  String pacoteAmpliado1
	private  String pacoteAmpliado2
	private  String pacoteCompacto1
	private  String pacoteCompacto2
	private  String pacoteEspecial
	private  String pacoteExclusivo
	private  String status

	//PACOTE
	private  String codigoPacote
	private  String descricaoPacote
	private  String quantidadeParcelas
	private  String valorPrimeiraParcela
	private  String valorTotalParcelado
	private  String valorTotalParcelaUnica
	private  String valorIof
	private  String valorAdicionalFracionamento
	private  String formaPagamento
	private  String Envelope

	//COBERTURA
	private  String codigoCobertura
	private  String descricaoCobertura
	private  String valorPremio
	private  String valorFranquia
	private  String valorLMI
	private  String coberturas



	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsuario2(){
		return usuario2
	}

	public void setUsuario2(String usuario2){
		this.usuario2 = usuario2
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public String getNomeCpfCondutor() {
		return nomeCpfCondutor;
	}

	public void setNomeCpfCondutor(String nomeCpfCondutor) {
		this.nomeCpfCondutor = nomeCpfCondutor;
	}

	public String getNumCpfCondutor() {
		return numCpfCondutor;
	}

	public void setNumCpfCondutor(String numCpfCondutor) {
		this.numCpfCondutor = numCpfCondutor;
	}

	public String getBlindagem() {
		return blindagem;
	}

	public void setBlindagem(String blindagem) {
		this.blindagem = blindagem;
	}

	public String getNumeroci() {
		return numeroci;
	}

	public void setNumeroci(String numeroci) {
		this.numeroci = numeroci;
	}

	public String getCenario() {
		return cenario;
	}

	public void setCenario(String cenario) {
		this.cenario = cenario;
	}

	public String getExecutar() {
		return executar;
	}

	public void setExecutar(String executar) {
		this.executar = executar;
	}

	public String getClasseDeBonus() {
		return classeDeBonus;
	}

	public void setClasseDeBonus(String classeDeBonus) {
		this.classeDeBonus = classeDeBonus;
	}

	public String getCotacao() {
		return cotacao;
	}

	public void setCotacao(String cotacao) {
		this.cotacao = cotacao;
	}

	public String getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(String valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public String getValorPacote(){
		return valorPacote
	}

	public void setValorPacote(String valorPacote) {
		this.valorPacote = valorPacote;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getUsuario(){
		return usuario
	}

	public void setUsuario(String usuario){
		this.usuario = usuario
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getResidenciaCondutor() {
		return residenciaCondutor;
	}

	public void setResidenciaCondutor(String residenciaCondutor) {
		this.residenciaCondutor = residenciaCondutor;
	}

	public String getPacoteAmpliado1() {
		return pacoteAmpliado1;
	}

	public void setPacoteAmpliado1(String pacoteAmpliado1) {
		this.pacoteAmpliado1 = pacoteAmpliado1;
	}

	public String getPacoteAmpliado2() {
		return pacoteAmpliado2;
	}

	public void setPacoteAmpliado2(String pacoteAmpliado2) {
		this.pacoteAmpliado2 = pacoteAmpliado2;
	}

	public String getPacoteCompacto1() {
		return pacoteCompacto1;
	}

	public void setPacoteCompacto1(String pacoteCompacto1) {
		this.pacoteCompacto1 = pacoteCompacto1;
	}

	public String getPacoteCompacto2() {
		return pacoteCompacto2;
	}

	public void setPacoteCompacto2(String pacoteCompacto2) {
		this.pacoteCompacto2 = pacoteCompacto2;
	}

	public String getPacoteEspecial() {
		return pacoteEspecial;
	}

	public void setPacoteEspecial(String pacoteEspecial) {
		this.pacoteEspecial = pacoteEspecial;
	}

	public String getPacoteExclusivo() {
		return pacoteExclusivo;
	}

	public void setPacoteExclusivo(String pacoteExclusivo) {
		this.pacoteExclusivo = pacoteExclusivo;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(String quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public String getValorPrimeiraParcela() {
		return valorPrimeiraParcela;
	}

	public void setValorPrimeiraParcela(String valorPrimeiraParcela) {
		this.valorPrimeiraParcela = valorPrimeiraParcela;
	}

	public String getValorTotalParcelado() {
		return valorTotalParcelado;
	}

	public void setValorTotalParcelado(String valorTotalParcelado) {
		this.valorTotalParcelado = valorTotalParcelado;
	}

	public String getValorTotalParcelaUnica() {
		return valorTotalParcelaUnica;
	}

	public void setValorTotalParcelaUnica(String valorTotalParcelaUnica) {
		this.valorTotalParcelaUnica = valorTotalParcelaUnica;
	}

	public String getValorIof() {
		return valorIof;
	}

	public void setValorIof(String valorIof) {
		this.valorIof = valorIof;
	}

	public String getValorAdicionalFracionamento() {
		return valorAdicionalFracionamento;
	}

	public void setValorAdicionalFracionamento(String valorAdicionalFracionamento) {
		this.valorAdicionalFracionamento = valorAdicionalFracionamento;
	}

	public String getCodigoCobertura() {
		return codigoCobertura;
	}

	public void setCodigoCobertura(String codigoCobertura) {
		this.codigoCobertura = codigoCobertura;
	}

	public String getDescricaoCobertura() {
		return descricaoCobertura;
	}

	public void setDescricaoCobertura(String descricaoCobertura) {
		this.descricaoCobertura = descricaoCobertura;
	}

	public String getValorPremio() {
		return valorPremio;
	}

	public void setValorPremio(String valorPremio) {
		this.valorPremio = valorPremio;
	}

	public String getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(String valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public String getValorLMI() {
		return valorLMI;
	}

	public void setValorLMI(String valorLMI) {
		this.valorLMI = valorLMI;
	}

	public String getCodigoPacote() {
		return codigoPacote;
	}

	public void setCodigoPacote(String codigoPacote) {
		this.codigoPacote = codigoPacote;
	}

	public String getDescricaoPacote() {
		return descricaoPacote;
	}

	public void setDescricaoPacote(String descricaoPacote) {
		this.descricaoPacote = descricaoPacote;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(String coberturas) {
		this.coberturas = coberturas;
	}

	public String getEnvelope() {
		return Envelope;
	}

	public void setEnvelope(String envelope) {
		Envelope = envelope;
	}





}
