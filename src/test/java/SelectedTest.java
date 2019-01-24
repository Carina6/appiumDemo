import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import page.GroupPage;
import page.MainPage;
import page.SearchPage;
import page.SelectedPage;

import java.util.ArrayList;

class SelectedTest {
    private static MainPage mainPage;
    private static SelectedPage selectedPage;

    @BeforeAll
    static void init(){
        mainPage = MainPage.start();
        selectedPage = mainPage.gotoSelectedPage();
    }

    @ParameterizedTest
    @CsvSource({
            "xiaomi, 小米集团-W",
            "pdd, 拼多多"
    })
    void addSelected(String content, String name){
        SearchPage searchPage = selectedPage.gotoSearchPage();

        String actual = searchPage.search(content).getResults().get(0);
        Assertions.assertEquals(name, actual);

        searchPage.addSelected();

        MatcherAssert.assertThat(searchPage.cancel().gotoSelectedPage().getAll(), Matchers.hasItem(name));

    }

    @ParameterizedTest
    @CsvSource({
            "小米集团-W",
            "拼多多"
    })
    void removeSelected(String name){
        GroupPage groupPage = selectedPage.gotoGroupPage();
        ArrayList<String> allName = groupPage.getAllStockName();
        ArrayList<WebElement> allCheck = groupPage.getAllCheck();

        int index = allName.indexOf(name);
        if(index == -1){
            Assertions.fail(String.format("can not find the name:%s", name));
        }

        allCheck.get(index).click();
        groupPage.cancelYes();

        allName = groupPage.getAllStockName();
        if(allName.contains(name)){
            Assertions.fail(String.format("not remove the name: %s",name));
        }

        groupPage.gotoSelectedPage();
        allName = selectedPage.getAll();
        if(allName.contains(name)){
            Assertions.fail(String.format("not remove the name: %s",name));
        }
    }

}
