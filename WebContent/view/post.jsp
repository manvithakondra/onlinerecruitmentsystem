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
	<div class="contanier">
<h1>       Post Job</h1>
	
	<form action="post.do" method="post" class="form-signin">
     <h3 style="color:blue;" ><b>SELECTION CRITERIA</b></h3>
 <p>Percentage: <select class="form-control" name="percentage" id="percentage" >
			     <option value="60">>=60%</option>
                 <option value="70">>=70%</option>
                 <option value="75">>=75%</option>
              </select>   </p>
 <p>Passed out year/Passing year: <select class="form-control" name="year" id="year" >
			     <option value="2016">2016</option>
                 <option value="2017">2017</option>
                 <option value="2018">2018</option>
              </select></p>
 <p>Degree: <select class="form-control" name="degree" id="degree" >
			     <option value="be">BE</option>
                 <option value="bcom">BCom</option>
                 <option value="ba">BA</option>
              </select></p>
 <p>Branch: <select class="form-control" name="branch" id="branch" >
			     <option value="cs">Computer Science</option>
                 <option value="it">Information Technology</option>
                 <option value="ece">Electronics</option>
                 <option value="acc">Accounting</option>
                 <option value="ms">Mass Communication</option>
              </select></p>
 <p>Designation:<select class="form-control" name="designation" id="desigation" >
			     <option value="trainee">Software Trainee</option>
                 <option value="sr.">Sr. Software Engineer</option>
                 <option value="hr">HR Trainee</option>
                 <option value="sr.hr">Sr. HR Manager</option>
                 <option value="manager">Manager</option>
              </select></p>
 <p>Address:
          <textarea name="address" id="address" placeholder="enter job location">  </textarea>
        </p>
 <p> Event Venue: <select class="form-control" name="event_venue" id="event_venue" >
			     <option value="Hyderabad">Hyderabad</option>
                 <option value="pune">Pune</option>
                 <option value="bang">Banglore</option>
                 <option value="che">Chennai</option>
                 <option value="del">Delhi</option>
              </select></p>
 <p> Profile type: <select class="form-control" name="profile" id="profile" >
			     <option value="pro">IT product</option>
                 <option value="ser">IT Services</option>
                 <option value="sales">sales</option>
                 <option value="bpo">BPO</option>
                 <option value="test">testing</option>
              </select></p>
 <p> Salary : <input type="text" class="form-control" name="salary" placeholder="salary" required="" autofocus="" /></p>
 <p> Event Date :<input type="text" class="form-control" name="event_date" placeholder="Event date" required="" autofocus="" /></p>
 <button type="submit" class="btn btn btn-primary" >Post</button>
 </form>
 </div>
 
<%@include file="/common/footer.jspf" %>