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
    
	@FindBy(xpath = "//*[@id=\"delete\"]")
	WebElement deleteProductBtn;
	
	@FindBy(xpath ="//*[@id=\"product-table\"]/tbody/tr[1]/td[8]/a[1]")
	WebElement updateProductBtn;
	
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement successMessage;
    
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
