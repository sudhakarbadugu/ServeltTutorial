<jsp:include page="header.jsp" />
<div class="text text-success">
    <h1>This is staging directory.</h1>
</div>

<div>
    <form action="download">
    <input type="checkbox" name="file1" value="attp-report-1.txt"> attp-report-1.txt
    <input type="checkbox" name="file2" value="attp-report-2.txt"> attp-report-2.txt
    <input type="checkbox" name="file3" value="attp-report-3.txt"> attp-report-3.txt
    <input type="checkbox" name="file4" value="attp-report-4.txt"> attp-report-4.txt	<br>
    <button class="btn btn-primary">Download</button>
</form>
</div>

<div>
<form method="post" class="form-inline" action="upload" enctype="multipart/form-data">
	<input type="file" name="upload">           
	<button class="btn btn-primary">Upload</button>
</form>
<a href="pwelcome">Back</a>
</div>
<%@ include file="footer.html" %>