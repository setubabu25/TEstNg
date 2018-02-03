import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSLOCATOR {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Md Rashid\\Desktop\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://www.mortgagecalculator.org");
        driver.findElement(By.cssSelector("input[class='right-cell']")).clear();
        driver.findElement(By.cssSelector("input[class='right-cell']")).sendKeys("5534566");



    }

}