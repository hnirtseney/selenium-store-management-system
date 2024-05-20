package pos.form;

public class CreateSaleForm {
    public String productCode;
    public String customerName;
    public String productQuantity;
    public String saleTax;
    public String saleDiscount;
    public String saleShipping;
    public String saleStatus;
    public String salePaymentMethod;
    public String saleAmountReceived;


    // Constructor
    public CreateSaleForm(String productCode, String customerName, String productQuantity, String saleTax, String saleDiscount, String saleShipping, String saleStatus, String salePaymentMethod, String saleAmountReceived) {
        this.productCode = productCode;
        this.customerName = customerName;
        this.productQuantity = productQuantity;
        this.saleTax = saleTax;
        this.saleDiscount = saleDiscount;
        this.saleShipping = saleShipping;
        this.saleStatus = saleStatus;
        this.salePaymentMethod = salePaymentMethod;
        this.saleAmountReceived = saleAmountReceived;
    }
}

