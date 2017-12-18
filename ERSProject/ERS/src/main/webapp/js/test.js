

window.onload=function(){
	/* This section will load required compartments of the html page at login screen.
	 * Since this is a single page application, this section will only load once, so 
	 * everything regarding the login page, which is technically the landing page
	 * will load here. As for the other views that have specific events that need to
	 * be addressed, they will be handled in each respective function that loads those views. 
	 */
	
	$('#message').hide();
	$('#login').on('click', controller);
	$('#register').on('click', register);
}
/* The functions below serve as the starting point for when it comes to loading
 * the specific views of this single web application. The functions are brief,
 * but they serve as the start for the front controller to determine which view
 * to load. 
 * 		1. loadHome()
 * 		2. loadProfile()
 * 		3. loadEditProfile()
 * 		4. loadSubmit()
 * 		5.
 */
function loadEmpHome(){
	loadView('employee');
}
function loadFinHome(){
	loadView('manager');
}
function loadViewProfile(){
	loadView('viewProfile');
}
function loadEditProfile(){
	loadView('editProfile');
}
function loadViewRequest(){
	loadView('viewRequest');
}
function loadSubmitRequest(){
	loadView('submitRequest');
}
function logOut(){
	//insert logout functionalities
	loadView('logOut');
}
function loadChangePassword(){
	loadView('changePassword');
}
function loadNewPassword(){
	loadView('newPassowrd');
}
function getAllRequests(){
	
}
function submitrequest(user){
	console.log("in submit request function");
	var amount = $('#amount').val();
	var description = $('#description').val();
	var type = $('#reimbursementtype').val();
	var id = user.data.client.id;
	var toSend=[amount,description,type,id];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	console.log("After creaing xhr. ");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			if(user !=0){
				console.log("Succesfully created!");
				$('input').hide();
				$('#submitTitle').hide();
				$('#typemessage').show();
				$('#typemessage').html("Succesfully Created!");
				$('#submitit').on('click',loadViewProfile);
			}
		}
	}
	console.log("Before leaving to servlet");
	xhr.open("POST","reimburseme", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}
function validatePasswords(){
	console.log("validating passwords");
	var passone= $("#password").val();
	var passtwo= $('#verifyPassword').val();
	if(passone !== passtwo){
		$('#message').show();
		$('#message').html("Passwords don't match");
		$('#newPassword').attr("disabled", true);
	}
	else{
		if(passone.length < 7){
			$('#message').show();
			$('#message').html("Password has to be more than 6 characters");
			$('#newPassword').attr("disabled", true);
		}
		else{
		$('#message').hide();
		$('#newPassword').attr("disabled", false);
		}
	}
}
function validateFields(){
	console.log("Validating Fields");
	var firstname = $('#newFirst').val();
	var lastname = $('#newLast').val();
	var email = $('#newEmail').val();
	if(firstname.length == 0 || lastname.length ==0 || email.length ==0){
		$('#message').show();
		$('#message').html("Please fill in all the fields.");
		$('#newInfo').attr("disabled", true);
	}
	else{
		if(email.length < 7){
			$('#message').show();
			$('#message').html("Email has to be more than 6 characters.");
		}
		else{
			$('#message').hide();
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					console.log(xhr.responseText);
					sessionUser = JSON.parse(xhr.responseText);
					console.log(sessionUser.email);
					if(email == sessionUser.email){
						$('#newInfo').attr("disabled", false);
						}
					else{
						isEmail();
					}
				}
			}	
			xhr.open("GET","getUserInfo", true);
			xhr.send();	
		}
	}
	
}
function isEmail(){
	var email = $('#newEmail').val();
	var toSend = [email,""];
	console.log(toSend);
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			console.log("email that was returned " + user.email);
			if(user.email == null){
				$('#message').hide();
				$('#newInfo').attr("disabled",false);
			}
			else{
				$('#message').show();
				$('#message').html("Email is already in use");
				$('#newInfo').attr("disabled", true);
			}
		}
	};
	xhr.open("POST","validator", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}
function isPassword(user){
	var pw = $('#password').val();
	var username = user.data.client.username;
	var toSend =[username,pw];
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			if(user.id != 0){
				console.log("loading new password page");
				loadNewPassword();
			}
			else{
				$('#message').show();
				$('#message').html("Incorrect Password");
			}
			
		}
	}
	xhr.open("POST","passwordVerify", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	
}
function validateRequestFields(){
	var amount = $('#amount').val();
	var type = $('#reimbursementtype').val();
	if(amount > 0){
		if(type>0 && type<5){
			$('#submitit').attr("disabled",false);
			$('#typemessage').hide();
		}
	}
	else{
		$('#submitit').attr("disabled",true);
	}
}
function submitProfileUpdate(user){
	/*This function will be the function that will take in the information from the user edit form
	 * and send it through a servlet to update the user information in the database
	 */
	var fn = $('#newFirst').val();
	var ln = $('#newLast').val();
	var em = $('#newEmail').val();
	var un = user.data.client.username;
	var id = user.data.client.id;
	var uri = user.data.client.userroleid;
	var user ={
			id: id,
			username: un,
			password: "",
			firstname: fn,
			lastname: ln,
			email: em,
			userroleid: uri
	};
	
	var userJSON = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			console.log(user);
			if(user.id != 0){
				$('#update').show();
				$('#update').html("Succesfully Updated!");
			}
			else{
				window.location.replace('index.html');
			}
		}
	}
	xhr.open("PUT", "updateProfile", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
}
function submitNewPassword(user){
	console.log("Inside Submit New Password Function");
	var pw = $('#password').val();
	var un = user.data.client.username;
	var toSend =[un, pw];
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var value = JSON.parse(xhr.responseText);
			if(value !=0 ){
				$('#goodMessage').show();
				$('#goodMessage').html("Successfully Updated!");
				$('input').hide();
				$('#titlePass').hide();
				$('#newPassword').hide();
				$('#cancel').html("View Profile");
				$('#cancel').on('click', loadViewProfile);
			}
			else{
				$('#message').show();
				$('#message').html("ERROR. CHECK IN WITH ADMIN");
				window.location.replace('index.html');
			}
			
		}
	}
	xhr.open("PUT","updatePassword", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}
function controller(){
	var username = $('#username').val();
	var password = $('#pass').val();
	if(username.length == 0 || password.length ==0){
		$('#message').show();
		$('#message').html("Username or Password cannot be empty. Try Again.");
	}
	else{
		var toSend =[username,password];
		var json = JSON.stringify(toSend);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var user = JSON.parse(xhr.responseText);
				console.log(user);
				/* 
				 * create switch statement based on the users role id
				 * if (413) display user home page and functionalities,
				 * else if (412), display manager home page and functionalities.
				 *  make sure to add user role id in the request SQL so that it can 
				 *  return it as well. make sure to set the user role id from the result set
				 *  
				 */
				switch(user.userroleid){
					case 413:
						loadEmpHome();
						break;
					case 414:
						loadFinHome();
						break;
					default:
						$('#message').show();
						$('#message').html("Invalid user");
						break;
				}
				
			}
		}
		xhr.open("POST","enterServlet", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(json);
	}
}
function loadUser(request){
	/*This function is in charge of loading user information onto the newly loaded
	 * 	partial. Since both employee and user view will contain a navbar with the same
	 * fields and the fields need user information to load, making one explicit
	 * function that will load user information is convenient. 
	 */
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			console.log("In Load User function " + sessionUser.userroleid);
			switch(sessionUser.userroleid){
				case 413:
					$('#homePage').on('click',loadEmpHome);
					break;
				case 414:
					$('#homePage').on('click',loadFinHome);
					break;
			}
			switch(request){
				case "/ERS/editProfile.view":
					$('#newFirst').attr("value", sessionUser.firstname);
					$('#newLast').attr("value", sessionUser.lastname);
					$('#newEmail').attr("value", sessionUser.email);
					$('#newInfo').on('click', {client: sessionUser}, submitProfileUpdate);
					$('#cancel').on('click', loadViewProfile);
					$('#changePassword').on('click', loadChangePassword);
					$('#message').hide();
					$('#update').hide();
					$("input").blur(validateFields);
					break;
				case "/ERS/viewProfile.view":
					$('#firstname').html(sessionUser.firstname);
					$('#lastname').html(sessionUser.lastname);
					$('#username').html(sessionUser.username);
					$('#email').html(sessionUser.email);
					$('#editprofile').on('click', loadEditProfile);
					break;
				case "/ERS/changePassword.view":
					$('#newPassword').on('click',{client: sessionUser}, isPassword);
					$("#cancel").on('click', loadViewProfile);
					$('#message').hide();
					$("input").blur(validatePasswords);
					break;
				case "/ERS/newPassword.view":
					$('#newPassword').on('click',{client: sessionUser},  submitNewPassword);
					$('#cancel').on('click', loadViewProfile);
					$('#message').hide();
					$('#goodMessage').hide();
					$("input").blur(validatePasswords);
					break;
				case "/ERS/submitRequest.view":
					console.log("In submit request view");
					$('input').blur(validateRequestFields);
					$('#submitit').attr("disabled",true);
					$('#submitit').on('click', {client: sessionUser}, submitrequest);
					break;
				case "/ERS/manager.view":
					$('#viewRequestButton').on('click', getAllRequests);
					$('#viewProfile').on('click', loadViewProfile);
					$('#editProfile').on('click', loadEditProfile);
					$('viewRequest').on('click', getAllRequests);
					break;
			}
			$('#title').html("Welcome " + sessionUser.firstname + " " + sessionUser.lastname);
			$('#name').html(sessionUser.firstname + " " + sessionUser.lastname);
			$('#viewProfile').on('click', loadViewProfile);
			$('#editProfile').on('click', loadEditProfile);
			$('#viewProfileButton').on('click', loadViewProfile);
			$('#viewRequest').on('click', loadViewRequest);
			$('#viewRequestButton').on('click', loadViewRequest);
			$('#submitRequest').on('click', loadSubmitRequest);
			$('#logOut').click(function(){
				window.location.replace('index.html');
			});
		}
	}
	xhr.open("GET","getUserInfo", true);
	xhr.send();
}

function loadView(page){
	/*This function will be handling the change of views for the user. Prior
	 * to calling this function, a command relevant to the view a user will see
	 * will be called. You can refer to the loadxxx functions to determine what will
	 * be loading. This function contains switch statements that determine what will 
	 * be the view that will be loaded next for a user depending on what they clock 
	 * on their page
	 */
	var goto; 
	switch(page){
		case "employee":
			goto="/ERS/employee.view";
			break;
		case "manager":
			goto="/ERS/manager.view";
			break;
		case "viewProfile":
			goto="/ERS/viewProfile.view";
			break;
		case "editProfile":
			goto="/ERS/editProfile.view";
			break;
		case "changePassword":
			goto="/ERS/changePassword.view";
			break;
		case "viewRequest":
			goto="/ERS/viewRequest.view";
			break;
		case "submitRequest":
			goto="/ERS/submitRequest.view";
			break;
		case "newPassowrd":
			goto="/ERS/newPassword.view";
			break;
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			switch(goto){
				case "/ERS/employee.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser();
					break;
				case "/ERS/manager.view":
					document.getElementById('view').innerHTML = xhr.responseText;	
					loadUser(goto);
					break;
				case "/ERS/viewProfile.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser(goto);
					break;
				case "/ERS/viewRequest.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser();
					break;
				case "/ERS/editProfile.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser(goto);
					break;
				case "/ERS/changePassword.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser(goto);
					break;
				case "/ERS/submitRequest.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser(goto);
					break;
				case "/ERS/newPassword.view":
					document.getElementById('view').innerHTML = xhr.responseText;
					loadUser(goto);
					break;
			}	
		}
	}
	console.log("REQUESTING VIEW " + goto);	
	xhr.open("GET", goto, true);
	xhr.send();
}