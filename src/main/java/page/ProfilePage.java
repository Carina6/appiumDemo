package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ProfilePage extends BasePage{
    private By login = locate("tv_login");
    private By actionBack = locate("action_back");

    public LoginPage gotoLoginPage(){
        findElement(login).click();
        return new LoginPage();
    }

    public boolean isLogin(){
        try {
            findElement(login);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public MainPage gotoMainPage(){
        findElement(actionBack).click();
        return new MainPage();
    }

}
