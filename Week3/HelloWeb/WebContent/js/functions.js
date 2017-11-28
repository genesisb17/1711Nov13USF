/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fib(n){
	if(n<=1) return n;
	else return (fib(n-1) + fib(n-2));
}


function runFib(){
	//alert("HELLO!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

var counter = 0;

function count(){
	counter = counter + 1;
	document.getElementById("count").innerHTML = counter;
}

document.getElementById("count").addEventListener("mouseover",count);




document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("outer").addEventListener("click", 
		function(){	alert("IN OUTER!");}, true);
		
document.getElementById("middle").addEventListener("click", 
		function() {alert("MIDDLE!");}, false);

document.getElementById("inner").addEventListener("click", function() {
	alert("INNER");}, true);






/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.

3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.

4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.

5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/