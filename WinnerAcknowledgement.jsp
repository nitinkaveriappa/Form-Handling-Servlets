<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<!--Nitin Kaveriappa Udiyanda Muthanna G01000006 -->
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="description" content="Homework 1">
	<meta name="author" content="Nitin Kaveriappa Udiyanda Muthanna">
	<title>SWE642 HW4</title>
	<link href="css/hw.css" rel="stylesheet" type="text/css">
	<link href="css/jquery-ui.css" rel="stylesheet">
	<script src="js/script.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script>
	$( function() {
			 $( "#tooltip" ).tooltip();
		 } );
	</script>
</head>
<body>
	<div class="container">
	<header>
	<h1>SWE-642 Assignment</h1>
	<h1>Computer Science Department Survery</h1>
	</header>
	<hr>
	<a href="index.html">Main Page</a>
	&nbsp;
	<a href="home.html">CS Dept. Homepage</a>
	<div style="color:blue;text-decoration:underline;display:inline;cursor:pointer;float:right" onclick="callRenewSet()">Change User</div>
	<hr>
	<div class="main">
		<div>
	    <p>Your data has been saved. <br/>
	    	Congrats! You won two movie tickets<br/>
	    	Mean = ${cData.mean} <br/>
	    	Standard Deviation = ${cData.deviation} 
	    </p>
	     <% ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("list"); %> 
	    <ol>
	    <% for(Integer sid : list) 
	    {
	    	out.print("<li><a href=\'/SWE642HW4/SubmitServlet?id="+sid.intValue()+"\'>"+sid.intValue()+"</a></li>");
	    }
	     %>
	    </ol>
    	</div>
	</div>
	<div class="err" style="display:none"></div>
	<hr>
	<footer>&copy; 2017 Nitin Kaveriappa</footer>
	</div>
</body>
<div class="logo" id="tooltip">
  	<a href="https://www2.gmu.edu/" title="Please visit http://www.gmu.edu for more information." target="_blank"><img src="images/logo.jpg" alt="Mason Logo" style="width:250px;height:175px;"></a>
</div>
</html>
