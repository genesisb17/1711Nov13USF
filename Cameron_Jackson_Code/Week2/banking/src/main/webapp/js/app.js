/**
 * 
 */
window.onload = function () {
	loadHome();
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
	$('#thebank').on('click', loadHome);

}

$('#logoutModal').on('shown.bs.modal', function () {
	$('#logoutModal').trigger('focus');
	$('#modal-logout').on('click', function() {
		console.log("logout bruh");
		window.location.replace("landing.html");
	});
  });

function loadHome() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			loadUserInfo();
		}
	}

	xhr.open("GET", "getHomeView", true);
	xhr.send();
}

function loadProfile() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			loadUserInfo();
		}
	}

	xhr.open("GET", "getProfileView", true);
	xhr.send();
}

function loadUserInfo() {
	var sessionUser;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.firstname + " " + sessionUser.lastname);
			return sessionUser;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	
}