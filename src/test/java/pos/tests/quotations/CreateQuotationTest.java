package pos.tests.quotations;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.CreateQuotationPage;
import pos.testcomponents.BaseTest;

public class CreateQuotationTest extends BaseTest {
    public void createQuotationTest() {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "password");

        CreateQuotationPage createQuotationPage = dashboardPage.
    }
}
