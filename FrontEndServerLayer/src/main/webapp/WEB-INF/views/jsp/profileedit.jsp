<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "org.arrow.controller.UserController" %>
<%@ page import = "org.arrow.model.SimpleUserModel" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
#registration{
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>

    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        
    </script>
</head>
<body>
<%@ include file="header.jsp" %>
	<h3><center>Join here to BID your items</center></h3>
	<div id="registration">
	<center>
		<form action="profileedit" method="post">
		<table>
			<tr><td><h4>UserName </h4></td><td><input type="text" name="username" value="${userDetails.getUsername()}" readonly></td></tr>
			<tr><td><h4>FirstName </h4></td><td><input type="text" name="firstName" value="${userDetails.getFirstName()}"></td></tr>
			<tr><td><h4>LastName </h4></td><td><input type="text" name="lastName" value="${userDetails.getLastName()}"></td></tr>
			<tr><td><h4>Password </h4></td><td><input type="password" name="password" value="${userDetails.getPassword()}" readonly></td></tr>
			<tr><td><h4>Company </h4></td><td><input type="text" name="company" value="${userDetails.getCompany()}"></td></tr>
			<tr><td><h4>PhoneNumber </h4></td><td><input type="text" name="phoneNumber" value="${userDetails.getPhoneNumber()}"></td></tr>
			<tr><td><h4>Email </h4></td><td><input type="text" name="email" value="${userDetails.getEmail()}"></td></tr>
			<tr><td><h4>user StreetName </h4></td><td><input type="text" name="user_streetName" value="${userDetails.getUser_streetName()}"></td></tr>
			<tr><td><h4>User HouseNumber </h4></td><td><input type="text" name="user_houseNumber" value="${userDetails.getUser_houseNumber()}"></td></tr>
			<tr><td><h4>User City </h4></td><td><input type="text" name="user_city" value="${userDetails.getUser_city()}"></td></tr>
			<tr><td><h4>User State </h4></td><td><input type="text" name="user_state" value="${userDetails.getUser_state()}"></td></tr>
			<tr><td><h4>User PinCode </h4></td><td><input type="text" name="user_pinCode" value="${userDetails.getUser_pinCode()}"></td></tr>
			<tr><td><h4>Shipping StreetName </h4></td><td><input type="text" name="shipping_streetName" value="${userDetails.getShipping_streetName()}"></td></tr>
			<tr><td><h4>Shipping HouseNumber </h4></td><td><input type="text" name="shipping_houseNumber" value="${userDetails.getShipping_houseNumber()}"></td></tr>
			<tr><td><h4>Shipping City </h4></td><td><input type="text" name="shipping_city" value="${userDetails.getShipping_city()}"></td></tr>
			<tr><td><h4>Shipping State </h4></td><td><input type="text" name="shipping_state" value="${userDetails.getShipping_state()}"></td></tr>
			<tr><td><h4>Shipping PinCode </h4></td><td><input type="text" name="shipping_pinCode" value="${userDetails.getShipping_pinCode()}"></td></tr>
		</table>
			<input type="submit" value="Save Changes">
			<a href="profileview">Cancel</a>
		</form>
	</center>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>