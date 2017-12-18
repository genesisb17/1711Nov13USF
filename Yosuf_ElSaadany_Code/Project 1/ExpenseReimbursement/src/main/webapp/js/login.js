
window.onload = function(){
	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click',register);	
}

var username;
var password;

function login() {
	$('#message').hide();
	username = $('#username').val();
	password = $('#password').val();
	var toSend = [username, password];
	var json = JSON.stringify(toSend);	
	var xhr = new XMLHttpRequest();
	if(username == "" || password == ""){
		$('#message').show();
		$('#message').html("Please enter all information");
	    $(function() {
	        setTimeout(function() {
	            $("#message").hide('blind', {}, 500)
	        }, 2000);
	    });
	}
	else {
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#message').show();
				$('#message').html("Invalid Credentials");
				 $(function() {
				        setTimeout(function() {
				            $("#message").hide('blind', {}, 500)
				        }, 2000);
				    });
			}
			else {
				window.location.replace('Home.html');
			}
		}
	};
	
	xhr.open("POST","login",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}
}

function register(){
	window.location.replace('Register.html');
}

