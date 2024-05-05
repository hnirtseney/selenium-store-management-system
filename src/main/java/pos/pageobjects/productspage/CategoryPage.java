package pos.pageobjects.productspage;

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

	public void openAddCategoryModal() {
		addCategoryButton.click();
	}

	public void fillCategoryForm(String categoryCode, String categoryName) {
		categoryCodeField.clear();
		categoryCodeField.sendKeys(categoryCode);
		categoryNameField.clear();
		categoryNameField.sendKeys(categoryName);
	}

	public void createCategory() {
		createCategoryButton.click();
	}

	// Navigation to Categories Page
	public void goTo() {
		driver.get("http://localhost:8000/product-categories");
	}
}
