package pos.tests.parties.supplierstest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.parties.customerspage.CreateCustomerPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.pageobjects.parties.supplierspage.CreateSupplierPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class CreateSupplierTest extends BaseTest {
    @DataProvider(name = "suppliersData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//parties//Suppliers.json");
        return data.stream()
                .map(d -> new Object[]{d.get("customer_name"), d.get("customer_mail"), d.get("customer_phone"), d.get("customer_city"), d.get("customer_country"),
                        d.get("customer_address")})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "suppliersData")
    public void createSupplierTest(String customer_name, String customer_mail, String customer_phone, String customer_city, String customer_country, String customer_address) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();

        CreateSupplierPage createSupplierPage = suppliersPage.gotoCreateSupplierPage();
        createSupplierPage.fillSupplierInfo(customer_name, customer_mail, customer_phone, customer_city, customer_country, customer_address);
        SuppliersPage createdCustomersPage = createSupplierPage.clickSubmitCreateSupplier();

        String expectSuccessMessage = "Supplier Created!";
        String actualMessage = createdCustomersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
