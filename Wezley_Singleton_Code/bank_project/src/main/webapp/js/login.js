window.onload = function() {
	$('#message').hide();
	$('#login').on('click', login);
	$('#register').on('click', register);
}

function login() {
	alert("TEST");
	var username = $('#username').val();
	var password = $('#password').val();
	
	var toSend = [username, password];
	
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			$("#message").show();
			
			if (user == null) {
				$("#message").html("Invalid username!");
			}
			
			else if (user.id == 0) {
				$("#message").html("Invalid password!");
			}
			
			else {
				$("#message").html(`Welcome, ${user.username}`);
				window.location.replace("app.html");
				console.log(`User id: ${user.id} login successful!`);
			}
		}
	};
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function register() {
	window.location.replace("register.html");
}