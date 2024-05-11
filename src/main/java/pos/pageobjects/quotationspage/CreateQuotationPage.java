package pos.pageobjects.quotationspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class CreateQuotationPage extends AbstractComponents {
    WebDriver driver;

    public CreateQuotationPage(WebDriver driver) {
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
    @FindBy(name = "shipping_amount")
    WebElement quotationShipping;
    @FindBy(name = "status")
    WebElement quotationStatus;
    @FindBy(xpath = "//*[@id=\"quotation-form\"]/div[5]/button")
    WebElement createQuotationButton;


    public void fillQuotationForm(String product_code, String customer, String product_quantity, String quotation_tax, String quotation_discount, String quotation_shipping, String quotation_status) throws InterruptedException {
        searchBox.clear();
        searchBox.sendKeys(product_code);
        searchedProduct.click();

        productQuantity.clear();
        productQuantity.sendKeys(product_quantity);
        submitQuantityProduct.click();

        Select customersDropdown = new Select(customersSelect);
        customersDropdown.selectByVisibleText(customer);

        quotationTax.clear();
        quotationTax.sendKeys(quotation_tax);

        quotationDiscount.clear();
        quotationDiscount.sendKeys(quotation_discount);

        quotationShipping.clear();
        quotationShipping.sendKeys(quotation_shipping);

        Select statusDropdown = new Select(quotationStatus);
        statusDropdown.selectByVisibleText(quotation_status);
    }

    public AllQuotationsPage clickSubmitCreateQuotation() {
        createQuotationButton.click();
        return new AllQuotationsPage(driver);
    }
}
