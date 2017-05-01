<!DOCTYPE html>
<!-- saved from url=(0054)http://bootsnipp-env.elasticbeanstalk.com/iframe/9XRdX -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import = "org.arrow.controller.UserController" %>
    
    <meta name="robots" content="noindex">

    <title>User Profile Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    
    <style type="text/css">
    .user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}
.toppad
{margin-top:20px;
}

    </style>
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
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body>
	<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">

        <a href="logout">Logout</a>
       <br>
<p class=" text-info">May 05,2014,03:00 pm </p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${userDetails.getUsername()} </h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="resources/images/user.jpg" class="img-circle img-responsive"> </div>
               
                <div class=" col-md-9 col-lg-9 "> 
                <center>
                <form action="editdetails" method="get">
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>FirstName:</td>
                        <td>${userDetails.getFirstName()}</td>
                      </tr>
                      <tr>
                        <td>LastName:</td>
                        <td>${userDetails.getLastName()}</td>
                      </tr>
                      <tr>
                        <td>User Address:</td>
                        <td>${userDetails.getUser_streetName()},&nbsp;${userDetails.getUser_houseNumber()},&nbsp;${userDetails.getUser_city()},<br>
                        ${userDetails.getUser_state()},&nbsp;${userDetails.getUser_pinCode()}</td>
                      </tr>
                      <tr>
                        <td>Shipping Address:</td>
                        <td>${userDetails.getShipping_streetName()},&nbsp;${userDetails.getShipping_houseNumber()},&nbsp;${userDetails.getShipping_city()},<br>
                        ${userDetails.getShipping_state()},&nbsp;${userDetails.getShipping_pinCode()}</td>
                      </tr>
                        <tr>
                        <td>PhoneNumber:</td>
                        <td>${userDetails.getPhoneNumber()}</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>${userDetails.getEmail()}</td>
                      </tr>
                      <tr>
                        <td>Last Login Time:</td>
                        <td>Under Construction </td>
                      <tr>
                     
                    </tbody>
                  </table>
                  <input type="submit" value="Edit Profile">
                  </form>
                  </center>
                </div>
              </div>
            </div>
                 
            
          </div>
        </div>
      </div>
    </div>
	


</body></html>