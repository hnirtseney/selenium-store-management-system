package pos.pageobjects.settingspage.currenciespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CreateCurrencyPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[1]/div/input")
    WebElement currencyNameField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[2]/div/input")
    WebElement currencyCodeField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement currencySymbolField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[2]/div/input")
    WebElement currencyThousandSeparatorField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[3]/div/input")
    WebElement currencyDecimalSeparatorField;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[1]/div/button")
    WebElement submitButton;

    public CreateCurrencyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCurrencyName(String currencyName) {
        currencyNameField.clear();
        currencyNameField.sendKeys(currencyName);
    }

    public void enterCurrencyCode(String currencyCode) {
        currencyCodeField.clear();
        currencyCodeField.sendKeys(currencyCode);
    }

    public void enterCurrencySymbol(String currencySymbol) {
        currencySymbolField.clear();
        currencySymbolField.sendKeys(currencySymbol);
    }

    public void enterCurrencyThousandSeparator(String currencyThousandSeparator) {
        currencyThousandSeparatorField.clear();
        currencyThousandSeparatorField.sendKeys(currencyThousandSeparator);
    }

    public void enterCurrencyDecimalSeparator(String currencyDecimalSeparator) {
        currencyDecimalSeparatorField.clear();
        currencyDecimalSeparatorField.sendKeys(currencyDecimalSeparator);
    }

    public AllCurrenciesPage clickCreateCurrencyButton() {
        submitButton.click();
        return new AllCurrenciesPage(driver);
    }
}
