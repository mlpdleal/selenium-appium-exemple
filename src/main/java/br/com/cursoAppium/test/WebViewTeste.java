package br.com.cursoAppium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.page.WebViewPage;

public class WebViewTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private WebViewPage webView = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		menu.acessarSBHibrido();
		webView.alterarContexto();
		webView.setEmail("ksdfjklasjdflkasdj@gmail.com");
		webView.setSenha("123456");
		webView.clicarEntrar();
		Assert.assertEquals("Bem vindo, teste!", webView.retornaMensagemLogin());
	}
	
	@After
	public void tearDown() {
		webView.sairContexto();
	}

}
