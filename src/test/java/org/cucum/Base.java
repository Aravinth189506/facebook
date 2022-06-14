package org.cucum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	protected static WebDriver driver;
	static Actions a;
	static Alert al;
	static JavascriptExecutor js;
	static TakesScreenshot ts;
	static File dest;
	static Select s;
	static int r;
	static String text="";
	static int c;


	 public static void toLaunchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public static void toLoadUrl(String url) {
		driver.get(url);
	}
	public static void toMaximize() {
		driver.manage().window().maximize();
	}
	public static String toGetUrl() {
		return(driver.getCurrentUrl());

	}
	public static String toGetTitle() {
		return(driver.getTitle());

	}
	public static void toEnterText(WebElement email, String text) {
	email.sendKeys(text);	

	}
	public static void toClick(WebElement element) {
		element.click();

	}
	public static void toQuit() {
		driver.quit();

	}
	public static void toMousehover(WebElement element) {
		a=new Actions(driver);
	a.moveToElement(element).perform();
	}
	public static String toGetText(WebElement element) {
		String text = element.getText();
		return text;
		
	}
	public static String toGetAttribute(WebElement element,String value) {
		String attribute = element.getAttribute(value);
	return attribute;
	} 
	public static void toDragAndDrop(WebElement element1,WebElement element2) {
	a =new Actions(driver);
	a.dragAndDrop(element1, element2).perform();
	}
	private void toDoubleClick(WebElement element) {
		a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	public static void toContextClick(WebElement element) {
		a=new Actions(driver);
	}
	public static void toKeyUpAndKeyDown(String value) {
	a=new Actions(driver);
	a.keyDown(Keys.SHIFT).sendKeys(value).keyUp(Keys.SHIFT).build().perform();
	}
	public static void alertAccept() {
		al=driver.switchTo().alert();
		al.accept();
	}
	public static void alertDismiss() {
		al=driver.switchTo().alert();
		al.dismiss();
	}
	public static void alertSendText(String value) {
	al=driver.switchTo().alert();
	al.sendKeys(value);
	}
	public static String alertGetText() {
	al=driver.switchTo().alert();
	String text = al.getText();
	return text;
	}
	public static void toTakeScreenshot(String value) throws IOException {
	ts=(TakesScreenshot)driver;
	File file = ts.getScreenshotAs(OutputType.FILE);
	dest=new File(value);
	FileUtils.copyFile(file, dest);
	}
	public static void toScrollDown(WebElement element) {
	js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	public static void toScrollUp(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",element);	
	}
	public static void useJavaScriptPassText(WebElement element,String value) {
		js=(JavascriptExecutor)driver;
	js.executeScript(value, element);
	}
	public static void useJavaScriptGetText(WebElement element) {
		js=(JavascriptExecutor)driver;	
	js.executeScript("return aruguments[0].getAttribute(value)", element);
	}
	public static void useJavaScriptClick(WebElement element) {
		js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0.click()", element);
	}

	public static void dropDownSelectByIndex(WebElement element,  int value) {
	s=new Select(element);	
	s.selectByIndex(value);
	}
	public static void dropDownSelecyByValue(WebElement element,String value) {
		s=new Select(element);	
	s.selectByValue(value);
	}
	public static void dropDownSelectByVisibleText(WebElement element,String value) {
		s=new Select(element);	
	s.selectByVisibleText(value);
	}
	public static void dropDownDeSelectByIndex(WebElement element,  int value) {
	s=new Select(element);	
	s.deselectByIndex(value);
	}
	public static void dropDownDeSelecyByValue(WebElement element,String value) {
		s=new Select(element);	
	s.deselectByValue(value);
	}
	public static void dropDownDeSelectByVisibleText(WebElement element,String value) {
		s=new Select(element);	
	s.deselectByVisibleText(value);
	}
	public static void dropDownDeselectAll(WebElement element) {
		s=new Select(element);		
	s.deselectAll();
	}
	public static void dropDownIsMultiple(WebElement element) {
	s=new Select(element);
	boolean multiple = s.isMultiple();
	}
	public static String dropDownFirstSelectedOption(WebElement element) {
	s=new Select(element);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	String text = firstSelectedOption.getText();
	return text;
	}
	public static String dropDownAllSelectedOption(WebElement element) {
		s=new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	for (int i = 0; i < allSelectedOptions.size(); i++) {
		WebElement element2 = allSelectedOptions.get(i);
		String text = element2.getText();
	}
	return text;
	}
	public static String dropDownAllOptions(WebElement element) {
		s=new Select(element);
	List<WebElement> alloptions = s.getOptions();
	for (int i = 0; i < alloptions.size(); i++) {
	WebElement element2 = alloptions.get(i);	
	}
	return text;
	}
	public static void toFrameByIdName(String value) {
	driver.switchTo().frame(value);
	}
	public static void toFrameByIndex(int value) {
		driver.switchTo().frame( value);
	}
	public static void toFrameWebelement(WebElement element) {
	driver.switchTo().frame(element);
	}
	public static String fetchFromExcel(String sheetName,int rowNo,int cellNo) throws IOException {
		File f=new File("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\framesd1.xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook b=new XSSFWorkbook(fin);
	Sheet sh = b.getSheet(sheetName);

	Row r = sh.getRow(rowNo);
	Cell c = r.getCell(cellNo);
	int type = c.getCellType();
	String val;
	if (type==1) {
		  val = c.getStringCellValue();
		
	}
	else if (DateUtil.isCellDateFormatted(c)) {
	Date da = c.getDateCellValue();
	SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");	 
	val = sim.format(da);
	}
	else {
	double dou = c.getNumericCellValue();

	long lo=(long)dou;
	  val = String.valueOf(lo);
		
		
	}
	return val;	
		}

	public static String getExcel(String fileName,String sheetName,int rowNo,int cellNo) throws IOException  {

	FileInputStream fin =new FileInputStream("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\"+fileName+".xlsx");
	Workbook w=new XSSFWorkbook(fin);
	return w.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	public static void createExcel(String fileName,String sheetName,int rNo,int cellNo,String value ) throws IOException {
		File f=new File("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\"+fileName+".xlsx");
		FileOutputStream fout=new FileOutputStream(f);
		Workbook w=new XSSFWorkbook();
	Cell cce = w.createSheet(sheetName).createRow(rNo).createCell(cellNo);
	cce.setCellValue(value);
	w.write(fout);
	}
	public static void insertCell(String fileName,String sheetName,int rowNo,int cellNo,String value) throws IOException {
		File f=new File("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\"+fileName+".xlsx");
		FileInputStream fin =new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sh = w.getSheet(sheetName);
	Row r = sh.getRow(rowNo);
	Cell c = r.createCell(cellNo);
	c.setCellValue(value);
	FileOutputStream fout=new FileOutputStream(f);
	w.write(fout);
	}
	public static void insertRow(String fileName,String sheetName,int rowNo,int cellNo,String value) throws IOException {
		File f=new File("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\"+fileName+".xlsx");
		FileInputStream fin =new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sh = w.getSheet(sheetName);
	Row r = sh.createRow(rowNo);
	Cell c = r.createCell(cellNo);
	c.setCellValue(value);
	FileOutputStream fout=new FileOutputStream(f);
	w.write(fout);
	}
	public static void updateExcel(String fileName,String sheetName,int rno,int cellno,String value) throws IOException {
	File f=new File("C:\\Users\\Bharath\\eclipse-workspace\\ProjectName8Am\\xlsheet\\"+fileName+".xlsx");
	FileInputStream fin =new FileInputStream(f);
	Workbook b=new XSSFWorkbook(fin);
	Sheet sh = b.getSheet(sheetName);
	Row row= sh.createRow(rno);
	Cell cell = row.createCell(cellno);
	cell.setCellValue(value);
	FileOutputStream fout=new FileOutputStream(f);
	b.write(fout);
	}
	public static void toWait(long value) {
	driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);

	}
	}	

























