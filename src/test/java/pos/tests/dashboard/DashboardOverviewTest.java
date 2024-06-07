package pos.tests.dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

public class DashboardOverviewTest extends BaseTest {
    @Test
    public void testRevenue() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double revenueOnDashboard = dashboardPage.getRevenue();
        double revenueFromDB = DatabaseHelper.getRevenue();
        Assert.assertEquals(revenueOnDashboard, revenueFromDB, "Revenue mismatch!");
    }

    @Test
    public void testSalesReturn() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double salesReturnOnDashboard = dashboardPage.getSalesReturn();
        double salesReturnFromDB = DatabaseHelper.getSalesReturn();
        Assert.assertEquals(salesReturnOnDashboard, salesReturnFromDB, "Sales Return mismatch!");
    }

    @Test
    public void testPurchasesReturn() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double purchasesReturnOnDashboard = dashboardPage.getPurchasesReturn();
        double purchasesReturnFromDB = DatabaseHelper.getPurchasesReturn();
        Assert.assertEquals(purchasesReturnOnDashboard, purchasesReturnFromDB, "Purchases Return mismatch!");
    }

    @Test
    public void testProfit() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double profitOnDashboard = dashboardPage.getProfit();
        double profitFromDB = DatabaseHelper.getProfit();
        Assert.assertEquals(profitOnDashboard, profitFromDB, "Profit mismatch!");
    }
}