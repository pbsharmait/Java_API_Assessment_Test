package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Author;
import com.util.AuthorUtil;

public class AuthorDao {
	
		public static int insertAuthor(Author a)
		{
			System.out.println("DAO");
			int result=0;
			try {
				Connection conn=AuthorUtil.createConnection();
				String sql="insert into rest_author (tname,aname) values(?,?)";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,a.getTname());
				pst.setString(2,a.getAname());
				result=pst.executeUpdate();
			} catch (Exception e) {
            e.printStackTrace();
			}
			return result;
		}
		
		public static int updateAuthor(Author a)
		{
			
			int result=0;
			try {
				Connection conn=AuthorUtil.createConnection();
				String sql="update rest_author set tname=?,aname=? where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1,a.getTname());
				pst.setString(2,a.getAname());
				pst.setInt(3,a.getId());
				result=pst.executeUpdate();
			} catch (Exception e) {
            e.printStackTrace();
			}
			return result;
		}
		
		
		public static int deleteAuthor(int id)
		{
			
			int result=0;
			try {
				Connection conn=AuthorUtil.createConnection();
				String sql="delete from rest_author where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1,id);
			
				result=pst.executeUpdate();
			} catch (Exception e) {
            e.printStackTrace();
			}
			return result;
		}
		
		
		
		
		public static List<Author> getAllAuthor()
		{
			List<Author> list=new ArrayList<Author>();
			try {
				Connection conn=AuthorUtil.createConnection();
				String sql="select * from rest_author";
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while (rs.next())
				{
				Author a=new Author();
				a.setTname(rs.getString("tname"));
				a.setAname(rs.getString("aname"));
				list.add(a);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
			return list;
		}
		public static Author getAuthor(int id)
		{
				Author a=null;
			try {
				Connection conn=AuthorUtil.createConnection();
				String sql="select * from rest_author where id=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				while (rs.next())
				{
				a=new Author();
				a.setTname(rs.getString("tname"));
				a.setAname(rs.getString("aname"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
			return a;
		}
		
		

}
