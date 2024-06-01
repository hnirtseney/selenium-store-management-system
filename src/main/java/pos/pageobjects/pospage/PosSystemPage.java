package pos.pageobjects.pospage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;
import pos.pageobjects.salespage.AllSalesPage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class PosSystemPage extends AbstractComponents {
    WebDriver driver;
    Select selectDropdown;
    AbstractComponents abstractComponents;

    @FindBy(xpath = "//input[@placeholder='Type product name or code....']")
    WebElement searchByProduct;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[2]/div[1]/div[4]/div/ul/li[1]/a")
    WebElement searchedProduct;

    @FindBy(id = "customer_id")
    WebElement selectCustomer;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[2]/div[2]/div/div/div[1]/div/div[1]/div/select")
    WebElement selectProductCategory;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[2]/div[2]/div/div/div[1]/div/div[2]/div/select")
    WebElement selectProductCount;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[2]/div[2]/div/div/div[2]/div[2]")
    WebElement product00FromList;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[3]/div[1]/div/input")
    WebElement textboxOrderTax;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[3]/div[2]/div/input")
    WebElement textboxDiscount;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[3]/div[3]/div/input")
    WebElement textboxShipping;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[4]/button[1]")
    WebElement buttonReset;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[4]/button[2]")
    WebElement buttonProceed;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[1]/div[2]/table/tbody/tr[1]/td[3]/div/input")
    WebElement textboxQuantity;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div/button")
    WebElement submitQuantityButton;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    WebElement productPrice;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div[3]/div/div[1]/div/div[2]/div/div/table/tbody/tr[4]/th[2]")
    WebElement grandTotal;

    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div")
    WebElement informationSalePopUp;

    @FindBy(xpath = "//*[@id=\"payment_method\"]")
    WebElement paymentMethodDropdown;

    @FindBy(xpath = "//*[@id=\"paid_amount\"]")
    WebElement textboxReceivedAmount;

    @FindBy(xpath = "//*[@id=\"checkout-form\"]/div[2]/button[2]")
    WebElement submitButton;

    public PosSystemPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        abstractComponents = new AbstractComponents(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectProduct(String productName, String productCategory) {
        if (!Objects.equals(productName, "") && Objects.equals(productCategory, "")) {
            searchByProduct.clear();
            searchByProduct.sendKeys(productName);
            searchedProduct.click();
        } else if (!Objects.equals(productCategory, "") && Objects.equals(productName, "")) {
            selectDropdown = new Select(selectProductCategory);
            selectDropdown.selectByVisibleText(productCategory);
            product00FromList.click();
        } else {
            product00FromList.click();
        }
    }

    public void selectProductCount(String productCount) {
        selectDropdown = new Select(selectProductCount);
        selectDropdown.selectByVisibleText(productCount);
    }

    public void selectCustomer(String customerName) {
        selectDropdown = new Select(selectCustomer);
        selectDropdown.selectByVisibleText(customerName);
    }

    public void inputProductQuantity(String productQuantity) {
        textboxQuantity.clear();
        textboxQuantity.sendKeys(productQuantity);
        submitQuantityButton.click();
    }

    public void inputOrderTax(String tax) {
        textboxOrderTax.clear();
        textboxOrderTax.sendKeys(tax);
    }

    public void inputDiscount(String discount) {
        textboxDiscount.clear();
        textboxDiscount.sendKeys(discount);
    }

    public void inputShipping(String shipping) {
        textboxShipping.clear();
        textboxShipping.sendKeys(shipping);
    }

    public void clickReset() {
        buttonReset.click();
    }

    public void clickProceed() {
        buttonProceed.click();
    }

    public double getProductPrice() {
        String priceText = productPrice.getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public double getGrandTotal() {
        String totalText = grandTotal.getText().replace("(=) $", "").replace("$", "").replace(",", "").trim();
        return Double.parseDouble(totalText);
    }

    public void selectPaymentMethod(String paymentMethod) {
        selectDropdown = new Select(paymentMethodDropdown);
        selectDropdown.selectByVisibleText(paymentMethod);
    }

    public void inputReceivedAmountType(String typeAmount) throws InterruptedException {
        double totalAmount = this.getGrandTotal();
        double partialAmount = totalAmount * 0.6;
        BigDecimal roundedPartialAmount = new BigDecimal(partialAmount).setScale(2, RoundingMode.HALF_UP);

        if (Objects.equals(typeAmount, "Partial")) {
            textboxReceivedAmount.clear();
            textboxReceivedAmount.sendKeys(roundedPartialAmount.toString());
        }
        if (Objects.equals(typeAmount, "Paid")) {
            textboxReceivedAmount.clear();
            textboxReceivedAmount.sendKeys(grandTotal.getText());
        }
    }

    public AllSalesPage createPosSale() {
        submitButton.click();
        return new AllSalesPage(driver);
    }
}
