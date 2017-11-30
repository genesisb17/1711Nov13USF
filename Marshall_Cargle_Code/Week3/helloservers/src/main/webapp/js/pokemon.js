/**
 * Understanding AJAX
 */

var pokemon;

function getPokemon(){

	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`)
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1. create XHR
	var xhr= new XMLHttpRequest();
	
	//Step 2. functions to handle ready state change of the response; callback function
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
			//set values method
		} 
	}
	
	//Step 3. Open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`,true);
														//true sends request asynchronously
	
	//Step 4. Open
	xhr.send();
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
	document.getElementById("weight").innerHTML = pokemon.weight;
	document.getElementById("height").innerHTML = pokemon.height;
}


window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPokemon);
}