package pos.form.products;

public class ProductForm {
    public String product_name;
    public String product_code;
    public String product_category;
    public String product_barcode;
    public String product_cost;
    public String product_price;
    public String product_quantity;
    public String product_alert_quantity;
    public String product_tax;
    public String product_tax_type;
    public String product_unit;
    public String product_image;


    // Constructor
    public ProductForm(String product_name, String product_code,
                       String product_category, String product_barcode,
                       String product_cost, String product_price, String product_quantity, String product_alert_quantity,
                       String product_tax, String product_tax_type, String product_unit, String product_image) {
        this.product_name = product_name;
        this.product_code = product_code;
        this.product_category = product_category;
        this.product_barcode = product_barcode;
        this.product_cost = product_cost;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.product_alert_quantity = product_alert_quantity;
        this.product_tax = product_tax;
        this.product_tax_type = product_tax_type;
        this.product_unit = product_unit;
        this.product_image = product_image;
    }
}

