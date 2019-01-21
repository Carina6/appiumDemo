package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{

    private By searchInputText = locate("search_input_text");
    private By actionClose = locate("action_close");

    private By followBtn = locate("follow_btn");
    private By followedBtn = locate("followed_btn");

    private By buttonDefaultNegative = locate("md_buttonDefaultNegative");
//    private By searchInputText = locate("search_input_text");

    private By stockName = locate("stockName");
    private ArrayList<String> result = new ArrayList<String>();

    public SearchPage search(String context){
        findElement(searchInputText).sendKeys(context);
        return this;
    }

    public MainPage cancel(){
        findElement(actionClose).click();
        return new MainPage();
    }

    public ArrayList<String> getResult() {
        for(WebElement we: findElements(stockName)){
            result.add(we.getText());
        }
        return result;
    }

    public SearchPage addSelected(String name){
        findElements(followBtn).get(0).click();
        return this;
    }
    public SearchPage cancelSelected(String name){
        findElement(followedBtn).click();
        return this;
    }
}
