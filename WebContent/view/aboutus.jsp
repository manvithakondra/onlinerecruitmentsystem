<%@include file="/common/header.jspf" %>
<%@include file="/common/recruiter_navbar.jspf" %>

	<div class="container">
 
 	<form action="about.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			Company Name:<input type="text" class="form-control" name="company" placeholder="Company Name" required="" autofocus="" />
			Address:<textarea class="form-control" name="address" id="address" placeholder="address" required="" autofocus="">  </textarea>
		    Description:<textarea class="form-control" name="description" id="description" placeholder="description" required="" autofocus="">  </textarea>   <br> 	      
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Update</button> 
			    	
	</form>
 </div>
<%@include file="/common/footer.jspf" %>