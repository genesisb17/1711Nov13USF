/**
 * 
 */
window.onload = function(){
	$('#email').popover();
	$('#message').hide();
	$('#emailmessage').hide();
	$('#passwordmessage').hide();
	$('#usernamemessage').hide();
	$('#email').blur(validateEmail);
	$('#username').blur(validateUsername);
	$('#pass').blur(validatePassword);
	$('#register').attr("disabled",true);
	$('#register').on('click', register);
}
function validateRequired(){
	console.log("In validate required method.");
	var email = $('#email').val();
	var username = $('#username').val();
	var password=$('#pass').val();
	console.log("In validate required method. length of all required fields are " + (email.length +username.length +password.length));
	if((email.length > 6)&&(username.length > 6) && (username.length > 6)){
		$('#typemessage').hide();
		$('#register').attr("disabled",false);
	}
}
function validatePassword(){
	var password= $('#pass').val();
	if (password.length < 6){
		$('#passwordmessage').show();
		$('#passwordmessage').html("Password has to be more than 6 characters.");
		$('#register').attr("disabled",true);
	}
	else{
		validateRequired();
		$('#passwordmessage').hide();
	}
}
//function onblur that notifies the user of whether or not their email address is already in use
function validateEmail(){
	console.log("blurred");
	var email = $('#email').val();
	if (email.length < 7){
		$('#emailmessage').show();
		$('#emailmessage').html("Email has to be more than 6 characters.") ;
		$('#register').attr("disabled",true);
	}
	else{
	//console.log("the length of the email is: " + email.length);
	//console.log("email is: " + email);
	var toSend = [email,""];
	console.log(toSend);
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#emailmessage').show();
			if(user.email != null){
				$('#emailmessage').html("Email Already in use.") ;
				$('#register').attr("disabled",true);
			}
				else{
				validateRequired();
				$('#emailmessage').hide();
				
			}
		}
	};
	
	xhr.open("POST","validator", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}
}


function validateUsername(){
	console.log("blurred")
	var username = $('#username').val();
	if (username.length < 7){
		$('#usernamemessage').show();
		$('#usernamemessage').html("Username has to be more than 6 characters.");
		$('#register').attr("disabled",true);
	}
	else{
	var toSend = [username, ""];

	
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#usernamemessage').show();
			if(user.username != null){
				$('#usernamemessage').html("Username Already in use.") ;
				$('#register').attr("disabled",true);
			}
			else{
				validateRequired();
				$('#usernamemessage').hide();

			}

		}
	};
	
	xhr.open("POST","validator", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}
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