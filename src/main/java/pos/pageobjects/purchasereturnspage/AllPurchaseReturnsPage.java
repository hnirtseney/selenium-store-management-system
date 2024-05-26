package pos.pageobjects.purchasereturnspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllPurchaseReturnsPage extends AbstractComponents {
    @FindBy(id = "purchase-returns-table")
    public WebElement purchasesReturnTable;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"purchase-returns-table\"]/tbody/tr/td[8]/div/button")
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
    public AllPurchaseReturnsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is important for @FindBy to work
    }

    public void deletePurchaseReturns() {
        optionButton.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public AddPaymentPurchaseReturnPage clickAddPayment() {
        optionButton.click();
        addPaymentButton.click();
        return new AddPaymentPurchaseReturnPage(driver);
    }

    public ShowPaymentPurchaseReturnPage clickShowPayment() {
        optionButton.click();
        showPaymentButton.click();
        return new ShowPaymentPurchaseReturnPage(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
