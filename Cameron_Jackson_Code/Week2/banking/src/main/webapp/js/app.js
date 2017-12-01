/**
 * 
 */
window.onload = function() {
	$('#login').on('click', login);
	$('#register').on('click',register);
}

function login() {
	alert("logging in");
	var username = $('#username').val();
	var password = $('#password').val();
//	var user = {
//			name: username,
//			password: password
//	};
	var user = [username, password];
	var tx = JSON.stringify(user);
	console.log(tx);
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
		}
	};
	
}

function register() {
	alert("registering");
}