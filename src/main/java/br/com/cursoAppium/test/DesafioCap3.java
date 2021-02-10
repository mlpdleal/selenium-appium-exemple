package br.com.cursoAppium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesafioCap3 {

	@Test
	public void preencherFormulario() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.APP,
				"/home/manoel/Documents/automation_projects/selenium-appium-exemple/src/main/resources/CTAppium_1_2(1).apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Manoel");
		String valorCampoNome = campoNome.getText();

		MobileElement comboConsole = driver.findElement(MobileBy.AccessibilityId("console"));
		comboConsole.click();

		MobileElement PS4 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']"));
		PS4.click();

		String ps4Text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

		MobileElement checkElement = driver.findElement(MobileBy.AccessibilityId("check"));
		checkElement.click();
		String isCheck = checkElement.getAttribute("checked");

		MobileElement switchElement = driver.findElement(MobileBy.AccessibilityId("switch"));
		switchElement.click();
		String switchIsCheck = switchElement.getAttribute("checked");

		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();

		assertEquals("Nome: " + valorCampoNome,
				driver.findElement(By.xpath("//android.widget.TextView[@index='12']")).getText());
		assertEquals("Console: " + (ps4Text.toLowerCase()),
				driver.findElement(By.xpath("//android.widget.TextView[@index='13']")).getText());
		assertEquals("Switch: " + switchIsOn(switchIsCheck),
				driver.findElement(By.xpath("//android.widget.TextView[@index='15']")).getText());
		assertEquals("Checkbox: " + checkMarcado(isCheck),
				driver.findElement(By.xpath("//android.widget.TextView[@index='16']")).getText());

		driver.quit();
	}

	private String checkMarcado(String value) {

		if (value.equals("true")) {
			return "Marcado";
		}

		return "Desabilitado";
	}

	private String switchIsOn(String value) {
		if (value.equals("true")) {
			return "On";
		}

		return "Off";
	}

}
