  var marker;
  var map;
  var address = "1";//从php里获取从外部传过来的地址
  var currentLatlng;
  function initialize() {
    var latlng = new google.maps.LatLng(-26.050825030396666,135.29872382059693);
    var myOptions = {
      zoom: 4,
      center: latlng,
      mapTypeControl: true,
      mapTypeId: google.maps.MapTypeId.ROADMAP//标准地图还是卫星地图
    };
    map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    
      marker= new google.maps.Marker({
      position: latlng, 
      map: map, 
      title:"Hello World!"
      });   
      google.maps.event.addListener(map, 'click', function(event) {
          currentLatlng = event.latLng;
          marker.setPosition(event.latLng);
          setLngLat();
      });
      codeAddress();
  
  }
  function setLngLat(){
       document.getElementById("lng").innerHTML = "经度:"+currentLatlng.lng();
       document.getElementById("lat").innerHTML="纬度:"+currentLatlng.lat();
  }

  function codeAddress() {
    if(address){
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode( { 'address': address}, function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            currentLatlng = results[0].geometry.location; 
            marker.setPosition(currentLatlng);
            setLngLat();
          } else {
            alert("无法把地址转换成坐标，请检查地址真实性 ");
          }
        });
    }
  }
  function oncfrimlocation(){

        alert("Hello" + currentLatlng.lng() + "," + currentLatlng.lat());    
        //在这里把值回传给php
  }  