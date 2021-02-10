package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.page.FormularioPage;
import br.com.cursoAppium.page.MenuPage;

public class FormularioTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();

	@Before
	public void setUp() throws MalformedURLException {
		menu.acessarFormulario();
	}


	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		formulario.escreverCampoNome("Manoel");
		assertEquals("Manoel", formulario.obterValorCampoNome());
	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {
		formulario.selecionarCombo("Nintendo Switch");
		String texto = formulario.obterTextoSelecionadoCombo();
		Assert.assertEquals("Nintendo Switch", texto);
	}

	@Test
	public void deveInteragirCheckBox() throws MalformedURLException {
		formulario.clicarNoCheck();
		formulario.clicarNoSwitch();
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchOn());
	}

}
