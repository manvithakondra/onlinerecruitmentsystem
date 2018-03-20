<%@include file="/common/header.jspf" %>
<%@include file="/common/recruiter_navbar.jspf" %>
<br>
<br>
	<div class="container">
	<% 
	
	if(request.getAttribute("msg")!=null)
	{
	if(request.getAttribute("msg").equals("success"))
	{
		%>
		<div class="alert alert-success alert-dismissible fade in">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong> ${success}
	</div>
	<%
	}
	else
	{
	%>
		<div class="alert alert-danger alert-dismissible fade in">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>Error!</strong> ${error}
	</div>
	<%
	}
	}
		
		%>
 
  		
 	<form action="about.do" method="post" class="form-signin">
		
			Company Name:<input type="text" class="form-control" name="company" value="hyderabad" placeholder="Company Name" required="" autofocus="" />
			Address:<input type="text" class="form-control" name="address" id="address" value="hyderabad" required="" autofocus="" />
		    Description:<textarea class="form-control" name="description" id="description" value="hyderabad" placeholder="description" required="" autofocus="">  </textarea>   <br> 	      
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Update</button> 
			    	
	</form>
 </div>

<%@include file="/common/footer.jspf" %>