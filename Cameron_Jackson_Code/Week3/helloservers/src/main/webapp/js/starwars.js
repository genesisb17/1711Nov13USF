/**
 * Understanding AJAX
 */
function getPeople() {
	var id = document.getElementById("id").value;
	console.log(`Sending Star Wars ID: ${id}`);
	
	// USING XMLHttpRequest OBJECT. FOUR STEPS
	// 1. Create XHR
	var xhr = new XMLHttpRequest();
	// 2. function to handle ready state change of the response; callback function
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var swpeople = JSON.parse(xhr.responseText);
			// set values method
			// setValues(swpeople);
			$('#name').append(swpeople.name);
			$('#weight').append(swpeople.mass);
			$('#birthyear').append(swpeople.birth_year);
		}
	}
	// 3. Open
	xhr.open("GET", `https://swapi.co/api/people/${id}`, true); 
								// true sends request asychrounously
	// 4. Send 
	xhr.send();
	
	//...Do stuf with data...
}

function setValues(swpeople) {
	document.getElementById("name").innerHTML = swpeople.name;
	document.getElementById("weight").innerHTML = swpeople.mass;
	document.getElementById("birthyear").innerHTML = swpeople.birth_year;
}

window.onload = function() {
	document.getElementById("submit").addEventListener("click", getPeople);
}