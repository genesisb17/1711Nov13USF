/**
 * main page of the application. thinking about creating a pseudo 
 * 	"admin" role based on a userame and password of admin for demo 
 * 	purposes 
 * 
 * for load profile.
 * window opens 
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
	//send AJAX request to some type of getUserInfo Servlet
	//store user as object and access here
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			loadProfileInfo  ();
			//this next call sometimes must be at the end of the load view
			//because of the asynchronous nature of ajax.
			//keep manipulation of DOM inside each method.
			//(didn't work in class until this was moved to the loadView(page)
			
		}
	}
	xhr.open("GET","getUserInfo",true);
	xhr.send();
	
	loadView("getProfileView");
}

function loadProfileInfo(){
	//here, we're just returning the info we got from our get user session
	//from the server(?)
	var sessionUser;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.firstname/*map to exact instance variable on pojo*/)
			return sessionUser;
		}
	}
	xhr.open("GET","getUserInfo",true);
	xhr.send();
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

