package br.com.pl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pl.domain.Calculo;
import br.com.pl.domain.Equacao;
import br.com.pl.viewhelper.VHEquacao;


/**
 * Servlet implementation class Servlet
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VHEquacao vhequacao = new VHEquacao();
		Equacao equacao = vhequacao.getEquacao(request);
		Calculo cal = new Calculo();
		equacao = cal.calcular(equacao);
		
		vhequacao.setView(equacao, request, response);
		
}			

}
