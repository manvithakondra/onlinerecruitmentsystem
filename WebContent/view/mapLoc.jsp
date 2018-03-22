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
  <h2>Job Location </h2>
  <div class="panel panel-default">
    <div class="panel-body"><div class="map" id="map"></div>
  </div>
</div>
</div>

    

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCHhAxEqUUzSdNMb8SZibp-G0WlZvrdr_g">
    </script>
<script type="text/javascript">
(function () 
	    {
	        displayMap();
	})();

	function displayMap()
	{
	    var gm = google.maps;
	    var pos = new Object(); // var pos = {};

	/*
	    var geocoder = new google.maps.Geocoder();
	    var address = "Kmit, Hyderabad";

	    geocoder.geocode( { 'address': address}, function(results, status) {

	      if (status == google.maps.GeocoderStatus.OK) {
	        var latitude = results[0].geometry.location.lat();
	        var longitude = results[0].geometry.location.lng();
	        console.log("{'lat':"+latitude+", 'lng':"+longitude+"}");
	      } 
	    }); 
	   */

	  
	   
	   var markers =JSON.parse('${data}');
	   // var content = "<b>This is test</b><input value='click' type='button' onclick='test()' />'";
	        var content = "<a href='#' data-toggle='modal' data-target='#registerUser'>Register</a>"
	        var map = new gm.Map(document.getElementById('map'), {
	          zoom: 6,
	          center: new gm.LatLng(markers[0].lat, markers[0].lng)
	        });

	        var infowindow = new gm.InfoWindow();

	        for(var p in markers)
	        {
	          var data = markers[p];
	          var myLatlng = new gm.LatLng(data.lat, data.lng);
	          var marker = new gm.Marker({
	            position: myLatlng,
	            map: map,
	            title: data.name
	          });


	          (function (marker, data) {
	          gm.event.addListener(marker, 'click', function(e) {
	                //infowindow.setContent("<div style = 'width:200px;min-height:40px'>" + data.description + "</div>");
	                //infowindow.setContent(content);
	                //infowindow.open(map, marker);
	                //$('#registerUser').modal('show');
	        	 
	                      var mymodal = $('#registerUser');
	                      mymodal.find('.modal-header').html("<h4>" + data.name + "</h4>");
	                      mymodal.find('.modal-body').html("<div style = 'width:200px;min-height:40px'>" + data.description + "</div>");
	                      mymodal.modal('show');

	          });
	          })(marker, data);

	        }
	        

	    
	}


</script>
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
          </div>

  </body>
</html>