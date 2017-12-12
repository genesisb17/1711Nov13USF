/**
 * 
 */
var store = [];
window.onload = function(){
	//loadHome();
	$('#home').on('click',loadHome);
	$('#profile').on('click', loadProfile);
	//$('#request').on('click', request);
	
}

$('#example').DataTable( {
    data: store,
    columns: [
        { title: "Name" },
        { title: "Position" },
        { title: "Office" },
        { title: "Extn." },
        { title: "Start date" },
        { title: "Salary" }
    ]
} );
$(document).ready(function(){
	console.log("in table");
    $('#table').DataTable( {
    	data: store,
    	columns: [
    		{title: "amount"},
    		{title: "submitted"},
    		{title: "resolved"},
    		{title: "description"},
    		{title: "author"},
    		{title: "resolver"},
    		{title: "status"},
    		{title: "type"}
    	]
    });
    
});
// load the data into the table when the document is ready, 
// note that appendData cannot be called with just $('#data').appendData();
$(document).ready(appendData);


function appendData(){
	console.log("hi");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("success");
			var data = JSON.parse(xhr.responseText);
			
			console.log(data);
			// use store array of data in array for formatting the table
			
//			for(var i = 0; i < data.length; i++) {
//				var dataset = new Array();
//				dataset.push(data[i]);
//				for(var j = 0; j < dataset.length; j++){
//					store.push(dataset);
//				}
//			}

			
			console.log(store);
			


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
	console.log("in data table function");
	xhr.open("POST", "datatable", true);
	xhr.send();
}


function loadHome(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').innerHTML = xhr.responseText;				
		}
	}	
	xhr.open("GET", "getHomeView" , true);
	xhr.send();
}

function loadProfile(){
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "getProfileView" , true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//partials/profile.html
			document.getElementById('view').innerHTML = xhr.responseText;	
			loadProfileInfo();
		}
	}
}


function loadProfileInfo(){
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




