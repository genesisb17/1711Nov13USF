/**
 * 
 */
window.onload = function () {
	loadHome();
	$('#home').on('click', loadHome);
	$('#profile').on('click').loadProfile);
	$('#login').on('click', login);
	$('#register').on('click', register);
}

function loadHome() {
	loadView("home");
}

function loadProfile() {
	loadView("profile");
}

function loadView(page) {
	var goto;
	switch (page) {
		case "home":
			goto = "getHomeView";
			break;
		case "profile":
			goto = "getProfileView";
			break;
		default:
	}

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('')
		}
	}
}

function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	var user = {
		username: username,
		password: password
	};
	//	var user = [username, password];
	var tx = JSON.stringify(user);
	console.log(tx);

	var xhr = new XMLHttpRequest();

	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	xhr.onreadystatechange = function () {
		console.log("ready state: " + xhr.readyState);
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
		}
	};

}

function register() {
	window.location.assign("/register.html");
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

	xhr.open("POST", "register", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx);
	xhr.onreadystatechange = function () {
		console.log("sending request");
	};

	$('#firstname').val("");
	$('#lastname').val("");
	$('#r-username').val("");
	$('#r-password').val("");
	window.location.assign("/landing.html");
}