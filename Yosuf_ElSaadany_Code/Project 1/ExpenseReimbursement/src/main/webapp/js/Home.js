
// WINDOW ONLOAD LISTENERS
window.onload = function(){
	loadProfileView();
	$('#logout').on('click', logout);
	
	$('#profile').on('click', loadProfileView);
	$('#add').on('click', loadAddReimbursement);
	$('#past').on('click', loadPastReimbursements);	
	
	$('#managerview').on('click', loadViewAll);
	$('#managerfilter').on('click', loadfiltered);
}

//-------------------------------------------------------------------------------------//
//								      MANAGER
//-------------------------------------------------------------------------------------//

// LOAD 'VIEW ALL REIMBURSEMENTS' VIEW
function loadViewAll(){
	// AJAX REQUEST TO GET VIEW 
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "ManagerView.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			viewAll();
		}
	}	
}

var count = 0;
// VIEW ALL REIMBURSEMENTS
function viewAll(){
	// DELETE ALL ROWS EVERYTIME TO GET RID OF DUPLICATES
	//$("#table-body").children().remove();
	$("#table-body tr").remove(); 
	console.log("HERE " + ++count);
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "ManagerViewAll" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pastTickets = JSON.parse(xhr.responseText);
			for(var i = 0; i < pastTickets.length; i++){
				var Reimb1 = pastTickets[i];

				// CHANGE TYPE FROM ID TO CORRESPONDING STRING
				if(Reimb1.status == 1)
					var status = "Pending";
				if(Reimb1.status == 2)
					var status = "Approved";
				if(Reimb1.status == 3)
					var status = "Denied";

				if(Reimb1.type == 1)
					var type = "Food";
				if(Reimb1.type == 2)
					var type = "Travel";
				if(Reimb1.type == 3)
					var type = "Lodging";
				if(Reimb1.type == 4)
					var type = "Other";

				if(Reimb1.resolved == null)
					Reimb1.resolved = "Not Resolved Yet";

				if(Reimb1.description == null)
					Reimb1.resolved = "N/A";

				var employeeName = Reimb1.firstname + " " + Reimb1.lastname;
				var managerName = Reimb1.resolverfn + " " + Reimb1.resolverln;
				
				if(Reimb1.resolverfn == null)
					managerName = "N/A";
				
				// SET COLUMN VALUES
				var rd = 
				   `<td>${Reimb1.reimb_id}</td>
					<td>${employeeName}</td>
					<td>${Reimb1.email}</td>
					<td>${Reimb1.amount}</td>
					<td>${managerName}</td>
					<td>${status}</td>
					<td>${type}</td>
					<td>${Reimb1.description}</td>
					<td>${Reimb1.submitted}</td>
					<td>${Reimb1.resolved}</td>`;
				
				// CREATE TABLE ROW
				var tr = document.createElement("tr");
			
				// INSERT ROW DATA INTO ROW
				tr.innerHTML = rd;
				
				// APPEND ROW TO TABLE
				$('#table-body').append(tr);
			}
			// DATATABLES
			$('#table').DataTable();
			
			// CLICK ON ROW TO APPROVE OR DENY REIMBURSEMENT
			$("#table tr").click(function(){
				   $(this).addClass('selected').siblings().removeClass('selected');    
				   var value = $(this).find('td:first').html();
				   $('#reimb_ID').html(value);
				//	$(this).remove(); 
				   process1(value);
			});
		}
	}		
}

// GET MANAGER'S INFO
function process1(value) { 
	var xhr1 = new XMLHttpRequest();
	xhr1.open("GET", "getUserInfo" , true);
	xhr1.send();
	xhr1.onreadystatechange = function(){
		if(xhr1.readyState == 4 && xhr1.status == 200){
			$('#messagee').hide();
			// Get DTO
			sessionUser = JSON.parse(xhr1.responseText);
			var user = sessionUser.user;
			process2(user, value);
		}
	}
}

// RESOLVE THE REIMBURSEMENT
function process2(user, value){

	$('#process').on('click', goProcess);
	function goProcess() {
		var reimbID = value;
		var status = $('#status').val();
		var resolver = user.user_id;
		
		if(status == "Approve")
			status = 2;
		if(status == "Deny")
			status = 3;
		
		var toSend = [reimbID, status, resolver];
		var json = JSON.stringify(toSend);	
		console.log("JSON: " + json);
		
		/*if(reimbID == "") {
			$('#messagee').show();
			$('#messagee').html("Please enter all information");
		    $(function() {
		        setTimeout(function() {
		            $("#messagee").hide('blind', {}, 500)
		        }, 2000);
		    });
		}
		else*/ if(status == null){
			$('#messagee').show();
			$('#messagee').html("Please enter all information");
			 $(function() {
			        setTimeout(function() {
			            $("#messagee").hide('blind', {}, 500)
			        }, 2000);
			    });
		}
		else {
			var xhr = new XMLHttpRequest();
			xhr.open("POST","process",true);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.send(json);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status==200){
					var result = JSON.parse(xhr.responseText);
					if(result == 0){
						$('#messagee').show();
						$('#messagee').html("Error");
						$(function() {
						        setTimeout(function() {
						            $("#messagee").hide('blind', {}, 500)
						        }, 2000);
						});
					}
				}
			};
			viewAll();
		}
		//window.location.reload(true);
		//viewAll();
	}
}


//-------------------------------------------------------------------------------------//
// LOAD FILTERED REIMBURSEMENTS
function loadfiltered(){
	// AJAX REQUEST TO GET VIEW 
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "ManagerFilter.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			console.log("MANAGER VIEW");
			$('#SubmitStatus').on('click', Filtered);
		}	
	}	
}

// VIEW FILTERED REIMBURSEMENTS
function Filtered(){
	// DELETE ALL ROWS EVERYTIME TO GET RID OF DUPLICATES
	$("#table-body2").children().remove();

	// AJAX REQUEST TO GET VIEW
	var status = $('#status').val();
	
	if(status == "Pending")
		var x = 1;
	if(status == "Approved")
		var x = 2;
	if(status == "Denied")
		var x = 3;
	
	var toSend = [x];
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "ManagerFiltered", true);
	xhr.send(json);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pastTickets = JSON.parse(xhr.responseText);
			for(var i = 0; i < pastTickets.length; i++){
				var Reimb1 = pastTickets[i];

				// CHANGE TYPE FROM ID TO CORRESPONDING STRING
				if(Reimb1.status == 1)
					var status = "Pending";
				if(Reimb1.status == 2)
					var status = "Approved";
				if(Reimb1.status == 3)
					var status = "Denied";

				if(Reimb1.type == 1)
					var type = "Food";
				if(Reimb1.type == 2)
					var type = "Travel";
				if(Reimb1.type == 3)
					var type = "Lodging";
				if(Reimb1.type == 4)
					var type = "Other";

				if(Reimb1.resolved == null)
					Reimb1.resolved = "Not Resolved Yet";

				if(Reimb1.description == null)
					Reimb1.resolved = "N/A";

				var employeeName = Reimb1.firstname + " " + Reimb1.lastname;
				var managerName = Reimb1.resolverfn + " " + Reimb1.resolverln;
				
				if(Reimb1.resolverfn == null)
					managerName = "N/A";
				
				// SET COLUMN VALUES
				var rd = 
				   `<td>${Reimb1.reimb_id}</td>
					<td>${employeeName}</td>
					<td>${Reimb1.email}</td>
					<td>${Reimb1.amount}</td>
					<td>${managerName}</td>
					<td>${status}</td>
					<td>${type}</td>
					<td>${Reimb1.description}</td>
					<td>${Reimb1.submitted}</td>
					<td>${Reimb1.resolved}</td>`;
				
				// CREATE TABLE ROW
				var tr = document.createElement("tr");
			
				// INSERT ROW DATA INTO ROW
				tr.innerHTML = rd;
				
				// APPEND ROW TO TABLE
				$('#table-body2').append(tr);
			}
			// DATATABLES
			$('#table2').DataTable();
		}
	}
}

//-------------------------------------------------------------------------------------//
//										BOTH
//-------------------------------------------------------------------------------------//

// UPDATE USER INFO 
function changeInfo(){
	$('#M').hide();
	// GET INPUT FROM USER
	var username = $('#Username').val();
	var password = $('#Password').val();
	var firstname = $('#Firstname').val();
	var lastname = $('#Lastname').val();
	var email = $('#Email').val();

	// CONVERT VARIABLES TO JSON
	var toSend = [username, password, firstname, lastname, email];
	var json = JSON.stringify(toSend);
	console.log("THIS IS THE JSON WE'RE SENDING: " + json);
	
	// AJAX REQUEST
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "updateInfo", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#M').show();
				$('#M').html("Username or email already registered");
			    $(function() {
			        setTimeout(function() {
			            $("#M").hide('blind', {}, 500)
			        }, 2000);
			    });
			    $('#Username').val("");
				$('#Password').val("");
				$('#Firstname').val("");
				$('#Lastname').val("");
				$('#Email').val("");
			}
			else {
				loadProfileView();
			}
		}
	}	
}

//-------------------------------------------------------------------------------------//
// MOVE ACCORDION UP AND DOWN ON CLICK
function Accordion() {
	console.log("ACCORDION");
	var acc = document.getElementsByClassName("accordion");
	var i;
	for (i = 0; i < acc.length; i++) {
	  acc[i].onclick = function() {
		this.classList.toggle("active");
		var panel = this.nextElementSibling;
		if (panel.style.maxHeight){
		  panel.style.maxHeight = null;
		} else {
		  panel.style.maxHeight = panel.scrollHeight + "px";
		} 
	  }
	}
	$('#changeinfo').on('click', changeInfo);
}

//-------------------------------------------------------------------------------------//
// LOGOUT TO login.html PAGE
function logout() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "logout", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("Loggin out");
			window.location.replace("Login.html");
		}
	}
}

//-------------------------------------------------------------------------------------//
// LOAD USER'S PROFILE VIEW
function loadProfileView() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "profile.view" , true);
	//xhr.open("GET", "getProfileView" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			$('#M').hide();
			getUserInfoProfileView();
		}
	}	
};

// GET USER INFO FROM SESSION TO DISPLAY ON 'PROFILE VIEW' 
function getUserInfoProfileView() {
	var sessionUser;
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getUserInfo" , true);
	xhr.send();	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			sessionUser = JSON.parse(xhr.responseText);
			console.log(sessionUser);
			var user = sessionUser.user;
			$('#firstname').html(user.firstname);
			$('#lastname').html(user.lastname);
			$('#username').html(user.username);
			$('#email').html(user.email);
			if(user.userRole == 1)
				var userRole = "Employee";
			else
				var userRole = "Manager";
			$('#userRole').html(userRole);
			if(userRole == "Manager"){
				$("#add").hide();
				$('#past').hide();
			}
			else {
				$('#managerview').hide();
				$('#managerfilter').hide();
				$('#managerprocess').hide();
			}
			Accordion();
		}
	}
}

//-------------------------------------------------------------------------------------//
//										EMPLOYEE
//-------------------------------------------------------------------------------------//
// LOAD 'ADD REIMBURSEMENT' VIEW
function loadAddReimbursement(){
	// AJAX REQUEST TO GET VIEW
	var xhr = new XMLHttpRequest();
	//xhr.open("GET", "getAddView", true);
	xhr.open("GET", "AddReimbursement.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').
			innerHTML = xhr.responseText;	
			$('#message').hide();
			getInfoToAddReimbursement();
		}
	}
}
			
// LOAD USER'S INFORMATION FROM DTO
function getInfoToAddReimbursement() {
	var xhr1 = new XMLHttpRequest();
	xhr1.open("GET", "getUserInfo" , true);
	xhr1.send();
	console.log("IN VIEW");
	xhr1.onreadystatechange = function(){
		if(xhr1.readyState == 4 && xhr1.status == 200){
			// Get DTO
			sessionUser = JSON.parse(xhr1.responseText);
			var user = sessionUser.user;
			var username = user.username;
			addReimbursement(username);
		}
	}
}

// CALL FUNCTION UPON USER REQUESTING TO ADD REIMBURSEMENT
function addReimbursement(username){
	$('#request').on('click',request);
	function request() {
		// GET VARIABLES FROM USER
		var amount = $("#amount").val();
		var type = $("#type").val();
		var description = $("#description").val();
		if(description == "")
			var description = "N/A";
		
		if(amount == "" || type == null) { 
			$('#message').show();
			$('#message').html("Please enter all information");
			 $(function() {
			        setTimeout(function() {
			            $("#message").hide('blind', {}, 500)
			        }, 2000);
			    });
		}
		else {
			// CONVERT VARIABLES TO JSON
			var toSend = [username, amount, type, description];
			var json = JSON.stringify(toSend);
			console.log("THIS IS THE JSON WE'RE SENDING: " + json);
			// AJAX REQUEST
			var xhr = new XMLHttpRequest();
			xhr.open("POST", "AddReimb", true);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.send(json);
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4 && xhr.status==200){
					console.log("in xhr callback" + xhr.responseText);
					var tickets = JSON.parse(xhr.responseText);
					if(tickets == null){
						$('#message').show();
						$('#message').html("Error. Please try again later");
						 $(function() {
						        setTimeout(function() {
						            $("#message").hide('blind', {}, 500)
						        }, 2000);
						    });	
					}
					else {
						$('#message').html("Thank you for submitting a request");
						$("#username").val("");
						$("#amount").val("");
						$("#type").val("");
						$("#description").val("");
					}
				}
			};
		}
	}
}

//-------------------------------------------------------------------------------------//
// LOAD VIEW PAST REIMBURSEMENTS VIEW
function loadPastReimbursements() {
	// AJAX REQUEST TO GET VIEW 
	var xhr = new XMLHttpRequest();
	//xhr.open("GET", "getPastTicketsView", true);
	xhr.open("GET", "ViewPastReimbursements.view", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#message2').hide();
			getPastReimbursements();
		}
	}
}

//GET USER INFO FROM SESSION AND VIEW PAST REIMBURSEMENTS
function getPastReimbursements() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getUserInfo" , true);
	xhr.send();
	console.log("IN VIEW");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			// Get DTO
			sessionUser = JSON.parse(xhr.responseText);
			var user = sessionUser.user;
			var pastTickets = sessionUser.pastReimbursments;
					
			console.log("INSIDE: " + user.username);
			console.log("INSIDE: " + pastTickets[1]);

			
			// If user has no past tickets 
			if(pastTickets == ""){
				$('#message2').show();
				$('#message2').html("You have no history of Reimbursements");
				$(function() {
				       setTimeout(function() {
				           $("#message2").hide('blind', {}, 500)
				       }, 2000);
				   });
			}
			else {
				for(var i = 0; i < pastTickets.length; i++){
					var Reimb1 = pastTickets[i];
					
					// CHANGE STATUS FROM ID TO CORRESPONDING STRING
					if(Reimb1.status == 1)
						var status = "Pending";
					if(Reimb1.status == 2)
						var status = "Approved";
					if(Reimb1.status == 3)
						var status = "Denied";
					
					// CHANGE TYPE FROM ID TO CORRESPONDING STRING
					if(Reimb1.type == 1)
						var type = "Food";
					if(Reimb1.type == 2)
						var type = "Travel";
					if(Reimb1.type == 3)
						var type = "Lodging";
					if(Reimb1.type == 4)
						var type = "Other";
					
					if(Reimb1.resolved == null)
						Reimb1.resolved = "Not Resolved Yet";

					if(Reimb1.description == null)
						Reimb1.resolved = "N/A";

					// SET COLUMN VALUES
					var rd = 
					   `<td>${Reimb1.amount}</td>
						<td>${type}</td>
						<td>${Reimb1.description}</td>
						<td>${status}</td>
						<td>${Reimb1.submitted}</td>
						<td>${Reimb1.resolved}</td>`;
						//<td>${Reimb1.resolver}</td>
					
					// CREATE TABLE ROW
					var tr = document.createElement("tr");
				
					// INSERT ROW DATA INTO ROW
					tr.innerHTML = rd;
					
					// APPEND ROW TO TABLE
					$('#table-body1').append(tr);
				}
				// DATATABLES
				$('#table1').DataTable();
			}
		}
	}
}


