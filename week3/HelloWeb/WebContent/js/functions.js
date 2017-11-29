/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n){
	if(n<=1) return n;
	else return fib(n-1)+fib(n-2);
}
	
function runFib(){
	//alert("HELLO!");
	var display=document.getElementById("fibDisplay");
	var n=document.getElementById("fib").value;
	display.innerHTML =fib(n);
}

var counter=0;

function count(){
	counter=counter+1;
}

document.getElementById("count").adEventListener("mouseover",count);


document.getElementById("doFib").addEventListener("click",runFib);

document.getElementById("outer").addEventListener("click", 
		function(){alert("IN OUTER!");},true);

document.getElementById("middle").addEventListener("click",function(){
	alert("MIDDLE!");},true);

document.getElementbyId("inner").addEventListener("click",function(){
	alert("INNER!");},true)
	
//false goes inside to outside (bubbling), true goes to outside to outside (capturing).
//in relation to other events that overlap the event it's describing