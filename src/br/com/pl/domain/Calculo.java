package br.com.pl.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculo {

	private final String MAIOR_IGUAL = ">=";
	private final String MENOR_IGUAL = "<=";
	private final String IGUAL = "=";
	private final String SOMA = "+";
	private final String SUBTRACAO = "-";
	private final String MAX = "maximizacao";
	private final String MIN = "minimizacao";

	public Equacao calcular(Equacao eq) {

		/*
		 * Cria lista com todos os pontos encotrados que posteriormente seram
		 * verificados mediante as restricoes informadas
		 */
		List<Pair> pontosCandidatos = new ArrayList<>();

		for (Restricao restricao : eq.getRestricoes()) {
			// Coordenada X
			Pair pairX = new Pair();

			// Coordenada Y
			Pair pairY = new Pair();

			// Calcula os valores do ponto X
			pairX.setX(restricao.getResultado() / restricao.getVariavelX());
			pairX.setY(eq.getLimites().getLimiteInferiorY());

			pairY.setY(restricao.getResultado() / restricao.getVariavelY());
			pairY.setX(eq.getLimites().getLimiteInferiorY());

			if (eq.getLimites().getLimiteSuperiorX() != null) {

				Pair pairW = new Pair();
				pairW.setX(eq.getLimites().getLimiteSuperiorX());
				pairW.setY(
						(restricao.getResultado() - (restricao.getVariavelX() * eq.getLimites().getLimiteSuperiorX()))
								/ restricao.getVariavelY());
				pontosCandidatos.add(pairW);
			}

			if (eq.getLimites().getLimiteSuperiorY() != null) {

				Pair pairZ = new Pair();
				pairZ.setX(
						(restricao.getResultado() - (restricao.getVariavelY() * eq.getLimites().getLimiteSuperiorY()))
								/ restricao.getVariavelX());
				pairZ.setY(eq.getLimites().getLimiteSuperiorY());
				pontosCandidatos.add(pairZ);
			}

			pontosCandidatos.add(pairX);
			pontosCandidatos.add(pairY);
		}
		
		for (int i = 0; i < eq.getRestricoes().size(); i++) {
    		Restricao res1 = eq.getRestricoes().get(i);
        	for (int j = i + 1; j < eq.getRestricoes().size(); j++) {
        		Pair pair = new Pair();
        		Double x = 0D;
        		Double y = 0D;
        		Restricao res2 = eq.getRestricoes().get(j);
        		Restricao resAux = new Restricao();
        		Double multiplicador = (res1.getVariavelX() / res2.getVariavelX()) * (-1);
        		resAux.setVariavelX(res2.getVariavelX() * multiplicador);
        		resAux.setVariavelY(res2.getVariavelY() * multiplicador);
        		resAux.setResultado(res2.getResultado() * multiplicador);
        		y = ( res1.getResultado() + resAux.getResultado()) / (res1.getVariavelY() + resAux.getVariavelY() );
        		x = ( res1.getResultado() - (res1.getVariavelY() * y)) / res1.getVariavelX();
        		pair.setX(x);
        		pair.setY(y); 
        		pontosCandidatos.add(pair);
        	}
        }

		/*
		 * Adiciona pontos com limites inferiores e superiores
		 */
		if (eq.getLimites().getLimiteSuperiorX() != null) {
			Pair pX = new Pair();
			pX.setX(eq.getLimites().getLimiteSuperiorX());
			pX.setY(eq.getLimites().getLimiteInferiorY());

			Pair pY = new Pair();
			pY.setX(eq.getLimites().getLimiteInferiorX());
			pY.setY(eq.getLimites().getLimiteSuperiorY());

			Pair pP = new Pair();
			pP.setX(eq.getLimites().getLimiteSuperiorX());
			pP.setY(eq.getLimites().getLimiteSuperiorY());

			pontosCandidatos.add(pX);
			pontosCandidatos.add(pY);
			pontosCandidatos.add(pP);
		}
		
		Pair pp = new Pair();
		pp.setX(eq.getLimites().getLimiteInferiorX());
		pp.setY(eq.getLimites().getLimiteInferiorY());

		pontosCandidatos.add(pp);
		/*
		 * Cria lista para adicionar pontos que serao removidos pois nao obedecem as
		 * restricoes de limite dos coeficientes
		 */
		List<Pair> remover = new ArrayList<>();
		for (Pair pair : pontosCandidatos) {
			if ((eq.getLimites().getLimiteSuperiorX() != null && pair.getX() > eq.getLimites().getLimiteSuperiorX()) // Ponto X maior que o limite superior X?
					|| pair.getX() < eq.getLimites().getLimiteInferiorX() // Ponto X menor que o limite inferior X?
					|| (eq.getLimites().getLimiteSuperiorY() != null && pair.getY() > eq.getLimites().getLimiteSuperiorY()) // Ponto Y maior que o limite superior Y?
					|| pair.getY() < eq.getLimites().getLimiteInferiorX()) // Ponto Y maior que o limite inferior Y?
			{

				// Adiciona ponto que nao obedece restricoes na lista para remover
				remover.add(pair);
			}

		}

		// Remove todos os pontos adicionados anteriormente
		pontosCandidatos.removeAll(remover);
		remover.clear();
		/*
		 * Itera sobre todos os pontos restantes validando-os com as demais restricoes
		 */
		for (Restricao rest : eq.getRestricoes()) {
			for (Pair p : pontosCandidatos) {
				// Verificar o operador informado
				if (rest.getOperador().equals(MENOR_IGUAL)) {
					// Se for "<="
					if (p.getX() * rest.getVariavelX() + p.getY() * rest.getVariavelY() > rest.getResultado()) {
						remover.add(p);
					} // Se for ">="
				} else if (rest.getOperador().equals(MAIOR_IGUAL)) {
					if (p.getX() * rest.getVariavelX() + p.getY() * rest.getVariavelY() < rest.getResultado()) {
						remover.add(p);
					}
				} else {
					if (p.getX() * rest.getVariavelX() + p.getY() * rest.getVariavelY() == rest.getResultado()) {
						remover.add(p);
					}
				}
			}
		}

		/*
		 * Removidos todos os pontos que nao estao de acordo com as restricoes
		 */
		pontosCandidatos.removeAll(remover);

		/*
		 * Agora resta verificar se o problema e de maximizacao ou minizacao e retornar
		 * a solucao otima junto com os pontos da solucao viavel para montar os graficos
		 * no front-end
		 */
		Resultado resultadoTrono = null;
		Pair coordenada = null;
		for ( Pair solucao : pontosCandidatos ) {
			Resultado r = new Resultado();
			
			Double valor1 = eq.getFuncObjetivo().getVariavelX() * solucao.getX();
			Double valor2 = eq.getFuncObjetivo().getVariavelY() * solucao.getY();
			
			
			r.setResultado( eq.getFuncObjetivo().getOperador().equals( SOMA ) ? valor1 + valor2 : valor1 - valor2 );
			
			if ( eq.getTipoProblema().equals( MAX ) ) {
				if ( null == resultadoTrono ) {
					resultadoTrono = r;
					coordenada = solucao;
				} else if ( r.getResultado() > resultadoTrono.getResultado() ) {
					resultadoTrono = r;
					coordenada = solucao;
				}
			} else {
				if ( null == resultadoTrono ) {
					resultadoTrono = r;
					coordenada = solucao;
				} else if ( r.getResultado() < resultadoTrono.getResultado() ) {
					resultadoTrono = r;
					coordenada = solucao;
				}				
			}
			
			
		}
		
		resultadoTrono.setCoordenada( coordenada );
		resultadoTrono.setRegiaoViavel( pontosCandidatos );
		
		String obj = eq.getFuncObjetivo().getObjetivoEquacao();
		String descX = eq.getFuncObjetivo().getDescricaoX();
		String descY = eq.getFuncObjetivo().getDescricaoY();
		String medidaX = eq.getFuncObjetivo().getMedidaX();
		String medidaY = eq.getFuncObjetivo().getMedidaY();
		
		eq.setResultado( resultadoTrono );
		eq.getResultado().setDescResposta("Para atingir o " + obj + " de " + eq.getResultado().getResultado() + " é necessário : " + eq.getResultado().getCoordenada().getX() + " " + medidaX + " de " + descX + " e  " + eq.getResultado().getCoordenada().getY() + " " + medidaY + " de " + descY);

		return eq;
	}
}