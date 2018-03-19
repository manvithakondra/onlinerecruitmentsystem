<%@include file="/common/header.jspf" %>
<header>
		<nav class="navbar navbar">
		<a href="#"class="navbar-brand"><img src="images/logo.png" height=70 /></a>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				         style="font-size:100%;">Jobs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Job by Location</a></li>
						<li><a href="#">Job by Skill</a></li>
						<li><a href="#">Job by Designation</a></li>
						<li><a href="#">Job by Category</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				        style="font-size:100%;">Recruiters<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">All Recruiters</a></li>
						<li><a href="#">Recruiters by Location</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				          style="font-size:100%;">Companies<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">About Companies</a></li>
						<li><a href="#">Write review for a Company</a></li>
						<li><a href="#">Sample Papers</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				          style="font-size:100%;">Services<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Help</a></li>
						<li><a href="#">Feedback</a></li>
						<li><a href="#">Contact Us</a></li>
						<li><a href="#">FAQ's</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				          style="font-size:100%;">Notifications<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Recommendations</a></li>
						<li><a href="#">Pending Actions</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                  Hello, ${name} <span class="caret"></span></a>
                 <ul class="dropdown-menu">				   
	                    <li><a href="edit.do">EditProfile</a></li>
						<li><a href="changejobseeker.do">ChangePassword</a></li>
					    <li><a href="logout.do">Logout</a></li>
                 </ul>   				  
	            </li> 
            </ul>
		</nav>
	</header>

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
 