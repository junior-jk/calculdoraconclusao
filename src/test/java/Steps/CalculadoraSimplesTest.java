package Steps;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraSimplesTest {

  private AndroidDriver driver;

  @BeforeEach
  public void iniciar() {
    var options = new BaseOptions<>()
      .amend("platformName", "Android")
      .amend("appium:platformVersion", "9.0")
      .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
      .amend("appium:deviceOrientation", "portrait")
      .amend("appium:app", "storage:filename=Calculator (2).apk")
      .amend("appium:appPackage", "com.google.android.calculator")
      .amend("appium:appActivity", "com.android.calculator2.Calculator")
      .amend("appium:automationName", "UiAutomator2")
      .amend("browserName", "")
      .amend("appium:ensureWebviewsHavePages", true)
      .amend("appium:nativeWebScreenshot", true)
      .amend("sauce:options", Map.ofEntries(Map.entry("name", "Appium Desktop Session -- Feb 17, 2025 8:01 PM")))
      .amend("appium:newCommandTimeout", 3600)
      .amend("appium:connectHardwareKeyboard", true);

    driver = new AndroidDriver(this.getUrl(), options);
  }

  @SuppressWarnings("deprecation")
  private URL getUrl() {
    try {
      return new URL(new URI("https://josejuniorc:be97a49e-247d-4a59-8202-29c77950cb2d@ondemand.us-west-1.saucelabs.com:443/wd/hub").toASCIIString());
    } catch (MalformedURLException | URISyntaxException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Test
  public void sampleTest() {

    driver.context("NATIVE_APP");
var el1 = driver.findElement(AppiumBy.accessibilityId("9"));
el1.click();
var el2 = driver.findElement(AppiumBy.accessibilityId("plus"));
el2.click();
var el3 = driver.findElement(AppiumBy.accessibilityId("3"));
el3.click();
var el4 = driver.findElement(AppiumBy.accessibilityId("equals"));
el4.click();
var el5 = driver.findElement(AppiumBy.accessibilityId("clear"));
el5.click();

var el6 = driver.findElement(AppiumBy.accessibilityId("1"));
el6.click();    
var el7 = driver.findElement(AppiumBy.accessibilityId("plus"));
el7.click();
var el8 = driver.findElement(AppiumBy.accessibilityId("1"));
el8.click();
var el9 = driver.findElement(AppiumBy.accessibilityId("equals"));
el9.click();
var el10 = driver.findElement(AppiumBy.accessibilityId("clear"));   
el10.click();

  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
