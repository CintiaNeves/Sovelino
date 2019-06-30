<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet"
		href="./plugins/bootstrap-4/css/bootstrap.min.css">


    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<!-- Title -->
<title>Sovelino</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-primary navbar-expand-lg"> <a
		class="navbar-brand" href="#">SOVELINO</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	</nav>
	<br>
	<center> <img src="logo.png" height="120" width="120"></center>
	<p> O Sovelino é uma ferramenta web para a resolução de problemas de programação linear através do método gráfico, com duas variáveis e sem limitações quanto ao número de restrições dos problemas.
	</p>
	<fieldset class="border p-2">
   <legend  class="w-auto">  &nbsp Resolução de problemas de programação linear &nbsp </legend>
	<div class="container">
	
	<form id="formulario" action="../Servlet"
		method="POST" class="container" onsubmit="return validaForm(this);">
				<u><h5>PROBLEMA</h5></u>
	
						<label for="tipoProblema">O seu problema é de: </label> <select
							name="tipoProblema">
							<option value="maximizacao">Maximização</option>
							<option value="minimizacao">Minimização</option>
						</select>
				<hr>


				<legend>
				<bold>	<h5>FUNÇÃO OBJETIVO</h5></bold>
				</legend>
				Defina sua função objetivo: <input type="text" name="valorVariavelX"
					placeholder="Coeficiente de x" style="width: 130px;"> x <select
					name="operadorFuncaoObjetivo">
					<option value="+">+</option>
					<option value="-">-</option>
				</select> <input type="text" name="valorVariavelY"
					placeholder="Coeficiente de y" style="width: 130px;"> y = <input type="text"
					name="stObjetivo" placeholder="Lucro máximo..."> </br>
				<hr>
				<legend>
					<u><h5>VARIÁVEIS DE DECISÃO</h5></u>
				</legend>
				</br> x = <input type="text" name="stVariavelX"
					placeholder="Produção de Trigo"> U.M. <input type="text"
					name="stUnidadeMedidaX" placeholder="Kilo ..." style="width: 130px;"> </br> y = <input
					type="text" name="stVariavelY" placeholder="Produção de Arroz">
				U.M. <input type="text" name="stUnidadeMedidaY"
					placeholder="Kilo ..." style="width: 130px;"> </br>
				<hr>
				<legend>
					<u><h5>LIMITES DA EQUACÃO</h5></u>
				</legend>
				</br> x >= <input type="text" name="limiteInferiorX"
					placeholder="Limite inferior da variável x" style="width: 220px;"> </br> y >= <input
					type="text" name="limiteInferiorY" placeholder="Limite inferior da variável y" style="width: 220px;">
				 </br>
				 </br> x <= <input type="text" name="limiteSuperiorX"
					placeholder="Limite superior da variável x" style="width: 220px;"> </br> y <= <input
					type="text" name="limiteSuperiorY" placeholder="Limite superior da variável y" style="width: 220px;">
				 </br>
				<hr>
				<legend>
					<u><h5>RESTRIÇÕES</h5></u>
				</legend>
				</br> Este problema está sujeito a: </br></br>
				<div id="restricoes" class="restricoes"></div>

				<!-- <button type="button" id="adicionarRestricao">Adicionar</button> -->
				
				<button type="button" id="adicionarRestricao" class="btn btn-outline-info">
        		  <span class="glyphicon glyphicon-plus"></span> + Adicionar restrição
        		</button>

				<button class="btn btn-success" id="btnOperacaoCalcular"
					name="btnOperacao" value="Calcular">Calcular</button>

				<hr />
	</form>
</div>
</fieldset>

<div class="footer-bottom-area">
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-12 h-100">
                        <div class="footer-bottom-content h-100 d-md-flex justify-content-between align-items-center">
                            <div class="copyright-text">
                                <p style="color:white;">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template was made by GrubLube
</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
<script src="javascript/jquery.min.js"></script>
<script src="plugins/bootstrap-4/js/bootstrap.min.js"></script>
<script src="javascript/script.js"></script>

</html>