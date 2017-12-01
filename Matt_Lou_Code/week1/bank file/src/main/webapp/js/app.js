/**
 * 
 */

window.onload = function(){
	$('#login').on('click', login);
	$('#register').on('click', register);
}

function login(){
//	alert("logging in");
	var username = $('#username').val();
	var password = $('#pass').val();
	var json = [username, password];
//	var user = {
//			name: username,
//			password: password
//	};
//	
//	var tx = JSON.stringify(user);
	json = JSON.stringify(json);
	console.log(json);
	
	var xhr = new XMLHTTPRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			
		}
	}
	xhr.open("POST", "login" ,true);
	// sets the content type of the request
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function register(){
	alert("registering");
}

