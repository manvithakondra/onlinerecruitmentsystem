<%@include file="/common/header.jspf" %>
<%@include file="/common/recruiter_navbar.jspf" %>
	

	<script>
	 function onSubmit(){
		 alert("job posted successfully");
	 }
	</script>
	
	<div class="contanier">
		<h1>Post Job</h1>
	
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
          <textarea class="form-control" name="address" id="address" placeholder="enter job location">  </textarea>
        </p>
 <p> Event Venue: <select class="form-control" name="event_venue" id="event_venue" >
			     <option value="Hyderabad">Hyderabad</option>
                 <option value="pune">Pune</option>
                 <option value="bang">Banglore</option>
                 <option value="che">Chennai</option>
                 <option value="delhi">Delhi</option>
              </select></p>
 <p> Profile type: <select class="form-control" name="profile" id="profile" >
			     <option value="pro">IT product</option>
                 <option value="services">IT Services</option>
                 <option value="sales">sales</option>
                 <option value="bpo">BPO</option>
                 <option value="test">testing</option>
              </select></p>
 <p> Salary : <input type="text" class="form-control" name="salary" placeholder="salary" required="" autofocus="" /></p>
 <p> Event Date :<input type="text" class="form-control" name="event_date" placeholder="Event date" required="" autofocus="" /></p>
 <button type="submit" class="btn btn btn-primary" onClick="onSubmit();">Post Job</button>

 </form>
 </div>
 
	
	
 
<%@include file="/common/footer.jspf" %>