
window.onload = function(){
	$('#message').hide();
	$('#register1').on('click', register);
	$('#login1').on('click', login);
}


function login() {
	window.location.replace('Login.html');
}

function register() {
	$('#message').hide();
	var username = $("#username").val();
	var password = $("#password").val();
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var email = $("#email").val();
	var userrole = $("#userrole").val();
	
	if(userrole == "Employee")
		userrole = 1;
	else userrole = 2;
		
	if(username == "" || password == "" || firstname == "" || lastname == "" || email == "" || userrole == "") {
		$('#message').show();
		$('#message').html("Please enter all information");
		 $(function() {
		        setTimeout(function() {
		            $("#message").hide('blind', {}, 500)
		        }, 2000);
		    });
	}
	else {
	var toSend = [username, password, firstname, lastname, email, userrole];
	var json = JSON.stringify(toSend);	
	
	console.log("HERE");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == 1) {
				window.location.replace('Login.html');
			}
			else {
				$('#message').show();
				$('#message').html("Username or email already used");
				 $(function() {
				        setTimeout(function() {
				            $("#message").hide('blind', {}, 500)
				        }, 2000);
				    });
			}
		}
	};
	
	console.log(json);
	xhr.open("POST","Register",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}
}

