<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/header.jspf" %>
<%@include file="/common/admin_navbar.jspf" %>

<div class="container">
 <h1 align="center">COMPANIES</h1>
 

       <c:forEach items="${company}" var="company1">

			
			<div class="row">
  				<div class="col-md-12">
    					<div class="panel panel-default">
      					<div class="panel-body">
      					<div class="row">
            					<div class="col-md-6">
                                <!--  <p> Name : ${company1.name} </p>-->
								<p> Company Name : ${company1.name} </p>
								<p> Company Address : ${company1.address} </p>
								<p> Company Description : ${company1.description} </p>
          
            					</div>
        					</div> 
          					
							
      					</div>
      					
      					</div>
  					</div>
				</div>
			     </c:forEach>
</div>
	
<%@include file="/common/footer.jspf" %>

