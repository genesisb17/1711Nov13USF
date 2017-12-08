window.onload = function() {
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
	$('#logout').on('click', logout);
	$('#allTickets').on('click', getAllTickets);
}

$(document).ready(function() {
	
	getAllTickets();
	
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

	// Create XMLHttpRequest Object
	var xhr = new XMLHttpRequest();

	// Callback function
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var response = JSON.parse(xhr.responseText);

			$(function() {
				$.each(response, function(i, item) {
					$('#reimTable > tbody').html(
							"<td>" + response[i].id + "</td><td>"
									+ response[i].amount + "</td><td>"
									+ response[i].submitted + "</td><td>"								
									+ response[i].resolved + "</td><td>"
									+ response[i].description + "</td><td>"
									+ response[i].receipt + "</td><td>"
									+ response[i].author + "</td><td>"
									+ response[i].resolver + "</td><td>"
									+ response[i].statusId + "</td><td>"
									+ response[i].typeId + "</td>")
							.appendTo('#reimTable');
				});
			});

			
			$('#reimTable').dataTable();
			

		}
	}

	// Open the request
	xhr.open("GET", "getAllTickets", true);

	// Send the request
	xhr.send();

}
