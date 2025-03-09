package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {
    private AndroidDriver driver;

    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickNumber(int number) {
        String id = String.valueOf(number);
        WebElement element = driver.findElement(AppiumBy.accessibilityId(id));
        element.click();
    }

    public void clickPlus() {
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
    }

    public void clickEquals() {
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
    }

    public void clear() {
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
    }
    public String obterResultado() {
        WebElement resultadoElement = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        return resultadoElement.getText();
   }
}

