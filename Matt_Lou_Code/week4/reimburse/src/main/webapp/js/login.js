/**
 * 
 */

window.onload = function(){
	$('#login-submit').on('click', login);
	$("#register-submit").on("click", register);
	$('#email-message').hide();
	$('#username-message').hide();
	//$('#password-message').hide();
	$('#register-submit').attr("disabled",true);
}


$(document).ready(function(){
	$('#email').blur(validateEmail);
	$('#username').blur(validateUsername);
	//$('#confirm-password').blur(validatePassword);
});

function register(){
	console.log("in register function");
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
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('landing.html');
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
	var password = $('password').val();
	var confirmPassword = $('confirm-password').val();
	if(password != confirmPassword){
		$('#password-message').show();
		$('#password-message').html("Password does not match.");
		$('#register').attr("disabled",true);
	}
	else{
		$('#register').attr("disabled",false);
		$('#password-message').hide();
	}
	
}








function login(){
	var username = $('#loginusername').val();
	var password = $('#loginpassword').val();

	var information = [username, password];
	
	console.log(information);
	
	var json = JSON.stringify(information);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback " + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null || user.id == 0){
				$('#message').html("Your username or password is incorrect.") ;
			}
			else{
				$('#message').html(`Welcome ${user.firstname}`) ;
				console.log("success!");
				
				// go to manager page
				if(user.userRoleId == 1){
					window.location.replace("manager.html");
				}
				// userRoleId is 2, go to employee page
				else {
					window.location.replace("submitrequest.html")
				}
					
				
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}

function loadSubmitRequestPage(){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//window.location.replace(xhr.responseText);
			window.location.assign('landing.html');
			
		}
	}
	
	xhr.open("GET", "forwardsubmitrequest", true);
	xhr.send();
}



//function loadApp(){
//	var xhr = new XMLHttpRequest();
//	console.log("load app");
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//window.location.replace(xhr.responseText);
//			document.getElementById('view').innerHTML = xhr.responseText;
//			console.log("load app2");
//			$('#home').on('click',loadHome);
//			$('#profile').on('click', loadProfile);
//		}
//	}	
//	xhr.open("GET", "landingpage" , true);
//	xhr.send();
//}
//
//function loadHome(){
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			document.getElementById('appview').innerHTML = xhr.responseText;				
//		}
//	}	
//	xhr.open("GET", "home.view" , true);
//	xhr.send();
//}
//
//function loadProfile(){
//	var xhr = new XMLHttpRequest();
//	xhr.open("GET", "profile.view" , true);
//	xhr.send();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			document.getElementById('appview').innerHTML = xhr.responseText;//partials/profile.html	
//			loadProfileView();
//			
//			console.log("TESTING IF WE ARE GETTING THE USER" + test);
//		
//		}
//	}
//}
//
//function loadProfileView(){
//	var xhr = new XMLHttpRequest();
//	xhr.open("GET","getUserInfo", true);
//	xhr.send();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			console.log(xhr.responseText);
//			var sessionUser = JSON.parse(xhr.responseText);
//			$("#name").html(sessionUser.firstname);
//		}
//	}
//}
//
