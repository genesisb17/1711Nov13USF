window.onload = function() {
	loadLogin();
	$("#toLogin").on("click", loadLogin);
	$("#toRegister").on("click", loadRegister);
	$("#toHome").on("click", loadHome);
	$("#toProfile").on("click", loadProfile);
}

function login() {
	
	var username = $('#login-username').val();
	var password = $('#login-password').val();
	
	var toSend = [username, password];
	
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			$("#login-message").show();
			
			if (user == null) {
				$("#login-message").html("Invalid username!");
			}
			
			else if (user.id == 0) {
				$("#login-message").html("Invalid password!");
			}
			
			else {
				$("#message").html(`Welcome, ${user.username}`);
				loadHome();
				console.log(`User id: ${user.id} login successful!`);
			}
		}
	};
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function loadLogin() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;	// xhr.responseText = partials/login.html
			loadLoginInfo();
		}
	}
	
	xhr.open("GET", "loginView", true);
	xhr.send();
}

function loadLoginInfo() {
	$('#login-message').hide();
	$('#login').on('click', login);
}

function loadRegister() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;	// xhr.responseText == partials/register.html
			loadRegisterInfo();
		}
	}
	
	xhr.open("GET", "registerView", true);
	xhr.send();
}

function loadRegisterInfo() {
	$('#reg-message').hide();
	$("#reg-username").blur(validateUsername);
	$("#email").blur(validateEmail);
	$("#register").attr("disabled", true);
	$("#register").on('click', register);
}

function loadHome() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;	// xhr.responseText == partials/home.html
		}
	}
	
	xhr.open("GET", "homeView", true);
	xhr.send();
}

function loadProfile() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;	// xhr.responseText == partials/profile.html
			loadProfileInfo();		
		}
	}
	
	xhr.open("GET", "profileView", true);
	xhr.send();
}

function loadProfileInfo() {
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var sessionUser = JSON.parse(xhr.responseText);
			console.log(sessionUser.id);
			if (sessionUser.id != 0) {
				$('#user_firstname').html(sessionUser.firstName);
				return sessionUser;
			}
			
			else {
				loadLogin();
			}
		}
	}
	
	xhr.open("GET", "loadProfileInfo", true);
	xhr.send();
}

function validateUsername() {
	$("#register").attr("disabled", false);
	$("#reg-message").hide();
	
	var username = $("#reg-username").val();
	var toSend = username;
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if(user == null) {
				$("#reg-message").show();
				$("#reg-message").html("Username is already in use! Please try another.");
				$("#register").attr("disabled", true);
			}
		}
	}
	
	xhr.open("POST", "usernameValidate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function validateEmail() {
	$("#register").attr("disabled", false);
	$("#reg-message").hide();
	
	var email = $("#email").val();
	var toSend = email;
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var email = JSON.parse(xhr.responseText);
			if(email == null){
				$("#reg-message").show();
				$("#reg-message").html("Email address is already in use! Please try another.") ;
				$("#register").attr("disabled", true);
			}
		}
	}
	
	xhr.open("POST", "emailValidate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function register() {
	var fn = $("#fn").val();
	var ln = $("#ln").val();
	var email = $("#email").val();
	var username = $("#reg-username").val();
	var password = $("#reg-password").val();
	
	var user = {
			id: 0,
			firstName: fn,
			lastName: ln,
			emailAddress: email,
			username: username,
			password: password
	}
	
	var userJson = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
		}
	}
	
	xhr.open("POST", "register", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(userJson);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	loadLogin();
}