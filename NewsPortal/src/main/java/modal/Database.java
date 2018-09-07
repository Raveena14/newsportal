package modal;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {
	
		private static final String DBNAME="newsportal";
		private static final String NEWS_TEMPORARY="news_temporary";
		private static final String NEWS_PERMANENT="news_permanent";
		private static final String EMPLOYEE_TEMPORARY="employee_temporary";
		private static final String EMPLOYEE_PERMANENT="employee_permanent";
		private static final String ADMIN="admin";
		public static MongoCollection<Document> collection1; 
		public static MongoCollection<Document> collection2;
		public static MongoCollection<Document> collection3; 
		public static MongoCollection<Document> collection4; 
		public static MongoCollection<Document> collection5; 

		public static void connect()
		{
			MongoClient mongo=new MongoClient("localhost",27017);
			MongoDatabase database=mongo.getDatabase(DBNAME);
			collection1=database.getCollection(EMPLOYEE_TEMPORARY);
			collection2=database.getCollection(EMPLOYEE_PERMANENT);
			collection3=database.getCollection(NEWS_TEMPORARY);
			collection4=database.getCollection(NEWS_PERMANENT);
			collection5=database.getCollection(ADMIN);
		}
	
}


