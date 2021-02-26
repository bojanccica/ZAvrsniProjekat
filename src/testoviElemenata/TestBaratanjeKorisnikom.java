package testoviElemenata;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elementi.DaneOdSljiveDoBanane;
import elementi.Homepage;
import elementi.KillAdverts;

public class TestBaratanjeKorisnikom {
	public static WebDriver driver;
	public static final String DEAR_CUSTOMER = "/html/body/div[2]/div/div/div[1]/button";
	public static final String ADVERT1 = "/html/body/div/div/div/div[1]/div/div/span";
	public static final String ADVERT2 = "/html/body/div[9]/div/div/div/div[2]/div[2]/div[2]/button";
	public static final String STUFF_DODAJ_E = "https://daneodsljivedobanane.humanity.com/app/staff/list/position/true/";
	public static final String STUF_LIST_URL = "https://daneodsljivedobanane.humanity.com/app/staff/list/";
	public static final String CHECK_BOX_FIELD = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[35]/td/div/div[2]/ul/li[3]/label/input";
	public static final String CHECK_BOX_BTN = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[39]/td/input";
	public static final String PICTURE_PATH = "C:\\Users\\Bojana\\eclipse-workspace\\ZAvrsniProjekat\\babaJula.jfif";
	public static final String STUFF = "https://daneodsljivedobanane.humanity.com/app/staff/list/load/true/";
	public static final String BOSNO_MOJA = "https://daneodsljivedobanane.humanity.com/app/staff/edit/6081270/";
												
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\driverHrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void killAdverts() {
		Homepage.goTo(driver, Homepage.URL_HOME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		KillAdverts.killAdverts(driver, DEAR_CUSTOMER);
		KillAdverts.killAdverts(driver, ADVERT2);

		String actual = driver.getCurrentUrl();
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
	public void testDodajKorisnika() {
		driver.navigate().to(STUFF_DODAJ_E);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.dodajKorisnika(driver, "Baba", "Mira", "miki@miki.com");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to(STUF_LIST_URL);
		// DaneOdSljiveDoBanane.proveraKorisnika(driver);

		String actual = DaneOdSljiveDoBanane.vracaImeKorisnika(driver, "Baba Mira");
		String expected = "Baba Mira";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void testExplicitUser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(STUFF_DODAJ_E);
		DaneOdSljiveDoBanane.dohvatiZaposlenog(driver, "Zoran Dilan");

		String actual = driver.getCurrentUrl();
		String expected = "https://daneodsljivedobanane.humanity.com/app/staff/detail/6085191/";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 5)
	public void testChangeName() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(STUF_LIST_URL);
		DaneOdSljiveDoBanane.dohvatiZaposlenog(driver, "Zoran Dilan");
		DaneOdSljiveDoBanane.editDetails(driver, "Goran");
		//driver.findElement(By.xpath(CHECK_BOX_FIELD));
		//driver.findElement(By.xpath(CHECK_BOX_BTN));

		boolean actual = DaneOdSljiveDoBanane.postojiIliNe(driver, "Zoran Dilan", STUFF);
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 6)
	public void testSetPicture() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DaneOdSljiveDoBanane.setPicture(driver);

		boolean actual = DaneOdSljiveDoBanane.porediSlike(driver);
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
 
  	@Test(priority = 7)
	public void testAddEmployee() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean dodao = DaneOdSljiveDoBanane.newUserFromApache(driver, "data.xlsx");

		boolean actual = dodao; //DaneOdSljiveDoBanane.apachePoi(driver, "data.xlsx");
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 9)
	public void testChangeLang() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean actual= DaneOdSljiveDoBanane.changeLan(driver);

		
	/*	try {
			actual = DaneOdSljiveDoBanane.languageChanged(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			actual = true;
		} */
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 8)
	public void testProfileAjust() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean prosao = DaneOdSljiveDoBanane.profileAjust(driver);
	
		boolean actual = prosao; //DaneOdSljiveDoBanane.postojiIliNe(driver, "bosnoMojaMilaLepaGizdava", BOSNO_MOJA);
		boolean expected = true;
		boolean poredi = DaneOdSljiveDoBanane.porediSlike(driver);
		boolean actual1 = poredi;
		boolean expected1 = true;

		Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual1, expected1);
	}

	@Test(priority = 10)
	public void testCheckButtons() {
		// DaneOdSljiveDoBanane.ifCheckedBTNS(driver,DaneOdSljiveDoBanane.CHECK_BOX1);
		boolean actual = DaneOdSljiveDoBanane.ifCheckedBTNS(driver, DaneOdSljiveDoBanane.CHECK_BOX2);
		// DaneOdSljiveDoBanane.ifCheckedBTNS(driver,DaneOdSljiveDoBanane.CHECK_BOX3);
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@AfterClass
	public void closeDRV() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
}
