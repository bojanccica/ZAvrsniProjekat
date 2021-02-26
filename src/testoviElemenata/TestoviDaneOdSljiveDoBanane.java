package testoviElemenata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elementi.DaneOdSljiveDoBanane;
import elementi.Homepage;
import elementi.KillAdverts;

public class TestoviDaneOdSljiveDoBanane {
	public static WebDriver driver;
	public static final String DEAR_CUSTOMER = "/html/body/div[2]/div/div/div[1]/button";
	public static final String  ADVERT1 = "/html/body/div/div/div/div[1]/div/div/span";
	public static final String ADVERT2 = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[2]/button";
	public static final String STUFF_DODAJ_E ="https://daneodsljivedobanane.humanity.com/app/staff/list/position/true/";
	public static final String STUF_LIST_URL ="https://daneodsljivedobanane.humanity.com/app/staff/list/";

	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority = 1)
	public void killAdverts() {
		Homepage.goTo(driver,Homepage.URL_HOME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		KillAdverts.killAdverts(driver, DEAR_CUSTOMER);
		KillAdverts.killAdverts(driver, ADVERT2);	
		
		String actual= driver.getCurrentUrl();
		String expected = Homepage.URL_HOME;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 2)
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
	
	@Test(priority = 3)
	public void testSP() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XSHIFT_PLANNING);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.SHIFT_PLANNING;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void testTC() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XTIMECLOCK);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.TIMECLOCK;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void testLeave() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XLEAVE);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.LEAVE;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 6)
	public void testTraining() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XTRAINING);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.TRAINING;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 7)
	public void testStuff() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XSTUFF);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.STUFF;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 8)
	public void testPayroll() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XPAYROLL);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.PAYROLL;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 9)
	public void testReports() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XREPORTS);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.REPORTS;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 10)
	public void testDash() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XDASHBOARD);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.DASHBOARD;
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 11)
	public void testAVB() {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.checkElementRibbon(driver, DaneOdSljiveDoBanane.XAVAILABILITY);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = driver.getCurrentUrl();
		String expected = DaneOdSljiveDoBanane.AVAILABILITY;
		Assert.assertEquals(actual, expected);
		driver.navigate().to(STUFF_DODAJ_E);
	}
	@AfterClass
	public void closeDRV() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
}
}
