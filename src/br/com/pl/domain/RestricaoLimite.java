package br.com.pl.domain;

public class RestricaoLimite {
	
	/*
	 * As restrições de limites inferiores,
	 * e superiores foram modeladas separadas
	 * das outras restricoes para evitar o 
	 * tratamento de Strings na hora de realizar
	 * os calculos necessarios.	 
	 */
	
	// Limites Superiores
	private Double limiteSuperiorX;
	private Double limiteSuperiorY;
	
	/*
	 * Por conveniencia, atribuimos "0"
	 * para os limites inferiores, inferindo
	 * restricao de positividade se nenhum valor
	 * for estabelecido.
	 */
	private Double limiteInferiorX = 0D;
	private Double limiteInferiorY = 0D;
	
	public Double getLimiteSuperiorX() {
		return limiteSuperiorX;
	}
	public void setLimiteSuperiorX(Double limiteSuperiorX) {
		this.limiteSuperiorX = limiteSuperiorX;
	}
	public Double getLimiteSuperiorY() {
		return limiteSuperiorY;
	}
	public void setLimiteSuperiorY(Double limiteSuperiorY) {
		this.limiteSuperiorY = limiteSuperiorY;
	}
	public Double getLimiteInferiorX() {
		return limiteInferiorX;
	}
	public void setLimiteInferiorX(Double limiteInferiorX) {
		this.limiteInferiorX = limiteInferiorX;
	}
	public Double getLimiteInferiorY() {
		return limiteInferiorY;
	}
	public void setLimiteInferiorY(Double limiteInferiorY) {
		this.limiteInferiorY = limiteInferiorY;
	}

}

