package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
	
	public void escreverCampoNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterValorCampoNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterTextoSelecionadoCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarSeekBar(double posicao) {
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		
		int x =  (int) (seek.getLocation().x + (seek.getSize().width * posicao));
		
		tap(x, y);
	}
	
	public void clicarNoCheck() {
		clicar(MobileBy.AccessibilityId("check"));
	}
	
	public void clicarNoSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("check"));
	}
	
	public boolean isSwitchOn() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSalvar() {
		clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	}
	
	public void clicarSalvarDemorado() {
		clicar(By.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']"));
	}
	
	public String obterTextoNome() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='12']"));
	}
	
	public String obterTextoConsole() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='13']"));
	}
	
	public String obterTextoSwitch() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='15']"));
	}
	
	public String obterTextoCheck() {
		return obterTexto(By.xpath("//android.widget.TextView[@index='16']"));
	}
	
	public String obterTextoData() {
		return obterTexto(By.xpath("//*[@text='20/2/2000']"));
	}

}
