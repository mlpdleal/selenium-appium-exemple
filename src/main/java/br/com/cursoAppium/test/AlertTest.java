package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.AlertasPage;
import br.com.cursoAppium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertasPage alertas = new AlertasPage();

	@Test
	public void deveConfirmarAlerta() {
		
		menu.acessarAlertas();
		alertas.clicarAlertaConfirm();
		assertEquals("Confirma a operação?", alertas.recuperarTextoMensagemInfo());
		
		alertas.clicarConfirmar();
		assertEquals("Confirmado", alertas.recuperarTextoInfoSair());
		
		alertas.clicarSair();
	}
}
