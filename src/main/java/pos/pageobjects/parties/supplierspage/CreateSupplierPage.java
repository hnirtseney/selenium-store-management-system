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

    public void fillSupplierInfo (String Supplier_name, String Supplier_mail, String Supplier_phone, String Supplier_city, String Supplier_country, String Supplier_address) {
        SupplierName.clear();
        SupplierName.sendKeys(Supplier_name);

        SupplierMail.clear();
        SupplierMail.sendKeys(Supplier_mail);

        SupplierPhone.clear();
        SupplierPhone.sendKeys(Supplier_phone);

        SupplierCity.clear();
        SupplierCity.sendKeys(Supplier_city);

        SupplierCountry.clear();
        SupplierCountry.sendKeys(Supplier_country);

        SupplierAddress.clear();
        SupplierAddress.sendKeys(Supplier_address);
    }

    public SuppliersPage clickSubmitCreateSupplier () {
        createSupplierBtn.click();
        return new SuppliersPage(driver);
    }
}
