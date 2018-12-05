/**
 * 
 */


function geoFindMe() {
  var output = document.getElementById("output");
  
  
  
  
  if (!navigator.geolocation){
    output.innerHTML = "<p>사용자의 브라우저는 지오로케이션을 지원하지 않습니다.</p>";
    return;
  }

  function success(position) {  
	  
	  
	  var latitude  = position.coords.latitude;
	  var longitude = position.coords.longitude;

	  output.innerHTML = '<p>위도 : ' + latitude + '° <br>경도 : ' + longitude + '°</p>';
	  ajaxDo(latitude,longitude);
  }
  
  function ajaxDo(latitude,longitude){	  
	  $.ajax({
			url:"servlet.do?command=geolocation&latitude="+latitude+"&longitude="+longitude,
			dataType:"text",
			success:function(msg){ 
				alert(msg + "성공");			
				
			},
			error:function(){
				alert("실패염");
			}
		});	  
  }  
  
  function error() {
    output.innerHTML = "사용자의 위치를 찾을 수 없습니다.";
    
  };

  output.innerHTML = "<p>Locating…</p>";  
  
  navigator.geolocation.getCurrentPosition(success, error);
    
}

$(window).on("load", function() {
	geoFindMe();
});