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
	
	var toSend = [username, password];

	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				console.log("user DNE");
			}
			else if(user.id == 0){
				console.log("wrong pw");
			}
			else{
				console.log("success!");
			}
		}
	};
	
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	

}

function register(){
	alert("registering");
}