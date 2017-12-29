
/**
 * previously app.js
 */

window.onload = function(){
	loginView();
};

function login(){
	var username = $('#username').val();
	var password = $('#pass').val();	
	var toSend = [username, password];
	var json = JSON.stringify(toSend);
	
	console.log(json);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null){
				$('#message').html("Invalid user") ;
			}
			else if(user.id == 0){
				$('#message').html( "Invalid password");
			}
			else{
				$('#message').html("Welcome " + user.fName) ;
				if(user.role == 1)
					loadApp1();
				else
					loadApp2();
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

function loginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//	window.location.replace(xhr.responseText);
		document.getElementById('view').innerHTML = xhr.responseText;
		$('#message').hide();
		$('#login').on('click',login);
		$('#register').on('click', registerView);
		}
	};
	xhr.open("GET", "login.view" , true);
	xhr.send();
}

function registerView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//	window.location.replace(xhr.responseText);
		document.getElementById('view').innerHTML = xhr.responseText;
		$('#message').hide();
		$('#register').on('click', register);
		$('#username').blur(validateEmail);
		$('#register').attr("disabled",true);
		}
	};
	xhr.open("GET", "register.view" , true);
	xhr.send();
}

function loadApp1(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		document.getElementById('view').innerHTML = xhr.responseText;
		loadHome();
		$('#home').on('click',loadHome);
		$('#reimb').on('click',loadReimb);
		$('#profile').on('click', loadProfile);
		$('#logout').on('click', logout);
		}
	};	
	xhr.open("GET", "app1.view" , true);
	xhr.send();
}

function loadApp2(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		document.getElementById('view').innerHTML = xhr.responseText;
		loadHome2();
		$('#home').on('click',loadHome2);
		$('#profile').on('click', loadProfile2);
		$('#logout').on('click', logout);
		loadProfileView();
		}
	};	
	xhr.open("GET", "app2.view" , true);
	xhr.send();
}
//function onblur that notifies the user of whether or not their email address is already in use 
function validateEmail(){
	$('#register').attr("disabled",false);
	$('#message').hide();
	var username = $('#username').val();
	var toSend = [username, ""];
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			console.log("USER: " + user);
			if(user != null){
				$('#message').show();
				$('#message').html("Username Already in use! Please try another") ;
				$('#register').attr("disabled",true);
			}
			else{
				$('#register').attr("disabled",false);
				$('#message').hide();
			}
		}
	};
	
	xhr.open("POST","login", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}

function register(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var uname = $('#username').val();
	var pass = $('#pass').val();
	var role = $('#role').val();
	// add password validation and second input confirmation?

	var user = {
			id: 0,
			fName: fn,
			lName: ln, 
			uName: uname, 
			password: pass,
			role: role
	};
	var userJSON = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","register", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('landing.html');
}

/**
 * main page of the application. thinking about creating a pseudo 
 * 	"admin" role based on a userame and password of admin for demo 
 * 	purposes 
 */
function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadProfileView();
			document.getElementById('appview').innerHTML = xhr.responseText;
			$('#rem').on('click',loadReimb);
			$('#prof').on('click', loadProfile);
			$('#log').on('click', logout);
		}
	};	
	xhr.open("GET", "home.view" , true);
	xhr.send();
}

function loadHome2(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadProfileView();
			document.getElementById('appview').innerHTML = xhr.responseText;
			$('#prof').on('click', loadProfile2);
			$('#log').on('click', logout);
		}
	};	
	xhr.open("GET", "home2.view" , true);
	xhr.send();
}

function loadReimb(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;
			$('#submit').on('click', processReimb);
		}
	};	
	xhr.open("GET", "reimb.view" , true);
	xhr.send();
}

function processReimb(){
	console.log("Processing Reimbursement");
	var amount = $('#amount').val();
	var type = $('#type').val();
	var description = $('#description').val();
	// add password validation and second input confirmation?

	var toSend = [amount, type, description];
	console.log(toSend);
	var reimbJSON = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","reimbursement", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(reimbJSON);
	alert("Success! Reimbursement created");
	loadHome();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "profile.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;//partials/profile.html	
			loadUserTable();
		}
	};
}

function loadProfile2(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "profile2.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;//partials/profile.html	
			loadProfileView();
			loadManagerTable();
		}
	};
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "logout" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loginView();
			console.log("Logged out");
		}
	};
}
function loadUserTable() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getTableInfo" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var tabInfo = JSON.parse(xhr.responseText);
			$("#user_table").tabulator({
			    layout:"fitColumns", //fit columns to width of table (optional)
			    columns:[ //Define Table Columns
			        {title:"R_ID", field:"reimb_id"},
			        {title:"Status", field:"status", align:"left"},
			        {title:"Amount", field:"amount", align:"left"},
			        {title:"Type", field:"type", align:"left"},
			        {title:"Submission Date", field:"date", align:"left"},
			        {title:"Date Resolved", field:"date2", align:"left"},
			        {title:"Description", field:"descr", align:"left", formatter:"textarea"},
			    ],
			});
			
			var tabledata = [];
			for(var i = 0; i < tabInfo.length; i++) {
				var resolveDate;
				if(tabInfo[i].date2 == null)
					resolveDate = "N/A"
				else
					resolveDate = tabInfo[i].date2.substring(0, 10);
				
				var tableRow = {
						id:(i + 1),
						reimb_id: tabInfo[i].reimb_id,
						status: tabInfo[i].status,
						amount: tabInfo[i].amount.toFixed(2),
						type: tabInfo[i].type,
						date: tabInfo[i].date.substring(0, 10),
						date2: resolveDate,
						descr: tabInfo[i].description
				};
				tabledata.push(tableRow);
			}
			$("#user_table").tabulator("setData", tabledata);
		}
	};
}
function loadManagerTable() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getTableInfo" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var tabInfo = JSON.parse(xhr.responseText);
			var statusEditor = function(cell, onRendered, success, cancel, editorParams){
			    //cell - the cell component for the editable cell
			    //onRendered - function to call when the editor has been rendered
			    //success - function to call to pass the succesfully updated value to Tabulator
			    //cancel - function to call to abort the edit and return to a normal cell
			    //editorParams - editorParams object set in column defintion

			    //create and style editor
			    var editor = $("<select><option value='Pending'>Pending</option><option value='Approved'>Approved</option><option value='Denied'>Denied</option></select>");
			    editor.css({
			        "padding":"3px",
			        "width":"100%",
			        "box-sizing":"border-box",
			    });

			    //Set value of editor to the current value of the cell
			    editor.val(cell.getValue());

			    //set focus on the select box when the editor is selected (timeout allows for editor to be added to DOM)
			    onRendered(function(){
			      editor.focus();
			    });

			    //when the value has been set, trigger the cell to update
			    editor.on("change blur", function(e){
			        success(editor.val());
			       
			    });

			    //return the editor element
			    return editor;
			};
			$("#manager_table").tabulator({
			     // set height of table, this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
			    layout:"fitColumns", //fit columns to width of table (optional)
			    columns:[ //Define Table Columns
			        {title:"R_ID", field:"reimb_id"},
			        {title:"Status", field:"status", align:"left", editor: statusEditor},
			        {title:"Amount", field:"amount", align:"left"},
			        {title:"Type", field:"type", align:"left"},
			        {title:"Submission Date", field:"date", align:"left"},
			        {title:"Date Resolved", field:"date2", align:"left"},
			        {title:"Description", field:"descr", align:"left", formatter:"textarea"},
			        {title:"First Name", field:"fname", align:"left"},
			        {title:"Last Name", field:"lname", align:"left"},
			    ],
			    cellEdited:function(cell){
			    	var rowData = cell.getRow().getData();
				    updateStatus(rowData);
				    setTimeout(loadManagerTable, 250);
			    }
			});
			
			var tabledata = [];
			for(var i = 0; i < tabInfo.length; i++) {
				var resolveDate;
				if(tabInfo[i].date2 == null)
					resolveDate = "N/A"
				else
					resolveDate = tabInfo[i].date2.substring(0, 10);
				
				var tableRow = {
						id:(i + 1),
						reimb_id: tabInfo[i].reimb_id,
						status: tabInfo[i].status,
						amount: tabInfo[i].amount.toFixed(2),
						type: tabInfo[i].type,
						date: tabInfo[i].date.substring(0, 10),
						date2: resolveDate,
						descr: tabInfo[i].description,
						fname: tabInfo[i].fName,
						lname: tabInfo[i].lName
				}
				tabledata.push(tableRow);
			}
			$("#manager_table").tabulator("setData", tabledata);
		}
	};
}


function updateStatus(rowData) {
	var values = [rowData.reimb_id, rowData.status, 0];
	var toSend = JSON.stringify(values);
	var xhr = new XMLHttpRequest();
	console.log(rowData);
	xhr.open("PUT", "updateStatus" , true);
	xhr.send(toSend);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("Updated reimbursement: " + rowData.reimb_id)
		}
	};
}
function loadProfileView(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","getUserInfo", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			var sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.fName);
		}
	};
}