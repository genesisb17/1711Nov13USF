/**
 * 
 */
function getPOkemon(){
	let id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	// make sure not using singlequote ^ 
	// using xhmphttprqust object 4 steps
	//1. create xhr
	var xhr= new XMLHttpRequest();
	//2. function to handle readystate chagne of the responce ; callback function 
	xhr.onreadystatechange =function(){
		console.log(xhr.readyState);
		if (xhr.readyState==4 && xhr.status==200)
		{
		let pokemon=JSON.parse(xhr.responseText)
		console.log(pokemon);
		setValues(pokemon);
		}
	};
	
	//3 open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
	//send
	xhr.send();
}
function setValues(pokemon){
	document.getElementById("name").innerHTML=pokemon.name;

	document.getElementById("height").innerHTML=pokemon.height;

	document.getElementById("weight").innerHTML=pokemon.weight;

	document.getElementById("base").innerHTML=pokemon.base_experience;

}

window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPOkemon);
	
}
