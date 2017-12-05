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
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;				
		}
	}	
	xhr.open("GET", "getHomeView" , true);
	xhr.send();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getProfileView" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;//partials/profile.html	
			loadProfileInfo();
		}
	}
}


function loadProfileInfo(){
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET","getUserInfo", true);
	xhr.send();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.firstname);
			return sessionUser;
		}
	}
}






