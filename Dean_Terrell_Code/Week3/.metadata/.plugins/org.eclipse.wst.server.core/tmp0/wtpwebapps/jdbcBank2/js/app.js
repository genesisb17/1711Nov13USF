
function login() {
	var username = $('#username').val();
	var password = $('#pass').val();
	var toSend = [username, password];
	/*var user = {
		name: username,
		password: password
	};
	
	//var tx = JSON.stringify(user);
	console.log(tx) */
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200)
			console.log("in xhr callback");
	};
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function register() {
	alert("registering");
}

window.onload = function() {
	$('#login').on('click',login);
	$('#register').on('click',register);
};