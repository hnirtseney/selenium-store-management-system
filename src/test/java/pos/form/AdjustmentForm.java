package pos.form;

public class AdjustmentForm {
    public String product_code;
    public String adjustment_quantity;
    public String adjustment_type;

    // Constructor
    public AdjustmentForm(String product_code, String adjustment_quantity, String adjustment_type) {
        this.product_code = product_code;
        this.adjustment_quantity = adjustment_quantity;
        this.adjustment_type = adjustment_type;
    }
}
