import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class MouseInteractions {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
        //Using Actions Class object to do mouse interactions
        Actions actions = new Actions(driver);
        driver.findElement(By.cssSelector("a.link.udlite-text-sm.ud-ufb-notice-click-event")).click();
        //Switching between multiple windows
        Set<String> windowSets = driver.getWindowHandles();
        Iterator<String> iterator= windowSets.iterator();
        String firstWindow = iterator.next();
        String secondWindow = iterator.next();
        driver.switchTo().window(secondWindow);
        driver.findElement(By.xpath("//a[contains(text(),'Get started')]")).click();
        driver.switchTo().window(firstWindow);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Categories']"))).build().perform();
        actions.moveToElement(driver.findElement(By.cssSelector("a#header-browse-nav-category-288"))).build().perform();
        actions.moveToElement(driver.findElement(By.cssSelector("a#header-browse-nav-subcategory-18"))).click().build().perform();
    }
}