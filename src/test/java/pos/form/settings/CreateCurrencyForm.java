package pos.form.settings;

public class CreateCurrencyForm {
    public String currencyName;
    public String currencyCode;
    public String currencySymbol;
    public String currencyThousandSeparator;
    public String currencyDecimalSeparator;


    // Construct0r
    public CreateCurrencyForm(String currencyName, String currencyCode, String currencySymbol, String currencyThousandSeparator, String currencyDecimalSeparator) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencySymbol = currencySymbol;
        this.currencyThousandSeparator = currencyThousandSeparator;
        this.currencyDecimalSeparator = currencyDecimalSeparator;
    }


}
