package pos.tests.usermanagement.rolespermissions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.rolespermissions.CreateRolePage;
import pos.pageobjects.usermanagementpage.rolespermissions.RolesAndPermissionsPage;
import pos.testcomponents.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class CreateRoleTest extends BaseTest {
    @DataProvider(name = "rolesData")
    public Object[][] rolesDataProvider() throws IOException {
        List<Map<String, Object>> rolesList = getJsonDataToMapInside(System.getProperty("user.dir") + "/src/test/java/pos/data/usermanagement/Roles.json");

        Object[][] data = new Object[rolesList.size()][1];
        for (int i = 0; i < rolesList.size(); i++) {
            data[i][0] = rolesList.get(i);
        }
        return data;
    }

    public List<Map<String, Object>> getJsonDataToMapInside(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<Map<String, Object>>>() {
        });
    }


    @Test(dataProvider = "rolesData")
    public void createRoleTest(Map<String, Object> roleData) {
        String roleName = (String) roleData.get("roleName");
        Map<String, List<String>> permissions = (Map<String, List<String>>) roleData.get("rolePermission");

        DashboardPage dashboardPage = this.gotoDashboardPage();
        RolesAndPermissionsPage rolesAndPermissionsPage;
        rolesAndPermissionsPage = dashboardPage.goToRolesPermissionsPage();
        CreateRolePage createRolePage = rolesAndPermissionsPage.goToAddRolePage();

        createRolePage.inputRoleName(roleName);
        for (String pageName : permissions.keySet()) {
            List<String> perms = permissions.get(pageName);
            for (String perm : perms) {
                this.clickToggleButton(pageName, perm);
            }
        }

        rolesAndPermissionsPage = createRolePage.clickCreateButton();
        String expectSuccessMessage = "Role Created With Selected Permissions!";
        String actualSuccessMessage = rolesAndPermissionsPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));

    }

    public void clickToggleButton(String pageName, String permissionName) {
        WebElement pageElement = driver.findElement(By.xpath("//div[contains(@class, 'card-header') and normalize-space(text())='" + pageName + "']"));
        WebElement parentEle = pageElement.findElement(By.xpath("./following-sibling::div"));
        WebElement permissionElement = parentEle.findElement(By.xpath(".//label[normalize-space(text())='" + permissionName + "']/preceding-sibling::input"));

        if (permissionElement != null) {
            if (!permissionElement.isSelected()) {
                Actions actions = new Actions(driver);
                actions.moveToElement(permissionElement).click().perform();
            } else {
                System.out.println("Permission " + permissionName + " is already enabled.");
            }
        } else {
            System.out.println("Permission element not found for: " + permissionName);
        }
    }

}
