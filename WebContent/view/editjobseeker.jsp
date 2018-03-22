<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

 <div class="container-fluid">
 
  
 	<form action="editjobseeker.do" method="post" class="form-signin">
	   <H1>Update Profile</H1>
		<p>
			<font color="red">${error}</font>
		</p>
			Name:<input type="text" class="form-control" name="fullname" placeholder="Full Name" required="" autofocus="" value="${jobseeker.name}" />
			Current Location:<input type="text" class="form-control" name="location" placeholder="current location" required="" autofocus="" value="${jobseeker.location}" />
			DateOfBirth:<input type="text" class="form-control" name="dob" placeholder="Date Of Birth" required="" autofocus="" value="${jobseeker.dateofbirth}" />
            Gender:<input type="text" class="form-control" name="gender" placeholder="Gender" required="" autofocus="" value="${jobseeker.gender}" />
            Percentage:<input type="text" class="form-control" name="percentage" placeholder="Percentage" required="" autofocus="" value="${jobseeker.percentage}" />
            Branch:<input type="text" class="form-control" name="branch" placeholder="Branch" required="" autofocus="" value="${jobseeker.branch}" />
            Key Skills:<input type="text" class="form-control" name="keyskills" placeholder="Key Skills" required="" autofocus="" value="${jobseeker.keyskills}" />
            Total Experience:<input type="text" class="form-control" name="experience" placeholder="Experience" required="" autofocus="" value="${jobseeker.experience}" />
            E-Mail:<input type="text" class="form-control" name="email" placeholder="e-mail" required="" autofocus="" value="${jobseeker.email}" />
			<br><br>
			    	      
      <button id="save" class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
      <button id="class" class="btn btn-lg btn-secondary btn-block" type="cancel">Cancel</button> 
	</form>
 </div>
 
 <!--<@include file="/common/footer.jspf" %>  -->
 
 