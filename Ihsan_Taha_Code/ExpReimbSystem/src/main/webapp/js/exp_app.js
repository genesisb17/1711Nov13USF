// ---------------------------------------------------------------------------
// 0. Session Variables & Required Global Variables
// ---------------------------------------------------------------------------
var sessionUser;
var sessionReimb;
var sessionUpdateReimb;

var sessionAuthor;
var sessionAuthors;

var status;
var type;
var submitted;
var resolved;
var receipt;
var resolver;



// ---------------------------------------------------------------------------
// 1. Listen for Button click events - (Login or Register)
// ---------------------------------------------------------------------------
window.onload = function() 
{	
	$('#registerBtn').on('click', registerFunc);
	$('#loginBtn').on('click', loginFunc);
	$('#logoutBtn').on('click', logoutFunc);
}



//----------------------------------------------------------------------------
// 1. Register
//----------------------------------------------------------------------------
function registerFunc()
{
	let un = $('#username').val();
	let pw = $('#password').val();
	let fn = $('#firstname').val();
	let ln = $('#lastname').val();
	let ue = $('#useremail').val();
	let ur = $('.selectpicker').val();
	
	let validUsername;
	let validPassword;
	let validFirstName;
	let validLastName;
	let validEmail;
	let validRole;
	
	if ($('#myselect option:selected').text() == "User")
		ur = 1;
	else if ($('#myselect option:selected').text() == "Manager")
		ur = 2;
	else
		ur = 0;
	
	
	// Beginning of Validate Input -------------------------
	if (un == "")
	{
		$('#userNameError').show();
		validUsername = false;
	}
	else
	{
		$('#userNameError').hide();
		validUsername = true;
	}
	
	if (pw == "")
	{
		$('#userPassError').show();
		validPassword = false;
	}
	else
	{
		$('#userPassError').hide();
		validPassword = true;
	}
	
	if (fn == "")
	{
		$('#userFNError').show();
		validFirstName = false;
	}
	else
	{
		$('#userFNError').hide();
		validFirstName = true;
	}
	
	if (ln == "")
	{
		$('#userLNError').show();
		validLastName = false;
	}
	else
	{
		$('#userLNError').hide();
		validLastName = true;
	}
	
	if (ue == "")
	{
		$('#userEmailError').show();
		validEmail = false;
	}
	else
	{
		$('#userEmailError').hide();
		validEmail = true;
	}
	
	if (ur == 2)
	{
		let managerCode = prompt("Please enter the manager code: ");
		if (managerCode != "abcde")
		{
			validUsername = false;
			alert("You have entered an invalid manager code. Please try again.");
			location.reload();
		}
	}
	
	if (ur == 0)
	{
		$('#userRoleError').show();
		validRole = false;
	}
	else
	{
		$('#userRoleError').hide();
		validRole = true;
	}
	// End of Validate Input -------------------------------
	
	if (((validUsername && validPassword) && validEmail) && (validRole && (validFirstName && validLastName)))
	{
		var user =
		{
			userId: 0,
			userName: un,
			passWord: pw,
			firstName: fn,
			lastName: ln,
			userEmail: ue,
			roleId: ur
		};
	
		var userJson = JSON.stringify(user);
	
		var xhr = new XMLHttpRequest();
		xhr.open("POST","RegisterServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(userJson);
		xhr.onreadystatechange = function()
		{
			if(xhr.readyState == 4 &&  xhr.status == 200)
			{			
				if (xhr.responseText == "incorrect")
				{
					alert("User and email already exists! Please try again.");
					location.reload();
				}
				else
				{
					alert("Successful Registration. Please login.");
					location.reload();
				}
			}
		}
	}
	else
	{
		document.getElementById('useremail').focus();
	}
}



//----------------------------------------------------------------------------
// 3. Login
//----------------------------------------------------------------------------
function loginFunc()
{	
	let userlogin = $('#loginUsername').val();
	let userPassword = $('#loginPassword').val();
	let validUsername;
	let validPassword;
	
	if (userlogin == "") 
	{
		$('#loginError').show();
		validUsername = false;
	}
	else
	{
		$('#loginError').hide();
		validUsername = true;
	}
	
	if (userPassword == "")
	{
		$('#passwordError').show();
		validPassword = false;
	}
	else
	{
		$('#passwordError').hide();
		validPassword = true;
	}
	
	if (validUsername && validPassword)
	{
		var toSend = [userlogin, userPassword];
		var loginJson = JSON.stringify(toSend);
	
		var xhr = new XMLHttpRequest();	
		xhr.open("POST", "LoginServlet", true);
		xhr.send(loginJson);
		xhr.onreadystatechange = function() 
		{
			if (xhr.readyState == 4 && xhr.status == 200) 
			{
				if (xhr.responseText == "incorrect")
				{
					alert("You have entered incorrect information. Please try again.");
					location.reload();
				}
				else
				{
					sessionUser = JSON.parse(xhr.responseText);
					loadView("GetHeader.view", "headerView");
					loadView("GetMenu.view", "menuView");
					loadView("GetContent.view", "contentView");
				}
			}
		}
	}
}



//----------------------------------------------------------------------------
// 4. Load new views according to arguments (page and id)
//----------------------------------------------------------------------------
function loadView(page, id)
{
	var xhr = new XMLHttpRequest();
	xhr.open("GET", page, true);
	xhr.send();
	xhr.onreadystatechange = function()
	{
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			document.getElementById(id).innerHTML = xhr.responseText;
			if (page == "GetHeader.view")
			{
				$('#logoutBtn').show();
				$('#sessionUser').html(sessionUser.firstName);
			}
			else if (page == "GetMenu.view")
				loadRequests();
			else if (page == "GetContent.view")
			{
				$('#newRequestContent').hide();
				$('#updateRequestContent').hide();
			}
		}
	}
}




//----------------------------------------------------------------------------
function getAuthor(aId)
{
	var author =
	{
		authorId: aId,
		authorName: "",
	}
	
	var authorJson = JSON.stringify(author);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "GetAuthorServlet", true);
	xhr.send(authorJson);
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 &&  xhr.status == 200)
		{
			sessionAuthor = JSON.parse(xhr.responseText);
			sessionAuthors.push(sessionAuthor);
		}
	} 
}



//----------------------------------------------------------------------------
// 5. loadRequests
//----------------------------------------------------------------------------
function loadRequests()
{
	let inUserView;
	let inManagerView;
	
	// Manage user role controls
	if (sessionUser.roleId == 2)
		$('#createNewRequestBtn').hide();
	
	$('#viewRequestsBtn').prop('disabled', true);
	$('#createNewRequestBtn').prop('disabled', false);
	$('#createNewRequestBtn').on('click', loadNewRequest);
	
	// Ajax call to get list of reimbursements
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "GetReimbListServlet", true);
	xhr.send();
	xhr.onreadystatechange = function() 
	{	
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			$("table tbody").html("");
			
			var reimbs = [];
			sessionAuthors = [];
			var jsonArray = JSON.parse(xhr.responseText);
			
			if (jsonArray == null)
			{
				$('#viewRequestsBtn').hide();
				$('#managerViews').hide();
				$('#userPastViews').html("You have no data yet. Please create a new reimbursement.");
			}
		
			else
			{
				for(var i = 0; i < jsonArray.length; i++)
					reimbs.push(jsonArray[i]);
				
				if (sessionUser.roleId == 2)
				{
					for (var i = 0; i < reimbs.length; i++)
						getAuthor(reimbs[i].reimbAuthor);
				}
			
				for (var i = 0; i < reimbs.length; i++)
				{
					//---------------------------------------------------
					// Formatting Data for Human Readability
					//---------------------------------------------------
					
					// Status
					if (reimbs[i].reimbStatusId == 1)
						status = "Pending";
					else if (reimbs[i].reimbStatusId == 2)
						status = "Approved";
					else if (reimbs[i].reimbStatusId == 3)
						status = "Denied";

					// Type	
					if (reimbs[i].reimbTypeId == 1)
						type = "Lodging";
					else if (reimbs[i].reimbTypeId == 2)
						type = "Travel";
					else if (reimbs[i].reimbTypeId == 3)
						type = "Food";
					else if (reimbs[i].reimbTypeId == 4)
						type = "Other";
				
					// Submitted
					submitted = reimbs[i].reimbSubmitted.substring(0,19);
				
					// Resolved
					if  (reimbs[i].reimbResolved == null)
						resolved = "No";
					else
						resolved = reimbs[i].reimbResolved.substring(0,19);
				
					// Receipt		
					if (reimbs[i].reimbReceipt == null)
						receipt = "None";
				
					// Resolver
					if (reimbs[i].reimbResolver == 0)
						resolver = "None";
					else
						resolver = reimbs[i].reimbResolver;
				

					// Role
					//---------------------------------------------------
					if (sessionUser.roleId == 1)
					{
						inUserView = true;
						inManagerView = false;
						$('#managerViews').hide();
					
						var markup = 					    "<tr><td>" + 
							reimbs[i].reimbId 			 + "</td><td>" + 
							"$"+reimbs[i].reimbAmount 	 + "</td><td>" +
							status 						 + "</td><td>" + 
							type 						 + "</td><td>" +
							submitted					 + "</td><td>" + 
							resolved				 	 + "</td><td>" +
							resolver 					 + "</td><td>" +
							reimbs[i].reimbDescription	 + "</td><td>" +
							receipt				 		 + "</td></tr>"+
							$("#userPastViews tbody").append(markup);
					}
					//---------------------------------------------------
					else if (sessionUser.roleId == 2)
					{
						inManagerView = true;
						inUserView = false;
						$('#userPastViews').hide();
						
						var markup = 					   "<tr><td>" + 
							reimbs[i].reimbId 			+ "</td><td>" +
							"$"+reimbs[i].reimbAmount 	+ "</td><td>" +
							reimbs[i].reimbAuthor       + "</td><td>" +
							status 						+ "</td><td>" + 
							type 						+ "</td><td>" +
							submitted					+ "</td><td>" + 
							resolved				 	+ "</td><td>" +
							resolver 					+ "</td><td>" +
							receipt				 		+ "</td><td>" +
							"<button id='statBtn' class='btn btn-sm btn-custom'>Update</button></td></tr>" +
							$("#managerViews tbody").append(markup);
					}
				}
				
				if (inUserView)
				{
					inManagerView = false;
					
					$(document).ready(function()
					{
						$('#userPastViews').DataTable();
						$('select').addClass('mdb-select');
					});
				}
				else if (inManagerView)
				{
					inUserView = false;
					
					$(document).ready(function() 
					{
						$('#managerViews').DataTable();	    
						$('select').addClass('mdb-select');
					});
			
					$('body').on('click', '#statBtn', function ()
					{		    	
						let self=$(this);
						let rowIndex = self.closest('tr').index();
						let table = $('#managerViews tbody')[0];
						let cell = table.rows[rowIndex].cells[0];
						let reimbId = $(cell).text();
		    	
						updateRequest(reimbId);
						console.log("In body click " + reimbId);
					});
				}
			}
		}
	}
}



//----------------------------------------------------------------------------
// 6. Load New Request
//----------------------------------------------------------------------------
function loadNewRequest()
{
	$('#viewRequestsBtn').prop('disabled', false);
	$('#createNewRequestBtn').prop('disabled', true);
	
	$('#requestsContent').hide();
	$('#newRequestContent').show();
	$('#updateRequestContent').hide();
	
	$('#viewRequestsBtn').on('click', viewRequests);
	$('#submitNewReqBtn').on('click', submitNewRequest);
}



//----------------------------------------------------------------------------
// 7. View Requests
//----------------------------------------------------------------------------
function viewRequests()
{	
	$('#viewRequestsBtn').prop('disabled', true);
	$('#createNewRequestBtn').prop('disabled', false);
	
	$('#requestsContent').show();
	$('#newRequestContent').hide();
	$('#updateRequestContent').hide();
	
	$('#createNewRequestBtn').on('click', loadNewRequest);
}



//----------------------------------------------------------------------------
// 8. Submit New Request
//----------------------------------------------------------------------------
function submitNewRequest()
{	
	let newReimbType = $('#reimbType option:selected').text();
	let newReimbAmount = $('#reimbAmount').val();
	let newReimbDesc = $('#reimbDesc').val();
	
	let validReimbType;
	let validReimbAmount;
	let validReimbDesc;
	
	if (newReimbType == "Select Reimbursement Type") 
	{
		$('#reimbTypeError').show();
		validReimbType = false;
	}
	else
	{
		$('#reimbTypeError').hide();
		validReimbType = true;
	}
	
	if (newReimbAmount == "")
	{
		$('#reimbAmountError').show();
		validReimbAmount = false;
	}
	else
	{
		$('#reimbAmountError').hide();
		validReimbAmount = true;
	}
	
	if (newReimbDesc == "")
	{
		$('#reimbDescError').show();
		validReimbDesc = false;
	}
	else
	{
		$('#reimbDescError').hide();
		validReimbDesc = true;
	}
	
	if ((validReimbType && validReimbAmount) && (validReimbDesc)) {
		
		switch(newReimbType)
		{
			case "Lodging":
				newReimbType = 1;
				break;
			case "Travel":
				newReimbType = 2;
				break;
			case "Food":
				newReimbType = 3;
				break;
			case "Other":
				newReimbType = 4;
				break;
			default:
				newReimbType = 1;
		}

		var newReimb =
		{
			reimbId: 0,
			reimbAmount: newReimbAmount,
			reimbAuthor: sessionUser.userId,
			reimbResolver: null,
			reimbStatusId: 0,
			reimbTypeId: newReimbType,
			reimbSubmitted: "",
			reimbResolved: 0,
			reimbDescription: newReimbDesc,
			reimbReceipt: null
		}
	
		var newReimbJson = JSON.stringify(newReimb);
	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "PostReimbServlet", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(newReimbJson);
		xhr.onreadystatechange = function()
		{
			if(xhr.readyState == 4 &&  xhr.status == 200)
			{
				loadView("GetMenu.view", "menuView");
				loadView("GetContent.view", "contentView");
			}
		}
	}
	
}



//----------------------------------------------------------------------------
// 9. Update Request
//----------------------------------------------------------------------------
function updateRequest(id)
{	
	$('#viewRequestsBtn').prop('disabled', false);
	$('#createNewRequestBtn').prop('disabled', false);
	
	$('#viewRequestsBtn').on('click', viewRequests);
	$('#createNewRequestBtn').on('click', loadNewRequest);
	
	id = parseInt(id);
	
	var reimb =
	{
		reimbId: id,
		reimbAmount: 0.0,
		reimbAuthor: 0,
		reimbStatusId: 0,
		reimbTypeId: 0,
		reimbSubmitted: "",
		reimbResolved: 0,
		reimbResolver: null,
		reimbDescription: "",
		reimbReceipt: null
	}
	
	var updateJson = JSON.stringify(reimb);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "GetReimbInfoServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(updateJson);
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 &&  xhr.status == 200)
		{
			sessionUpdateReimb = JSON.parse(xhr.responseText);
			
			//---------------------------------------------------
			// Formatting Data for Human Readability
			//---------------------------------------------------
			let author;
			let resolver;
			
			// Author/Resolver
			if (sessionUser.roleId == 2)
			{
				for (var i = 0; i < sessionAuthors.length; i++)
				{
					if (sessionAuthors[i].authorId == sessionUpdateReimb.reimbAuthor)
						author = sessionAuthors[i].authorName;
					/*
					 if (sessionAuthors[i].authorId == sessionUpdateReimb.reimbResolver)
						resolver = sessionAuthors[i].authorName;
					 else if (sessionUpdateReimb.reimbResolver == 0)
						resolver = "None";
					*/
					resolver = sessionUpdateReimb.reimbResolver;
					if (resolver == 0)
						resolver = "None";
				}
			}
			else
			{
				author = sessionUpdateReimb.reimbAuthor;
				resolver = sessionUpdateReimb.reimbResolver;
			}
			
			// Status
			if (sessionUpdateReimb.reimbStatusId == 2)
				status = "Approved";
			else if (sessionUpdateReimb.reimbStatusId == 3)
				status = "Denied";
			else if (sessionUpdateReimb.reimbStatusId == 1)
				status="Pending";
			
			// Type	
			if (sessionUpdateReimb.reimbStatusTypeId == 1)
				type = "Lodging";
			else if (sessionUpdateReimb.reimbStatusTypeId == 2)
				type = "Travel";
			else if (sessionUpdateReimb.reimbStatusTypeId == 3)
				type = "Food";
			else if (sessionUpdateReimb.reimbStatusTypeId == 4)
				type = "Other";
			
			// Submitted
			submitted = sessionUpdateReimb.reimbSubmitted.substring(0,19);
			
			// Resolved
			if  (sessionUpdateReimb.reimbResolved == null)
				resolved = "No";
			else
				resolved = sessionUpdateReimb.reimbResolved.substring(0,19);
			
			// Receipt
			if (sessionUpdateReimb.reimbReceipt == null)
				receipt = "None";
			//---------------------------------------------------
			
			$('#viewRequestsBtn').prop('disabled', false);
			$('#createNewRequestBtn').prop('disabled', false);
			
			$('#requestsContent').hide();
			$('#newRequestContent').hide();
			$('#updateRequestContent').show();
			$('#userPastViews').hide();
			
			$('#idDetail').html(sessionUpdateReimb.reimbId);
			$('#amountDetail').html("$"+sessionUpdateReimb.reimbAmount);
			$('#authorDetail').html(author);
			$('#statusDetail').html(status);
			$('#typeDetail').html(type);
			$('#submittedDetail').html(submitted);
			$('#resolvedDetail').html(resolved);
			$('#resolverDetail').html(resolver);
			$('#descDetail').html(sessionUpdateReimb.reimbDescription);
			$('#receiptDetail').html(receipt);
			
			$('#updateDetailsBtn').on('click', updateStatus);
		}
	}
	
}



//----------------------------------------------------------------------------
// 10. Alert Details
//----------------------------------------------------------------------------
function updateStatus() 
{	
	var selectedOption = $('input[name=resolveAction]:checked').val();
	
	if (selectedOption == "Approve")
		sessionUpdateReimb.reimbStatusId = 2;
	else if (selectedOption == "Deny")
		sessionUpdateReimb.reimbStatusId = 3;
	else if (selectedOption == "Pending")
		sessionUpdateReimb.reimbStatusId = 1;
		
	var reimbJson = JSON.stringify(sessionUpdateReimb);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "UpdateReimbServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(reimbJson);
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 &&  xhr.status == 200)
		{
			loadView("GetMenu.view", "menuView");
			loadView("GetContent.view", "contentView");
		}
	}
	
}




//----------------------------------------------------------------------------
// X. Logout
//----------------------------------------------------------------------------
function logoutFunc()
{
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "LogoutServlet", true);
	xhr.send();
	xhr.onreadystatechange = function() 
	{	
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			alert("Log out Successful");
			location.reload();
		}
	}
}
