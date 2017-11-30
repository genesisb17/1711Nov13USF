/*
* Understanding AJAX
*/


var pokemon;

function getPokemon() {
	
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState = 4 && xhr.status == 200) {
			pokemon = JSON.parse(xhr.responseText);

			console.log(pokemon.name)
			// set values method
			setValues(pokemon);
			
		}
	}
	
	// step 3 open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}/`, true);
	
	// step 4 
	xhr.send();
	
}

function setValues(pokemon) {
	document.getElementById("name").innerHTML = pokemon.name;
	document.getElementById("weight").innerHTML = pokemon.weight;
}

window.onload = function() {
	document.getElementById("submit").addEventListener("click", getPokemon);
}
