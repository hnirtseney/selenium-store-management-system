package pos.tests.dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

public class DashboardTest extends BaseTest {
    @Test
    public void testRevenue() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double revenueOnDashboard = dashboardPage.getRevenue();
        System.out.println("revenueOnDashboard: " + revenueOnDashboard);
        double revenueFromDB = DatabaseHelper.getRevenue();
        System.out.println("revenueFromDB: " + revenueFromDB);
        Assert.assertEquals(revenueOnDashboard, revenueFromDB, "Revenue mismatch!");
    }

    @Test
    public void testSalesReturn() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double salesReturnOnDashboard = dashboardPage.getSalesReturn();
        System.out.println("salesReturnOnDashboard: " + salesReturnOnDashboard);
        double salesReturnFromDB = DatabaseHelper.getSalesReturn();
        System.out.println("salesReturnOnDB: " + salesReturnFromDB);
        Assert.assertEquals(salesReturnOnDashboard, salesReturnFromDB, "Sales Return mismatch!");
    }

    @Test
    public void testPurchasesReturn() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double purchasesReturnOnDashboard = dashboardPage.getPurchasesReturn();
        System.out.println("purchasesReturnOnDashboard: " + purchasesReturnOnDashboard);
        double purchasesReturnFromDB = DatabaseHelper.getPurchasesReturn();
        System.out.println("purchasesReturnFromDB: " + purchasesReturnFromDB);
        Assert.assertEquals(purchasesReturnOnDashboard, purchasesReturnFromDB, "Purchases Return mismatch!");
    }

    @Test
    public void testProfit() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        double profitOnDashboard = dashboardPage.getProfit();
        System.out.println("profitOnDashboard: " + profitOnDashboard);
        double profitFromDB = DatabaseHelper.getProfit();
        System.out.println("profitFromDB: " + profitFromDB);
        Assert.assertEquals(profitOnDashboard, profitFromDB, "Profit mismatch!");
    }

//    @Test
//    public void testCurrentMonthChartData() throws Exception {
//        Map<String, Double> currentMonthChartDataFromDB = DatabaseHelper.getCurrentMonthChartData();
//        double salesOnDashboard = dashboardPage.getCurrentMonthChartData("sales");
//        double purchasesOnDashboard = dashboardPage.getCurrentMonthChartData("purchases");
//        double expensesOnDashboard = dashboardPage.getCurrentMonthChartData("expenses");
//
//        Assert.assertEquals(salesOnDashboard, currentMonthChartDataFromDB.get("sales"), "Current Month Sales data mismatch!");
//        Assert.assertEquals(purchasesOnDashboard, currentMonthChartDataFromDB.get("purchases"), "Current Month Purchases data mismatch!");
//        Assert.assertEquals(expensesOnDashboard, currentMonthChartDataFromDB.get("expenses"), "Current Month Expenses data mismatch!");
//    }
//
//    @Test
//    public void testSalesPurchasesChartData() throws Exception {
//        Map<String, List<Double>> salesPurchasesChartDataFromDB = DatabaseHelper.getSalesPurchasesChartData();
//        List<Double> salesOnDashboard = dashboardPage.getSalesPurchasesChartData("sales");
//        List<Double> purchasesOnDashboard = dashboardPage.getSalesPurchasesChartData("purchases");
//
//        Assert.assertEquals(salesOnDashboard.toArray(), salesPurchasesChartDataFromDB.get("sales").toArray(), "Sales data mismatch!");
//        Assert.assertEquals(purchasesOnDashboard.toArray(), salesPurchasesChartDataFromDB.get("purchases").toArray(), "Purchases data mismatch!");
//    }
//
//    @Test
//    public void testPaymentChartData() throws Exception {
//        Map<String, List<Double>> paymentChartDataFromDB = DatabaseHelper.getPaymentChartData();
//        List<String> paymentMonthsFromDB = DatabaseHelper.getPaymentMonths();
//        List<Double> paymentReceivedOnDashboard = dashboardPage.getPaymentChartData("payment_received");
//        List<Double> paymentSentOnDashboard = dashboardPage.getPaymentChartData("payment_sent");
//        List<String> monthsOnDashboard = dashboardPage.getPaymentChartMonths();
//
//        Assert.assertEquals(paymentReceivedOnDashboard.toArray(), paymentChartDataFromDB.get("payment_received").toArray(), "Payment Received data mismatch!");
//        Assert.assertEquals(paymentSentOnDashboard.toArray(), paymentChartDataFromDB.get("payment_sent").toArray(), "Payment Sent data mismatch!");
//        Assert.assertEquals(monthsOnDashboard.toArray(), paymentMonthsFromDB.toArray(), "Months data mismatch!");
//    }
}