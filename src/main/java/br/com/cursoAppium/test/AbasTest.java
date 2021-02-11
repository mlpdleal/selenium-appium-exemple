package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AbasPage;
import br.com.cursoAppium.page.MenuPage;

public class AbasTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		assertEquals("Este é o conteúdo da Aba 1", abas.obterTextoAba1());
		
		//acessar aba 2
		abas.clicarAba2();
		
		//verificar que esta na aba 2
		assertEquals("Este é o conteúdo da Aba 2", abas.obterTextoAba2());
		
	}

}
