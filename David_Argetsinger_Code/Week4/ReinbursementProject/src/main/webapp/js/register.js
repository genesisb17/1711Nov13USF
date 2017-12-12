/**
 * cry.jpeg
 */

window.onload = function(){
	$('#message').hide();
	$('#register').on('click', register);
	$('#emai2l').blur(validateEmail);
	$('#username').blur(validateUsername);
	$('#role').blur(validRole);
	$('#register').attr("disabled",true);
	


}
//onblur is to say when not focused, when they switch to a different field for instance 

function validRole(){
	//console.log (" in valiD ROLE	 function (blurred)")
	var role = $(`#role`).val().trim();
	console.log(role);
	 if (isNaN(role) || role < 0 || role > 1) 
		 $(`#rolemessage`).html("only 1 or 2 are valid current input will default to 1");
	else	
		$(`#rolemessage`).html("");
}

function validateEmail(){
	console.log (" in validate e-mail function (blurred)")
	var email = $(`#emai2l`).val().trim();
	var toSend=[email,""];
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();
	console.log("tosend for email val "+ toSend);
	console.log("json for email val "+ json);
	console.log(" email val "+ email);
	//at what point do we send the email ^ right there right ?
	// when readystate becomes 4 the response text is the user 
	// we then parse it into user var on the js side 
	// if ! null that means the e-mail was found on the database 
	// and that means it is not unique and they should try again .

	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("in xhr callback "+xhr.responseText)
			var user =JSON.parse(xhr.responseText);
			$(`#emailmessage`).show();
			if(user.email !=null){
				$('#emailmessage').html("Email Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
			else {
				$('#emailmessage').html("Email is good");
				$('#register').attr("disabled",false);// remove this later
				// you don't need to tell the user when they are good , just when they are bad 
			}
		}
	};
	xhr.open("POST","validator2",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

function validateUsername(){
	console.log('Within validate username, the username field is out of focus ');
	var username = $('#username').val().trim();
	var toSend=[username,""];
	// exact same as above just with a different field 
	// i wonder if you could ...,. yes you can just make one  function taking in a field as a param
	// look into doing that  by saturday !
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
			console.log("in the xhr callback for username val "+ xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$(`#usernamemessage`).show();
			if(user.username!=null){
				$(`#usernamemessage`).html("username already used pelease try another ");
				$(`register`).attr("disabled", true );
			}
			else{
				$(`#usernamemessage`).html("username solid sally");
				$(`register`).attr("disabled", false );
			}
		}
	};
	xhr.open("POST","validator",true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}


function register(){
	var fitname = $(`#fn`).val().trim();
	var latname = $(`#ln`).val().trim();
	var emil = $(`#emai2l`).val().trim();
	var usrname = $('#username').val().trim();
	var pasword = $('#pass').val().trim();
	var roe;
	if (isNaN(role) || role < 0 || role > 1)
	roe =$(`#role`).val();
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
	console.log(json);

	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			console.log("added user");
		}
	};



	xhr.open("POST","register", true); // goes to the register servlet! 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('Login.html');

}

