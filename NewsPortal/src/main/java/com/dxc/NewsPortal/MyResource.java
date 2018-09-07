package com.dxc.NewsPortal;

import java.util.Date;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modal.Employee;
import modal.News;
import services.AdminService;
import services.EmployeeService;
import services.NewsService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("getallemp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEmployee() {
    	
    	return Response.ok(AdminService.getAllEmployee())
    	      //  .header("Access-Control-Allow-Origin", "*")
    	        // whatever other CORS headers
    	        .build();
    	
    }
    
    @GET
    @Path("getallnewstemporary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNewsTemporary() {

    	return Response.ok(NewsService.getAllNewsTemporary())
    	      //  .header("Access-Control-Allow-Origin", "*")
    	        // whatever other CORS headers
    	        .build();

    }
    
    @GET
    @Path("getallnewspermanent")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllNewsPermanent() {
    	
    	return Response.ok(AdminService.getAllNewsPermanent())
    	    //    .header("Access-Control-Allow-Origin", "*")
    	        // whatever other CORS headers
    	        .build();
    	
    }
    
    @POST
    @Path("addemptemporary")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTemporary(Employee input)
    {
    	System.out.println("hello");
    	EmployeeService.addEmpTemporary(input);
    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
    			//.header("Access-Control-Allow-Origin", "*")
    			.build();

    }

    @POST
    @Path("approveemp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveEmp(Employee input)
    {
        AdminService.addEmpPermanent(input);
        AdminService.deleteTemporaryEmployee(input.getEmail());
        return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
                //.header("Access-Control-Allow-Origin", "*")
                .build();

    }

    @POST
    @Path("approvenews")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response approveNews(News input)
    {
        NewsService.addNewsPermanent(input);
        AdminService.deleteTemporaryNews(input.getTitle());
        return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
                //.header("Access-Control-Allow-Origin", "*")
                .build();

    }
    
    @POST
    @Path("addemppermanent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Employee input)
    {
    	System.out.println("hello");
    	AdminService.addEmpPermanent(input);
    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
    			//.header("Access-Control-Allow-Origin", "*")
    			.build();

    }
    
    @POST
    @Path("addnewstemporary")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewsTemporary(News input)
    {
    	System.out.println("hello");
    	NewsService.addNewsTemporary(input);
    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
    		//	.header("Access-Control-Allow-Origin", "*")
    			.build();

    }
    
    @POST
    @Path("addnewspermanent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewsPermanent(News input)
    {
    	System.out.println("hello");
    	NewsService.addNewsPermanent(input);
    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}")
    			//.header("Access-Control-Allow-Origin", "*")
    			.build();

    }
    
    @Path("getnewsbycategory/{category}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewsByCategory(@PathParam("category")String category) {
    	return Response.ok(NewsService.getNewsByCategory(category))
    			//.header("Access-Control-Allow-Origin", "*")
    			.build();
    }
    
    @Path("getnewsbydate/{date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewsByDate(@PathParam("date")Date date) {
    	return Response.ok(NewsService.getNewsByDate(date))
    			//.header("Access-Control-Allow-Origin", "*")
    			.build();
    }
    
    @DELETE
    @Path("deletetemporary/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTemporary(@PathParam("title")String title) {
    
    	if(AdminService.deleteTemporaryNews(title)) {
    		return "{\"status\":\"0\",\"message\":\"successfuly deleted\"}";
    	}
    	else {
    		return "{\"status\":\"1\",\"message\":\"not found\"}";
    	}
}
    
    @DELETE
    @Path("deletepermanentnews/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePermanent(@PathParam("title")String title) {
    
    	if(AdminService.deletePermanentNews(title)) {
    		return "{\"status\":\"0\",\"message\":\"successfuly deleted\"}";
    	}
    	else {
    		return "{\"status\":\"1\",\"message\":\"not found\"}";
    	}
}
    
    @DELETE
    @Path("deletepermanent/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTemporaryEmployee(@PathParam("email")String email) {
    
    	if(AdminService.deleteTemporaryEmployee(email)) {
    		return "{\"status\":\"0\",\"message\":\"successfuly deleted\"}";
    	}
    	else {
    		return "{\"status\":\"1\",\"message\":\"not found\"}";
    	}
}
}
