package pos.pageobjects.usermanagementpage.users;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllUsersPage extends AbstractComponents {
    @FindBy(xpath = "//*[@id=\"users-table\"]")
    public WebElement usersTable;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addUserButton;
    @FindBy(xpath = "//*[@id=\"users-table\"]/tbody/tr/td[6]/a")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"users-table\"]/tbody/tr[1]/td[4]/span")
    WebElement userRole;

    public AllUsersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateUserPage clickAddUserButton() {
        addUserButton.click();
        return new CreateUserPage(driver);
    }

    public CreateUserPage editUser() {
        editButton.click();
        return new CreateUserPage(driver);
    }

    public void deleteUser() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getUserRole() {
        return userRole.getText();
    }
}
