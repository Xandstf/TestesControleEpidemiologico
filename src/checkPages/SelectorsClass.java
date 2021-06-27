package checkPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorsClass {

	public static void main(String[] args) throws InterruptedException {
		String userPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userPath + "/lib/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		homeTests home = new homeTests();
		home.runTests(driver);
		
		pragaTests praga = new pragaTests();
		praga.runTests(driver);
		
		localTests local = new localTests();
		local.runTests(driver);
		
	}
}
