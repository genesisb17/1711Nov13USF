/**
 * 
 */


window.onload = function(){
	console.log("in on load");
	$('#profile').on("click", loadProfile);
	$('#submit').on("click", submitRequest);
	$('#viewrequest').on("click", viewRequest);
	$('#logout').on("click", logout);
}
//$( document ).ready(function(){
//	console.log("in load ");
//	$('#submit').click(submitRequest);
//});

function loadProfile(){
	window.location.replace("profile.html");
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

function viewRequest(){
	
	window.location.replace("viewrequest.html");
//	console.log("in view request");
//	var xhr = new XMLHttpRequest();
//	
//	xhr.open("GET", "viewrequest" ,true)
//	xhr.send();
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200) {
//			window.location.replace("viewrequest.html");
//		}
//	}
}

function submitRequest(){
	var amount = $('#amount').val();
	var description = $('#description').val();
	var type_id = $('#selectTypeId').find('.active').find('input').attr('id');
	
	var request = {
		amount: amount,
		description: description,
		type_id: type_id
	};
	
	var json = JSON.stringify(request);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			alert("Your reimbursement has been submitted");
		}
	};
	xhr.open("POST", "submitrequest", true);
	xhr.send(json);
}


