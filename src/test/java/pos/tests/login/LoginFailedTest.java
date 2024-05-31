package pos.tests.login;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginFailedTest extends BaseTest {

    @DataProvider(name = "loginFailureData")
    public Object[][] getLoginFailureData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//login//LoginFailed.json");
        return data.stream().map(d -> new Object[]{d.get("email"), d.get("password"), d.get("invalid-feedback")})
                .toArray(Object[][]::new);
    }

    @Test(
            dataProvider = "loginFailureData",
            priority = 2,
            groups = {"LoginTest"}
    )
    public void loginFailureTest(String email, String password, String expectedError) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(email, password);
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message does not match expected.");
    }
}
