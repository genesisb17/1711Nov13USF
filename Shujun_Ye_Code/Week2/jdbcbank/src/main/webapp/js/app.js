/**
 * main page of the application. thinking about creating a pseudo 
 * 	"admin" role based on a userame and password of admin for demo 
 * 	purposes 
 */

window.onload = function(){
	$('#home').on('click',loadHome);
	$('#profile').on('click', loadProfile);
}

function loadHome(){
	loadView("home");
}
function loadProfile(){
	loadView("profile");
}
function loadView(page){
	var goto = "loadView";
	
	switch(page){
	case "home":
		goto+="/home";
		break;
	case "profile":
		goto+="/profile";
		break;
	}
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getAcctPageInfo(); // loads user info by calling function
			listenforEdits();
		}
	}
	console.log("getting accts")
	xhr.open("GET", goto , true);
	xhr.send();
};