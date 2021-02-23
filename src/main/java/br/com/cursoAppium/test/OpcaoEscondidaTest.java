package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		menu.scroll(0.3, 0.6);
		
		//clicar menu
		menu.acessarOpcaoEscondida();
		
		//verificar mensagem
		Assert.assertTrue(menu.existeElementoPorTexto("Você achou essa opção"));
		
		//sair
		menu.clicarPorTexto("Você achou essa opção");
		
	}

}
