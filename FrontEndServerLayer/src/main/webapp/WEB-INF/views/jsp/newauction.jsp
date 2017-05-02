<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <meta name="robots" content="noindex">
    <%@ page import = "org.arrow.authenticate.SessionManagement" %>
    

    <title>Products Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
    	th, td { 
    		padding: 20px;
            color: #003264;
    			 }
    	body  {
    		background-image: url("resources/images/bg.jpg");
		}
    </style>
    </head>
    <body>
    	<%@ include file="header.jsp" %>
    	<% String username=(String)session.getAttribute(SessionManagement.SessionUSER); %>
    	<center>
    	<h3 style="color: green">Enter your product details</h3><br><br>
    	<form action="newauction" id="auctionform" method="POST">
    	  <input type="hidden" name="username" value=<%=username %>>
    		<table cellspacing="10" style="background-color: #E8E8E8">
    		<tr><td><h4>Product Name </h4></td><td><input type="text" name="productName" required="true" autofocus="true"></td></tr>
    		<tr><td><h4>Product Description </h4></td><td><input type="text" name="productDescription" maxlength="75" required="true" style="width: 300px; height: 100px"></td></tr>
    		<tr><td><h4>Product Category </h4></td><td><input type="text" name="category" required="true"></td></tr>
    		<tr><td><h4>Initial Bid Price </h4></td><td><input type="number" name="startingBid" required="true"></td></tr>
    		<tr><td><h4>Auction End Date </h4></td><td><input type="date" name="actualEndDate" required="true"></td></tr>
    		<tr><td><h4>Image Url for Product </h4></td><td><input type="text" name="imageURL" required="true"></td></tr>
    		</table><br>
    		<input type="submit" value="submit">
    	</form>
    	</center>
    	<%@ include file="footer.jsp" %>
    </body>
    </html>