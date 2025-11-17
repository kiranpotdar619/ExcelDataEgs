package com.Exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelData 
{
    public static void main( String[] args ) throws IOException
    {
       WebDriver driver;
       
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       
       driver.manage().window().maximize();
       driver.get("https://www.amazon.in/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       driver.findElement(By.xpath("//*[text()='Hello, sign in']")).click();
       
       File file = new File("C:\\Users\\HP\\eclipse-workspace\\ExcelData\\src\\main\\resources\\Book1.xlsx");
       FileInputStream fis = new FileInputStream(file);
       
       XSSFWorkbook wb = new XSSFWorkbook(fis);
       
       XSSFSheet sheet = wb.getSheetAt(0);
//       
//       Row row = sheet.getRow(1);
//       Cell cell = row.getCell(0);
//       
//       
//      // Row row1 = sheet.getRow(1);
//       Cell cell1 = row.getCell(1);
//       
       String username = ""; //cell.getStringCellValue();
     //  System.out.println(username);
       String password = "" ;//cell1.getStringCellValue();
       
       for(Row row : sheet) {
    	   //if(row.equals(sheet.getRow(1))){
    	    username = row.getCell(0).getStringCellValue();
    	    System.out.println("Username: "+username+" "+row.getRowNum());
    	    password = row.getCell(1).getStringCellValue();
    	  // }
       }

       WebElement email = driver.findElement(By.id("ap_email_login"));
       email.sendKeys(username);
       driver.findElement(By.className("a-button-input")).click();
       
       
       WebElement pass = driver.findElement(By.id("ap_password"));
       pass.sendKeys(password);
       driver.findElement(By.id("signInSubmit")).click();

    }
}
