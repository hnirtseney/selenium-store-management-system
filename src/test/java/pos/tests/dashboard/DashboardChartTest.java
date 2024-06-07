package pos.tests.dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DashboardChartTest extends BaseTest {
    @Test
    public void salesPurchasesChartTest() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        Thread.sleep(4000);
        List<Double> salesDataDB = DatabaseHelper.getSalesChartData();
        List<Double> purchasesDataDB = DatabaseHelper.getPurchasesChartData();

        ArrayList<ArrayList<Double>> salesPurchasesDataDashboard = dashboardPage.getSalesPurchasesChartFromDashboardPage();
        List<Double> salesDataDashboard = formatChartData(salesPurchasesDataDashboard.get(0));
        List<Double> purchasesDataDashboard = formatChartData(salesPurchasesDataDashboard.get(1));

        assertEquals(salesDataDashboard, salesDataDB, "Sales data from dashboard does not match with database.");
        assertEquals(purchasesDataDashboard, purchasesDataDB, "Purchases data from dashboard does not match with database.");
    }

    @Test
    public void currentMonthChartTest() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        Thread.sleep(4000);

        List<Double> currentMonthDB = DatabaseHelper.getCurrentMonthChartData();

        ArrayList<ArrayList<Double>> currentMonthDashboardPage = dashboardPage.getCurrentMonthChartFromDashboardPage();
        List<Double> currentMonthDashboard = formatChartData(currentMonthDashboardPage.get(0));

        Assert.assertEquals(currentMonthDB, currentMonthDashboard, "Current month data from dashboard does not match with database.");

    }

    @Test
    public void paymentChartTest() throws Exception {
        DashboardPage dashboardPage = loginPage.loginTest();
        Thread.sleep(4000);

        ArrayList<ArrayList<Double>> paymentDashboardPage = dashboardPage.getPaymentChartFromDashboardPage();
        List<Double> paymentSentDashboard = formatChartData(paymentDashboardPage.get(0));
        List<Double> paymentReceivedDashboard = formatChartData(paymentDashboardPage.get(1));

        List<Double> paymentReceivedChartDB = DatabaseHelper.getPaymentReceivedChartData();
        List<Double> paymentSentChartDB = DatabaseHelper.getPaymentSentChartData();

        Assert.assertEquals(paymentSentChartDB, paymentSentDashboard, "Payment Sent data from dashboard does not match with database.");
        Assert.assertEquals(paymentReceivedChartDB, paymentReceivedDashboard, "Payment Receive data from dashboard does not match with database.");
    }

    private List<Double> formatChartData(List<Double> chartData) {
        List<Double> formattedData = new ArrayList<>();
        for (Double data : chartData) {
            formattedData.add(data);
        }
        return formattedData;
    }
}
