/**
 * Implementation for the landing page
 **/

window.onload = function(){
	loadMain();

}

$(document).on('click','#login',login);
$(document).on('click','#register', registerView);
$(document).on('click','#sub-logout', logout);
$(document).on('click','#sub-new', subnew);
$(document).on('blur','#fn', validate(3,true));
$(document).on('blur','#ln', validate(3,true));
$(document).on('blur','#pw', validate(3,true));
var user = {
	user_id : 0,
	username : null,
	firstname : null,
	lastname : null,
	email : null,
	role : null,
	password : null,
}

/*
 * Handles login functionality
 * loads LoginServlet @/login
 */

function loadMain(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","MainServlet",true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if (xhr.responseText == "login"){
				loadLogin();
			}
			else if(xhr.responseText == "app"){
				getUser();

			}
		}
	}	
}

function getUser(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "GetUserServlet", true)
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			loadApp();
			loadHome();
			loadTickets();
		}
	}
}

function loadLogin(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","login.view",true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			$('#global_view').html(xhr.responseText);
			$('#appview').html("");
			$('#message').hide();
		}
	}
}	


function login(){
//	alert("logging in");
	var username = $('#username').val();
	var password = $('#pass').val();
	
	var toSend = [username, password, "user"];
	
	var json = JSON.stringify(toSend);
	console.log("in login after stringify " + json);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("in xhr callback" + xhr.responseText);
			user = JSON.parse(xhr.responseText);
			$('#message').show();
			if(user == null){
				$('#message').html("Invalid user") ;
			}
			else if(user.user_id == 0){
				$('#message').html("Invalid password");
			}
			else{
				$('#message').html(`Welcome ${user.firstname}`) ;
				loadApp();
				console.log("success! - in login - between loadapp and load home");
				loadHome();
				loadTickets();
				
			}
		}
	};
	
	xhr.open("POST","LoginServlet", true);
	//console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);
	

}

function loadApp(){
	console.log("in load app -start")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//	window.location.replace(xhr.responseText);
		console.log("-in loadApp/readystate 4")
		document.getElementById('global_view').innerHTML = xhr.responseText;
		console.log("in loadapp after global view replacement")
		//$('#home').on('click',loadHome);
		//$('#profile').on('click', loadProfile);
					  if (typeof(element) != 'undefined')
			  { 
			     console.log("DNDNE");
			     console.log(user);
			  }
		document.getElementById("nav-title").innerHTML =(`${user.firstname} ${user.lastname}'s Reimbursment Page `);
		}
	}	
	xhr.open("GET", "app.view" , true);
	xhr.send();
}

function loadHome(){
	console.log("in loadHome - start")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#appview').html(xhr.responseText);
			
			  	
		}
	}	
	xhr.open("GET", "home.view" , true);
	xhr.send();
}

function logout(){
	console.log("in logout - start")
	$('#logmodal').modal('hide');
	$('body').removeClass('modal-open');
	$('.modal-backdrop').remove();
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user.user_id = 0;
			user.username = null;		
			user.firstname = null;
			user.lastname = null;
			user.email = null;
			user.role = null,				
			loadMain();
		}
	}	
	xhr.open("GET", "logout" , true);
	xhr.send();
}

function loadTickets(){
	console.log("load Tix start");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var jsonTix = JSON.parse(xhr.responseText);

				if (user.role == 1){
					$("#reimb_table").tabulator({
					    height:500, // set height of table, this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
					    layout:"fitColumns", //fit columns to width of table (optional)
					    data:jsonTix,
					    columns: [
					    	{ title: "Author:", field: "sub_name" },
				            { title: "Status:", field: "status" },
				            { title: "Type:", field: "type" },
				            { title: "Amount:", field: "amount", formatter: "money" },
				            { title: "Description:", field: "description" },
				            { title: "Submitted:", field: "submittedD", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
				            { title: "Resolved:", field: "resolvedD", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
				            { title: "Resolved by:", field: "resolver" }
				        ],
					    rowClick:function(e, row){ //trigger an alert message when the row is clicked
					        
					    	if(row.getData().status == "Pending"){
					    		console.log(row.getData());
					    		let id = row.getData().reimb_id;
					    		console.log(id);
					        	$('#resmodal').modal('show');
					        	$("#approve").on('click',{rowid: id, stat: 1}, resolve);
					        	$("#deny").on('click', {rowid: id, stat: 2}, resolve);
					        }
					    },
					});
				}
				else {
					$("#reimb_table").tabulator({
					    height:500, // set height of table, this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
					    layout:"fitColumns", //fit columns to width of table (optional)
					    data:jsonTix,
					    columns: [
					    	{ title: "Author:", field: "sub_name" },
				            { title: "Status:", field: "status" },
				            { title: "Type:", field: "type" },
				            { title: "Amount:", field: "amount", formatter: "money" },
				            { title: "Description:", field: "description" },
				            { title: "Submitted:", field: "submittedD", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
				            { title: "Resolved:", field: "resolvedD", sorter: "date", sorterParams: { format: "MM-DD-YY" } },
				            { title: "Resolved by:", field: "resolver" }
				        ],
					});
				}
				
				//$('#reimb-table').tabulator("setData", jsonTix);
			

			
			  	
		}
	}	
	xhr.open("GET", "GetTickets" , true);
	xhr.send();

}


function subnew(){
//	alert("logging in");
	var funds = $('#new-amount').val();
	var description = $('#description').val();
	var typevalue = $("input[name='type']:checked").val();
	var type;
	if (typevalue == "L"){type = 0;}
	else if (typevalue == "T"){type = 1;}
	else if (typevalue == "F"){type = 2;}
	else if (typevalue == "O"){type = 3;}


	var toSend = [funds, description, type];
	
	var json = JSON.stringify(toSend);
	console.log("in login after stringify " + json);
	
	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){        	
		$('#ticketmod').modal('hide');
    	$('body').removeClass('modal-open');
    	$('.modal-backdrop').remove();
    	$('#reimb_table').html("");
    	$('#global_view').html("");
		$('#appview').html("");
		getUser();
		}
	};
	
	xhr.open("POST","AddTicket", true);
	//console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);
	

}

function resolve(event) {
	let i = event.data.rowid;
	let s = event.data.stat;
    var data = [i, s];
    console.log(data);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	$('#resmodal').modal('hide');
        	$('body').removeClass('modal-open');
        	$('.modal-backdrop').remove();
        	$('#reimb_table').html("");
        	$('#global_view').html("");
			$('#appview').html("");
			getUser();
        }
    }
    xhr.open("POST", "ResolveTicket", true);
    xhr.send(JSON.stringify(data));
}


function registerView(){
	console.log("in register view")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
		//window.location.replace(xhr.responseText);
		document.getElementById('global_view').innerHTML = xhr.responseText;
		//to be implemented
		$('#un_message').hide();
		$('#em_message').hide();
		$('#un').blur(validateUser);
		$('#em').blur(validateEmail);
		$('#fn').blur(validate(3, true));
		$('#ln').blur(validate(3, true));
		$('#pw').blur(validate(3, true));
		$('#create_user').attr("disabled",true);
		$('#create_user').on('click',register);
		}
	}	
	xhr.open("GET", "register.view" , true);
	xhr.send();
}

function register(){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var uname = $('#un').val();
	var em = $('#em').val();
	var pass = $('#pw').val();
	var role = ($('#manager-box').is(':checked') ? 1 : 0) 
	// add password validation and second input confirmation?

	var v_user = {
			user_id: 0,
			firstname: fn,
			lastname: ln, 
			username: uname, 
			password: pass,
			email: em,
			role: role
	};
	
	var userJSON = JSON.stringify(v_user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("added user");
		}
	};
	
	xhr.open("POST","RegistrationServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(userJSON);
	$('#em_message').hide();
	$('#un_message').hide();
	alert("Success! Please login using your credentials");
	window.location.replace('landing.html');
}

//function onblur that notifies the user of whether or not their 
//email address is already in use 
function validateUser(){
	$('#register').attr("disabled",false);
	$('#un_message').hide();
	var username = $('#un').val();
	
	var toSend = [username, "", "user"];

	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			user = JSON.parse(xhr.responseText);
			console.log("USER: " + user);
			validate();
			if(user != null){
				
				validate(1,false);
				//$('#create_user').attr("disabled",true);
			}
			else{
				//$('#create_user').attr("disabled",false);
				validate(1,true);
				
			}
		}
	};
	xhr.open("POST","LoginServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}



function validateEmail(){
	$('#create_user').attr("disabled",false);
	$('#em_message').hide();
	var email = $('#em').val();
	
	var toSend = [email, "", "email"];

	var json = JSON.stringify(toSend);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			user = JSON.parse(xhr.responseText);
			console.log("USER: " + user);
			if(user != null){
				
				validate(2,false);
				//$('#create_user').attr("disabled",true);
			}
			else{
				validate(2,true)
				//$('#create_user').attr("disabled",false);
				
				
			}
		}
	};
	xhr.open("POST","LoginServlet", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
}


var validf = false;
var validl = false;
var validp = false;
var validu = false;
var valide = false;
function validate(form, valid){
	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var uname = $('#un').val();
	var em = $('#em').val();
	var pass = $('#pw').val();
	if (form == 1){
		if (valid && uname){
			validu = true;
			$('#un_message').hide();
		}
		else{
			validu = false;
			$('#un_message').show();
			$('#un_message').html("Invalid Username! Please try another") ;
		}
	}
	else if (form == 2){
		if (valid && em){
			valide = true;
			$('#em_message').hide();
		}
		else{
			valide = false;
			$('#em_message').show();
			$('#em_message').html("Invalid Email! Please try another") ;
		}
	}
	if (fn){
		validf = true;
	}
	else{
		validf = false;
	}
	if (ln){
		validl = true;
	}
	else{
		validl = false;
	}
	if (pass){
		validp = true;
	}
	else{
		validp = false;
	}
	console.log(validf);
	console.log(validl);
	console.log(validu);
	console.log(validp);
	console.log(valide);
	if(validf && validl && validu && validp && valide){
		$('#create_user').attr("disabled",false);
	}
	else{
		$('#create_user').attr("disabled",true);
	}

}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "profile.view" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('appview').innerHTML = xhr.responseText;//partials/profile.html	
			loadProfileView();
			
			console.log("TESTING IF WE ARE GETTING THE USER" + test);
		
		}
	}
}

function loadProfileView(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET","getUserInfo", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var sessionUser = JSON.parse(xhr.responseText);
			$("#name").html(sessionUser.firstname);
		}
	}
}