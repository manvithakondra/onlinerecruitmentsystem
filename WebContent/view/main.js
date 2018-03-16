(function () 
    {
        
        var ourRequest = new XMLHttpRequest();
        ourRequest.overrideMimeType("application/json");
        ourRequest.open('GET', 'person.json',true);
        ourRequest.onload = function() {
          renderData(ourRequest.responseText);
          //console.log(ourRequest.responseText); 
        };

        ourRequest.onerror = function() {
          alert("Connection error");
        };

        ourRequest.send();

})();

function renderData(data)
{
    var result= document.getElementById("result");
    var ourData = JSON.parse(data);
    for(var i in ourData[0].gps_location[0])
    {
      result.innerHTML += i +" : "+ ourData[0].gps_location[0][i]+"<br />";
    }

    displayMap(ourData);
    
}

function test()
{
  alert("Hello World");
}

function displayMap(data)
{
    var gm = google.maps;
    var pos = new Object(); // var pos = {};
    pos = data[0].gps_location[0];
    
    var content = "<b>This is test</b><input value='click' type='button' onclick='test()' />'";
        
        var map = new gm.Map(document.getElementById('map'), {
          zoom: 6,
          center: pos
        });

        var marker = new gm.Marker({
          position: pos,
          map: map
        });
        
        var infowindow = new gm.InfoWindow();
        gm.event.addListener(marker, 'click', function() {
                infowindow.setContent(content);
                infowindow.open(map, this);
        });


    
}

