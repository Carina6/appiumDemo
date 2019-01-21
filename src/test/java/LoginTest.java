//import org.junit.Test;
//import org.junit.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;


public class LoginTest {
    private static MainPage mainPage;
    private static ProfilePage profilePage;

    @BeforeAll
    public void before(){
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfilePage();
    }

    @ParameterizedTest
    @CsvSource({
            "14700001111, 123456, 用户名或密码错误",
            "1234567, 1234, 手机号错误"
    })
    void notPhone(String account, String pwd, String expect){
        LoginPage loginPage = profilePage.gotoLoginPage();

        loginPage.passwordLoginFail(account, pwd);
        MatcherAssert.assertThat(loginPage.getMsg(), Matchers.equalTo(expect));
    }
}
