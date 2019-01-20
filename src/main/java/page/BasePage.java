package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebElement findElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    By locate(String locator){
        return By.id(locator);
    }

    By text(String context){
        return By.xpath("//*[@text='" + context + "']");
    }
}
