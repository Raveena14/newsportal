package modal;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class EmployeeDatabase {
	
	
	public static void addEmployeeTemporary(Document emp)
	{
	  Database.collection1.insertOne(emp);	
	}
	

}
