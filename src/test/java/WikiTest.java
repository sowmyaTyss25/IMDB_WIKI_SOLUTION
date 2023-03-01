import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.WikiPage;

public class WikiTest extends BaseClass {
	
	@Test
	public void wikiTest() {

		String movieName = excelUtility.getDataFromExcel(1, 1, "Sheet1");
		String browser = fileUtility.getDataFromProperty("browser");
		String wiki = fileUtility.getDataFromProperty("wikiUrl");
		WebDriver driver = webdriverUtility.setupDriver(browser);
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(10);
		webdriverUtility.openApplication(wiki);
		WikiPage w=new WikiPage(driver);
		w.enterMovieName(movieName);
		w.clickOnSearchBtn();
		WebElement poster = driver.findElement(By.xpath("//div[.='Theatrical release poster']"));
		jsUtility.initiallizeJSExecutor(driver);
		jsUtility.scrollTillElement(poster);
		System.out.println("Realese date of the movie: "+w.getReleaseDate());
		System.out.println("Country name: "+w.getCountryName());
		webdriverUtility.takeScreenShotPage(webdriverUtility, javaUtility);
		driver.quit();
		
	
	}
}