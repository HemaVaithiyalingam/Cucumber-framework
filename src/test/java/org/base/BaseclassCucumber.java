package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class BaseclassCucumber {
	
		public static WebDriver driver;
		public static WebElement element;
		public static Actions actions;

		public static void browserLaunch(String browser) {

			switch (browser) {

			case ("chrome"):
				driver = new ChromeDriver();
				break;

			case ("edge"):
				driver = new EdgeDriver();
				break;

			case ("firefox"):
				driver = new FirefoxDriver();
				break;

			}
		}

		public static void maximizeWindow() {
			driver.manage().window().maximize();
		}

		public static void loadUrl(String url) {
			driver.get(url);
		}

		public static void quitBrowser() {
			driver.quit();

		}

		public static WebElement findingWebElement(String locator, String webElement) {

			if (locator.equals("id")) {
				element = driver.findElement(By.id(webElement));
			} else if (locator.equals("name")) {
				element = driver.findElement(By.name(webElement));
			} else if (locator.equals("class")) {
				element = driver.findElement(By.className(webElement));
			} else if (locator.equals("xpath")) {
				element = driver.findElement(By.xpath(webElement));
			} else if (locator.equals("tagname")) {
				element = driver.findElement(By.tagName(webElement));
			}
			return element;

		}

		public static void sendingValue(WebElement element, String value) {
			element.sendKeys(value);
		}
		
		public static void clickButton(WebElement element) {
			element.click();
		}

		public static void navigateWebpage(String data) {
			if (data.equals("back")) {
				driver.navigate().back();
			} else if (data.equals("forward")) {
				driver.navigate().forward();
			} else if (data.equals("refresh")) {
				driver.navigate().refresh();
			}
		}

		public static String gettingElementText(WebElement textElement) {
			String text = textElement.getText();
			return text;
		}

		public static String getAttributeValue(WebElement element, String attributeName) {
			String attributeValue = element.getAttribute(attributeName);
			return attributeValue;
		}

		public static void moveElement(WebElement element) {
			actions = new Actions(driver);
			actions.moveToElement(element).perform();
			actions.clickAndHold(element);
		}

		public static void dragAndDropElement(WebElement sourceElement, WebElement destinationElement) {

			actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, destinationElement).perform();
		}

		public static void doubleClickTheElement() {
			actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}

		public static void rightClick() {
			actions = new Actions(driver);
			actions.contextClick(element).perform();
		}

		public static void switchingToFrame(String frameName) {
			driver.switchTo().frame(frameName);

		}

		public static void switchingToFrame(int frameIndex) {
			driver.switchTo().frame(frameIndex);

		}

		public static void switchingToFrame(WebElement element) {
			driver.switchTo().frame(element);

		}

		public static void alertHandling(String alertHandle) {
			Alert alert = driver.switchTo().alert();

			if (alertHandle.equals("acceptAlert")) {
				alert.accept();
			} else if (alertHandle.equals("dismissAlert")) {
				alert.dismiss();
			}
		}

		public static void screenShot(String filePath) throws IOException {
			TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
			File screenshot = takesScreenShot.getScreenshotAs(OutputType.FILE);
			Files.copy(screenshot, new File(filePath));

		}

		public static void executeJavascript(String javascript, WebElement element) {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript(javascript, element);
		}
		

		public static void dropdownSelect(WebElement element, int indexvalue) {
			Select select = new Select(element);
			select.selectByIndex(indexvalue);
		}

		public static void dropdownSelect(WebElement element, String selectby, String value) {
			Select select = new Select(element);

			if (selectby.equals("value")) {
				select.selectByValue(value);
			} else if (selectby.equals("visibleText")) {
				select.selectByVisibleText(value);
			}

		}

		public static String excelread(String fileLocation, String sheetName, int rowNum, int cellNum) throws IOException {
			File file = new File(fileLocation);
			FileInputStream inputstream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(inputstream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			CellType cellType = cell.getCellType();
			String data = null;

			switch (cellType) {

			case STRING:
				String stringValue = cell.getStringCellValue();
				data = stringValue;
				break;

			case BOOLEAN:
				boolean booleanValue = cell.getBooleanCellValue();
				data = Boolean.toString(booleanValue);
				break;

			case NUMERIC:
				double numericCellValue = cell.getNumericCellValue();
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
					String formatteddate = dateformat.format(dateCellValue);
					data = formatteddate;
				} else {
					long round = Math.round(numericCellValue);
					if (round == numericCellValue) {
						data = Long.toString(round);
					} else {
						data = Double.toString(numericCellValue);
					}
				}

				break;
			}
			return data;
		}

		public void handlingWindow(int id) {
			
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindowId = driver.getWindowHandles();
			List<String> list=new ArrayList<String>();
			list.addAll(allWindowId);
			String windowId = list.get(id);
			driver.switchTo().window(windowId);
		}
		

}
