var person;

function getPerson() {
	var id = document.getElementById("id").value;
	console.log(`Sending person no. ${id}`);
	
	//Using XMLHttpRequest (XHR) Object
	//Step 1: Create XHR
	var xhr = new XMLHttpRequest();
	
	//Step 2: Create function to handle XHR ready state changes of the response; callback function
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			//parse received JSON file to create a person object
			person = JSON.parse(xhr.responseText);
			setValues(person);
		}
	}
	
	//Step 3: Open request
	xhr.open("GET", `https://swapi.co/api/people/${id}`, true);
	
	//Step 4: Send request
	xhr.send();
}

function setValues(person) {
	document.getElementById("name").innerHTML = person.name;
}

window.onload = function() {
	document.getElementById("submit").addEventListener("click", getPerson);
}