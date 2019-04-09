package com.dvla.test.run;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dvla.util.GetCSVValue;
import com.dvla.util.GetDirectoryInfo;
import com.dvla.util.GetDirectoryLocation;
import com.dvla.util.GetFileInfo;
import com.dvla.util.Writer;



public class ExcuteTest {

	public static void main(String[] args) {
	
		String dirPath = new String();
		String fileWriterPath = new String();
		String webDriverPath = new String();
		
		try {
			
			GetCSVValue getcsvValue = new GetCSVValue();
			//Reading config and getting directory Path
			  GetDirectoryLocation getDirectoryLocation = new GetDirectoryLocation();
			  dirPath = getDirectoryLocation.getValueFormConfig("directoryPath");
			  fileWriterPath = getDirectoryLocation.getValueFormConfig("filePath");
			  webDriverPath = getDirectoryLocation.getValueFormConfig("webdriverPath");
			  
			  
			  //Getting number of file from configured directory
			  GetDirectoryInfo getDirectoryInfo = new GetDirectoryInfo(); 
			  int numberOfFile = getDirectoryInfo.getNumberOfFilesFormDirectory(dirPath);
			  System.out.println(numberOfFile);
			  
			  //Getting List of all file with path from directory
			  List<String> listFilesPath= getDirectoryInfo.getFilesWithPathFromDirectory(dirPath);
			  
			  Writer writer = new Writer();
			  
			  for (String filePath : listFilesPath) {
				    
				  System.out.println(filePath);
				    GetFileInfo getFileInfo = new GetFileInfo();
				    String fileName = getFileInfo.getFileName(filePath);
					String fileMimeType = getFileInfo.getMimeType(filePath);
					double fileSize = getFileInfo.getFileSize(filePath);
					String extension = getFileInfo.getFileExtension(filePath);
					
					writer.WriteInTextFile(fileWriterPath,fileName,fileMimeType,fileSize,extension);
					
					List <String> vList = getcsvValue.getvehicleNumber(filePath);
					
					 for (String vNumber : vList) {

						 	System.setProperty("webdriver.chrome.driver", webDriverPath);
							WebDriver driver = new ChromeDriver();
							
							driver.manage().window().maximize();
							driver.manage().deleteAllCookies();
							driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							driver.get("https://www.gov.uk/get-vehicle-information-from-dvla");
							
							driver.findElement(By.xpath("//a[@href='https://www.vehicleenquiry.service.gov.uk']")).click();
							
							driver.findElement(By.id("Vrm")).sendKeys(vNumber);
							driver.findElement(By.name("Continue")).click();
							
							WebElement elementColour = driver.findElement(By.id("Colour"));
							String colour = elementColour.getAttribute("value");
							
							
					 }
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
