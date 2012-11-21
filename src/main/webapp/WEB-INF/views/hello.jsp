<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Upload a pdf please</title>
</head>
<body>
	<h1>Please upload a pdf</h1>
	<c:out value="${error}" />
	<form method="post" action="<c:url value="/hello/upload"/>"
		enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" />
	</form>
</body>
</html>