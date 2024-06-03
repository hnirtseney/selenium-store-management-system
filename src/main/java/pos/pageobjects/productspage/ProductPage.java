package pos.pageobjects.productspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class ProductPage extends AbstractComponents {

    //    @FindBy(id = "document-dropzone")
//    public WebElement imageFileSelect;
    WebDriver driver;
    Select dropdownSelect;
    @FindBy(name = "product_name")
    WebElement productNameField;
    @FindBy(name = "product_code")
    WebElement productCodeField;
    @FindBy(id = "category_id")
    WebElement categorySelect;
    @FindBy(id = "barcode_symbology")
    WebElement barcodeSymbologySelect;
    @FindBy(name = "product_cost")
    WebElement productCostField;
    @FindBy(name = "product_price")
    WebElement productPriceField;
    @FindBy(name = "product_quantity")
    WebElement productQuantityField;
    @FindBy(name = "product_stock_alert")
    WebElement productStockAlertField;
    @FindBy(name = "product_order_tax")
    WebElement productOrderTaxField;
    @FindBy(id = "product_tax_type")
    WebElement taxTypeSelect;
    @FindBy(id = "product_unit")
    WebElement productUnitSelect;
    @FindBy(css = "input[type='file']")
    WebElement imageUpload;
    @FindBy(xpath = "//*[@id=\"product-form\"]/div/div[1]/div/button")
    WebElement createUpdateProductButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputProductName(String productName) {
        productNameField.clear();
        productNameField.sendKeys(productName);
    }

    public void inputProductCode(String productCode) {
        productCodeField.clear();
        productCodeField.sendKeys(productCode);
    }

    public void selectCategory(String productCategory) {
        dropdownSelect = new Select(categorySelect);
        dropdownSelect.selectByVisibleText(productCategory);
    }

    public void selectBarcodeSymbology(String productBarCode) {
        dropdownSelect = new Select(barcodeSymbologySelect);
        dropdownSelect.selectByVisibleText(productBarCode);
    }

    public void inputProductCost(String productCost) {
        productCostField.clear();
        productCostField.sendKeys(productCost);
    }

    public void inputProductPrice(String productPrice) {
        productPriceField.clear();
        productPriceField.sendKeys(productPrice);
    }

    public void inputProductQuantity(String productQuantity) {
        productQuantityField.clear();
        productQuantityField.sendKeys(productQuantity);
    }

    public void inputProductStockAlert(String productStockAlert) {
        productStockAlertField.clear();
        productStockAlertField.sendKeys(productStockAlert);
    }

    public void inputProductOrderTax(String productOrderTax) {
        productOrderTaxField.clear();
        productOrderTaxField.sendKeys(productOrderTax);
    }

    public void selectTaxType(String productTaxType) {
        dropdownSelect = new Select(taxTypeSelect);
        dropdownSelect.selectByVisibleText(productTaxType);
    }

    public void selectProductUnit(String productUnit) {
        dropdownSelect = new Select(productUnitSelect);
        dropdownSelect.selectByVisibleText(productUnit);
    }

    public void uploadImageFile(String imagePath) {
        imageUpload.sendKeys(System.getProperty("user.dir") + "\\resourse\\productphotos\\" + imagePath);
    }

    public AllProductsPage clickSubmitCreateUpdateProduct() {
        createUpdateProductButton.click();
        return new AllProductsPage(driver);
    }
}
