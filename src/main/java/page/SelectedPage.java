package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SelectedPage extends BasePage {
    private By portfolioStockName = locate("portfolio_stockName");

    private By actionSearch = locate("action_create_cube");
    private By editGroup = locate("edit_group");
    private By c = locate("portfolio_stockName");

    public ArrayList<String> getAll() {
        ArrayList<String> results = new ArrayList<String>();
        for(WebElement we: findElements(portfolioStockName)){
            results.add(we.getText());
        }
        return results;
    }

    public SearchPage gotoSearchPage(){
        findElement(actionSearch).click();
        return new SearchPage();
    }

    public GroupPage gotoGroupPage(){
        findElement(editGroup).click();
        return new GroupPage();
    }

}
