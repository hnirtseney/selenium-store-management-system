package pos.tests.parties.customerstest;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.customerspage.CreateCustomerPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateCustomerTest extends BaseTest {
    @DataProvider(name = "customersData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//parties//Customers.json");
        return data.stream()
                .map(d -> new Object[]{d.get("customer_name"), d.get("customer_mail"), d.get("customer_phone"), d.get("customer_city"), d.get("customer_country"),
                        d.get("customer_address")})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "customersData")
    public void createCustomerTest(String customer_name, String customer_mail, String customer_phone, String customer_city, String customer_country, String customer_address) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

        CustomersPage customersPage = dashboardPage.goToCustomersPage();
        CreateCustomerPage createCustomerPage = customersPage.gotoCreateCustomerPage();

        createCustomerPage.inputCustomerName(customer_name);
        createCustomerPage.inputCustomerMail(customer_mail);
        createCustomerPage.inputCustomerPhone(customer_phone);
        createCustomerPage.inputCustomerCity(customer_city);
        createCustomerPage.inputCustomerCountry(customer_country);
        createCustomerPage.inputCustomerAddress(customer_address);

        CustomersPage createdCustomersPage = createCustomerPage.clickSubmitCreateCustomer();

        String expectSuccessMessage = "Customer Created!";
        String actualMessage = createdCustomersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
