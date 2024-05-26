package pos.pageobjects.purchasereturnspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class ShowPaymentPurchaseReturnPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(id = "delete")
    WebElement deleteButton;

    public ShowPaymentPurchaseReturnPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllPurchaseReturnsPage clickDeleteButton() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new AllPurchaseReturnsPage(driver);
    }

}
