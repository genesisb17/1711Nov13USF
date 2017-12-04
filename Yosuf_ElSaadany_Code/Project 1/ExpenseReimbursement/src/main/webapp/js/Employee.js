
	
	window.onload = function(){
		$('#message').hide();
		$('#message2').hide();
	}

	// Accordion Event
	var acc = document.getElementsByClassName("accordion");
	var i;
	for (i = 0; i < acc.length; i++) {
	  acc[i].onclick = function() {
		this.classList.toggle("active");
		var panel = this.nextElementSibling;
		if (panel.style.maxHeight){
		  panel.style.maxHeight = null;
		} else {
		  panel.style.maxHeight = panel.scrollHeight + "px";
		} 
	  }
	}
	
	//----------------------------Logout Event-------------------------------//

	$('#logout').on('click',logout);
	function logout(){
		window.location.replace('login.html');
	}
	
	
	//---------------------- Add Reimbursement Request ----------------------//
	
	$('#request').on('click',request);
	function request(){
		var amount = $("#amount").val();
		var type = $("#type").val();
		var description = $("#description").val();
		var username = $("#username").val();
		
		if(description == "")
			var description = "N/A";
		
		$('#message').show();
		if(amount == "" || type == null){
			$('#message').html("Please enter all information");
		}
		// Sending AJAX request to Servlet
		else { 
			$('#message').html("Cool!");

			var toSend = [username, amount, type, description];
			
			var json = JSON.stringify(toSend);
			console.log(json);
			
			var xhr = new XMLHttpRequest();
			console.log(xhr.readyState);
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status==200){
					console.log("in xhr callback" + xhr.responseText);
					var tickets = JSON.parse(xhr.responseText);
					$('#message').show();
					if(tickets == null){
						$('#message').html("Error. Please try again later");
					}
					else {
						//$('#message').html(`Welcome ${user.username}`) ;
						//window.location.replace('main.html');
						$('#message').html("Thank you for submitting a request");
						
					}
				}
			};
			
			xhr.open("POST", "AddReimb", true);
			console.log(xhr.readyState);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			console.log("AFTER HEADER " + xhr.readyState);
			xhr.send(json);
		}
		
		//---------------------- View Past Reimbursements ----------------------//
		$('#getbyamount').on('click', get);
		function get() {
			console.log("HERE");
			var username = "Yosuf.92";
			var toSend = [username];
			
			var json = JSON.stringify(toSend);
			console.log(json);
			
			var xhr = new XMLHttpRequest();
			console.log(xhr.readyState);
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status==200){
					console.log("in xhr callback" + xhr.responseText);
					var tickets = JSON.parse(xhr.responseText);
					$('#message2').show();
					if(tickets == null){
						$('#message2').html("User has no history of Reimbursements");
					}
					else {
						$('#message2').html(tickets.toString());
						/*//get input values
						var id = tickets.toString();
						var name = document.getElementById("name").value;
						var major = document.getElementById("major").value;
						
						//create row
						var row = document.createElement("tr");
						
						//create row cells
						var cell1 = document.createElement("td");
						var cell2 = document.createElement("td");
						var cell3 = document.createElement("td");
						
						//append cells to row
						row.appendChild(cell1);
						row.appendChild(cell2);
						row.appendChild(cell3);
						
						//add info to cells
						cell1.innerHTML = id;
						cell2.innerHTML = name;
						cell3.innerHTML = major;
						
						//append row to table
						document.getElementById("students").appendChild(row); */
						
					}
				}
			}	
			
			xhr.open("POST", "ViewPastTickets", true);
			console.log(xhr.readyState);
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			console.log("AFTER HEADER " + xhr.readyState);
			xhr.send(json);
		}
