package pos.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pos.pageobjects.adjustmentspage.AdjustmentPage;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.pageobjects.productspage.*;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a")
	WebElement productsBtn;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[1]/a")
	WebElement categoryBtn;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[2]/a")
	WebElement productBtn;
	
	@FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[3]/a")
	WebElement allProductsBtn;

	@FindBy(xpath = "//a[contains(.,'Stock Adjustments')]")
	WebElement stockAdjustmentsBtn;

	@FindBy(linkText = "Create Adjustment")
	WebElement createAdjustmentBtn;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[2]/a")
	WebElement allAdjustmentsBtn;


	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
//		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	// Expand Sidebar
	public void expandSidebar() {
		WebElement sidebar = driver.findElement(By.id("sidebar"));
		// Kiểm tra nếu sidebar đang có class 'c-sidebar-minimized'
		if (sidebar.getAttribute("class").contains("c-sidebar-minimized")) {
			// Tìm nút toggle để mở rộng sidebar
			WebElement sidebarToggler = driver.findElement(By.cssSelector(".c-sidebar-minimizer"));
			sidebarToggler.click();
		}
	}

	// Go to Category Page
	public CategoryPage goToCategoryPage() {
		productsBtn.click();
		categoryBtn.click();
		CategoryPage categoryPage = new CategoryPage(driver);
		return categoryPage;
	}

	// Go to Create Product Page
	public ProductPage goToCreateProductPage() {
		productsBtn.click();
		productBtn.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}

	// Go to All Product Page
	public AllProductsPage goToAllProductsPage() {
		productsBtn.click();
		allProductsBtn.click();
		AllProductsPage allProductsPage = new AllProductsPage(driver);
		return allProductsPage;
	}

	// Go to Create Adjustment Page
	public AdjustmentPage goToAdjustmentPage() {
		stockAdjustmentsBtn.click();
		createAdjustmentBtn.click();
		AdjustmentPage adjustmentPage = new AdjustmentPage(driver);
		return adjustmentPage;
	}

	public AllAdjustmentsPage goToAllAdjustmentsPage() {
		stockAdjustmentsBtn.click();
		allAdjustmentsBtn.click();
		allAdjustmentsBtn.click();
		AllAdjustmentsPage allAdjustmentsPage = new AllAdjustmentsPage(driver);
		return allAdjustmentsPage;
	}

}
