<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<div id="registrationfields">
				<form name=registrationform
					action="${pageContext.request.contextPath}/reg" method="post">
					<table>
						<tr>
							<td>User name:</td>
							<td><input type="text" name="username" required
								pattern=".{2,}"></input></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" required
								pattern=".{6,}"></input></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><input type="email" name="email" required
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"></input></td>
						</tr>
					</table>

					<input id="registerbutton" type="submit" value="Register"></input>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
