window.onload = function() {
	$('#home').on('click', loadHome);
	$('#profile').on('click', loadProfile);
	$('#logout').on('click', logout);
	$('#allTickets').on('click', function() {location.reload();});
}

$(document).ready(function() {

	getAllTicketsManager();
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

var data;

function getAllTicketsManager() {

	var table = $('#example')
			.DataTable(
					{
						paging: true,
						sort: true,
						/*scrollY: "400px",*/
						search: true,
						"ajax" : {
							"url" : "http://localhost:9999/ExpenseReimbursementSystem/AllTicketsManager",
							cache : false
						},
						"columns" : [ {
							"data" : "id"
						}, {
							"data" : "username"
						},{
							"data" : "amount", render: $.fn.dataTable.render.number( ',', '.', 0, '$' )
						}, {
							"data" : "submitted"
						},{
							"data" : "description"
						}, {
							"data" : "type"
						}, {
							"data" : "status"
						}, ]
					});
	
	updateStatusModal();
	
	// Activate the inline editor on click of a table cell
	$('#example tbody').on( 'click', 'tr', function () {
	    var datas = table.row( this ).data();
	    data = datas.id;
	    //console.log(data.status);
	    
	    openDialog();
	    
	} );

}

function updateStatusModal() {
	
	$("#updatedialog").dialog({
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
	
};

function updateStatusModalAJAX() {
	
	var status = document.getElementById("statusdrop").value;
	//console.log(data + " " + status)
	
	$.ajax({
        url:'ChangeStatus',
        data:{"status":status, "id": data},
        type:'post',
        cache:false,
        success:function(data){ 
        	
        	closeDialog();
        	location.reload();
        	//getAllTicketsManager();
        },
        error:function(){
        	console.log("Error. appmanager.js line 145.");
        }
     });
	
};

function newReimModalAJAX() {
	
	var reimamount = document.getElementById("reimamount").value;
	var reimdesc = document.getElementById("reimdesc").value;
	var reimtype = document.getElementById("reimtype").value;
	
	//console.log(reimamount +", "+ reimdesc +", "+ reimtype);
	
	$.ajax({
        url:'NewReimbursement',
        data:{"amount":reimamount, "description": reimdesc, "type": reimtype},
        type:'post',
        cache:false,
        success:function(data){ 
        	
        	//console.log("success!");
        	closeDialog();
        	location.reload();
        	
        },
        error:function(){
        	console.log("Error. appmanager.js line 175.");
        }
     });
	
};

function newTicketModal() {
	
	$("#opener").on("click", function() {
		openReimDialog();
	});

}

function openDialog() {
	Avgrund.show( "#default-popup" );
}

function openReimDialog() {
	Avgrund.show( "#reim-popup" );
}

function closeDialog() {
	Avgrund.hide();
}

