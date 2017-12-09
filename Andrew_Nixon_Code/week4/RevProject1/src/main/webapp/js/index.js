/**
 * 
 */

window.onload = function(){
	$('#message').hide();
	$('#login').on('click',login);

}

function login(){
	//window.location.replace('LoginSuccess.html');
	//1. check if user name is in database.
	var username = $('#username').val();
	var password = $('#password').val();
	var toSend = [username, password];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	
	xhr.open("POST","userLogin", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				//$('#message').html("Invalid user") ;
				console.log("bad name!");
			}
			else if(user.id == -1){
				//$('#message').html( "Invalid password");
				console.log("bad pass!");
			}
			else{
				$('#message').html(`Welcome ${user.firstname}`) ;
				console.log("good combo!");
				//window.location.replace('LoginSuccess.html');				
			}
		}		
	}
}

function loadMain(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//	window.location.replace(xhr.responseText);
		document.getElementById('view').innerHTML = xhr.responseText;
		$('#home').on('click',loadHome);
		$('#profile').on('click', loadProfile);
		}
	}	
	xhr.open("GET", "app.view" , true);
	xhr.send();
}
