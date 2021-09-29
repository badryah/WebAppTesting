package UdemyWebApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class SearchMethod {
public static AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Nexus5-trining");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","8.1.0");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("chromdriverExecutable","D:\\Programs\\Selenium\\Driver\\chromedriver.exe");
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.udemy.com/");
	}
	
	@Test
	public void searchtest() throws InterruptedException {
		driver.findElementById("mobile-header-open-search-icon").click();
		driver.findElementById("header-mobile-search-bar").sendKeys("testing");
		Thread.sleep(3000);
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterTest
	public void CloseApp() {
		driver.quit();
	}

}
