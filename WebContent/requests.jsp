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
			<div id="addnewthreadbutton">
				<a href="${pageContext.request.contextPath}/newrequest.jsp">+ Create new request</a>
			</div>

			<c:forEach var="entry" items="${post}">
				<div class="thread">

					<div class="threadhead">
						<div class="threadtitle">${entry.topic }</div>
						<div class="author">
							${entry.appUser.username }<img src="img/verified.png">
						</div>
					</div>

					<div class="threadbody">
						<div class="threadcontent">${entry.description }</div>
					</div>

					<div class="threadfooter">
						<div class="buttons">
							<a href="" onClick="generateCommentSection(); return false;"><img
								src="img/comment.png"></a> <a href="shareLocation.html"
								target="_blank" id="location"><img
								src="img/location.png" class="share"></a> <img
								src="img/running.png">
						</div>
						<div id="popupcontent" class="popupcontent"></div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>
