/**
 * 
 */
window.onload = function () {
	$('#login').on('click', login);
	$('#register').on('click', register);
	$('#message').hide();
}

function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	var user = {
		userId: 0,
		firstname: null,
		lastname: null,
		username: username,
		password: password
	};
	//	var user = [username, password];
	var tx = JSON.stringify(user);
	console.log(tx);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {
		console.log("ready state: " + xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if (user == null) {
				$('#message').show();
				$('#message').html("Invalid username or password");
				$('#password').val("");
			}
			else {
				document.location.replace('app.html');
			}
		}
	};
	if (user.username != null && user.password != null) {
		xhr.open("POST", "login", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(tx);
	}
}

function register() {
	window.location.replace("register.html");
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var username = $('#r-username').val();
	var password = $('#r-password').val();

	var user = {
		userId: 0,
		firstname: firstname,
		lastname: lastname,
		username: username,
		password: password
	}

	var tx = JSON.stringify(user);
	var xhr = new XMLHttpRequest();

	if (user.firstname != null && user.lastname != null &&
		user.username != null && user.password != null) {
		xhr.open("POST", "register", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(tx);
	}

	xhr.onreadystatechange = function () {
		console.log("sending request");
	};

	$('#firstname').val("");
	$('#lastname').val("");
	$('#r-username').val("");
	$('#r-password').val("");
}