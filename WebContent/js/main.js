(function () 
    {
        displayMap();
})();

function displayMap()
{
    var gm = google.maps;
    var pos = new Object(); // var pos = {};


    var geocoder = new google.maps.Geocoder();
    var address = "Kmit, Hyderabad";

    geocoder.geocode( { 'address': address}, function(results, status) {

      if (status == google.maps.GeocoderStatus.OK) {
        var latitude = results[0].geometry.location.lat();
        var longitude = results[0].geometry.location.lng();
        console.log("{'lat':"+latitude+", 'lng':"+longitude+"}");
      } 
    }); 
   


   var markers = ['${data}'];
    
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
          console.log(myLatlng)
          var marker = new gm.Marker({
            position: myLatlng,
            map: map,
            title: data.title
          });


          (function (marker, data) {
          gm.event.addListener(marker, 'click', function(e) {
                //infowindow.setContent("<div style = 'width:200px;min-height:40px'>" + data.description + "</div>");
                //infowindow.setContent(content);
                //infowindow.open(map, marker);
                //$('#registerUser').modal('show');
        	 
                      var mymodal = $('#registerUser');
                      mymodal.find('.modal-header').html("<h4>" + data.title + "</h4>");
                      mymodal.find('.modal-body').html("<div style = 'width:200px;min-height:40px'>" + data.description + "</div>");
                      mymodal.modal('show');

          });
          })(marker, data);

        }
        

    
}

