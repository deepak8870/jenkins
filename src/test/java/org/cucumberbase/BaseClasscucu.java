package org.cucumberbase;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasscucu {
	
	
	public static String getdata(String filenamepath,String sheetname,int rowno,int cellno) throws IOException {
		
		String data = null;
		
		File file = new File(filenamepath);
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook= new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(sheetname);
		
		Row row = sheet.getRow(rowno);
		
		Cell cell = row.getCell(cellno);
		
		CellType type = cell.getCellType();
		
		switch (type) {
		case STRING:
		data = cell.getStringCellValue();
			
			break;
		case NUMERIC:
			
			if (DateUtil.isCellDateFormatted(cell)) {
				
				Date date = cell.getDateCellValue();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				
				 data = dateFormat.format(date);
			} 
			
			else {
				
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				 data = b.toString();
				
				}
			
			break;
			
			default:
			break;
			}
		
		return data;
	}
	
	public static void updatedata(String filenamepath,String sheetname,int rowno,int cellno,String olddata,String newdata) throws IOException {
		
File file = new File(filenamepath);
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook= new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet(sheetname);
		
		Row row = sheet.getRow(rowno);
		
		Cell cell = row.getCell(cellno);
		
		String value = cell.getStringCellValue();
		
		if (value.equals(olddata)) {
			
			cell.setCellValue(newdata);
		}
		
		FileOutputStream o = new FileOutputStream(file);
		workbook.write(o);

	}
	
	
	public static void Writedata(String filenamepath,String sheetname,int rowno,int cellno,String data) throws IOException {
		
		File file = new File(filenamepath);
				
				FileInputStream stream = new FileInputStream(file);
				
				Workbook workbook= new XSSFWorkbook(stream);
				
				Sheet sheet = workbook.getSheet(sheetname);
				
				Row row = sheet.getRow(rowno);
				
				Cell cell = row.createCell(cellno);
				
				cell.setCellValue(data);
				
				FileOutputStream o = new FileOutputStream(file);
				workbook.write(o);

			}
	
	public static void createworkbook(String filenamepath,String sheetname,int rowno,int cellno,String data) throws IOException {
		
		File file = new File(filenamepath);
				
 Workbook workbook= new XSSFWorkbook();
				
				Sheet sheet = workbook.createSheet(sheetname);
				
				Row row = sheet.getRow(rowno);
				
				Cell cell = row.createCell(cellno);
				
				cell.setCellValue(data);
				
				
				FileOutputStream o = new FileOutputStream(file);
				workbook.write(o);

			}
					
	  public static  WebDriver driver;
	
	public static void getdriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
	
   public  static void geturl(String url) {
	
	driver.get(url);
	
	driver.manage().window().maximize();
		
	}
  public static void sendkey(WebElement element,String data) {
	
	element.sendKeys(data);
	
   }

     public static void click(WebElement element) {
	
	element.click();
   }

    public static WebElement findelementid(String data) {
	
    	   WebElement element = driver.findElement(By.id(data));
    	return element;
    }
    
    public static WebElement findelementclassname(String data) {
    	
 	   WebElement element = driver.findElement(By.className(data));
 	return element;
 }
    
    public static WebElement findelementname(String data) {
    	
 	   WebElement element = driver.findElement(By.name(data));
 	return element;
 }
    
    public static WebElement findelementxpath(String data) {
    	
 	   WebElement element = driver.findElement(By.xpath(data));
 	return element;
 }
    
    public  static String getcurrenturl() {
		
    	String geturl = driver.getCurrentUrl();
return geturl;
	}
    
    public String gettext(WebElement element) {
		
    	String text = element.getText();
    	return text;
	}
    
public static String getattribute(WebElement element) {
		
    	String text = element.getAttribute("value");
    	return text;
	}

public static String getattribute(WebElement element,String data) {
	
	String text = element.getAttribute(data);
	return text;
}

    public static void quit() {
		
    	driver.quit();
    	
	}
    
    public static void close() {
		
    	driver.close();

	}
    
    public static void selectbytext(WebElement element,String text) {
		
    	Select se = new Select(element);
    	se.selectByVisibleText(text);

	}
    
    
 public static void selectbyvalue(WebElement element,String text) {
		
    	Select se = new Select(element);
    	se.selectByValue(text);

	}
    
 public static void selectbyindex(WebElement element,int index) {
		
 	Select se = new Select(element);
 	se.selectByIndex(index);

	}
    
 public static void jstext(WebElement element , String text) {
	
 JavascriptExecutor executor =(JavascriptExecutor)driver;
    
    executor.executeScript("arguments[0].setAttribute('value',"+text+")", element);
    
 } 
    
 public static void jsclick(WebElement element ) {
		
 JavascriptExecutor executor =(JavascriptExecutor)driver;
    
    executor.executeScript("arguments[0].click", element);
    
 } 
 
 public static void jsscrollup(WebElement element ) {
		
	 JavascriptExecutor executor =(JavascriptExecutor)driver;
	    
	    executor.executeScript("arguments[0].scrollIntoView(false)", element);
	    
	 } 
 
 public static void jsscrolldoWn(WebElement element ) {
		
	 JavascriptExecutor executor =(JavascriptExecutor)driver;
	    
	    executor.executeScript("arguments[0].scrollIntoView(true)", element);
	    
	 } 
 
  public static void takescreen( WebElement element,String pathname) throws IOException {

	 TakesScreenshot ts = (TakesScreenshot)driver;
	 
	 File as = element.getScreenshotAs(OutputType.FILE);
	 
	 File de=new File(pathname);
	 
	 FileUtils.copyFile(as, de);
	 }
 
 public static void takescreenas( String pathname) throws IOException {

	 TakesScreenshot ts = (TakesScreenshot)driver;
	 
	 File as = ts.getScreenshotAs(OutputType.FILE);
	 
	 File de=new File(pathname);
	 
	 FileUtils.copyFile(as, de);
	 }
  public static void rightclick(WebElement element) {
	
	 Actions actions = new Actions(driver);
	 actions.contextClick(element).perform();
	 
}   
 
 public static void movetoelement(WebElement element) {
		
	 Actions actions = new Actions(driver);
	 actions.moveToElement(element).perform();
	 
}   
    
 public static void draganddrop(WebElement source,WebElement target) {
		
	 Actions actions = new Actions(driver);
	 actions.dragAndDrop(source, target);
	 
}      
 
 public static void doubleclick(WebElement element) {
		
	 Actions actions = new Actions(driver);
	 actions.doubleClick(element).perform();
	 
}   
 
 public static void thread(int millis) throws InterruptedException {
	
	 Thread.sleep(millis);
	 }
 
 public static void implicitly(int sec) {
	
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
}
 
 public  static void webdriverwait(int sec) {
	
	 WebDriverWait w = new WebDriverWait(driver, sec);
	
	 
}
 public static void fluentwaitclick(int sec,int sec1,String name) {
	
 Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(sec1)).ignoring(Throwable.class);
	 
	 
 wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		 
	 }
 
 public static void navigate(String url) {
	
	 driver.navigate().to(url);
}
 
 public static void navigateforward() {
		
	 driver.navigate().forward();
}
 
 public static void navigatebackward() {
		
	 driver.navigate().back();
	 
}
 public static void navigaterefesh() {
		
	 driver.navigate().refresh();
}
 
 public static void windowurl(String url) {
	
	 
	 driver.switchTo().window(url);
}
 
 public static void windowtile(String url) {
	
	 
	 driver.switchTo().window(url);
} 
 public static void windowid(String url) {
	
	 
	 driver.switchTo().window(url);
}
 public static void defaultwindow() {
	
	 
	 driver.switchTo().defaultContent();
}
    
 public static void defaultframe() {
	
	 
	 driver.switchTo().defaultContent();
}
 
public static void frameid(String id) {
	
	 
	 driver.switchTo().frame(id);
}
public static void framename(String name) {
	
	 
	 driver.switchTo().frame(name);
}

public static void framewebelement(WebElement element) {
	
	 
	 driver.switchTo().frame(element);
}

public static void frametoparent() {
	
	 
	 driver.switchTo().parentFrame();
}


public static void alertok() {
	
	Alert al = driver.switchTo().alert();
	
	al.accept();
	
}

public static void alertdismiss() {
	
	Alert al = driver.switchTo().alert();
	
	al.dismiss();
	
}

public static void alertsend(String send) {
	
	Alert al = driver.switchTo().alert();
	
	al.sendKeys(send);
	
}

public static String alertprint() {
	
	Alert al = driver.switchTo().alert();
	
	String text = al.getText();
	return text;
}

public static void keyboardaction(int keycode) throws Throwable {

Robot robot = new Robot();
robot.keyPress(keycode);
robot.keyRelease(keycode);

}

    public static void sysout(String data) {
		System.out.println(data);

	}
    
    
    
}
