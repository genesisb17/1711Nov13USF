/**
 * 
 */
var store = [];
window.onload = function(){
	//loadHome();
	//$('#home').on('click',loadHome);
	$('#profile').on('click', getProfilePage);
	$('#logout').on('click', logout);
	//$('#request').on('click', request);
	//---------------------------------------------
	//$('#2').on('click', updateApprove);
	console.log("below #2");
	//$('#3').on('click', updateDeny);
	//---------------------------------------------
	
}
console.log("after window on loads");


// load the data into the table when the document is ready, 
// note that appendData cannot be called with just $('#data').appendData();
//$(document).ready(appendData);

$(document).ready(function(){
	appendData();
	//$('#2').on('click', updateApprove);
	
});


function updateApprove(){
	var status = $('#2').attr('id');
	console.log("inside update approve");
	console.log(status);
	var toSend = {
		reimb_id: 0,
		status_id: status,
		resolver: 0	
	}
	console.log(toSend);
	var json = JSON.stringify(toSend);
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			console.log(xhr.responseText);
		}
	}
	xhr.open("POST","updateservlet", true);
	xhr.send(json);
}

function getProfilePage(){
	var xhr = new XMLHttpRequest();
	console.log("here");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
		
			location.assign("profile.html");
			//document.write(user.firstname);
			//document.write(user.lastname);
//			$('#firstname').append(user.firstname);
//			$('#lastname').append(user.lastname);
		}
		$('#firstname').append(user.firstname);
		$('#lastname').append(user.lastname);
		
	}
	xhr.open("GET", "getUserInfo", true)
	xhr.send();
}

function logout() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			window.location.replace("index.html");
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();

}

function status(x) {
	switch(x) {
	case 1:
		return "Pending";
	case 2:
		return "Approved";
	case 3:
		return "Denied";	
	}
}
function type(x) {
	switch(x){
	case 1:
		return "Travel";
	case 2:
		return "Lodging";
	case 3:
		return "Food";
	case 4: 
		return "Other";
	}
}

function description(x){
	if(x === null) {
		return "-";
	} else{
		return x;
	}
}

function resolve(x) {
//	switch(x){
//	case null:
//		//return "Pending";
//		console.log("it is null");
//		return "hi";
//	}
	if(x === 0) {
		return "Pending";
	} else{
		return x;
	}
}

function timeResolve(x){
	if(x === null) {
		return "<button id=\"2\" type\"button\" class=\"btn btn-success\">approve</button>" +
				" <button id=\"3\" type=\"button\" class=\"btn btn-danger\">deny</button>";
	}else{
		return x;
	}
}




function appendData(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = JSON.parse(xhr.responseText);
			
			// use store array of data in array for formatting the table
			for(var i = 0; i < data.length; i++){
				var dataset = new Array();
				dataset.push(data[i].reimb_id);
				dataset.push("$" + String(data[i].amount));
				dataset.push(String(data[i].submitted));
				dataset.push(String(timeResolve(data[i].resolved)));
				dataset.push(String(description(data[i].description)));
				dataset.push(String(data[i].author));
				dataset.push(String(resolve(data[i].resolver)));
				dataset.push(String(status(data[i].status_id)));
				dataset.push(String(type(data[i].type_id)));
				store.push(dataset);
			}
			
			$(document).ready(function(){
			    $('#example').DataTable( {
			    	data: store,
			    	columns: [
			    		{title: "Id"},
			    		{title: "amount" },
			    		{title: "submitted" },
			    		{title: "resolved" },
			    		{title: "description" },
			    		{title: "author" },
			    		{title: "resolver" },
			    		{title: "status" },
			    		{title: "type" }
			    	]
			    });
			    $("#2").onclick = updateApprove;
			});
			
//			for(var i = 0; i < data.length; i++){
//				$('#data').append("<tr>");
//				
//				$('#data').append("<td> $" + data[i].amount + "</td>");
//				$('#data').append("<td>" + data[i].submitted + "</td>");
//				$('#data').append("<td>" + data[i].resolved + "</td>");
//				$('#data').append("<td>" + data[i].description + "</td>");
//				$('#data').append("<td>" + data[i].author + "</td>");
//				$('#data').append("<td>" + data[i].resolver + "</td>");
//				$('#data').append("<td>" + data[i].status_id + "</td>");
//				$('#data').append("<td>" + data[i].type_id + "</td>");
//				$('#data').append("</tr>");
//			}		
		}
	}	
	xhr.open("POST", "datatable", true);
	xhr.send();
}

//
//function loadHome(){
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			document.getElementById('view').innerHTML = xhr.responseText;				
//		}
//	}	
//	xhr.open("GET", "getHomeView" , true);
//	xhr.send();
//}
//
//function loadProfile(){
//	var xhr = new XMLHttpRequest();
//	xhr.open("GET", "getProfileView" , true);
//	xhr.send();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			//partials/profile.html
//			document.getElementById('view').innerHTML = xhr.responseText;	
//			loadProfileInfo();
//		}
//	}
//}
//
//
//function loadProfileInfo(){
//	var xhr = new XMLHttpRequest();
//	
//	xhr.open("GET","getUserInfo", true);
//	xhr.send();
//	
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			console.log(xhr.responseText);
//			var sessionUser = JSON.parse(xhr.responseText);
//			$("#name").html(sessionUser.firstname);
//		}
//	}
//}




