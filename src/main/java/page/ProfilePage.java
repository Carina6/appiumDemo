package page;

import org.openqa.selenium.By;

public class ProfilePage extends BasePage{
    public By login = locate("tv_login");

    public LoginPage gotoLoginPage(){
        findElement(login).click();
        return new LoginPage();
    }

}
