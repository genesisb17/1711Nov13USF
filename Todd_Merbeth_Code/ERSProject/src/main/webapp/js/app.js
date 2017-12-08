window.onload = function() {
	loadLoginView();
//	$('#home').on('click', loadHome);
//	$('#profile').on('click', loadProfile);
	$('#logout').on('click', logout);
	hideNav();
}
function loadLoginView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADLOGINVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#login').on('click', login);
			$('#register').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}
function loadRegisterView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADREGISTERVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#registerRegister').on('click', register);
			$('#registerCancel').on('click', loadLoginView);
		}
	}
	xhr.open("GET", "register.view", true);
	xhr.send();
}
function login(){
	console.log("LOGGING IN");
	var username = $('#username').val();
	var password = $('#password').val();
	var json1 = [username, password];
	var json = JSON.stringify(json1);
	
	console.log(json);
	
	//AJAX stuff
	var xhr = new XMLHttpRequest();
	//ReadyState = 0, Client has been created. open() not called yet.
	xhr.onreadystatechange = function(){  // this will happen last, is a callback
		console.log("ATTEMPINGLOGIN " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
			var user = JSON.parse(xhr.responseText);
			$('#outcome').show();
			if(user == null){
				$('#outcome').html("Invalid username or password");
			}
			else{
				$('#outcome').html(`Welcome ${user.firstname}`);
				console.log(user.role);
				if(user.role == 2){
					loadManagerHome();
					showManagerNav();
				}
				else {
					loadEmployeeHome();
					showEmployeeNav();
					}
			}
		}
	};
	xhr.open("POST", "login", true);	// what to do, what servlet address (the @WebServlet("/login") in this case), asynchronous request
	xhr.setRequestHeader("Content-type", "application/x-www.form-urlencoded");
	xhr.send(json);
}
function register(){
	var username = $('#username').val();
	var pass = $('#pass').val();
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var e = $('#email').val();
	
	var user = {
			id: 0,
			username: username,
			password: pass,
			firstname: fn,
			lastname: ln, 
			email: e,
			role: 1,
			roleStr: ""
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("ATTEMPTINGREGISTER " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				alert("Error creating account");
			}
			else{
				console.log("added new user");
				$('#message').hide();
				alert("Success! Please log in to your new account");
				loadLoginView();
//				window.location.replace('login.html');
				
			}
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
}

function loadEmployeeHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("LOADEMPHOMEVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "employeeHome.view", true);
	xhr.send();
	loadUserReimbursements();
	
}

function loadUserReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("LOADUSERREIMBS " + xhr.responseText);
			var reimbursements = JSON.parse(xhr.responseText);
			var str = `<table id="userReimbs" class="display dataTable" cellspacing="0" width="100%" role="grid">
						<thead>
							<tr>
								<th class="sorting_asc" tabindex="0">ID</th>
								<th class="sorting">Amount</th>
								<th class="sorting">Submission Date</th>
								<th class="sorting">Description</th>
								<th class="sorting">Type</th>
								<th class="sorting">Status</th>
							</tr>
						</thead>
						<tbody>`;
			for (var i=0; i<reimbursements.length; i++){
				var line = 
						`<tr>
							<td> ${reimbursements[i].id} </td>
							<td> ${reimbursements[i].amount} </td>
							<td> ${reimbursements[i].submitted} </td>
							<td> ${reimbursements[i].description} </td>
							<td> ${reimbursements[i].typeStr} </td>
							<td> ${reimbursements[i].statusStr}</td>
						</tr>`;
				str = str.concat(line);
			}
			str = str.concat("</tbody></table>");
			console.log(str);
			document.getElementById('userReimbursements').innerHTML = str;
			$(document).ready(function(){
			    $('#userReimbs').DataTable();
			});
		}
	}
	xhr.open("GET", "employeeReimbursements", true);
	xhr.send();	
}

function loadProfile(){
	loadView("employeeProfile");
	
	loadUserInfo();
}

function loadUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADUSERINFO " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			document.getElementById('userInfo').innerHTML = "<p>First name: " + user.firstname + "</p>" +
					"<p>Last name: " + user.lastname + "</p>" +"<p>Username: " + user.username + "</p>" +
					"<p>Email: " + user.email + "</p>" + "<p>Role: " + user.roleStr + "</p>";
		}
	}
	xhr.open("GET", "employeeInfo", true);
	xhr.send();	
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOGOUT" + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			hideNav();
			loadLoginView();
			alert("You have been logged out. Have a nice day!");
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();
}

function showManagerNav(){
	$('#home').show();
	$('#profile').show();
	$('#logout').show()
}

function showEmployeeNav(){
	$('#home').show();
	$('#profile').show();
	$('#logout').show()
}

function hideNav(){
	$('#home').hide();
	$('#profile').hide();
	$('#logout').hide()
}







