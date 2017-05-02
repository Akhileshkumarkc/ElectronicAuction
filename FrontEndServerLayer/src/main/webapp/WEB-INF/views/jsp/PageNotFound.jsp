<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>404:oops url not found!!!</title>
<link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        
    </script>
 <style type="text/css">
#error1{
 padding-left: 350px;
 padding-bottom: 10px;
 }
 #error2{
  padding-left: 480px;
 padding-bottom: 10px;
 }
 </style>
</head>
<body>
<%@ include file="headerhome.jsp" %>

<h1 id="error1" >Oops!! Page not found!</h1>
<h3 id="error2">Error Code: 404</h3>
<center>
<a href="newuserlogin">Click here to login again!!!</a>
<img src="resources/images/404.gif" height="313px" width="428px">
</center>
<%@ include file="footer.jsp" %>
</body>
</html>