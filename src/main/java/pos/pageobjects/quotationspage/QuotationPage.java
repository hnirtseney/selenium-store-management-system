package pos.pageobjects.quotationspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class QuotationPage extends AbstractComponents {
    WebDriver driver;
    //    Actions action;
    Select selectDropdown;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[1]/div/div/div[1]/div/div/div/input")
    WebElement searchBox;
    @FindBy(name = "customer_id")
    WebElement customersSelect;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[1]/div/div/div[4]/div/ul/li[1]/a")
    WebElement searchedProduct;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/input")
    WebElement productQuantity;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/div/button")
    WebElement submitQuantityProduct;
    @FindBy(name = "tax_percentage")
    WebElement quotationTax;
    @FindBy(name = "discount_percentage")
    WebElement quotationDiscount;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[2]/div[3]/div[3]/div/input")
    WebElement quotationShipping;
    @FindBy(name = "status")
    WebElement quotationStatus;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[5]/button")
    WebElement submitButton;

    public QuotationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputProductCode(String product_code) {
        searchBox.clear();
        searchBox.sendKeys(product_code);
        searchedProduct.click();
    }

    public void inputProductQuantity(String product_quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(product_quantity);
        submitQuantityProduct.click();
    }

    public void selectCustomer(String customer_name) {
        selectDropdown = new Select(customersSelect);
        selectDropdown.selectByVisibleText(customer_name);
    }

    public void inputQuotationTax(String quotation_tax) {
        quotationTax.clear();
        quotationTax.sendKeys(quotation_tax);
    }

    public void inputQuotationDiscount(String quotation_discount) {
        quotationDiscount.clear();
        quotationDiscount.sendKeys(quotation_discount);
    }

    public void inputQuotationShipping(String quotation_shipping) {
        quotationShipping.clear();
        quotationShipping.sendKeys(quotation_shipping);
    }

    public void selectQuotationStatus(String quotation_status) {
        selectDropdown = new Select(quotationStatus);
        selectDropdown.selectByVisibleText(quotation_status);
    }

    public AllQuotationsPage clickSubmitQuotation() {
        submitButton.click();
        return new AllQuotationsPage(driver);
    }

    public String getValidationMessage() {
        return quotationTax.getAttribute("validationMessage");
    }
}
