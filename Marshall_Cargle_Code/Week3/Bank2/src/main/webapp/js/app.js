/**
 * 
 */

window.onload=function(){
	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click',register);
}

function login(){
	//alert("logging in");
	var username=$('#username').val();
	var password=$('#pass').val();
	var toSend = [username, password];
	/*var user={
			name: username,
			password: password
	};*/
	
	//var tx = JSON.stringify(user);
	json = JSON.stringify(toSend);
	//console.log(tx);
	console.log(json);
	
	var xhr=new XMLHttpRequest();
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
	xhr.onreadystatechange = function(){
		console.log("ready state: "+xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("in xhr callback");
		}
	};
}

function register(){
	alert("registering");
}