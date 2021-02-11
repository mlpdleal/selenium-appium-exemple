package br.com.cursoAppium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.MenuPage;
import br.com.cursoAppium.page.SplashPage;

public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void deveAguardarSplash() {
		
		//acessar menu Splash
		menu.acessarSplash();
		
		//Verificar que o splash está sendo exibido
		splash.isTelaSplashVisivel();
		splash.aguardarSplashSumir();
		
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
		

	}

}
