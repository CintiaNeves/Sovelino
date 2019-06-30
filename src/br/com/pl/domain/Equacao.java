package br.com.pl.domain;

import java.util.List;


public class Equacao {
	
	private FuncaoObjetivo funcObjetivo;
	private RestricaoLimite limites;
	private String tipoProblema;
	private Resultado resultado;

	
	private List < Restricao > restricoes;

	public FuncaoObjetivo getFuncObjetivo() {
		return funcObjetivo;
	}

	public void setFuncObjetivo(FuncaoObjetivo funcObjetivo) {
		this.funcObjetivo = funcObjetivo;
	}

	public RestricaoLimite getLimites() {
		return limites;
	}

	public void setLimites(RestricaoLimite limites) {
		this.limites = limites;
	}

	public List<Restricao> getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(List<Restricao> restricoes) {
		this.restricoes = restricoes;
	}

	public String getTipoProblema() {
		return tipoProblema;
	}

	public void setTipoProblema(String tipoProblema) {
		this.tipoProblema = tipoProblema;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
}

