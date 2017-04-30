<!DOCTYPE html>
<!-- saved from url=(0054)http://bootsnipp-env.elasticbeanstalk.com/iframe/9XRdX -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="robots" content="noindex">

    <title>User Profile Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./bootstrap.min(1).css" rel="stylesheet" id="bootstrap-css">
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
    <script src="./jquery-1.10.2.min.js"></script>
    <script src="./bootstrap.min(2).js"></script>
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
           <a href="http://bootsnipp-env.elasticbeanstalk.com/iframe/edit.html">Edit Profile</a>

        <a href="http://bootsnipp-env.elasticbeanstalk.com/iframe/edit.html">Logout</a>
       <br>
<p class=" text-info">May 05,2014,03:00 pm </p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Aravind Chowdary</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="resouces/images/User Pic" src="user.jpg" class="img-circle img-responsive"> </div>
               
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>FirstName:</td>
                        <td>----</td>
                      </tr>
                      <tr>
                        <td>LastName:</td>
                        <td>----</td>
                      </tr>
                      <tr>
                        <td>Address:</td>
                        <td>----</td>
                      </tr>
                   
                         <tr>
                             </tr><tr>
                        <td>Company:</td>
                        <td>----</td>
                      </tr>
                        <tr>
                        <td>PhoneNumber:</td>
                        <td>----</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>----</td>
                      </tr>
                        <tr><td>Last Login Location:</td>
                        <td>----</td>
                      </tr>
                      <tr>
                        <td>Last Login Time:</td>
                        <td>----</td>
                      <tr>
                     
                    </tbody>
                  </table>
                  
                  <a href="/Users/aravindchowdary/Desktop/itempage_files/items.html" class="btn btn-primary">Go to Bid</a>
                  <a href="/Users/aravindchowdary/Desktop/itempage_files/items.html" class="btn btn-primary">Go to Cart</a>
                </div>
              </div>
            </div>
                 
            
          </div>
        </div>
      </div>
    </div>
	


</body></html>