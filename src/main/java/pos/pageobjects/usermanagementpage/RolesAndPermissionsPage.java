package pos.pageobjects.usermanagementpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class RolesAndPermissionsPage extends AbstractComponents {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addRoleButton;
    @FindBy(id = "roles-table")
    WebElement tableRolesAndPermissions;
    @FindBy(xpath = "//*[@id=\"roles-table\"]/tbody/tr/td[4]/a")
    WebElement editButton;
    @FindBy(id = "delete")
    WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public RolesAndPermissionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateRolePage clickAddRole() {
        addRoleButton.click();
        return new CreateRolePage(driver);
    }

    public CreateRolePage UpdateRole() {
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

