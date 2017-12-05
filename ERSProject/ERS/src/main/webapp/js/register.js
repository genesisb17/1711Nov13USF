/**
 * 
 */
window.onload = function(){
	$('#message').hide();
	$('#register').on('click', register);
	$('#email').blur(validateEmail);
	$('#username').blur(validateUsername);
	$('#register').attr("disabled",true);
	
	
}

//function onblur that notifies the user of whether or not their email address is already in use
function validateEmail(){
	console.log("blurred")
	var email = $('#email').val();
	var toSend = [email,""];
	
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#emailmessage').show();
			if(user.email !=null){
				$('#emailmessage').html("Email Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
			else{
				$('#emailmessage').html("Email is good");
				
			}
		}
	};
	xhr.open("POST","validator", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}


function validateUsername(){
	console.log("blurred")
	var username = $('#username').val();
	var toSend = [username, ""];

	
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#usernamemessage').show();
			if(user.username != null){
				$('#usernamemessage').html("Username Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
			else{
				$('#usernamemessage').html("Username is good");
				$('#register').attr('disabled', false);
				
			}

		}
	};
	
	xhr.open("POST","validator", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

function register(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var email = $('#email').val();
	var uname = $('#username').val();
	var pass = $('#pass').val();
	// add password validation and second input confirmation?
	console.log("Register funciton in JS " + fn + ln + email + uname + pass);
	
	
	var user = {
			id: 0,
			username: uname,
			password: pass,
			firstname: fn,
			lastname: ln, 
			email: email,
			password: pass
	};
	
	var userJSON = JSON.stringify(user);
	console.log("user after being converted to JSON " + userJSON);
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