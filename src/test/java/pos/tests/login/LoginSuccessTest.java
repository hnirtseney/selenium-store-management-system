package pos.tests.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
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
        DashboardPage dashboardPage = loginPage.login(email, password);
        dashboardPage.waitForElementToAppear(By.id("paymentChart"));
        Assert.assertTrue(dashboardPage.paymentChart.isDisplayed(), "Bảng payment  không hiển thị.");

//        AllUsersPage allUsersPage = dashboardPage.goToAllUsersPage();
//        allUsersPage.waitForElementToAppear((By.id("users-table")));
//        Assert.assertTrue(allUsersPage.usersTable.isDisplayed(), "Bảng danh sách Users không hiển thị.");
    }
    
}
