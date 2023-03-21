package helper;

import com.github.javafaker.Faker;

import net.minidev.json.JSONObject;

public class dummydatagenerator 
{
	public static String randomemailgenrator()
	{
		Faker faker = new Faker();
		String email = faker.name().firstName().toLowerCase() + faker.random().nextInt(0,100) +"@test.com";
		return email;				
	}
	public static String generatefirstname()
	{
		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		return firstname;
	}
	public static String generatebookname()
	{
		Faker faker = new Faker();
		String bookname = faker.book().title();
		return bookname;
	}
	public static String genratebookauthorname()
	{
		Faker faker = new Faker();
		String authorname = faker.book().author();
		return authorname;
	}
	public static String generaterandominteger()
	{
		Faker faker = new Faker();
		String randominteger = faker.number().digits(4);
		return randominteger;
	}
	
	public static JSONObject generatearticle()
	{
		Faker faker = new Faker();
		String title = faker.gameOfThrones().character();
		String description = faker.gameOfThrones().city();
		String body = faker.gameOfThrones().quote();
		String taglist = faker.gameOfThrones().house();
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("title", title);
		jsonobject.put("description", description);
		jsonobject.put("body", body);
		jsonobject.put("tagList", taglist);
		return jsonobject;		
	}
	public static JSONObject addcomments()
	{
		Faker faker = new Faker();
		String comments = faker.commerce().productName();
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("body", comments);		
		return jsonobject;
		
	}
}
