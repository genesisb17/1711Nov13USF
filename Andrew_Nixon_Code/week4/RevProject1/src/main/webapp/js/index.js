/**
 * 
 */

var tableData;

window.onload = function() {
	$('#login').on('click', login);
	$('#register').on('click', loadRegister);

}

function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	var toSend = [ username, password ];
	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();

	xhr.open("POST", "userLogin", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(json);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if (user === null) {
				$('#message').html("Invalid user");
			} else if (user.userID === -1) {
				$('#message').html("Invalid password");
			} else {
				console.log("loading main");
				loadMain();

			}
		}
	}
}

function loadMain() {
	console.log("in loadMain")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			getUserInfo();
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "main.view", true);
	xhr.send();
}

function getUserInfo() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "userInfo.view", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			getUserInfoHelper();
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
}

function loadEmployee() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInfo();
		}
	}
	xhr.open("GET", "employeePage.view", true);
	xhr.send();
}

function loadManager() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInfo();
		}
	}
	xhr.open("GET", "employeePage.view", true);
	xhr.send();
}

function getUserInfoHelper() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var sessionUser = JSON.parse(xhr.responseText);
			$("#fname").html(sessionUser.firstName);
			$("#lname").html(sessionUser.lastName);
			$('#submittedReimb').on('click', getReimbByAuthor);
			$('#persistReimb').on('click', createReimb);
			$('#pendingReimb').on('click', getPendingReimbs);
			$('#logout').on('click', logout);
			$('#allReimb').on('click', getAllReimbs);
			$('#resolveReimb').on('click', resolveReimb);
			createManagerTable();
			createAuthorTable();
		}
	}
}

function getReimbByAuthor() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getReimbByAuthor", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rData = JSON.parse(xhr.responseText);
			var Data = xhr.responseText;
			
			//document.getElementById('reimbs').innerHTML = xhr.responseText;
		}
	}
}

function getPendingReimbs() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getPendingReimbs", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('getPending').innerHTML = xhr.responseText;
		}
	}
}

function getAllReimbs() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getAllReimbs", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var rData = JSON.parse(xhr.responseText);
			var Data = xhr.responseText;
		}
	}
}

function loadRegister() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#persistUser').on('click', createUser);

		}
	}
	xhr.open("GET", "registerUser.view", true);
	xhr.send();
}

function createUser() {
	var fn = $('#rfname').val();
	var ln = $('#rlname').val();
	var un = $('#username').val();
	var pw = $('#password').val();
	var r = $('#rrole').val();
	var iuid = 0;

	if (r === "Employee") {
		r = 21;
	}
	if (r === "Financial Manager") {
		r = 22;
	}

	var user = {
		userID : iuid,
		username : un,
		password : pw,
		firstName : fn,
		lastName : ln,
		email : "",
		roleID : r
	};
	var userJSON = JSON.stringify(user);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			loadHome();

		}
	}
	xhr.open("POST", "createUser", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send(userJSON);
}

function loadHome() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#login').on('click', login);
			$('#register').on('click', loadRegister);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}

function createReimb() {
	var a = $('#amount').val();
	var rt = $('#reimbType').val();
	var d = $('#reimbDescription').val();

	switch (rt) {
	case "Lodging":
		rt = 21;
		break;
	case "Travel":
		rt = 22;
		break;
	case "Food":
		rt = 23;
		break;
	case "Other":
		rt = 24;
		break;
	}

	var reimbursement = {
		reimbID : 0,
		amount : a,
		submitted : null,
		resolved : null,
		description : d,
		receipt : null,
		author : 0,
		resolver : 0,
		statusID : 21,
		typeID : rt
	};

	var rJSON = JSON.stringify(reimbursement);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

		}
	}
	xhr.open("POST", "createReimbursement", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send(rJSON);

}

function logout() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "logoutFromSession", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			loadHome();

		}
	}

}

function resolveReimb() {
	var resolvedID = $('#reimbID').val();
	var resolvedStatus = $('#reimbStatus').val();

	if (resolvedStatus == "Approve") {
		resolvedStatus = 22;
	} else {
		resolvedStatus = 23;
	}

	var reimbursement = {
		reimbID : resolvedID,
		amount : 0,
		submitted : null,
		resolved : null,
		description : null,
		receipt : null,
		author : 0,
		resolver : 0,
		statusID : resolvedStatus,
		typeID : 0
	};
	var rrJSON = JSON.stringify(reimbursement);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "resolve", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(rrJSON);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var resolution = JSON.parse(xhr.responseText);
			if (resolution === null) {
				$('#resolveMessage').html("Failure: Invalid Reimbursement ID");
			}else if (resolution.reimbID === -1) {
				$('#resolveMessage').html("Failure: Reimbursement arleady resolved.");
			} 
			else {
				$('#resolveMessage').html("Success: Reimbursement Resolved");
			}
		}
	}
}

function createAuthorTable(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getReimbByAuthor", true);
	xhr.send();
    var allReimbs = [];

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var Data = JSON.parse(xhr.responseText);
			
			for (di = 0; di < Data.length; ++di){
                allReimbs[di] = [Data[di].submitted, Data[di].amount, Data[di].type, 
					Data[di].description, Data[di].status, Data[di].resolved];

			}
			$('#user_table').DataTable( {
		        data: allReimbs,
		        columns: [
		            { title: "Submitted" },
		            { title: "Amount" },
		            { title: "Type" },
		            { title: "Description" },
		            { title: "Status" },
		            { title: "Resolved" }
		        ]
		    } );
		}
	}
}

function createManagerTable(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "managerTable", true);
	xhr.send();
    var allReimbs = [];

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var Data = JSON.parse(xhr.responseText);
			
			for (di = 0; di < Data.length; ++di){
                allReimbs[di] = [Data[di].reimbursementID, Data[di].authorName,  Data[di].submitted, 
                	Data[di].amount, Data[di].type, Data[di].description, Data[di].status, Data[di].resolved];

			}
			$('#manager_table').DataTable( {
		        data: allReimbs,
		        columns: [
		            { title: "Reimbursement ID" },
		            { title: "Author" },
		            { title: "Submitted" },
		            { title: "Amount" },
		            { title: "Type" },
		            { title: "Description" },
		            { title: "Status" },
		            { title: "Resolved" }
		        ]
		    } );
		}
	}
}

