package pos.form.pos;

public class CreateSaleByPosForm {
    public String productBySearchBox;
    public String productCategory;
    public String productCount;
    public String customerName;
    public String productQuantity;
    public String productOrderTax;
    public String productDiscount;
    public String productShipping;
    public String paymentMethod;
    public String receivedAmount;


    // Constructor
    public CreateSaleByPosForm(String productBySearchBox, String productCategory, String productCount, String customerName, String productQuantity, String productOrderTax, String productDiscount, String productShipping, String paymentMethod, String receivedAmount) {
        this.productBySearchBox = productBySearchBox;
        this.productCategory = productCategory;
        this.productCount = productCount;
        this.customerName = customerName;
        this.productQuantity = productQuantity;
        this.productOrderTax = productOrderTax;
        this.productDiscount = productDiscount;
        this.productShipping = productShipping;
        this.paymentMethod = paymentMethod;
        this.receivedAmount = receivedAmount;
    }
}

