package pos.pageobjects.usermanagementpage.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class CreateUserPage extends AbstractComponents {
    WebDriver driver;
    Select selectDropdown;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[1]/div/input")
    WebElement userName;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[1]/div[2]/div/input")
    WebElement userMail;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[1]/div/input")
    WebElement userPassword;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[2]/div/div/div[2]/div[2]/div/input")
    WebElement userConfirmPassword;
    @FindBy(xpath = "//*[@id=\"role\"]")
    WebElement userRole;
    @FindBy(xpath = "//*[@id=\"is_active\"]")
    WebElement userStatus;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/form/div/div[1]/div/button")
    WebElement createButton;

    public CreateUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUserName(String user_name) {
        userName.clear();
        userName.sendKeys(user_name);
    }

    public void inputUserMail(String user_mail) {
        userMail.clear();
        userMail.sendKeys(user_mail);
    }

    public void inputUserPassword(String user_password) {
        userPassword.clear();
        userPassword.sendKeys(user_password);
    }

    public void inputUserConfirmPassword(String confirm_password) {
        userConfirmPassword.clear();
        userConfirmPassword.sendKeys(confirm_password);
    }

    public void selectUserRole(String user_role) {
        selectDropdown = new Select(userRole);
        selectDropdown.selectByVisibleText(user_role);
    }

    public void selectUserStatus(String user_status) {
        selectDropdown = new Select(userStatus);
        selectDropdown.selectByVisibleText(user_status);
    }

    public AllUsersPage clickSubmitButton() {
        createButton.click();
        return new AllUsersPage(driver);
    }
}