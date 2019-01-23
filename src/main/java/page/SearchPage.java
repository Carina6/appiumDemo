package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{

    private By searchInputText = locate("search_input_text");
    private By actionClose = locate("action_close");

    private By followBtn = locate("follow_btn");
    private By followedBtn = locate("followed_btn");

    private By buttonDefaultNegative = locate("md_buttonDefaultNegative");

    private By stockName = locate("stockName");

    public SearchPage search(String context){
        findElement(searchInputText).sendKeys(context);
        return this;
    }

    public MainPage cancel(){
        findElement(actionClose).click();
        return new MainPage();
    }

    public ArrayList<String> getResults() {
        ArrayList<String> results = new ArrayList<String>();
        for(WebElement we: findElements(stockName)){
            results.add(we.getText());
        }
        return results;
    }

    public SearchPage addSelected(){
        findElements(followBtn).get(0).click();
        try {
            findElement(buttonDefaultNegative).click();
            return this;
        }catch (NoSuchElementException e){
            return this;
        }
    }

    public SearchPage removeSelected(){
        findElements(followedBtn).get(0).click();
        return this;
    }
}
