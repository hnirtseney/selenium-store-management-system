package pos.pageobjects.parties.customerspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CustomersPage extends AbstractComponents {
    @FindBy(id = "customers-table")
    public WebElement customersTable;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addCustomerButton;
    @FindBy(xpath = "//*[@id=\"customers-table\"]/tbody/tr[1]/td[4]/a[1]")
    WebElement updateCustomerBtn;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteCustomerButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateCustomerPage gotoCreateCustomerPage() {
        addCustomerButton.click();
        return new CreateCustomerPage(driver);
    }

    public CreateCustomerPage updateCustomer() {
        updateCustomerBtn.click();
        return new CreateCustomerPage(driver);
    }

    public void deleteCustomer() {
        deleteCustomerButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
