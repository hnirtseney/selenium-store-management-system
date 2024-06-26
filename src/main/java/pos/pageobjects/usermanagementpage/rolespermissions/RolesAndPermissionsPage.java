package pos.pageobjects.usermanagementpage.rolespermissions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class RolesAndPermissionsPage extends AbstractComponents {
    @FindBy(xpath = "//*[@id=\"roles-table\"]")
    public WebElement tableRolesAndPermissions;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addRoleButton;
    @FindBy(xpath = "//*[@id=\"roles-table\"]/tbody/tr[3]/td[4]/a")
    WebElement editButton;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public RolesAndPermissionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateRolePage goToAddRolePage() {
        addRoleButton.click();
        return new CreateRolePage(driver);
    }

    public CreateRolePage updateRole() {
        editButton.click();
        return new CreateRolePage(driver);
    }

    public void deleteRole() {
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

}

