package Datadriven.Runner;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

public class featurerunner1 
{
	@Test
	public Karate runtest()
	{
		return Karate.run("classpath:Datadriven/Test_2_verify_fav_article_on_user_profile.feature");
		
	}
}
