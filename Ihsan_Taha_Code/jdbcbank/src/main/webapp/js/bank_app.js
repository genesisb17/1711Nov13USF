/**
 * 
 */

window.onload = function() {
	$('#login').on('click', login);
	$('#register').on('click', register);
}

function login() 
{
	alert("Logging In");
	
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var username = $('#username').val();
	var password = $('#password').val();
	
	var tnsc = [firstname, lastname, username, password];
	
	var json = JSON.stringify(tnsc);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 &&  xhr.status == 200) {
			console.log("in xhr callback");
		}
	};
	
	xhr.open("POST","login",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}

function register() {
	alert("Registering");
}	
