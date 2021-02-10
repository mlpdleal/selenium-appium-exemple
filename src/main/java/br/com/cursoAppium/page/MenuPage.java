package br.com.cursoAppium.page;

import br.com.cursoAppium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}
