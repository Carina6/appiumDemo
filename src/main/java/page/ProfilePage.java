package page;

import driver.Driver;
import org.openqa.selenium.By;

public class ProfilePage {
    public static By login = By.id("tv_login");

    public LoginPage gotoLoginPage(){
        Driver.getDriver().findElement(login).click();
        return new LoginPage();
    }

}
