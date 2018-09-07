package services;

import java.util.ArrayList;

import org.bson.Document;

import modal.AdminDatabase;
import modal.Database;
import modal.Employee;
import modal.EmployeeDatabase;
import modal.EmployeeDocumentMapper;

import javax.json.JsonObject;

public class EmployeeService {

	static{

		Database.connect();
	}
	
	
	 
	 public static void addEmpTemporary(Employee emp)
		{
		    Document empDoc=EmployeeDocumentMapper.getDocument(emp);
		    EmployeeDatabase.addEmployeeTemporary(empDoc);	    
		}

}
