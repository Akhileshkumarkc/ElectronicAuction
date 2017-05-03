<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <meta name="robots" content="noindex">
    <%@ page import="java.util.*" %>
        <%@ page import = "org.arrow.authenticate.SessionManagement" %>
<%@ page import = "org.arrow.model.SimpleAuctionListResponseModel" %>
<%@ page import = "org.arrow.model.SimpleAuctionResponseModel" %>


    <title>Products Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional Bootstrap theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
		/*for table*/
		table {
    		border-collapse: collapse;
    		width: 100%;
		}

		th, td {
    		padding: 8px;
    		text-align: left;
    		border-bottom: 1px solid #ddd;
		}
		th {
			height: 50px;
		}
tr:hover{
		background-color:lightgrey;
		}


</style>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
    <span class="caret"></span></button>
    <div class="dropdown-menu">
      <button onclick="sortTable_Name()">Name</button>
      <button onclick="sortTable_Date()">Date</button>
      <button onclick="sortTable_Price()">Price</button>
      <button onclick="sortTable_Category()">Category</button>
    </div>
  	</div>
	</div>
	

	<div class = "container">
		<center>
		<table width="100" id="product_table1" cellpadding="10">
  				<tr>
    			<th align="center">Product&nbsp;&nbsp;&nbsp;</th>
   				<th align="center">Description&nbsp;&nbsp;&nbsp;</th>
   				<th align="center">Bid Ending Date&nbsp;&nbsp;&nbsp;</th>
   				<th align="center">Price&nbsp;&nbsp;&nbsp;</th>
   				<th align="center">Category</th>
  				</tr>
  		</table>
		<%
	List<SimpleAuctionResponseModel> products = (ArrayList<SimpleAuctionResponseModel>)request.getAttribute("productDetails");
	for(SimpleAuctionResponseModel i : products){
    %>
		<form action="closebid" method="POST">
		<% String username=(String)session.getAttribute(SessionManagement.SessionUSER); %>
			<table width="100" id="product_table" cellpadding="10">
  				<tr>
    			<td><img src="<%=i.getImageURL() %>" height="150" width="150"></td>
    			<td><b><%=i.getProductName()%></b><br><%= i.getProductDescription()%></td>
    			<td><%=i.getAcutalEndDate()%></td>
    			<td><%=i.getStartingBid() %></td>
    			<td><%=i.getCategory() %></td>
    			<td> <input style="background-color: #3CB371" type="submit" value="Close Bid"></td>
  				</tr>
  				<input type="hidden" name="auctionid" value="<%=i.getAuctionid() %>">
  				<input type="hidden" name="bidprice" value="<%=i.getStartingBid() %>">
  				<%} %>
  				
  				</form>
  				</table>
  				

	<%@ include file="footer.jsp" %>
		
	<script>
	function sortTable_Name() {
 	 var table, rows, switching, i, x, y, shouldSwitch;
  	table = document.getElementById("product_table");
  	switching = true;
  
  while (switching) {
    switching = false;
    rows = table.getElementsByTagName("TR");
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}

	function sortTable_Date() {
 	 var table, rows, switching, i, x, y, shouldSwitch;
  	table = document.getElementById("product_table");
  	switching = true;
  
  while (switching) {
    switching = false;
    rows = table.getElementsByTagName("TR");
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[2];
      y = rows[i + 1].getElementsByTagName("TD")[2];
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}

	function sortTable_Price() {
 	 var table, rows, switching, i, x, y, shouldSwitch;
  	table = document.getElementById("product_table");
  	switching = true;
  
  while (switching) {
    switching = false;
    rows = table.getElementsByTagName("TR");
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[3];
      y = rows[i + 1].getElementsByTagName("TD")[3];
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}

	function sortTable_Category() {
 	 var table, rows, switching, i, x, y, shouldSwitch;
  	table = document.getElementById("product_table");
  	switching = true;
  
  while (switching) {
    switching = false;
    rows = table.getElementsByTagName("TR");
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[4];
      y = rows[i + 1].getElementsByTagName("TD")[4];
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>

</body>
</html>