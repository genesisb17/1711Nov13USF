/**
 * 
 */

window.onload = function(){
	$('#login-submit').on('click', login);
}

function login(){
	var username = $('#loginusername').val();
	var password = $('#loginpassword').val();

	var information = [username, password];
	
	console.log(information);
	
	var json = JSON.stringify(information);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback " + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null || user.id == 0){
				$('#message').html("Your username or password is incorrect.") ;
			}
			else{
				$('#message').html(`Welcome ${user.firstname}`) ;
				loadApp();
				console.log("success!");
				loadHome();
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}

function loadApp(){
	var xhr = new XMLHttpRequest();
	console.log("load app");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//window.location.replace(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			console.log("load app2");
			$('#home').on('click',loadHome);
			$('#profile').on('click', loadProfile);
		}
	}	
	xhr.open("GET", "landingpage" , true);
	xhr.send();
}

function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;				
		}
	}	
	xhr.open("GET", "home.view" , true);
	xhr.send();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "profile.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;//partials/profile.html	
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

