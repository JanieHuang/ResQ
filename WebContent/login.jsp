<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>ResQ - Respond Quick</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="javascript.js"></script>
</head>

<body>

	<div id="container">
		<div id="head">
			<%@include file="head.jsp"%>
		</div>

		<div id="body">
			<div id="loginfields">
				<form action="${pageContext.request.contextPath}/login"
					method="post">
					<table>
						<tr>
							<td>User:</td>
							<td><input type="text" name="username"></input></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password"></input></td>
						</tr>
					</table>

					<input id="loginbutton" type="submit" value="Log In"></input>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
