package testoviElemenata;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elementi.DaneOdSljiveDoBanane;
import elementi.Homepage;
import elementi.KillAdverts;
import elementi.Setap2Page;

public class TestoviElemenata {
	public static WebDriver driver;
	//public static final String USERNAME = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[1]/input";
	//public static final String PASSWORD = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[2]/input";
	public static final String BTN = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[3]/input";
	public static final String DEAR_CUSTOMER = "/html/body/div[2]/div/div/div[1]/button";
	public static final String  ADVERT1 = "/html/body/div/div/div/div[1]/div/div/span";
	public static final String ADVERT2 = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[2]/button";
	public static final String ABOUT_US_LINK = "https://www.humanity.com/about";
	public static String value = "DaneOdSljiveDoBanane";
	public static String num = "225883";
	public static String pass = "shilobadi";
	
	@BeforeClass
	public void createDriver() {
		//WebDriverWait wait = new WebDriverWait(driver,5);
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		driver = new ChromeDriver();
}
	@Test(priority = 1)
	public void testHomepageGo() {
		Homepage.goTo(driver,Homepage.URL_HOME);
		
		String actual = driver.getCurrentUrl();
		String expected ="https://www.humanity.com/";
		
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
	public void killAdverts() {
		//Homepage.goTo(driver,Homepage.URL_HOME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		KillAdverts.killAdverts(driver, DEAR_CUSTOMER);
		KillAdverts.killAdverts(driver, ADVERT2);	
		
		String actual= driver.getCurrentUrl();
		String expected = Homepage.URL_HOME;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 3)
	public void testScreenshot() {
		driver.manage().window().maximize();
		Homepage.aboutUs(driver, ABOUT_US_LINK);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Homepage.shooting(driver,"FullScreenshot.");
		boolean actual = true;
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 4)
	public void testLoginMain() {
		Homepage.goTo(driver,Homepage.URL_HOME );
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Homepage.loginFormInputField(driver,Homepage.USERNAME, Homepage.FILE,0,0 );
		Homepage.loginFormInputField(driver,Homepage.PASSWORD, Homepage.FILE,0,1 );
		Homepage.pressBTN(driver, BTN);
		
		String actual= driver.getCurrentUrl();
		String expected = Setap2Page.URL_PAGE2;
	}
	@Test (priority = 5)
	public void testLoginAlternative() {
		Homepage.goTo(driver,Homepage.URL_HOME );
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Homepage.pressBTN(driver,Homepage.BTN2);
		Homepage.loginFormInputField(driver,Homepage.USERNAME1, Homepage.FILE,1,0 );
		Homepage.loginFormInputField(driver,Homepage.PASSWORD1, Homepage.FILE,1,1 );
		Homepage.pressBTN(driver, Homepage.SUBMIT);
		
		String actual= driver.getCurrentUrl();
		String expected = Setap2Page.URL_PAGE2;
	}
		
	@Test (priority = 6)
	public void testPostojeciKorisnik() {
		driver.manage().window().maximize();
		Homepage.existingUser(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = "https://daneodsljivedobanane.humanity.com/app/dashboard/";
		Assert.assertEquals(actual, expected);
	}
	/*@Test(priority = 7)
	public void testRibbon() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver,DaneOdSljiveDoBanane.XSHIFT_PLANNING);
		
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.SHIFT_PLANNING;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 8)
	public void testRibbon1() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver,DaneOdSljiveDoBanane.XTIMECLOCK);
		
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.TIMECLOCK;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 9)
	public void testRibbon2() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver,DaneOdSljiveDoBanane.XLEAVE);
		
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.LEAVE;
		Assert.assertEquals(actual, expected);
	}
	*/
	@AfterClass
	public void closeDRV() {
		driver.close();
	}
}
