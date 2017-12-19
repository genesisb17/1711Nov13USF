/**
 * 
 */
var store = [];
window.onload = function(){
	
	$('#profile').on('click', getProfilePage);
	$('#logout').on('click', logout);
	/*
	 * in order to grab the reimbursement Id from the datatable(), console.log(event)
	 * to get the event path that will "see" the innerText of the reimbursement
	 * for this case: it goes event -> path[2] -> cells[0] -> innerText, this value
	 * is the table data of the first element in the dataTable(), each row will grab 
	 * that specific row's first table data, which is the reimbursement id
	 */
	/*
	 * the closest selects the button and get "closest" ancestor element, returning 0
	 * or 1 element, if it does return, the if statement = 1 will be true, running the
	 * 
	 */
	$(document).on('click', 'button[id]', function(e) {
		var id = event.path[2].cells[0].innerText;
		  if ($(this).closest("#" + this.id).length) {
			  e.preventDefault();
		    if(this.id == 2){
		    	updateApprove(id);
		    	
		    } else if(this.id == 3){
		    	updateDeny(id);
		    }
		  }
	});
}


// load the data into the table when the document is ready, 
// note that appendData cannot be called with just $('#data').appendData();
$(document).ready(appendData);

function updateDeny(id){
	// 3 for Deny
	var status = 3;
	
	// 0 for author_id that will be passed in at java side
	var toSend = [0, status, id]
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			window.location.replace("manager.html");
		}
	}
	xhr.open("POST","updatestatusservlet", true);
	xhr.send(json);
}

function updateApprove(id){
	// 2 for approval
	var status = 2;
	// 0 for author_id that will be passed in at Java side
	/*
	 * id selected from the row of the table and getting that reimbursement id
	 */
	var toSend = [0, status, id]
	var json = JSON.stringify(toSend);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			window.location.replace("manager.html");
		}
	}
	xhr.open("POST","updatestatusservlet", true);
	xhr.send(json);
}

function getProfilePage(){
	window.location.replace("profile.html");
//	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			console.log(xhr.responseText);
//			var user = JSON.parse(xhr.responseText);
//		
//			window.location.replace("profile.html");
//			//document.write(user.firstname);
//			//document.write(user.lastname);
////			$('#firstname').append(user.firstname);
////			$('#lastname').append(user.lastname);
//		}
//		$('#firstname').append(user.firstname);
//		$('#lastname').append(user.lastname);
//		
//	}
//	xhr.open("GET", "getUserInfo", true)
//	xhr.send();
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
				dataset.push(data[i].first_name);
				dataset.push(data[i].last_name);
				dataset.push(String(description(data[i].description)));
				dataset.push(String(resolve(data[i].resolver)));
				dataset.push(String(status(data[i].status_id)));
				dataset.push(String(type(data[i].type_id)));
				dataset.push(String(data[i].submitted));
				dataset.push(String(timeResolve(data[i].resolved)));
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
			    		{title: "resolver" },
			    		{title: "status" },
			    		{title: "type" },
			    		{title: "submitted" },
			    		{title: "resolved" }
			    	]
			    });
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



