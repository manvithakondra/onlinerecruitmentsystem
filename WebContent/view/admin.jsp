<%@include file="/common/header.jspf" %>
	<header>
		<nav class="navbar navbar">
		<a href="#"class="navbar-brand"><img src="images/logo.png" height=100 /></a>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				         style="font-size:100%;">ManageJobseekers<span class="caret"></span></a>
					<ul class="dropdown-menu">
					    <li><a href="#">Send Notifications</a></li>
						<li><a href="#">Received Applications</a></li>
						<li><a href="#">Send E-Mail</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				      style="font-size:100%;">ManageRecruiters<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Send Notifications</a></li>
						<li><a href="#">Send Sort-List</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				       style="font-size:100%;">Notifications<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Short-Listed Candidates</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
	            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                     Hello, ${name} <span class="caret"></span></a>
                 <ul class="dropdown-menu">
						<li><a href="changeadmin.do">ChangePassword</a></li>
						<li><a href="logout.do">Logout</a></li>
                 </ul>   				  
	            </li> 
            </ul>
		</nav>
	</header>
<%@include file="/common/footer.jspf" %>