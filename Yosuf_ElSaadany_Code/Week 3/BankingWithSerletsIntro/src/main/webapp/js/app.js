/**
 * 
 */

window.onload = function(){
	
	$("#login").on("click", login);
	$("#register").on("click", register);

}

function login(){
	//alert("logging in");
	var username = $("#username").val();
	var password = $("#pass").val();
	var toSend = [username, password];
	
	json = JSON.stringify(toSend);
	console.log(json);
	
	// 1
	var xhr = new XMLHttpRequest();

	// 2
	xhr.onreadystatechange = function(){
		console.log("ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("in xhr callback");
		}
	};
	// 3
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www.form-urlencoded");
	
	// 4
	xhr.send(json);
	

	
}

function register(){
	alert("registering");
	
}