package br.com.cursoAppium.page;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {
	
	private DSL dsl = new DSL();
	
	public void escreverCampoNome(String nome) {
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterValorCampoNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterTextoSelecionadoCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarNoCheck() {
		dsl.clicar(MobileBy.AccessibilityId("check"));
	}
	
	public void clicarNoSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("check"));
	}
	
	public boolean isSwitchOn() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSalvar() {
		dsl.clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	}
	
	public String obterTextoNome() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
	}
	
	public String obterTextoConsole() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
	}
	
	public String obterTextoSwitch() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String obterTextoCheck() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}

}
