/**
 * Main page of the application thinking about creating a
 * pseudo admin role based on a username and password of
 * admin for demo purposes
 */

window.onload = function(){
	loadHome();
	$('#home').on('click',loadHome);
	$('#profile').on('click',loadProfile);
}

function loadHome(){
	loadView("home");
}

function loadProfile(){
	loadView("profile");
}

function loadView(page){
	alert("loading view" + page);
	var goto; //servlet locatoin
	switch(page){
	case "home":
		goto="getHomeView";//url pattern for servlet
		break;
	case "profile":
		goto="getProfileView"; //url pattern for servlet
		break;
	}
	var xhr = new XMLHttpRequest();
	xhr.oonreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	console.log("REQUESTING VIEW " + goto);
	
	xhr.open("GET", goto, true);
	xhr.send();
	
	
}