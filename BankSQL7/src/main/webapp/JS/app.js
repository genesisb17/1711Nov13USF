window.onload = function()
{
	$('#message').hide();
	$('#login').on('click',login);
	$('#register').on('click', register);
	
}
function login()
{
//	alert("logging in");
	var username = $('#username').val();
	var password = $('#pass').val();
	
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
				$('#message').html(`Welcome ${user.firstname}`) ;
				window.location.replace('landing.html');
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

function register()
{
	window.location.replace('reg.html');
}
function getUserInfo()
{
	var sessionUser;
	var xhr = XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState ==4&&xhr.status ==200)
		{
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			return sessionUser;
		}
	}
	xhr.open("GET","getUserInfo",true);
	xhr.send();
}
function loadProfile()
{
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function()
	{
		if(xhr.readyState==4&&xhr.status==200)
			{
				document.getElementById('view').innerHTML=xhr.responseText;
			}
	}
}


