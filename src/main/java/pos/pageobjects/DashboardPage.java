package pos.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pos.abstractcomponents.*;

public class DashboardPage extends AbstractComponents {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Define sidebar navigation links using PageFactory
	@FindBy(css = "a[href='http://localhost:8000/home']")
	WebElement homeLink;

	@FindBy(css = "a[href='#'][title='Products']")
	WebElement productsDropdown;

	@FindBy(css = "a[href='#'][title='Stock Adjustments']")
	WebElement stockAdjustmentsDropdown;

	@FindBy(css = "a[href='#'][title='Expenses']")
	WebElement expensesDropdown;

	// Define elements for actions in the header
	@FindBy(css = "a[href='http://localhost:8000/app/pos']")
	WebElement posSystemButton;

	@FindBy(css = "i.bi-bi-bell")
	WebElement notificationsIcon;

	@FindBy(css = "img.c-avatar.rounded-circle")
	WebElement profileAvatar;

	@FindBy(xpath = "//a[contains(@href, 'logout')]")
	WebElement logoutLink;

	// Interaction methods
	public void navigateToHome() {
		homeLink.click();
	}

	public void openProductsDropdown() {
		productsDropdown.click();
	}

	public void openStockAdjustmentsDropdown() {
		stockAdjustmentsDropdown.click();
	}

	public void openExpensesDropdown() {
		expensesDropdown.click();
	}

	public void goToPosSystem() {
		posSystemButton.click();
	}

	public void logout() {
		logoutLink.click();
	}

	// Navigation to HomePage
	public void goTo() {
		driver.get("http://localhost:8000/home");
	}
}
