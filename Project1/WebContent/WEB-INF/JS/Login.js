/*
 * 
 */

function add()
{
	var i = document.getElementById("id");

	//add info to cells
	cell1.innerHTML = count++;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	document.getElementById("students").appendChild(row);
	
}

document.getElementById("add").addEventListener("click", add, false);