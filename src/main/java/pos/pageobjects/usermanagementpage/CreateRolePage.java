package pos.pageobjects.usermanagementpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CreateRolePage extends AbstractComponents {
    WebDriver driver;

    public CreateRolePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
