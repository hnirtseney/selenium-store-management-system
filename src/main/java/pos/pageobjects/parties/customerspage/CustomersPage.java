package pos.pageobjects.parties.customerspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CustomersPage extends AbstractComponents {
    WebDriver driver;
    public CustomersPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addCustomerBtn;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteCustomerBtn;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public CreateCustomerPage gotoCreateCustomerPage() {
        addCustomerBtn.click();
        return new CreateCustomerPage(driver);
    }

    public void deleteCustomer() {
        deleteCustomerBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
