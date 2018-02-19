window.onload = function(){
	loadLoginView();
}

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			console.log("loaded login");
			//now we can add event listeners to the loaded view, to add functionality 
			$('#login').on('click',login);
			$('#register').on('click', loadRegisterView);

		}
	}
	xhr.open("GET", "login.page" , true);
	xhr.send();
	//
}

function loadRegisterView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#message').hide();
			$('#register').on('click', register);
			$('#username').blur(validateEmail);
		}
	}
	xhr.open("GET", "register.page" , true);
	xhr.send();
}

function login(){
//	alert("logging in");
	var username = $('#username').val();
	var password = $('#pass').val();
	
	var toSend = [username, password];

	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
//	var x = `READY STATE = ${xhr.readyState}` ;
	console.log("READY STATE = " + xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null){
				$('#message').html("Invalid user") ;
			}
			else if(user.id == 0){
				$('#message').html( "Invalid password");
			}
			else{
				console.log("success!");
				$('#view').html(`Welcome ${user.firstname}`) ;
				
				
				
			}
		}
	};
	xhr.open("POST","login", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);
	

}
function register(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var uname = $('#username').val();
	var pass = $('#pass').val();

	var user = {
			id: 0,
			firstname: fn,
			lastname: ln, 
			email: uname, 
			password: pass
	};
	var json = JSON.stringify(user);
	console.log(json);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
			$('#message').hide();
			var welcome = `Welcome ${uname}! Please log in using your credentials`;
			alert(welcome);
			window.location.replace('index.html');
		}		
	}
	xhr.open("POST", "register", true);
	xhr.setRequestHeader("Content-type",
	"application/x-www-form-urlencoded");
	xhr.send(json);
	



}

function validateEmail(){
	console.log("in validate email method");
	var username = $('#username').val();
	//var json = JSON.stringify(username);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var text = xhr.responseText;
			if(text != "DNE"){
				$('#message').show();
				$('#message').html("Username already exists! Please try another");
			}
		}
	}

	xhr.open("POST", "validate", true);
	xhr.setRequestHeader("Content-type",
	"application/x-www-form-urlencoded");
	xhr.send(username);


}