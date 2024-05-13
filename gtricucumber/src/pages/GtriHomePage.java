package gtri.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GtriHomePage {


	WebDriver driver;             //null

	public GtriHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public HashMap<String, Integer> fetchAllHyperLinkDetails() throws IOException
	{
		HashMap<String,Integer> hyperLinkHMap = new HashMap<String,Integer> ();
		List<WebElement> hyperlinkList = driver.findElements(By.tagName("a"));
		for(int i =0 ; i < hyperlinkList.size();i++)
		{
			String linkDetails = hyperlinkList.get(i).getAttribute("href");
			 
			if(linkDetails!=null)
			{
				int statuscode = verifyLink(linkDetails,i);
				hyperLinkHMap.put(linkDetails,statuscode);
			}
			else {
				
				System.out.println("Else List size::: " + i + "  url::: " + linkDetails);
			}

		}
		return hyperLinkHMap;
	}
	public  int  verifyLink(String url, int index) throws IOException {
		
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpUriRequest httpUriRequest = new HttpGet(url);
		HttpResponse response = client.execute(httpUriRequest);
		int responseCode = response.getStatusLine().getStatusCode();
		//System.out.println("Response:"+response.getStatusLine().getStatusCode());
		if(responseCode!=200)
		{
			System.out.println(url  + " - " + index + "--"+ responseCode );
		}
		
//		HttpURLConnection httpURLConnection = null;
//		 
//		try {
//			URL link = new URL(url);
//			httpURLConnection = (HttpURLConnection) link.openConnection();
//			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
//			httpURLConnection.connect();
//			if (httpURLConnection.getResponseCode() == 200) {
//				//System.out.println(url + " - " + httpURLConnection.getResponseMessage());
//			} else {
//				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + index + " is a broken link");
//			}
//		} catch (Exception e) {
//			System.out.println(url + " - " + "is a broken link");
//		}
		//return httpURLConnection.getResponseCode();
		return response.getStatusLine().getStatusCode();
	}
}

