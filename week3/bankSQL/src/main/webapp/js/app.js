/**
 * 
 */

window.onload = function(){
	$('#login').on('click',login);
	$('#register').on('click',register);
	
}

function loadHome(){
	loadView("getHomeView");
}

function loadProfile(){
	loadView("getProfileView");
	//send AJAX request to some type of getUserInfo Servlet.
	//store user as object and access here

	console.log("loaded profile view");
}
function loadView(page){
	var xhr= new XMLHttpRequest();
	xhr.onreadstatechange= function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('view').innerHTML=xhr.responseText;
			$('#name').html("Test");
		}
	}
	console.log("REQUESTING VIEW "+page)
	xhr.open("GET",page,true);
	xhr.send();
};


function getUserInfo(){
	var user = {}; // AJAX call
}