/**
 * 
 */

window.onload = function(){
	$("#login").on("click", login);
	$("#register").on("click", register);
}

function login(){
	alert("logging in");
	var tx = JSON.stringify({
			username: $("#username").val(),
			password: $("#password").val()
	});
	console.log(tx);
	var xhr = new XMLHttpRequest();
	xhr.onReadyStateChange = function(){
		if(xhs.readyState == 4 && xhr.status == 200){
			console.log("in xhr callback");
		}
	};
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
	xhr.send(tx);
}

function register(){
	alert("registering");
}