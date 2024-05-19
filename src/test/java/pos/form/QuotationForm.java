package pos.form;

public class QuotationForm {
    public String quotation_productCode;
    public String quotation_customer;
    public String quotation_quantity;
    public String quotation_tax;
    public String quotation_discount;
    public String quotation_shipping;
    public String quotation_status;
    public String quotation_message;

    public QuotationForm(String quotation_productCode, String quotation_customer, String quotation_quantity, String quotation_tax, String quotation_discount, String quotation_shipping, String quotation_status, String quotation_message) {
        this.quotation_productCode = quotation_productCode;
        this.quotation_customer = quotation_customer;
        this.quotation_quantity = quotation_quantity;
        this.quotation_tax = quotation_tax;
        this.quotation_discount = quotation_discount;
        this.quotation_shipping = quotation_shipping;
        this.quotation_status = quotation_status;
        this.quotation_message = quotation_message;
    }
}
