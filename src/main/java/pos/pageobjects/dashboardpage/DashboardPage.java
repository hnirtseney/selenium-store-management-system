package pos.pageobjects.dashboardpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Revenue')]/preceding-sibling::div")
    WebElement revenue;

    @FindBy(xpath = "//div[contains(text(),'Sales Return')]/preceding-sibling::div")
    WebElement salesReturn;

    @FindBy(xpath = "//div[contains(text(),'Purchases Return')]/preceding-sibling::div")
    WebElement purchasesReturn;

    @FindBy(xpath = "//div[contains(text(),'Profit')]/preceding-sibling::div")
    WebElement profit;

    @FindBy(id = "salesPurchasesChart")
    WebElement salesPurchasesChart;
    @FindBy(id = "currentMonthChart")
    WebElement currentMonthChart;
    @FindBy(id = "paymentChart")
    WebElement paymentChart;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double getRevenue() {
        return Double.parseDouble(revenue.getText().replace("$", "").replace(",", ""));
    }

    public double getSalesReturn() {
        return Double.parseDouble(salesReturn.getText().replace("$", "").replace(",", ""));
    }

    public double getPurchasesReturn() {
        return Double.parseDouble(purchasesReturn.getText().replace("$", "").replace(",", ""));
    }

    public double getProfit() {
        return Double.parseDouble(profit.getText().replace("$", "").replace(",", ""));
    }

    public ArrayList<ArrayList<Double>> getDataFromChart(WebElement chartElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ArrayList<ArrayList<Number>> rawData = (ArrayList<ArrayList<Number>>) js.executeScript(
                "var chart = Chart.getChart(arguments[0]);" +
                        "if (chart) {" +
                        "   var datasets = chart.data.datasets;" +
                        "   return datasets.map(dataset => dataset.data);" +
                        "} else { return null; }",
                chartElement.getAttribute("id")
        );

        ArrayList<ArrayList<Double>> chartData = new ArrayList<>();
        for (List<Number> dataset : rawData) {
            ArrayList<Double> dataPoints = new ArrayList<>();
            for (Number value : dataset) {
                dataPoints.add(value.doubleValue());
            }
            chartData.add(dataPoints);
        }
        return chartData;
    }

    public ArrayList<ArrayList<Double>> getSalesPurchasesChartFromDashboardPage() {
        return this.getDataFromChart(salesPurchasesChart);
    }

    public ArrayList<ArrayList<Double>> getCurrentMonthChartFromDashboardPage() {
        return this.getDataFromChart(currentMonthChart);
    }

    public ArrayList<ArrayList<Double>> getPaymentChartFromDashboardPage() {
        return this.getDataFromChart(paymentChart);
    }
}
