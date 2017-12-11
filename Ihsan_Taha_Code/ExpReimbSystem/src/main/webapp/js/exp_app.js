// ---------------------------------------------------------------------------
// 1. Listen for Button click events - (Login or Register)
// ---------------------------------------------------------------------------
var sessionUser;
var sessionReimb;
var userlogin;
var userPassword;
var toSend;
var json;

window.onload = function() 
{
	$('#loginBtn').on('click', loginFunc);
	$('#registerBtn').on('click', registerFunc);
}



//----------------------------------------------------------------------------
// 2. Login
//----------------------------------------------------------------------------
function loginFunc()
{
	// 1. Get input values from html file according to their id's
	userlogin = $('#loginUsername').val();
	userPassword = $('#loginPassword').val();
	
	// 2. Assign the input values to a string array
	toSend = [userlogin, userPassword];
	
	// 3. Stringify the array into a json string
	json = JSON.stringify(toSend);
	
	// 4. Create a new XMLHttpRequest to GetUserInfoServlet to send the json string
	//    for processing and retreive the user information from the database
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "GetUserInfoServlet", true);
	xhr.send(json);
	xhr.onreadystatechange = function() 
	{
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			sessionUser = JSON.parse(xhr.responseText);
			loadView("GetHeader.view", "headerView");
			loadView("GetMenu.view", "menuView");
			loadView("GetContent.view", "contentView");
		}
	}
}



//----------------------------------------------------------------------------
// 3. Load new views according to arguments (page and id)
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
				$('#sessionUser').html(sessionUser.firstName);
			}
			else if (page == "GetMenu.view")
			{
				loadRequests();
			}
			else if (page == "GetContent.view")
			{
				$('#newRequestContent').hide();
			}
		}
	}
}



//----------------------------------------------------------------------------
// 3. loadRequests
//----------------------------------------------------------------------------
function loadRequests()
{	
	$('#viewRequests').prop('disabled', true);
	$('#createNewRequest').prop('disabled', false);
	$('#createNewRequest').on('click', loadNewRequest);
	
	sessionReimb = 
	{
		reimbId: 0,
		reimbAmount: 0.0,
		reimbAuthor: 0,
		reimbStatusId: 0,
		reimbTypeId: 0,
		reimbSumbitted: "",
		reimbResolved: 0,
		reimbResolver: null,
		reimbDescription: "",
		reimbReceipt: null
	}
	
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "GetReimbServlet", true);
	xhr.send(json);
	xhr.onreadystatechange = function() 
	{	
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			var reimbs = [];
			var jsonArray = JSON.parse(xhr.responseText);
			for(var i = 0; i < jsonArray.length; i++) {
			    reimbs.push(jsonArray[i]);
			}
			
			for (var i = 0; i < reimbs.length; i++)
			{
				var markup = 					   "<tr><td>" + 
					reimbs[i].reimbId 			+ "</td><td>" + 
					reimbs[i].reimbAmount 		+ "</td><td>" +
					reimbs[i].reimbAuthor 		+ "</td><td>" +
					reimbs[i].reimbStatusId 	+ "</td><td>" + 
					reimbs[i].reimbTypeId 		+ "</td><td>" +
					reimbs[i].reimbSubmitted 	+ "</td><td>" + 
					reimbs[i].reimbResolved 	+ "</td><td>" +
					reimbs[i].reimbResolver 	+ "</td><td>" +
					reimbs[i].reimbDescription 	+ "</td><td>" + 
					reimbs[i].reimbReceipt 		+ "</td></tr>";
	            $("table tbody").append(markup);
			}
			
			$(document).ready(function() {
			    $('#pastViews').DataTable();
			    $('select').addClass('mdb-select');
			    $('.mdb-select').material_select();
			});
		}
	}
}



//----------------------------------------------------------------------------
// 4. Load New Request
//----------------------------------------------------------------------------
function loadNewRequest()
{
	$('#viewRequests').prop('disabled', false);
	$('#createNewRequest').prop('disabled', true);
	$('#requestsContent').hide();
	$('#newRequestContent').show();
	$('#viewRequests').on('click', viewRequests);
}



//----------------------------------------------------------------------------
// 5. View Requests
//----------------------------------------------------------------------------
function viewRequests()
{	
	$('#viewRequests').prop('disabled', true);
	$('#createNewRequest').prop('disabled', false);	
	$('#requestsContent').show();
	$('#newRequestContent').hide();
	$('#createNewRequest').on('click', loadNewRequest);
}



//----------------------------------------------------------------------------
// 5. Register
//----------------------------------------------------------------------------
function registerFunc() 
{
	// 1. Get input values from html file according to their id's
	var un = $('#username').val();
	var pw = $('#password').val();
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var ue = $('#useremail').val();
	var ur = $('.selectpicker').val();
	var ur;
	
	if ($('#myselect option:selected').text() == "User") 
		ur = 1;
	else
		ur = 2;
	
	// 2. Create an object with fields identical to the user pojo and assign
	//    the input values from step 1 into the object
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
	
	// 3. Stringify the new user object into a json string
	var userJSON = JSON.stringify(user);
	
	// 4. Create a new XMLHttpRequest to RegisterServlet to send the json string
	//    for processing and further persist the user into the database
	var xhr = new XMLHttpRequest();	
	xhr.open("POST","RegisterServlet",true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	xhr.onreadystatechange = function() 
	{
		if(xhr.readyState == 4 &&  xhr.status == 200)
			;
	};
	
	// 5. Load the new views upon successful registration
	// loadView("GetHeader.view", "headerView");
	// loadView("GetMenu.view", "menuView");
	// loadView("GetContent.view", "contentView");
}



