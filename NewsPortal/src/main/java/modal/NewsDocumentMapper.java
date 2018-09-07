package modal;

import org.bson.Document;

public class NewsDocumentMapper {
	
	public static News getNews(Document d)
	{
		News news1=new News();
		news1.setTitle(d.getString("title"));
		news1.setCategory(d.getString("category"));
		news1.setDate(d.getDate("date"));
		news1.setDescription(d.getString("description"));
		news1.setOffice_loc(d.getString("office_loc"));
		return news1;
		
	}
	
	public static Document getNewsDocument(News news)
	{
		Document doc=new Document().append("title",news.getTitle())
				.append("category",news.getCategory())
				.append("date",news.getDate())
				.append("description",news.getDescription())
				.append("office_loc",news.getOffice_loc());
				
		return doc;
	}

}
