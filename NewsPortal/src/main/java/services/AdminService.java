package services;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import modal.AdminDatabase;
import modal.Database;
import modal.Employee;
import modal.EmployeeDatabase;
import modal.EmployeeDocumentMapper;
import modal.News;
import modal.NewsDatabase;
import modal.NewsDocumentMapper;

public class AdminService {

	static{

		Database.connect();
	}
	
	
	 public static ArrayList getAllEmployee()
		{
		 ArrayList al=AdminDatabase.retreiveAllEmployee();
		 return al;
		}

	 public static void addEmpPermanent(Employee emp)
		{
		    Document empDoc=EmployeeDocumentMapper.getDocument(emp);
		    AdminDatabase.addEmployeePermanent(empDoc);	    
		}
	 public static ArrayList getAllNewsPermanent()
		{
		 ArrayList al=NewsDatabase.retreiveAllNews();
		 return al;
		}
	 
	 public static boolean deleteTemporaryNews(String title) {
			Document d= new Document();
			d.append("title", title);
			Database.collection3.deleteOne(d);
			return true;
		}
		
		public static boolean deletePermanentNews(String title) {
			Document d= new Document();
			d.append("title", title);
			Database.collection4.deleteOne(d);
			return true;
		}

		public static boolean deleteTemporaryEmployee(String email) {
			Document d= new Document();
			d.append("email", email);
			Database.collection1.deleteOne(d);
			return true;
		}
}
