package pos.abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pos.pageobjects.adjustmentspage.AdjustmentPage;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.pageobjects.expensespage.AllExpensesPage;
import pos.pageobjects.expensespage.CategoriesPage;
import pos.pageobjects.expensespage.CreateExpensePage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.pageobjects.productspage.ProductPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.pageobjects.purchasereturnspage.CreatePurchaseReturnPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.pageobjects.purchasespage.CreatePurchasePage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.pageobjects.salereturnspage.CreateSaleReturnPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.pageobjects.salespage.CreateSalePage;
import pos.pageobjects.settingspage.currenciespage.AllCurrenciesPage;
import pos.pageobjects.settingspage.unitspage.AllUnitsPage;
import pos.pageobjects.usermanagementpage.AllUsersPage;
import pos.pageobjects.usermanagementpage.CreateUserPage;

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
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/a")
    WebElement stockAdjustmentsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[1]/a")
    WebElement createAdjustmentButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[3]/ul/li[2]/a")
    WebElement allAdjustmentsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/a")
    WebElement quotationsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[1]/a")
    WebElement createQuotationButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[4]/ul/li[2]/a")
    WebElement allQuotationsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[5]/a")
    WebElement purchasesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[5]/ul[1]/li/a")
    WebElement createPurchasesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[5]/ul[2]/li/a")
    WebElement allPurchasesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[6]/a")
    WebElement purchasesReturnButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[6]/ul[1]/li/a")
    WebElement createPurchasesReturnButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[6]/ul[2]/li/a")
    WebElement allPurchaseReturnsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/a")
    WebElement salesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/ul[1]/li/a")
    WebElement createSaleButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[7]/ul[2]/li/a")
    WebElement allSalesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[8]/a")
    WebElement saleReturnsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[8]/ul[1]/li/a")
    WebElement createSaleReturnButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[8]/ul[2]/li/a")
    WebElement allSaleReturnsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[9]/a")
    WebElement expensesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[9]/ul/li[1]/a")
    WebElement categoriesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[9]/ul/li[2]/a")
    WebElement createExpenseButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[9]/ul/li[3]/a")
    WebElement allExpensesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/a")
    WebElement partiesButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[1]/a")
    WebElement customersButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[10]/ul/li[2]/a")
    WebElement suppliersButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[12]/a")
    WebElement userManagementButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[12]/ul/li[1]/a")
    WebElement createUserButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[12]/ul/li[2]/a")
    WebElement allUsersButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[13]/a")
    WebElement settingsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[13]/ul[1]/li/a")
    WebElement unitsButton;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/ul/li[13]/ul[2]/li/a")
    WebElement currenciesButton;

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

    public AllProductsPage goToAllProductsPage() {
        productsButton.click();
        allProductsButton.click();
        return new AllProductsPage(driver);
    }

    public ProductPage goToCreateProductPage() {
        productsButton.click();
        productButton.click();
        return new ProductPage(driver);
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

    public CreatePurchasePage goToCreatePurchasePage() {
        purchasesButton.click();
        createPurchasesButton.click();
        return new CreatePurchasePage(driver);
    }

    public AllPurchasesPage goToAllPurchasesPage() {
        purchasesButton.click();
        allPurchasesButton.click();
        return new AllPurchasesPage(driver);
    }

    public CreatePurchaseReturnPage goToCreatePurchaseReturnPage() {
        purchasesReturnButton.click();
        createPurchasesReturnButton.click();
        return new CreatePurchaseReturnPage(driver);
    }

    public AllPurchaseReturnsPage goToAllPurchaseReturnsPage() {
        purchasesReturnButton.click();
        allPurchaseReturnsButton.click();
        return new AllPurchaseReturnsPage(driver);
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

    public CreateSaleReturnPage goToCreateSaleReturnPage() {
        saleReturnsButton.click();
        createSaleReturnButton.click();
        return new CreateSaleReturnPage(driver);
    }

    public AllSaleReturnsPage goToAllSaleReturnsPage() {
        saleReturnsButton.click();
        allSaleReturnsButton.click();
        return new AllSaleReturnsPage(driver);
    }

    public CreateExpensePage goToCreateExpensePage() {
        expensesButton.click();
        createExpenseButton.click();
        return new CreateExpensePage(driver);
    }

    public CategoriesPage goToCategoriesPage() {
        expensesButton.click();
        categoriesButton.click();
        return new CategoriesPage(driver);
    }

    public AllExpensesPage goToAllExpensesPage() {
        expensesButton.click();
        allExpensesButton.click();
        return new AllExpensesPage(driver);
    }

    public CustomersPage goToCustomersPage() {
        partiesButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", customersButton);
        customersButton.click();
        return new CustomersPage(driver);
    }

    public SuppliersPage goToSuppliersPage() {
        partiesButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", suppliersButton);
        suppliersButton.click();
        return new SuppliersPage(driver);
    }

    public CreateUserPage goToCreatUserPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", userManagementButton);
        userManagementButton.click();
        createUserButton.click();
        return new CreateUserPage(driver);
    }

    public AllUsersPage goToAllUsersPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", userManagementButton);
        userManagementButton.click();
        allUsersButton.click();
        return new AllUsersPage(driver);
    }

    public AllUnitsPage goToAllUnitsPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", settingsButton);
        settingsButton.click();
        unitsButton.click();
        return new AllUnitsPage(driver);
    }

    public AllCurrenciesPage goToAllCurrenciesPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", settingsButton);
        settingsButton.click();
        currenciesButton.click();
        return new AllCurrenciesPage(driver);
    }

}
