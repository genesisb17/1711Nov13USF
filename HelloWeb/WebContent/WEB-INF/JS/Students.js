/*
 * 
 */

function add()
{
	var i = document.getElementById("id");
	var name = document.getElementById("name");
	var major = document.getElementById("major");
	//create a row
	var row = document.createElement("tr");
	//create row cells
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	//append cells to row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	//add info to cells
	cell1.innerHTML = count++;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	document.getElementById("students").appendChild(row);
	
}

document.getElementById("add").addEventListener("click", add, false);