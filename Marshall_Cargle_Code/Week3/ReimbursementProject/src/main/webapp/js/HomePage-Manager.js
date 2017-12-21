window.onload = function() {
	getUser();
	$('#submit').on('click', submitManager);
	$('#myProfile').on('click', loadMyProfile);
	$('#logout').on('click', logout);
	loadTable();
}

function getUser(){
	var test=0;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			if(user==null){
				window.location.replace('StartPage.html');
			}
		}
	};
	
	xhr.open("POST","getUserInfo", true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(test);
}

var ticketNumber=0;

function logout(){
	window.location.replace('StartPage.html')
}

function loadMyProfile(){
	window.location.replace('EditProfile.html');
}

function submitManager() {
	var selectedOption = $("input:radio[name=radio]:checked").val()
	// add password validation and second input confirmation?
	var option = [selectedOption, ticketNumber];
	var optionJSON = JSON.stringify(option);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var option = JSON.parse(xhr.responseText);
			let testing;
			let xhr2 = new XMLHttpRequest();
			xhr2.onreadystatechange = function() {
				if (xhr2.readyState == 4 && xhr2.status == 200) {
					testing = JSON.parse(xhr2.responseText);
					let count = Object.keys(testing).length;
					let tabledata=[];
					for(i=0; i<count;i++){
						tabledata.push(testing[i]);
					}

					$("#example-table").tabulator("setData", tabledata);
				}
			};
			xhr2.open("POST", "manager", true);
			xhr2.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr2.send();

		}
	};
	xhr.open("POST", "resolve", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(optionJSON);
}

function loadTable(){
	var testing;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			testing = JSON.parse(xhr.responseText);
			var count = Object.keys(testing).length;
			var tabledata=[];
			for(i=0; i<count;i++){
				tabledata.push(testing[i]);
			}

			$("#example-table").tabulator("setData", tabledata);
		}
	};
	xhr.open("POST", "manager", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
	//create Tabulator on DOM element with id "example-table"
	$("#example-table").tabulator({
	    columns:[ //Define Table Columns
	        {title:"Ticket ID", field:"ticket_id"},
	        {title:"First Name", field:"firstName", formatter:"textarea"},
	        {title:"Last Name", field:"lastName"},
	        {title:"Email", field:"email"},
	        {title:"Amount", field:"amount"},
	        {title:"Date Submitted", field:"submitted"},
	        {title:"Date Resolved", field:"resolved"},
	        {title:"Description", field:"description", width: 220},
	        {title:"Resolver", field:"resolver"},
	        {title:"Status", field:"status"},
	        {title:"Type", field:"type"}
	    ],
	    rowClick:function(e, row){ //trigger an alert message when the row is clicked
	    	ticketNumber=row.getData().ticket_id;
	        $('#ticketid').html("Ticket Id: "+ ticketNumber);	
	        $('.popup').css('opacity', 1);
	    	$('.overlay').css('opacity', 0.8);
	    	$('.popup').css('display', 'block');
	    	$('.overlay').css('display', 'block');
	    },
	});
}

// close popup
$('.popup-close').click(function() {
	$('.popup').css('opacity', 0);
	$('.overlay').css('opacity', 0);
	setTimeout(function() {
		$('.popup').css('display', 'none');
		$('.overlay').css('display', 'none');
	}, 1000);

});

