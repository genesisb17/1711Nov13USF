/**
 * Week 3 Javascript Assignment. 
 *
 *Assignment: Complete 6 functions out of the given set of functions and create a webpage 
 * HTML FILE NAME: (Week3Functions.html)
 * The functions are all paired with respective functions that layer out the way for interacting
 * with t he HTML webpage listed above. 
 */


/*
 * 1. Fibonacci Sequence function
 * 
 */

function fib(n)
{
	if(n<2)
		return 1;
	return fib(n-1) + fib(n-2);
}
function runFib(){
	//alert("HELLO!");
	var display = document.getElementById("outputFib");
	var n = document.getElementById("inputFib").value;
	display.innerHTML = fib(n);
}
document.getElementById("fibButton").addEventListener("click", runFib);


/*
 * 2. Factorial function
 */

function factorial(someNum){
	if (someNum == 0)
		return 1;
	return someNum * factorial(someNum-1);
		
}
function runFactorial(){
	//alert("HELLO!");
	var display = document.getElementById("outputFactorial");
	var n = document.getElementById("inputFact").value;
	display.innerHTML = factorial(n);
}
document.getElementById("factButton").addEventListener("click", runFactorial);

/*
 * 3. Even Check function
 */
function isEven(n){
	if((n & 1) == 0)
		return n + " is even!";
	else
		return n + " is odd!";
}
function runEvenCheck(){
	//alert("HELLO!");
	var display = document.getElementById("outputEven");
	var n = document.getElementById("inputEven").value;
	display.innerHTML = isEven(n);
}
document.getElementById("evenButton").addEventListener("click", runEvenCheck);

/*
 * 4. Substring function
 * 
*/

function substring(a,b,c){
	var stringCheck="hello";
	if(typeof a != typeof stringCheck){
		alert("Incorrect input! your first input must be a string not a " + typeof a);
		return 0;
	}
	else{
		return ("New sentence: " + a.substring(c, b+c));
	}	
}
function runSub(){
	//alert("HELLO!");
	var display = document.getElementById("outputSubstring");
	var n = document.getElementById("inputSub").value;
	var o = n.length;
	var p = document.getElementById("inputSubNum").value;
	display.innerHTML = substring(n,o,p);
}
document.getElementById("substringButton").addEventListener("click", runSub);

/*
 * 
 * 5. Palindrome Question
 * 
 * 
 * */
function isPalindrome(str){
var a = str.length-1;
for(var b = 0;b<str.length; b++){
if(str[a]!= str[b]){
	return str + " is not a palindrome!";
	}
	a--;
}
	return str + " is a palindrome!";
}
function runPalindrome(){
	//alert("HELLO!");
	var display = document.getElementById("outputPal");
	var n = document.getElementById("inputPal").value;
	display.innerHTML = isPalindrome(n);
}
document.getElementById("palindromeButton").addEventListener("click", runPalindrome);

/*
* 6.Object Literal Function
*
*/

function traverseObject(obj){
	return "Hello " + obj.name + " So you're a " + obj.age + " year old " + 
	obj.gender + " ? That's wassup! ";
}
function runObject(){
	var display = document.getElementById("outputPerson");
	var n = document.getElementById("inputName").value;
	var a = document.getElementById("inputAge").value;
	var g = document.getElementById("inputGender").value;
	var object = {name: n, age: a, gender: g};
	display.innerHTML = traverseObject(object);
}
document.getElementById("personButton").addEventListener("click",runObject);