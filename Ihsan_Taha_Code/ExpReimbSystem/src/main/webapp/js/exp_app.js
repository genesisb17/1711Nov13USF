// ---------------------------------------------------------------------------
// 1. Listen for Button click events - (Login or Register)
// ---------------------------------------------------------------------------
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
	var userlogin = $('#loginUsername').val();
	var userPassword = $('#loginPassword').val();
	
	// 2. Assign the input values to a string array
	var toSend = [userlogin, userPassword];
	
	// 3. Stringify the array into a json string
	var json = JSON.stringify(toSend);
	
	// 4. Create a new XMLHttpRequest to GetUserInfoServlet to send the json string
	//    for processing and retreive the user information from the database
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "GetUserInfoServlet", true);
	xhr.send(json);
	xhr.onreadystatechange = function() 
	{
		if (xhr.readyState == 4 && xhr.status == 200) 
		{
			var sessionUser = JSON.parse(xhr.responseText);
			$('#sessionUser').html(sessionUser.firstName);
		}
	}
	
	// 5. Load the new views upon successful logging in
	loadView("GetHeader.view", "headerView");
	loadView("GetMenu.view", "menuView");
	loadView("GetContent.view", "contentView");
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
		}
	}
}




//----------------------------------------------------------------------------
// 3. Register
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
	loadView("GetHeader.view", "headerView");
	loadView("GetMenu.view", "menuView");
	loadView("GetContent.view", "contentView");
}




