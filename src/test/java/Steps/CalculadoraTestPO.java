package Steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CalculadoraTestPO {

    private AndroidDriver driver;

   
  @BeforeEach
  public void iniciar() {
    @SuppressWarnings("rawtypes")
    var options = new BaseOptions()
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

    static Stream<String[]> lerCSV() {
        try {
            List<String[]> dados = Files.lines(Path.of("src/test/resources/csv/soma.csv"))
                .skip(1) // Pular cabeçalho
                .map(linha -> linha.split(",")) // Dividir por vírgula
                .toList();
            return dados.stream();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler CSV", e);
        }
    }

    @ParameterizedTest
    @MethodSource("lerCSV")
    public void testarSoma(String num1, String num2, String resultadoEsperado) {
        driver.findElement(AppiumBy.accessibilityId(num1)).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.accessibilityId(num2)).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

                // Obtém o resultado da tela
        String resultadoObtido = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();

        // Valida se o resultado está correto
        Assertions.assertEquals(resultadoEsperado, resultadoObtido, 
            "Erro na soma: " + num1 + " + " + num2 + " deveria ser " + resultadoEsperado);
    }
    

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}