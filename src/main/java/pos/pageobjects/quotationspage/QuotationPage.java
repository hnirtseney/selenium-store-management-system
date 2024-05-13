package pos.pageobjects.quotationspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;
import pos.pageobjects.salespage.AllSalesPage;

public class QuotationPage extends AbstractComponents {
    WebDriver driver;
    Select selectDropdown;

    public QuotationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
    @FindBy(xpath = "//*[@id=\"getTotalAmount\"]")
    WebElement totalAmountBtn;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[5]/button")
    WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[5]/button")
    WebElement createSaleBtn;




    public void fillQuotationForm(String product_code, String customer, String product_quantity, String quotation_tax, String quotation_discount, String quotation_shipping, String quotation_status){
        searchBox.clear();
        searchBox.sendKeys(product_code);
        searchedProduct.click();

        productQuantity.clear();
        productQuantity.sendKeys(product_quantity);
        submitQuantityProduct.click();

        selectDropdown = new Select(customersSelect);
        selectDropdown.selectByVisibleText(customer);

        quotationTax.clear();
        quotationTax.sendKeys(quotation_tax);

        quotationDiscount.clear();
        quotationDiscount.sendKeys(quotation_discount);

        quotationShipping.clear();
        quotationShipping.sendKeys(quotation_shipping);

        selectDropdown = new Select(quotationStatus);
        selectDropdown.selectByVisibleText(quotation_status);
    }

    public void clickTotalAmount() {
        totalAmountBtn.click();
        totalAmountBtn.click();
    }

    public AllQuotationsPage clickSubmitQuotation() {
        submitButton.click();
        return new AllQuotationsPage(driver);
    }

    public AllSalesPage clickCreateSale() {
        createSaleBtn.click();
        return new AllSalesPage(driver);
    }
}
