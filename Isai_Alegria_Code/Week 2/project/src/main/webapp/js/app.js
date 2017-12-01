/**
 * 
 */

window.onload = function(){
	
	$('#login').on('click',login);
	$('#register').on('click',register);
	
}

function login(){
	//alert("Logging in...");
	var username = $('#username').val();
	var password = $('#password').val();
	var toSend = [username, password];
	
//	  var user = {
//	  	name:username,
//	  	password: password
//	  
//	  }; 
//	  
	 //var jtx = JSON.stringify(user);
	 //console.log(jtx);
	
	 var json = JSON.stringify(toSend);
	 console.log(json);
	 
	 var xhr = new XMLHttpRequest();
	 	console.log("ready state: " + xhr.readyState)
	 xhr.onReadyStateChange = function(){
		 if(xhr.readyState == 4 && xhr.status == 200){
			 console.log("in xhr callback");
		 } 
	 };
	 
	 xhr.open("POST","login",true);
	 xhr.setRequestHeader("Content-type","application/x-www-form-unrlencoded");
	 xhr.send(json); //sending message body
	 
}

function register(){
	alert("Registering...");
	
	
}