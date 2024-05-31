package pos.pageobjects.settingspage.unitspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllUnitsPage extends AbstractComponents {
    // Locator for the table rows
    @FindBy(xpath = "//*[@id=\"data-table\"]")
    public WebElement unitsTable;
    WebDriver driver;
    // Locator for Add Unit button
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addUnitButton;
    @FindBy(xpath = "//*[@id=\"data-table\"]/tbody/tr[1]/td[6]/a")
    WebElement editButton;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public AllUnitsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateUnitPage clickAddUnitButton() {
        addUnitButton.click();
        return new CreateUnitPage(driver);
    }

    public CreateUnitPage editUnit() {
        editButton.click();
        return new CreateUnitPage(driver);
    }

    public void deleteUnit() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
