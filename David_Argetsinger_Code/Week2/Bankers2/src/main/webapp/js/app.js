/**
 * 
 */
window.onload=function(){
	$(`#login`).on(`click`,login);
	$(`#register`).on(`click`,register);
}	

function login() { 
	alert("Loggin in");
	var username=$(`#username`).val();
	var password= $(`#password`).val();
	//var trans=[username,password];
//	var user={
//			name: username,
//			password:password
//	};
	//if using json 
	//var tx=JSON.stringify(user);
	var json=JSON.stringify(user);
	//console.log(tx);
	console.log(json);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange= function(){
		if(xhr.readyState==4 && xhr.status==200)
		{
			console.log("in xhr callback ")
		}
	};
	xhr.open("POST", "login",true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded" )
	xhr.send(json);
}

function register(){
	alert("Registering ");
}