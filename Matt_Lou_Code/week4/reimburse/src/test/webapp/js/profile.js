/**
 * 
 */

window.onload = function(){
	$("#profile").on("click", updateProfile);
	$("#home").on("click", loadHome);
	$("#logout").on("click", logout);
}


$(document).ready(function(){
	$('.email').blur(validateEmail);
});

function logout() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			window.location.replace("index.html");
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();

}

function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user.userRoleId == 1){
				window.location.replace("manager.html");
			} 
			else if(user.userRoleId == 2) {
				window.location.replace("submitrequest.html");
			}
			else{
				window.location.replace("index.html");
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	//window.location.replace("submitrequest.html");
}

function updateProfile(){
	console.log("in function");
	alert("Your information has been updated.");
	var firstname = $(".firstname").val();
	var lastname = $(".lastname").val();
	var email = $(".email").val();
	
	var toSend = {
		firstname: firstname,
		lastname: lastname,
		email: email
	}
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			//alert("Your information has been updated.");
		}
	}
	xhr.open("POST", "updateservlet", true);
	xhr.send(json);
}

function validateEmail(){
	
	var email = $('.email').val();
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
				$('#profile').attr("disabled",true);
			}
			else{
				$('#profile').attr("disabled",false);
				$('#email-message').hide();
			}
		}
	}

	xhr.open("POST", "validateEmail", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}