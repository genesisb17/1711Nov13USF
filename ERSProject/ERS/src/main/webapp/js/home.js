/**
 * 
 */
window.onload = function(){
	$('#home').on('click',loadHome);
	$('#profile').on('click', loadProfile);
	$('#submit').on('click', loadSubmit);
}


function loadHome(){
	loadView("home");
}

function loadProfile(){
	loadView("profile");
}
function loadSubmit(){
	loadView("submit");
}

function loadView(page){
	alert("loading view" + page);
	var goto; //servlet location
	switch(page){
	case "home":
		goto="getHomeView";//url pattern for servlet that will load home page
		break;
	case "profile":
		goto="getProfileView"; //url pattern for servlet that will load profile page
		break;
	case "submit":
		goto="getSubmitView"; // url pattern for servlet that will load submit page
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	console.log("REQUESTING VIEW " + goto);
	
	xhr.open("GET", goto, true);
	xhr.send();
	
	
}