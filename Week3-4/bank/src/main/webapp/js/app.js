var logged = false;
window.onload = function(){

	loadHomeView();

	if(logged == false){
		$("#navbar").hide();
	}
	else{
		$("#navbar").show();};

		document.getElementById("homePage")
		.addEventListener("click", loadDashboardView);

		document.getElementById("accPage")
		.addEventListener("click", loadAccountPageView);


};

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;		
			document.getElementById("login")
			.addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};


function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	var tx = [email, pass];
	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;

			if (response == "fail"){
				document.getElementById("message")
				.innerHTML = "Invalid credentials. Please try again";
			}
			else if(response == "pass"){
				document.getElementById("message")
				.innerHTML = "Invalid user. Please try again";
			}
			else{
				logged = true;
				console.log(response);
				loadDashboardView();
				$("#navbar").show();
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type",
	"application/x-www-form-urlencoded");
	xhr.send(tx);
};


function loadDashboardView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getUserPageInfo(); // loads user info by calling function

		}
	}
	console.log("getting dash");
	xhr.open("GET", "getDashboard", true);
	xhr.send();
};


/*
 * look into window.location.href = <html page>
 */
//function ajaxGetPage(){
//return $.ajax({
//url: 'getAccPage',
//data: {
//format: 'html'
//},
//type: 'GET',
//success: function(result){
//console.log("inside ajax GET");
//$('#view').html(result);
//getAcctPageInto(); }
//})

//};
//https://stackoverflow.com/questions/8840257/jquery-ajax-handling-continue-responses-success-vs-done

function loadAccountPageView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getAcctPageInfo(); // loads user info by calling function
			listenforEdits();
		}
	}
	console.log("getting accts")
	xhr.open("GET", "getAccPage", true);
	xhr.send();
}

function listenforEdits(){
	
	var rows = document.getElementsByTagName('tr');
	for (var row in rows) {
			row.onclick = function(){
				alert("hi");
			}
	  }; 
	  // or attachEvent, depends on browser
	}





function getAcctPageInfo(){ // loads basic user info and account info into html
	$("#accountForm").hide();
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			var accounts = dto.accounts;

			document.getElementById("name").innerHTML = user.firstname;
			if (accounts.length == 0){
				document.getElementById("accounts").style.visibility = "hidden"; 
			}
			else{

				for(var i = 0; i < accounts.length; i++){
					// populate accounts table
					var table = document.getElementById("accTable");
					var row = table.insertRow();
					var acc = row.insertCell(0);
					var type = row.insertCell(1);
					var bal = row.insertCell(2);
					var id = accounts[i].id
					acc.innerHTML = "Account No. " + id;
					type.innerHTML = accounts[i].type;
					bal.innerHTML = "$" + accounts[i].balance;	
					row.setAttribute("class", "userAccount");
					row.setAttribute("id", id);
				}
			}
		}
		
		$(".userAccount").on('click', function(){
			alert($(this).attr("id"));
		});
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
	console.log("in account page info after XHR send");
	$("#makeAccount").click(function(){showAddAccountView();});

};

function showAddAccountView(){
	$("#accountForm").show();
	$("#accounts").hide();
	$("#submitAccount").click(function(){addAccount();});

};


function addAccount(){ // allows us to acc new accounts 

	var accType = $('input[name="accType"]:checked').val();
	accType = JSON.stringify(accType);
	console.log(accType);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			loadAccountPageView()
		}
	}

	xhr.open("POST", "addAccount", true);
	xhr.setRequestHeader("Content-type",
	"application/x-www-form-urlencoded");
	//set the header to tell the server you have data for it to process
	xhr.send(accType); //include your post data in the send()

}; 


function getUserPageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var user = dto.user;
			document.getElementById('name')
			.innerHTML = user.firstname + " " + user.lastname;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};




//function createUser(){

////load pageview
//validatePass();
//$("#submitNewUser").onclick(){
////validate emai
//}

//};

function validatePass(){
	$('input[type=password]').keyup(function() {
		var pswd = $(this).val();

		//validate the length
		if ( pswd.length < 8 ) {
			$('#length').removeClass('valid').addClass('invalid');
		} else {
			$('#length').removeClass('invalid').addClass('valid');
		}

		//validate letter
		if ( pswd.match(/[A-z]/) ) {
			$('#letter').removeClass('invalid').addClass('valid');
		} else {
			$('#letter').removeClass('valid').addClass('invalid');
		}

		//validate capital letter
		if ( pswd.match(/[A-Z]/) ) {
			$('#capital').removeClass('invalid').addClass('valid');
		} else {
			$('#capital').removeClass('valid').addClass('invalid');
		}

		//validate number
		if ( pswd.match(/\d/) ) {
			$('#number').removeClass('invalid').addClass('valid');
		} else {
			$('#number').removeClass('valid').addClass('invalid');
		}

		//validate space
		if ( pswd.match(/[^a-zA-Z0-9\-\/]/) ) {
			$('#space').removeClass('invalid').addClass('valid');
		} else {
			$('#space').removeClass('valid').addClass('invalid');
		}

	}).focus(function() {
		$('#pswd_info').show();
	}).blur(function() {
		$('#pswd_info').hide();
	});

};


