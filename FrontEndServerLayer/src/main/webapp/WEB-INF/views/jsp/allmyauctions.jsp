<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <meta name="robots" content="noindex">
    <%@ page import="java.util.*" %>
<%@ page import = "org.arrow.model.SimpleAuctionRequestModel" %>

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


</style>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort By
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><button onclick="sortTable_Name()">Name</button></li>
      <li><button onclick="sortTable_Date()">Date</button></li>
      <li><button onclick="sortTable_Price()">Price</button></li>
      <li><button onclick="sortTable_Category()">Category</button></li>
    </ul>
  	</div>
	</div>
<%
	List<SimpleAuctionRequestModel> products = (ArrayList<SimpleAuctionRequestModel>)request.getAttribute(responselist);
	for(SimpleAuctionRequestModel i : products){
	
%>
	<div class = "container">
		<center>
			<table width="100" id="product_table" cellpadding="10">
  				<tr>
    			<th align="center">Product</th>
   				<th align="center">Description</th>
   				<th align="center">Bid Ending Date</th>
   				<th align="center">Price</th>
   				<th align="center">Category</th>
  				</tr>
  				<tr>
    			<td><img src="5s.jpg" height="150" width="150"></td>
    			<td><b>Iphone 5s</b><br>Apple iPhone 5s 64GB (GSM Unlocked) 4G iOS Smartphone - Gold/Silver/Space Gray</td>
    			<td>2017/04/12</td>
    			<td>$210.00</td>
    			<td>Phone</td>
  				</tr>
  				<tr>
   				<td><img src="s7edge.jpg" height="150" width="150"></td>
    			<td><b>Samsung Galaxy s7 edge</b><br>Samsung Galaxy S7 Edge G935F 32 GB Factory Unlocked 4G LTE GSM Smartphone</td>
    			<td>2017/03/23</td>
    			<td>$301.00</td>
    			<td>Phone</td>
  				</tr>
  				<tr>
    			<td><img src="i7plus.jpg" height="150" width="150"></td>
    			<td><b>IPhone 7 plus</b><br>NEW Apple iPhone 7 PLUS 5.5" UNLOCKED 256GB RED 4G LTE GLOBAL GSM FULL WARRANTY</td>
    			<td>2016/12/03</td>
    			<td>$410.00</td>
    			<td>Phone</td>
  				</tr>
  				<tr>
    			<td><img src="mac.jpg" height="100" width="150"></td>
    			<td><b>Macbook Pro</b><br>Apple MacBook Pro 13" Laptop 2.53GHz / 4GB Memory / 500GB Drive / Yosemite</td>
    			<td>2017/04/12</td>
    			<td>$720.00</td>
    			<td>Laptop</td>
  				</tr>
  				<tr>
    			<td><img src="dell.jpg" height="100" width="150"></td>
    			<td><b>Dell Inspiron</b><br>New Dell Inspiron 15 15.6"HD i3-5015U 2.1GHz 4GBRAM 1TB HDD HDMI DVD-RW W10H 1Yr</td>
    			<td>2017/03/11</td>
    			<td>$520.00</td>
    			<td>Laptop</td>
  				</tr>
  				<tr>
    			<td><img src="hp.jpg" height="100" width="150"></td>
    			<td><b>HP Spectre X360</b><br>HP Spectre X360 13-4116DX 13.3" 2.5GHz i7 16GB 512GB IPS Touch Notebook/Tablet</td>
    			<td>2017/02/14</td>
    			<td>$635.00</td>
    			<td>Laptop</td>
  				</tr>
			</table>

	<%@ include file="header.jsp" %>
		
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