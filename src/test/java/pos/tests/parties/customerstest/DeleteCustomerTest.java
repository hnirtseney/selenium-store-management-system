package pos.tests.parties.customerstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.testcomponents.BaseTest;

public class DeleteCustomerTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deleteCustomerTest(String username, String password) {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        CustomersPage customersPage = dashboardPage.goToCustomersPage();

        customersPage.deleteCustomer();

        String expectSuccessMessage = customersPage.getSuccessMessage();
        String actualSuccessMessage = "Customer Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
