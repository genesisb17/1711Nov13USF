/**
 * 
 */
function add(){
	console.log("hey man");
	let id= Math.random();
	let name= document.getElementById("name").value;
	let major= document.getElementById("major").value;
	// make rows
	let row = document.createElement("tr");

	//make row cells 
	let cell1=document.createElement("td");
	let cell2=document.createElement("td");
	let cell3=document.createElement("td");	//appendchild to row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	//add info
//could've done count variable and count++ 
	cell1.innerHTML=id;
	cell2.innerHTML=name;
	cell3.innerHTML=major;
	// append to table
	document.getElementById("students").appendChild(row);
	
	
}
document.getElementById("add").addEventListener("click", add,false);
