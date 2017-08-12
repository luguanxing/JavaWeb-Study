package hw05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class comments {
	String comment;
	String author;
	String date;
	String querykey;
	String deletekey;
	
	StringBuffer addmessage;
	StringBuffer deletemessage;
	StringBuffer queryResultByAll;
	StringBuffer queryResultByCondition;
	
	public comments() {
		queryResultByAll = new StringBuffer();
		queryResultByCondition = new StringBuffer();
		try { 
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			//生成驱动对象实例
		} 
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuerykey() {
		return querykey;
	}
	public void setQuerykey(String querykey) {
		this.querykey = querykey;
	}
	public String getDeletekey() {
		return deletekey;
	}
	public void setDeletekey(String deletekey) {
		this.deletekey = deletekey;
	}

	
	public StringBuffer getQueryResultByAll() {
		String condition="SELECT * FROM comments";
		queryResultByAll=mysql_get(condition);
		return queryResultByAll;
	}
	public StringBuffer getQueryResultByCondition() {
		String condition="SELECT * FROM comments WHERE COMMENT LIKE '%"+ querykey +"%' or author LIKE '%"+ querykey +"%'";
		queryResultByCondition=mysql_get(condition);
		return queryResultByCondition;
	}
	public StringBuffer getAddmessage() {
		String condition="INSERT INTO `comments` (`comment`, `author`, `date`) VALUES('"+comment+"','"+author+"','"+date+"')";
		addmessage = mysql_add(condition);
		return addmessage;
	}

	public StringBuffer getDeletemessage() {
		String condition="DELETE FROM `db_comments`.`comments` WHERE `id`='"+deletekey+"'";
		deletemessage = mysql_delete(condition);
		return deletemessage;
	}
	
	private StringBuffer mysql_add(String condition) {
	      StringBuffer str=new StringBuffer();
	      Connection con;
	      Statement sql; 
	      ResultSet rs;
	      try {
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_comments","root","12345a");
	           sql=con.createStatement();
	           int m = sql.executeUpdate(condition);
               if(m==0) {
                 str.append("增加记录失败");
               }
	           con.close();
	      } catch(SQLException e) {
	    	  str.append(e); 
	      }
	      return str;
	}
	
	private StringBuffer mysql_delete(String condition) {
	      StringBuffer str=new StringBuffer();
	      Connection con;
	      Statement sql; 
	      ResultSet rs;
	      try {
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_comments","root","12345a");
	           sql=con.createStatement();
	           //这里就懒得判断失败了
	           int m = sql.executeUpdate(condition);
               if(m==0) {
                 str.append("删除记录失败");
               }
	           con.close();
	      } catch(SQLException e) {
	    	  str.append(e); 
	      }
	      return str;
	}
	
	private StringBuffer mysql_get(String condition) {
	      StringBuffer str=new StringBuffer();
	      Connection con;
	      Statement sql; 
	      ResultSet rs;
	      try {
	    	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_comments","root","12345a");
	           sql=con.createStatement();
	           rs=sql.executeQuery(condition);
	           str.append("<table border=1>");
	           str.append("<th width=100>"+"编号");
	           str.append("<th width=100>"+"内容");
	           str.append("<th width=100>"+"作者");
	           str.append("<th width=100>"+"日期");
	           while(rs.next()){
	              str.append("<tr>");
	              str.append("<td>"+rs.getString(1)+"</td>");
	              str.append("<td>"+rs.getString(2)+"</td>");
	              str.append("<td>"+rs.getString(3)+"</td>");
	              str.append("<td>"+rs.getString(4)+"</td>");
	              str.append("</tr>");
	           }
	           str.append("<table border=1>");
	           con.close();
	      } catch(SQLException e) {
	    	  str.append(e); 
	      }
	      return str;
	}
}
