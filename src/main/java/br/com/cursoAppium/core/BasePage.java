package br.com.cursoAppium.core;

import static br.com.cursoAppium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	public void clicarPorTexto(String texto) {
		getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public String obterAtributo(By by, String atributo) {
		return getDriver().findElement(by).getAttribute(atributo);
	}

	public void press(int x, int y) {
		new AndroidTouchAction(getDriver()).press(PointOption.point(x, y)).perform();
	}

	public void tap(int x, int y) {
		new AndroidTouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * inicio);

		int end_y = (int) (size.height * fim);
		
		LongPressOptions lpOptions = LongPressOptions.longPressOptions()
				.withDuration(Duration.ofMillis(2000)).withPosition(PointOption.point(x, start_y));

		AndroidTouchAction touchAction = new AndroidTouchAction(getDriver())
			.longPress(lpOptions)			
			.moveTo(PointOption.point(x, end_y))
			.release();
		
		touchAction.perform();
	}

}
