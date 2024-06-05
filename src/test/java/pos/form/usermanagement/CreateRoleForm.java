package pos.form.usermanagement;

public class CreateRoleForm {
    public String currencyName;
    public String currencyCode;
    public String currencySymbol;
    public String currencyThousandSeparator;
    public String currencyDecimalSeparator;


    // Construct0r
    public CreateRoleForm(String currencyName, String currencyCode, String currencySymbol, String currencyThousandSeparator, String currencyDecimalSeparator) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencySymbol = currencySymbol;
        this.currencyThousandSeparator = currencyThousandSeparator;
        this.currencyDecimalSeparator = currencyDecimalSeparator;
    }


}
