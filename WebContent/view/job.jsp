<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
	<header>
		<nav class="navbar navbar">
		<a href="#"class="navbar-brand"><img src="images/logo.png" height=100 /></a>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" 
				         style="font-size:100%;">Jobs<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="job.do">Job by Location</a></li>
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
						<li><a href="changejobseeker.do">ChangePassword</a></li>
					    <li><a href="logout.do">Logout</a></li>
                 </ul>   				  
	            </li> 
            </ul>
		</nav>
	</header>


<div class="container">
	<H1 align="center">JOB</H1>
	
	

<table class="table table-striped">
		<caption></caption>
		<thead>
			<th>Description</th>
		</thead>
		 <tbody>
			<c:forEach items="${messages}" var="message">
				<tr>
					<td>
					${message.percentage}
					${message.year}
					${message.degree}
					${message.branch}
					${message.designation}
					${message.address}
					${message.profile}
				  	${message.salary}
					</td>
				
				</tr>
			</c:forEach>
		</tbody>
	</table>
<form class="form-search"  >
		<div class="input-append">
			<!--  <input type="text" class="search-query input-medium" name="keyword"> 
			<button type="submit" class="btn btn-large">APPLY</button>-->
			<a href="#" data-toggle="modal" data-target="#apply" data-backdrop="static">
			      <button type="submit" class="btn btn-primary">Apply</button></a>
		</div>
	</form>	
<div class="modal fade" id="apply">
	 <div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title">Apply</h4>
		</div>
		<div class="modal-body">
		<div class="form-group">
			<label for="percentage"></label>
			<input type="text" name="p" placeholder="percentage" class="form-control" required="auto-focus">
		</div>
		<div class="form-group">
			<label for="branch"></label>
			<input type="text" name="b" placeholder="branch" class="form-control" required="auto-focus">
		</div>
		<div>
		  <label for="venue preference"></label>
			<input type="text" name="vp" placeholder="venue preference" class="form-control" required="auto-focus">
		</div>
		
			<p align="center"><button type="submit" class="btn btn-block btn-primary">Apply</button></p>
	   </div>
	  </div>
	 </div>
	</div>			
			
		
	<p>
		<font color="red">${errorMessage}</font>
	</p>

</div>

<%@include file="/common/footer.jspf"%>