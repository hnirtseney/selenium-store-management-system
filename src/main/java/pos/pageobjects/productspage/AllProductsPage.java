package pos.pageobjects.productspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {
    WebDriver driver;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
//    @FindBy(xpath = "//a[contains(@href, '/products/create')]")
//    private WebElement addButton;
//
//    @FindBy(id = "product-table")
//    private WebElement productsTable;
//
//    @FindBy(css = "div.dataTables_filter input")
//    private WebElement searchInput;
    
	@FindBy(xpath = "//*[@id=\"delete\"]")
	WebElement deleteProductBtn;
	
	@FindBy(xpath ="//*[@id=\"product-table\"]/tbody/tr[1]/td[8]/a[1]")
	WebElement updateProductBtn;
	
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement successMessage;

    // Page Methods
//    public void goToCreateProduct() {
//        addButton.click();
//    }
//
//    public boolean isProductTableVisible() {
//        return productsTable.isDisplayed();
//    }
//
//    public void searchForProduct(String productName) {
//        searchInput.sendKeys(productName);
//    }
    
	public String getSuccessMessage() {
		return successMessage.getText();
	}
    
	public void deleteProduct() {
		deleteProductBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public ProductPage goToUpdateProductPage() {
		updateProductBtn.click();
		return new ProductPage(driver);
    }
}
