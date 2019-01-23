import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;


class LoginTest {
    private static MainPage mainPage;
    private static ProfilePage profilePage;

    @BeforeAll
    static void before(){
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfilePage();
    }

    @ParameterizedTest
    @CsvSource({
            "14700001112, 123456, '用户名或密码错误'",
            "123456789091, 123456, '手机号码填写错误'"
    })
    void passwordLoginFail(String account, String pwd, String expect){
        LoginPage loginPage = profilePage.gotoLoginPage();

        loginPage.passwordLoginFail(account, pwd);
        Assertions.assertEquals(expect, loginPage.getMsg());
        profilePage = loginPage.gotoProfilePage();
    }

    @ParameterizedTest
    @CsvSource({
            "18721120188, ********"
    })
    void passwordLoginSuccess(String account, String pwd){
        LoginPage loginPage = profilePage.gotoLoginPage();

        mainPage = loginPage.passwordLoginSuccess(account, pwd);

        profilePage = mainPage.gotoProfilePage();
        Assertions.assertTrue(profilePage.isLogin());
        profilePage.gotoMainPage();

    }
}
