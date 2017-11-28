/**
 * 
 */

function fib(n) {
	console.log(n);
	if(n<=1) return n;
	else return (fib(n-1) + fib(n-2));
}

function doFib() {
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}


document.getElementById("doFib").addEventListener("click", run);

