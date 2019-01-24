package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class GroupPage extends BasePage{
    private By stockName = locate("stockName");
    private By check = locate("check");
    private By cancelFollow = locate("cancel_follow");
    private By buttonDefaultPositive = locate("md_buttonDefaultPositive");
    private By buttonDefaultNegative = locate("md_buttonDefaultNegative");

    private By actionClose = locate("action_close");

    public GroupPage cancelYes(){
        findElement(cancelFollow).click();
        findElement(buttonDefaultPositive).click();
        return this;
    }

    public GroupPage cancelNo(){
        findElement(cancelFollow).click();
        findElement(buttonDefaultNegative).click();
        return this;
    }

    public SelectedPage gotoSelectedPage(){
        findElement(actionClose).click();
        return new SelectedPage();
    }

    public ArrayList<String> getAllStockName() {
        ArrayList<String> allStockName = new ArrayList<String>();
        for(WebElement we: findElements(stockName)){
            allStockName.add(we.getText());
        }
        return allStockName;
    }

    public ArrayList<WebElement> getAllCheck() {
        return new ArrayList<WebElement>(findElements(check));
    }
}
