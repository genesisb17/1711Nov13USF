/**
 * crie.js
 */

window.onload = function(){
	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click', register);
	
}

function login(){
	
	var username = $('#username').val().trim();
	var password = $('#password').val().trim();
	var toSend = [username, password];

	
	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest(); 	
	console.log(xhr.readyState);
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
				if(user.role==0)
				window.location.replace('admin.html');
				if(user.role==1)
				window.location.replace('members.html');
				//console.log("success!");
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
	window.location.replace('register.html');
}