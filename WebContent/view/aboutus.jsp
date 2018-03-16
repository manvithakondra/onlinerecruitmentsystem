<%@include file="/common/header.jspf" %>
	<header>
		<nav class="navbar navbar">
		<a href="#"class="navbar-brand"><img src="images/logo.png" height=70 /></a>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				          style="font-size:100%;">PostJobs<span class="caret"></span></a>
				      <ul class="dropdown-menu">
						<li><a href="post.do">Job by Location</a></li>
						<li><a href="post.do">Job by Skill</a></li>
						<li><a href="post.do">Job by Designation</a></li>
						<li><a href="post.do">Job by Category</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				          style="font-size:100%;">Company<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">About Us</a></li>
						<li><a href="#">Industries</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Softwares</a></li>
						<li><a href="#">Careers</a></li>
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
			             <li><a href="#">From Administrator</a></li>
			             <li><a href="#">Short-Listed Students</a></li>
				    </ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"
	                    style="font-size:100%;">Hello, ${name} <span class="caret"></span></a>
                 <ul class="dropdown-menu">				   
	                    <li><a href="editrecruiter.do">EditProfile</a></li>
						<li><a href="changerecruiter.do">ChangePassword</a></li>
						<li><a href="logout.do">Logout</a></li>
                 </ul>   				  
	            </li> 
            </ul>
		</nav>
	</header>
	<div class="container">
 
 	<form action="about.do" method="post" class="form-signin">
		<p>
			<font color="red">${error}</font>
		</p>
			<input type="text" class="form-control" name="company" placeholder="Company Name" required="" autofocus="" />
			<input type="text" class="form-control" name="address" placeholder="Address" required="" autofocus="" />    	      
      <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button> 
			    	
	</form>
 </div>
<%@include file="/common/footer.jspf" %>