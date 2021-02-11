package br.com.cursoAppium.page;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class AbasPage extends BasePage {
	
	public String obterTextoAba1() {
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
	}
	
	public String obterTextoAba2() {
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
	}
	
	public void clicarAba2() {
		clicarPorTexto("ABA 2");
	}


}
