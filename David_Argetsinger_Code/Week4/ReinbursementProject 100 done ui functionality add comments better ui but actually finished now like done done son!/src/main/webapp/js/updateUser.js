
window.onload = function(){
	$('#update').on('click', update);
	$('#emai2l').on('keyup',validateEmail);

	
}

//checks if email is allowed.
function validateEmail(){
	//console.log (" in validate e-mail function (blurred)")
	
	var email = $(`#emai2l`).val();
	var toSend=[email,""];
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("in xhr callback "+xhr.responseText)
			var user =JSON.parse(xhr.responseText);
			$(`#emailmessage`).show();
			if(user.email !=null){
				$('#update').attr("disabled",true);
				$('#emailmessage').html("Email Already in use! Please try another") ;
				return false;
				
			}
			else {
				$('#emailmessage').hide();
				
				$('#update').attr("disabled",false);
				return true;// remove this later
				// you don't need to tell the user when they are good , just when they are bad 
			}
		}
	};
	xhr.open("POST","validator2",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

// updates, checks if null on servlet side with session
function update(){

	var fitname = $(`#fn`).val();
	var latname = $(`#ln`).val();
	var eail = $(`#emai2l`).val();
	var usrname ="";
	var pasword = $('#pass').val();
	var roe="";
	var user = {
			id: 0,
			username: "",
			password: pasword,
			lastname: latname, 
			name: fitname,        
			email: eail,
			role:roe 
	};

	var json = JSON.stringify(user);


	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$(`#fn`).val("");
			$(`#ln`).val("");
			$(`#emai2l`).val("");
			$('#pass').val("");
			$('#emailmessage').show();
			$('#emailmessage').html("Values Set") ;
		}
	};



	xhr.open("POST","update", true); 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}

