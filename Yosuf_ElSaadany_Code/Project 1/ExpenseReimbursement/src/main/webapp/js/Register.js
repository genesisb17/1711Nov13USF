
window.onload = function(){
	$('#message').hide();
	$('#register1').on('click', register);
	$('#login1').on('click', login);
}


function login() {
	window.location.replace('Login.html');
}

function register() {
	$('#message').hide();
	var username = $("#username").val();
	var password = $("#password").val();
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var email = $("#email").val();
	var userRole = $("#userRole").val();
	
	if(userRole == "Employee")
		userRole = 1;
	else if(userRole == "Manager")
		userRole = 2;
		
	if(username == "" || password == "" || firstname == "" || lastname == "" || email == "" || userRole == null) {
		$('#message').show();
		$('#message').html("Please enter all information");
		$(function() {
			setTimeout(function() {
				$("#message").hide('blind', {}, 500)
		    }, 2000);
		});
	}
	else {
		var toSend = [username, password, firstname, lastname, email, userRole];
		var json = JSON.stringify(toSend);	
				
		var xhr = new XMLHttpRequest();
		xhr.open("POST","Register",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(json);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status==200){
				var user = JSON.parse(xhr.responseText);
				var username = user.username;
				var email = user.email;
				if(username == null){
					$('#message').show();
					$('#message').html("Username already used");
					$(function() {
						setTimeout(function() {
							$("#message").hide('blind', {}, 500)
					    }, 2000);
					 });
				}
				else if(email == null) {
					$('#message').show();
					$('#message').html("Email already used");
					$(function() {
						setTimeout(function() {
							$("#message").hide('blind', {}, 500)
					    }, 2000);
					});
				}
				else {
					window.location.replace('Login.html');
				}
			}
		};
	}
}

