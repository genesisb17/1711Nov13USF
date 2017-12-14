/**
 * 
 */


window.onload = function(){
	console.log("in on load");
	//$("#register-submit").on("click", register);
	$('#submit').on("click", submitRequest);
	$('#viewrequest').on("click", viewRequest);
	$('#logout').on("click", logout);
}
//$( document ).ready(function(){
//	console.log("in load ");
//	$('#submit').click(submitRequest);
//});


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
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "viewrequest" ,true)
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.readystate == 4 && xhr.status == 200) {
			console.log("going to another page");
		}
	}
}

function submitRequest(){
	console.log("in submit function");
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
			console.log("add reimbursement");
		}
	};
		
	xhr.open("POST", "submitrequest", true);
	xhr.send(json);
}


