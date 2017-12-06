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
	xhr.open("GET", "view/home" , true);
	xhr.send();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "view/profile" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;//partials/profile.html	
			loadProfileView();
			
			console.log("TESTING IF WE ARE GETTING THE USER" + test);
		
		}
	}
}

function loadProfileView(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","getUserInfo", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.firstname);
		}
	}
	
	
}






