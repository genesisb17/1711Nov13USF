window.onload = function() {
	logout();
	$('#register').on('click', register);
	$('#loginButton').on('click', login);
}

function logout(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
		}
	};
	
	xhr.open("POST","logout", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send();
}

function register() {
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var uname = $('#regEmail').val();
	var pass = $('#regPass').val();
	// add password validation and second input confirmation?
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(re.test(uname.toLowerCase())){
	var user = {
		id : 0,
		username : uname,
		password : pass,
		firstName : fn,
		lastName : ln,
		email : uname,
		role : 0
	};
	var userJSON = JSON.stringify(user);
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
	//window.location.replace('landing.html');
	}else{
		$('#notice').removeClass('alert alert-success').addClass('alert alert-danger');
		$('#header').html("Invalid Email");
		$('#notice').show();
	}
}

function login(){
	
	var username = $('#logEmail').val();
	var password = $('#logPass').val();
	
	var toSend = [username, password];

	
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user==null){
				$('#notice').removeClass('alert alert-success').addClass('alert alert-danger');
				$('#header').html("Invalid Login");
				$('#notice').show();
			}else if(user.role==0){
				window.location.replace('HomePage.html');
			}else{
				window.location.replace('HomePage-Manager.html');
			}
		}
	};
	
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
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