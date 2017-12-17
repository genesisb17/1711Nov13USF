/**
 * Handle all events
 */

/**
 * Fires when the resource has loaded.
 */
window.onload = function(){
	loadLogin();
}

var userId;
var roleId;

function loadLogin(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#message').hide();
			$('#login').on('click', login);
			$('#register').on('click', loadRegister);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}

function login(){
	var username = $('#username').val();
	var password = $('#password').val();
	
	if(isEmpty(username) || isEmpty(password)){
		$('#message').show();
		$('#message').html("Please enter all required fields!");
	} else{
		var toSendUser = {
				username: username,
				password: password,
				firstname: null,
				lastname: null,
				email: null,
				roleId: 0
		}

		var json = JSON.stringify(toSendUser);
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var user = JSON.parse(xhr.responseText);
				$('#message').show();
				if(user == null){
					$('#message').html("Invalid username!");
				} else if(user.password == null){
					$('#message').html("Invalid password!")
				} else{
					loadMain();
					loadProfile();
				}
			}
		}
		xhr.open("POST","login", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(json);
	}
}

function loadRegister(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#message').hide();
			$('#firstname').blur(function(){
				var firstname = $('#firstname').val();
				if(isEmpty(firstname)){
					$('#message').show();
					$('#message').html("First name cannot be empty!");
				} else if(!(allLetters(firstname))){
					$('#message').show();
					$('#message').html("First name must be all letters!");
					$('#firstname').val('');
				}
			});
			$('#lastname').blur(function(){
				var lastname = $('#lastname').val();
				if(isEmpty(lastname)){
					$('#message').show();
					$('#message').html("Last name cannot be empty!");
				} else if(!(allLetters(lastname))){
					$('#message').show();
					$('#message').html("Last name must be all letters!");
					$('#lastname').val('');
				}
			});
			$('#email').blur(function(){
				var email = $('#email').val();
				if(isEmpty(email)){
					$('#message').show();
					$('#message').html("Email cannot be empty!");
				} else if(!(emailFormat(email))){
					$('#message').show();
					$('#message').html("Please enter a valid email address!");
					$('#email').val('');
				}
			});
			$('#username').blur(function(){
				var username = $('#username').val();
				if(isEmpty(username)){
					$('#message').show();
					$('#message').html("Username cannot be empty!");
				} else if(!(usernameFormat(username))){
					$('#message').show();
					$('#message').html("Please enter a valid username!");
					$('#username').val('');
				}
			});
			$('#password').blur(function(){
				var password = $('#password').val();
				if(isEmpty(password)){
					$('#message').show();
					$('#message').html("Password cannot be empty!");
				} else if(!(passwordFormat(password))){
					$('#message').show();
					$('#message').html("Please enter a valid password!");
					$('#password').val('');
				}
			});
			$('#signup').on('click', createAcc);
			$('#dirLogin').on('click', loadLogin);
		}
	}
	xhr.open("GET", "register.view", true);
	xhr.send();
}

function createAcc(){
	var username = $('#username').val();
	var password = $('#password').val();
	var firstname = $('#firstname').val();
	var lastname = $('#lastname').val();
	var email = $('#email').val();
	
	var roleId = $('#role:checked').val();
	
	if(username != "" && password != "" && firstname != "" && lastname != ""
			&& email != "" && roleId != undefined){
		// all inputs are entered, create a user object
		// create a user object
		var toSendNewUser = {
			username: username,
			password: password,
			firstname: firstname,
			lastname: lastname,
			email: email,
			roleId: roleId
		}
		
		var json = JSON.stringify(toSendNewUser);
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var user = JSON.parse(xhr.responseText);
				if(user.email == null){
					$('#message').show();
					$('#message').html("This email already existed. Please use another one!");
				} else if(user.username == null){
					$('#message').show();
					$('#message').html("This username already existed. Please use another one!");
				} else{
					// both are unique, redirect to login page
					alert("Success! Please login using your credentials");
					loadLogin();
				}
			}
		}
		xhr.open("POST", "register", true);
		xhr.send(json);
		
	} else {
		$('#message').show();
		$('#message').html("Please enter all fields!");	
	}	
}

function loadMain(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$('#view').html(xhr.responseText);
		$('#profile').on('click', loadProfile);
		$('#reimb').on('click', loadReimb);
		$('#logout').on('click', logoutModal);
	}
	xhr.open("Get", "app.view", true);
	xhr.send();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#appview').html(xhr.responseText);
			$('#message').hide();
			getUserInfo();
			$('#reset').on('click', resetPassword);
		}
	}
	xhr.open("GET", "profile.view", true);
	xhr.send();
}

function getUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var sessionUser = JSON.parse(xhr.responseText);
			$('#userfirstname').html(sessionUser.firstname);
			$('#user').html(sessionUser.username);
			$('#fullname').html(sessionUser.firstname + " " + sessionUser.lastname);
			$('#emailaddress').html(sessionUser.email);
			userId = sessionUser.userId;
			if(sessionUser.roleId == 1){
				roleId = 1;
				$('#position').html("EMPLOYEE");
			} else{
				roleId = 2;
				$('#position').html("MANAGER");
			}
			$('#userId').html(userId);
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function resetPassword(){
	var oldpass = $('#oldpass').val();
	var newpass = $('#newpass').val();
	var repass = $('#repass').val();
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var sessionUser = JSON.parse(xhr.responseText);
			var syspass = sessionUser.password;

			if(isEmpty(oldpass) || isEmpty(newpass) || isEmpty(repass)){
				$('#message').show();
				$('#message').html("Please enter all fields!");
			} else if(oldpass != syspass){
				$('#message').show();
				$('#message').html("Wrong login password!");
			} else if(!(passwordFormat(newpass)) || !(passwordFormat(newpass))){
				$('#message').show();
				$('#message').html("Please enter a valid password!");
		 	} else if(newpass != repass){
				$('#message').show();
				$('#message').html("New Passwords do not match!");
			} else{
				$('#message').hide();
				updatePassword(newpass);
				loadProfile();
			}
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}

function updatePassword(newpass){
	var xhr = new XMLHttpRequest();
	var sendNewpass = [newpass];
	var json = JSON.stringify(sendNewpass);
	console.log(json);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			if(user.password == newpass){
				alert("Success!");
			} else{
				alert("Fail to update the new password!");
			}		
		}
	}
	xhr.open("POST", "updateUserPass", true);
	xhr.send(json);
}

function loadReimb(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#appview').html(xhr.responseText);
			$('#message').hide();
			$('#submitReimb').on('click', submitReimb);
			loadTable();
		}
	}
	xhr.open("GET", "expense.view", true);
	xhr.send();
}

function submitReimb(){
	var reimbTypeId = $('#typeSel').val();
	var reimbAmount = $('#amount').val();
	var reimbDescription = $('#description').val();
	
	if(isEmpty(reimbAmount) || isEmpty(reimbTypeId)){
		$('#message').show();
		$('#message').html("Make sure fill out all required fields!");
	} else{
		var toSendReimb = {
			reimbAmount: reimbAmount,
			reimbDescription: reimbDescription,
			reimbAuthor: userId,
			reimbStatusId: 0,
			reimbTypeId: reimbTypeId,
		}

		var json = JSON.stringify(toSendReimb);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				$('#reimbModal').modal('hide');
				$('body').removeClass('modal-open');
				$('.modal-backdrop').remove();
				alert("Success!");
				loadReimb();
			}
		}
		xhr.open("POST","submitReimb", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(json);	
	}
}

function loadTable(){
	console.log(roleId);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#tableview').html(xhr.responseText);
			if(roleId == 1 ){ //employee table
				loadEmpTable();
			} else{
				loadManTable();
			}
		}
	}
	xhr.open("GET", "table.view", true);
	xhr.send();
}

function loadEmpTable(){
	$.ajax({
		url: "getIndividualReimb",
		method: "POST",
		dataType: "json",
		success: function (data){
			$('#reimbTable').DataTable({
				data: data,
				columns: [
					{'data': 'ReimbID'},
					{'data': 'CreatedDate'},
					{'data': 'ReimbType'},
					{
						'data': 'Amount',
						'render': function(amount){
							return "$" + amount.toFixed(2);
						}
					},
					{'data': 'Description'},
					{'data': 'ReimbStatus'},
					{'data': 'ReDate'},
					{'data': 'Resolver'},	
				]
			});
		},
		fail: function(){alert("Fail to load the DataTable!")},
	});	
}

function loadManTable(){
	$(document).ready(function(){
	$.ajax({
		url: "getAllReimb",
		method: "POST",
		dataType: "json",
		success: function (data){
			var table = $('#reimbTable').DataTable({
				data: data,
				columns: [
					{'data': 'ReimbID'},
					{'data': 'Requester'},
					{'data': 'CreatedDate'},
					{'data': 'ReimbType'},
					{
						'data': 'Amount',
						'render': function(amount){
							return "$ " + amount.toFixed(2);
						}
					},
					{'data': 'Description'},
					{'data': 'ReimbStatus'},
					{'data': 'ReDate'},
					{'data': 'Resolver'},
					{
						'data': null,
						"defaultContent": "<button class=\"btn btn-outline-success\" id=\"edit\">Edit</button>",
					    "targets": -1
					}
				]
			});
			$('#reimbTable tbody').on('click', 'td button', function(){
				$('#approvalMessage').hide();
				var data = table.row( $(this).parents('tr') ).data();
				var reimbId = data.ReimbID;
				var requester = data.Requester;
				var createdDate = data.CreatedDate;
				var type = data.ReimbType;
				var amount = data.Amount;
				var description = data.Description;
				var status = data.ReimbStatus;
				if(status != "PENDING"){
					$('#completedModal').modal('show');
				} else{
					var ticket = {id: reimbId, author: requester, created: createdDate,
					type: type, amount: amount, description: description, status: status};
					getTicketInfo(ticket);
				}
			});
		},
		fail: function(){alert("Fail to load the DataTable!")},
	});
	});
}

function getTicketInfo(ticket){
	var toSend = [ticket.id, userId];
	toSend = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText; // if response text is 1, proceed approval process
			if(response == 1){
				approvalModal(ticket);
			} else{
				$('#notAuthorizeModal').modal('show');
			}
		}
	}
	xhr.open("POST", "checkTicket", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(toSend);
}

function approvalModal(ticket){
	ticket.amount = "$" + ticket.amount.toFixed(2);
	var requestInfo = `<p><b>Requester</b>: ${ticket.author}</p>
					   <p><b>Reimb ID</b>: ${ticket.id}</p>
					   <p><b>Status</b>: ${ticket.status}</p>
					   <p><b>Type</b>: ${ticket.type}</p>
					   <p><b>Created Date</b>: ${ticket.created}</p>
					   <p><b>Total Amount</b>: ${ticket.amount}</p>
					   <p><b>Description</b>: ${ticket.description}</p>`;
	$('#requesterInfo').html(requestInfo);
	$('#authorizeModal').modal('show');
	$('#authorized').on('click', function(){
		var reimbStatus = $('#authSel').val();
		if(isEmpty(reimbStatus)){
			$('#approvalMessage').show();
			$('#approvalMessage').html("Please select an approval status!");
		} else{
			var toSendApproval = [ticket.id, userId, reimbStatus];
			console.log(toSendApproval);
			var json = JSON.stringify(toSendApproval);
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					$('#authorizeModal').modal('hide');
					$('body').removeClass('modal-open');
					$('.modal-backdrop').remove();
					alert(xhr.responseText);
//					loadReimb();	
					loadManTable();
				}
			}
			xhr.open("POST","submitApproval", true);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.send(json);	
		}	
	});	
}

function logoutModal(){
	$('#logoutModal').modal('show');
	$('#ok').on('click', function(){
		$('#logoutModal').modal('hide');
		$('body').removeClass('modal-open');
		$('.modal-backdrop').remove();
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				alert(xhr.responseText);
				loadLogin();
			}
		}
		xhr.open("GET", "logoutSession", true);
		xhr.send();
	});
}

/**
 * Check if the input is empty
 * @param input
 * @returns
 */
function isEmpty(input){
	if(input.length == 0) return true;
	return false;
}

function allLetters(input){
	var letters = /^[a-zA-Z]+$/;
	if(input.match(letters)){
		return true;  
	} else {
		return false;  
	} 
}

function emailFormat(input){
	var emails = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(input.match(emails)){
		return true;
	} else {
		return false;
	}
}

function usernameFormat(input){
	// 
	// 5-15 in length
	var unformat = /^(?=.{5,15}$)(?!.[_]{2})[a-zA-Z0-9_]+(?<![_])$/;
	if(input.match(unformat)){
		return true;
	} else{
		return false;
	}
}

function passwordFormat(input){
	// at least one number, one lowercase and one uppercase letter
	// 6-15 in length
	var passformat = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,15}$/;
	if(input.match(passformat)){
		return true;
	} else{
		return false;
	}
}