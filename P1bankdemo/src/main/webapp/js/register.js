

window.onload = function(){
	$('#message').hide();
	$('#register').on('click', register);
	$('#username').blur(validateEmail);
	$('#register').attr("disabled",true);
	
}

//function onblur that notifies the user of whether or not their email address is already in use 
function validateEmail(){
	$('#register').attr("disabled",false);
	$('#message').hide();
	var username = $('#username').val();
	
	var toSend = [username, ""];

	
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user != null){
				$('#message').html("Username Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
		}
	};
	
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

function register(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var uname = $('#username').val();
	var pass = $('#pass').val();
	// add password validation and second input confirmation?

	var user = {
			id: 0,
			firstname: fn,
			lastname: ln, 
			email: uname, 
			password: pass
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('landing.html');
}




function validatePass(){
	// got from internet. need to edit keeping for ideas 
	$('input[type=password]').keyup(function() {
		var pswd = $(this).val();

		//validate the length
		if ( pswd.length < 8 ) {
			$('#length').removeClass('valid').addClass('invalid');
		} else {
			$('#length').removeClass('invalid').addClass('valid');
		}

		//validate letter
		if ( pswd.match(/[A-z]/) ) {
			$('#letter').removeClass('invalid').addClass('valid');
		} else {
			$('#letter').removeClass('valid').addClass('invalid');
		}

		//validate capital letter
		if ( pswd.match(/[A-Z]/) ) {
			$('#capital').removeClass('invalid').addClass('valid');
		} else {
			$('#capital').removeClass('valid').addClass('invalid');
		}

		//validate number
		if ( pswd.match(/\d/) ) {
			$('#number').removeClass('invalid').addClass('valid');
		} else {
			$('#number').removeClass('valid').addClass('invalid');
		}

		//validate space
		if ( pswd.match(/[^a-zA-Z0-9\-\/]/) ) {
			$('#space').removeClass('invalid').addClass('valid');
		} else {
			$('#space').removeClass('valid').addClass('invalid');
		}

	}).focus(function() {
		$('#pswd_info').show();
	}).blur(function() {
		$('#pswd_info').hide();
	});

};