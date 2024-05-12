package pos.pageobjects.quotationspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllQuotationsPage{
    WebDriver driver;

    public AllQuotationsPage (WebDriver driver) {
//        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[6]/div/button")
    WebElement expandOption;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void clickDeleteQuotationButton() {
        expandOption.click();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
