  var marker;
  var map;
  var address = "1";//从php里获取从外部传过来的地址
  var currentLatlng;
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

    var image = '../images/green_icon.jpg';
      marker= new google.maps.Marker({
      position: lat, 
      map: map, 
      icon: image,
      title:"Hello World!"
      });   
      google.maps.event.addListener(map, 'click', function(event) {
          currentLatlng = event.lat;
          marker.setPosition(event.lat);
          setLngLat();
      });
      codeAddress();
  
  }
  function setLngLat(){
       document.getElementById("lng").innerHTML = "经度:"+currentLatlng.lng();
       document.getElementById("lat").innerHTML="纬度:"+currentLatlng.lat();
  }
  function mark(){
      var lat = new google.maps.LatLng(-26.050825030396666,135.29872382059693);
    //id = document.getElementById('form_id').id;
      map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
      var image = './green_icon.jpg';
      marker= new google.maps.Marker({
      position: lat, 
      map: map, 
      icon: image,
      title:"Hello World!"
      }); 
      marker.setPosition(lat);  
      
  }
  function GetArgsFromHref(sHref, sArgName)
{
      var args    = sHref.split("?");
      var retval = "";
    
      if(args[0] == sHref) /*参数为空*/
      {
           return retval; /*无需做任何处理*/
      }  
      var str = id[1];
      args = str.split("&");
      for(var i = 0; i < args.length; i ++)
      {
          str = args[i];
          var arg = str.split("=");
          if(arg.length <= 1) continue;
          if(arg[0] == sArgName) retval = arg[1]; 
      }
      return retval;
      alert(retval);
}

  function alt(){
    
    alert("123"+id);
    
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

  function postData(){
    var myForm = document.create_r_rElement("form");
    myForm.method = "post";
    myForm.action = "als1.html";
    var inputs=document.getElementsByName("post_data");
    var i;
    for (i=0;i<inputs.length;i++) {
      var myInput = document.create_r_rElement("input");
      myInput.type = "text";
      myInput.name="post_data";
      myInput.value=inputs[i].value;
      myForm.a(myInput);
    }
    document.body.a(myForm);
    myForm.submit();
    document.body.removeChild(myForm);
  }