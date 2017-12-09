/**
 * previously app.js
 */
window.onload = function()
{
	console.log("test1")
	$('#message').hide();
	$('#login').on('click',login);	
}

function login()
{
	console.log("test2");
	var username = $('#username').val();
	var password = $('#pass').val();
	
	var toSend = [username, password];
	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 && xhr.status==200)
		{
			console.log("in xhr callback" + xhr.responseText);
			//var user = JSON.parse(xhr.responseText);
			var user = xhr.responseText;
			$('#message').show();
			if(user == null)
			{
				$('#message').html("Invalid user") ;
				alert("error1");
			}
			else if(user.id == 0)
			{
				$('#message').html( "Invalid password");
				alert("error2");
			}
			else
			{
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