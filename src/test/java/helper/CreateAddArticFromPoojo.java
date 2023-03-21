package helper;

import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONObject;

public class CreateAddArticFromPoojo 
{
	
	public static JSONObject addarticlejson()
	{
		Addarticlepojo ad = new Addarticlepojo();
		Articlepojo ar = new Articlepojo();
		List<String> mylist = new ArrayList<String>();
		
		mylist.add("ABC1");
		mylist.add("ABC2");
		ar.setTagList(mylist);
		ar.setBody("test_test_567");
		ar.setTitle("History_automation_123");
		ar.setDescription("sdfdsdf");
		ad.setArticle(ar);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("title", ad.getArticle().getTitle());
		jsonobject.put("description", ad.getArticle().getDescription());
		jsonobject.put("body", ad.getArticle().getBody());
		jsonobject.put("tagList1", ad.getArticle().getTagList().get(0));
		jsonobject.put("tagList2", ad.getArticle().getTagList().get(1));		
		return jsonobject;		
	}
}
