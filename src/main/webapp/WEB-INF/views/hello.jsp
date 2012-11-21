<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Servlet3 Main</title>
</head>
<body>
	<h1>${applicationScope.message}</h1>
	<c:out value="${error}" />
	<form method="post" action="<c:url value="/hello/upload"/>"
		enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" />
	</form>

	<hr />
	<h2>Servlets</h2>
	<a href="<c:url value="/servlet1"/>">Servlet1</a>
	<br />
	<a href="<c:url value="/servlet2"/>">Servlet2</a>
	<br />
	<a href="<c:url value="/async"/>">Slow servlet</a>
	<br />
	<form method="post" action="<c:url value="/async"/>">
		<input type="number" placeholder="bid" name="price" /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>