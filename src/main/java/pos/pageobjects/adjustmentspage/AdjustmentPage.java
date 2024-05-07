package pos.pageobjects.adjustmentspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdjustmentPage {
	
	WebDriver driver;
	
    public AdjustmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    

}
