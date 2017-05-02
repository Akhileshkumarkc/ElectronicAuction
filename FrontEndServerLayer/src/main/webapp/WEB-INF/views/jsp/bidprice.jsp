<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bid Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    
</head>
<body>
<%@ include file="header.jsp" %>
<center>
<form action="sendprice" method="post">
<label>Enter your Bid Price:</label>
	<input type="number" name="newprice"><br><br>
	<p>${bidprice1}</p>
	<input type="submit" value="submit">
	<input type="hidden" name="auctionid" value="${auctionid}">
	<input type="hidden" name="oldprice" value="${bidprice1}">
</form>
</center>
<%@ include file="footer.jsp" %>
</body>
</html>