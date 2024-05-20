package pos.pageobjects.salespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class CreateSalePage extends AbstractComponents {
    WebDriver driver;
    Select select;
    // Web elements
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[1]/div/div/div[1]/div/div/div/input")
    WebElement searchField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[1]/div/div/div[4]/div/ul/li[1]/a")
    WebElement searchedProduct;
    @FindBy(id = "customer_id")
    WebElement customerDropdown;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/input")
    WebElement productQuantity;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[2]/div[1]/div/table/tbody/tr/td[4]/div/div/button")
    WebElement productQuantityButton;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[2]/div[2]/div/div/table/tbody/tr[4]/th[2]")
    WebElement totalAmount;
    @FindBy(name = "tax_percentage")
    WebElement taxPercentageField;
    @FindBy(name = "discount_percentage")
    WebElement discountPercentageField;
    @FindBy(xpath = "//*[@id=\"sale-form\"]/div[2]/div[3]/div[3]/div/input")
    WebElement shippingAmountField;
    @FindBy(name = "status")
    WebElement statusDropdown;
    @FindBy(name = "payment_method")
    WebElement paymentMethodDropdown;
    @FindBy(name = "paid_amount")
    WebElement paidAmountField;
    @FindBy(id = "getTotalAmount")
    WebElement getTotalAmountButton;
    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    // Constructor
    public CreateSalePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputProducts(String product) {
        searchField.clear();
        searchField.sendKeys(product);
        searchedProduct.click();
    }

    public void selectCustomer(String customer) {
        select = new Select(customerDropdown);
        select.selectByVisibleText(customer);
    }

    public void inputQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);
        productQuantityButton.click();
    }

    public void inputTaxPercentage(String tax) {
        taxPercentageField.clear();
        taxPercentageField.sendKeys(tax);
    }

    public void inputDiscountPercentage(String discount) {
        discountPercentageField.clear();
        discountPercentageField.sendKeys(discount);
    }

    public void inputShippingAmount(String shippingAmount) {
        shippingAmountField.clear();
        shippingAmountField.sendKeys(shippingAmount);
    }

    public void selectStatus(String status) {
        select = new Select(statusDropdown);
        select.selectByVisibleText(status);
    }

    public String getTotalAmountText() {
        return totalAmount.getText();
    }


    public void selectPaymentMethod(String paymentMethod) {
        select = new Select(paymentMethodDropdown);
        select.selectByVisibleText(paymentMethod);
    }

    public void inputAmount(String typeAmount) throws InterruptedException {
        Thread.sleep(3000);
        String totalAmount = this.getTotalAmountText();

        String cleanedTotalAmount = totalAmount.replaceAll("[^\\d.]", "");

        double doubleTotalAmount = Double.parseDouble(cleanedTotalAmount);

        double partialAmount = doubleTotalAmount * 0.6;

        BigDecimal roundedPartialAmount = new BigDecimal(partialAmount).setScale(2, RoundingMode.HALF_UP);

        if (Objects.equals(typeAmount, "Partial")) {
            paidAmountField.clear();
            paidAmountField.sendKeys(roundedPartialAmount.toString());
        }
        if (Objects.equals(typeAmount, "Paid")) {
            paidAmountField.sendKeys(cleanedTotalAmount);
        }
    }

    public AllSalesPage clickSubmitButton() {
        submitButton.click();
        return new AllSalesPage(driver);
    }
}
