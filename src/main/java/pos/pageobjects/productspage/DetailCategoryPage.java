package pos.pageobjects.productspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class DetailCategoryPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(name = "category_code")
    WebElement categoryCodeField;

    @FindBy(name = "category_name")
    WebElement categoryNameField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement updateBtn;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div[1]/div/span")
    WebElement failedMessage;

    public DetailCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCategoryCode(String categoryCode) {
        categoryCodeField.clear();
        categoryCodeField.sendKeys(categoryCode);
    }

    public void setCategoryName(String categoryName) {
        categoryNameField.clear();
        categoryNameField.sendKeys(categoryName);
    }

    public CategoryPage clickUpdateBtn() {
        updateBtn.click();
        return new CategoryPage(driver);
    }

    public String getFailedMessage() {
        return failedMessage.getText();
    }
}
