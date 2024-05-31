package pos.pageobjects.settingspage.unitspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CreateUnitPage extends AbstractComponents {
    WebDriver driver;
    // Locators for the form fields
    @FindBy(name = "name")
    WebElement unitNameField;

    @FindBy(name = "short_name")
    WebElement shortNameField;

    @FindBy(name = "operator")
    WebElement operatorField;

    @FindBy(name = "operation_value")
    WebElement operationValueField;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div/div/div/div/div[5]/div/button")
    WebElement submitButton;

    public CreateUnitPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUnitName(String unitName) {
        unitNameField.clear();
        unitNameField.sendKeys(unitName);
    }

    public void enterShortName(String shortName) {
        shortNameField.clear();
        shortNameField.sendKeys(shortName);
    }

    public void enterOperator(String operator) {
        operatorField.clear();
        operatorField.sendKeys(operator);
    }

    public void enterOperationValue(String operationValue) {
        operationValueField.clear();
        operationValueField.sendKeys(operationValue);
    }

    public AllUnitsPage clickCreateUnitButton() {
        submitButton.click();
        return new AllUnitsPage(driver);
    }
    
}
