package qa.com.datadrivenframework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import qa.com.excel.utilities3.Xls_Reader1;

public class paramerazation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		
		Xls_Reader1 db3 = new Xls_Reader1("E:/workbook.xlsx");
		int rowcount = db3.getRowCount("Deepak");
		System.out.println(rowcount);
		
		
		for (int rownum=2;rownum<=rowcount;rownum++)
		{
			String FirstName =db3.getCellData("Deepak", "First name",rowcount );
			System.out.println("FirstName :-" + FirstName );
			
			String surname =db3.getCellData("Deepak", "Sirname", rowcount);
			System.out.println("surname :-" + surname );
			
			
			driver.findElement(By.xpath("//*[@id='login1']")).clear();
			   driver.findElement(By.xpath("//*[@id='login1']")).sendKeys(FirstName);
			   
			   driver.findElement(By.xpath("//*[@id='password']")).clear();
			   driver.findElement(By.xpath("//*[@id='password']")).sendKeys(surname);
		
		driver.quit();
		}

	}

}
