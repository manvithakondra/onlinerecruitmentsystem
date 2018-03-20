<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>



<div class="container">
	<h1 align="center">List of Jobs</h1>
	

			<c:forEach items="${messages}" var="message">
			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<button type="button" class="close" aria-hidden="true">&times;</button>
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
            						<p> Percentage : ${message.percentage} </p>
								<p> Year : ${message.year} </p>
								<p> Qualification : ${message.degree} </p>
								<p> Branch : ${message.branch} </p>
            					</div>
            					<div class="col-md-6">
            						<p> Designation : ${message.designation} </p>
								<p> Address : ${message.address} </p>
						
								<p> Profile : ${message.profile} </p>
					  			<p> Salary : ${message.salary} </p>
            					</div>
        					</div> 
          					
							
      					</div>
      					<div class="panel-footer">
      					
      					<form class="form-search"  >
							<div class="input-append">
								<!--  <input type="text" class="search-query input-medium" name="keyword"> 
								<button type="submit" class="btn btn-large">APPLY</button>-->
								
								      <button type="submit" data-toggle="modal" data-target="#apply" data-backdrop="static" class="btn btn-primary col-md-offset-11">Apply</button>
							</div>
						</form>	
      					
      					</div>
  					</div>
				</div>
			</div>
			
			
				
			</c:forEach>
		

<div class="modal fade" id="apply">
	 <div class="modal-dialog" role="document">
	 
	  <div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		
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