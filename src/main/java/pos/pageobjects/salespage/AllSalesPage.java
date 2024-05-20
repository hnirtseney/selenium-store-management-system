package pos.pageobjects.salespage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllSalesPage extends AbstractComponents {
    @FindBy(id = "sales-table")
    public WebElement salesTable;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[8]/div/button")
    WebElement optionButton;
    @FindBy(id = "delete")
    WebElement deleteButton;
    @FindBy(xpath = "((//a[contains(@class,'dropdown-item')][normalize-space()='Edit'])[1])")
    WebElement editButton;
    @FindBy(xpath = "(//a[@class='dropdown-item'][normalize-space()='Add Payment'])[1]")
    WebElement addPaymentButton;
    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[8]/div/div/a[2]")
    WebElement showPaymentButton;

    // Constructor
    public AllSalesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is important for @FindBy to work
    }

    public void deleteSale() {
        optionButton.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public AddPaymentPage clickAddPaymentButton() {
        optionButton.click();
        addPaymentButton.click();
        return new AddPaymentPage(driver);
    }

    public ShowPaymentPage clickShowPaymentPage() {
        optionButton.click();
        showPaymentButton.click();
        return new ShowPaymentPage(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
