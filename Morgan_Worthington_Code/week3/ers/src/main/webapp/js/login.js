/**
 * 
 */
window.onload= function(){
	sendToLogin();
};

function requestValid(){
	var user=$("#username").val();
	var pass= $("#password").val();
	credentials=[user, pass];
	json=JSON.stringify(credentials);
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			response=xhr.responseText;
			if(response == 'Validated.'){
				sendToProfile();
			} else {
				$("#notification").html(response);
			}
			
		}
	}
	xhr.open("POST","validLogin",true);
	xhr.send(json);
};

function sendToRegister(){
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			registerPage=xhr.responseText;
			$("#view").html(registerPage);
		}
	}
	xhr.open("GET","register.view",true);
	xhr.send();
};

function sendToLogin(){
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			loginPage=xhr.responseText;
			$("#view").html(loginPage);
			$("#login").on('click',requestValid);
			$("#register").on('click',sendToRegister);
		}
	}
	xhr.open("GET","login.view",true);
	xhr.send();
};

function sendToProfile(){
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			profilePage=xhr.responseText;
			$("#view").html(profilePage);
		}
	}
	xhr.open("GET","profile.view",true);
	xhr.send();
};