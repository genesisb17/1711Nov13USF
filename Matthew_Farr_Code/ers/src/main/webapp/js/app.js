window.onload = function(){
	$('#message').hide();
	$('#login').on('click',login);
}

const ROLE_MANAGER = 100;
const ROLE_EMPLOYEE = 200;

function login(){
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
			else if (user.roleId == ROLE_MANAGER) {
				$('#message').html(`Welcome to the Manager Portal, ${user.firstname} ${user.lastname}!`);
				loadManagerApp();
				console.log("success!");
				//loadManagerHome();
			}
			else if (user.roleId == ROLE_EMPLOYEE) {
				$('#message').html(`Welcome to the Employee Portal, ${user.firstname} ${user.lastname}!`);
				loadEmployeeApp();
				console.log("success!");
			}
		}
	};
	
	xhr.open("POST","login", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);
}

// Herp derp
function registerView() {
	
}

function loadEmployeeApp() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		document.getElementById('view').innerHTML = xhr.responseText;
		loadEmpReimbView();
		setEmpOnClicks();
		}
	}	
	xhr.open("GET", "empApp.view" , true);
	xhr.send();
}

function loadEmpReimbView(){
	console.log("in loadEmpReimbView");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;
			loadEmpReimbursements();
		}
	}	
	xhr.open("GET", "empReimb.view" , true);
	xhr.send();
}

function setEmpOnClicks() {
	function click(e) {
	    if (e.target.id === "reimbursements"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#reimbursements').addClass('active');
	    	loadEmpReimbView();
	    }
	    else if (e.target.id === "submit"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#submit').addClass('active');
	    	loadSubmitReimbView();
	    }
	    else if (e.target.id === "logout"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#logout').addClass('active');
	    }
	}
	document.getElementById("reimbursements").addEventListener("click", click, false);
	document.getElementById("submit").addEventListener("click", click, false);
	document.getElementById("profile").addEventListener("click", click, false);
	document.getElementById("logout").addEventListener("click", click, false);
}

function loadEmpReimbursements() {
	console.log("in loadEmpReimbursements");
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var reimbs = JSON.parse(xhr.responseText);
			if(reimbs == null){
				console.log("Invalid reimbursements list object");
			}
			console.log(reimbs);
			loadEmpReimbsTable(reimbs);
		}
	};
	
	xhr.open("GET","reimbursements", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send();
}

function loadEmpReimbsTable(reimbs) {
	console.log("in loadEmpReimbsTable");
	$("#reimb-view").tabulator({
	    layout:"fitColumns", //fit columns to width of table (optional)
	    columns:[
	    	{title:"ID", field:"reimbursementId"},
	    	{title:"Amount", field:"amount"},
	    	{title:"Submitted", field:"submitted"},
	    	{title:"Resolved", field:"resolved"},
	    	{title:"Description", field:"description"},
	    	{title:"Resolver", field:"resolverId"},
	    	{title:"Status", field:"statusId"},
	    	{title:"Type", field:"typeId"}
	    ],
	    rowClick:function(e, row){
	    },
	});
	
	$("#reimb-view").tabulator("setData", reimbs);
}

function loadSubmitReimbView() {
	console.log("in loadSubmitReimbView");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;
			$('#message').hide();
		}
	}	
	xhr.open("GET", "submitReimb.view" , true);
	xhr.send();
}

function submitReimbursement() {
	console.log("in submit reimbursement");
	var amount = parseFloat($('#amount').val());
	var description = $('#description').val();
	//var type = $('#typeId').val();
	var type = $('.form-control option:selected').text();
	var typeId = -1;
	if (type === 'Travel')
		typeId = 100;
	else if (type === 'Lodging')
		typeId = 200;
	else if (type === 'Food')
		typeId = 300;
	else if (type === 'Other')
		typeId = 400;
	
	console.log([amount, description, typeId]);
	
	var submitObject = { "amount":amount, "description":description, "typeId":typeId};
	var submitJSON = JSON.stringify(submitObject)
	console.log(submitJSON);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
		}
	};
	
	xhr.open("POST","submit", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(submitJSON);
}

function loadManagerApp() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//	window.location.replace(xhr.responseText);
		document.getElementById('view').innerHTML = xhr.responseText;
		loadManReimbView();
		setManOnClicks();
		}
	}	
	xhr.open("GET", "manApp.view" , true);
	xhr.send();
}

function setManOnClicks() {
	function click(e) {
	    if (e.target.id === "reimbursements"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#reimbursements').addClass('active');
	    	loadManReimbView();
	    }
	    else if (e.target.id === "update"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#update').addClass('active');
	    	loadUpdateReimbView();
	    }
	    else if (e.target.id === "logout"){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#logout').addClass('active');
	    }
	}
	document.getElementById("reimbursements").addEventListener("click", click, false);
	document.getElementById("update").addEventListener("click", click, false);
	document.getElementById("profile").addEventListener("click", click, false);
	document.getElementById("logout").addEventListener("click", click, false);
}

function loadManReimbView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;
			loadManReimbursements();
		}
	}	
	xhr.open("GET", "manReimb.view" , true);
	xhr.send();
}

function loadManReimbursements() {
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var reimbs = JSON.parse(xhr.responseText);
			if(reimbs == null){
				console.log("Invalid reimbursements list object");
			}
			console.log(reimbs);
			manReimbsTable(reimbs);
		}
	};
	
	xhr.open("GET","reimbursements", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send();
}

//var reimbId = -1;

function manReimbsTable(reimbs) {
	
	$("#reimb-view").tabulator({
	    layout:"fitColumns", //fit columns to width of table (optional)
	    columns:[
	    	{title:"ID", field:"reimbursementId"},
	    	{title:"Amount", field:"amount"},
	    	{title:"Submitted", field:"submitted"},
	    	{title:"Resolved", field:"resolved"},
	    	{title:"Description", field:"description"},
	    	{title:"Author", field:"authorId"},
	    	{title:"Resolver", field:"resolverId"},
	    	{title:"Status", field:"statusId"},
	    	{title:"Type", field:"typeId"}
	    ],
	    rowClick:function(e, row){
	    	$('.navbar-nav a').removeClass('active');
	    	$('#update').addClass('active');
	    	console.log(row.getData());
	    	var reimbId = row.getData().reimbursementId;
	    	loadUpdateReimbView(reimbId);
	    },
	});
	$('#reimb-view').tabulator({index: "reimbursementId"});
	$("#reimb-view").tabulator("setData", reimbs);
}

function loadUpdateReimbView(reimbId) {
	console.log("in loadUpdateReimbView");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;
			if (reimbId > 0)
				$('#reimbursementId').val(reimbId);
			else
				console.log("ReimbId uninitialized");
			$('#message').hide();
		}
	}	
	xhr.open("GET", "updateReimb.view" , true);
	xhr.send();
}

function updateReimbursement() {
	console.log("in updateReimbursement");
	
	var reimbId = parseInt($('#reimbursementId').val());
	var status = $('.form-control option:selected').text();
	
	var statusId = -1;
	if (status === 'Approved')
		statusId = 201;
	else if (status === 'Denied')
		statusId = 301;
	
	var submitObject = {"reimbursementId":reimbId, "statusId":statusId};
	var submitJSON = JSON.stringify(submitObject);
	console.log(submitJSON);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			$('#message').show();
			$('#message').html('Reimbursement successfully update! :)');
		}
	};
	
	xhr.open("POST","update", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(submitJSON);
}

function loadProfileView() {
	console.log("loadProfileView");
}

