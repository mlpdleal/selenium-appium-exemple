package br.com.cursoAppium.page;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;

public class AccordeonPage extends BasePage {

	public void clicarOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterValorOp1() {
		return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
