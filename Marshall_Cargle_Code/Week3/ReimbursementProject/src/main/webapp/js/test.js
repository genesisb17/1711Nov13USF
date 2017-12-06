window.onload = function(){
	$('#register').on('click', register);
}

function register(){
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var uname = $('#regEmail').val();
	var pass = $('#regPass').val();
	// add password validation and second input confirmation?

	var user = {
			id: 0,
			username: uname,
			password: pass,
			firstName: fn,
			lastName: ln, 
			email: uname,
			role: 0
			
	};
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	//window.location.replace('landing.html');
}

var $loginMsg = $(".loginMsg"),
  $login = $(".login"),
  $signupMsg = $(".signupMsg"),
  $signup = $(".signup"),
  $frontbox = $(".frontbox");

$("#switch1").on("click", function() {
  $loginMsg.toggleClass("visibility");
  $frontbox.addClass("moving");
  $signupMsg.toggleClass("visibility");

  $signup.toggleClass("hide");
  $login.toggleClass("hide");
});

$("#switch2").on("click", function() {
  $loginMsg.toggleClass("visibility");
  $frontbox.removeClass("moving");
  $signupMsg.toggleClass("visibility");

  $signup.toggleClass("hide");
  $login.toggleClass("hide");
});
