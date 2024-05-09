package pos.tests.parties.customerstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.testcomponents.BaseTest;

public class DeleteCustomerTest extends BaseTest {
    @Test
    public void deleteCustomerTest() {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        CustomersPage customersPage = dashboardPage.goToCustomersPage();

        customersPage.deleteCustomer();

        String expectSuccessMessage = customersPage.getSuccessMessage();
        String actualSuccessMessage = "Customer Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
