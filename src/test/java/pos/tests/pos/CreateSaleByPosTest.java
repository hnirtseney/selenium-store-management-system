package pos.tests.pos;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.pos.CreateSaleByPosForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.pospage.PosSystemPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class CreateSaleByPosTest extends BaseTest {
    @DataProvider(name = "saleByPosData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//pos//SalesByPos.json");
        return data.stream()
                .map(d -> new Object[]{new CreateSaleByPosForm(
                        d.get("productBySearchBox"),
                        d.get("productCategory"),
                        d.get("productCount"),
                        d.get("customerName"),
                        d.get("productQuantity"),
                        d.get("productOrderTax"),
                        d.get("productDiscount"),
                        d.get("productShipping"),
                        d.get("paymentMethod"),
                        d.get("receivedAmount")
                )})
                .toArray(Object[][]::new);
    }

    public PosSystemPage fillForm(CreateSaleByPosForm form) throws InterruptedException {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        PosSystemPage posSystemPage = dashboardPage.goToPosSystemPage();

        String quantity1 = form.productQuantity;
        String tax = form.productOrderTax;
        String productDiscount = form.productDiscount;
        String productShipping = form.productShipping;

        posSystemPage.selectProduct(form.productBySearchBox, form.productCategory);
        posSystemPage.selectProductCount(form.productCount);
        posSystemPage.selectCustomer(form.customerName);
        posSystemPage.inputProductQuantity(quantity1);
        posSystemPage.inputOrderTax(tax);
        posSystemPage.inputDiscount(productDiscount);
        posSystemPage.inputShipping(productShipping);
        double pricePerProduct = posSystemPage.getProductPrice();
        double quantity = Double.parseDouble(quantity1);
        double orderTax = Double.parseDouble(tax);
        double discount = Double.parseDouble(productDiscount);
        double shipping = Double.parseDouble(productShipping);
        Thread.sleep(2000);
        double expectedGrandTotal = pricePerProduct * quantity * (1 + orderTax / 100) * (1 - discount / 100) + shipping;
        // Làm tròn giá trị expectedGrandTotal đến 2 chữ số thập phân
        BigDecimal exp = new BigDecimal(Double.toString(expectedGrandTotal));
        exp = exp.setScale(0, RoundingMode.HALF_UP);
        expectedGrandTotal = exp.doubleValue();
        Thread.sleep(2000);
        double actualGrandTotal = posSystemPage.getGrandTotal();
        BigDecimal act = new BigDecimal(Double.toString(actualGrandTotal));
        act = act.setScale(0, RoundingMode.HALF_UP);
        actualGrandTotal = act.doubleValue();
        posSystemPage.clickProceed();
        Thread.sleep(2000);
        posSystemPage.selectPaymentMethod(form.paymentMethod);
        posSystemPage.inputReceivedAmountType(form.receivedAmount);

        Assert.assertEquals(actualGrandTotal, expectedGrandTotal, "Grand Total does not match the expected value.");

        return posSystemPage;
    }

    // Create Success By Normal Case
    @Test(dataProvider = "saleByPosData")
    public void createProductProceedTest(CreateSaleByPosForm form) throws InterruptedException {
        PosSystemPage posSystemPage = this.fillForm(form);

        AllSalesPage allSalesPage = posSystemPage.createPosSale();
        String expectedSuccessMessage = "POS Sale Created!";
        String actualSuccessMessage = allSalesPage.getSuccessMessage();

        Assert.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectedSuccessMessage), "Success message does not match the expected value.");
    }
}
