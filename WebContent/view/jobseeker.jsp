<%@include file="/common/header.jspf" %>
	<header>
		<nav class="navbar navbar">
		<a href="#"class="navbar-brand"><img src="images/logo.png" height=100 /></a>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				         style="font-size:100%;">Jobs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="view/index.html">Job by Location</a></li>
						<li><a href="job.do">Job by Skill</a></li>
						<li><a href="job.do">Job by Designation</a></li>
						<li><a href="job.do">Job by Category</a></li>
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
						<li><a href="resumeupload.do">Pending Actions</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                  Hello, ${name} <span class="caret"></span></a>
                 <ul class="dropdown-menu">				   
	                    <li><a href="editjobseeker.do">EditProfile</a></li>
						<li><a href="changejobseeker.do">ChangePassword</a></li>
					    <li><a href="logout.do">Logout</a></li>
                 </ul>   				  
	            </li> 
            </ul>
		</nav>
	</header>
<%@include file="/common/footer.jspf" %>