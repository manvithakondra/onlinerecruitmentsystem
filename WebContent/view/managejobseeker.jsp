
<%@include file="/common/header.jspf" %>
<%@include file="/common/admin_navbar.jspf" %>

<div class="container">
 <h1 align="center">JOB SEEKERS</h1>
 
<<<<<<< HEAD
 <!--  <c:forEach items="${jobseeker}" var="j">-->
=======
    <!--   <c:forEach items="${u}" var="u">-->
>>>>>>> branch 'master' of https://github.com/manvithakondra/onlinerecruitmentsystem.git
			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
<<<<<<< HEAD
            					<p> Name : ${jobseeker.name} </p>
								<p> Location : ${jobseeker.location} </p>
								<p> DateOfBirth : ${jobseeker.dateofbirth} </p>
								<p> Gender : ${jobseeker.gender} </p>
=======
          
								<p> Location : ${jobseeker.location} </p>
								<p> DateOfBirth : ${jobseeker.dateofbirth} </p>
								<p> Gender : ${jobseeker.gender} </p>
            					<p> Percentage : ${jobseeker.percentage} </p>
>>>>>>> branch 'master' of https://github.com/manvithakondra/onlinerecruitmentsystem.git
            					</div>
            					<div class="col-md-6">
<<<<<<< HEAD
            					<p> Percentage : ${jobseeker.percentage} </p>
=======
            					
>>>>>>> branch 'master' of https://github.com/manvithakondra/onlinerecruitmentsystem.git
								<p> Branch : ${jobseeker.branch} </p>
	                            <p> KeySkills : ${jobseeker.keyskills} </p>					
								<p> Experience : ${jobseeker.experience}  </p>
					  			<p> E-mail : ${jobseeker.email} </p>
            					</div>
        					</div> 
          					
							
      					</div>
      					
      					</div>
  					</div>
				</div>
			<!--     </c:forEach>-->
</div>
	
<%@include file="/common/footer.jspf" %>