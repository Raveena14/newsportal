package modal;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class AdminDatabase {
	
	public static ArrayList retreiveAllEmployee()
	{
		ArrayList al=new ArrayList();
		FindIterable<Document> fit=Database.collection1.find();
		Iterator it=fit.iterator();
		while(it.hasNext())
		{
			 Document empDocument=(Document)it.next();	
			 Employee empObject=EmployeeDocumentMapper.getEmployee(empDocument);
			 al.add(empObject);
		}
		return al;
	}
	
	
	public static void addEmployeePermanent(Document emp)
	{
	  Database.collection2.insertOne(emp);	
	}

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

}
