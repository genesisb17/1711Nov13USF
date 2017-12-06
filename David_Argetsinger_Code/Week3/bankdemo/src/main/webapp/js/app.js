/**
 * main page of the application. thinking about creating a pseudo 
 * 	"admin" role based on a userame and password of admin for demo 
 * 	purposes 
 */

window.onload = function(){
	loadHome();
	$('#home').on('click',loadHome);
	$('#profile').on('click', loadProfile);
}

function loadHome(){
	loadView("getHomeView");
}
function loadProfile(){
	loadView("getProfileView");
}
function loadView(page){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;			
		}
	}
	console.log("REQUESTING VIEW " + page)
	
	xhr.open("GET", page , true);
	xhr.send();
};