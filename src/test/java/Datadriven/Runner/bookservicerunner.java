package Datadriven.Runner;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class bookservicerunner 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("bookdetails").relativeTo(getClass());
		
	}
}
