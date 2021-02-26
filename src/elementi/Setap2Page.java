package elementi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Setap2Page {
	public static final String URL_PAGE2="https://www.humanity.com/wizard-setup2/";
	public static final String COMPANY_NAME = "/html/body/div/div/div/form/div[1]/div/div[1]/div/div/input";
	public static final String FIELD_OF_WORK = "div.input-container";
	public static final String OPTION1 = "Restaurant / Food Service";
	public static final String OPTION2 = "Other";
	public static final String PHONE = "/html/body/div/div/div/form/div[1]/div/div[4]/div/input";
	public static final String PASS1 = "/html/body/div/div/div/form/div[1]/div/div[5]/div/input";
	public static final String PASS2 = "/html/body/div/div/div/form/div[1]/div/div[6]/div/input";
	public static final String BTN_SCHEDULING = "/html/body/div/div/div/form/div[2]/span/input";
	
	public static void page2(WebDriver driver) {
		driver.navigate().to(URL_PAGE2);
	}
	public static void companyName(WebDriver driver, String value) {
		WebElement we = driver.findElement(By.xpath(COMPANY_NAME)); //PRVO POLJE NA STRANI DVA- IME KOMPANIJE, unosimo ga u testu kao string!
		we.sendKeys(value);
	}
	public static void selectBox1(WebDriver driver, int opt) {
		WebElement we = driver.findElement(By.cssSelector(FIELD_OF_WORK));// SELEKT BOX - DA BIH ODABRALA OPCIJE PRVO PRONALAZIM ELEMENT
		we.click();
	}
	public static void otions1(WebDriver driver) {
		WebElement we = driver.findElement(By.linkText(OPTION1)); //PRVI SELECT BOX- KONKRETNE OPCIJE, OVU F-JU POZIVAM UVEK NAKON companyName
		we.click();
	}
	public static void otions2(WebDriver driver) { ////DRUGI SELECT BOX- KONKRETNE OPCIJE, OVU F-JU POZIVAM UVEK NAKON companyName
		WebElement we = driver.findElement(By.linkText(OPTION2));
		we.click();
	}
	public static void phone(WebDriver driver, String num) {
		WebElement we = driver.findElement(By.xpath(PHONE)); //PRVO POLJE NA STRANI DVA- IME KOMPANIJE, unosimo ga u testu kao string!
		we.sendKeys(num);
	}
	public static void password(WebDriver driver, String pass) { //unos pasworda
		WebElement we = driver.findElement(By.xpath(PASS1));
		we.click();
		we.sendKeys(pass);
	}
	public static void passwordRep(WebDriver driver, String pass) { //potvrda passworda
		WebElement we = driver.findElement(By.xpath(PASS2));
		we.click();
		we.sendKeys(pass);
	}
	public static void passwordRep(WebDriver driver) { //potvrda passworda
		WebElement we = driver.findElement(By.xpath(BTN_SCHEDULING));
		we.click();
	}
}
