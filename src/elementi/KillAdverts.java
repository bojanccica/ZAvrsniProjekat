package elementi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KillAdverts {
	public static final String DEAR_CUSTOMER = "/html/body/div[2]/div/div/div[1]/button";
	public static final String  ADVERT1 = "/html/body/div/div/div/div[1]/div/div/span";
	public static final String ADVERT2 = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[2]/button";

	public static void killAdverts(WebDriver driver,String popup) {
		driver.findElement(By.xpath(popup)).click();
	}
}
