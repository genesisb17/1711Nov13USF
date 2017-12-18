/**
 * 
 */

window.onload = function(){
	$('#message').hide();
//	$('#login').on('click',login);
	$('#register').on('click', register);
	$('#login').on('click',controller);
}
function controller(){
	var username = $('#username').val();
	var password = $('#pass').val();
	if(username.length == 0 || password.length ==0){
		$('#message').show();
		$('#message').html("Username or Password cannot be empty. Try Again.");
	}
	else{
		var toSend =[username,password];
		var json = JSON.stringify(toSend);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log("ready state check");
				var user = JSON.parse(xhr.responseText)
				if(user.id !=0){
					window.location.assign("home.html");
					document.getElementById('view').innerHTML = "<h2> yoooo </h2>";
				}
				else{
				$('#message').show();
				$('#message').html("Invalid user");
				}
			}
		}
		xhr.open("POST","enterServlet", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(json);
	
	}
	

}

function register(){
	//create servlet that will forward to
	window.location.assign('register.html');
}