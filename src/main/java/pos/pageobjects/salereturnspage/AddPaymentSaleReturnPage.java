package pos.pageobjects.salereturnspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AddPaymentSaleReturnPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(id = "getTotalAmount")
    WebElement getTotalAmountButton;
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div/div[1]/div/button")
    WebElement createPaymentButton;

    public AddPaymentSaleReturnPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGetTotalAmountButton() {
        getTotalAmountButton.click();
    }

    public AllSaleReturnsPage clickCreatePaymentButton() {
        createPaymentButton.click();
        return new AllSaleReturnsPage(driver);
    }
}
