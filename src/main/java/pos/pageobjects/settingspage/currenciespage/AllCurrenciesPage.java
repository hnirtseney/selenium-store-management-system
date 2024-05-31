package pos.pageobjects.settingspage.currenciespage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllCurrenciesPage extends AbstractComponents {
    @FindBy(xpath = "//*[@id=\"currency-table\"]")
    public WebElement currenciesTable;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addCurrencyButton;
    @FindBy(xpath = "//*[@id=\"currency-table\"]/tbody/tr/td[6]/a")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public AllCurrenciesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateCurrencyPage clickAddCurrencyButton() {
        addCurrencyButton.click();
        return new CreateCurrencyPage(driver);
    }

    public CreateCurrencyPage editCurrency() {
        editButton.click();
        return new CreateCurrencyPage(driver);
    }

    public void deleteCurrency() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
