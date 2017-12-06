/**
 * 
 */

function getPokemon(){
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			pokemon = JSON.parse(xhr.responseText);
			console.log(pokemon);
			setValues(pokemon);
		}
	}
	
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
	
	xhr.send();
}

function setValues(){
	document.getElementById("name").innerHTML = pokemon.name;
	document.getElementById("weight").innerHTML = pokemon.weight;
}

window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPokemon);
}