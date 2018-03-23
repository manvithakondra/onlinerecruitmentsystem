<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>



<div class="container">

	<h1 align="center">List of Companies</h1>
	
		<c:forEach items="${companies}" var="com">
		
			
			<div class="row">
  				
    					<div class="panel panel-default">
      					<!--  <button type="button" class="close" aria-hidden="true">&times;</button> -->
      					<div class="panel-body">
      					<div class="row">
            					
        
            					<p> Name : ${com.name} </p>
								<p> Address : ${com.address} </p>
								<p> Description : ${com.description} </p>
						</div>
            					
           				</div>
        					
        					</div> 
        					</div>
        					
          					
						</c:forEach>	
      					
      					<div class="panel-footer">
                     	</div>			
			
	

</div>

<%@include file="/common/footer.jspf"%>