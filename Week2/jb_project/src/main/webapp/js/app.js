/**
 * 
 */


window.onload = function() {
	$('#login').on('click', login);
	$('#register').on('click', register);
	
}

function login() {
	
	alert("Logging in");
	
	var username = $('#username').val();
	var password = $('#password').val();
	//var json = [username, password];
	var user = {
			
			name: username,
			password: password
	};
	
	var tx = JSON.stringify(user);
	json = JSON.stringify(json);
	console.log(tx);
	console.log(json)
}


function register() {
	
	alert("Registering in");
}