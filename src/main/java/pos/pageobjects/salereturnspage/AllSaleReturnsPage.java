package pos.pageobjects.salereturnspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllSaleReturnsPage extends AbstractComponents {
    @FindBy(id = "sale-returns-table")
    public WebElement salesReturnTable;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"sale-returns-table\"]/tbody/tr/td[8]/div/button")
    WebElement optionButton;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][normalize-space()='Show Payments']")
    WebElement showPaymentButton;
    @FindBy(xpath = "//a[normalize-space()='Add Payment']")
    WebElement addPaymentButton;
    @FindBy(xpath = "//div[@class='dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='Edit']")
    WebElement editButton;
    @FindBy(id = "delete")
    WebElement deleteButton;


    // Constructor
    public AllSaleReturnsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is important for @FindBy to work
    }

    public void deleteSaleReturns() {
        optionButton.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public AddPaymentSaleReturnPage clickAddPayment() {
        optionButton.click();
        addPaymentButton.click();
        return new AddPaymentSaleReturnPage(driver);
    }

    public ShowPaymentSaleReturnPage clickShowPayment() {
        optionButton.click();
        showPaymentButton.click();
        return new ShowPaymentSaleReturnPage(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
