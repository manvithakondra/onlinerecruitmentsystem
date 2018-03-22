<%@include file="/common/header.jspf" %>
<%@include file="/common/admin_navbar.jspf" %>

<div class="container">
 <h1 align="center">JOB SEEKERS</h1>
 
 <c:forEach items="${jobseeker}" var="j">
			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<button type="button" class="close" aria-hidden="true">&times;</button>
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
            					<p> Name : ${j.name} </p>
								<p> Location : ${j.location} </p>
								<p> DateOfBirth : ${j.dateofbirth} </p>
								<p> Gender : ${j.gender} </p>
            					</div>
            					<div class="col-md-6">
            					<p> Percentage : ${j.percentage} </p>
								<p> Branch : ${j.branch} </p>
	                            <p> KeySkills : ${j.keyskills} </p>					
								<p> Experience : ${j.experience}  </p>
					  			<p> E-mail : ${j.email} </p>
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