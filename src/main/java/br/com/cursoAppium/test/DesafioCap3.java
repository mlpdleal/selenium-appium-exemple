package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.DriverFactory;
import br.com.cursoAppium.page.FormularioPage;
import br.com.cursoAppium.page.MenuPage;

public class DesafioCap3 {
	
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	
	@Before
	public void setUp() {
		menu.acessarFormulario();
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void preencherFormulario() throws MalformedURLException {
		formulario.escreverCampoNome("Manoel");
		String valorCampoNome = formulario.obterValorCampoNome();
	    formulario.selecionarCombo("PS4");
        String ps4Text = formulario.obterTextoSelecionadoCombo().toLowerCase();
        formulario.clicarNoCheck();
        boolean marcado = formulario.isCheckMarcado();
        formulario.clicarNoSwitch();
        boolean on = formulario.isSwitchOn();
        formulario.clicarSalvar();

		assertEquals("Nome: " + valorCampoNome, formulario.obterTextoNome());
		assertEquals("Console: " + ps4Text, formulario.obterTextoConsole());
		assertEquals("Switch: " + switchIsOn(on), formulario.obterTextoSwitch());
		assertEquals("Checkbox: " + checkMarcado(marcado), formulario.obterTextoCheck());

	}

	private String checkMarcado(boolean marcado) {

		if (marcado) {
			return "Marcado";
		}

		return "Desabilitado";
	}

	private String switchIsOn(boolean on) {
		if (on) {
			return "On";
		}

		return "Off";
	}

}
