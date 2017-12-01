/**
 * 
 */

function fib (n){
	//console.log(n);
	if(n<2) return 1;
	return fib(n-1)+fib(n-2);
}

function substring(someStr, length, offset){
	var n="";
	if(offset>length)
		return alert("incorrect values for length / offset");
	for(let i = offset; i <length; i++)
		n+=someStr[i];
	console.log(n);
	return n;
}

var counter = 0;
function count(){
	counter=counter+1;
	document.getElementById("count").innerHTML=counter;
}

document.getElementById("count").addEventListener("mouseover", count);

document.getElementById("outer").addEventListener("click", function(){alert("IN OUTER")},true);
document.getElementById("middle").addEventListener("click", function(){alert("IN MIDDLE")},false);
document.getElementById("inner").addEventListener("click", function(){alert("IN INNER")},true);


function ReverseString (arr){
	for(let i=arr.length-1; i>-1;i--)
	{
		arr+=arr[i];
		}
	arr=arr.substring(arr.length/2)
console.log(arr);
return arr;
}

function runRev(){
	//alert("hello!");
	let display= document.getElementById("revDisplay");
	let n =document.getElementById("rev").value;
	display.innerHTML=ReverseString(n);
}
document.getElementById("doRev").addEventListener("click", runRev);

function runFib(){
	//alert("hello!");
	let display= document.getElementById("fibDisplay");
	let n =document.getElementById("fib").value;
	display.innerHTML=fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);







function runSubs(){
	let display= document.getElementById("subDisplay");
	let n =document.getElementById("subs").value;
	let offset =document.getElementById("sub1").value;
	let lenng =document.getElementById("sub2").value;
	display.innerHTML=substring(n, lenng, offset );
}

document.getElementById("doSub").addEventListener("click", runSubs);


function factorial(someNum) {
	if(someNum < 0){ System.out.println("cannot be negative"); return 0;}
	else if(someNum == 0) return 1;
	else{
		return someNum*factorial(someNum-1);
	}
}



function runFac(){
	let display= document.getElementById("facDisplay");
	let n =document.getElementById("fac").value;
	display.innerHTML=factorial(n);
}

document.getElementById("doFac").addEventListener("click", runFac);



function isEven(someNum)
{
	let hold= someNum/2;
	hold=Math.floor(hold)
	if(hold*2==someNum)
	return true;
	return false;
}

function runEve(){
	let display= document.getElementById("eveDisplay");
	let n =document.getElementById("eve").value;
	display.innerHTML=isEven(n);
}

document.getElementById("doEve").addEventListener("click", runEve);
