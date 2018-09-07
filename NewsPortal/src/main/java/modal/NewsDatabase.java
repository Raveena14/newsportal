package modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class NewsDatabase {
	
	public static ArrayList retreiveAllNews()
	{
		ArrayList al=new ArrayList();
		FindIterable<Document> fit=Database.collection3.find();
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			 Document newsDocument=(Document)it.next();	
			 News newsObject=NewsDocumentMapper.getNews(newsDocument);
			 al.add(newsObject);
		}
		return al;
	}
	
	public static void addNewsTemporary(Document news)
	{
	  Database.collection3.insertOne(news);	
	}
	
	public static void addNewsPermanent(Document news)
	{
	  Database.collection4.insertOne(news);	
	}

	public static ArrayList getNewsByCategory(String category) {
		ArrayList al=new ArrayList();
		FindIterable<Document> fit=Database.collection4.find().filter(Filters.eq("category",category));
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			 al.add(it.next());
		}
		return al;
	}
	
	public static ArrayList getNewsByDate(Date date) {
		ArrayList al=new ArrayList();
		FindIterable<Document> fit=Database.collection4.find().filter(Filters.eq("date",date));
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			 al.add(it.next());
		}
		return al;
	}
}
