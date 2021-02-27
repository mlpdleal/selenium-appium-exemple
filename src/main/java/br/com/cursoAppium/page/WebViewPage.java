package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class WebViewPage extends BasePage {

	private Set<String> contextHandles = getDriver().getContextHandles();

	public void alterarContexto() {
		getDriver().context("WEBVIEW_com.ctappium");
	}

	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);
		;
	}

	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);
	}

	public void clicarEntrar() {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public String retornaMensagemLogin() {
		return getDriver().findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	}

	public void sairContexto() {
		getDriver().context((String) contextHandles.toArray()[0]);
	}

}
