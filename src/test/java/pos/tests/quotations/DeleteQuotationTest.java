package pos.tests.quotations;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.testcomponents.BaseTest;

public class DeleteQuotationTest extends BaseTest {
    @Test
    public void deleteProduct() {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();
        allQuotationsPage.deleteQuotation();

        String expectDeleteSuccessMessage = "Quotation Deleted!";
        String actualDeleteSuccessMessage = allQuotationsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualDeleteSuccessMessage.equalsIgnoreCase(expectDeleteSuccessMessage));
    }

}
