package pos.pageobjects.adjustmentspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class AdjustmentPage extends AbstractComponents {
    WebDriver driver;

    public AdjustmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements

    @FindBy(xpath="//input[@type='text']")
    WebElement searchTextBox;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[1]/div/div/div[4]/div/ul/li/a")
    WebElement searchedProduct;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div[2]/div/div/div/form/div[2]/div/table/tbody/tr/td[5]/input")
    WebElement adjustmentQuantity;

    @FindBy (xpath = "/html/body/div[2]/div/main/div/div[2]/div/div/div/form/div[2]/div/table/tbody/tr/td[6]/select")
    WebElement adjustmentType;

    @FindBy(css = "button[type='submit']")
    WebElement createAdjustmentButton;

    // Find Product
    public void searchByProduct (String productCode) {
        searchTextBox.clear();
        searchTextBox.sendKeys(productCode);
        searchedProduct.click();
    }

    public void fillAdjustmentQuantity (String quantity) {
        adjustmentQuantity.clear();
        adjustmentQuantity.sendKeys(quantity);
    }

    public void chooseAdjustmentType (String type) {
        Select taxTypeDropdown = new Select(adjustmentType);
        taxTypeDropdown.selectByVisibleText(type);
    }

    public AllAdjustmentsPage clickCreateSuccess () {
        createAdjustmentButton.click();
        AllAdjustmentsPage allAdjustmentsPage = new AllAdjustmentsPage(driver);
        return allAdjustmentsPage;
    }

}
