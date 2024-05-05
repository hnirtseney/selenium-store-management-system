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
<<<<<<< HEAD

	// Message
	@FindBy(xpath = "")
	WebElement createSuccessMessage;

	@FindBy(xpath = "")
	WebElement updateSuccessMessage;

=======
	
	
	//Message
	@FindBy(xpath = "")
	WebElement createSuccessMessage;
	
//	@FindBy(xpath = "")
//	WebElement updateSuccessMessage;
	
>>>>>>> ffadb6bfbea27ba15fb250764e4abb8192ed5961
	@FindBy(xpath = "//*[@id=\"swal2-title\"]")
	WebElement deleteSuccessMessage;

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

	public void deleteCategory() {
		deleteButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
<<<<<<< HEAD

	public String getCreateSuccessMessage() {
		return createSuccessMessage.getText();
	}

	public String updateCreateSuccessMessage() {
		return updateSuccessMessage.getText();
	}

=======
	
	public String getCreateSuccessMessage() {
		return createSuccessMessage.getText();
	}
	
//	public String updateCreateSuccessMessage() {
//		return updateSuccessMessage.getText();
//	}
	
>>>>>>> ffadb6bfbea27ba15fb250764e4abb8192ed5961
	public String getDeleteSuccessMessage() {
		return deleteSuccessMessage.getText();
	}

	public void goTo() {
		driver.get("http://localhost:8000/product-categories");
	}
}
