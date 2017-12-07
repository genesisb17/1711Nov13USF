/**
 * 
 */

window.onload = function(){
	
	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click', register);
}
	
	function login(){
		
		var username = $('#username').val();
		var password = $('#password').val();
		
		var toSend = [username, password];
		
		var user = {
			
		}
		
		var json = JSON.stringify(toSend);
		
		var xhr = new XMLHttpRequest();
		console.log(xhr.readyState);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status==200){
				console.log("in xhr callback " + xhr.responseText);
				$('#message').show();
				if(xhr.responseText==""){
					console.log("can't");
					//$('#message').html("Login failed.");
					alert("Login failed!")
				}
				//var user = JSON.parse(xhr.responseText);
				//console.log(user);
				//if(user == null){
					
				//}
				//else if(user.id == 0){
					//$('#message').html( "Invalid password");
				//}
				else{
					var user = JSON.parse(xhr.responseText);
					$('#message').html(`Welcome ${user.firstname}`) ;
					window.location.replace('app.html');
					console.log("success!");
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
		 	//alert("registering");
		 	window.location.replace('register.html');
		  } 