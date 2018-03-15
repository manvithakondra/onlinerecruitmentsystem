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
	                    <li><a href="editjobseeker.do">EditProfile</a></li>
						<li><a href="change.do">ChangePassword</a></li>
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
 
 <H1>Edit Profile</H1>
 
 <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
 

 
 	<form action="editjobseeker.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			Name:<input type="text" class="form-control" name="fullname" placeholder="Full Name" required="" autofocus="" />
			Current Location:<input type="text" class="form-control" name="location" placeholder="current location" required="" autofocus="" />
			Preferred Location:<select class="form-control" name="preloc" id="preloc" placeholder="preferred location">
			            <option value=""></option>
                        <option value="hyd">Hyderabad</option>
                        <option value="chennai">Chennai</option>
                        <option value="bengaluru">Bengaluru</option>
                        <option value="delhi">Delhi</option>
                        <option value="mumbai">Mumbai</option>
                 </select>
            Total Experience:<select class="form-control" name="exp" id="exp" placeholder="total experience">
			            <option value="fre">Fresher</option>
                        <option value="hyd">0-1</option>
                        <option value="chennai">2-4</option>
                        <option value="bengaluru">5-7</option>
                        <option value="delhi">7-9</option>
                        <option value="mumbai">>=10</option>
                 </select>  
            Industry:<select class="form-control" name="ind" id="ind" placeholder="industry">
			            <option value="acc">Accounting/Finance</option>
                        <option value="ith">IT-Hardware & Network</option>
                        <option value="its">IT-Software/Software Services</option>
                        <option value="oth">Others</option>
                    </select>   
			E-Mail:<input type="text" class="form-control" name="email" placeholder="e-mail" required="" autofocus="" />
			<br><br>
			    	      
      <button id="save" class="btn btn-lg btn-primary btn-block" type="save">Save</button>
      <button id="class" class="btn btn-lg btn-secondary btn-block" type="cancel">Cancel</button> 
			    	
	</form>
 </div>
 
 <!--<@include file="/common/footer.jspf" %>  -->
 
 