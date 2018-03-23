<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

<script type="text/javascript">
function result()
{
	
}

</script>


<div class="container">

	<h1 align="center">List of Jobs</h1>
	
	
	<% 
	System.out.println("JSP : "+ request.getSession().getAttribute("msg"));
	if(request.getSession().getAttribute("msg")!=null)
	{
	if(request.getSession().getAttribute("msg").equals("success"))
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
    
	
		<c:forEach items="${messages}" var="message">
		
			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<!--  <button type="button" class="close" aria-hidden="true">&times;</button> -->
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
        
            					<p> Percentage : ${message.percentage} </p>
								<p> Year : ${message.year} </p>
								<p> Qualification : ${message.degree} </p>
								<p> Branch : ${message.branch} </p>
            					</div>
            					<div class="col-md-6">
            						<p> Designation : ${message.designation} </p>
								<p> Address : ${message.address} </p>
						
								<p> Profile : ${message.profile} </p>
					  			<p> Salary : ${message.salary} </p>
            					</div>
        					</div> 
          					
							
      					</div>
      					<div class="panel-footer">
	  							<form action=apply.do method="post">
      							<input type="hidden" value='${message.jid}' name="jid" />
      				
								<button type="submit" id="apply" class="btn btn-primary col-md-offset-11" >Apply</button>
								</form>
      					
      					</div>
  					</div>
				</div>
			</div>
             
			</c:forEach>
		</div>
			
			


<%@include file="/common/footer.jspf"%>