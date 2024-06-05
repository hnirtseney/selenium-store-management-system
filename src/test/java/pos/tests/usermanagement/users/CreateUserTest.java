package pos.tests.usermanagement.users;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.usermanagement.CreateUserForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.users.AllUsersPage;
import pos.pageobjects.usermanagementpage.users.CreateUserPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateUserTest extends BaseTest {
    @DataProvider(name = "userData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//usermanagement//Users.json");
        return data.stream()
                .map(d -> new Object[]{new CreateUserForm(
                        d.get("userName"),
                        d.get("userMail"),
                        d.get("userPassword"),
                        d.get("userConfirmPassword"),
                        d.get("userRole"),
                        d.get("userStatus")
                )})
                .toArray(Object[][]::new);
    }

    public CreateUserPage fillForm(CreateUserForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CreateUserPage createUserPage = dashboardPage.goToCreatUserPage();

        createUserPage.inputUserName(form.userName);
        createUserPage.inputUserMail(form.userMail);
        createUserPage.inputUserPassword(form.userPassword);
        createUserPage.inputUserConfirmPassword(form.userConfirmPassword);
        createUserPage.selectUserRole(form.userRole);
        createUserPage.selectUserStatus(form.userStatus);
        return createUserPage;
    }

    @Test(dataProvider = "userData")
    public void createCustomerTest(CreateUserForm form) {
        CreateUserPage createUserPage = this.fillForm(form);
        AllUsersPage allUsersPage = createUserPage.clickSubmitButton();

        String expectSuccessMessage = "User Created & Assigned '" + form.userRole + "' Role!";
        String actualMessage = allUsersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
