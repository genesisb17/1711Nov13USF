/*
 * 
 */
function getPokemon()
{
	var testJSON =
		{
			name:"example",
			age:56
		}
	var id = document.getElementById("id").value;
	console.log('seding poke no. '+id);
	//step 1 create xhr; https://developer.mozilla.org/en-US/docs/Web/API/XMLHTTpRequest
	var xhr = new XMLHttpRequest();
	//step 2 function to handle ready state change of the reponse callback function
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState==4&&xhr.status==200)
		{
			var pokemon = JSON.parse(xhr.responseText);
			console.log(JSON.parse(xhr.responseText));
			setValues(pokemon);
			//
		}
	}//step 3 OPEN
	xhr.open("GET","https://pokeapi.co/api/v2/pokemon/"+id,true);
	//step 4 send
	xhr.send();
}
function setValues(pokemon)
{
	document.getElementById("name").innerHTML = pokemon.name;
}
window.onload=function()
{
	document.getElementById("submit").addEventListener("click",getPokemon);
}