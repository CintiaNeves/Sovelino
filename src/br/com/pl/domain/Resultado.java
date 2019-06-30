package br.com.pl.domain;

import java.util.List;

/**
 * Objeto enviado para o
 * front-end com os resultados
 * dos calculos realizados
 */
public class Resultado {
	
	/**
	 * Descricao textual da resposta
	 * contendo a solucao otima
	 */
	private String descResposta;
	
	/**
	 * Resultado obtido atraves
	 * da solucao ideal, seja ele
	 * para maximizacao ou para
	 * minimizacao
	 */
	private Double resultado;
	
	/**
	 * Coordenadas do plano cartesiano
	 * que contem a solucao otima
	 */
	private Pair coordenada;
	
	/**
	 * Contem a lista de coordenadas
	 * que compoem a regiao viavel
	 */
	private List < Pair > regiaoViavel;
	
	public String getDescResposta() {
		return descResposta;
	}
	
	public void setDescResposta(String descResposta) {
		this.descResposta = descResposta;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public Pair getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Pair coordenada) {
		this.coordenada = coordenada;
	}

	public List<Pair> getRegiaoViavel() {
		return regiaoViavel;
	}

	public void setRegiaoViavel(List<Pair> regiaoViavel) {
		this.regiaoViavel = regiaoViavel;
	}
}
