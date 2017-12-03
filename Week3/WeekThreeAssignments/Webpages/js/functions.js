/**
 * Objects 
 * -can contain data and functions
 * -can inherit from other objects
 * -object literal {}
 * - objects can contain an unordered collection of name/value pairs
 * 
 * 
 */

/*
 * Arrays
 * -inherit from object
 * -array indexes are converted into strings and used as names 
 *   retrieve values
 *   array literal [] 
 *   -do not specify lenth.type
 *   -length number - not the actual number of elements stored in the array but 1 larger than the last index
 */

/*
 * Hoisting declarations using var are treated as
 * if they are at the top of the function (or
 * global scope, if declared outside of a function)
 * regardless of where the actual declaration occurs;
 * this is class hoisting
 */

/*
 * LET KEYWORD
 * limits the variable to specific block scope in which variable is initialized in
 */
var a = 5;
var b = "hello";
var c ='hello';
var d = 7/0;
var e = {name: "genesis", age: 30};
var f = e.age;
var g = [0,2,4,6,8];
var h = null;
var i;
console.log(typeof(a));


/*functions
 * 
 * 
 * 
 * 
*/

function add(a,b){return a + b;}

/*
 * Palindrome
 * Define function isPalinndrome(someStr)
 * return true if someStr is a palindrome, otherwise return false
 */




/*
 * 
 * 1. fibonacci 
 * define function fib(n)
 * return the nth number in the fibonacci sequence.
 * 
 */



//var counter = 0;
//function count(){
//	counter = counter +1;
//	document.getElementById("count").innerHTML = counter;
//}





document.getElementById("count").addEventListener("mouseover", count);
document.getElementById("outer").addEventListener("click",function(){alert("IN OUTER DIV!")}, true);
document.getElementById("middle").addEventListener("click",function(){alert("IN MIDDLE DIV!")}, true);
document.getElementById("inner").addEventListener("click",function(){alert("IN INNER DIV!")}, true);

/*
 * 2. Bubble Sort
	Define function: bubbleSort(numArray)
	Use the bubble sort algorithm to sort the array.
	Return the sorted array.
	
	*/

	function bubbleSort(numArray){
		var x =numArray.length;
		for(var y =0; y< x-1; y++){
			for(var z = 0; z< x-y-1;z++){
				if(numArray[z] > numArray[z+1]){
					var temp = numArray[z];
					numArray[z] = numArray[z+1]
					numArray[z+1] = temp;
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
	
	
	// finish up reverse string function
	function reverseStr(someStr){
		var a = someStr.length;
		var newString = "";
		
		//for(var x =0; x<a)
	}

	/*
	4. Factorial
	Define function: factorial(someNum)
	Use recursion to compute and return the factorial of someNum.
	*/

	/*
	 *5. Substring
		Define function substring(someStr, length, offset)
		Return the substring contained between offset and (offset + length) inclusively.
		If incorrect input is entered, use the alert function and describe why the input was incorrect.
	 * 
	 */
/*
	 * 	6. Even Number
		Define function: isEven(someNum)
		Return true if even, false if odd.
		Do not use % operator.
	 */


	var getUser = function(){
		return isLoggedIn && username;
	}
	
	/*
	 * Default operator - || 
	 * if the first operand is truthy, 
	 * return the first operand. 
	 * otherwise, 
	 * return the second operand
	 */
	var getsCommission = 500;
	var getsRegSalary = 50;
	var getsPaid = function(){
		return getsCommission || getsRegSalary;
	}