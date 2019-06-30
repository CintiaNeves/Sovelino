package br.com.pl.domain;

public class Restricao {
	
	/*
	 * Restricoes que nao sao
	 * relacionadas aos limites
	 * foram modeladas separadamente,
	 * embora possuam os mesmos atributos
	 * de equacao, simplesmente por semantica.
	 */
	private Double variavelX;
	private Double variavelY;
	private Double resultado;
	private String operador;
	public Double getVariavelX() {
		return variavelX;
	}
	public void setVariavelX(Double variavelX) {
		this.variavelX = variavelX;
	}
	public Double getVariavelY() {
		return variavelY;
	}
	public void setVariavelY(Double variavelY) {
		this.variavelY = variavelY;
	}
	public Double getResultado() {
		return resultado;
	}
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
}