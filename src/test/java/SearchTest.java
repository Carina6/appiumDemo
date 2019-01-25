import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

class SearchTest {
    private static MainPage mainPage;
    private static SearchPage searchPage;

    @BeforeAll
    static void init(){
        mainPage = MainPage.start();
    }

    @BeforeEach
    void gotoSearchPage(){
        searchPage = mainPage.gotoSearchPage();
    }

    @AfterEach
    void gotoMainPage(){
        mainPage = mainPage.gotoMainPage();
    }

    @ParameterizedTest
    @CsvSource({
            "xiaomi, 小米集团-W",
            "pdd, 拼多多"
    })
    void search(String content, String name){
        String actual = searchPage.search(content).getResults().get(0);
        Assertions.assertEquals(name, actual);
    }

    @ParameterizedTest
//    @CsvSource({
//            "xiaomi, 小米集团-W",
//            "pdd, 拼多多"
//    })
    @CsvFileSource(resources = "/SearchTest.csv")
    void addSelected(String content, String name){
        String actual = searchPage.search(content).getResults().get(0);
        Assertions.assertEquals(name, actual);

        searchPage.addSelected();

        MatcherAssert.assertThat(searchPage.cancel().gotoSelectedPage().getAll(), Matchers.hasItem(name));
    }

    @ParameterizedTest
    @CsvSource({
            "xiaomi, 小米集团-W",
            "pdd, 拼多多"
    })
    void removeSelected(String content, String name){
        String actual = searchPage.search(content).getResults().get(0);
        Assertions.assertEquals(name, actual);

        searchPage.removeSelected();

        if(searchPage.cancel().gotoSelectedPage().getAll().contains(name)){
            Assertions.fail();
        }else {
            Assertions.assertTrue(true);
        }
    }

}
