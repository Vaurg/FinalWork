import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver {
	
	static WebDriver driver;

	// Activating Chrome driver
	public static void chromedriver() {
		driver = new ChromeDriver();
	}

	// Activating Firefox driver
	public static void firefoxDriver() {
		driver = new FirefoxDriver();
	}

}
