/**
 * 
 */



window.onload = function(){
	$(document).ready(appendData);
	$("#logout").click(logout);
	$("#home").click(submitrequestPage);
	$("#profile").click(profilePage);
}

function submitrequestPage(){
	window.location.replace("submitrequest.html");
}

function profilePage(){
	window.location.replace("profile.html")
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
	if(x === null) {
		return "Pending";
	} else{
		return x;
	}
}

function appendData(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var data = JSON.parse(xhr.responseText);
			var store = [];
			// use store array of data in array for formatting the table
			for(var i = 0; i < data.length; i++){
				var dataset = new Array();
				dataset.push(data[i].reimb_id);
				dataset.push("$" + String(data[i].amount));
				dataset.push(data[i].first_name);
				dataset.push(data[i].last_name);
				dataset.push(String(description(data[i].description)));
				dataset.push(String(status(data[i].status_id)));
				dataset.push(String(type(data[i].type_id)));
				dataset.push(String(data[i].submitted));
				dataset.push(String(resolve(data[i].resolved)));
				store.push(dataset);
			}
			
			$(document).ready(function(){
			    $('#example').DataTable( {
			    	data: store,
			    	columns: [
			    		{title: "Id"},
			    		{title: "amount" },
			    		{title: "First Name"},
			    		{title: "Last Name"},
			    		{title: "description" },
			    		{title: "status" },
			    		{title: "type" },
			    		{title: "submitted" },
			    		{title: "resolved" }
			    	]
			    });
			});
		}
	}	

	xhr.open("POST", "viewrequest", true);
	xhr.send();
}
