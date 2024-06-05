package pos.pageobjects.usermanagementpage.rolespermissions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CreateRolePage extends AbstractComponents {
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/form/div[1]/button")
    public WebElement createButton;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/form/div[2]/div/div[1]/input")
    WebElement roleNameTextField;

    public CreateRolePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputRoleName(String roleName) {
        roleNameTextField.sendKeys(roleName);
    }

    public RolesAndPermissionsPage clickCreateButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createButton);
        return new RolesAndPermissionsPage(driver);
    }

//    public RolesAndPermissionsPage clickCreateButton() {
//        createButton.click();
//        return new RolesAndPermissionsPage(driver);
//    }
}
