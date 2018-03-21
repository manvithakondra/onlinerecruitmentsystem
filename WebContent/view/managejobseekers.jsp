<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/header.jspf" %>
<%@include file="/common/admin_navbar.jspf" %>	

<div class="container">
	<h1 align="center">JOBSEEKERS</h1>
	
		<c:forEach items="${update}" var="update">
			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<button type="button" class="close" aria-hidden="true">&times;</button>
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
            				    <p> Name : ${update.name} </p>
								<p> Location : ${update.location} </p>
								<p> DateOfBirth : ${update.dateofbirth} </p>
								<p> Gender : ${update.gender} </p>
            					</div>
            					<div class="col-md-6">
            					<p>Percentage  : ${update.percentage} </p>
								<p>Branch : ${update.branch} </p>
								<p>KeySkills : ${update.keyskills} </p>
					  			<p>Experience : ${update.experience}</p>
					  			<p>Email : ${update.email}</p>
            					</div>
        					</div> 
          					
							
      					</div>
      					<div class="panel-footer">
      					
      							<form action=apply.do method="post">
      							<input type="hidden" value='${message.jid}' name="jid" />
								<button type="submit" id="apply" class="btn btn-primary col-md-offset-11">Apply</button>
								</form>
							</div>	
      					
      					</div>
  					</div>
				</div>
						</c:forEach>
			
			</div>



<%@include file="/common/footer.jspf" %>