<%@include file="/common/header.jspf" %>
<%@include file="/common/recruiter_navbar.jspf" %>
 
 <div class="container">
 
 <H1>Edit Profile</H1>
 
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
 

 
 	<form action="editrecruiter.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			Name:<input type="text" class="form-control" name="name" placeholder="Full Name" required="" autofocus="" value="${recruiter.name}" />
			Current Location:<input type="text" class="form-control" name="location" placeholder="current location" required="" autofocus="" value="${recruiter.location}" />
            Industry:<input type="text" class="form-control" name="industry" placeholder="industry" required="" autofocus="" value="${recruiter.industry}" />
			E-Mail:<input type="text" class="form-control" name="email" placeholder="e-mail" required="" autofocus="" value="${recruiter.email}" />
			<br><br>
			    	      
      <button id="save" class="btn btn-lg btn-primary btn-block" type="save">Save</button>
      <button id="class" class="btn btn-lg btn-secondary btn-block" type="cancel">Cancel</button> 
			    	
	</form>
 </div>
 
 <!--<@include file="/common/footer.jspf" %>  -->
 
 