package pos.form;

public class CreatePurchaseReturnForm {
    public String productCode;
    public String supplierName;
    public String productQuantity;
    public String purchaseReturnTax;
    public String purchaseReturnDiscount;
    public String purchaseReturnShipping;
    public String purchaseReturnStatus;
    public String purchaseReturnPaymentMethod;
    public String purchaseReturnAmountPaid;


    // Constructor
    public CreatePurchaseReturnForm(String productCode, String supplierName, String productQuantity, String purchaseReturnTax, String purchaseReturnDiscount, String purchaseReturnShipping, String purchaseReturnStatus, String purchaseReturnPaymentMethod, String purchaseReturnAmountPaid) {
        this.productCode = productCode;
        this.supplierName = supplierName;
        this.productQuantity = productQuantity;
        this.purchaseReturnTax = purchaseReturnTax;
        this.purchaseReturnDiscount = purchaseReturnDiscount;
        this.purchaseReturnShipping = purchaseReturnShipping;
        this.purchaseReturnStatus = purchaseReturnStatus;
        this.purchaseReturnPaymentMethod = purchaseReturnPaymentMethod;
        this.purchaseReturnAmountPaid = purchaseReturnAmountPaid;
    }
}
