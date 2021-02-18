package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AlertasPage;
import br.com.cursoAppium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertasPage alertas = new AlertasPage();
	
	@Before
	public void setUp() {
		menu.acessarAlertas();
	}

	@Test
	public void deveConfirmarAlerta() {
		
		
		alertas.clicarAlertaConfirm();
		assertEquals("Confirma a operação?", alertas.recuperarTextoMensagemInfo());
		
		alertas.clicarConfirmar();
		assertEquals("Confirmado", alertas.recuperarTextoInfoSair());
		
		alertas.clicarSair();
	}
	
	@Test
	public void deveClicarForaAlerta() throws InterruptedException {
		alertas.clicarAlertaSimples();
		
		Thread.sleep(2000);
		alertas.press(100, 150);
		
		Assert.assertFalse(alertas.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
