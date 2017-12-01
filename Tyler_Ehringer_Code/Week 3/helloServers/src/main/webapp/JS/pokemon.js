/**
 * 
 */

function getPokemon(){
	var id = document.getElementById("id").value;
	console.log(`sending poke no. ${id}.`);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var pokemon = JSON.parse(xhr.responseText);
			document.getElementById("name").innerHTML = pokemon.name;
			document.getElementById("height").innerHTML = pokemon.height;
			document.getElementById("weight").innerHTML = pokemon.weight;
		}
	};
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
	xhr.send();
}

window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPokemon);
}
