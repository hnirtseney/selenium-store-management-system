package pos.tests.dashboard;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

import java.util.List;
import java.util.Map;

public class SalesPurchasesChartTest extends BaseTest {
    WebDriver driver;
    DashboardPage dashboardPage;

    @Test
    public void testSalesPurchasesChart() {
        Map<String, List<Map<String, Object>>> chartData = dashboardPage.getSalesPurchasesChart();

        List<Map<String, Object>> salesData = chartData.get("sales");
        List<Map<String, Object>> purchasesData = chartData.get("purchases");

        Assert.assertNotNull(salesData);
        Assert.assertNotNull(purchasesData);
        Assert.assertFalse(salesData.isEmpty());
        Assert.assertFalse(purchasesData.isEmpty());

        salesData.forEach(data -> {
            System.out.println("Sales - Day: " + data.get("day") + ", Value: " + data.get("value"));
        });

        purchasesData.forEach(data -> {
            System.out.println("Purchases - Day: " + data.get("day") + ", Value: " + data.get("value"));
        });
    }
}
