package pos.form.salereturns;

public class CreateSaleReturnForm {
    public String productCode;
    public String customerName;
    public String productQuantity;
    public String saleReturnTax;
    public String saleReturnDiscount;
    public String saleReturnShipping;
    public String saleReturnStatus;
    public String saleReturnPaymentMethod;
    public String saleReturnAmountReceived;


    // Constructor
    public CreateSaleReturnForm(String productCode, String customerName, String productQuantity, String saleReturnTax, String saleReturnDiscount, String saleReturnShipping, String saleReturnStatus, String saleReturnPaymentMethod, String saleReturnAmountReceived) {
        this.productCode = productCode;
        this.customerName = customerName;
        this.productQuantity = productQuantity;
        this.saleReturnTax = saleReturnTax;
        this.saleReturnDiscount = saleReturnDiscount;
        this.saleReturnShipping = saleReturnShipping;
        this.saleReturnStatus = saleReturnStatus;
        this.saleReturnPaymentMethod = saleReturnPaymentMethod;
        this.saleReturnAmountReceived = saleReturnAmountReceived;
    }
}
