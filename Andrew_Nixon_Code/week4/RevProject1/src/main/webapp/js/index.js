/**
 * 
 */

var tableData;

window.onload = function() {
	// $('#message').hide();
	$('#login').on('click', login);
	$('#register').on('click', loadRegister);

}

function login() {
	// window.location.replace('LoginSuccess.html');
	// 1. check if user name is in database.
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
			// console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			console.log(user);
			if (user === null) {
				$('#message').html("Invalid user");
				console.log("bad name!");
			} else if (user.userID === -1) {
				$('#message').html("Invalid password");
				console.log("bad pass!");
			} else {
				// $('#message').html(`Welcome ${user.firstname}`) ;
				console.log("good combo!");
				loadMain();
				// window.location.replace('LoginSuccess.html');

			}
		}
	}
}

function loadMain() {
	console.log("in function loadMain")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// window.location.replace(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			// $('#home').on('click',loadHome);
			// $('#profile').on('click', loadProfile);
			getUserInfo();
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
			console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			getUserInfoHelper();
		}
	}
}

function getUserInfoHelper() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var sessionUser = JSON.parse(xhr.responseText);
			// console.log(sessionUser.firstName);
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
			// console.log(xhr.responseText);
			var rData = JSON.parse(xhr.responseText);
			var Data = xhr.responseText;
			
			document.getElementById('reimbs').innerHTML = xhr.responseText;
		}
	}
}

function getPendingReimbs() {
	console.log("in getPendingReimbs function");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getPendingReimbs", true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// console.log(xhr.responseText);
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
			// console.log(xhr.responseText);
			var rData = JSON.parse(xhr.responseText);
			var Data = xhr.responseText;
			
			//document.getElementById('reimbs').innerHTML = xhr.responseText;
		}
	}
}

function loadRegister() {
	console.log("in function loadRegister")
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

	console.log("in function createUser")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("user registered");
			loadHome();

		}
	}
	xhr.open("POST", "createUser", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send(userJSON);
}

function loadHome() {
	console.log("in function loadHome")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// window.location.replace(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#login').on('click', login);
			$('#register').on('click', loadRegister);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}

function createReimb() {
	console.log("in function createReimb");
	var a = $('#amount').val();
	var rt = $('#reimbType').val();
	var d = $('#reimbDescription').val();
	// var aid = sessionUser.userID;

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
			console.log("reimburement added");

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
			console.log("logging out");
			loadHome();

		}
	}

}

function resolveReimb() {
	console.log("in function resolveReimb");
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
			console.log("resolving reimbursement");
			var resolution = JSON.parse(xhr.responseText);
			if (resolution === null) {
				$('#resolveMessage').html("Invalid Reimbursement ID");
				console.log("bad RID!");
			} else {
				$('#resolveMessage').html("Reimbursement Resolved");
				console.log("good RID!");
			}
		}
	}
}

function createAuthorTable(){
	console.log("in getAllReimbs function");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getReimbByAuthor", true);
	xhr.send();
    var allReimbs = [];

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// console.log(xhr.responseText);
			var Data = JSON.parse(xhr.responseText);
			console.log(Data.length);
			console.log(Data);
			
			for (di = 0; di < Data.length; ++di){
                allReimbs[di] = [Data[di].submitted, Data[di].amount, Data[di].type, 
					Data[di].description, Data[di].status, Data[di].resolved];

			}
        	console.log(allReimbs);
			for (var tdi = 0; tdi < allReimbs.length; tdi++){
				console.log("for loop" + tdi);
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
	console.log("in getAllReimbs function");
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "managerTable", true);
	xhr.send();
    var allReimbs = [];

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// console.log(xhr.responseText);
			//document.getElementById('getAll').innerHTML = xhr.responseText;
			var Data = JSON.parse(xhr.responseText);
			console.log(Data.length);
			console.log(Data);
			
			for (di = 0; di < Data.length; ++di){
                allReimbs[di] = [Data[di].reimbursementID, Data[di].authorName,  Data[di].submitted, 
                	Data[di].amount, Data[di].type, Data[di].description, Data[di].status, Data[di].resolved];

			}
        	console.log(allReimbs);
			for (var tdi = 0; tdi < allReimbs.length; tdi++){
				console.log("for loop" + tdi);
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

