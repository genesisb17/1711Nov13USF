/**
 * 
 */

window.onload = function(){
	$('#login').on('click',login);
	$('#register').on('click',register)
}

function login(){
	alert("logging in");
	var username = $('#username').val()
	var password = $('#pass').val()
	//making an array to turn into a json to send to the java
	var toSend = [username, password];       //OR
	var user = {
		name: username,
		password: password
	};
	
	//var tx = JSON.stringify(user);
	var json = JSON.stringify(toSend);
	//console.log(tx);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	
	//this happens during the send
	xhr.onreadystatechange = function(){
		console.log("Ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback");
		}
			
	};
	xhr.open("POST","login",true);
	
	//ignore this
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	xhr.send(json);
	//We are sending a request (the json) to login(the servlet) via the POST function
}

function register(){
	alert("registering")
	
}