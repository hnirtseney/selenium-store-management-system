package pos.pageobjects.parties.supplierspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CreateSupplierPage extends AbstractComponents {
    WebDriver driver;

    public CreateSupplierPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[1]/div/input")
    WebElement SupplierName;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[2]/div/input")
    WebElement SupplierMail;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement SupplierPhone;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[2]/div/input")
    WebElement SupplierCity;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[3]/div/input")
    WebElement SupplierCountry;
    @FindBy(name = "address")
    WebElement SupplierAddress;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[1]/div/button")
    WebElement createSupplierBtn;

    public void inputSupplierName(String supplier_name) {
        SupplierName.clear();
        SupplierName.sendKeys(supplier_name);
    }

    public void inputSupplierMail(String supplier_mail) {
        SupplierMail.clear();
        SupplierMail.sendKeys(supplier_mail);
    }

    public void inputSupplierPhone(String supplier_phone) {
        SupplierPhone.clear();
        SupplierPhone.sendKeys(supplier_phone);
    }

    public void inputSupplierCity(String supplier_city) {
        SupplierCity.clear();
        SupplierCity.sendKeys(supplier_city);
    }

    public void inputSupplierCountry(String supplier_country) {
        SupplierCountry.clear();
        SupplierCountry.sendKeys(supplier_country);
    }

    public void inputSupplierAddress(String supplier_address) {
        SupplierAddress.clear();
        SupplierAddress.sendKeys(supplier_address);
    }

    public SuppliersPage clickSubmitCreateSupplier () {
        createSupplierBtn.click();
        return new SuppliersPage(driver);
    }
}
