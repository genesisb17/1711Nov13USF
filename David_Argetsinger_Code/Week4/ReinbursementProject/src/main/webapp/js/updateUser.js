/**
 * cry.jpeg
 */

window.onload = function(){
	$('#update').on('click', update);
	$('#emai2l').blur(validateEmail);
	$('#update').attr("disabled",true);
	


}
//onblur is to say when not focused, when they switch to a different field for instance 


function validateEmail(){
	console.log (" in validate e-mail function (blurred)")
	var email = $(`#emai2l`).val();
	var toSend=[email,""];
	var json = JSON.stringify(toSend);
	var xhr= new XMLHttpRequest();
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
				$('#update').attr("disabled",false);// remove this later
				// you don't need to tell the user when they are good , just when they are bad 
			}
		}
	};
	xhr.open("POST","validator2",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}


function update(){
	var fitname = $(`#fn`).val();
	var latname = $(`#ln`).val();
	var emil = $(`#emai2l`).val();
	var usrname ="";
	var pasword = $('#pass').val();
	var roe=1;
	var user = {
			id: 0,
			username: "",
			password: pasword,
			lastname: latname, 
			name: fitname,        
			email: emil,
			role:1 
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



	xhr.open("POST","update", true); // goes to the register servlet! 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	alert("Success! Account updated");

}

