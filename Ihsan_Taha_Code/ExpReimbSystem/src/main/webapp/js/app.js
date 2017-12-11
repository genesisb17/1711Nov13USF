window.onload = function(){
	alert("Hi from app.js");
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
}

function loadHome() {
	loadView("getHomeView");
}

function loadProfile() {
	loadView("getProfileView");
}

function loadView(page) {
		
	alert(page);
	alert("Before xhr.onreadystatechange");
	document.getElementById('view').innerHTML = "Bye";
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;	
			alert("In xhr.onreadystatechange");
		}
	}
	
	alert("After xhr.onreadystatechange");
	
	console.log("Requesting View " + page);
	
	xhr.open("GET", page, true);
	
	xhr.send();
};
