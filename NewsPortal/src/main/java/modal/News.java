package modal;

import java.util.Date;

public class News {
	
	String title;
	String office_loc;
	String category;
	String description;
	Date date;
	

	public News() {
		
	}
	
	public News(String title, String office_loc, String category, String description, Date date) {
		super();
		this.title = title;
		this.office_loc = office_loc;
		this.category = category;
		this.description = description;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOffice_loc() {
		return office_loc;
	}
	public void setOffice_loc(String office_loc) {
		this.office_loc = office_loc;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
