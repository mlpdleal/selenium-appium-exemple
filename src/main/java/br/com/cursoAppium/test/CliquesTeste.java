package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.CliquesPage;
import br.com.cursoAppium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage cliques = new CliquesPage();
	
	@Before
	public void setUp() {
		//acessar menu
		menu.acessarCliques();	
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		//clique longo
		cliques.cliqueLongo();
		
		//validar texto
		Assert.assertEquals("Clique Longo", cliques.obterTextoCampo());
		
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		cliques.clicarPorTexto("Clique duplo");
		cliques.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", cliques.obterTextoCampo());
	}

}
