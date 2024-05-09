package pos.pageobjects.parties.customerspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage {
    WebDriver driver;

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[1]/div/input")
    WebElement customerName;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[2]/div/input")
    WebElement customerMail;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement customerPhone;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[2]/div/input")
    WebElement customerCity;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[3]/div/input")
    WebElement customerCountry;
    @FindBy(name = "address")
    WebElement customerAddress;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[1]/div/button")
    WebElement createCustomerBtn;

    public void fillCustomerInfo (String customer_name, String customer_mail, String customer_phone, String customer_city, String customer_country, String customer_address) {
        customerName.clear();
        customerName.sendKeys(customer_name);

        customerMail.clear();
        customerMail.sendKeys(customer_mail);

        customerPhone.clear();
        customerPhone.sendKeys(customer_phone);

        customerCity.clear();
        customerCity.sendKeys(customer_city);

        customerCountry.clear();
        customerCountry.sendKeys(customer_country);

        customerAddress.clear();
        customerAddress.sendKeys(customer_address);
    }

    public CustomersPage clickSubmitCreateCustomer () {
        createCustomerBtn.click();
        return new CustomersPage(driver);
    }
}
