package elementi;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.Dimension;
import java.awt.Rectangle;

import org.apache.commons.io.FileUtils;

public class Homepage {
	
	public static final String URL_HOME="https://www.humanity.com/";
	public static final String USERNAME = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[1]/input";
	public static final String PASSWORD = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[2]/input";
	public static final String BTN = "/html/body/div[1]/header/div[2]/div/div/div/div/form/div/div[3]/input";
	public static final String FILE = "data.xlsx";
	public static final String MENUE_RIGHT = "/html/body/div[6]";
	public static final String BTN2 = "/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/div/a[3]";//dugme koje je druga opcija za kreiranje profila
	public static final String USERNAME1 = "/html/body/div[5]/div/div/div/div/div/div[2]/form/div[1]/input";
	public static final String PASSWORD1 = "/html/body/div[5]/div/div/div/div/div/div[2]/form/div[2]/input";
	public static final String SUBMIT = "/html/body/div[5]/div/div/div/div/div/div[2]/form/input";// dugme za submit nakon druge opcije
	public static final String ABOUTUS = "/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/ul/li[6]/a";
	public static final String LOGIN = "/html/body/div[1]/header/div[1]/div/div/div/nav/div[2]/div/a[2]/p";
	public static final String EXISTING_MAIL_INPUT = "/html/body/div[1]/div[2]/div/form[1]/div[1]/div[2]/div/input";
	public static final String EXISTING_PASSWORD = "/html/body/div[1]/div[2]/div/form[1]/div[1]/div[3]/div/input";
	public static final String EXISTING_LOGIN_BTN = "/html/body/div[1]/div[2]/div/form[1]/div[3]/div/button[1]";
	
	
	public static void goTo(WebDriver driver, String page) {
		driver.navigate().to(page);
	}
	/*public static void loginFormUserName(WebDriver driver, String path) {//pri pozivu f-je dodajemo putanju na koju zelimo da idemo
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.xpath(path));
		we.sendKeys(citajPodatak(FILE,1,0));
	}*/
	public static void loginFormInputField(WebDriver driver, String path, String file, int row, int cell) {//pri pozivu f-je dodajemo putanju na koju zelimo da idemo
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement we = driver.findElement(By.xpath(path));
		we.click();
		we.sendKeys(citajPodatak(file,row,cell));
	}
	public static void pressBTN(WebDriver driver, String path) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath(path)).click();
		
	}
	public static String citajPodatak(String f, int r, int c) {
		
		File d = new File(f);
		InputStream inp=null;
		try {
			inp = new FileInputStream(d);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(inp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet1 = wb.getSheetAt(0);
		Row row = sheet1.getRow(r);
		Cell cell = row.getCell(c);
		String kredencijal = cell.getStringCellValue();
		
		return kredencijal.toString();
	}
	public static void menueRight(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(MENUE_RIGHT));
		we.click();
	}
	public static void aboutUs(WebDriver driver, String url) {
		WebElement we = driver.findElement(By.xpath(ABOUTUS));
		we.click();
		driver.navigate().to(url);
	}
	public static void shooting(WebDriver driver,String name) {
		        try {
		            Robot robot = new Robot();
		            String format = "jpg";
		            String fileName = name + format;
		             
		            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		            ImageIO.write(screenFullImage, format, new File(fileName));
		        } catch (AWTException | IOException ex) {
		            System.err.println(ex);
		        }
		    }
	public static void drugiLogin(WebDriver driver,String path, String file,int row, int cell) {
		Homepage.goTo(driver, URL_HOME);
		pressBTN(driver,BTN2);
		loginFormInputField(driver, path,file,row,cell);//USERNAME1
		loginFormInputField(driver, path,file,row, cell);//PASSWORD1
		pressBTN(driver, SUBMIT);
	}
	public static void existingUser(WebDriver driver) {
		goTo(driver,URL_HOME);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(LOGIN)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginFormInputField(driver,EXISTING_MAIL_INPUT, FILE, 0,1);
		loginFormInputField(driver,EXISTING_PASSWORD, FILE, 0,2);
		pressBTN(driver,EXISTING_LOGIN_BTN);
	}
	}

