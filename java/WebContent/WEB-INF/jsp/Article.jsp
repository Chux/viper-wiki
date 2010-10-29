<%@page import="java.util.List"%>
<%@page import="viper.entities.Article"%>
<%@page import="viper.entities.ArticleDAO"%>
<%@page import="viper.viperSession"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	viperSession vSession = (viperSession)session.getAttribute("session");
	List<Article> allArticles = vSession.getAllArticles();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Articles</h2>
		<form action="ApiServlet" method="post">
			Title: <input type="text" name="title"/>
			Content: <input type="text" name="content"/>
			<input type="submit"/>
		</form>
	
	<ul>
<% for(Article a : allArticles) { %>
		<li>Title:  <%= a.getTitle()%></li> 
		<li>Content: <%= a.getContent()%> </li>
	
<% } %>
	
	</ul>

</body>
</html>