<%@ include file="/common/header.jspf" %>
<%@include file="/common/jobseeker_navbar.jspf" %>

<style>
      .map {
        width: 100%;
        height: 600px;
        background-color: silver;
      }
</style>
<div class="container">
<br>
<br>
  <h2>Job Location</h2>
  <div class="panel panel-default">
    <div class="panel-body"><div class="map" id="map"></div>
  </div>
</div>
</div>

    

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCHhAxEqUUzSdNMb8SZibp-G0WlZvrdr_g">
    </script>
    <script src="js/main.js"></script>

        <!-- Register User Modal -->
        <div class="modal fade" id="registerUser">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              
              <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">
            Register User
        </h4>
              </div>
              
              <div class="modal-body">
               <p>Modal body text goes here.</p>
              </div>
               
               <div class="modal-footer">
                <button type="button" class="btn btn-primary">
                    Register
                </button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                    Close
                </button>
              </div>
            </div>  
          </div>


  </body>
</html>