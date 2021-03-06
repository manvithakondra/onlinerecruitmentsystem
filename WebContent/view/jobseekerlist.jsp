<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

<div class="container">
 <h1 align="center">List of JobSeekers Applied</h1>
 

       <c:forEach items="${jobseeker}" var="jobseeker1">

			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
                                <p> Name : ${jobseeker1.name} </p>
								<p> Location : ${jobseeker1.location} </p>
								<p> DateOfBirth : ${jobseeker1.dateofbirth} </p>
								<p> Gender : ${jobseeker1.gender} </p>
            					<p> Percentage : ${jobseeker1.percentage} </p>
          
            					</div>
            					<div class="col-md-6">
								<p> Branch : ${jobseeker1.branch} </p>
	                            <p> KeySkills : ${jobseeker1.keyskills} </p>					
								<p> Experience : ${jobseeker1.experience}  </p>
					  			<p> E-mail : ${jobseeker1.email} </p>
            					</div>
        					</div> 
          					
							
      					</div>
      					
      					</div>
  					</div>
				</div>
			     </c:forEach>
</div>
	
<%@include file="/common/footer.jspf" %>