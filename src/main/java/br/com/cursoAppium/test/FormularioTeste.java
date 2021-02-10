package br.com.cursoAppium.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/home/manoel/Documents/automation_projects/selenium-appium-exemple/src/main/resources/CTAppium_1_2(1).apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		elementosEncontrados.get(1).click();

		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Manoel");

		String text = campoNome.getText();
		Assert.assertEquals("Manoel", text);

		driver.quit();

	}
	
	
	@Test
	public void deveInteragirComOCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/home/manoel/Documents/automation_projects/selenium-appium-exemple/src/main/resources/CTAppium_1_2(1).apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		String texto = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		
		Assert.assertEquals("Nintendo Switch", texto);
		
		driver.quit();

	}
	
	@Test
	public void deveInteragirCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/home/manoel/Documents/automation_projects/selenium-appium-exemple/src/main/resources/CTAppium_1_2(1).apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		
		check.click();
		
		MobileElement switchElement = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		switchElement.click();
		
		Assert.assertEquals("true",check.getAttribute("checked"));
		Assert.assertEquals("false", switchElement.getAttribute("checked"));
		
		driver.quit();

	}
	

}
