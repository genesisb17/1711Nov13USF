
window.onload = function(){
	$('#register').on('click', register);
	$('#emai2l').blur(validateEmail);
	$('#username').blur(validateUsername);
	$('#role').blur(validRole);
	$('#register').attr("disabled",true);
	$(`#rolemessage`).hide()
	$(`#emailmessage`).hide()
	$(`#usernamemessage`).hide()



}
var logincheck = false;
var emailcheck = false;
//checks role type 
function validRole(){
	var role = $(`#role`).val().trim();
	//console.log(role);
	if (isNaN(role) || role < 0 || role > 1) {
		$(`#rolemessage`).html("only 0 or 1 are valid current input will default to 1");
		$(`#rolemessage`).show();
	}
	else	{
		$(`#rolemessage`).hide();
	}
}
//validates email 
function validateEmail(){
	var email = $(`#emai2l`).val().trim();
	var toSend=[email,""];
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();

	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			//console.log("in xhr callback "+xhr.responseText)
			var user =JSON.parse(xhr.responseText);
			$(`#emailmessage`).show();
			if(user.email !=null){
				$('#emailmessage').show();
				$('#emailmessage').html("Email Already in use! Please try another") ;
				$('#register').attr("disabled",true);
				emailcheck=false;
			}
			else {
				
				$('#emailmessage').hide();
				$('#register').attr("disabled",false); 
				emailcheck=true;
			}
		}
	};
	xhr.open("POST","validator2",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}
//validates username 
function validateUsername(){
	var username = $('#username').val().trim();
	var toSend=[username,""];
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			//console.log("in the xhr callback for username val "+ xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$(`#usernamemessage`).show();
			if(user.username!=null){

				$(`#usernamemessage`).show();
				$(`#usernamemessage`).html("username already used pelease try another ");
				$(`register`).attr("disabled", true );
				logincheck=false;
			}
			else{
				$(`#usernamemessage`).hide();
				$(`register`).attr("disabled", false );
				logincheck=true;
			}
		}
	};
	xhr.open("POST","validator",true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

// does some validation , sends information to servlets for registration
function register(){
	if($('#username').val().trim()==""){
		alert("Enter your username");
	return; }
	if($('#fn').val().trim()==""){
		alert("Enter your First name");
	return; }
	if($('#ln').val().trim()==""){
		alert("Enter your Last name");
	return; }
  if(logincheck == false){
		alert("Please Check your username");
		return; }
 if($(`#emai2l`).val().trim()==""){
		alert("Please Enter your email");
		return; }
 if(emailcheck==false){
		alert("Please Check your email");
		return; }
 if($('#pass').val().trim()==""){
		alert("Please enter your password");
		return; }
 if($(`#role`).val().trim()==""){
		alert("Please enter your Role");
		return; }
 
	var fitname = $(`#fn`).val().trim();
	var latname = $(`#ln`).val().trim();
	var emil = $(`#emai2l`).val().trim();
	var usrname = $('#username').val().trim();
	var pasword = $('#pass').val().trim();
	var  roe=parseInt($(`#role`).val());
	if (roe==0)
		roe=roe;
	else
		roe=1;
	var user = {
			id: 0,
			username: usrname,
			password: pasword,
			lastname: latname, 
			name: fitname,        
			email: emil,
			role:roe 
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
	}

	};



	xhr.open("POST","register", true);  
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('Login.html');
	
}

