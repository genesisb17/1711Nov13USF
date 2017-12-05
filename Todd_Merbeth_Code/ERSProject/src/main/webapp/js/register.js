/**
 * 
 */
window.onload = function(){
	$('#message').hide();
	$('#register').on('click', register);
//	$('#username').blur(validateEmail);
//	$('#register').attr("disabled",true);
	
}

//function onblur that notifies the user of whether or not their email address is already in use 
function validateEmail(){
	console.log("blurred")
	var username = $('#username').val();
	
	var toSend = [username, ""];

	
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
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

function register(){
	var username = $('#username').val();
	var pass = $('#pass').val();
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var e = $('#email').val();
	
	var user = {
			id: 0,
			username: username,
			password: pass,
			firstname: fn,
			lastname: ln, 
			email: e,
			role: 1
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				alert("Error creating account");
			}
			else{
				console.log("added new user");
				$('#message').hide();
				alert("Success! Please log in to your new account");
				window.location.replace('login.html');
			}
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
}
