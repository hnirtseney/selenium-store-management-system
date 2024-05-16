package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
                .map(d -> new Object[]{d.get("supplier_name"), d.get("supplier_mail"), d.get("supplier_phone"), d.get("supplier_city"), d.get("supplier_country"),
                        d.get("supplier_address")})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "suppliersData")
    public void createSupplierTest(String supplier_name, String supplier_mail, String supplier_phone, String supplier_city, String supplier_country, String supplier_address) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();

        CreateSupplierPage createSupplierPage = suppliersPage.gotoCreateSupplierPage();
        createSupplierPage.inputSupplierName(supplier_name);
        createSupplierPage.inputSupplierMail(supplier_mail);
        createSupplierPage.inputSupplierPhone(supplier_phone);
        createSupplierPage.inputSupplierCity(supplier_city);
        createSupplierPage.inputSupplierCountry(supplier_country);
        createSupplierPage.inputSupplierAddress(supplier_address);

        SuppliersPage createdsuppliersPage = createSupplierPage.clickSubmitCreateSupplier();

        String expectSuccessMessage = "Supplier Created!";
        String actualMessage = createdsuppliersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
