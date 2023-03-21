package Datadriven;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class Datadrivenrunner 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("\\data_driven_conduit2").relativeTo(getClass());
		
	}
}
