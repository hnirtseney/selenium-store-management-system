package pos.pageobjects.dashboardpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;
import pos.pageobjects.possystempage.PosSystemPage;

import java.util.List;
import java.util.Map;

public class DashboardPage extends AbstractComponents {

    WebDriver driver;
    // Page elements
    @FindBy(xpath = "//div[@class='text-value text-primary']")
    private WebElement revenueValue;
    @FindBy(xpath = "//div[@class='text-value text-warning']")
    private WebElement salesReturnValue;
    @FindBy(xpath = "//div[@class='text-value text-success']")
    private WebElement purchasesReturnValue;
    @FindBy(xpath = "//div[@class='text-value text-info']")
    private WebElement profitValue;
    @FindBy(xpath = "//canvas[@id='salesPurchasesChart']")
    private WebElement salesPurchasesChart;
    @FindBy(xpath = "//canvas[@id='currentMonthChart']")
    private WebElement currentMonthChart;
    @FindBy(xpath = "//canvas[@id='paymentChart']")
    private WebElement paymentChart;
    @FindBy(xpath = "/html/body/div[2]/header/ul[2]/li[1]/a")
    private WebElement posSystemLink;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getRevenueValue() {
        return revenueValue.getText();
    }

    public String getSalesReturnValue() {
        return salesReturnValue.getText();
    }

    public String getPurchasesReturnValue() {
        return purchasesReturnValue.getText();
    }

    public String getProfitValue() {
        return profitValue.getText();
    }

    public PosSystemPage clickPOSSystemLink() {
        posSystemLink.click();
        return new PosSystemPage(driver);
    }

    public boolean isSalesPurchasesChartDisplayed() {
        return salesPurchasesChart.isDisplayed();
    }

    public Map<String, List<Map<String, Object>>> getSalesPurchasesChart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var chart = Chart.getChart('salesPurchasesChart');" +
                "var salesData = [];" +
                "var purchasesData = [];" +
                "if (chart) {" +
                "    var labels = chart.data.labels;" +
                "    var datasets = chart.data.datasets;" +
                "    for (var i = 0; i < labels.length; i++) {" +
                "        salesData.push({" +
                "            day: labels[i]," +
                "            value: datasets[0].data[i]" +
                "        });" +
                "        purchasesData.push({" +
                "            day: labels[i]," +
                "            value: datasets[1].data[i]" +
                "        });" +
                "    }" +
                "}" +
                "return {sales: salesData, purchases: purchasesData};";

//        List<Map<String, Object>> data = (List<Map<String, Object>>) js.executeScript(script);
//        return Map.of("sales", data.get(0), "purchases", data.get(1));
        Map<String, List<Map<String, Object>>> chartData = (Map<String, List<Map<String, Object>>>) js.executeScript(script);
        return chartData;
    }

    public boolean isCurrentMonthChartDisplayed() {
        return currentMonthChart.isDisplayed();
    }

    public boolean isPaymentChartDisplayed() {
        return paymentChart.isDisplayed();
    }
}