package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.SupplierForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.supplierspage.CreateSupplierPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateSupplierTest extends BaseTest {
    @DataProvider(name = "suppliersData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//parties//Suppliers.json");
        return data.stream()
                .map(d -> new Object[]{new SupplierForm(
                        d.get("supplier_name"),
                        d.get("supplier_mail"),
                        d.get("supplier_phone"),
                        d.get("supplier_city"),
                        d.get("supplier_country"),
                        d.get("supplier_address")
                )})
                .toArray(Object[][]::new);
    }

    public CreateSupplierPage fillForm(SupplierForm form) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();
        CreateSupplierPage createSupplierPage = suppliersPage.gotoCreateSupplierPage();

        createSupplierPage.inputSupplierName(form.supplier_name);
        createSupplierPage.inputSupplierMail(form.supplier_mail);
        createSupplierPage.inputSupplierPhone(form.supplier_phone);
        createSupplierPage.inputSupplierCity(form.supplier_city);
        createSupplierPage.inputSupplierCountry(form.supplier_country);
        createSupplierPage.inputSupplierAddress(form.supplier_address);
        return createSupplierPage;
    }

    @Test(dataProvider = "suppliersData")
    public void createSupplierTest(SupplierForm form) {
        CreateSupplierPage createSupplierPage = this.fillForm(form);

        SuppliersPage createdSuppliersPage = createSupplierPage.clickSubmitCreateSupplier();

        String expectSuccessMessage = "Supplier Created!";
        String actualMessage = createdSuppliersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
