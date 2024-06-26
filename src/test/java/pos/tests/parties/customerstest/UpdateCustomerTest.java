package pos.tests.parties.customerstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.customerspage.CreateCustomerPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.testcomponents.BaseTest;

public class UpdateCustomerTest extends BaseTest {
    @Test
    public void updateCustomerTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CustomersPage customersPage;
        customersPage = dashboardPage.goToCustomersPage();
        CreateCustomerPage updateCustomer = customersPage.updateCustomer();
        customersPage = updateCustomer.clickSubmitCreateCustomer();

        String expectUpdateSuccessMessage = customersPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Customer Updated!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
