window.onload = function() {
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
	$('#logout').on('click', logout);
	$('#allTickets').on('click', function() {
		location.reload();
	});
}

$(document).ready(function() {

	getAllTickets();
	newTicketModal();

});

function loadHome() {
	loadView("employeeView");
}

function loadProfile() {
	loadView("getProfileView");
}

function loadEmployeeNav() {
	loadView("employeeNavigation");
}

function loadAllTickets() {
	loadView("getAllTickets");
}

function loadView(page) {

	// Create XMLHttpRequest Object
	var xhr = new XMLHttpRequest();

	// Callback function
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	console.log("REQUESTING VIEW " + page)

	// Open the request
	xhr.open("GET", page, true);

	// Send the request
	xhr.send();
};

function logout() {

	// Create XMLHttpRequest Object
	var xhr = new XMLHttpRequest();

	// Callback function
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			window.location.replace("login.html");
		}
	}

	// Open the request
	xhr.open("POST", "logoutServlet", true);

	// Send the request
	xhr.send();

};

function getAllTickets() {

	var table = $('#example')
			.DataTable(
					{
						paging : true,
						sort : true,
						search : true,
						"ajax" : {
							"url" : "http://localhost:9999/ExpenseReimbursementSystem/getAllTickets",
							cache : false
						},
						"columns" : [
								{"data" : "id"},
								{"data" : "amount",render : $.fn.dataTable.render.number(',','.', 0, '$')}, 
								{"data" : "submitted"}, 
								{"data" : "description"}, {"data" : "type"},
								{"data" : "status"} ]
					});
	
}

function newTicketModal() {

	$("#dialog").dialog({
		autoOpen : false,
		show : {
			effect : "scale",
			duration : 300
		},
		hide : {
			effect : "scale",
			duration : 300
		}
	});

	$("#opener").on("click", function() {
		$("#dialog").dialog("open");
	});

}