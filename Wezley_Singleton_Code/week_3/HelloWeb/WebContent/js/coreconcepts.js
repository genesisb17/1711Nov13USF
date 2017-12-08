/**
 * JavaScript (JS) Core Concepts
 * 
 * JS is a scripting language for client-side operations
 * 		- JS != Java (JS is to Java as ham is the hamster)
 * 		- adds dynamic functionality to HTML web pages
 * 		- C-like syntax
 * 		- supports prototypal inheritance
 * 		- loosely typed (no need to specify data types)
 * 			- variable types:
 * 				- number		- string
 * 				- object		- boolean
 * 				- null			- NaN
 * 				- undefined
 * 		
 */

var a = 5;							//number
var b = "hello";					//string
var c = 'hello';					//string
var d = 7/0;						//number
var e = {name: "Wezley", age: 27};	//object literal
var f = e.age;						//string
var g = [0, 2, 4, 6, 8];			//object
var h = null;						//null
var i = false;						//boolean
var j;								//undefined

/**
 *  Type coersion
 *  	- == vs ===
 *  		- == checks to see if only the value of two variables are equivalent
 *  		- === checks to see if the value and the data type of two variables are equivalent
 *  
 *  Truthy vs Falsy
 *  	- because JS is loosely typed, each variable value is given an inherit boolean value
 *  	- AVOID DIRECTION COMPARISONS TO BOOLEAN VALUES!
 *  
 *  	- Always Truthy:
 *  		- '0' (a string containing any text)
 *  		- 'false' (a string containing the text 'false')
 *  		- [] (an empty array)
 *  		- {} (an empty object)
 *  		- function(){} (an empty function)
 *  
 *  	- Always Falsy:
 *  		- false			- null
 *  		- 0				- undefined
 *  		- '' or ""		- NaN
 */

/**  Operators
 *  	- Arithmetic: +  -  *  /  %
 *		- Bitwise: &  |  >>  >>>  >>
 *		- Comparison: >  <  >=  <=  ==  ===  !=  !==
 *		- Logical: &&  ||  !  !!
 *		
 *		- Guard: &&
 *			- if the first operand is truthy, return the second operand; otherwise, return the first
 *			- instead of returning true or false, it returns the value of the appropriate operand
 *
 *		- Default: ||
 *			- if the first operand is truthy, return the first operand; otherwise, return the second
 *		
 */

// Guard operator example 1 (returns "user")
var isLoggedIn = true;
var username = "user";
var getUser = function() {
	return isLoggedIn && username;
}
getUser();

// Guard operator example 2 (returns false)
isLoggedIn = false;
getUser();

// Guard operator example 3 (returns undefined)
isLoggedIn = undefined;
getUser();


// Default operator example 1 (returns 500)
var getsCommission = 500;
var getsRegSalary = 50;
var getsPaid = function() {
	return getsCommission || getsRegSalary;
}

getsPaid();
// Default operator example 2 (returns 50)
getsCommission = 0;
getsPaid();

// Default operator example 3 (returns 50)
getsCommission = undefined;
getsPaid();



 /**  Arrays
 *  	- inherits from object
 *  	- array indexes are converted into strings and used as names to retrieve values
 *  	- array literal: []
 *  	- do no specify length/type
 *  	- uses dot operator (.) to access array methods
 *  		- .pop(): removes and returns the last value in the array
 *  		- .shift(): removes and returns the first value in the array
 *  		- .push(#): adds the value to the end of the array and returns the new length of the array
 *  		- .unshift(#): adds the value to the beginning of the array and returns the new length of 
 *  					   the array
 *  		- .indexOf(#): returns the index position of the given value (first occurence)
 *  		- .splice(#, #): removes the values from the starting index (first paramater) to the number
 *  						 of index positions specified by the second parameter, and returns the
 *  						 spliced values as an array
 *  		- .length: returns the length of the array (last index position + 1)
 *  
 *  	- making an array:
 *  		- []		// initializes an empty array
 *  		- [,,,,,,]	// initializes an array with a length of 6
 *  		- Array[6]	// initializes an array with a length of 6
 *  
 *  Objects
 *  	- can contain data and methods
 *  	- can inherit from other objects
 *  	- object literal: {}
 *  	- objects can contain an unordered collection of name/value pairs
 *  
 *  	- adding properties to objects:
 *  		+ SYNTAX:
 *  			var obj = {name: "myName"};
 *  			obj.age = 30;
 *  			obj.isAwesome = true;
 *  	
 *  	- functions can be properties:
 *  		+ SYNTAX:
 *  			obj.talk = function() {console.log("Ohai!");
 *  
 *  Strings
 *  	- immutable
 *  	- interpolation (similar to printf() in Java
 *  		+ SYNTAX:
 *  			var h = "hello";
 *  			var interpol = `This is string interpolation! ${h}`
 *  			RESULT of interpol: "This is string interpolation! hello"
 *  
 *  		+ SYNTAX (with object properties):
 *  			var str = `${obj.name} is ${obj.age} and it is ${obj.isAwesome} that they are awesome`
 *  
 *   	
 */

/** Hoisting
*		Variable declarations using 'var' are treated as if they are at the top of the function
*		(or global scope, if declared outside of a function) regardless of where the actual
*		declaration is.
*
*		The declaration of 'value' is hoisted to the top while the initialization remains in the
*		same spot. That means that the variable 'value' is still accessible elsewhere in the
*		function; it just has a value of undefined.
*/

function getValue(condition) {
	if(condition) {
		var value = "blue";
		return value;
	}
	
	else {
		//value exists here with a value of undefined
		return null;
	}
}

// the above function is interpreted by the JSVM as:
function getValue(condition) {
	var value;
	if(condition) {
		value = "blue";
		return value;
	}
	
	else {
		//value exists here with a value of undefined
		return null;
	}
}

/** Understand 'let' keyword
*		- limits the variable to block scope
*/
function getValue(condition) {
	if(condition) {
		let value = "blue";
		return value;
	}
	
	else {
		// 'value' is not accessible here because we used the 'let' keyword
		return null;
	}
}