package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver get() {
        return driver;
    }
    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static void init() {
        WebDriver driverInput;
        switch (Config.getProperty("test.browser")) {
            case "firefox":
                driverInput = new FirefoxDriver();
                break;
            case "iexplore":
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe");
                driverInput = new InternetExplorerDriver();
                break;
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
                //System.setProperty("webdriver.chrome.driver", "../chromedriver");
//                System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
                driverInput = new ChromeDriver();
                break;
            case "safari":
                DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
                safariCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                safariCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driverInput = new SafariDriver(safariCapabilities);
                break;
            case "htmlunit":
                driverInput = new HtmlUnitDriver();
                break;
            //Selenium version ">= 2.33.0"
            //case "ghost":
            //    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            //    System.out.print(System.getProperty("user.dir"));
            //    String path = System.getProperty("user.dir") + "\\driver\\phantomjs\\phantomjs.exe";
            //    desiredCapabilities.setCapability("phantomjs.binary.path", path);
            //    driverInput = new PhantomJSDriver(desiredCapabilities);
            //    break;
            default:
                throw new AssertionError("Unsupported browser: " + Config.getProperty("test.browser"));
        }
        driverInput.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("test.timeout")), TimeUnit.SECONDS);
        //***driverInput.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Driver.set(driverInput);
        //get().manage().window().maximize();
        get().manage().window().setSize(new Dimension(800, 360));
    }

    public static void tearDown() {
        Driver.get().quit();
    }
}