package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AddPaymentSaleReturnPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.testcomponents.BaseTest;

public class AddPaymentSaleReturnTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void addPaymentTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllSaleReturnsPage allSalesReturnPage = dashboardPage.goToAllSaleReturnsPage();
        AddPaymentSaleReturnPage addPaymentSaleReturnPage = allSalesReturnPage.clickAddPayment();

        addPaymentSaleReturnPage.clickGetTotalAmountButton();
        AllSaleReturnsPage allSalesPageAfterAddPayment = addPaymentSaleReturnPage.clickCreatePaymentButton();
        String expectMessage = "Sale Return Payment Created!";
        String actualMessage = allSalesPageAfterAddPayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
