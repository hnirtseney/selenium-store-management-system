package pos.pageobjects.quotationspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllQuotationsPage extends AbstractComponents {
    WebDriver driver;

    public AllQuotationsPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
