package seleniumProgram;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapProg 
{

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", ".exe file path");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
		
		
		
		int num=12345,rev=0;
		while(num!=0)
		{
			int digit=num%10;
			rev=rev*10+digit;
			num/=10;
		}
		System.out.println("Revrse String-->"+rev);

		
		
		
		
		
		
		/*String str="Geeta";
		String rev="";
		int l=str.length();
		for(int i=l-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println("Revrse String-->"+rev);
		*/
		
		HashMap<String,String>hmap=new HashMap<String,String>();
		hmap.put("Name", "Geeta");
		hmap.put("Address", "Thane");
		hmap.put("Langauage", "Java");
		System.out.println(hmap);
		hmap.remove("Name");
		System.out.println(hmap);

		System.out.println(hmap.keySet());
         System.out.println(hmap.values());
        System.out.println(hmap.containsKey("Name"));
        System.out.println(hmap.containsValue("Geeta"));

	}

}
