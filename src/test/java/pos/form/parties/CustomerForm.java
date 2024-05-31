package pos.form.parties;

public class CustomerForm {
    public String customer_name;
    public String customer_mail;
    public String customer_phone;
    public String customer_city;
    public String customer_country;
    public String customer_address;


    // Constructor
    public CustomerForm(String customer_name, String customer_mail, String customer_phone, String customer_city, String customer_country, String customer_address) {
        this.customer_name = customer_name;
        this.customer_mail = customer_mail;
        this.customer_phone = customer_phone;
        this.customer_city = customer_city;
        this.customer_country = customer_country;
        this.customer_address = customer_address;
    }
}
