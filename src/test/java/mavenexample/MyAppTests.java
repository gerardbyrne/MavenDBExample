package mavenexample;

import org.junit.Assert;
import org.junit.Test;

public class MyAppTests {
	@Test
	public void testCompanyName()
	{
		Assert.assertEquals(MyApp.getCompanyName(), "Gerry and David Ltd");
	}
	
	
	@Test
	public void testCompanyName1()
	{
		Assert.assertEquals(MyApp.getCompanyName(), "Gerry and David Ltd");
	}

}