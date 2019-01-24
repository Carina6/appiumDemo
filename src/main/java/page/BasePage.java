package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    By locate(String locator){
        return By.id(locator);
    }

    By text(String context){
        return By.xpath("//*[@text='" + context + "']");
    }

    WebElement findElement(By locator) throws NoSuchElementException{
        return Driver.getDriver().findElement(locator);
    }

    List<WebElement> findElements(By locator){
        return Driver.getDriver().findElements(locator);
    }

}
