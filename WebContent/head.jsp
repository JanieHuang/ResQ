<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="logo">
	<img src="img/logo.png">
</div>
<div id="menubar">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/req">Requests</a></li>
		<li><a href="categories.html">Categories</a></li>
	</ul>
</div>
<div id="login">
	<ul>
		<li><c:if test="${user==null}">
				<a href="login.jsp" target="_blank">Log In</a>
			</c:if> <c:if test="${user!=null}">
			${user.username }
		</c:if></li>
		<li><c:if test="${user==null}">
				<a href="register.jsp" target="_blank">Register</a>
			</c:if> <c:if test="${user!=null}">
				<a href="${pageContext.request.contextPath}/logout">Log Out</a>
			</c:if></li>
	</ul>
</div>