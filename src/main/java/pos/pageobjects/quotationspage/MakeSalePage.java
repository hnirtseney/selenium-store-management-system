package pos.pageobjects.quotationspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.pageobjects.salespage.AllSalesPage;

public class MakeSalePage extends QuotationPage {

    WebDriver driver;

    public MakeSalePage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[5]/button")
    WebElement createSaleBtn;

    @FindBy(xpath = "//*[@id=\"getTotalAmount\"]")
    WebElement totalAmountBtn;

    public AllSalesPage clickCreateSale() {
        createSaleBtn.click();
        return new AllSalesPage(driver);
    }

    public void clickTotalAmount() {
        totalAmountBtn.click();
    }
}
