<!DOCTYPE html>
<jsp:include page="header.jsp" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<button>Create parser</button>
<h2>List of parsers<h2></h2>
<table border="1px">
	<tr><th>Parse name</th><th>File name</th><th>Client name</th></tr>
	<tr><td>ATNT-parse</td><td>report.txt</td><td>winstream</td></tr>
	<tr><td>2</td><td>report2</td><td>jlljl</td></tr>
</table>

<h3>Staged files</h3>

<div>
    <form action="downloadopgen">
    <input type="checkbox" name="file1" value="attp-report-1"> Attp-report-1
    <input type="checkbox" name="file2" value="attp-report-1"> attp-report-2
    <input type="checkbox" name="file3" value="attp-report-1"> attp-report-3
    <input type="checkbox" name="file4" value="attp-report-1"> attp-report-4	<br>
    <button class="btn btn-primary">downloadopgen</button> <br>
</form>
</div>
<div>
<form action="upload">
	<button class="btn btn-success">Upload</button>
	<br><br>
	<input type="file" name="upload">
</form>
	<a href=pwelcome>Back</a>
</div>

</body>
</html>
<%@ include file="footer.html" %>