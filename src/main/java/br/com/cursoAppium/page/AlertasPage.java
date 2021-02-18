package br.com.cursoAppium.page;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class AlertasPage extends BasePage {

	public void clicarAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String recuperarTextoMensagemInfo() {
		return obterTexto(By.xpath("//*[@text='Confirma a operação?']"));
	}
	
	public void clicarConfirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public String recuperarTextoInfoSair() {
		return obterTexto(By.xpath("//*[@text='Confirmado']"));
	}
	
	public void clicarSair() {
		clicarPorTexto("SAIR");
	}
}
