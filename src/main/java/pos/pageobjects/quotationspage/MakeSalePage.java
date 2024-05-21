package pos.pageobjects.quotationspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.pageobjects.salespage.AllSalesPage;

public class MakeSalePage extends QuotationPage {

    WebDriver driver;
    Select select;
    @FindBy(xpath = "//*[@id=\"status\"]")
    WebElement saleStatus;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[5]/button")
    WebElement createSaleBtn;
    @FindBy(xpath = "//*[@id=\"getTotalAmount\"]")
    WebElement totalAmountBtn;

    public MakeSalePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSaleStatus() {
        select = new Select(saleStatus);
        select.selectByVisibleText("Completed");
    }

    public void clickTotalAmount() {
        totalAmountBtn.click();
    }

    public AllSalesPage clickCreateSale() {
        createSaleBtn.click();
        return new AllSalesPage(driver);
    }
}
