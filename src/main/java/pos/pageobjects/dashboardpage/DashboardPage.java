package pos.pageobjects.dashboardpage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

import java.util.ArrayList;
import java.util.Arrays;
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

//    public double[] getChartData(String chartId) {
//        String script = "return Array.from(document.getElementById('" + chartId + "').getContext('2d').chart.data.datasets[0].data);";
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        return ((List<Double>) js.executeScript(script)).stream().mapToDouble(Double::doubleValue).toArray();
//    }

    public double getCurrentMonthChartData(String dataType) {
        String script = "return document.getElementById('currentMonthChart').data.datasets.find(dataset => dataset.label === '" + dataType + "').data[0];";
        Object result = ((JavascriptExecutor) driver).executeScript(script);
        return ((Number) result).doubleValue();
    }

    public List<Double> getSalesPurchasesChartData(String dataType) {
        String script = "return document.getElementById('salesPurchasesChart').data.datasets.find(dataset => dataset.label === '" + dataType + "').data;";
        Object result = ((JavascriptExecutor) driver).executeScript(script);
        return parseChartData(result);
    }

    public List<Double> getPaymentChartData(String dataType) {
        String script = "return document.getElementById('paymentChart').data.datasets.find(dataset => dataset.label === '" + dataType + "').data;";
        Object result = ((JavascriptExecutor) driver).executeScript(script);
        return parseChartData(result);
    }

    public List<String> getPaymentChartMonths() {
        String script = "return document.getElementById('paymentChart').data.labels;";
        Object result = ((JavascriptExecutor) driver).executeScript(script);
        return Arrays.asList(((String) result).split(","));
    }

    private List<Double> parseChartData(Object result) {
        List<Double> data = new ArrayList<>();
        if (result instanceof List) {
            for (Object value : (List<?>) result) {
                data.add(((Number) value).doubleValue());
            }
        }
        return data;
    }
}
