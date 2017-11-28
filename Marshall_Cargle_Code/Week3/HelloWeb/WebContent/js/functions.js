/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
/*
 1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fib(n){
	console.log(n);
	if(n<=1) return n;
	else return (fib(n-1)+fib(n-2));
}

function runFib(){
	//alert("HELLO!");
	var display = document.getElementById("fibDisplay");
	var n=document.getElementById("fib").value;
	display.innerHTML=fib(n);
}

var counter=2;

function count(){
	counter=counter*10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000;
	document.getElementById("count").innerHTML = counter;
}
document.getElementById("count").addEventListener("mouseover", count);



document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER!")
}, true);

document.getElementById("middle").addEventListener("click", function(){
	alert("IN MIDDLE!")
}, false);

document.getElementById("inner").addEventListener("click", function(){
	alert("IN INNER!")
}, true);
/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray){
	let extra = 0;
	for (let i=0; i < numArray.length; i++) {
		for (let j=0; j < numArray.length; j++) {
			if (numArray[j] > numArray[i]) {
				extra = numArray[j];
				numArray[j] = numArray[i];
				numArray[i] = extra;
			}
		}
	}
	return numArray;
}
/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(s){
	for(let i=0; i<s.length;i++)
		s=s.substring(1, s.length-i)+s.substring(0,1)+s.substring(s.length-i);
}
/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
	let x=0;
    if(someNum==1)
      return 1;
    x = factorial(someNum-1) * someNum;
    return x;
}
/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function subStr(str,length,offset){
	return str.subString(offset,offset+length)
}
/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */