var contador = 1;

	$("#adicionarRestricao").click(function(){
		
		var valorYRestricao = "valorYRestricao" + contador;
		var valorXRestricao = "valorXRestricao" + contador;

		$("#restricoes").append(`
				Restrição ` + contador + ` 
		      	<input type="text" name="coeficienteX${contador}" placeholder="Coeficiente de x" style="width: 130px;"> x  
				<select name="operadorRestricao${contador}">
			        <option value="operadorSoma">+</option>
			        <option value="operadorSubtracap">-</option>
		     	</select>
		      	<input type="text" name="valorYRestricao${contador}" placeholder="Coeficiente de y" style="width: 130px;"> y
		      	<select name="operadorEquacaoRestricao${contador}">
			        <option value="=">=</option>
			        <option value="<="><=</option>
			        <option value=">=">>=</option>
		     	</select>	
		     	<input type="text" name="resultadoRestricao${contador}" placeholder="Resultado da restrição" style="width: 230px;">
		     	<br><br>
				`)
				contador++;
		
	})
	
	$("#formulario").submit(function(){
		$("#formulario").append(`
				<input type="hidden" name="qtdRestricoes" value="${--contador}">
		`)
	})
	
	function validaForm(frm){
		   
		   //funcao para validação do formulário
		
		   //Valida se valorVariavelX não foi preenchido
		   if(frm.valorVariavelX.value == "" || frm.valorVariavelX.value == null) {
		       alert("Por favor, indique o valor da variável x.");
		       frm.valorVariavelX.focus();
		       return false;
		   }
		   
		 //Valida se valorVariavelY não foi preenchido
		   if(frm.valorVariavelY.value == "" || frm.valorVariavelY.value == null) {
		       alert("Por favor, indique o valor da variável y.");
		       frm.valorVariavelY.focus();
		       return false;
		   }
		 
		 //Valida se stObjetivo não foi preenchido
		   if(frm.stObjetivo.value == "" || frm.stObjetivo.value == null) {
		       alert("Por favor, indique objetivo da função.");
		       frm.stObjetivo.focus();
		       return false;
		   }
		 
		   
		 //Valida se stVariavelX não foi preenchido
		   if(frm.stVariavelX.value == "" || frm.stVariavelX.value == null) {
		       alert("Por favor, indique a descrição da variável x.");
		       frm.stVariavelX.focus();
		       return false;
		   }
		   
		 //Valida se stVariavelY não foi preenchido
		   if(frm.stVariavelY.value == "" || frm.stVariavelY.value == null) {
		       alert("Por favor, indique a descrição da variável y.");
		       frm.stVariavelY.focus();
		       return false;
		   }
		   
		 //Valida se stUnidadeMedidaX não foi preenchido
		   if(frm.stUnidadeMedidaX.value == "" || frm.stUnidadeMedidaX.value == null) {
		       alert("Por favor, indique a unidade de medida da variável x.");
		       frm.stUnidadeMedidaX.focus();
		       return false;
		   }
		   
		 //Valida se stUnidadeMedidaY não foi preenchido
		   if(frm.stUnidadeMedidaY.value == "" || frm.stUnidadeMedidaY.value == null) {
		       alert("Por favor, indique a unidade de medida da variável y.");
		       frm.stUnidadeMedidaY.focus();
		       return false;
		   }
		   
		 
		   
//		 //Valida se limiteSuperiorX não foi preenchido
//		   if(frm.limiteSuperiorX.value == "" || frm.limiteSuperiorX.value == null) {
//		       alert("Por favor, indique o limite superior para a variável x.");
//		       frm.limiteSuperiorX.focus();
//		       return false;
//		   }
//		   
//		 //Valida se limiteSuperiorY não foi preenchido
//		   if(frm.limiteSuperiorY.value == "" || frm.limiteSuperiorY.value == null) {
//		       alert("Por favor, indique o limite superior para a variável y.");
//		       frm.limiteSuperiorY.focus();
//		       return false;
//		   }
		 
		 //Valida se limiteInferiorX e Y não foi preenchido
		   if(frm.limiteInferiorX.value == "" || frm.limiteInferiorX.value == null || frm.limiteInferiorY.value == "" || frm.limiteInferiorY.value == null) {		  
			   alert("O limite inferior da variável x e y será automaticamente 0");
				frm.limiteInferiorX.value = '0';
				frm.limiteInferiorY.value = '0';
				   return true;
				   
		   }
		 
	   }