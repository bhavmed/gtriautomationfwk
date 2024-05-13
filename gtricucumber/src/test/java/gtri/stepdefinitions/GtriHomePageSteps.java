package gtri.stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.junit.Assert;

import gtri.helper.BaseClass;
import gtri.helper.HelperClass;
import gtri.pages.GtriHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GtriHomePageSteps extends BaseClass {
	   HelperClass helper;
	   HashMap<String,Integer> hyperLinkActualHMap;

	@Given("User visited to the gtri home page")
	public void user_visited_to_the_gtri_home_page() throws IOException {
		
		instantiateDriver();
		helper=new HelperClass(driver);
		helper.launchBrowser(pro.getProperty("gtriURL"));

		 
	}
	@When("User click on each hyperlink")
	public void user_click_on_each_hyperlink() throws IOException {
		GtriHomePage gtriHPage = new GtriHomePage(driver);
		hyperLinkActualHMap = gtriHPage.fetchAllHyperLinkDetails();
		 
	}
	@Then("User can launch the page successfully")
	public void user_can_launch_the_page_successfully() {
		Set<String> linkSet = hyperLinkActualHMap.keySet();
		System.out.println("###################3Printing the Hyper Link Details####################");
		for(String link : linkSet)
		{
			System.out.println(link + "----" + hyperLinkActualHMap.get(link));
		}
		 
		 Assert.assertTrue(!hyperLinkActualHMap.containsValue(400));
		 helper.closeBrowser();
		 
	}
}
