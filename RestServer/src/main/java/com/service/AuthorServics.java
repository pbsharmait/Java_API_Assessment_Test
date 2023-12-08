package com.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.Author;
import com.dao.AuthorDao;
import com.google.gson.Gson;

@Path("author")
public class AuthorServics {
	
	Gson gson= new Gson();
	
	    @Path("insert")
	    @Produces(MediaType.TEXT_PLAIN)
	    @Consumes(MediaType.APPLICATION_JSON)
	    @POST
		public String insertAuthor(String author)
		{
			Author a=gson.fromJson(author,Author.class);
			int result=AuthorDao.insertAuthor(a);
			
			if(result>0)
			{
				return "Data Insertion Successfully";
			}
			else
			{
			   return "Data Insertion failed";	
			}
		}
	    
	    @Path("selectall")
	    @Produces(MediaType.APPLICATION_JSON)
	    @GET
	    public String getAllAuthor()
	    {
	    	List<Author> list=AuthorDao.getAllAuthor();
	    	return gson.toJson(list);
	    }
	    
	    @Path("getauthor")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@POST
		public String getAuthor(String aid)
		{
			int id=gson.fromJson(aid, Integer.class);
			Author a= AuthorDao.getAuthor(id);
			return gson.toJson(a);
		}
		
		
		@Path("update")
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.APPLICATION_JSON)
		@POST
		public String updateStudent(String author)
		{
			Author a=gson.fromJson(author, Author.class);
			int result=AuthorDao.updateAuthor(a);
			
			if(result>0)
			{
				return "Data Updates Successfully"; 
			}
			else {
				return "Data Updates Failed";
			}
		}
			
			@Path("delete")
			@Produces(MediaType.TEXT_PLAIN)
			@Consumes(MediaType.APPLICATION_JSON)
			@POST 
			public String deleteAuthor(String aid)
			{
				int id=gson.fromJson(aid, Integer.class);
				int result=AuthorDao.deleteAuthor(id);
				
				if(result>0)
				{
					return "Data deleted Successfully"; 
				}
				else {
					return "Data deletion Failed";
				}
			}

}
