
window.onload = function(){

	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click', register);
}

$('document').ready(function(){
	logout();// logout page will direct user here and log them out ....so just make sure the user isn't stored here jah

});


function logout(){

	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'logout', true);
	xhr.onprogress = function () {
	};
	xhr.onload = function () {
	};
	xhr.send(null);



};


function login(){

	var username = $('#username').val().trim();
	var password = $('#password').val().trim();
	var toSend = [username, password];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest(); 	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user.username == null){
				$('#message').show();
				$('#message').html("Login Failed") ;
			}
			if(user.id == 0){
				$('#message').show();
				$('#message').html( "Login Failed");
			}
			else{
				if(user.role==0)
					window.location.replace('admin.html');
				if(user.role==1)
					window.location.replace('members.html');
			}
		}
	};

	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);


}

function register(){
	window.location.replace('register.html');
}