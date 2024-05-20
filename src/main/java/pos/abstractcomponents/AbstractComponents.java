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
import pos.pageobjects.salespage.AllSalesPage;
import pos.pageobjects.salespage.CreateSalePage;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/a")
    WebElement productsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[1]/a")
    WebElement categoryButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[2]/a")
    WebElement productButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[2]/ul/li[3]/a")
    WebElement allProductsButton;
    @FindBy(xpath = "//a[contains(.,'Stock Adjustments')]")
    WebElement stockAdjustmentsButton;
    @FindBy(linkText = "Create Adjustment")
    WebElement createAdjustmentButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[2]/a")
    WebElement allAdjustmentsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/a")
    WebElement partiesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[1]/a")
    WebElement customersButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[2]/a")
    WebElement suppliersButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/a")
    WebElement quotationsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[1]/a")
    WebElement createQuotationButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[2]/a")
    WebElement allQuotationsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/a")
    WebElement salesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/ul[1]/li/a")
    WebElement createSaleButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/ul[2]/li/a")
    WebElement allSalesButton;

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
        productsButton.click();
        categoryButton.click();
        return new CategoryPage(driver);
    }

    public ProductPage goToCreateProductPage() {
        productsButton.click();
        productButton.click();
        return new ProductPage(driver);
    }

    public AllProductsPage goToAllProductsPage() {
        productsButton.click();
        allProductsButton.click();
        return new AllProductsPage(driver);
    }

    public AdjustmentPage goToAdjustmentPage() {
        stockAdjustmentsButton.click();
        createAdjustmentButton.click();
        return new AdjustmentPage(driver);
    }

    public AllAdjustmentsPage goToAllAdjustmentsPage() {
        stockAdjustmentsButton.click();
        allAdjustmentsButton.click();
        allAdjustmentsButton.click();
        return new AllAdjustmentsPage(driver);
    }

    public CustomersPage goToCustomersPage() {
        partiesButton.click();
        customersButton.click();
        return new CustomersPage(driver);
    }

    public SuppliersPage goToSuppliersPage() {
        partiesButton.click();
        suppliersButton.click();
        return new SuppliersPage(driver);
    }

    public QuotationPage goToCreateQuotationPage() {
        quotationsButton.click();
        createQuotationButton.click();
        return new QuotationPage(driver);
    }

    public AllQuotationsPage goToAllQuotationsPage() {
        quotationsButton.click();
        allQuotationsButton.click();
        return new AllQuotationsPage(driver);
    }

    public CreateSalePage goToCreateSalePage() {
        salesButton.click();
        createSaleButton.click();
        return new CreateSalePage(driver);
    }

    public AllSalesPage goToAllSalesPage() {
        salesButton.click();
        allSalesButton.click();
        return new AllSalesPage(driver);
    }

}
