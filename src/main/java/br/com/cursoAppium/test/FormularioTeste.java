package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cursoAppium.core.BaseTest;
import br.com.cursoAppium.core.DriverFactory;
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
		assertEquals("Nintendo Switch", texto);
	}

	@Test
	public void deveInteragirCheckBox() throws MalformedURLException {
		formulario.clicarNoCheck();
		formulario.clicarNoSwitch();
		assertTrue(formulario.isCheckMarcado());
		assertFalse(formulario.isSwitchOn());
	}
	
	@Test
	public void cadastroDemorado() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		formulario.escreverCampoNome("Manoel");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']")));
		formulario.clicarSalvarDemorado();
		assertEquals("Nome: Manoel", formulario.obterTextoNome());
	
	}

}
