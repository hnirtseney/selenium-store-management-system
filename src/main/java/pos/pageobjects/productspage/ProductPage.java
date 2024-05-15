package pos.pageobjects.productspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pos.abstractcomponents.AbstractComponents;

public class ProductPage extends AbstractComponents {

	WebDriver driver;
	Select dropdownSelect;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// text-field
	@FindBy(name = "product_name")
	WebElement productNameField;

	// text-field
	@FindBy(name = "product_code")
	WebElement productCodeField;

	// dropdown
	@FindBy(id = "category_id")
	WebElement categorySelect;

	// dropdown
	@FindBy(id = "barcode_symbology")
	WebElement barcodeSymbologySelect;

	// number-field
	@FindBy(name = "product_cost")
	WebElement productCostField;

	// number-field
	@FindBy(name = "product_price")
	WebElement productPriceField;

	// number-field
	@FindBy(name = "product_quantity")
	WebElement productQuantityField;

	// number-field
	@FindBy(name = "product_stock_alert")
	WebElement productStockAlertField;

	// number-field
	@FindBy(name = "product_order_tax")
	WebElement productOrderTaxField;

	@FindBy(id = "product_tax_type")
	WebElement taxTypeSelect;

	// dropdown
	@FindBy(id = "product_unit")
	WebElement productUnitSelect;

	// button
	@FindBy(xpath = "//*[@id=\"product-form\"]/div/div[1]/div/button")
	WebElement createUpdateProductButton;

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

	public AllProductsPage clickSubmitCreateUpdateProduct() {
		createUpdateProductButton.click();
		return new AllProductsPage(driver);
	}
}
