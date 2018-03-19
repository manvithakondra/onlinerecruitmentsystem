<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>JS Demo</title>
    <meta charset="utf-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

    <style>
      .map {
        width: 100%;
        height: 400px;
        background-color: silver;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCHhAxEqUUzSdNMb8SZibp-G0WlZvrdr_g">
    </script>

    <!-- Required meta tags -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Bootstrap JS -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
    
  </head>
  <body>
    <h1 id="result"></h1>
    <div class="map" id="map"></div>

    <script src="main.js"></script>

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