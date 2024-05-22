package pos.pageobjects.purchasespage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllPurchasesPage extends AbstractComponents {
    @FindBy(id = "purchases-table")
    public WebElement purchasesTable;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"purchases-table\"]/tbody/tr/td[8]/div/button")
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
    public AllPurchasesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is important for @FindBy to work
    }

    public void deletePurchase() {
        optionButton.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public AddPaymentPage clickAddPayment() {
        optionButton.click();
        addPaymentButton.click();
        return new AddPaymentPage(driver);
    }

    public ShowPaymentPage clickShowPayment() {
        optionButton.click();
        showPaymentButton.click();
        return new ShowPaymentPage(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
