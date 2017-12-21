window.onload = function() {
	getUser();
	$('#EditProfile').on('click', editProfile);
	$('#EditPassword').on('click', editPassword);
	$('#logout').on('click', logout);
	$('#home').on('click', home);
}

function getUser(){
	var test=0;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user==null){
				window.location.replace('StartPage.html');
			}
		}
	};
	
	xhr.open("POST","getUserInfo", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(test);
}

function home(){
	var home=0;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user.role==1){
				window.location.replace('HomePage-Manager.html');
			}else{
				window.location.replace('HomePage.html');
			}
		}
	};
	
	xhr.open("POST","getUserInfo", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(home);
}

function logout(){
	window.location.replace('StartPage.html')
}

function editProfile(){
	var email= $('#email').val();
	var firstname=$('#firstname').val();
	var lastname=$('#lastname').val();
	var info=[email,firstname,lastname];
	var infoJSON=JSON.stringify(info);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var info = JSON.parse(xhr.responseText);
		}
	};
	xhr.open("POST", "EditProfile", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(infoJSON);
}

function editPassword(){
	var oldPass = $('#oldPassword').val();
	var newPass = $('#newPassword').val();
	
	var pass=[oldPass, newPass];
	
	var passJSON = JSON.stringify(pass);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var pass = JSON.parse(xhr.responseText);
		}
	};
	xhr.open("POST", "EditPass", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(passJSON);
}