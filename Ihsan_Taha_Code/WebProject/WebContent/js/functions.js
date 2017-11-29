function fib(n) {
	if(n<= 1)
		return 1
	else
		return (fib(n-1) + fib(n-2));
}

function runFib() {
	alert("HELLO!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

var counter = 0;
function count(){
	counter += 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover", count);

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("outer").addEventListener("click", function(){alert("In Outer!");}, false);

document.getElementById("middle").addEventListener("click", function() {alert("In Middle!");}, false);

document.getElementById("inner").addEventListener("click", function() {alert("In Inner!");}, false);