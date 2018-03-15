<%@include file="/common/header.jspf" %>
<%@include file="/common/nav_login.jspf" %> 

<script type="text/javascript">
$('submit').click(function () {
	  if ($('#password').val() == $('#confirm_password').val()) {
	    $('#message').html('Matching').css('color', 'green');
	  } else 
	    $('#message').html('Not Matching').css('color', 'red');
	});
</script>

 
 <div class="container">
 

 
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
 

 
 	<form action="register.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			<input type="text" class="form-control" name="name" placeholder="Name" required="" autofocus="" />
			<input type="text" class="form-control" name="fullname" placeholder="Full Name" required="" autofocus="" />
			<input type="text" class="form-control" name="email" placeholder="Email ID" required="" autofocus="" />
			<input type="password" class="form-control" id="password"  name="password" placeholder="Password" required=""/>
			<input type="password" class="form-control" name="confirm_password"  id="confirm_password" placeholder="Confirm Password" required=""/>
			<select class="form-control" name="type" id="type" placeholder="select option">
			     <option value=""></option>
                 <option value="adm">Admin</option>
                 <option value="rec">Recruiter</option>
                 <option value="js">Jobseeker</option>
                 </select>   
			    	      
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Register</button> 
			    	
	</form>
 </div>
 
 <%@include file="/common/footer.jspf" %>
 