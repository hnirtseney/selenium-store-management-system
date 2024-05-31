package pos.form.purchases;

public class CreatePurchaseForm {
    public String productCode;
    public String supplierName;
    public String productQuantity;
    public String purchaseTax;
    public String purchaseDiscount;
    public String purchaseShipping;
    public String purchaseStatus;
    public String purchasePaymentMethod;
    public String purchaseAmountPaid;


    // Constructor
    public CreatePurchaseForm(String productCode, String supplierName, String productQuantity, String purchaseTax, String purchaseDiscount, String purchaseShipping, String purchaseStatus, String purchasePaymentMethod, String purchaseAmountPaid) {
        this.productCode = productCode;
        this.supplierName = supplierName;
        this.productQuantity = productQuantity;
        this.purchaseTax = purchaseTax;
        this.purchaseDiscount = purchaseDiscount;
        this.purchaseShipping = purchaseShipping;
        this.purchaseStatus = purchaseStatus;
        this.purchasePaymentMethod = purchasePaymentMethod;
        this.purchaseAmountPaid = purchaseAmountPaid;
    }
}
