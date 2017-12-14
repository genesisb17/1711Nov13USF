window.onload = function() {
	//var now = new Date();
	//alert(now);
	//$('#Home').on('click',loadLanding());
	$('#submit').on('click', submitTicket());
//$('#profile').on('click', loadProfile);
}

/*function loadLanding(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("Alert");
		}
	}
	xhr.open("POST", "landing", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(userJSON);
	alert(user.password);
}*/

function submitTicket() {
	var am = $('#amount').val();
	var des = $('#description').val();
	var selectedOption = $("input:radio[name=radio]:checked").val()
	// add password validation and second input confirmation?

	var ticket = {
		amount : am,
		description : des,
		option : selectedOption
	};
	console.log(ticket);
/*
var userJSON = JSON.stringify(user);
alert("testing");
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var user = JSON.parse(xhr.responseText);
		if(user==null){
			$('#notice').removeClass('alert alert-success').addClass('alert alert-danger');
			$('#header').html("User already exists");
			$('#notice').show();
		}else{
			$('#notice').removeClass('alert alert-danger').addClass('alert alert-success');
			$('#notice').show();
			$('#header').html("Success");
		}
	}
};
xhr.open("POST", "register", true);
xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhr.send(userJSON);
alert(user.password);
//window.location.replace('landing.html');*/
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