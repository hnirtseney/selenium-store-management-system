package pos.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pos.pageobjects.adjustmentspage.AdjustmentPage;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
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

	@FindBy(xpath = "//a[contains(.,'Parties')]")
	WebElement partiesBtn;

	@FindBy (linkText = "Customers")
	WebElement customersBtn;

	@FindBy (linkText = "Suppliers")
	WebElement suppliersBtn;


//	public void waitForElementToAppear(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
//	}
//
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
//
//	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
////		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
//	}

//	public void expandSidebar() {
//		WebElement sidebar = driver.findElement(By.id("sidebar"));
//		if (sidebar.getAttribute("class").contains("c-sidebar-minimized")) {
//			WebElement sidebarToggler = driver.findElement(By.cssSelector(".c-sidebar-minimizer"));
//			sidebarToggler.click();
//		}
//	}

	// Go to Category Page
	public CategoryPage goToCategoryPage() {
		productsBtn.click();
		categoryBtn.click();
		return new CategoryPage(driver);
	}

	// Go to Create Product Page
	public ProductPage goToCreateProductPage() {
		productsBtn.click();
		productBtn.click();
		return new ProductPage(driver);
	}

	// Go to All Product Page
	public AllProductsPage goToAllProductsPage() {
		productsBtn.click();
		allProductsBtn.click();
		return new AllProductsPage(driver);
	}

	// Go to Create Adjustment Page
	public AdjustmentPage goToAdjustmentPage() {
		stockAdjustmentsBtn.click();
		createAdjustmentBtn.click();
		return new AdjustmentPage(driver);
	}

	public AllAdjustmentsPage goToAllAdjustmentsPage() {
		stockAdjustmentsBtn.click();
		allAdjustmentsBtn.click();
		allAdjustmentsBtn.click();
		return new AllAdjustmentsPage(driver);
	}

	public CustomersPage goToCustomersPage() {
		partiesBtn.click();
		customersBtn.click();
		return new CustomersPage(driver);
	}

	public SuppliersPage goToSuppliersPage() {
		partiesBtn.click();
		suppliersBtn.click();
		return new SuppliersPage(driver);
	}

}
