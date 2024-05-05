package pos.pageobjects.productspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {
    private WebDriver driver;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(xpath = "//a[contains(@href, '/products/create')]")
    private WebElement addButton;

    @FindBy(id = "product-table")
    private WebElement productsTable;

    @FindBy(css = "div.dataTables_filter input")
    private WebElement searchInput;
    
	@FindBy(xpath = "//*[@id=\"delete\"]")
	WebElement deleteProductButton;
	
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement deleteSuccessMessage;

    // Page Methods
    public void goToCreateProduct() {
        addButton.click();
    }

    public boolean isProductTableVisible() {
        return productsTable.isDisplayed();
    }

    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName);
    }
    
	public String getDeleteSuccessMessage() {
		return deleteSuccessMessage.getText();
	}
    
	public void deleteProduct() {
		deleteProductButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

    // Navigation
    public void navigateToProductsPage() {
        driver.get("http://127.0.0.1:8000/products");
    }
}
