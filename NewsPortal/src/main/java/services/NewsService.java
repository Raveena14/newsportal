package services;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import modal.Database;
import modal.EmployeeDatabase;
import modal.EmployeeDocumentMapper;
import modal.News;
import modal.NewsDatabase;
import modal.NewsDocumentMapper;

public class NewsService {
	
	static{

		Database.connect();
	}
	
	 public static ArrayList getAllNewsTemporary()
		{
		 ArrayList al=NewsDatabase.retreiveAllNews();
		 return al;
		}
	 
	

	public static void addNewsTemporary(News input) {
		 Document newsDoc=NewsDocumentMapper.getNewsDocument(input);
		    NewsDatabase.addNewsTemporary(newsDoc);
	}
	
	public static void addNewsPermanent(News input) {
		 Document newsDoc=NewsDocumentMapper.getNewsDocument(input);
		    NewsDatabase.addNewsPermanent(newsDoc);
	}

	public static ArrayList getNewsByCategory(String category) {
		ArrayList a=NewsDatabase.getNewsByCategory(category);
		return a;
	}
	
	public static ArrayList getNewsByDate(Date date) {
		ArrayList a=NewsDatabase.getNewsByDate(date);
		return a;
	}

}
