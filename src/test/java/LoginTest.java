import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginTest {
    @Test
    public void notPhone(){
        MainPage mainPage = MainPage.start();
        ProfilePage profilePage = mainPage.goToProfilePage();
        LoginPage loginPage = profilePage.gotoLoginPage();
        loginPage.passwordLoginFail("14700001111", "123456");
        assertThat(loginPage.getMsg(), equalTo("用户名或密码错误"));
    }
}
