/**
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.

2. Bubble Sort
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

function fib(n){
	if(n<=1)return n;
	else return (fib(n-1) + fib(n-2));
}

function runFib(){
	//alert("HELLO");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

var counter = 0;
function count(){
	counter = counter + 1;
	document.getElementById("count").innerHTML = counter;
}
document.getElementById("count").addEventListener("mouseover", count);

document.getElementById("doFib").addEventListener("click", runFib);


document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER!");}, false);
// capture defaults to false, you can specify true
document.getElementById("middle").addEventListener("click", function(){
	alert("MIDDLE!");
}, false);
document.getElementById("inner").addEventListener("click", function(){
	alert("INNER!");
}, true);

/*****************************************************************/

function bubbleSort(numArray){
	var swapped;
    do {
        swapped = false;
        for (var i=0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}

/**********************************************************/

function reverseStr(someStr){
	return someStr.split("").reverse().join("");
}

function doReverse(){
	var display = document.getElementById("revDisplay");
	var n = document.getElementById("reverse").value;
	display.innerHTML = reverseStr(n);
}

document.getElementById("doReverse").addEventListener("click", doReverse);

/*********************************************************/
function factorial(someNum){
	if(someNum <= 1) {
		return 1;
	}
	else{
		return someNum * factorial(someNum - 1);
	}
}

function doFactorial(){
	var number = document.getElementById("factorial").value;
	var display = document.getElementById("factDisplay");
	display.innerHTML = factorial(number);
}

document.getElementById("doFactorial").addEventListener("click", doFactorial);

/*********************************************************/
function substring(someStr, length, offset){
	var string = someStr.substr(offset - 1, (offset+length));
	if(someStr.length + offset < someStr.length){
		alert("The string does not contain that many characters.");
	}
	return string;
}

/***********************************************************/
function isEven(someNum){
	if(someNum & 1)
		return false;
	else
		return true;
}

function evenOdd(){
	var value = document.getElementById("evenOdd").value;
	var display = document.getElementById("displayEvenOdd");
	display.innerHTML = isEven(value);
}
document.getElementById("evenlistener").addEventListener("click", evenOdd);


/************************************************************/















