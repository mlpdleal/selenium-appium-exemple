package br.com.cursoAppium.page;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;

import br.com.cursoAppium.core.BasePage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage {

	public void cliqueLongo() {
		
		LongPressOptions lpOptions = LongPressOptions.longPressOptions()
				.withDuration(Duration.ofMillis(1000))
				.withElement(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))));
		
		new AndroidTouchAction(getDriver())
		.longPress(lpOptions).release().perform();
	}

	public String obterTextoCampo() {
		/*
		 * xpath entre parenteses indica uma busca global, ou seja,
		 * vai buscar todas as ocorrências de android.widget.TextView na estrutura
		 * listar as ocorrências na ordem de apresentação
		 * e pegar a terceira ocorrência 
		 */
		return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
	}

}
