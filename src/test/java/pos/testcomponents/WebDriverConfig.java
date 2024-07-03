package pos.testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class WebDriverConfig {
    private WebDriver driver;

    public WebDriver initializeDriver(String browserName, boolean useGrid) throws IOException {
        if (useGrid) {
            // Cấu hình WebDriver để sử dụng Selenium Grid
            // Sử dụng RemoteWebDriver để kết nối tới Selenium Grid Hub
            // Bạn có thể cung cấp các capabilities cho trình duyệt tại đây
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (browserName.equalsIgnoreCase("chrome")) {
                capabilities.setBrowserName("chrome");
                ChromeOptions options = new ChromeOptions();
                options.merge(capabilities);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                capabilities.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else if (browserName.equalsIgnoreCase("edge")) {
                capabilities.setBrowserName("MicrosoftEdge");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            }
        } else {
            // Cấu hình WebDriver để chạy địa phương
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
                driver = new EdgeDriver();
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
