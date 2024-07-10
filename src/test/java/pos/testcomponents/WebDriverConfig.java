package pos.testcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class WebDriverConfig {
    WebDriver driver;

    public WebDriverConfig() {
    }

    public WebDriver initializeDriver(String browserName, boolean useGrid) throws IOException {
        if (useGrid) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browserName.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:8888/wd/hub"), capabilities);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:8888/wd/hub"), capabilities);
            } else if (browserName.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("MicrosoftEdge");
                driver = new RemoteWebDriver(new URL("http://localhost:8888 /wd/hub"), capabilities);
            }
        } else {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
