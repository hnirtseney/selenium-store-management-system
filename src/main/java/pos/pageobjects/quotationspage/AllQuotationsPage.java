package pos.pageobjects.quotationspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllQuotationsPage extends AbstractComponents {
    @FindBy(id = "sales-table_wrapper")
    public WebElement allQuotationsTable;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[6]/div/button")
    WebElement expandOption;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[6]/div/div/a[3]")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"sales-table\"]/tbody/tr[1]/td[6]/div/div/a[1]")
    WebElement makeSaleButton;

    public AllQuotationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void expandSetting() {
        expandOption.click();
    }

    public MakeSalePage makeSaleQuotation() {
        makeSaleButton.click();
        return new MakeSalePage(driver);
    }

    public QuotationPage editQuotation() {
        editButton.click();
        return new QuotationPage(driver);
    }

    public void deleteQuotation() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
