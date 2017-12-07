/**
 * 
 */

$(#login).on(click,function{
	//AJAX servlet call
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange(function(){
		if(this.status==200 && this.readystate==4){
			user=$(#username).val();
			pass=$(#password).val();
			credentials={username:user; password:pass};
			json=credentials.stringify();
		}
	}
	xhr.open("POST","ValidateLoginServlet",true);
	xhr.send(json);
	
	//
	response=xhr.response;
	if(response == 'Validated.'){
		
	} else {
		$(#notification).html(response);
	}
	);
});

$(#register).on(click,function{
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange(function(){
		if(this.status==200 && this.readystate==4){
			//redirect to register page
		}
	}
	xhr.open("POST","RegisterNewServlet",true);
	xhr.send();
	);
});