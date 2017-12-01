/**
 * 
 */

function fib(n){
	console.log(n);
	
	if(n<=1) return n;
	else return (fib(n-1) + fib(n-2));

}
function runFib(){
	alert("HELLO!");
/*var display = document.getElementById("fibDisp");*/
	/*var n = document.getElementById("fib");*/
	
}

//null because the DOM doesn't fully load before the function executes
window.onload=function(){
document.getElementById("solve").addEventListener("click", runFib);
}