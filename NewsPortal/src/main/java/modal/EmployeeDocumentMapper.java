package modal;

import org.bson.Document;

public class EmployeeDocumentMapper {
	
		public static Employee getEmployee(Document d)
		{
			Employee emp=new Employee();
			emp.setName(d.getString("name"));
			emp.setMobile(d.getString("mobile"));
			emp.setEmailId(d.getString("email"));
			emp.setPassword(d.getString("password"));
			return emp;
		}
		
		public static Document getDocument(Employee emp)
		{
			Document doc=new Document().append("name",emp.getName())
					.append("mobile", emp.getMobile())
					.append("email", emp.getEmail())
					.append("password", emp.getPassword());
			return doc;
		}

}
