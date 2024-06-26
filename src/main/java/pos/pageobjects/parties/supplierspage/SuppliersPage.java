package pos.pageobjects.parties.supplierspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class SuppliersPage extends AbstractComponents {
    @FindBy(xpath = "//*[@id=\"suppliers-table\"]")
    public WebElement supplierTable;
    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div/div/div/div/div/a")
    WebElement addSupplierBtn;
    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteSupplierBtn;
    @FindBy(xpath = "//*[@id=\"suppliers-table\"]/tbody/tr[1]/td[4]/a[1]")
    WebElement updateSupplierBtn;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;


    //    *[@id="sidebar"]
    public SuppliersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateSupplierPage gotoCreateSupplierPage() {
        addSupplierBtn.click();
        return new CreateSupplierPage(driver);
    }

    public CreateSupplierPage updateSupplierPage() {
        updateSupplierBtn.click();
        return new CreateSupplierPage(driver);
    }

    public void deleteSupplier() {
        deleteSupplierBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
