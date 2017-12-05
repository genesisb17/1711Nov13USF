window.onload = function() {
	loadHome();
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
	$('#logout').on('click', logout);
}

function loadHome(){
	loadView("employeeHome");
}
function loadProfile(){
	loadView("employeeProfile");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			document.getElementById('userInfo').innerHTML = "<p>First name: " + user.firstname + "</p>" +
					"<p>Last name: " + user.lastname + "</p>" +"<p>Username: " + user.username + "</p>" +
					"<p>Email: " + user.email + "</p>" + "<p>Role: " + user.role + "</p>";
		}
	}
	xhr.open("GET", "employeeInfo", true);
	xhr.send();	
}
function loadView(page){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", page, true);
	xhr.send();
}
function logout(){
	window.location.replace('login.html');
}