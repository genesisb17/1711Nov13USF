/**
 * 
 */
var sessionUser;
window.onload = function(){
	loadCredentials(sessionUser);
	//loadHome(sessionUser);
	$('#home').on('click',loadHome);
	$('#profile').on('click', loadProfile);
	$('#submit').on('click', loadSubmit);
	$('#logout').on('click', logOut);
	$('#submitrequest').on('click', submitRequest);
}
function loadCredentials(user){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			console.log("In load Credentials function: " + user.id);
			loadHome(user);
		}
	};
	xhr.open("GET","getUserInfo", true);
	xhr.send();
}
function logOut(){
	
}
function editProfile(){
	console.log("In EditProfile function");

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			console.log(sessionUser);
			document.getElementById('view').innerHTML = view;
			$('#newFirst').html(sessionUser.firstname);
			$('#newLast').html(sessionUser.lastname);
			$('#newEmail').html(sessionUser.email);
			$('#newInfo').on('click', newInfo);
			$('#cancel').on('click', loadProfile);
		}
	}
	xhr.open("GET","getUserInfo", true);
	xhr.send();
	
}
function newInfo(){
	console.log("Inside new info function");
}
function loadHome(user){
	console.log("Username of user is " + user.username);
	loadView("home", user);
}
function loadProfile(){
	loadView("profile");
}
function loadSubmit(){
	loadView("submit");
}
function loadEditProfile(){
	loadView("editProfile");
}
function loadProfileInfo(){
	//Place session user here if code breaks because i removed session user from here
	$('#editprofile').on('click', loadEditProfile);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			sessionUser = JSON.parse(xhr.responseText);
			console.log(sessionUser);
			$('#firstname').html(sessionUser.firstname);
			$('#lastname').html(sessionUser.lastname);
			$('#username').html(sessionUser.username);
			$('#email').html(sessionUser.email);
		}
	}
	xhr.open("GET","getUserInfo", true);
	xhr.send();
}
function loadSubmitInfo(){
	$('#submitrequest').attr("disabled",true);
	$('#reimbursementtype').popover();
	$('#reimbursementtype').blur(validateFields);
	$('#submitrequest').on("click",submitRequest);
}
function submitRequest(){
	//write code that will submit registration. XMLHTTPRequest, etc
	console.log("in Submit Request method. sessionUser id is: " + sessionUser.id);
	var amount = $('#amount').val();
	var description = $('#description').val();
	var type= $('#reimbursementtype').val();
	var creator = sessionUser.id;
	console.log("Session user is " + creator);
	var toSend = [amount, description, type, creator];
			/*create Data Transfer Object. Create DTO.Java file 
			that creates a Reimbursement object. Make sure the name of the
			field */
	var json = JSON.stringify(toSend);
	console.log("The string to be sent to submit servlet is " + json);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange= function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("After succesul submission call ");
		}
	};
	console.log("Before open of xhr");
	xhr.open("POST", "submitRequest", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	}



function validateFields(){
	var amount = $('#amount').val();
	var type = $('#reimbursementtype').val();
	if(amount > 0){
		if(type>0 && type<5){
			$('#submitrequest').attr("disabled",false);
			$('#typemessage').hide();
		}
	}
	else{
		$('#submitrequest').attr("disabled",true);
	}
}
function loadView(page, user){
	//alert("loading view" + page);
	var goto; //servlet location
	switch(page){
	case "home":
		goto="/ERS/home.view";//url pattern for servlet that will load home page
		break;
	case "profile":
		goto="/ERS/profile.view"; //url pattern for servlet that will load profile page
		break;
	case "submit":
		goto="/ERS/submit.view"; // url pattern for servlet that will load submit page
		break;
	case "editProfile":
		goto="/ERS/editProfileForm.view";
		break;
	}
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			switch(goto){
			case "/ERS/home.view":
				// add data to respective view 
				document.getElementById('view').innerHTML = xhr.responseText;
				console.log("Before calling Home INfo");
				$('#name').html(user.firstname);
				//loadHomeInfo(user);
				//create functions for each page that will return user and manipulate DOM
				break;
			case "/ERS/profile.view":
				//$("#name").html(user.firstname)
				console.log(xhr.responseText);
				document.getElementById('view').innerHTML = xhr.responseText;
				loadProfileInfo();
				break;
			case "/ERS/submit.view":
				document.getElementById('view').innerHTML = xhr.responseText;
				console.log("User before entering submit view: " + user);
				loadSubmitInfo();
				break;
			case "/ERS/editProfileForm.view":
				document.getElementById('view').innerHTML = xhr.responseText;
				console.log("Before loading profile edit form");
				break;
				
			}	
		}
	}
	console.log("REQUESTING VIEW " + goto);	
	xhr.open("GET", goto, true);
	xhr.send();
	
	
}