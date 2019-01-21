package page;

import driver.Driver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{
    // 表示页面中的控件
    // 个人中心
    private By profile = locate("user_profile_icon");

    // 更新页弹窗
    private By update = locate("update_id_ok");
    private By imageCancel = locate("image_cancel");

    private By homeSearch = locate("home_search");
    public static MainPage start(){
        try {
            Driver.start();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new MainPage();
    }

    public ProfilePage gotoProfilePage(){
        findElement(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearchPage(){
        findElement(homeSearch);
        return new SearchPage();
    }

    public void add(){

    }

    public List<Object> getContentByFilter(String name){
        return new ArrayList<Object>();
    }


}
