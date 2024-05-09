package pos.pageobjects.productspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pos.abstractcomponents.AbstractComponents;

public class ProductPage extends AbstractComponents {

	WebDriver driver;

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
	
	public void fillProductForm(String productName, String productCode,
			String productCategory, String productBarCode,
			String productCost, String productPrice, String productQuantity, String productStockAlert,
			String productOrderTax, String productTaxType, String productUnit) {

		productNameField.clear();
		productNameField.sendKeys(productName);

		productCodeField.clear();
		productCodeField.sendKeys(productCode);

		Select categoryDropdown = new Select(categorySelect);
		categoryDropdown.selectByVisibleText(productCategory);

		Select barcodeSymbologyDropdown = new Select(barcodeSymbologySelect);
		barcodeSymbologyDropdown.selectByVisibleText(productBarCode);

		productCostField.clear();
		productCostField.sendKeys(productCost);

		productPriceField.clear();
		productPriceField.sendKeys(productPrice);

		productQuantityField.clear();
		productQuantityField.sendKeys(productQuantity);

		productStockAlertField.clear();
		productStockAlertField.sendKeys(productStockAlert);

		productOrderTaxField.clear();
		productOrderTaxField.sendKeys(productOrderTax);

		Select taxTypeDropdown = new Select(taxTypeSelect);
		taxTypeDropdown.selectByVisibleText(productTaxType);

		Select unitDropdown = new Select(productUnitSelect);
		unitDropdown.selectByVisibleText(productUnit);
	}

	public AllProductsPage clickSubmitCreateUpdateProduct() {
		createUpdateProductButton.click();
		return new AllProductsPage(driver);
	}
}
