  var marker;
  var map;
  var id;
  var loc;

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

  }





  