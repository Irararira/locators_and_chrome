package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    private final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Login open(String url) {
        driver.get(url);
        return this;
    }

    public Login waitElementVisibleByCssSelector(String selector) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        return this;
    }

    public Login consentForm(String className, String name){
        WebElement element = driver.findElement(By.className(className));

        if (element != null) {
            driver.findElement(By.name(name)).click();
        }
        return this;
    }

    public Login clickByCssSelector(String selector){
        driver.findElement(By.cssSelector(selector)).click();
        return this;
    }

    public Login sendKeyCssSelector(String selector, String value){
        driver.findElement(By.cssSelector(selector)).sendKeys(value);
        return this;
    }



}
