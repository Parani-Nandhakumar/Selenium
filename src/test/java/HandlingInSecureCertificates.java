import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingInSecureCertificates {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        // Below is a simple way to accept insecure certificates in chrome browser
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setAcceptInsecureCerts(true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        WebDriver driver = new ChromeDriver(chromeOptions);
    }
}
