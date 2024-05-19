package pos.tests.parties.customerstest;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.CustomerForm;
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
                .map(d -> new Object[]{new CustomerForm(
                        d.get("customer_name"),
                        d.get("customer_mail"),
                        d.get("customer_phone"),
                        d.get("customer_city"),
                        d.get("customer_country"),
                        d.get("customer_address")
                )})
                .toArray(Object[][]::new);
    }

    public CreateCustomerPage fillForm(CustomerForm form) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        CustomersPage customersPage = dashboardPage.goToCustomersPage();
        CreateCustomerPage createCustomerPage = customersPage.gotoCreateCustomerPage();

        createCustomerPage.inputCustomerName(form.customer_name);
        createCustomerPage.inputCustomerMail(form.customer_mail);
        createCustomerPage.inputCustomerPhone(form.customer_phone);
        createCustomerPage.inputCustomerCity(form.customer_city);
        createCustomerPage.inputCustomerCountry(form.customer_country);
        createCustomerPage.inputCustomerAddress(form.customer_address);
        return createCustomerPage;
    }

    @Test(dataProvider = "customersData")
    public void createCustomerTest(CustomerForm form) {
        CreateCustomerPage createCustomerPage = this.fillForm(form);
        CustomersPage createdCustomersPage = createCustomerPage.clickSubmitCreateCustomer();

        String expectSuccessMessage = "Customer Created!";
        String actualMessage = createdCustomersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
