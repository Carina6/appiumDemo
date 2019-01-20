package page;

import driver.Driver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{
    // 表示页面中的控件
    private By profile = By.id("user_profile_icon");

    // 更新页弹窗
    private By update = By.id("update_id_ok");
    private By imageCancel = By.id("image_cancel");

    public static MainPage start(){
        try {
            Driver.start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MainPage();
    }

    public ProfilePage goToProfilePage(){
        Driver.getDriver().findElement(profile).click();
        return new ProfilePage();
    }

    public SearchPage search(String name){
        return new SearchPage();
    }

    public void add(){

    }

    public List<Object> getContentByFilter(String name){
        return new ArrayList<Object>();
    }


}
