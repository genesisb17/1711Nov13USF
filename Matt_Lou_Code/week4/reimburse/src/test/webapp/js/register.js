/**
 * 
 */


window.onload = function(){
	$("#register-submit").on("click", register);
	$('#email-message').hide();
	$('#username-message').hide();
	//$('#password-message').hide();
	$('#register-submit').attr("disabled",true);

}
$(document).ready(function(){
	$('#email').blur(validateEmail);
	$('#username').blur(validateUsername);
	$('#confirm-password').on( "keyup", validatePassword);
});

function register(){
	
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var username = $('#username').val();
	var password = $('#password').val();
	var email = $('#email').val();
	var selectrole = $('#selectrole').find('.active');
	var userRoleId = selectrole.find('input').attr('id');
	
	var user = {
			users_id: 0,
			username: username,
			password: password,
			firstname: firstname,
			lastname: lastname,
			email: email,
			userRoleId: userRoleId	
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
			console.log(xhr.responseText);
			alert("Success! Please login using your credentials");
			//window.location.replace('index.html');
		}
	};
	
	xhr.open("POST", "register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	
}


function validateEmail(){
	
	var email = $('#email').val();
	var information = [email, ""];
	
	var json = JSON.stringify(information);
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			console.log("USER: " + user);
			if(user == null){
				$('#email-message').show();
				$('#email-message').html("Email already exists. Please use another email.") ;
				$('#register-submit').attr("disabled",true);
			}
			else{
				$('#register-submit').attr("disabled",false);
				$('#email-message').hide();
			}
		}
	}

	xhr.open("POST", "validateEmail", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}


function validateUsername(){
	
	var username = $('#username').val();
	var information = [username, ""];
	
	var json = JSON.stringify(information);
	
	console.log("here");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("statechange");
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			console.log("USER: " + user);
			if(user == null){
				$('#username-message').show();
				$('#username-message').html("Username already exists. Please pick another username.") ;
				$('#register-submit').attr("disabled",true);
			}
			else{
				$('#register-submit').attr("disabled",false);
				$('#username-message').hide();
			}
		}
	}

	xhr.open("POST", "validateUsername", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	console.log("after send");
	
}

function validatePassword(){
	var password = $('#password').val();
	var confirmPassword = $('#confirm-password').val();
	console.log("in validate pass");
	if(password != confirmPassword){
		$('#password-message').show();
		$('#password-message').html("Password does not match.");
		$('#register').attr("disabled", true);
	}
	else{
		$('#register').attr("disabled", false);
		$('#password-message').hide();
	}
	
}









