<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

<script type="text/javascript">
$('submit').click(function () {
	  if ($('#password').val() == $('#confirm_password').val()) {
	    $('#message').html('Matching').css('color', 'green');
	  } else 
	    $('#message').html('Not Matching').css('color', 'red');
	});
</script>

 
 <div class="container">
 
 <H1>Change Password</H1>
 
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
 
 	<form action="account-update.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			Old Password:<input type="password" class="form-control" id="old_password"  name="old_password" placeholder="old password" required=""/>
			New Password:<input type="password" class="form-control" id="new_password"  name="new_password" placeholder="new password" required=""/>
			Confirm Password:<input type="password" class="form-control" name="confirm_password"  id="confirm_password" placeholder="confirm password" required=""/>
		<br><br>	
			    	      
      <button id="set" class="btn btn-lg btn-primary btn-block" type="submit">Set New Password</button> 
	  <button id="can" class="btn btn-lg btn-secondary btn-block" type="submit">Cancel</button> 
	  	    	
	</form>
 </div>
 
 <%@include file="/common/footer.jspf" %>
 