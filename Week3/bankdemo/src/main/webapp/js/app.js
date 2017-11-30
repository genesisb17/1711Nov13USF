/**
 * 
 */

window.onload = function(){
	$('#login').on('click',login);
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
	
	json = JSON.stringify(json);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			
		}
	};
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

function register(){
	alert("registering");
}