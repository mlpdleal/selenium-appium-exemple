package br.com.cursoAppium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.cursoAppium.core.DSL;
import br.com.cursoAppium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

	private DSL dsl = new DSL();

	@Before
	public void setUp() throws MalformedURLException {
		dsl.clicarPorTexto("Formulário");
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Manoel");
		assertEquals("Manoel", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		String texto = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", texto);
	}

	@Test
	public void deveInteragirCheckBox() throws MalformedURLException {
		dsl.clicar(MobileBy.AccessibilityId("check"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}

}
