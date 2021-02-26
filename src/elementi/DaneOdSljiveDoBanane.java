package elementi;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import elementi.Homepage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class DaneOdSljiveDoBanane {
	public static final String URL_DANE_OD_SLJIVE= "https://daneodsljivedobanane.humanity.com/app/dashboard/";
	public static final String DASHBOARD = "https://daneodsljivedobanane.humanity.com/app/dashboard/";
	public static final String SHIFT_PLANNING ="https://daneodsljivedobanane.humanity.com/app/schedule/employee/week/overview/overview/24%2c1%2c2021/";
	public static final String TIMECLOCK = "https://daneodsljivedobanane.humanity.com/app/timeclock/";
	public static final String LEAVE ="https://daneodsljivedobanane.humanity.com/app/requests/vacation/";
	public static final String TRAINING ="https://daneodsljivedobanane.humanity.com/app/training/";
	public static final String STUFF ="https://daneodsljivedobanane.humanity.com/app/staff/list/load/true/";
	public static final String AVAILABILITY ="https://daneodsljivedobanane.humanity.com/fe/availability/#/requests/week/2021-02-21/1";
	public static final String PAYROLL ="https://daneodsljivedobanane.humanity.com/app/payroll/scheduled-hours/";
	public static final String REPORTS = "https://daneodsljivedobanane.humanity.com/app/reports/dashboard/";
	public static final String STUFF_DODAJ_E ="https://daneodsljivedobanane.humanity.com/app/staff/list/position/true/";
	public static final String IS_THERE_USER ="https://daneodsljivedobanane.humanity.com/app/staff/list/";
	public static final String EDIT_DATA_BTN ="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[1]/a[2]";
	public static final String NAME_DTA_FIELD = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td[2]/input";
	public static final String SAVE_EMPLOEE_BTN ="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[39]/td/input";
											  //"/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[1]/a[2]"}
	public static final String XSHIFT_PLANNING="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[2]/a/span";
	public static final String XTIMECLOCK = "/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[3]/a/span";
	public static final String XLEAVE ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[4]/a/span";
	public static final String XTRAINING ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[5]/a/span";
	public static final String XSTUFF ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[6]/a/span";
	public static final String XAVAILABILITY ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[7]/a/span";
	public static final String XPAYROLL ="/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[8]/a/span";
	public static final String XREPORTS = "/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[9]/a/span";
	public static final String XDASHBOARD = "/html/body/table/tbody/tr/td/div[7]/div/div[2]/ul/li[1]/a/span";
	public static final String AD_EMPLOEE_BTN = "/html/body/table/tbody/tr/td/div[5]/button[3]";
	public static final String EMPLOEE_NAME = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[2]/input";
	public static final String EMPLOEE_LASTNAME = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[3]/input";
	public static final String EMPLOEE_EMAIL = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[2]/td[4]/input";
	public static final String EMPLOEE_SUBMIT = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[9]/td[2]/button";
	public static final String EMPLOEE_TABLE = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/div/div[2]";
	public static final String UPLOAD_IMG_BTN = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/span[1]/input";
	public static final String PICTURE_PATH = "C:\\Users\\Bojana\\eclipse-workspace\\ZAvrsniProjekat\\babaJula.jfif";
	public static final String SAVE_CHANGES_BTN = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[39]/td/input";
	public static final String SAVE_APACHE_BTN = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/table/tbody/tr[9]/td[2]";
	public static final String GEAR_SIGN_BTN_URL = "https://daneodsljivedobanane.humanity.com/app/admin/settings/";
	public static final String AMERICAN_ENGLISH_LIST = "/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String LANGUAGE_CHOOSE = "/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[1]/table/tbody/tr[3]/td[2]/select/option[8]";
	public static final String CHECK_BOX1 = "/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[2]/table/tbody/tr[1]/td[2]/input";
	public static final String CHECK_BOX2 = "/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[2]/table/tbody/tr[2]/td[2]/input";
	public static final String CHECK_BOX3 = "/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[2]/table/tbody/tr[3]/td[2]/input";
	public static final String PROFILE_SETING = "https://daneodsljivedobanane.humanity.com/app/staff/edit/6081270/";
	public static final String EDIT_DETAILS ="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[1]/a[2]";
	public static final String CHANGE_NICKNAME = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[2]/input";
	public static final String PICTURE_ANONIMOUS  ="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[1]/div[1]/img";
	//public static final String UPLOAD_IMG_BTN1 = "/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/span[1]/input";
	public static final String BABA_JULA_PCT = "https://daneodsljivedobanane.humanity.com/app/staff/detail/6085367/";
	public static final String BARBI_SINDY_PCT = "https://daneodsljivedobanane.humanity.com/app/staff/detail/6085367/";
	public static final String REFRESH ="/html/body/table/tbody/tr/td/div[9]/div[8]/div[3]/div/form/div[1]/table/tbody/tr[3]/td[1]/label/a";
	public static final String SAVE_APACHE_BTN1 ="/html/body/table/tbody/tr/td/div[9]/div[5]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/form/table/tbody/tr[42]/td/input";
											       
	
	public static void checkElementRibbon(WebDriver driver, String path) {
		driver.findElement(By.xpath(path)).click();
		
	}
	public static void findElementBy(WebDriver driver, String path) {
		WebElement we = driver.findElement(By.xpath(path));
		we.click();
	}
	public static void dodajKorisnika(WebDriver driver, String name,String lastname,String email) {
		driver.navigate().to(STUFF_DODAJ_E);
		findElementBy(driver,AD_EMPLOEE_BTN);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.xpath(EMPLOEE_NAME));
		we.click();
		we.sendKeys(name);
		WebElement we1 = driver.findElement(By.xpath(EMPLOEE_LASTNAME));
		we1.click();
		we1.sendKeys(lastname);
		WebElement we2 = driver.findElement(By.xpath(EMPLOEE_EMAIL));
		we2.click();
		we2.sendKeys(email);
		findElementBy(driver,EMPLOEE_SUBMIT);
		
	}
	public static void proveraKorisnika(WebDriver driver) {
		driver.navigate().to(IS_THERE_USER);
		List<WebElement> users = driver.findElements(By.id("7"));
		for (WebElement user:users) {
			saveUserList("listaKorisnika.xlsx",user.toString());;
			System.out.println(user);
		}
		}
	public static void saveUserList(String file,String user) {
			try {
				FileInputStream inp = new FileInputStream(file);
				XSSFWorkbook wb = new XSSFWorkbook(inp);
				XSSFSheet sheet = wb.getSheet("Sheet1");
				int broj =sheet.getLastRowNum();
				Row row = sheet.createRow(broj + 1);
				Cell cell = row.createCell(0);
				Cell cell1= row.createCell(1);
				cell.setCellValue(user);
				FileOutputStream oup = new FileOutputStream(file);
				wb.write(oup);
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void dohvatiZaposlenog(WebDriver driver,String text) {
		Homepage.goTo(driver, IS_THERE_USER);
		driver.findElement(By.linkText(text)).click();
	}
	public static void editDetails(WebDriver driver, String changedName) {
		driver.findElement(By.xpath(EDIT_DATA_BTN)).click();
		WebElement we = driver.findElement(By.xpath(NAME_DTA_FIELD));
		we.clear();
		we.sendKeys(changedName);
		driver.findElement(By.xpath(SAVE_EMPLOEE_BTN )).click();
	}
	public static void setPicture(WebDriver driver) {
		dohvatiZaposlenog(driver,"Baba Jula");
		driver.findElement(By.xpath(EDIT_DATA_BTN)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(UPLOAD_IMG_BTN)).sendKeys("C:\\Users\\Bojana\\eclipse-workspace\\ZAvrsniProjekat\\babaJula.jfif");
		driver.findElement(By.xpath(SAVE_CHANGES_BTN)).click();
	}
	public static boolean newUserFromApache(WebDriver driver, String file) {
		boolean postavio =true;
		driver.navigate().to(STUFF_DODAJ_E);
		findElementBy(driver,AD_EMPLOEE_BTN);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		for(int i = 1; i<7 ;i++) {
			WebElement wn = driver.findElement(By.id("_asf"+i));
			wn.sendKeys(Homepage.citajPodatak(file, i , 0));
			WebElement wl = driver.findElement(By.id("_asl"+i));
			wl.sendKeys(Homepage.citajPodatak(file, i , 1));
			WebElement we = driver.findElement(By.id("_ase" +i));
			we.sendKeys(Homepage.citajPodatak(file, i , 2));
		}
		Homepage.pressBTN(driver,SAVE_APACHE_BTN);
		return postavio;
	}
	public static boolean changeLan(WebDriver driver) {
		driver.navigate().to(GEAR_SIGN_BTN_URL);
		//Dimension dimension = new Dimension(600, 400);
		//driver.manage().window().setSize(dimension);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CHECK_BOX3)).click();
		driver.findElement(By.xpath(CHECK_BOX2)).click();
		driver.findElement(By.xpath(CHECK_BOX1)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(AMERICAN_ENGLISH_LIST)).click();
		driver.findElement(By.xpath(LANGUAGE_CHOOSE)).click();
		
		driver.findElement(By.id("_save_settings_button")).click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(50,0)");
		//driver.findElement(By.xpath(REFRESH)).click();
		boolean promenio = true;
		return promenio;
		}
	
	public static boolean profileAjust(WebDriver driver) {
		driver.navigate().to(PROFILE_SETING);//dodaj driv.ele koji korisnik_?
		driver.findElement(By.xpath(EDIT_DETAILS)).click();
		driver.findElement(By.xpath(UPLOAD_IMG_BTN)).sendKeys("C:\\Users\\Bojana\\eclipse-workspace\\ZAvrsniProjekat\\naslovna.jfif");
		WebElement we = driver.findElement(By.xpath(CHANGE_NICKNAME));
	//	we.click();
		we.clear();
		we.sendKeys("bosnoMojaMilaLepaGizdava");
		driver.findElement(By.xpath(SAVE_APACHE_BTN1)).click();
		//driver.findElement(By.xpath(REFRESH)).click();
		boolean prosao = true;
		return prosao;
	}
	
	public static String vracaImeKorisnika(WebDriver driver, String name) {
		driver.navigate().to(STUFF);
		String we = driver.findElement(By.linkText(name)).getAttribute("Baba Mira"); //??? TriM
		return we;
	}
	public static boolean postojiIliNe(WebDriver driver,String name, String url) {
		driver.navigate().to(url);
		WebElement we = driver.findElement(By.linkText(name));
		boolean postoji = true;
		if(we != null) {
			postoji = true;
		}else {
			postoji = false;
		}
		return postoji;	
	}
	public static boolean porediSlike(WebDriver driver) {
		driver.navigate().to(BABA_JULA_PCT);
		WebElement slika = driver.findElement(By.tagName("img"));
		slika.getText().toString();
		driver.navigate().to(BARBI_SINDY_PCT);
		WebElement pct  = driver.findElement(By.tagName("img"));
		pct.getText().toString();
		boolean postoji = true;
		if(slika != pct) {
			postoji = true;
		}else {
			postoji = false;
		}
		return postoji;	
	} 
	public static boolean apachePoi(WebDriver driver, String file) {
		driver.navigate().to(STUFF);
		boolean isto = true;
		for(int i = 1;i<6; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String ime = Homepage.citajPodatak(file, i, 2).toString(); 
			String name = driver.findElement(By.linkText(ime)).toString();
			if(ime == name) {
				isto = true;
			}else {
				isto = false;
			}
		}
		return isto;
	
	}
	public static boolean languageChanged(WebDriver driver) throws InterruptedException, IOException {
		driver.navigate().to(GEAR_SIGN_BTN_URL);
		boolean izmenjen = false;
		try {
		WebElement we = driver.findElement(By.linkText("Availability"));
		}catch (NoSuchElementException e){
			e.equals(null);
			izmenjen = true;
		}
		//if(we.equals()) {
		//	izmenjen = true;
		return izmenjen;
	}
	public static boolean ifCheckedBTNS(WebDriver driver, String patx) {
		driver.navigate().to(GEAR_SIGN_BTN_URL);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean we = true;
		if(driver.findElement(By.xpath(patx)).isSelected()) {
			we = false;
		}else {
			we = true;
		}
		 return we;
		//driver.findElement(By.xpath(CHECK_BOX2)).click();
		//driver.findElement(By.xpath(CHECK_BOX1)).click();
	}
}
