window.onload = function(){
	loadLanding();
	$('#Home').on('click',loadLanding());
	//$('#profile').on('click', loadProfile);
}

function loadLanding(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("Alert");
		}
	}
	xhr.open("GET", "landing", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(userJSON);
	alert(user.password);
}

//Open popup
$('.text').click(function() {
 $('.popup').css('opacity', 1);
 $('.overlay').css('opacity', 0.8);
 $('.popup').css('display', 'block');
		$('.overlay').css('display', 'block'); 
});
//close popup
$('.popup-close').click(function() {
 $('.popup').css('opacity', 0);
 $('.overlay').css('opacity', 0);
 setTimeout(function() {
     $('.popup').css('display', 'none');
		    $('.overlay').css('display', 'none'); 
 }, 1000);
 
});