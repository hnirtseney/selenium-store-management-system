package pos.abstractcomponents;

import org.openqa.selenium.By;
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
import pos.pageobjects.productspage.AllProductsPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.pageobjects.productspage.ProductPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;
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
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/a")
    WebElement partiesBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[1]/a")
    WebElement customersBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[2]/a")
    WebElement suppliersBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/a")
    WebElement quotationsBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[1]/a")
    WebElement createQuotationBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[2]/a")
    WebElement allQuotationsBtn;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

//	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
//	}

//	public void expandSidebar() {
//		WebElement sidebar = driver.findElement(By.id("sidebar"));
//		if (sidebar.getAttribute("class").contains("c-sidebar-minimized")) {
//			WebElement sidebarToggle = driver.findElement(By.cssSelector(".c-sidebar-minimizer"));
//			sidebarToggle.click();
//		}
//	}

    public CategoryPage goToCategoryPage() {
        productsBtn.click();
        categoryBtn.click();
        return new CategoryPage(driver);
    }

    public ProductPage goToCreateProductPage() {
        productsBtn.click();
        productBtn.click();
        return new ProductPage(driver);
    }

    public AllProductsPage goToAllProductsPage() {
        productsBtn.click();
        allProductsBtn.click();
        return new AllProductsPage(driver);
    }

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

    public QuotationPage goToCreateQuotationPage() {
        quotationsBtn.click();
        createQuotationBtn.click();
        return new QuotationPage(driver);
    }

    public AllQuotationsPage goToAllQuotationsPage() {
        quotationsBtn.click();
        allQuotationsBtn.click();
        return new AllQuotationsPage(driver);
    }

}
