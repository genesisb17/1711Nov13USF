/**
 * Understanding AJAX
 */
var pokemon;
function getPokemon(){
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`); // this is not a ' it is a ` (by the squiggle)
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1. create XHR
	var xhr = new XMLHttpRequest();
	
	//Step 2. function to handle ready state change of the response; callback funtion
	xhr.onreadystatechange = function(){
		consol.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){ // status 200 is good
			pokemon = JSON.parse(xhr.responseText);
//			console.log(pokemon.name);
			console.log(pokemon); // Can just return pokemon to look at it as object in console
			//set values method
			setValues(pokemon);
		}
	}

	//Step 3. open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true); // true sends request asynchronously
	//xhr.open("GET", `https://swapi.co/api/people/${id}`, true);
	//Step 4. Send
	xhr.send();
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
	document.getElementById("weight").innerHTML = pokemon.weight;
}

window.onload = function(){
	console.log("window loaded");
	document.getElementById("submit").addEventListener("click", getPokemon);
}
