/**
 * Understanding AJAX
 */

function getPokemon() {
	var id = document.getElementById("id").value;

	//USING XMLHttpRequest Object
	//Step 1. create XHR
	var xhr = new XMLHttpRequest();

	//Step 2. function to handle ready state change of the response; callback function
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			var pokemon = JSON.parse(xhr.responseText);
			console.log(pokemon);
			setValues(pokemon);
			// set values method
			
		}
	};
	
	//Step 3. Open
	xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + id, true);
									// true sends request asynchronously
	
	//Step 4. Send
	xhr.send();
}

function setValues(pokemon) {
	document.getElementById("name").innerHTML = pokemon.name;
	document.getElementById("weight").innerHTML = pokemon.weight;
	document.getElementById("move").innerHTML = pokemon.moves[0].move.name;
}

window.onload = function() {
	document.getElementById("submit").addEventListener("click", getPokemon);
};