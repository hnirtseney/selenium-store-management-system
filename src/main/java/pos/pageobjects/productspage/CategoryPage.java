package pos.pageobjects.productspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pos.abstractcomponents.*;

public class CategoryPage extends AbstractComponents {

	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[data-target='#categoryCreateModal']")
	WebElement addCategoryButton;

	@FindBy(name = "category_code")
	WebElement categoryCodeField;

	@FindBy(name = "category_name")
	WebElement categoryNameField;

	@FindBy(css = "button[type='submit']")
	WebElement createCategoryButton;

	@FindBy(xpath = "//*[@id=\"delete\"]")
	WebElement deleteButton;

	@FindBy(xpath = "//*[@id=\"product_categories-table\"]/tbody/tr[1]/td[4]/a")
	WebElement updateCategoryButton;

	@FindBy(id = "product_categories-table")
	public WebElement productCategoriesTable;

	// Message
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement successMessage;

	@FindBy(xpath = "/html/body/div[2]/div/main/div[1]/div/div/div[1]/div/span")
	WebElement failedMessage;
	
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement deleteSuccessMessage;

	public void openAddCategoryModal() {
		addCategoryButton.click();
	}

	public void inputCategoryCode(String categoryCode) {
		categoryCodeField.clear();
		categoryCodeField.sendKeys(categoryCode);
	}

	public void inputCategoryName(String categoryName) {
		categoryNameField.clear();
		categoryNameField.sendKeys(categoryName);
	}

	public void createCategory() {
		createCategoryButton.click();
	}

	public void deleteCategory() {
		deleteButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}

	public String getFailedMessage() {
		return failedMessage.getText();
	}

	public String updateCreateSuccessMessage() {
		return successMessage.getText();
	}
	
	public String getDeleteSuccessMessage() {
		return deleteSuccessMessage.getText();
	}

	public DetailCategoryPage clickUpdateCategoryButton() {
		updateCategoryButton.click();
		return new DetailCategoryPage(driver);
	}
}
