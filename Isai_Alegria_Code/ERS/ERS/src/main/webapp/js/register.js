/**
 * 
 */

window.onload = function(){
	$('#message').hide();
	$('#register').on('click', register);
	$('#username').blur(validateUser);
	//$('#register').attr("disabled",true);
	
}

function register(){
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var uname = $('#username').val();
	var pass = $('#password').val();
	var fn = $("#firstname").val();
	var ln = $("#lastname").val();
	var email = $("#email").val();
	// add password validation and second input confirmation?
	
	
//	var user = {
//			UserID: 0,
//			firstName: fn,
//			lastName: ln, 
//			email: uname, 
//			password: pass,
//			userRoleID: 99
//	};
	
	var toSend = [uname, pass,fn,ln,email];
	
	var userJSON = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('login.html');
}

//function onblur that notifies the user of whether or not their email address is already in use 
function validateUser(){
	console.log("blurred")
	var username = $('#username').val();
	
	var toSend = [username, ""];

	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("validating user");
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user != null){
				$('#message').html("Username Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
		}
	};
	
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}


