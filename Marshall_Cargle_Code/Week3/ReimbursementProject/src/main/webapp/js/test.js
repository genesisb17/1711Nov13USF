window.onload = function() {
	$('#register').on('click', register);
	$('#loginButton').on('click', login);
	console.log("testing");
}

function register() {
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var uname = $('#regEmail').val();
	var pass = $('#regPass').val();
	// add password validation and second input confirmation?

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
	//window.location.replace('landing.html');
}

function login(){
	alert("Message");
	
	var username = $('#logEmail').val();
	var password = $('#logPass').val();
	
	var toSend = [username, password];

	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user==null){
				$('#notice').removeClass('alert alert-success').addClass('alert alert-danger');
				$('#header').html("Invalid Login");
				$('#notice').show();
			}else{
				window.location.replace('landing.html');
			}
		}
	};
	
	xhr.open("POST","login", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
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