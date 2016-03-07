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
			<div id="body">
				<div id="postnewthread">
					<form action="${pageContext.request.contextPath}/req" method="post">
						<table>
							<tr>
								<td>Title:</td>
								<td><input type="text" name="topic"></input></td>
							</tr>
							<tr>
								<td id="descriptionlabel">Description:</td>
								<td><textarea rows="8" cols="80" name="description"></textarea></td>
							</tr>
							<tr>
								<td>Location:</td>
								<td><input type="text" name="address"></input> or
									<button type="button">Get Location</button></td>
							</tr>
							<tr>
								<td colspan="2"><input id="postrequestbutton" type="submit"
									value="Post this request"> <a
									href="${pageContext.request.contextPath}/req"><button
											id="postrequestbutton" type="button">Cancel</button></a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
