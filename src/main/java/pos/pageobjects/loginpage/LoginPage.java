package pos.pageobjects.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;
import pos.pageobjects.dashboardpage.DashboardPage;

public class LoginPage extends AbstractComponents {

    WebDriver driver;
    // Định nghĩa các WebElement sử dụng PageFactory
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "submit")
    WebElement submitButton;
    @FindBy(css = "div[class*='invalid-feedback']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        // Khởi tạo
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Phương thức để đăng nhập
    public DashboardPage login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
        return new DashboardPage(driver);
    }

    // Phương thức lấy thông báo lỗi
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goToLoginPage() {
        driver.get("http://127.0.0.1:8000/login");
    }
}
