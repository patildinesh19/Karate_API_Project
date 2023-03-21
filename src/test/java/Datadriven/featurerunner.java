package Datadriven;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class featurerunner 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("addarticleusingautocreatedjson").relativeTo(getClass());
		
	}
}
