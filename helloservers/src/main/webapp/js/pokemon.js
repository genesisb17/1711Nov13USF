

var pokemon;
function getPokemon() {
	
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. $(id)`);
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1: OPEN XHR
	
	var xhr = new XMLHttpRequest();
	
	//Step 2: Function to handle ready state change of response; callback function
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			pokemon = JSON.parse(xhr.responseText);
			console.log(pokemon);
			// set values method
		}
	};
	//Step 3:
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
										//true sends request asynchronously
	//Step 4:
	xhr.send();
}



window.onload = function() {
	
	document.getElementById("submit").addEventListener("click", getPokemon);	
	
}