<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

 <div class="container">
 
  <c:forEach items="${jobseeker}" var="j">
 	<form action="editjobseeker.do" method="post" class="form-signin">
	   <H1>Update Profile</H1>
		<p>
			<font color="red">${error}</font>
		</p>
			Name:<input type="text" class="form-control" name="fullname" placeholder="Full Name" required="" autofocus="" value="${j.name}" />
			Current Location:<input type="text" class="form-control" name="location" placeholder="current location" required="" autofocus="" value="${j.location}" />
			DateOfBirth:<input type="text" class="form-control" name="dob" placeholder="Date Of Birth" required="" autofocus="" value="${j.dateofbirth}" />
            Gender:<select class="form-control" name="gender" id="gender" placeholder="gender" value="${j.gender}">
			            <option value="male">Male</option>
                        <option value="female">Female</option>
                     </select>  
            Percentage:<input type="text" class="form-control" name="percentage" placeholder="Percentage" required="" autofocus="" value="${j.percentage}" />
            Branch:<input type="text" class="form-control" name="branch" placeholder="Branch" required="" autofocus="" value="${j.branch}" />
            Key Skills:<input type="text" class="form-control" name="keyskills" placeholder="Key Skills" required="" autofocus="" value="${j.keyskills}" />
            Total Experience:<select class="form-control" name="experience" id="exp" placeholder="total experience" value="${j.experience}">
			            <option value="fresher">Fresher</option>
                        <option value="0-1">0-1</option>
                        <option value="2-4">2-4</option>
                        <option value="5-7">5-7</option>
                        <option value="7-9">7-9</option>
                        <option value=">=10">>=10</option>
                 </select>  
            E-Mail:<input type="text" class="form-control" name="email" placeholder="e-mail" required="" autofocus="" value="${j.email}" />
			<br><br>
			    	      
      <button id="save" class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
      <button id="class" class="btn btn-lg btn-secondary btn-block" type="cancel">Cancel</button> 
			    	
	</form>
	</c:forEach>
 </div>
 
 <%@include file="/common/footer.jspf" %>