window.onload = function() {
	loadLoginView();
}

function loadLoginView() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#login-message').hide();
			$('#login-btn').on('click', login);
			$('#newUserRegister-btn').on('click', loadRegisterView);
			$('#managerLogin-btn').on('click', loadManagerLoginView);
		}
	}

	xhr.open("GET", "login.view", true);
	xhr.send();
}

function loadManagerLoginView() {

	console.log("In loadManagerLoginView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#mlogin-message').hide();
			$('#mlogin-btn').on('click', mlogin);
			$('#userLogin-btn').on('click', loadLoginView);
		}
	}
	console.log("wtf");
	xhr.open("GET", "managerLogin.view", true);
	xhr.send();
}

//--------------------------------------------------------------------------------------------------------------------

function loadRegisterView() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			document.getElementById('view').innerHTML = xhr.responseText;
			$('#register-message').hide();
			$('#register-btn').on('click', register);
			$('#register-username').blur(validateUsername);
			$('#register-email').blur(validateEmail);
			$('#register-btn').attr('disabled', true);
		}
	}

	xhr.open("GET", "register.view", true);
	xhr.send();
}

function validateUsername() {
	$("#register-btn").attr("disabled", false);
	$("#register-message").hide();

	var username = $("#register-username").val();
	var toSend = username;
	var json = JSON.stringify(toSend);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if(user == null) {
				$("#register-message").show();
				$("#register-message").html("Username is already in use! Please try another.");
				$("#register-btn").attr("disabled", true);
			}
		}
	}

	xhr.open("POST", "username.validate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function validateEmail() {
	$("#register-btn").attr("disabled", false);
	$("#register-message").hide();

	var email = $("#register-email").val();
	var toSend = email;
	var json = JSON.stringify(toSend);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var email = JSON.parse(xhr.responseText);
			if(email == null){
				$("#register-message").show();
				$("#register-message").html("Email address is already in use! Please try another.") ;
				$("#register").attr("disabled", true);
			}
		}
	}

	xhr.open("POST", "email.validate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function validateUpdatedUsername() {
	$("#editProfile-btn").attr("disabled", false);
	$("#editProfile-message").hide();

	var username = $("#editProfile-username").val();
	var toSend = username;
	var json = JSON.stringify(toSend);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if(user == null) {
				$("#editProfile-message").show();
				$("#editProfile-message").html("Username is already in use! Please try another.");
				$("#updateProfile-btn").attr("disabled", true);
			}
		}
	}

	xhr.open("POST", "username.validate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function validateUpdatedEmail() {
	$("#updateProfile-btn").attr("disabled", false);
	$("#updateProfile-message").hide();

	var email = $("#editProfile-email").val();
	var toSend = email;
	var json = JSON.stringify(toSend);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState)
		if(xhr.readyState == 4 && xhr.status == 200) {
			var email = JSON.parse(xhr.responseText);
			if(email == null){
				$("#editProfile-message").show();
				$("#editProfile-message").html("Email address is already in use! Please try another.") ;
				$("#updateProfile-btn").attr("disabled", true);
			}
		}
	}

	xhr.open("POST", "email.validate", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function register() {
	var fn = $("#register-fn").val();
	var ln = $("#register-ln").val();
	var email = $("#register-email").val();
	var username = $("#register-username").val();
	var password = $("#register-password").val();

	var user = {
			userId: 0,
			firstName: fn,
			lastName: ln,
			emailAddress: email,
			username: username,
			password: password,
			roleId: 3
	}

	var userJson = JSON.stringify(user);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log("ready state: " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {

			$('#register-message').hide();
			alert("Enrollment successful! Please login using your credentials");
			loadLoginView();
		}
	}

	xhr.open("POST", "register", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(userJson);
}

//--------------------------------------------------------------------------------------------------------------------

function loadHomeView() {
	console.log("In loadHomeView()...")

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			console.log("In loadHomeView() - xhr callback...");

			document.getElementById('view').innerHTML = xhr.responseText;
			loadUserProfileView();
			$('#userProfile-tab').on('click', loadUserProfileView);
			$('#openTicket-tab').on('click', loadUserOpenTicketView);
			$('#viewPending-tab').on('click', loadUserPendingView);
			$('#viewResolved-tab').on('click', loadUserResolvedView);
			$('#logout-tab').on('click', logout);
		}
	}

	xhr.open("GET", "home.view", true);
	xhr.send();
}

function loadManagerHomeView() {
	console.log("In loadManagerHomeView()...")

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadManagerHomeView() - xhr callback...")
			document.getElementById('view').innerHTML = xhr.responseText;
			loadUserProfileView();
			$('#userProfile-tab').on('click', loadUserProfileView);
			$('#mViewPending-tab').on('click', loadManagerPendingView);
			$('#logout-tab').on('click', logout);
		}
	}

	xhr.open("GET", "mhome.view", true);
	xhr.send();
}

function loadUserProfileView() {
	console.log("In loadUserProfileView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadUserProfileView() - xhr callback...");

			document.getElementById('content').innerHTML = xhr.responseText;
			$('#editProfile-btn').on('click', loadEditProfileView);
			loadUserProfileInfo();
		}
	}

	xhr.open("GET", "userView-profile.view", true);
	xhr.send();
}

function loadUserOpenTicketView() {
	console.log("In loadUserOpenTicketView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadUserOpenTicketView() - xhr callback...");

			document.getElementById('content').innerHTML = xhr.responseText;
			$('#openTicket-btn').on('click', openTicket)
		}
	}

	xhr.open("GET", "userView-openTicket.view", true);
	xhr.send();
}

function loadUserPendingView() {
	console.log("In loadUserPendingView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadUserPendingView() - xhr callback...");

			document.getElementById('content').innerHTML = xhr.responseText;
			loadPendingInfo();
			$('body').on('click', '#detail-btn', function() {

				let self = $(this);
				let rowIndex = self.closest('tr').index();
				let table = $('table tbody')[0];
				let cell = table.rows[rowIndex].cells[0];
				let ticketId = $(cell).text();

				loadPendingDetailsView(ticketId);

			});


			$('body').on('click', '#remove-btn', function(event) {

				let self = $(this);
				let rowIndex = self.closest('tr').index();
				/*console.log("Row selected: " + rowIndex);*/

				let table = $('table tbody')[0];
				let cell = table.rows[rowIndex].cells[0];
				let ticketId = $(cell).text();

				/*console.log("Ticket id: " + ticketId);*/

				let deleteConfirmed = confirm("Are you sure you want to remove this ticket?");
				event.stopPropagation();
				if (deleteConfirmed) { closeTicket(ticketId); }
				else { loadUserPendingView(); }
			});
		}
	}

	xhr.open("GET", "userView-pending.view", true);
	xhr.send();
}

function loadManagerPendingView() {
	console.log("In loadManagerPendingView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadManagerPendingView() - xhr callback...");
			document.getElementById('content').innerHTML = xhr.responseText;
			loadManagerPendingInfo();
			$('body').on('click', '#detail-btn', function() {

				let self = $(this);
				let rowIndex = self.closest('tr').index();
				let table = $('table tbody')[0];
				let cell = table.rows[rowIndex].cells[0];
				let ticketId = $(cell).text();

				loadPendingDetailsView(ticketId);

			});

			$('body').on('click', '#approve-btn', function() {

				let self = $(this);
				let rowIndex = self.closest('tr').index();
				let table = $('table tbody')[0];
				let cell = table.rows[rowIndex].cells[0];
				let ticketId = $(cell).text();

				approveOpenTicket(ticketId);

			});

			$('body').on('click', '#deny-btn', function() {

				let self = $(this);
				let rowIndex = self.closest('tr').index();
				let table = $('table tbody')[0];
				let cell = table.rows[rowIndex].cells[0];
				let ticketId = $(cell).text();

				denyOpenTicket(ticketId);

			});
		}
	}

	xhr.open("GET", "managerView-pending.view", true);
	xhr.send();
}

function loadPendingDetailsView(ticketId) {
	console.log("In loadPendingDetailsView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadPendingDetailsView() - xhr callback...");
			document.getElementById('content').innerHTML = xhr.responseText;
			$('#editPending-btn').on('click', function() {
				loadEditPendingView(ticketId);
			});

			$('#goBack-btn').on('click', loadUserPendingView);
			loadPendingDetailsInfo(ticketId);

		}
	}

	xhr.open("GET", "userView-pendingDetails.view", true);
	xhr.send();
}

function loadEditPendingView(ticketId) {
	console.log("In loadEditPendingView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadEditPendingView() - xhr callback...");
			document.getElementById('content').innerHTML = xhr.responseText;
			$('#ticketId').html(ticketId);
			$('#updateTicket-btn').on('click', function() {
				updatePendingTicket(ticketId);
			})
			$('#goBack-btn').on('click', function() {
				loadPendingDetailsView(ticketId);
			})
		}
	}

	xhr.open("GET", "editTicket.view", true);
	xhr.send();
}

function loadUserResolvedView() {
	console.log("In loadUserResolvedView()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadUserResolvedView() - xhr callback...");

			document.getElementById('content').innerHTML = xhr.responseText;
			loadHistoryInfo();
		}
	}

	xhr.open("GET", "userView-history.view", true);
	xhr.send();
}

function loadEditProfileView() {
	console.log("In loadEditProfileView()...")
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadEditProfileView() - xhr callback...")
			document.getElementById('content').innerHTML = xhr.responseText;
			$('#editProfile-message').hide();
			$('#updateProfile-btn').on('click', updateUserProfile);
			$('#updateProfile-btn').attr('disabled', true);
			$('#editProfile-username').blur(validateUpdatedUsername);
			$('#editProfile-email').blur(validateUpdatedEmail);
			$('#goBack-btn').on('click', loadUserProfileView);
			loadEditUserProfileInfo();
		}
	}
	
	xhr.open("GET", "editProfile.view", true);
	xhr.send();
}

//------------------------------------------------------------------------------------------------------------------------

function loadUserProfileInfo() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			var sessionUser = JSON.parse(xhr.responseText);

			$('#user-firstname').html(sessionUser.firstName);
			$('#user-lastname').html(sessionUser.lastName);
			$('#user-username').html(sessionUser.username);
			$('#user-email').html(sessionUser.emailAddress);

			if(sessionUser.roleId == 1) {
				$('#user-role').html("Administrator");
			} else if(sessionUser.roleId == 2) {
				$('#user-role').html("Manager");
			} else {
				$('#user-role').html("Employee");
			}

		}
	}

	xhr.open("GET", "profile.loadinfo", true);
	xhr.send();
}

function loadEditUserProfileInfo() {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {

			var sessionUser = JSON.parse(xhr.responseText);

			$('#user-firstname').html(sessionUser.firstName);
			$('#user-lastname').html(sessionUser.lastName);

			if(sessionUser.roleId == 1) {
				$('#user-role').html("Administrator");
			} else if(sessionUser.roleId == 2) {
				$('#user-role').html("Manager");
			} else {
				$('#user-role').html("Employee");
			}

		}
	}

	xhr.open("GET", "profile.loadinfo", true);
	xhr.send();
}

function loadPendingInfo() {

	console.log("In loadPendingInfo()...");

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadPendingInfo() - xhr callback...")
			var pendingReimbs = JSON.parse(xhr.responseText);

			// to sort array by reimbursementId
			pendingReimbs = bubbleSorter(pendingReimbs);

			if(pendingReimbs.length > 0) {
				pendingReimbs.forEach(function(reimb) {
					let id = reimb.reimbursementId;
					let typeId = reimb.typeId;

					let type;
					switch (typeId) {
					case 1: type = "Lodging"; break;
					case 2: type = "Travel"; break;
					case 3: type = "Food"; break;
					case 4: type = "Other"; break;
					}

					let amount = parseFloat(Math.round(reimb.amount * 100) / 100).toFixed(2);

					let markup = "<tr>" +
					'<td id="reimbId">' + id + "</td>" +
					'<td id="reimbType">' + type + "</td>" +
					'<td id="reimbAmount">$' + amount + "</td>" +
					'<td><button class="btn btn-primary" id="detail-btn">Details</button>&nbsp;&nbsp;&nbsp;' + 
					'<button class="btn btn-primary" id="remove-btn">Remove</button></td>' +
					"</tr>";

					$('table tbody').append(markup);
				});
			}
		}
	}

	xhr.open("GET", "pending.loadinfo", true);
	xhr.send();
}

function loadManagerPendingInfo() {
	console.log("In loadManagerPendingInfo()...");
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadManagerPendingInfo() - xhr callback...");
			var pendingReimbs = JSON.parse(xhr.responseText);
			console.log(pendingReimbs[0]);
			// to sort array by reimbursementId
			pendingReimbs = bubbleSorter(pendingReimbs);

			if(pendingReimbs.length > 0) {
				pendingReimbs.forEach(function(reimb) {
					let id = reimb.reimbursementId;
					let type = reimb.type;
					let author = reimb.author;
					let amount = parseFloat(Math.round(reimb.amount * 100) / 100).toFixed(2);

					let markup = "<tr>" +
					'<td id="reimbId">' + id + "</td>" +
					'<td id="reimbAuthorId">' + author + "</td>" +
					'<td id="reimbType">' + type + "</td>" +
					'<td id="reimbAmount">$' + amount + "</td>" +
					'<td><button class="btn btn-primary btn-small" id="detail-btn">Details</button>&nbsp;&nbsp;' + 
					'<button class="btn btn-primary btn-small" id="approve-btn">Approve</button>&nbsp;&nbsp;' +
					'<button class="btn btn-primary btn-small" id="deny-btn">Deny</button></td>' +
					"</tr>";

					$('table tbody').append(markup);
				});
			}
		}
	}

	xhr.open("GET", "managerPending.loadinfo", true);
	xhr.send();
}

function loadHistoryInfo() {
	console.log("In loadHistoryInfo()...");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadHistoryInfo() - xhr callback...");
			var reimbHistory = bubbleSorter(JSON.parse(xhr.responseText));
			if(reimbHistory.length > 0) {
				reimbHistory.forEach(function(reimb) {
					let id = reimb.reimbursementId;
					let type = reimb.type;
					let resolver = reimb.resolver;
					let status = reimb.status;

					let amount = parseFloat(Math.round(reimb.amount * 100) / 100).toFixed(2);

					let timeResolved_ms = new Date(reimb.timeResolved),
					year = timeResolved_ms.getFullYear(),
					month = timeResolved_ms.getMonth() + 1,
					day = timeResolved_ms.getDate(),
					hour = (timeResolved_ms.getHours() < 10 ? '0' : '') + timeResolved_ms.getHours(),
					minutes = (timeResolved_ms.getMinutes() < 10 ? '0' : '') + timeResolved_ms.getMinutes();

					let timeResolved_formatted = month + "/" + day + "/" + year + " " + hour + ":" + minutes;
					console.log(timeResolved_formatted);

					let markup = "<tr>" +
					'<td>' + id + "</td>" +
					'<td>' + type + "</td>" +
					'<td>$' + amount + "</td>" +
					'<td>' + status + "</td>" +
					'<td>' + resolver + "</td>" +
					'<td>' + timeResolved_formatted + '</td>' +
					"</tr>";

					$('table tbody').append(markup);
				});
			}
		}
	}
	xhr.open("GET", "history.loadinfo", true);
	xhr.send();
}

function bubbleSorter(array) {
	temp = 0;

	for(i = 0; i < array.length; i++) {

		for(j = 1; j < array.length; j++) {

			if(array[j-1].reimbursementId > array[j].reimbursementId) {

				temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}
		}
	}

	return array;
}

function loadPendingDetailsInfo(ticketId) {
	console.log("In loadPendingDetailsInfo()...");

	var ticketIdForDetails = JSON.stringify(ticketId); 

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In loadPendingDetailsInfo() - xhr callback...");
			var reimb = JSON.parse(xhr.responseText);

			let id = reimb.reimbursementId;
			let author = reimb.author;
			let type = reimb.type;			
			let status = reimb.status;
			let amount = reimb.amount;
			let descr = reimb.description;


			$('#pendingDetails-id').html(id);
			$('#pendingDetails-authorId').html(author);
			$('#pendingDetails-type').html(type);
			$('#pendingDetails-status').html(status);
			$('#pendingDetails-amount').html(amount);
			$('#pendingDetails-description').html(descr);
		}
	}

	xhr.open("POST", "pendingDetails.loadinfo", true);
	xhr.send(ticketId);
}

//------------------------------------------------------------------------------------------------------------------------

function openTicket() {

	var reimbType = $('#openTicket-type').val();

	var reimbTypeId;
	switch (reimbType) {
	case "lodging": reimbTypeId = 1; break;
	case "travel": reimbTypeId = 2; break;
	case "food": reimbTypeId = 3; break;
	case "other": reimbTypeId = 4; break;
	}

	var reimbAmnt = $('#openTicket-amount').val();
	var reimbDescr = $('#openTicket-description').val();


	/*console.log(reimbType);
	console.log(reimbAmnt);
	console.log(reimbDescr);*/

	var newTicket = {
			reimbursementId: 0,
			amount: reimbAmnt,
			timeResolved: null,
			description: reimbDescr,
			receipt: null,
			authorId: 0,
			resolverId: 1,
			statusId: 3,
			typeId: reimbTypeId
	}

	var newTicketJson = JSON.stringify(newTicket);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In openReimbTicket() - xhr callback...");
			var newReimb = JSON.parse(xhr.responseText);

			if (newReimb.reimbursementId == 0) {
				console.log("Reimbursement creation failed!")
			} else {
				alert("Reimbursement creation successful!");
				loadUserOpenTicketView();
			}
		}
	}

	xhr.open("POST", "open.ticketmanager", true);
	xhr.send(newTicketJson);
}

function closeTicket(ticketId) {
	console.log("In closeTicket()...");

	var ticketJson = JSON.stringify(ticketId);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In closeTicket() - xhr callback...");
			console.log("Ticket id: " + ticketId + ", closed!");
			loadUserPendingView();
		}
	}

	xhr.open("POST", "close.ticketmanager", true);
	xhr.send(ticketJson);
}

function approveOpenTicket(ticketId) {
	console.log("In approveOpenTicket()...");
	var approvedTicketId = JSON.stringify(ticketId);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("In approveOpenTicket() - xhr callback...");
			console.log("Ticket id: " + ticketId + ", approved!");
			loadManagerPendingView();
		}
	}
	xhr.open("POST", "approve.ticketmanager", true);
	xhr.send(approvedTicketId);
}

function denyOpenTicket(ticketId) {
	console.log("In denyOpenTicket()...");
	var deniedTicketId = JSON.stringify(ticketId);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In denyOpenTicket() - xhr callback...");
			console.log("Ticket id: " + ticketId + ", denied!");
			loadManagerPendingView();
		}
	}
	xhr.open("POST", "deny.ticketmanager", true);
	xhr.send(deniedTicketId);
}

function updatePendingTicket(ticketId) {
	console.log("In updatePendingTicket()...");

	var reimbType = $('#editTicket-type').val();

	var reimbTypeId;
	switch (reimbType) {
	case "lodging": reimbTypeId = 1; break;
	case "travel": reimbTypeId = 2; break;
	case "food": reimbTypeId = 3; break;
	case "other": reimbTypeId = 4; break;
	}

	var reimbAmnt = $('#editTicket-amount').val();
	var reimbDescr = $('#editTicket-description').val();

	var updatedTicket = {
			reimbursementId: ticketId,
			amount: reimbAmnt,
			timeResolved: null,
			description: reimbDescr,
			receipt: null,
			authorId: 0,
			resolverId: 1,
			statusId: 3,
			typeId: reimbTypeId
	}
	
	var updatedTicketJson = JSON.stringify(updatedTicket);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In updatePendingTicket() - xhr callback...");
			var updatedReimb = JSON.parse(xhr.responseText);

			if (updatedReimb.reimbursementId == 0) {
				alert("Reimbursement update failed!")
			} else {
				alert("Reimbursement update successful!");
				loadPendingDetailsView(ticketId);
			}
		}
	}

	xhr.open("POST", "update.ticketmanager", true);
	xhr.send(updatedTicketJson);

}

function updateUserProfile() {
	console.log("In updateUserProfile()...");
	var updatedUsername = $('#editProfile-username').val();
	var updatedEmail = $('#editProfile-email').val();
	var updatedPassword = $('#editProfile-password').val();
	
	var updatedUser = {
			userId: 0,
			username: updatedUsername,
			password: updatedPassword,
			firstName: null,
			lastName: null,
			emailAddress: updatedEmail,
			roleId: 0
	}
	
	var updatedUserJson = JSON.stringify(updatedUser);

	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("In updateUserProfile() - xhr callback...");
			var updatedProfile = JSON.parse(xhr.responseText);
			if(updatedProfile == null) {
				alert("Profile update failed!")
			} else {
				alert("Profile update successful!\nPlease login again for changes to take effect.");
				loadLoginView();
			}
		}
	}
	
	xhr.open("POST", "updateAccount", true);
	xhr.send(updatedUserJson);
}

//------------------------------------------------------------------------------------------------------------------------

function login() {

	console.log("In login()...");

	var username = $('#login-username').val();
	var password = $('#login-password').val();

	var toSend = [username, password];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			$("#login-message").show();

			if (user == null) {
				$("#login-message").html("Invalid username!");
			} else if (user.username == null) {
				$("#login-message").html("Invalid password!");
			} else {
				$("#login-message").html(`Welcome, ${user.username}`);
				console.log(`User id: ${user.userId} login successful!`);
				loadHomeView();
			}
		}
	};

	xhr.open("POST", "session", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function mlogin() {

	console.log("In mlogin()...");

	var username = $('#mlogin-username').val();
	var password = $('#mlogin-password').val();

	var toSend = [username, password];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			$("#mlogin-message").show();

			if (user == null) {
				$("#mlogin-message").html("Invalid username!");
			} else if (user.roleId > 2) {
				$("#mlogin-message").html("Insufficient permissions!<br>Please use standard user login")
			} else if (user.username == null) {
				$("#mlogin-message").html("Invalid password!");
			} else {
				$("#mlogin-message").html(`Welcome, ${user.username}`);
				console.log(`User id: ${user.userId} login successful!`);
				/*if (user.id != 1) { loadManagerHomeView(); }
				else { loadAdminHomeView(); }*/
				loadManagerHomeView();
			}
		}
	};

	xhr.open("POST", "session", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
}

function logout() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("in logout xhr call back");
			loadLoginView();
		}
	}

	xhr.open("GET", "session", true)
	xhr.send();
}