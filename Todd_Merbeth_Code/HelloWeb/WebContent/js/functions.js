/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n) {
	console.log(n);
	if (n<2) return 1;
	return fib(n-1) + fib(n-2);
}
function runFib(){
//	alert("HELLO!");
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
//If set like this cannot be passed parameters

document.getElementById("doFib").addEventListener("click", runFib);

document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER!");}, false);
	
document.getElementById("middle").addEventListener("click", function(e) {
	alert("MIDDLE!");}, false);

document.getElementById("inner").addEventListener("click", function(e) {
	alert("INNER!");}, false);
// Bubbleing/capturing
// event propagation 

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	var str = "";
	var i = 0;
	for(i = 0; i < someStr.length; i++){
		str = str + someStr.charAt(someStr.length -1 - i);
	}
	return str;
}

function runReverseStr(){
	var display = document.getElementById("revDisplay");
	var n = document.getElementById("rev").value;
	display.innerHTML = reverseStr(n);
}

document.getElementById("doRev").addEventListener("click", runReverseStr);
//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
	if (someNum <= 1){
		return someNum;
	}
	else {
		someNum = someNum * factorial(someNum - 1)
	}
	return someNum;	
}

function runFactorial(){
	var display = document.getElementById("facDisplay");
	var n = document.getElementById("fac").value;
	display.innerHTML = factorial(n);
}

document.getElementById("doFac").addEventListener("click", runFactorial);

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
	var off = parseInt(offset);
	var len = parseInt(length);
	var str = someStr.substring(offset, off+len);
	return str;
}

function runSubstring(){
	var display = document.getElementById("subsDisplay");
	var n = document.getElementById("subs1").value;
	var o = document.getElementById("subs2").value;
	var p = document.getElementById("subs3").value;
	if(isNaN(o) && isNaN(p)){
		alert("Please enter number for the length and offset");
	}
	else if(isNaN(o)){
		alert("Please enter number for the length");
	}
	else if(isNaN(p)){
		alert("Please enter number for the offset");
	}
	else {
		display.innerHTML = substring(n, o, p);
	}
}
document.getElementById("doSubs").addEventListener("click", runSubstring);
//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum){
	if (someNum & 1) {
		return false;
	} else
		return true;
}

function runEven(){
	var display = document.getElementById("evenDisplay");
	var n = document.getElementById("even").value;
	display.innerHTML = isEven(n);
	
}
document.getElementById("doEven").addEventListener("click", runEven);
//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
	var revStr = someStr.split("").reverse().join("");
	return revStr == someStr;
}

function runPalin(){
	var display = document.getElementById("palinDisplay");
	var str = document.getElementById("palin").value;
	display.innerHTML = isPalindrome(str);
}
document.getElementById("doPalin").addEventListener("click", runPalin);

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
//
//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
	return someObj;	
}

//
//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
//
//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
//
//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);
function Person(name, age){
	var person = {name:name, age:age};
	return person;
}
//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);
function getPerson(name, age){
	var person = {};
	person.name = name;
	person.age = age;
	return person;
}