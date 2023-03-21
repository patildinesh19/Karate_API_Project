package Datadriven.Runner;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class signuprunner 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("verify_invalid_signup_signin").relativeTo(getClass());
		
	}
}
