window.onload = function() {
	loadLoginView();
	$('#logout').on('click', logout);
	hideNav();
}

//////////////////////////////////////////////////////   Login   ///////////////////////////////////////////////////

function loadLoginView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADLOGINVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#outcome').hide();
			$('#username').on('input',function(e){
				$('#outcome').hide();
			});
			$('#password').on('input',function(e){
				$('#outcome').hide();
			});
			$('#login').on('click', login);
			$('#register').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}
function login(){
	console.log("LOGGING IN");
	var username = $('#username').val();
	var password = $('#password').val();
	var json1 = [username, password];
	var json = JSON.stringify(json1);
	
	console.log(json);
	
	// AJAX stuff
	var xhr = new XMLHttpRequest();
	// ReadyState = 0, Client has been created. open() not called yet.
	xhr.onreadystatechange = function(){  // this will happen last, is a
											// callback
		console.log("ATTEMPINGLOGIN " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("in xhr callback");
			var user = JSON.parse(xhr.responseText);
			$('#outcome').show();
			if(user == null){
				$('#outcome').html("Invalid username or password. Please try again.");
			}
			else{
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
	xhr.open("POST", "login", true);	// what to do, what servlet address (the
										// @WebServlet("/login") in this case),
										// asynchronous request
	xhr.setRequestHeader("Content-type", "application/x-www.form-urlencoded");
	xhr.send(json);
}

//////////////////////////////////////////////////////   Register   ///////////////////////////////////////////////////

function loadRegisterView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADREGISTERVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#umessage').hide();
			$('#emessage').hide();
			$('#emptymessage').hide();
			$('#registerRegister').on('click', register);
			$('#registerCancel').on('click', loadLoginView);
			$('#username').blur(checkUsername);
			$('#email').blur(checkEmail);
//			$('#fn').on('input', checkAllFilled());
//			$('#ln').on('input', checkAllFilled());
//			$('#username').on('input', checkAllFilled());
//			$('#password').on('input', checkAllFilled());
//			$('#email').on('input', checkAllFilled());
//			$('#register').attr("disabled",true);
		}
	}
	xhr.open("GET", "register.view", true);
	xhr.send();
}
function checkUsername(){
	var username = $('#username').val();
	var json = JSON.stringify(username);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var exist = xhr.responseText;
			console.log(exist);
			if(exist.length==4){
				$('#umessage').html(`Username: '${username}' is already taken! Please try another.`);
				$('#umessage').show();
			}
			else {
				$('#umessage').hide();
				}
		}
	};
	
	xhr.open("POST","checkUsername", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}
function checkEmail(){
	var email = $('#email').val();
	var json = JSON.stringify(email);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var exist = xhr.responseText;
			console.log(exist);
			if(exist.length==4){
				$('#emessage').html(`Email: '${email}' is already in use for an account! Please try another or log into your account.`);
				$('#emessage').show();
			}
			else {
				$('#emessage').hide();
				}
		}
	};
	
	xhr.open("POST","checkEmail", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}
//function checkAllFilled() {
//	var username = $('#username').val();
//	var pass = $('#pass').val();
//	var fn = $('#fn').val();
//	var ln = $('#ln').val();
//	var e = $('#email').val();
//	
//	if (username.length == 0 || username == '' || p.length == 0 || pass == '' || fn == '' || ln == '' || e == ''){
//		$('#register').attr("disabled",true);
//	}
//	else {
//		$('#register').attr("disabled",false);
//	}
//	
//}
function checkFilled() {
	var username = $('#username').val();
	var pass = $('#pass').val();
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var e = $('#email').val();
	
	if (username.length == 0 || username == ''){
		return false;
	}
	if (pass.length == 0 || pass == ''){
		return false;
	}
	if (fn.length == 0 || fn == ''){
		return false;
	}
	if (ln.length == 0 || ln == ''){
		return false;
	}
	if (e.length == 0 || e == ''){
		return false;
	}
	return true;
}
function register(){
	console.log(checkFilled());
	if (checkFilled() == false) {
		$('#emptymessage').show();
	}
	else {
		$('#emptymessage').hide();
		var username = $('#username').val();
		var pass = $('#pass').val();
		var fn = $('#fn').val();
		var ln = $('#ln').val();
		var e = $('#email').val();
		var r = 1;
		if ($('#role').is(":checked")){
			r = 2;
		}
		console.log(r);
		var user = {
				id: 0,
				username: username,
				password: pass,
				firstname: fn,
				lastname: ln, 
				email: e,
				role: r,
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
					// window.location.replace('login.html');
					
				}
			}
		};
	
		xhr.open("POST","register", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(userJSON);
	}
}

/////////////////////////////////////////////////////  Employee  //////////////////////////////////////////////////

function loadEmployeeHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("LOADEMPHOMEVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			loadEmployeeReimbursements();
		}
	}
	xhr.open("GET", "employeeHome.view", true);
	xhr.send();
}

function loadEmployeeReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var reimbursements = JSON.parse(xhr.responseText);
			// Fix this by table append instead of this massive string
			var str = `
				<table id="userReimbs" class="display dataTable" cellspacing="0"
				width="100%" role="grid">
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
							<td> $${reimbursements[i].amount} </td>
							<td> ${reimbursements[i].submitted} </td>
							<td> ${reimbursements[i].description} </td>
							<td> ${reimbursements[i].typeStr} </td>
							<td> ${reimbursements[i].statusStr}</td>
						</tr>`;
				str = str.concat(line);
			}
			str = str.concat('</tbody></table>');
			document.getElementById('userReimbursements').innerHTML = str;
			$(document).ready(function(){
			    $('#userReimbs').DataTable();
			});
		}
	}
	xhr.open("GET", "employeeReimbursements", true);
	xhr.send();	
}

function loadEmployeeProfile(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("LOADEMPPROFILEVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			loadUserInfo();
		}
	}
	xhr.open("GET", "employeeProfile.view", true);
	xhr.send();
}

function loadUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADUSERINFO " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			document.getElementById('userInfo').innerHTML = `
					<p>First name: ${user.firstname} </p>
					<p>Last name: ${user.lastname} </p>
					<p>Username: ${user.username} </p>
					<p>Email: ${user.email} </p> 
					<p>Role: ${user.roleStr} </p>`;
		}
	}
	xhr.open("GET", "employeeInfo", true);
	xhr.send();	
}

function loadNewRequest(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADNEWREQUEST " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#errmessage').hide();
			loadRTypeInfo()
			$('#createRequest').on('click', sendRequest);
		}
	}
	xhr.open("GET", "empNewRequest.view", true);
	xhr.send();
}
function loadRTypeInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADREQUESTINFO " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var rTypes = JSON.parse(xhr.responseText);
			var str = '<label for="reqType">Type:  </label><select id="reqType"><option disabled selected value> -- select an option -- </option>';
			for (let i = 0; i < rTypes.length; i++){
				var line = `<option value="${rTypes[i].r_id}">${rTypes[i].r_type}</option>`;
				str = str.concat(line);
			}
			str = str.concat("</select>");
			document.getElementById('reqType').innerHTML = str;
		}
	}
	xhr.open("GET", "reimbursementTypes", true);
	xhr.send();	
}
function sendRequest() {
	var amountInput = $('#reqAmount').val();
	var type = $('#reqType option:selected').val();
	var desc = $('#reqDescription').val();	
//	if(amount == "" || type == undefined){
//		$('#errmessage').show();
//	}
//	else {
	console.log(amountInput);
	console.log(type);
	console.log(desc);
		var reimbursement = {
				id : 0,
				amount : amountInput,
				submitted : "",
				resolved : "",
				description : desc,
				receipt : null,
				author : 0,
				resolver : 0,
				status : 0,
				type : type,
				authorStr : "",
				resolverStr : "",
				statusStr : "",
				typeStr : ""
		};
		
		var reimbJSON = JSON.stringify(reimbursement);
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			console.log("ATTEMPTINGNEWREQUEST " + xhr.readyState);
			if(xhr.readyState == 4 && xhr.status==200){
				var reimbursement = JSON.parse(xhr.responseText);
				if(reimbursement == null){
					alert("Error creating request");
				}
				else{
					console.log("added new request");
					alert("Success! New reimbursement request has been added!");
					loadEmployeeHome();
				}
			}
		};
	
		xhr.open("POST","newReimbursement", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(reimbJSON);
//	}
}
////////////////////////////////////////////////////  Manager  //////////////////////////////////////////////////
function loadManagerHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("LOADMANHOMEVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			loadAllReimbursements();
		}
	}
	xhr.open("GET", "managerHome.view", true);
	xhr.send();
}

function loadAllReimbursements(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("LOADALLREIMBS " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var reimbursements = JSON.parse(xhr.responseText);
			// Fix this by table append instead of this massive string
			var str = `
				<table id="allReimbs" class="display dataTable" cellspacing="0"
				width="100%" role="grid">
					<thead>
						<tr>
							<th class="sorting_asc" tabindex="0">ID</th>
							<th class="sorting">Amount</th>
							<th class="sorting">Submission Date</th>
							<th class="sorting">Resolved Date</th>
							<th class="sorting">Description</th>
							<th class="sorting">Author</th>
							<th class="sorting">Resolver</th>
							<th class="sorting">Type</th>
							<th class="sorting">Status</th>
						</tr>
					</thead>
					<tbody>`;
			for (var i=0; i<reimbursements.length; i++){
				var dollar = '$';
				var line = 
						`<tr>
							<td> ${reimbursements[i].id} </td>
							<td> $${reimbursements[i].amount} </td>
							<td> ${reimbursements[i].submitted} </td>
							<td> ${reimbursements[i].resolved} </td>
							<td> ${reimbursements[i].description} </td>
							<td> ${reimbursements[i].authorStr} </td>
							<td> ${reimbursements[i].resolverStr} </td>
							<td> ${reimbursements[i].typeStr} </td>
							<td> ${reimbursements[i].statusStr}</td>
						</tr>`;
				str = str.concat(line);
			}
			str = str.concat('</tbody></table>');
			document.getElementById('reimbursements').innerHTML = str;
			$(document).ready(function(){
			    $('#allReimbs').DataTable();
			});
			addTableClicks(reimbursements);
		}
	}
	xhr.open("GET", "loadAllReimbursements", true);
	xhr.send();
}
function addTableClicks(reimbursements) {
    $("#allReimbs tr").click(function() {
    	document.getElementById('selected').innerHTML = this.getElementsByTagName("td")[0].innerHTML;
    	});
}

////////////////////////////////////////////////////  Logout  ///////////////////////////////////////////////////

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

////////////////////////////////////////////////////  Nav  //////////////////////////////////////////////////////

function showManagerNav(){
	$('#mhome').show();
	$('#mprofile').show();
	$('#logout').show()
}

function showEmployeeNav(){
	$('#ehome').show();
	$('#eprofile').show();
	$('#enewreq').show();
	$('#logout').show()
	$('#ehome').on('click', loadEmployeeHome);
	$('#eprofile').on('click', loadEmployeeProfile);
	$('#enewreq').on('click', loadNewRequest);
}

function hideNav(){
	$('#mhome').hide();
	$('#ehome').hide();
	$('#mprofile').hide();
	$('#eprofile').hide();
	$('#enewreq').hide();
	$('#logout').hide()
}







