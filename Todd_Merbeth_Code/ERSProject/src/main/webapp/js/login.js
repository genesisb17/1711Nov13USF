/**
 * 
 */
window.onload = function(){
	$('#login').on('click', login);
	$('#register').on('click', register);
}

function login(){
	var username = $('#username').val();
	var password = $('#password').val();
	var json1 = [username, password];
	var json = JSON.stringify(json1);
	
	console.log(json);
	
	//AJAX stuff
	var xhr = new XMLHttpRequest();
	//ReadyState = 0, Client has been created. open() not called yet.
	xhr.onreadystatechange = function(){  // this will happen last, is a callback
		console.log("ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
			var user = JSON.parse(xhr.responseText);
			$('#outcome').show();
			if(user == null){
				$('#outcome').html("Invalid username or password") ;
			}
			else{
//				$('#outcome').html(`Welcome ${user.firstname}`);
				window.location.replace('logged.html');
			}
		}
	};
	
	xhr.open("POST", "login", true);	// what to do, what servlet address (the @WebServlet("/login") in this case), asynchronous request
	//ReadyState = 1, open() has been called.
	xhr.setRequestHeader("Content-type", "application/x-www.form-urlencoded");
	xhr.send(json);
	//ReadyState = 2 send() has been called, and headers and status are available
	
	
	
	//End AJAX stuff
}

function register(){
	window.location.replace('register.html');
}



