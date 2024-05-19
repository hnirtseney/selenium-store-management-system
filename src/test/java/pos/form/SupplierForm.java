package pos.form;

public class SupplierForm {
    public String supplier_name;
    public String supplier_mail;
    public String supplier_phone;
    public String supplier_city;
    public String supplier_country;
    public String supplier_address;


    // Constructor
    public SupplierForm(String supplier_name, String supplier_mail, String supplier_phone, String supplier_city, String supplier_country, String supplier_address) {
        this.supplier_name = supplier_name;
        this.supplier_mail = supplier_mail;
        this.supplier_phone = supplier_phone;
        this.supplier_city = supplier_city;
        this.supplier_country = supplier_country;
        this.supplier_address = supplier_address;
    }
}

