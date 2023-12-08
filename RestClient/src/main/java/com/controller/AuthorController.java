package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.bean.Author;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@WebServlet("/AuthorController")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String WebURL="http://localhost:8081/RestServer/";
    ClientConfig clientConfig=null;
    Client client=null;
    Gson gson=new Gson();
    WebTarget target=null;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Response rs=target.path("author").path("selectall").request().get();		
	String result=rs.readEntity(String.class);
	if (rs.getStatus()==200)
	{
		List<Author> list=gson.fromJson(result, new TypeToken<List<Author>>() {}.getType());
	   request.getRequestDispatcher("show.jsp").forward(request, response);	
	} 
	else
	{
		System.out.println("server Error");
	}
     
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	clientConfig = new ClientConfig();
	client = ClientBuilder.newClient(clientConfig);
	target= client.target(WebURL).path("rest");
	String action=request.getParameter("action");
	
	if(action.equalsIgnoreCase("insert")) 
	{
		Author a=new Author();
		a.setAname(request.getParameter("aname"));
		a.setTname(request.getParameter("tname"));
		String author=gson.toJson(a);
		Response rs=target.path("author").path("insert").request().post(Entity.json(author));
		String result = rs.readEntity(String.class);
		System.out.println(result);
		if (rs.getStatus()==200)
		{
		showAll(request, response);	
		}
		else 
		{
			System.out.println(result);
		}
	}
	
	else if (action.equalsIgnoreCase("edit")) {
	
	int id=Integer.parseInt(request.getParameter("id"));
	   String aid=gson.toJson(id);
	   Response rs=target.path("author").path("getauthor").request().post(Entity.json(aid));
	   String result = rs.readEntity(String.class);
	   if(rs.getStatus()==200)
	   {
		   Author a=gson.fromJson(result, Author.class);
		   request.setAttribute("a", a);
		   request.getRequestDispatcher("update.jsp").forward(request, response);
	   }
	   else 
	   {
		   System.out.println("Server Error");
	   }

	}
	else if (action.equalsIgnoreCase("update"))
    {
 	   Author a=new Author();
 	    a.setAname(request.getParameter("aname"));
		a.setTname(request.getParameter("tname"));
 	   String author=gson.toJson(a);
 	   Response rs=target.path("author").path("update").request().post(Entity.json(author));
 	   String result=rs.readEntity(String.class);
 	   System.out.println(result);
 	   if(rs.getStatus()==200)
 	   {
 		   showAll(request, response);
 	   }
 	   else {
			
 		   System.out.println(result);
		}  
    }
	else if (action.equalsIgnoreCase("delete"))
	{
		int id=Integer.parseInt(request.getParameter("id"));
 	   String aid=gson.toJson(id);
 	   Response rs=target.path("author").path("delete").request().post(Entity.json(aid));
 	   String result = rs.readEntity(String.class);
 	   if(rs.getStatus()==200)
 	   {
 		   showAll(request, response);  
 	   }
 	   else
 	   {
 		   System.out.println(result);
		   }
 	   
 	   
	   }
	}
	
	}
	


