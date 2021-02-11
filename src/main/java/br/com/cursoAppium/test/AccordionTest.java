package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AccordeonPage;
import br.com.cursoAppium.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordeonPage accordeon = new AccordeonPage();
	
	@Test
	public void deveInteragirComAccordeon() throws InterruptedException {
		//acessar menu
		menu.acessarAccordeon();
		
		//clicar op 1
		accordeon.clicarOpcao1();
		
		//verificar texto op 1
		
		Thread.sleep(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", accordeon.obterValorOp1());
	}

}
