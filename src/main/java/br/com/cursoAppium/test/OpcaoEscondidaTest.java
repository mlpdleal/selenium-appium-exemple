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
		menu.scrollToElementByText("Opção bem escondida");
		
		//clicar menu
		
		menu.clicarPorTexto("Opção bem escondida");
		
		//verificar mensagem
		Assert.assertTrue(menu.existeElementoPorTexto("Você achou essa opção"));
		
		//sair
		menu.clicarPorTexto("Você achou essa opção");
		
	}

}
