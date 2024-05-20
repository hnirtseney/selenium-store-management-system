package pos.pageobjects.salespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AddPaymentPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(id = "getTotalAmount")
    WebElement getTotalAmountButton;
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div/div[1]/div/button")
    WebElement createPaymentButton;

    public AddPaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGetTotalAmountButton() {
        getTotalAmountButton.click();
    }

    public AllSalesPage clickCreatePaymentButton() {
        createPaymentButton.click();
        return new AllSalesPage(driver);
    }
}
