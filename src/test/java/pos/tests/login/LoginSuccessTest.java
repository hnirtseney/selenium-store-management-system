package pos.tests.login;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginSuccessTest extends BaseTest {

    @DataProvider(name = "loginSuccessData")
    public Object[][] getLoginSuccessData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//login//LoginSuccess.json");
        return data.stream().map(d -> new Object[]{d.get("email"), d.get("password")}).toArray(Object[][]::new);
    }

    @Test(
            dataProvider = "loginSuccessData",
            priority = 1,
            groups = {"LoginTest"})
    public void loginSuccessTest(String email, String password) {
        loginPage.goToLoginPage();
        loginPage.login(email, password);
    }
}
