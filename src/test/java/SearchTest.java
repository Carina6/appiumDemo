import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

public class SearchTest {
    private static MainPage mainPage;
    private static SearchPage searchPage;

    @BeforeAll
    static void init(){
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearchPage();
    }

    @ParameterizedTest
    @CsvSource({
            "xiaomi, 小米集团-W",
            "pdd, 拼多多"
    })
    void search(String content, String name){
        String actual = searchPage.search(content).getResults().get(0);
        MatcherAssert.assertThat(actual, Matchers.equalTo(name));
    }

    @ParameterizedTest
    @CsvSource({
            "xiaomi, 小米集团-W",
            "pdd, 拼多多"
    })
    void addSelected(String content, String name){
        search(content, name);
        searchPage.addSelected();

        MatcherAssert.assertThat(searchPage.cancel().gotoSelectedPage().getAll(), Matchers.contains(name));
        mainPage.gotoMainPage();
    }

}
