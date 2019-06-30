package br.com.pl.viewhelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pl.domain.Equacao;
import br.com.pl.domain.FuncaoObjetivo;
import br.com.pl.domain.Restricao;
import br.com.pl.domain.RestricaoLimite;

public class VHEquacao {

	public Equacao getEquacao(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int contador = Integer.parseInt(request.getParameter("qtdRestricoes"));
	
	
		String stObjetivo = request.getParameter("stObjetivo");
		String stVariavelX = request.getParameter("stVariavelX");
		String stVariavelY = request.getParameter("stVariavelY");
		String stUnidadeMedidaX = request.getParameter("stUnidadeMedidaX");
		String stUnidadeMedidaY = request.getParameter("stUnidadeMedidaY");
		
		
		FuncaoObjetivo funcaoObjetivo = new FuncaoObjetivo();
		
		funcaoObjetivo.setVariavelX(Double.parseDouble(request.getParameter("valorVariavelX")));
		funcaoObjetivo.setVariavelY(Double.parseDouble(request.getParameter("valorVariavelY")));
		funcaoObjetivo.setOperador(request.getParameter("operadorFuncaoObjetivo"));
		funcaoObjetivo.setObjetivoEquacao(request.getParameter("stObjetivo"));
		
		RestricaoLimite restricaoLimite = new RestricaoLimite();

		restricaoLimite.setLimiteInferiorX(Double.parseDouble(request.getParameter("limiteInferiorX")));
		restricaoLimite.setLimiteInferiorY(Double.parseDouble(request.getParameter("limiteInferiorY")));
		if (!request.getParameter("limiteSuperiorX").isEmpty()) {
			restricaoLimite.setLimiteSuperiorX(Double.parseDouble(request.getParameter("limiteSuperiorX")));
			}
		if (!request.getParameter("limiteSuperiorY").isEmpty())
		{
			restricaoLimite.setLimiteSuperiorY(Double.parseDouble(request.getParameter("limiteSuperiorY")));
		}

		Restricao restricao = null;
		List<Restricao> restricoes = new ArrayList<>();
		
		for(int i = 1; i <= contador; i++) {
			restricao = new Restricao();
			restricao.setOperador(request.getParameter("operadorEquacaoRestricao"+i));
			restricao.setResultado(Double.parseDouble(request.getParameter("resultadoRestricao"+i)));
			restricao.setVariavelX(Double.parseDouble(request.getParameter("coeficienteX"+i)));
			restricao.setVariavelY(Double.parseDouble(request.getParameter("valorYRestricao"+i)));
			restricoes.add(restricao);
		}
			
		
		Equacao equacao = new Equacao();
		equacao.setTipoProblema(request.getParameter("tipoProblema"));
		equacao.setFuncObjetivo(funcaoObjetivo);
		equacao.setLimites(restricaoLimite);
		equacao.setRestricoes(restricoes);
		
		equacao.getFuncObjetivo().setObjetivoEquacao(stObjetivo);
		equacao.getFuncObjetivo().setDescricaoX(stVariavelX);
		equacao.getFuncObjetivo().setDescricaoY(stVariavelY);
		equacao.getFuncObjetivo().setMedidaX(stUnidadeMedidaX);
		equacao.getFuncObjetivo().setMedidaY(stUnidadeMedidaY);	
	
		
		return equacao;
		
	}
	
	public void setView(Equacao eq, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		request.setAttribute("msg", eq.getResultado().getDescResposta());
	
		RequestDispatcher rd = request.getRequestDispatcher("web/Solucao.jsp");
		rd.forward(request, response);
		
	}
}