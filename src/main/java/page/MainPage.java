package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{
    // 个人中心
    private By profile = locate("user_profile_icon");

    // 更新页弹窗
    private By update = locate("update_id_ok");
    private By imageCancel = locate("image_cancel");

    private By homeSearch = locate("home_search");

    private By mainPageBtn = text("雪球");
    private By optionBtn = text("自选");
//    private By optionBtn1 = By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']");
    private By optionBtn3 = locate("tab_name");


    public static MainPage start(){
        try {
            Driver.start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MainPage();
    }

    public ProfilePage gotoProfilePage(){
        try {
            findElement(profile).click();
        }catch (NoSuchElementException e){
            findElement(imageCancel).click();
            findElement(profile).click();
        }

        return new ProfilePage();
    }

    public SearchPage gotoSearchPage(){
        findElement(homeSearch).click();
        return new SearchPage();
    }

    public MainPage gotoMainPage(){
        findElement(mainPageBtn).click();
        return this;
    }

    public SelectedPage gotoSelectedPage(){
//        findElement(optionBtn1).click();
        findElements(optionBtn3).get(1).click();
        return new SelectedPage();
    }

    public void add(){

    }

    public List<Object> getContentByFilter(String name){
        return new ArrayList<Object>();
    }

}
