/**
 * 
 */
window.onload = function(){
	showSR();
	loadLoginView();
//	$('#message').hide();
//	$('#log').on('click', login);
//	$("#example-table").tabulator("setData", tabledata);
	$('#logout').on('click', logout);
	hideNav();
}
function showSR() {
	$('#signin').show();
	$('#register').show();
	
}
function loadLoginView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOGIN " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			$('#message').hide();
			$('#username').on('input',function(e){
				$('#message').hide();
			});
			$('#pass').on('input',function(e){
				$('#message').hide();
			});
			$('#login').on('click', login);
			$('#register').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}
function login(){
	//alert("logging in");
	var username = $('#username').val();
	var password = $('#pass').val();
	
	var toSend = [username, password];

	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null){
				$('#message').html("Invalid user") ;
			}
			else if(user.userId == 0){
				$('#message').html( "Invalid password");
			}
			else{
//				$('#message').html(`Welcome ${user.firstName}`) ;
//				console.log("success!");
				if(user.userRoleId == 1){
					console.log("You are an employee " + user.userRoleId)

					loadEHome();
					showEmployeeNav();
				}
				else{
					console.log("You are a manager " + user.userRoleId)

					loadMHome();
					showManagerNav();

				}
			}
		}
	};
	
	xhr.open("POST","LoginServlet", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);
}


function hideNav(){
	$('#mhome').hide();
	$('#ehome').hide();
	$('#mprofile').hide();

	$('#enewreq').hide();
	$('#logout').hide()
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOGOUT" + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			hideNav();
			loadLoginView();
			alert("Logging out!");
		}
	}
	xhr.open("GET", "LogoutServlet", true);
	xhr.send();
}

//create Tabulator on DOM element with id "example-table"
//e
//	
//	
//});

//$("#example-table").tabulator({
//    height:400,
//    layout:"fitColumns",
//    columns:[
//        {title:"Name", field:"name", width:150},
//        {title:"Age", field:"age", align:"left", formatter:"progress", formatterParams:{color: "#FFDF00"}},
//        {title:"Favourite Color", field:"col"},
//        {title:"Date Of Birth", field:"dob", sorter:"date", align:"center"},
//    ],
//    rowClick:function(e, row){
//        alert("Row " + row.getData().id + " Clicked!!!!");
//    },
//});
//
//var tabledata = [
//    {id:1, name:"Oli Bob", age:"12", col:"red", dob:""},
//    {id:2, name:"Mary May", age:"1", col:"blue", dob:"14/05/1982"},
//    {id:3, name:"Christine Lobowski", age:"42", col:"green", dob:"22/05/1982"},
//    {id:4, name:"Brendon Philips", age:"125", col:"orange", dob:"01/08/1980"},
//    {id:5, name:"Margret Marmajuke", age:"16", col:"yellow", dob:"31/01/1999"},
//];

function loadEHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("EMPLOYEE HOME " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			
				empReimbursementTable();
		}
	}
	xhr.open("GET", "employeeHome.view", true);
	xhr.send();
}

function loadRegisterView(){	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADREGISTERVIEW " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;

			$('#emessage').hide();
			$('#emptymessage').hide();
			$('#registerRegister').on('click', register);
			$('#email').blur(checkEmail);

		}
	}
	xhr.open("GET", "register.view", true);
	xhr.send();
}

//function newReimb(){	
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		console.log("LOADREGISTERVIEW " + xhr.readyState);
//		if(xhr.readyState == 4 && xhr.status == 200){
//			document.getElementById('view').innerHTML = xhr.responseText;
//
////			$('#emessage').hide();
////			$('#emptymessage').hide();
//			$('#createRequest').on('click', createReq);
////			$('#email').blur(checkEmail);
//
//		}
//	}
//	xhr.open("GET", "empNewRequest.view", true);
//	xhr.send();
//}
function createReq(){
	console.log("IN REGISTER");
	var amt = $('#reqAmount').val();
	var desc = $('#desc').val();
	var typeR = 1;
	if ($('#typeR').is(":checked")){
		typeR = 2;
	}
	var user = {
			reimbId : 0,
			reimbAmount : amt,
			reimbResolved : "",
			reimbDescription : desc,
			reimbAuthor : 0,
			reimbReceipt : null,
			reimbResolver : 0,
			reimbStatId : 0,
			reimbTypeId : typeR,
			reimbSubmitted : ""
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("in register xhr " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				alert("Error");
			}
			else{
				$('#message').hide();
				alert("Success");
//				loadLoginView();
			}
		}
	};

	xhr.open("POST","MakeReimb", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
}


function loadMHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	console.log("MANAGER HOME " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;
			mgrReimbursementTable();
		}
	}
	xhr.open("GET", "managerHome.view", true);
	xhr.send();
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
				$('#emessage').html(`'${email}' is a duplicate. Try again.`);
				$('#emessage').show();
			}
			else {
				$('#emessage').hide();
				}
		}
	};
	
	xhr.open("POST","ValEmailServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

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

function showManagerNav(){	
	$('#mhome').show();
	$('#mprofile').show();
	$('#signin').hide();
	$('#register').hide();
	$('#logout').show();
	$('#mhome').on('click', loadMHome);
	$('#mprofile').on('click', loadResolver);
}


function loadResolver(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
//			console.log("reso " + xhr.readyState);
			if(xhr.readyState == 4 && xhr.status == 200){
				document.getElementById('view').innerHTML = xhr.responseText;
				
				$('#resolveRequest').on('click', resolverF);
				console.log("createRequest clicked");
			}
		}
		xhr.open("GET", "manResRequest.view", true);
		xhr.send();
}


function resolverF() {
	console.log("IN resolver");
	var reimbId = $('#reimId').val();
	var final = 1;
	if ($('#reso').is(":checked")){
		final = 2;
	}
	var user = {
			reimbId : 0,
			reimbAmount : reimbId,
			reimbResolved : "",
			reimbDescription : "",
			reimbAuthor : 0,
			reimbReceipt : null,
			reimbResolver : 0,
			reimbStatId : final,
			reimbTypeId : 0,
			reimbSubmitted : ""
	};
	
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("in register xhr " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				alert("Error");
			}
			else{
				$('#message').hide();
				alert("Success");
//				loadLoginView();
			}
		}
	};

	xhr.open("POST","ResoReimb", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);

}

function showEmployeeNav(){
	console.log("in showempnav");
	$('#ehome').show();
	$('#eprofile').show();
	$('#enewreq').show();
	$('#signin').hide();
	$('#register').hide();
	$('#logout').show();
	$('#ehome').on('click', loadEHome);
	$('#enewreq').on('click', loadNewRequest);
}

function register(){
	console.log(checkFilled());
	if (checkFilled() == false) {
		$('#emptymessage').show();
	}
	else {
		$('#emptymessage').hide();
		var usern = $('#username').val();
		var pass = $('#pass').val();
		var fn = $('#fn').val();
		var ln = $('#ln').val();
		var em = $('#email').val();
		var role = 1;
		if ($('#role').is(":checked")){
			role = 2;
		}
		var user = {
				userName: usern,
				password: pass,
				firstName: fn,
				lastName: ln, 
				email: em,
				userRoleId: role
		};
		
		var userJSON = JSON.stringify(user);
		
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			console.log("in register xhr " + xhr.readyState);
			if(xhr.readyState == 4 && xhr.status==200){
				var user = JSON.parse(xhr.responseText);
				if(user == null){
					alert("Error");
				}
				else{
					$('#message').hide();
					alert("Success");
					loadLoginView();
				}
			}
		};
	
		xhr.open("POST","RegisterServlet", true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send(userJSON);
	}
}

function mgrReimbursementTable() {
	console.log("in empreimbursement");
//	xhr.onreadystatechange = function(){
//		console.log("LOADEMPREIMBS " + xhr.readyState);
//		if(xhr.readyState == 4 && xhr.status == 200){
	$("#example-table").tabulator({
        height: 300,
        persistentLayout: true,
        index: "reimbId",
        layout: 'fitColumns',
        persistentLayoutID: "empReims",
        columns: [
            { title: "Reimb Id:", field: "reimbId" },
            { title: "Amount:", field: "reimbAmount", formatter: "money" },
            { title: "Submitted:", field: "reimbSubmitted", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved:", field: "reimbResolved", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Status:", field: "rStat" },
            { title: "Type:", field: "rType" },
            { title: "Description:", field: "reimbDescription" },
            { title: "Author:", field: "author" },
            { title: "Resolver:", field: "resolver" }
        ],
    });

	$("#example-table").tabulator("setData", "/ers_project/MgrReimbsServlet");
	$("#example-table").tabulator("clearSort");
//    $("#example-table").tabulator("setFilter", "rStat", "=", "Pending");
    $("#example-table").tabulator("setSort", "submitted", "desc");
	
}
function empReimbursementTable() {
//	var xhr = new XMLHttpRequest();
	console.log("in empreimbursement");
//	xhr.onreadystatechange = function(){
//		console.log("LOADEMPREIMBS " + xhr.readyState);
//		if(xhr.readyState == 4 && xhr.status == 200){
	$("#example-table").tabulator({
        height: 300,
        persistentLayout: true,
        index: "reimbId",
        layout: 'fitColumns',
        persistentLayoutID: "empReims",
        columns: [
            { title: "Reimb Id:", field: "reimbId" },
            { title: "Amount:", field: "reimbAmount", formatter: "money" },
            { title: "Submitted:", field: "reimbSubmitted", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Resolved:", field: "reimbResolved", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
            { title: "Status:", field: "rStat" },
            { title: "Type:", field: "rType" },
            { title: "Description:", field: "reimbDescription" },
            { title: "Author:", field: "author" },
            { title: "Resolver:", field: "resolver" }
        ],
    });

	$("#example-table").tabulator("setData", "/ers_project/EmpReimbsServlet");
	$("#example-table").tabulator("clearSort");
//    $("#example-table").tabulator("setFilter", "rStat", "=", "Pending");
    $("#example-table").tabulator("setSort", "submitted", "desc");

//	}
//		xhr.open("GET", "EmpReimbsServlet", true);
//		xhr.send();	
//	}
}

function loadNewRequest(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log("LOADNEWREQUEST " + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;

			$('#createRequest').on('click', createReq);
			console.log(" clicked");
		}
	}
	xhr.open("GET", "empNewRequest.view", true);
	xhr.send();
}
//function sendRequest() {
//	var amountInput = $('#reqAmount').val();
//	console.log($('#reqAmount').val());
//	var type = $('#typeR').val();
//	console.log($('#typeR').val());
//	var desc = $('#reqDescription').val();	
//	console.log($('#reqDescription').val());
//    	$('#errmessage').show();
//		var reimbursement = {
//				id : 0,
//				amount : amountInput,
//				submitted : "",
//				resolved : "",
//				description : desc,
//				receipt : null,
//				author : 0,
//				resolver : 0,
//				status : 0,
//				type : type,
//				authorStr : "",
//				resolverStr : "",
//				statusStr : "",
//				typeStr : ""
//		};
//		
//		var reimbJSON = JSON.stringify(reimbursement);
//		
//		var xhr = new XMLHttpRequest();
//		xhr.onreadystatechange = function(){
//			console.log("ATTEMPTINGNEWREQUEST " + xhr.readyState);
//			if(xhr.readyState == 4 && xhr.status==200){
//				var reimbursement = JSON.parse(xhr.responseText);
//				if(reimbursement == null){
//					alert("Error creating request");
//				}
//				else{
//					alert("Success! New reimbursement request has been added!");
//					loadEmployeeHome();
//				}
//			}
//		};
//	
//		xhr.open("POST","newReimbursement", true);
//		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//		xhr.send(reimbJSON);
//
//}