package pos.tests.products.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
//import pos.pageobjects.productspage.CategoryPage;
import pos.pageobjects.productspage.ProductPage;
import pos.testcomponents.BaseTest;

public class CreateProductTest extends BaseTest {
	@DataProvider(name = "productData")
	public Object[][] getProductData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pos//data//products//Product.json");
		return data.stream()
				.map(d -> new Object[] { d.get("product_name"), d.get("product_code"), d.get("product_cost"),
						d.get("product_price"), d.get("product_quantity"), d.get("product_alert_quantity"),
						d.get("product_tax"), })
				.toArray(Object[][]::new);
	}

	@Test(dataProvider = "productData")
	public void createProductTest(String productName, String productCode, String productCost, String productPrice,
			String productQuantity, String productStockAlert, String productOrderTax) {
		// Login
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

		// Navigate to Create Product Page through Dashboard
		ProductPage productPage = dashboardPage.goToCreateProductPage();

		// Create Product
		productPage.fillProductForm(productName, productCode, productCost, productPrice, productQuantity,
				productStockAlert, productOrderTax);
		AllProductsPage allProductsPage = productPage.clickSubmitCreateUpdateProduct();

		String expectUpdateSuccessMessage = allProductsPage.getSuccessMessage();
		String actualUpdateSuccessMessage = "Product Created!";

		AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
	}

}
