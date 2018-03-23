<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
  function idea(){
	  alert("Thank You for your Feedback!!");
  }
  
</script>
</head>
<body style="background-color:PeachPuff;">
  <h1 align="center" style="color:blue;">Submit an Idea !</h1>
  <center>
    <textarea rows=20 cols=100></textarea><br>
    <button class="btn btn-primary" type="submit" onClick="idea();">submit</button> 
  
  </center>
<%@include file="/common/footer.jspf" %>