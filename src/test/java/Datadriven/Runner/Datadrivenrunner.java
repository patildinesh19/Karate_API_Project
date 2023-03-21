package Datadriven.Runner;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class Datadrivenrunner 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("classpath:Datadriven/data_driven_conduit.feature");
		
	}
}
